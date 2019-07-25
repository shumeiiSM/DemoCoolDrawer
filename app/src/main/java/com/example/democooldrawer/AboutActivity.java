package com.example.democooldrawer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class AboutActivity extends AppCompatActivity {

    TextView tv, tvAuthor;
    ImageView ivRP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        tv = findViewById(R.id.tvInfo);
        ivRP = findViewById(R.id.ivRP);

        String imageURL = "https://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg";
        Picasso.with(this)
                .load(imageURL)
                .placeholder(R.drawable.ajax_loader)
                .error(R.drawable.error)
                .into(ivRP);
    }
}