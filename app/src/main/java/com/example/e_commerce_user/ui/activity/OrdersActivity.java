package com.example.e_commerce_user.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.e_commerce_user.R;
import com.example.e_commerce_user.model.Order;
import com.example.e_commerce_user.ui.adapter.Order_Adapter;
import com.example.e_commerce_user.utils.FirebaseConstants;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class OrdersActivity extends AppCompatActivity {

    private RecyclerView order_recycler;
    private Order_Adapter adapter;
    private ProgressBar progress;
    private ImageView iv_back;
    private TextView tv_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);

       init();

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        order_recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));



            Query query = FirebaseDatabase.getInstance().getReference()
                    .child(FirebaseConstants.Order.key)
                    .orderByChild(FirebaseConstants.Order.user_id)
                    .equalTo(FirebaseAuth.getInstance().getUid());

            FirebaseRecyclerOptions<Order> options=
                    new FirebaseRecyclerOptions.Builder<Order>()
                            .setQuery(query, Order.class)
                            .build();

            adapter=new Order_Adapter(options, this, progress, new Order_Adapter.ClickCallBack() {
                @Override
                public void click(int count) {
                    if(count==0)
                        tv_data.setVisibility(View.VISIBLE);
                }
            });
            order_recycler.setAdapter(adapter);


    }

    private void init() {
        order_recycler=findViewById(R.id.order_recycler);
        iv_back=findViewById(R.id.iv_back);
        tv_data=findViewById(R.id.tv_data);
        progress=findViewById(R.id.progress);
    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}