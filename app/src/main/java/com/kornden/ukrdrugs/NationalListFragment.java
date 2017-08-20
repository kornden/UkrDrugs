package com.kornden.ukrdrugs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class NationalListFragment extends Fragment {


    public NationalListFragment() {
        super();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView =  inflater.inflate(R.layout.drug_search, container,false);
        EditText searchText = (EditText) rootView.findViewById(R.id.search_text);
        return rootView;
    }

}
