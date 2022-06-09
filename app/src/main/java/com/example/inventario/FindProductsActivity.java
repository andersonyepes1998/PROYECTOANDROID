package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import com.example.inventario.databinding.ActivityFindProductsBinding;

public class FindProductsActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityFindProductsBinding findProductsBinding;
    private  DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findProductsBinding = ActivityFindProductsBinding.inflate(getLayoutInflater());
        View view = findProductsBinding.getRoot();
        setContentView(view);
        dbHelper = new DbHelper(this);
    }
    public void find(View view){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String producsToFind = findProductsBinding.etNombreConsultar.getText().toString();
        Cursor cursor = db.rawQuery("SELECT * FROM producs WHERE Codigo= "+producsToFind, null);
        cursor.moveToNext();
        String Name = cursor.getString(1);
        findProductsBinding.tvMostrarConsulta.setText(String.valueOf(Name));
        int Precio = cursor.getInt(2);
        findProductsBinding.tvMostrarPrecio.setText(String.valueOf(Precio));
    }

    public void previous(){
        Intent atras = new Intent(FindProductsActivity.this,ProductosActivity.class);
        startActivity(atras);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAtrasFind:
                previous();
                break;
        }
    }
}
