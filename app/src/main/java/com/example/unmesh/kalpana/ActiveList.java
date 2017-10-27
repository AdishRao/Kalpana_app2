package com.example.unmesh.kalpana;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Adish on 28/10/17.
 */

public class ActiveList extends ArrayAdapter<userswithreq> {
    private Activity context;
    private List<userswithreq> userlist;

    public ActiveList(Activity context, List<userswithreq> userlist) {
        super(context, R.layout.list_layout, userlist);
        this.context = context;
        this.userlist = userlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewitem = inflater.inflate(R.layout.list_layout, null, true);
        TextView textViewName = listViewitem.findViewById(R.id.displayname);
        TextView textViewLocation = listViewitem.findViewById(R.id.displaylocation);

        userswithreq userswithreq = userlist.get(position);

        textViewName.setText(userswithreq.getUsername());
        textViewLocation.setText(userswithreq.getLocation());

        return listViewitem;

    }
}
