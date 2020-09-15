package com.example.e_commerce_admin.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_commerce_admin.R;

public class All_Address_Adapter extends RecyclerView.Adapter<All_Address_Adapter.Order_Detail_Adapter_View> {

    @NonNull
    @Override
    public Order_Detail_Adapter_View onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.all_adress, parent, false);
        return new Order_Detail_Adapter_View(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Order_Detail_Adapter_View holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    class Order_Detail_Adapter_View extends RecyclerView.ViewHolder {
        public Order_Detail_Adapter_View(@NonNull View itemView) {
            super(itemView);
        }
    }
}
