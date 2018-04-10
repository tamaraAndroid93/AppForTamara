package com.example.djordjeblagojevic.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    public  ArrayList<Contacts> list;

    public static final int RequestPermissionCode = 1;
    private Contacts contacts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EnableRuntimePermission();

        list = new ArrayList<>();


        incComponents();
        GetContactsIntoArrayList();



        Set<Contacts> tempContacts = new HashSet<>();
        tempContacts.addAll(list);

        list.clear();
        list.addAll(tempContacts);


        adapter = new ContactsAdapter(list,this);

        recyclerView.setAdapter(adapter);






    }

    private void incComponents(){

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }


    public ArrayList<Contacts> GetContactsIntoArrayList(){

        Cursor cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null, null, null);


        while (cursor.moveToNext()) {

            Contacts contacts = new Contacts();

            contacts.name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            contacts.photoUri = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.PHOTO_THUMBNAIL_URI));
            contacts.number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            list.add(contacts);



        }

        cursor.close();


        return  list;

    }


public void EnableRuntimePermission(){
    if (ActivityCompat.shouldShowRequestPermissionRationale(
            MainActivity.this,
            Manifest.permission.READ_CONTACTS))
    {

        Toast.makeText(MainActivity.this,"CONTACTS permission allows us to Access CONTACTS app", Toast.LENGTH_LONG).show();

    }else{

        ActivityCompat.requestPermissions(MainActivity.this,new String[]{
                Manifest.permission.READ_CONTACTS}, RequestPermissionCode);

    }

    }




    @Override
    public void onRequestPermissionsResult(int RC, String per[], int[] PResult) {

        switch (RC) {

            case RequestPermissionCode:

                if (PResult.length > 0 && PResult[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(MainActivity.this,"Permission Granted, Now your application can access CONTACTS.", Toast.LENGTH_LONG).show();

                } else {

                    Toast.makeText(MainActivity.this,"Permission Canceled, Now your application cannot access CONTACTS.", Toast.LENGTH_LONG).show();

                }
                break;
        }
    }


    public class Compare implements Comparator<Contacts>{


        @Override
        public int compare(Contacts o1, Contacts o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }





}
