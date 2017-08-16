package com.kornden.ukrdrugs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static android.R.attr.editable;

public class AffordableDrugs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drug_search);
        EditText searchText = (EditText) findViewById(R.id.search_text);
        final ArrayList<Drug> drugs = new ArrayList<>();
        drugs.add(new Drug("Аміодарон"));
        drugs.add(new Drug("Амлодипін"));
        drugs.add(new Drug("Атенолол"));
        drugs.add(new Drug("Верапаміл"));
        drugs.add(new Drug("Гідрохлортіазид"));
        drugs.add(new Drug("Спіронолактон"));
        drugs.add(new Drug("Фуросемід"));
        drugs.add(new Drug("Дигоксин"));
        drugs.add(new Drug("Еналаприл"));
        drugs.add(new Drug("Ізосорбіду динітрат"));
        drugs.add(new Drug("Карведілол"));
        drugs.add(new Drug("Клопідогрель"));
        drugs.add(new Drug("Метопролол"));
        drugs.add(new Drug("Нітрогліцерин"));
        drugs.add(new Drug("Симвастатин"));

        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ArrayList<Drug> findItem = new ArrayList<Drug>();
                if(charSequence ==""){
                    findItem.clear();
                }else
                if(charSequence!=""){
                    for(Drug drug:drugs){

                        if(drug.getName().toLowerCase().startsWith(
                                charSequence.toString().toLowerCase())){
                            findItem.add(drug);
                        }
                    }
                }
                ListView listView = (ListView) findViewById(R.id.search_result);
                DrugArrayAdapter drugAdapt = new DrugArrayAdapter(AffordableDrugs.this, findItem);
                listView.setAdapter(drugAdapt);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }
}
