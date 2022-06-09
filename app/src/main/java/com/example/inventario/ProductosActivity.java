package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.inventario.databinding.ActivityProductosBinding;
import com.example.inventario.databinding.ActivityRegisterBinding;

public class ProductosActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityProductosBinding productosBinding;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        productosBinding = ActivityProductosBinding.inflate(getLayoutInflater());
        View view = productosBinding.getRoot();
        setContentView(view);

        dbHelper = new DbHelper(this);

        productosBinding.btnCreate.setOnClickListener(this);
    }

    public void registerProduct(View view) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues producsData = new ContentValues();
        producsData.put("Codigo", productosBinding.etCodigo.getText().toString());
        producsData.put("Name", productosBinding.etName.getText().toString());
        producsData.put("Precio", productosBinding.etPrecio.getText().toString());

        long newproducs = db.insert("producs", null, producsData);
        Toast.makeText(this, "" + newproducs, Toast.LENGTH_SHORT).show();
    }

    public void previous(){
        Intent atras = new Intent(ProductosActivity.this,MainActivity.class);
        startActivity(atras);
    }
    public void NextConsult() {
        Intent intent = new Intent(ProductosActivity.this, FindProductsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCreate:
                registerProduct(v);
                break;
            case R.id.btnPrevius:
                previous();
                break;
            case R.id.btnConsultar:
                NextConsult();
        }
    }
}