package com.example.workout;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AgregarEjercicio#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AgregarEjercicio extends Fragment {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    private StorageReference mStorage;

    Button btn2;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AgregarEjercicio() {
        // Required empty public constructor
        super(R.layout.activity_ejercicio_basico);
    }

    //@Override
    //public void onViewCreated(@NonNull View view, Bundle saveInstanceState) {
        //int someInt = requireArguments().getInt("some_int");
    //}

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AgregarEjercicio.
     */
    // TODO: Rename and change types and number of parameters
    public static AgregarEjercicio newInstance(String param1, String param2) {
        AgregarEjercicio fragment = new AgregarEjercicio();
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

        mStorage = FirebaseStorage.getInstance().getReference();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            //ImageView imageView2 = (ImageView) findViewById(R.id.imageView2);
            //imageView2.setImageBitmap(Bitmap.createScaledBitmap(imageBitmap, 500, 500, false));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_agregar_ejercicio, container, false);

        //Referencia al boton del fragmento
        //btn2 = view.findViewById(R.id.button7);

        //btn2.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {
                //Fragment segundoFragment = new EjercicioBasico();
                //FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                //fm.replace(R.id.AgregarEjercicio, segundoFragment).commit();
            //}
        //});

        return view;
    }

    //public void creado(View v){
    //}

}