package com.digitalbrandoptimization;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class Tab_1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
         View rootView=inflater.inflate(R.layout.fragment_location,container,false);

        Spinner spinnerlocation=(Spinner)rootView.findViewById(R.id.spinnerLocationname);
        spinnerlocation.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
                Object item = parent.getItemAtPosition(pos);
                Globals g = Globals.getInstance();
                g.setvLocation(item.toString());

                Toast.makeText(getActivity(),item.toString(),Toast.LENGTH_SHORT).show();

            }

            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });


        return rootView;
    }


}
