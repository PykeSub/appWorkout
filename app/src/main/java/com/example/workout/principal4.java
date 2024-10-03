package com.example.workout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
//import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class principal4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_principal4);

        //Referencia al Toolbar
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        //TabLayout tl = (TabLayout) findViewById(R.id.tablayout);
        //tl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            //@Override
            //public void onTabSelected(TabLayout.Tab tab) {
                //Codificar cosas a ejecutar cuando le das tap a un tab
                //int position = tab.getPosition();
                //switch (position) {
                    //case 0:
                        //Llamar al fragmento Niveles
                        //Niveles n = new Niveles();
                        //getSupportFragmentManager().beginTransaction().replace(R.id.contenedor1,n).commit();
                        //break;
                    //case 1:
                        //Llamar al fragmento Feed
                        //Feed f = new Feed();
                        //getSupportFragmentManager().beginTransaction().replace(R.id.contenedor1, f).commit();
                        //break;
                    //case 2:
                        //Llamar al fragmento Calendario
                        //Calendario c = new Calendario();
                        //getSupportFragmentManager().beginTransaction().replace(R.id.contenedor1, c).commit();
                        //break;
                    //case 3:
                        //Llamar al fragmento Cerrar Sesion
                        //CerrarSesion s = new CerrarSesion();
                        //getSupportFragmentManager().beginTransaction().replace(R.id.contenedor1, s).commit();
                        //break;
                //}
            //}

            //@Override
            //public void onTabUnselected(TabLayout.Tab tab) {
                //Codificar cosas a ejecutar cuando un tab deja de estar seleccionado

            //}

            //@Override
            //public void onTabReselected(TabLayout.Tab tab) {
                //Codificar cosas a ejecutar cuando un tab se vuelve a seleccionar

            //}
        //});

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /* Incorporamos el Menu Lateral */
        NavigationView nav = (NavigationView) findViewById(R.id.nav1);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //Recuperar la opcion del Menu
                int id = item.getItemId(); //Recuperar el ID de la opcion seleccionada
                if(id==R.id.Feed){
                    //Toast.makeText(getApplicationContext(), "Vas a Feed", Toast.LENGTH_SHORT).show();

                    Feed f = new Feed();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor1, f).commit();
                } else if(id==R.id.Calendario) {
                    //Toast.makeText(getApplicationContext(), "Vas a Calendario", Toast.LENGTH_SHORT).show();

                    Calendario c = new Calendario();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor1, c).commit();
                } else if(id==R.id.Cerrar_Sesion) {
                    //Toast.makeText(getApplicationContext(), "Vas a Cerrar Sesion", Toast.LENGTH_SHORT).show();

                    CerrarSesion s = new CerrarSesion();
                    getSupportFragmentManager().beginTransaction().replace(R.id.contenedor1, s).commit();
                }
                return false;
            }
        });
        DrawerLayout dl = (DrawerLayout) findViewById(R.id.main);
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

        //if (savedInstanceState == null) {
            //getSupportFragmentManager().beginTransaction().replace(R.id.contenedor4, new Calendario()).commit();

        //}

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


    //public interface OnNavigationItemSelectedListener{
        //public  boolean onNavigationItemSelectedListener(@NonNull MenuItem item);
    //}
    //NavigationView nav = (NavigationView) findViewById(R.id.nav1);
    //public interface OnNavigationItemSelectedListener{
        //public  boolean onNavigationItemSelectedListener(@NonNull MenuItem item);
    //}
    //nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
    //@Override
    //public boolean onNavigationItemSelected(@NonNull MenuItem) {
    //return false;
    //}
    //});


    //@Override
    //public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //int id = item.getItemId(); //Recuperar el ID de la opcion seleccionada
        //if(id==R.id.Niveles){
            //Toast.makeText(this, "Vas al Calendario", Toast.LENGTH_SHORT).show();
        //} else if(id==R.id.Feed){
            //Toast.makeText(this, "Vas al Feed", Toast.LENGTH_SHORT).show();
        //} else if(id==R.id.Calendario) {
            //Toast.makeText(this, "Vas a los Niveles", Toast.LENGTH_SHORT).show();
        //} else if(id==R.id.Cerrar_Sesion) {
            //Toast.makeText(this, "Vas a Cerrar Sesion", Toast.LENGTH_SHORT).show();
        //}

        //return super.onOptionsItemSelected(item);
    //}

    public void EjercicioBasico(View v){
        Intent i = new Intent(this, EjercicioBasico.class);
        startActivity(i);
    }
}