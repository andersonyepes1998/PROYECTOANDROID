package com.example.inventario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.inventario.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = mainBinding.getRoot();
        setContentView(view);

        mainBinding.btnSignin.setOnClickListener(this);
        mainBinding.btnSignUp.setOnClickListener(this);
    }

    public void showMessage() {
        Intent intent = new Intent(MainActivity.this, ProductosActivity.class);
        startActivity(intent);
    }

    public void goToRehister() {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignin:
                showMessage();
                break;
            case R.id.btnSignUp:
                goToRehister();
                break;
        }
    }
}