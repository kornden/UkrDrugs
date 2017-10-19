package com.kornden.ukrdrugs.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.version;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

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
                DrugContract.DrugEntry._ID + " TEXT PRIMARY KEY"

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
