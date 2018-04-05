package com.example.djordjeblagojevic.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> implements View.OnClickListener {

     public static ArrayList<Contacts> contacts;

     private Context context;


    public ContactsAdapter(ArrayList <Contacts> contacts, Context context) {
        this.contacts = contacts;
        this.context = context;



    }

    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

         Contacts con = contacts.get(position);

         holder.textName.setText(con.getName());
         holder.textName.setContentDescription(con.getName());

         holder.textName.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 Intent intent = new Intent(context,ContactActivity.class);

                 intent.putExtra("position",position);

                  context.startActivity(intent);

             }
         });


    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    @Override
    public void onClick(View v) {

    }


    public class ViewHolder extends RecyclerView.ViewHolder  {

        public TextView textName,textSurname,textNumber;


        public ViewHolder(View itemView) {
            super(itemView);

            textName = (TextView) itemView.findViewById(R.id.textName);

        }


    }
}
