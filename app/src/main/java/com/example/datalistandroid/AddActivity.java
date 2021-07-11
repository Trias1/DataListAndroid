package com.example.datalistandroid;


import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends Activity {

    SQLiteHelper dbHelper;
    Button btnAdd_save;
    EditText edAdd_Nama;
    EditText edAdd_Nim;
    EditText edAdd_asal;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_data);

        dbHelper = new SQLiteHelper(this);
        edAdd_Nama = (EditText) findViewById(R.id.edAdd_nama);
        edAdd_Nim = (EditText) findViewById(R.id.edAdd_nim);
        edAdd_asal = (EditText) findViewById(R.id.edAdd_asal);
        btnAdd_save = (Button) findViewById(R.id.btnA_save);
        btnAdd_save.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View arg0){
                // TODO Auto-generated method todo
                SQLiteDatabase db = dbHelper.getReadableDatabase();
                db.execSQL("insert into kota(nama, nim, asal) values ('"+edAdd_Nama.getText().toString()+"','"+edAdd_Nim.getText().toString()+"','"+edAdd_asal.getText().toString()+"')");
                Toast.makeText(getApplicationContext(),"Berhasil di tambah",Toast.LENGTH_LONG).show();
                MainActivity.ma.RefreshList();
                finish();
            }
        });
    }
}