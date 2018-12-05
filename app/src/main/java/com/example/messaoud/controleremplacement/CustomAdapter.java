package com.example.messaoud.controleremplacement;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

// un ArrayAdapter est générique : il prend une classe en parametre
public class CustomAdapter extends ArrayAdapter<User> {


    ArrayList<User> contacts;
    Context context;

    public CustomAdapter(Context context, ArrayList<User> contacts){
        super(context,0,contacts);
        this.contacts = contacts;
        this.context = context;
    }

    static class ViewHolder{
        ImageView mImage;
        TextView mName;
        TextView mStatus;
    }



    //l'objectif de getView est de creer la vue correspondante à l'objet de position 'pos' de notre tableau
    //convertView est la vue qui appartient à notre ListView et qui se trouve dans la position 'pos'
    //evidement elle peut etre null (si on n'y est jamais arrivé) ou correspondre à une vue existante
    //ce qui va etre interessant c'est de remplir la vue lorsqu'elle sera null
    @NonNull
    @Override
    public View getView(int pos, View convertView, ViewGroup parent){

        //cette ligne ne sert que pour simplifier le nom du convertView
        View v = convertView ;

        //c'est un objet dans lequel on va stocker les informations de notre vue
        ViewHolder vHolder;
        if (v==null){

            //
            v = LayoutInflater.from(context).inflate(R.layout.line,parent,false);

            vHolder = new ViewHolder();

            vHolder.mName = (TextView) v.findViewById(R.id.name);
            vHolder.mStatus = (TextView) v.findViewById(R.id.status);
            vHolder.mImage = (ImageView) v.findViewById(R.id.avatar);

            //on enregistre le vHolder comme attribut de la vue qu'on vient de construire
            v.setTag(vHolder);

        }

        else { vHolder = (ViewHolder) v.getTag(); }

        // him c'est l'objet User qui se trouve dans la position pos
        User him = contacts.get(pos);

        //on récupére la reference de l'image en question
        ImageView img = vHolder.mImage;

        //img.setImageBitmap(him.getAvatar());
        img.setImageResource(him.getAvatar());

        //ImageView img = (ImageView) v.findViewById(R.id.avatar);
        //img = him.getAvatar();
        TextView name = vHolder.mName;
        //TextView name = (TextView) v.findViewById(R.id.name);
        name.setText(him.getName());
        TextView status = vHolder.mStatus;
        //TextView status = (TextView) v.findViewById(R.id.status);
        status.setText(him.getStatus());

        return v;
    }
}
