package com.example.djordjeblagojevic.myapplication;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ContactActivity extends AppCompatActivity {

    private ImageView imageView;

    private TextView textViewNameDetail,textViewNumberDetail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_contact_details);

        incCompo();

        int position;

        position = getIntent().getIntExtra("position", 0);


        loadContact(position);





    }


    private void loadContact(int position) {



        Picasso.with(getApplicationContext())
                .load(MainActivity.list.get(position).photoUri)
                .into(imageView);

        if(MainActivity.list.get(position).photoUri==null){

           imageView.setImageResource(R.drawable.ic_launcher_background);
        }

        textViewNameDetail.setText(MainActivity.list.get(position).name);

        textViewNumberDetail.setText(MainActivity.list.get(position).number);

        textViewNameDetail.setContentDescription(MainActivity.list.get(position).name);

        textViewNumberDetail.setContentDescription(MainActivity.list.get(position).number);

    }




    private void incCompo(){

        imageView = (ImageView)findViewById(R.id.imageView);
        textViewNameDetail = (TextView)findViewById(R.id.textViewNameDetail);
        textViewNumberDetail = (TextView)findViewById(R.id.textViewNumberDetail);
    }

}

