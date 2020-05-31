package com.example.eco_impulse.fragments;

import android.app.Activity;
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
import com.example.eco_impulse.adapters.PostAdapter;
import com.example.eco_impulse.modelos.Post;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class PostListFragment extends Fragment {

    RecyclerView rvPostList;
    PostAdapter adapter;
    FloatingActionButton fabNewPost;
    ArrayList<Post> items;
    FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post_list,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvPostList = (RecyclerView) view.findViewById(R.id.rvPostList);
        fabNewPost = (FloatingActionButton) view.findViewById(R.id.fabNewPost);
        items = new ArrayList<Post>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvPostList.setLayoutManager(linearLayoutManager);

        getList();

        fabNewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Se dispara el fragmento "Ver Post"

            }
        });
    }

    private void getList() {
        items.add(new Post("Planta tu propio árbol", R.drawable.reforestation));
        items.add(new Post("Ayuda a construir un mejor lugar para todos", R.drawable.cleaning_park));
        items.add(new Post("Ayuda a quien más te necesita", R.drawable.helping_homeless));
        showAllPosts();
        CollectionReference postList = firestore.collection("post");
        postList.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    for (DocumentSnapshot document : task.getResult()){
                        if(document.exists()){
                            String tittle, imageUrl, postId, description, date, category, authorId;
                            tittle = String.valueOf(document.get("titulo"));
                            imageUrl = String.valueOf(document.get("imagen"));
                            postId = String.valueOf(document.get("post_id"));
                            description = String.valueOf(document.get("descripción"));
                            date = String.valueOf(document.get("fecha"));
                            category = String.valueOf(document.get("tema"));
                            authorId = String.valueOf(document.get("usuario_id"));
                            items.add(new Post(tittle, imageUrl, postId, description, date, category, authorId));
                            showAllPosts();
                        }
                    }
                }
            }
        });
    }

    private void showAllPosts() {
        adapter = new PostAdapter(items);
        rvPostList.setAdapter(adapter);
    }


}
