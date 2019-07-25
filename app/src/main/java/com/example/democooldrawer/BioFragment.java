package com.example.democooldrawer;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class BioFragment extends Fragment {

    Button btn;
    TextView tv;
    EditText etEdit;

    public BioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.biofragment, container, false);

        btn = view.findViewById(R.id.btnEdit);
        tv = view.findViewById(R.id.tv);

        // Step 2a : Obtain an instance of the SharedPreferences
        SharedPreferences pref = getContext().getSharedPreferences("pref", MODE_PRIVATE);

        // Step 2b : Retrieve the saved data from the SharedPreferences object
        String msg = pref.getString("myText","Nothing");

        // Step 2c : Update the UI element with the value
        tv.setText(msg);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view1 = inflater.inflate(R.layout.activity_dialog, null);
                etEdit = view1.findViewById(R.id.etEdit);
                etEdit.setText(tv.getText().toString());

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Edit Bio").setView(view1).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tv.setText(etEdit.getText().toString());

                        // Step 1b : Obtain an instance of the SharedPreferences
                        SharedPreferences pref = getContext().getSharedPreferences("pref", MODE_PRIVATE);

                        // Step 1c : Obtain an instance of the SharedPreferences Editor for update later
                        SharedPreferences.Editor prefEdit = pref.edit();

                        // Step1d : Add the key-value pair
                        // The value should be from the variable defined in Step 1a
                        prefEdit.putString("myText", etEdit.getText().toString());

                        // Step 1e : Call commit() method to save the changes into SharedPreferences
                        prefEdit.commit();
                    }

                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();

            }
        });


        return view;
    }


}