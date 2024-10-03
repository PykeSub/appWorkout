package com.example.workout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

public class Ejercicio1 extends AppCompatActivity {
    public Ejercicio1(){
        super(R.layout.activity_ejercicio1);
    }

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ejercicio1);

        //Referencia al boton
        btn = findViewById(R.id.button5);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btn.setVisibility(View.GONE);

                Fragment fragment = new RegistroEjercicio();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.Ejercicio1, fragment).commit();

            }
        });

        //Referencia al Toolbar
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Ejercicio1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /* Incorporamos el Menu Lateral */
        NavigationView nav = (NavigationView) findViewById(R.id.nav3);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //Recuperar la opcion del Menu
                int id = item.getItemId(); //Recuperar el ID de la opcion seleccionada
                if(id==R.id.Feed){
                    Toast.makeText(getApplicationContext(), "Vas a Feed", Toast.LENGTH_SHORT).show();

                    Feed f = new Feed();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor3, f).commit();
                } else if(id==R.id.Calendario) {
                    Toast.makeText(getApplicationContext(), "Vas a Calendario", Toast.LENGTH_SHORT).show();

                    Calendario c = new Calendario();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor3, c).commit();
                } else if(id==R.id.Cerrar_Sesion) {
                    Toast.makeText(getApplicationContext(), "Vas a Cerrar Sesion", Toast.LENGTH_SHORT).show();

                    CerrarSesion s = new CerrarSesion();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor3, s).commit();
                }

                return false;
            }
        });
        DrawerLayout dl = (DrawerLayout) findViewById(R.id.Ejercicio1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                dl,
                R.string.abrir_drawer,
                R.string.cerrar_drawer
        );
        dl.addDrawerListener(toggle);
        toggle.syncState();

        tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dl.isDrawerOpen(GravityCompat.START)){
                    dl.closeDrawer(GravityCompat.START);
                }else {
                    dl.openDrawer((int) Gravity.START);
                }
            }
        });
    }

    public void RegistroEjercicio(View v){
        Intent i = new Intent(this, RegistroEjercicio.class);
        startActivity(i);
    }
}