package com.example.messaoud.controleremplacement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> contacts ;
    ListView list;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        contacts = new ArrayList<User>();


        contacts.add(new User("Ordi1","", R.drawable.accessoire ));
        contacts.add(new User("ORDINATEUR2","", R.drawable.accessoire ));
        contacts.add(new User("ordi4","", R.drawable.accessoire ));


        //CustomAdapter est une classe qu'on a créé nous meme à partir de la classe ArrayAdapter<User>

        adapter = new CustomAdapter(getApplicationContext(),contacts);


        //il sagit de la liste qu'on veut remplir (c'est une vue)
        list = (ListView) findViewById(R.id.articleCat);


        list.setAdapter(adapter);






    }
}
