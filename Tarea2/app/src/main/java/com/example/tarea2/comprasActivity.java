package com.example.tarea2;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class comprasActivity extends AppCompatActivity {

    TextView txt;
    Button btnRegresar;
    Button btnFinalizar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compras);

        txt = findViewById(R.id.txtPedido);
        btnRegresar = findViewById(R.id.btnRegresar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        btnRegresar.setOnClickListener(view -> {
            finish();
        });

        btnFinalizar.setOnClickListener(v -> {
            Intent intent = new Intent(comprasActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        });

        txt = findViewById(R.id.txtPedido);

        String pedido = getIntent().getStringExtra("pedido");

        if (pedido == null) {
            txt.setText("Error: no se recibió pedido");
        } else {
            txt.setText(pedido);
        }
    }

}