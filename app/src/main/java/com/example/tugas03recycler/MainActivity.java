package com.example.tugas03recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recyclerViewLayoutManager;
    ArrayList<ItemModel> data;

    private AdapterRecyclerView.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);


        recyclerViewLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        data = new ArrayList<>();
        for(int i = 0; i < MyItem.nama.length; i++){
            data.add(new ItemModel(
                MyItem.nama[i],
                MyItem.email[i],
                MyItem.iconlist[i]));

        }

        setOnClickListener();
        recyclerViewAdapter = new AdapterRecyclerView(this, data,listener);
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    private void setOnClickListener() {
        listener = new AdapterRecyclerView.RecyclerViewClickListener(){
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(),DefaultActivity.class);
                intent.putExtra("gambar",data.get(position).getImage());
                intent.putExtra("nama", data.get(position).getName());
                intent.putExtra("email", data.get(position).getEmail());
                startActivity(intent);
            }

        };
    }

}