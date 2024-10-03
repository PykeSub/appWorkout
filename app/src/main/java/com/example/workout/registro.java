package com.example.workout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_registro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void completado(View v){
        EditText campo1 = this.findViewById(R.id.name);
        String nombre = campo1.getText().toString();
        EditText campo2 = this.findViewById(R.id.correo);
        String correo = campo2.getText().toString();
        EditText campo3 = this.findViewById(R.id.contrasenia);
        String contrasenia = campo3.getText().toString();
        EditText campo4 = this.findViewById(R.id.confirmacion);
        String confirmacion = campo4.getText().toString();
        Usuario u = new Usuario("", "", "", "");

        Intent i = new Intent(this, principal2.class);
        i.putExtra("usuario", u);
        startActivity(i);
    }
}