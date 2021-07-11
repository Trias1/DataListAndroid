package com.example.datalistandroid;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditData extends Activity {

    protected Cursor cursor;
    SQLiteHelper dbHelper;
    Button btnEdit_save;
    EditText edEdit_nama;
    EditText edEdit_nim;
    EditText edEdit_asal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);

        dbHelper = new SQLiteHelper(this);
        edEdit_nama = (EditText) findViewById(R.id.edEdit_nama);
        edEdit_nim = (EditText) findViewById(R.id.edEdit_nim);
        edEdit_asal = (EditText) findViewById(R.id.edEdit_asal);

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM kota where nama='"+getIntent().getStringExtra("nama")+"'",null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0){
            cursor.moveToPosition(0);
            edEdit_nama.setText(cursor.getString(1).toString());
            edEdit_nim.setText(cursor.getString(2).toString());
            edEdit_asal.setText(cursor.getString(3).toString());
        }
        btnEdit_save = (Button) findViewById(R.id.btnE_save);
        //TODO Auto-generated method sub
        btnEdit_save.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0){
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update kota SET nama='"+edEdit_nama.getText().toString()+"', " +"nim='"+edEdit_nim.getText().toString() +"', "+"asal='"+edEdit_asal.getText().toString()+"' WHERE "+"nama='"+getIntent().getStringExtra("nama")+"'");
                Toast.makeText(getApplicationContext(), "berhasil di update",Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
            });

    }
}