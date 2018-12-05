package com.example.messaoud.simulationwhatsapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity3 extends AppCompatActivity {

    ArrayList<User> contacts ;
    ListView list;
    CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        contacts = new ArrayList<User>();





        //CustomAdapter est une classe qu'on a créé nous meme à partir de la classe ArrayAdapter<User>

        adapter = new CustomAdapter(getApplicationContext(),contacts);


        //il sagit de la liste qu'on veut remplir (c'est une vue)
        list = (ListView) findViewById(R.id.articleCat);


        list.setAdapter(adapter);


        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("Categorie");
            //The key argument here must match that used in the other activity



            TextView titre = findViewById(R.id.cat);

            if(value.equals("accessoire")){

                contacts.add(new User("Accesoire1","", R.drawable.accessoire ));
                contacts.add(new User("Accesoire2","", R.drawable.accessoire ));
                contacts.add(new User("Accesoire3","", R.drawable.accessoire ));

            }
            if(value.equals("magazine")){

                contacts.add(new User("Magazin1","", R.drawable.accessoire ));
                contacts.add(new User("Magazin2","", R.drawable.accessoire ));
                contacts.add(new User("Magazin3","", R.drawable.accessoire ));

            }
            if(value.equals("ordinateur")){

                contacts.add(new User("Ordi1","", R.drawable.accessoire ));
                contacts.add(new User("ORDINATEUR2","", R.drawable.accessoire ));
                contacts.add(new User("ordi4","", R.drawable.accessoire ));

            }
            if(value.equals("portable")){

                contacts.add(new User("Ordi1","", R.drawable.accessoire ));
                contacts.add(new User("ORDINATEUR2","", R.drawable.accessoire ));
                contacts.add(new User("ordi4","", R.drawable.accessoire ));

            }




            titre.setText(value);


        }




        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {



            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                MainActivity.panier.add(contacts.get(position));


                //Intent intent= new Intent(getApplicationContext(),Activity2.class);
                //intent.putExtra("Panier", panier);

                //startActivity(intent);

                finish();
                //on va changer le text de nom
                //((EditText) findViewById (R.id.editTextName)).setText(contacts.get(position).getName());


            }

        });

        Button panierBouton = (Button) this.findViewById(R.id.button);


        panierBouton.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {


                Intent intent= new Intent(getApplicationContext(),Activity4.class);
                startActivity(intent);

            }
        });






    }
}
