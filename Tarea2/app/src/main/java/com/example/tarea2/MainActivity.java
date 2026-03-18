package com.example.tarea2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    boolean pizza = false, hamburguesa = false, tacos = false;
    boolean refresco = false, papas = false, flan = false;

    ImageButton btnPizza, btnHamburguesa, btnTacos;
    ImageButton btnRefresco, btnPapas, btnFlan;
    Button btnPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedidos);

        btnPizza = findViewById(R.id.btnPizza);
        btnHamburguesa = findViewById(R.id.btnHamburguesa);
        btnTacos = findViewById(R.id.btnTacos);
        btnRefresco = findViewById(R.id.btnRefresco);
        btnPapas = findViewById(R.id.btnPapas);
        btnFlan = findViewById(R.id.btnFlan);
        btnPedido = findViewById(R.id.btnPedido);

        btnPizza.setOnClickListener(v -> {
            pizza = !pizza;
            btnPizza.setBackgroundResource(pizza ? R.drawable.boton_seleccionado : R.drawable.borde_boton);
        });

        btnHamburguesa.setOnClickListener(v -> {
            hamburguesa = !hamburguesa;
            btnHamburguesa.setBackgroundResource(hamburguesa ? R.drawable.boton_seleccionado : R.drawable.borde_boton);
        });

        btnTacos.setOnClickListener(v -> {
            tacos = !tacos;
            btnTacos.setBackgroundResource(tacos ? R.drawable.boton_seleccionado : R.drawable.borde_boton);
        });

        btnRefresco.setOnClickListener(v -> {
            refresco = !refresco;
            btnRefresco.setBackgroundResource(refresco ? R.drawable.boton_seleccionado : R.drawable.borde_boton);
        });

        btnPapas.setOnClickListener(v -> {
            papas = !papas;
            btnPapas.setBackgroundResource(papas ? R.drawable.boton_seleccionado : R.drawable.borde_boton);
        });

        btnFlan.setOnClickListener(v -> {
            flan = !flan;
            btnFlan.setBackgroundResource(flan ? R.drawable.boton_seleccionado : R.drawable.borde_boton);
        });

        btnPedido.setOnClickListener((v -> {

            String pedido = "";
            int total = 0;

            if (pizza) { pedido += "\n Pizza "; total += 100; }
            if (hamburguesa) { pedido += "\n Hamburguesa "; total += 80; }
            if (tacos) { pedido += "\n Tacos "; total += 60; }
            if (refresco) { pedido += "\n Refresco "; total += 25; }
            if (papas) { pedido += "\n Papas fritas "; total += 50; }
            if (flan) { pedido += "\n Flan "; total += 40; }

            if (pedido.isEmpty()) {
                pedido = "No seleccionaste nada";
            } else {
                pedido = "Elegiste: " + pedido + "\nTotal: $" + total;
            }

            Intent intent = new Intent(MainActivity.this, comprasActivity.class);
            intent.putExtra("pedido", pedido);
            startActivity(intent);
        }));
    }
}