package com.kornden.ukrdrugs;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.kornden.ukrdrugs.data.DrugContract;

/** This activity will show information about drug, when you click on RecyclerView.ViewHolder on
 * MainActivity
 */
public class DrugActivity extends AppCompatActivity {
    TextView drugName;
    TextView drugINN;
    TextView drugForm;
    TextView drugConsistOf;
    TextView drugFarmGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug);
        drugName = (TextView) findViewById(R.id.drug_name_text);
        drugINN = (TextView) findViewById(R.id.drug_inn);
        drugForm = (TextView) findViewById(R.id.drug_form);
        drugConsistOf = (TextView) findViewById(R.id.drug_consistof);
        drugFarmGroup = (TextView) findViewById(R.id.drug_farmgroup);

        Intent intent = getIntent();
        Uri[] nUri = {intent.getData()};
        new DrugLoader().execute(nUri);


    }
    private class DrugLoader extends AsyncTask<Uri,Void, Cursor>{
        @Override
        protected Cursor doInBackground(Uri... uris) {
            String[] projection = {DrugContract.DrugEntry.COLUMN_NAME,
                    DrugContract.DrugEntry.COLUMN_INN,
                    DrugContract.DrugEntry.COLUMN_FORM,
                    DrugContract.DrugEntry.COLUMN_CONSISTOF,
                    DrugContract.DrugEntry.COLUMN_FARM_GROUP};
            return getContentResolver().query(uris[0],
                    projection,
                    null,
                    null,
                    null);

        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            super.onPostExecute(cursor);
            if(cursor.getCount() > 0) {
                cursor.moveToNext();
                drugName.setText(cursor.getString(cursor.getColumnIndex(DrugContract.DrugEntry.COLUMN_NAME)));
                drugINN.setText(cursor.getString(cursor.getColumnIndex(DrugContract.DrugEntry.COLUMN_INN)));
                drugForm.setText(cursor.getString(cursor.getColumnIndex(DrugContract.DrugEntry.COLUMN_FORM)));
                drugConsistOf.setText(cursor.getString(cursor.getColumnIndex(DrugContract.DrugEntry.COLUMN_CONSISTOF)));
                drugFarmGroup.setText(cursor.getString(cursor.getColumnIndex(DrugContract.DrugEntry.COLUMN_FARM_GROUP)));
            }
            cursor.close();
        }
    }
}
