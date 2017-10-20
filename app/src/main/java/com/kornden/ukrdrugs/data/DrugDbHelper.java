package com.kornden.ukrdrugs.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kornd on 19-Oct-17.
 */

public class DrugDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "drugRegister.db";

    private static final int VERSION = 1;

    public DrugDbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String CREATE_TABLE = "CREATE TABLE " + DrugContract.DrugEntry.TABLE_NAME + " (" +
                DrugContract.DrugEntry._ID + " TEXT PRIMARY KEY, " +
                DrugContract.DrugEntry.COLUMN_NAME + " TEXT DEFAULT NULL, " +
                DrugContract.DrugEntry.COLUMN_INN + " TEXT DEFAULT NULL, " +
                DrugContract.DrugEntry.COLUMN_FORM + " TEXT DEFAULT NULL, " +
                DrugContract.DrugEntry.COLUMN_RECIPE + " TEXT DEFAULT NULL, " +
                DrugContract.DrugEntry.COLUMN_COMPOSITION + " TEXT DEFAULT NULL, " +
                DrugContract.DrugEntry.COLUMN_GROUP + " TEXT DEFAULT NULL, "+
                DrugContract.DrugEntry.COLUMN_ATC + " TEXT DEFAULT NULL, " +
                DrugContract.DrugEntry.COLUMN_MANUFACTURER + " TEXT DEFAULT NULL, " +
                DrugContract.DrugEntry.COLUMN_COUNTRY + " TEXT DEFAULT NULL, " +
                DrugContract.DrugEntry.COLUMN_REGISTRATION_NUMBER + " TEXT DEFAULT NULL, " +
                DrugContract.DrugEntry.COLUMN_START_REGISTRATION + " TEXT DEFAULT NULL, " +
                DrugContract.DrugEntry.COLUMN_END_REGISTRATION + " TEXT DEFAULT NULL, " +
                DrugContract.DrugEntry.COLUMN_IS_HERBAL + " TEXT DEFAULT NULL, " +
                DrugContract.DrugEntry.COLUMN_IS_HOMEPATHIC + " TEXT DEFAULT NULL, " +
                DrugContract.DrugEntry.COLUMN_URL_MANUAL + " TEXT DEFAULT NULL);";

        sqLiteDatabase.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + DrugContract.DrugEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
