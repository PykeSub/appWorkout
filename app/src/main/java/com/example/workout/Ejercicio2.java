package com.example.workout;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;


public class Ejercicio2 extends Fragment {

    Button btn;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Ejercicio2() {
        // Required empty public constructor
        suoer(R.layout.fragment_ejercicio2);
    }

    private void suoer(int fragmentEjercicio2) {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Ejercicio2.
     */
    // TODO: Rename and change types and number of parameters
    public static Ejercicio2 newInstance(String param1, String param2) {
        Ejercicio2 fragment = new Ejercicio2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ejercicio2, container, false);

        //Referencia al boton
        btn = view.findViewById(R.id.button5);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btn.setVisibility(View.GONE);

                Fragment fragment = new RegistroEjercicio();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.Ejercicio2, fragment).commit();

            }
        });

        return view;

        //Referencia al Toolbar
        Toolbar tb = (Toolbar)view.findViewById(R.id.toolbar);
        setSupportActionBar(tb);

        ViewCompat.setOnApplyWindowInsetsListener(view.findViewById(R.id.Ejercicio2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /* Incorporamos el Menu Lateral */
        NavigationView nav = (NavigationView)view.findViewById(R.id.nav3);
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
        DrawerLayout dl = (DrawerLayout)view.findViewById(R.id.Ejercicio2);
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
    //public void RegistroEjercicio(View v){
        //Intent i = new Intent(this, RegistroEjercicio.class);
        //startActivity(i);
    //}
}