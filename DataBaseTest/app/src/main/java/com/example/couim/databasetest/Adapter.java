package com.example.couim.databasetest;

import android.content.ContentResolver;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by couim on 19/01/16.
 */
public class Adapter extends ArrayAdapter {
    private LayoutInflater mLayoutInflater;
    private ContentResolver contentResolver;

    static class ViewHolder {
        public TextView name;
        public TextView surname;
    }

    /**
     *
     * @param context
     * @param rep
     */
    public Adapter(Context context, List<Person> rep){
        super(context, R.layout.list_person, rep);
        this.mLayoutInflater = LayoutInflater.from(context);
        this.contentResolver = context.getContentResolver();
    }


    /**
     * position : position in the list of  conversations..
     * convertView : given by the system to recycle or recalculate rowView wich  has just appeared (by scrolling for example)
     *
     * permet la récupération de la vue personnalisée d'une ligne (rowView) qui
     * contiendra, grâce au XML, nos deux élements de textes que nous pourront
     * exploiter afin de pouvoir y personnaliser. La méthode getView est appelée
     * pour générer chaque lignes de l'écran.
     *
     * This method is a redefinition of getView in class ArrayAdapter witch is used for
     * calculate one element of our list of widget rowView created by us.
     * permit the recycling (or calculate) and return the personalized view of a line (rowView) witch
     * will be composed of, thanks to XML, tow entities of the TextView. (ref to R.layout.listofconvers.xml)
     *this method is called every time the program need to generate a rowview.
     *
     * If you want to improve the design of the listOfConvers activity (main activity) refer to
     * R.layout.listofconvers.xml and R.layout.opensecuritysms.xml
     */
    /**
     * get a view that displays the data at the specified position in the data set.
     * This function is called for each rows
     * a row contains information loaded thanks to the controller
     *
     * @param position the position of the item in the listview
     * @param convertView the old view to rescue
     * @param parent the parent that this view will eventually be attached to (mainActivity)
     * @return the view of a row. Created view by us
     */
    @Override
    public View getView (int position, View convertView, ViewGroup parent) {

        ViewHolder holder;  //use this class to keep element when one of them disappear (by scrolling for example)
        View rowView = convertView;

        //if the parameter convertView is null, we have to recalculate rowview thanks to the following lines.
        if(rowView == null) {
            //la méthode inflate permet de créer un objet view à partir d'un xml.
            //inflate method permit to create a View object since the xml
            rowView = this.mLayoutInflater.inflate(R.layout.list_person, null);

            /*initialization of holder, because convertView is null so holder couldn't know
            members assignment. We have to recreate it with the following lines*/
            holder = new ViewHolder();
            holder.name = (TextView) rowView.findViewById(R.id.namePerson);
            holder.surname = (TextView) rowView.findViewById(R.id.surNamePerson);
            rowView.setTag(holder);
        }
        //else, the parameter convertView exists so the element can be save with the convertView passed by the system
        else {
            holder = (ViewHolder) rowView.getTag();
        }

        //Color c = new Color();
        //rowView.setBackgroundColor(c.argb(50,250,250,190));

        Person person = (Person) getItem(position);
        holder.name.setText(person.getName());
        holder.surname.setText(person.getSurname());

        return rowView;
    }
}
