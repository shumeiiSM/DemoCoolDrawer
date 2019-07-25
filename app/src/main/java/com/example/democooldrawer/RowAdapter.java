package com.example.democooldrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class RowAdapter extends ArrayAdapter<String> {

    private String[] myRow;
    private Context context;
    private TextView tvName;
    private ImageView ivImage;

    public RowAdapter(Context context, int resource, String[] objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        myRow = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvName = rowView.findViewById(R.id.tvName);
        // Get the ImageView object
        ivImage = rowView.findViewById(R.id.ivImage);
        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.

        String currentRow = myRow[position];

        tvName.setText(currentRow);

        if (position == 0) {
            ivImage.setImageResource(R.drawable.ic_info);
        } else if (position == 1) {
            ivImage.setImageResource(R.drawable.ic_vaccination);
        } else if (position == 2) {
            ivImage.setImageResource(R.drawable.ic_anniversary);
        } else {
            ivImage.setImageResource(R.drawable.ic_star);
        }

        return rowView;
    }
}