package com.example.ms_shoppingmall;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,brand,price;
        LinearLayout item;

        MyViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.item_image);
            name = view.findViewById(R.id.item_title);
            brand = view.findViewById(R.id.item_brand);
            price = view.findViewById(R.id.item_price);
            item = view.findViewById(R.id.item_list);

        }
    }

    private ArrayList<Item> itemList;
    ItemAdapter(ArrayList<Item> items) {
        this.itemList = items;
    }

    @NonNull
    @Override
    public ItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;


        ArrayList<String> info = itemList.get(position).getInfo();
        ArrayList<Integer> detail_image = itemList.get(position).getDetail_image();
        myViewHolder.name.setText(itemList.get(position).getName());
        myViewHolder.brand.setText(itemList.get(position).getBrand());
        myViewHolder.price.setText(itemList.get(position).getPrice());
        myViewHolder.imageView.setImageResource(itemList.get(position).getImage());

        myViewHolder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent i = new Intent(context,ItemDetail.class);
                i.putExtra("name",itemList.get(position).getName());
                i.putExtra("brand",itemList.get(position).getBrand());
                i.putExtra("price",itemList.get(position).getPrice());
                i.putIntegerArrayListExtra("detail_image",detail_image);
                i.putStringArrayListExtra("info",info);
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


}
