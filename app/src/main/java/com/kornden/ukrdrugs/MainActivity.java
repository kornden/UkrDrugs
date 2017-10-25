package com.kornden.ukrdrugs;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kornden.ukrdrugs.data.DrugContract;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**TODO Дмитренко, [22.10.17 13:02]
 #хотелкі:
 -Activity обране (там знаходяться раніше відмічені препарати, там є індикатор що препарати в обраному і він збережений на тел)
 -Інструкції прератів збегірати по замовчуванню на сд карті
 - додати мкх коди (поміняють навзу тіпа помічник лікаря)
 - можна додати мед калькулятори сптздить які на маркеті
 -заунуть шкали та таблиці ризику ссз
 Фільтр  таб амл флакон інлятори капсули порошки
 Баги: не дозволять введення енера після назви
 - шукав слово "Форте" но воно не підтянуло "Мезим Форте",а підтянуло  коли шукав "мезим"
 NB! Інструкції повноцінні
 Фільтр Фармакотерапевтична група*/

public class MainActivity extends AppCompatActivity implements
DrugAdapter.DrugItemClickListener{



    ProgressBar progressBar;

    // listOfDrugData ArrayList consist of String[] which have on [0] - _id column(it`s a TEXT),
    // [1] - drug name, [2] - drug INN, [3] - drug dosage
    ArrayList<String[]> listOfDrugData;

    RecyclerView recyclerDrugList;

    DrugAdapter drugAdapter;

    AutoCompleteTextView editTextDrugSearch;

    HashSet<String> autocompleteSet;

    ArrayList<String> autocompleteList;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listOfDrugData = new ArrayList<>();

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        recyclerDrugList = (RecyclerView) findViewById(R.id.recycler_drug_list);
        recyclerDrugList.setLayoutManager(new LinearLayoutManager(this));
        recyclerDrugList.setHasFixedSize(true);

        String[] all = {DrugContract.DrugEntry.COLUMN_NAME, null};

        new LoadCursor().execute(all);

        recyclerDrugList.setVisibility(View.INVISIBLE);



    }
    public void getAutocompleteList(){

        //  HashSet holds only one copy of value, so it will filter all duplicates
        autocompleteSet = new HashSet<>();
        for (String[] listname : listOfDrugData){
            //listname[1] - drug name
            autocompleteSet.add(listname[1]);
            //listname[2] - drug INN
            autocompleteSet.add(listname[2]);
        }
        //autocompleteList is used for filling AutoCompleteTextView with data
        autocompleteList = new ArrayList<>(autocompleteSet);
        // Drug names must be sorted in AutoCompleteTextView
        Collections.sort(autocompleteList);

        editTextDrugSearch = (AutoCompleteTextView) findViewById(R.id.edit_drug_search);

        editTextDrugSearch.setThreshold(1);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,
                autocompleteList);

        editTextDrugSearch.setAdapter(arrayAdapter);

        editTextDrugSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                find();
                View view1 = MainActivity.this.getCurrentFocus();
                if (view1 != null) {
                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view1.getWindowToken(), 0);
                }
            }
        });
    }

    public void find(){

        String[] searchArgs = {editTextDrugSearch.getText().toString().toUpperCase().trim()};
        if (searchArgs[0].contains("\'")){
            searchArgs[0] = new StringBuilder(searchArgs[0])
                    .insert(searchArgs[0].indexOf("\'"), "\'").toString();
        }


            new LoadCursor().execute(searchArgs);



    }
    // implements interface for handling clicks on DrugAdapter.DrugViewHolder
    // you must get String[0] from ArrayList<String[]> for passing ID (which is TEXT!)
    @Override
    public void onDrugItemClick(int clickedDrugIndex) {
        String mID = listOfDrugData.get(clickedDrugIndex)[0];
        Intent intent = new Intent(this,DrugActivity.class);
        Uri nUri = Uri.withAppendedPath(DrugContract.DrugEntry.CONTENT_URI,mID);
        intent.setData(nUri);
        startActivity(intent);

    }

    /** LoadCursor is class for quering DrugRegister.db via ContentResolver*/
    private class LoadCursor extends AsyncTask<String,Void,Cursor>{
    @Override
    protected Cursor doInBackground(String... strings) {
        Cursor cursor;
        String[] columns = {DrugContract.DrugEntry._ID, DrugContract.DrugEntry.COLUMN_NAME,
                DrugContract.DrugEntry.COLUMN_INN, DrugContract.DrugEntry.COLUMN_CONSISTOF};
        switch (strings.length){
            case  1:
            String selection = DrugContract.DrugEntry.COLUMN_NAME + " LIKE \'" + strings[0] + "%'";
            cursor = getContentResolver().query(DrugContract.DrugEntry.CONTENT_URI,
                    columns,
                    selection,
                    null,
                    DrugContract.DrugEntry.COLUMN_INN);

                    if (cursor.getCount() == 0) {
                    selection = DrugContract.DrugEntry.COLUMN_INN + " LIKE \'" + strings[0] + "%'";
                    cursor = getContentResolver().query(DrugContract.DrugEntry.CONTENT_URI,
                            columns,
                            selection,
                            null,
                            DrugContract.DrugEntry.COLUMN_INN);
                    }
                    break;
            default:
            cursor = getContentResolver().query(DrugContract.DrugEntry.CONTENT_URI,
                    columns,
                    null,
                    null,
                    null);
        }


        return cursor;
    }

    @Override
    protected void onPostExecute(Cursor cursor) {
listOfDrugData = new ArrayList<>();
        recyclerDrugList.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
        if (cursor.getCount() != 0){
            while (cursor.moveToNext()){
                String[] drugData = {cursor.getString(
                        cursor.getColumnIndex(DrugContract.DrugEntry._ID)),cursor.getString(
                        cursor.getColumnIndex(DrugContract.DrugEntry.COLUMN_NAME)),cursor.getString(
                        cursor.getColumnIndex(DrugContract.DrugEntry.COLUMN_INN)),cursor.getString(
                        cursor.getColumnIndex(DrugContract.DrugEntry.COLUMN_CONSISTOF))};
                listOfDrugData.add(drugData);
            }
            drugAdapter = new DrugAdapter(listOfDrugData, MainActivity.this);

            recyclerDrugList.setAdapter(drugAdapter);
        }else{
            recyclerDrugList.setVisibility(View.INVISIBLE);
            Toast.makeText(getBaseContext(),"No matches", Toast.LENGTH_LONG).show();
        }
        cursor.close();
        if(autocompleteList == null) {
            getAutocompleteList();
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        recyclerDrugList.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
    }
}
}
