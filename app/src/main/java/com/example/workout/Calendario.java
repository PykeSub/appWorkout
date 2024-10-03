package com.example.workout;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.FragmentTransaction;


public class Calendario extends Fragment {

    Button btn2;


    public Calendario() {
        // Required empty public constructor
        super(R.layout.fragment_calendario);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calendario, container, false);

        btn2 = view.findViewById(R.id.button19);
         btn2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Fragment segundoFragment = new RegistroEjercicio();

                 FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                 fm.replace(R.id.contenedor4, segundoFragment).commit();

             }
         });

        return view;
    }
}