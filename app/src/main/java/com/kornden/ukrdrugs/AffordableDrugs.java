package com.kornden.ukrdrugs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Affordable Drugs (in ukrainian "Доступні ліки"), Ukrainian goverment program to make drugs for
 * Cardiac diseases, bronchial asthma and Diabetes mellitus type 2  cheaper or, in some cases - free.
 * The goal of this code - to find and display INN of drugs.
 *
 * TODO: need to import Apache POI and create Drug objects from excel files.
 */


public class AffordableDrugs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drug_search);
        EditText searchText = (EditText) findViewById(R.id.search_text);
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

            /**
             * When you start type - this method compares name field in Drug object in drugs list to
             * the text, which was typed in EditText view, and if it matches, it puts Drug object
             * into displayDrug list. When seeking is done displayDrug List is puts on drug_search
             * layout in ListView via DrugArrayAdapter.
             * @param charSequence
             * @param i
             * @param i1
             * @param i2
             */
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ArrayList<Drug> displayDrugs = new ArrayList<Drug>();
                if (charSequence == "") {
                    displayDrugs.clear();
                } else if (charSequence != "") {
                    for (Drug drug : drugs) {
                        if (drug.getName().toLowerCase().startsWith(
                                charSequence.toString().toLowerCase()) && (charSequence != "")) {
                            displayDrugs.add(drug);
                        }
                    }
                }
                ListView listView = (ListView) findViewById(R.id.search_result);
                DrugArrayAdapter drugAdapt = new DrugArrayAdapter(AffordableDrugs.this, displayDrugs);
                listView.setAdapter(drugAdapt);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}
