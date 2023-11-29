package com.project.e_mart.dashactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.project.e_mart.Helper.ManagementCart;
import com.project.e_mart.R;
import com.project.e_mart.domain.PopularDomain;

public class DetailActivity extends AppCompatActivity {

    private Button addToCartBtn;
    private TextView titleTxt, feeTxt ,descriptionTxt, reviewTxt ,scoreTxt;

    private ImageView picItem , backBtn;

    private PopularDomain object;

    private int numberOrder = 1;

    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        managementCart = new ManagementCart(this);
        initView();
        getBundle();
    }

    private void getBundle(){
        object = (PopularDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId = this.getResources().getIdentifier(object.getPicUrl(),"drawable",this.getPackageName());

        Glide.with(this).load(drawableResourceId).into(picItem);

        titleTxt.setText(object.getTitle());
        feeTxt.setText("$"+object.getPrice());
        descriptionTxt.setText(object.getDescription());
        scoreTxt.setText(object.getScore()+"");
        reviewTxt.setText(object.getReview()+"");

       addToCartBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               object.setNumberInCart(numberOrder);
               managementCart.insertFood(object);
           }
       });

        backBtn.setOnClickListener(v -> finish());
    }
    private void initView()
    {
        addToCartBtn = findViewById(R.id.addToCartBtn);
        titleTxt = findViewById(R.id.titleTxt);
        feeTxt = findViewById(R.id.feeTxt);
        descriptionTxt = findViewById(R.id.descriptionTxt);
        reviewTxt = findViewById(R.id.reviewTxt);
        scoreTxt = findViewById(R.id.scoreTxt);
        picItem = findViewById(R.id.itemPic);
        backBtn = findViewById(R.id.backBtn);


    }
}
