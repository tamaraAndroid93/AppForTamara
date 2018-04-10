package com.example.djordjeblagojevic.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
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

        Contacts contacts;


        contacts = (Contacts)getIntent().getSerializableExtra("position");


        loadContacts(contacts);






    }


    private void loadContacts (Contacts contacts){

        Picasso.with(getApplicationContext()).load(contacts.photoUri).into(imageView);

        if(contacts.photoUri==null){

            imageView.setImageResource(R.drawable.ic_launcher_background);
        }

        textViewNameDetail.setText(contacts.name);

        textViewNumberDetail.setText(contacts.number);

        textViewNameDetail.setContentDescription(contacts.name);

        textViewNumberDetail.setContentDescription(contacts.number);
    }








    private void incCompo(){

        imageView = (ImageView)findViewById(R.id.imageView);
        textViewNameDetail = (TextView)findViewById(R.id.textViewNameDetail);
        textViewNumberDetail = (TextView)findViewById(R.id.textViewNumberDetail);
    }

}

