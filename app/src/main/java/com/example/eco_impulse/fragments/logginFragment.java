package com.example.eco_impulse.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.eco_impulse.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

public class logginFragment extends Fragment {
    EditText nombre;
    EditText password;
    Button entrar;
    Button registrar;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nombre = view.findViewById(R.id.nombre);
        password = view.findViewById(R.id.password);
        entrar =(Button) view.findViewById(R.id.boton_entrar);
        registrar = view.findViewById(R.id.boton_registrar);
        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    public void autenticar{
        String nombreUsuario = "";
        String contraseña = "";
        nombreUsuario = String.valueOf(nombre.getText());
        contraseña = String.valueOf(password.getText());
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        CollectionReference usuarios = firebaseFirestore.collection("users");
        usuarios.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {

            }
        })

    }
}
