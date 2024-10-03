package com.example.workout;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistroEjercicio#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistroEjercicio extends Fragment {

    Button btn9;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegistroEjercicio() {
        // Required empty public constructor
        super(R.layout.fragment_registro_ejercicio);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistroEjercicio.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistroEjercicio newInstance(String param1, String param2) {
        RegistroEjercicio fragment = new RegistroEjercicio();
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

    //public void ejercicio(View v){
        //EditText campo1 = this.findViewById(R.id.Ejecicio);
        //String ejercicio = campo1.getText().toString();
        //EditText campo2 = this.findViewById(R.id.Cantidad);
        //String cantidad = campo2.getText().toString();

        //Intent i = new Intent(this, Ejercicio1.class);

        //startActivity(i);
    //}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registro_ejercicio, container, false);

        //Referencia al boton del Fragmento



        return view;
    }

    //public void ejercicioRegistrado(View v){
        //Intent i = new Intent(this, Ejercicio1.class);
    //}

}