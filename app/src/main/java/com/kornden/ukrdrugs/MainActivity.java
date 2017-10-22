package com.kornden.ukrdrugs;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kornden.ukrdrugs.data.DrugContract;

import java.util.ArrayList;
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

    EditText editTextDrugSearch;

    ProgressBar progressBar;
    // listOfDrugData ArrayList consist of String[] which have on [0] - _id column(it`s a TEXT),
    // [1] - drug name, [2] - drug INN, [3] - drug dosage
    ArrayList<String[]> listOfDrugData;
    RecyclerView drugList;
    DrugAdapter drugAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drugList = (RecyclerView) findViewById(R.id.recycler_drug_list);

        drugList.setLayoutManager(new LinearLayoutManager(this));

        drugList.setHasFixedSize(true);




        editTextDrugSearch = (EditText) findViewById(R.id.edit_drug_search);

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);



        listOfDrugData = new ArrayList<>();




    }
    public void find(View view){


        String[] searchArgs = {editTextDrugSearch.getText().toString().toUpperCase().trim()};


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

    private class LoadCursor extends AsyncTask<String,Void,Cursor>{
    @Override
    protected Cursor doInBackground(String... strings) {
        String[] columns = {DrugContract.DrugEntry._ID, DrugContract.DrugEntry.COLUMN_NAME,
                DrugContract.DrugEntry.COLUMN_INN, DrugContract.DrugEntry.COLUMN_CONSISTOF};
        String selection = DrugContract.DrugEntry.COLUMN_NAME + " LIKE \'" + strings[0] + "%'";
        Cursor cursor = getContentResolver().query(DrugContract.DrugEntry.CONTENT_URI,
                columns,
                selection,
                null,
                DrugContract.DrugEntry.COLUMN_INN);
        if(cursor != null)
        if(cursor.getCount() == 0){
            selection = DrugContract.DrugEntry.COLUMN_INN + " LIKE \'" + strings[0] + "%'";
            cursor = getContentResolver().query(DrugContract.DrugEntry.CONTENT_URI,
                    columns,
                    selection,
                    null,
                    DrugContract.DrugEntry.COLUMN_INN);
        }


        return cursor;
    }

    @Override
    protected void onPostExecute(Cursor cursor) {
        listOfDrugData.clear();
        drugList.setVisibility(View.VISIBLE);
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

            drugList.setAdapter(drugAdapter);
        }else Toast.makeText(getBaseContext(),"No matches", Toast.LENGTH_LONG).show();
        cursor.close();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        drugList.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
    }
}
}
