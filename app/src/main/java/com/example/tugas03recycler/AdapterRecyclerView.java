package com.example.tugas03recycler;

import android.content.Context;
import android.content.Intent;
import android.graphics.text.TextRunShaper;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ViewHolder> {

    private ArrayList<ItemModel> dataItem;
    private Context context;

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNama;
        TextView txtEmail;
        ImageView imageIcon;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNama = itemView.findViewById(R.id.text_nama);
            txtEmail = itemView.findViewById(R.id.text_email);
            imageIcon = itemView.findViewById(R.id.imageList);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }

    AdapterRecyclerView(Context context, ArrayList<ItemModel> dataItem){
        this.context = context;
        this.dataItem = dataItem;
    }

    @NonNull
    @Override
    public AdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView txtNama = holder.txtNama;
        TextView txtEmail = holder.txtEmail;
        ImageView imageIcon = holder.imageIcon;



        txtNama.setText(dataItem.get(position).getName());
        txtEmail.setText(dataItem.get(position).getEmail());
        imageIcon.setImageResource(dataItem.get(position).getImage());

        holder.parentLayout.setOnClickListener(v -> {

            Toast.makeText(context,"Anda Memilih " + dataItem.get(position).getName(), Toast.LENGTH_SHORT).show();
            
            
            if(dataItem.get(position).getName().equals("MUHAMMAD DZAKY APRIMA")){
                Intent intent = new Intent(context, DefaultActivity.class);
                intent.putExtra("GAMBAR_DEFAULT", R.drawable.a);
                intent.putExtra("TEKS_DEFAULT", "email activity");
                context.startActivity(intent);
            }


        });



    }

    @Override
    public int getItemCount() {
        return dataItem.size();
    }
}
