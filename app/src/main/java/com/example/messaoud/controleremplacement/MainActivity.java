package com.example.messaoud.controleremplacement;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<User> contacts ;
    ListView list;
    CustomAdapter adapter;

    static int selectedElement;

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

        final EditText entree = (EditText) this.findViewById(R.id.editText);

        MainActivity.input = entree.getText().toString();

        ajouterBoutton.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {


                contacts.add(new User(entree.getText().toString(),"", R.drawable.accessoire ));
                list.setAdapter(adapter);




            }
        });

        Button supprimerBoutton = (Button) this.findViewById(R.id.buttonSupprimer);


        supprimerBoutton.setOnClickListener(new View.OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {


                if(entree.getText().toString().equals("")){
                    contacts.remove(contacts.remove(MainActivity.selectedElement));
                    list.setAdapter(adapter);
                }
                else{

                    for(int i = 0; i<contacts.size() ;i++){

                        if (contacts.get(i).getName().equals(entree.getText().toString())) {
                            contacts.remove(contacts.remove(i));
                            list.setAdapter(adapter);

                        }

                    }
                }



            }
        });


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {



            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                MainActivity.selectedElement = position;


                //Intent intent= new Intent(getApplicationContext(),Activity2.class);
                //intent.putExtra("Panier", panier);

                //startActivity(intent);

                //finish();
                //on va changer le text de nom
                //((EditText) findViewById (R.id.editTextName)).setText(contacts.get(position).getName());


            }

        });



    }


}
