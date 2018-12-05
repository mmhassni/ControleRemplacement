package com.example.messaoud.controleremplacement;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> contacts ;
    ListView list;
    CustomAdapter adapter;

    static String input = "";

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
        list = (ListView) findViewById(R.id.listViewP);


        list.setAdapter(adapter);


        Button ajouterBoutton = (Button) this.findViewById(R.id.buttonAjouter);

        TextView entree = (TextView) this.findViewById(R.id.textView);

        MainActivity.input = entree.getText().toString();

        ajouterBoutton.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {



                contacts.add(new User(MainActivity.input,"", R.drawable.accessoire ));



            }
        });

        Button supprimerBoutton = (Button) this.findViewById(R.id.buttonSupprimer);


        supprimerBoutton.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {



                contacts.add(new User(MainActivity.input,"", R.drawable.accessoire ));



            }
        });



    }


}
