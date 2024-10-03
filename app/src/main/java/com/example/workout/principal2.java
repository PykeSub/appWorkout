package com.example.workout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class principal2 extends AppCompatActivity {
    Usuario u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal2);
        //Recuperar TODO
        Bundle paquete = getIntent().getExtras();
        if(paquete!=null){
            u = (Usuario) paquete.getSerializable("usuario");
            System.out.println(u);
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void inicio(View v){
        EditText campo1 = this.findViewById(R.id.correo);
        String correo = campo1.getText().toString();
        EditText campo2 = this.findViewById(R.id.contrasenia);
        String contrasenia = campo2.getText().toString();

        if(correo.equals("gaston@gmail.com")&& contrasenia.equals("12345")){
            Intent i = new Intent(this, principal4.class);
            startActivity(i);
        }else{
            Toast.makeText(this, "Error, uno de los campos esta incorrecto", Toast.LENGTH_SHORT).show();
        }
    }

    public void registro(View v){
        Intent i = new Intent(this, registro.class);
        startActivity(i);
    }

}