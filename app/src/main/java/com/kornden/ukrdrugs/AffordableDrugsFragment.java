package com.kornden.ukrdrugs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by kornd on 20-Aug-17.
 */

public class AffordableDrugsFragment extends Fragment {
    public AffordableDrugsFragment() {
        super();
    }

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       final View rootView =  inflater.inflate(R.layout.drug_search, container,false);
        EditText searchText = (EditText) rootView.findViewById(R.id.search_text);
        final ArrayList<Drug> drugs = new ArrayList<>();
        drugs.add(new Drug("Аміодарон", "Amiodarone", "200mg"));
        drugs.add(new Drug("Амлодипін", "Amlodipine", "5mg, 10mg"));
        drugs.add(new Drug("Атенолол", "Atenolol", "50mg, 100mg"));
        drugs.add(new Drug("Верапаміл", "Verapamil", "40mg, 80mg"));
        drugs.add(new Drug("Гідрохлортіазид", "Hydrochlorothiazide", "25mg"));
        drugs.add(new Drug("Спіронолактон", "Spironolactone", "25mg, 50mg, 100mg"));
        drugs.add(new Drug("Фуросемід", "Furosemide", "40mg"));
        drugs.add(new Drug("Дигоксин", "Digoxin", "0.25mg"));
        drugs.add(new Drug("Еналаприл", "Enalapril", "5mg, 10mg, 20mg"));
        drugs.add(new Drug("Ізосорбіду динітрат", "Isosorbide dinitrate", "5mg"));
        drugs.add(new Drug("Карведілол", "Carvedilol", "6.25mg, 12.5mg, 25mg"));
        drugs.add(new Drug("Клопідогрель", "Clopidogrel", "75mg"));
        drugs.add(new Drug("Метопролол", "Metoprolol", "25mg, 50mg, 100mg"));
        drugs.add(new Drug("Нітрогліцерин", "Glyceryl trinitrate", "0.5mg"));
        drugs.add(new Drug("Симвастатин", "Simvastatin", "10mg, 20mg, 40mg"));
        drugs.add(new Drug("Бісопролол", "Bisoprolol", "2.5mg, 5mg, 10mg"));
        drugs.add(new Drug("Метформін", "Metformin", "500mg, 850mg, 1000mg"));
        drugs.add(new Drug("Гліклазид", "Gliclazide", "30mg, 60mg, 80mg"));
        drugs.add(new Drug("Беклометазон", "Beclometasone", "100mkg/d, 250mkg/d"));
        drugs.add(new Drug("Будесонід", "Budesonide", "100mkg, 200mkg, 0.5mg/ml 2.0ml"));
        drugs.add(new Drug("Сальбутамол", "Salbutamol", "100mkg/d"));


        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ArrayList<Drug> displayDrugs = new ArrayList<Drug>(drugs);
                if (charSequence != "") {
                    displayDrugs.clear();
                    for (Drug drug : drugs) {
                        //compare input of EditText view to begining of Drug's name and if it`s true -
                        // add this Drug object to displayDrugs List
                        if (drug.getName().toLowerCase().startsWith(
                                charSequence.toString().toLowerCase())) {
                            displayDrugs.add(drug);
                        }
                    }
                }
                ListView listView = (ListView) rootView.findViewById(R.id.search_result);
                DrugArrayAdapter drugAdapt = new DrugArrayAdapter(getActivity(), displayDrugs);
                listView.setAdapter(drugAdapt);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        return rootView;
    }

}
