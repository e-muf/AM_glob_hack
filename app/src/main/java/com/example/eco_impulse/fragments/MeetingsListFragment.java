package com.example.eco_impulse.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eco_impulse.R;
import com.example.eco_impulse.adapters.MeetingAdapter;
import com.example.eco_impulse.modelos.Meeting;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class MeetingsListFragment extends Fragment {

    RecyclerView rvMeetingsList;
    FloatingActionButton fabNewMeeting;
    MeetingAdapter adapter;
    ArrayList<Meeting> items;
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_meeting_list,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvMeetingsList = (RecyclerView) view.findViewById(R.id.rvMeetingtList);
        fabNewMeeting = (FloatingActionButton) view.findViewById(R.id.fabNewMeeting);
        items = new ArrayList<Meeting>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMeetingsList.setLayoutManager(linearLayoutManager);

        getList();

        fabNewMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Se dispara el fragmento "Ver Reunión"
            }
        });
    }

    private void getList() {
        items.add(new Meeting("Comiendo Juntos", R.drawable.feeding, "Jun 12 15:00", "Calle Totola #5, Copilco el Alto"));
        items.add(new Meeting("Enséñanos un Poco", R.drawable.teaching, "Jun 05 07:00", "Facultad de Ingeniería, C.U."));
        items.add(new Meeting("Concierto de Caridad", R.drawable.charity_concert, "Jun 11 20:00", "Jardín Hidalgo, Coyoacán"));
        showAllMeetings();
        CollectionReference meetings = firestore.collection("reunion");
        meetings.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for(DocumentSnapshot document : task.getResult()){
                        if(document.exists()){
                            String tittle, description, imageUrl, hostId, date,  location, materials;
                            tittle = String.valueOf(document.get("titulo"));
                            description = String.valueOf(document.get("descripcion"));
                            imageUrl = String.valueOf(document.get("imagen"));
                            hostId = String.valueOf(document.get("usuario_id"));
                            date = String.valueOf(document.get("fecha"));
                            location = String.valueOf(document.get("ubicacion"));
                            materials = String.valueOf(document.get("materiales"));
                            items.add(new Meeting(tittle, description, imageUrl, hostId, date, location, materials));
                            showAllMeetings();
                        }
                    }
                }
            }
        });
    }

    private void showAllMeetings() {
        adapter = new MeetingAdapter(items);
        rvMeetingsList.setAdapter(adapter);
    }
}
