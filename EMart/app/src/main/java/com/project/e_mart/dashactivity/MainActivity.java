package com.project.e_mart.dashactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.project.e_mart.Adapter.PopularAdapter;
import com.project.e_mart.R;
import com.project.e_mart.domain.PopularDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterPopular;
    private RecyclerView recyclerViewPopular;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initRecyclerView();
        bottomNavigation();
    }

    private void bottomNavigation()
    {
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        LinearLayout cartBtn = findViewById(R.id.cartBtn);

        homeBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,MainActivity.class)));

        cartBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity.this,CartActivity.class)));
    }
    private void initRecyclerView(){
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("T-shirt Black","A black shirt embodies timeless sophistication and versatility.\n" +
                " Its classic hue exudes elegance, offering a sleek and polished look\n " +
                "suitable for various occasions. Whether paired with formal attire for a\n" +
                " professional setting or dressed down for a casual chic style, the black \n" +
                "shirt effortlessly adds an air of refinement.","item_1",15,5));
        items.add(new PopularDomain("Smart Watch","A smartwatch is the ultimate fusion of convenience and technology,\n" +
                " a wearable marvel that transcends timekeeping. Seamlessly integrating into your lifestyle, \n" +
                "it offers a myriad of functionalities beyond telling time, from fitness tracking to notifications\n" +
                "and even acting as a mini-computer on your wrist.","item_2",42,20));
        items.add(new PopularDomain("i-Phone 14 Pro","The iPhone 14 Pro epitomizes innovation and sophistication in the world of smartphones.\n" +
                " Its cutting-edge technology, paired with an elegant design,\n" +
                " redefines the boundaries of mobile devices. Boasting a stunning\n" +
                " Super Retina XDR display and an advanced camera system that captures\n" +
                " life’s moments in breathtaking detail, it raises the bar for photography and videography. ","item_3",20,10));
        items.add(new PopularDomain("VisionX Pro LED TV","The NEXAR 42-inch LED Full HD (FHD) TV is a sleek entertainment powerhouse\n" +
                " designed to elevate your viewing experience. With its impressive 1080p\n" +
                " resolution, vibrant colors, and sharp image quality, it brings your\n" +
                " favorite movies, shows, and games to life. Its expansive 42-inch display\n" +
                " coupled with advanced LED technology offers immersive visuals, while its\n" +
                " sleek design complements any living space seamlessly. ","item_4",12,4));

        recyclerViewPopular = findViewById(R.id.view1);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterPopular = new PopularAdapter(items);
        recyclerViewPopular.setAdapter(adapterPopular);
    }
}
