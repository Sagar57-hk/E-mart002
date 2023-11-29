package com.project.e_mart.dashactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.project.e_mart.Adapter.CartAdapter;
import com.project.e_mart.Helper.ChangeNumberitemsListener;
import com.project.e_mart.Helper.ManagementCart;
import com.project.e_mart.R;

public class CartActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private ManagementCart managementCart;

    private TextView emptyTxt,totalTxt,subtotalTxt,taxTxt,deliveryTxt;
    private double tax;
    private ScrollView scrollView;
    private ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        managementCart = new ManagementCart(this);

        initView();
        setVariable();
        calculatorCart();
        initList();
    }

    private void initList()
    {
        if(managementCart.getListCart().isEmpty())
        {
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }
        else{
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new CartAdapter(managementCart.getListCart(), this, () -> calculatorCart());
        recyclerView.setAdapter(adapter);
    }
    private void calculatorCart()
    {
    double percentTax =0.04;
    double delivery=10;
    tax = Math.round(managementCart.getTotalFee()*percentTax*100.0)/100.0;

    double total = Math.round((managementCart.getTotalFee()+tax+delivery)*100)/100;
    double itemTotal = Math.round(managementCart.getTotalFee()*100)/100;

    subtotalTxt.setText("$"+itemTotal);
    deliveryTxt.setText("$"+delivery);
    taxTxt.setText("$"+tax);
    totalTxt.setText("$"+total);
    }
    private void setVariable()
    {
    backBtn.setOnClickListener(v -> finish());
    }
    private void initView()
    {
        subtotalTxt = findViewById(R.id.subtotalTxt);
        totalTxt = findViewById(R.id.totalTxt);
        taxTxt = findViewById(R.id.taxTxt);
        deliveryTxt = findViewById(R.id.deliveryTxt);
        recyclerView = findViewById(R.id.view2);
        scrollView = findViewById(R.id.scrollView2);
        backBtn = findViewById(R.id.backBtn);
        emptyTxt= findViewById(R.id.emptyTxt);
    }

    public void setManagementCart(ManagementCart managementCart) {
        this.managementCart = managementCart;
    }
}