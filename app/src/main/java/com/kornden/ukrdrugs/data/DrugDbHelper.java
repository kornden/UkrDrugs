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
                DrugContract.DrugEntry.COLUMN_NAME + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_INN + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_FORM + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_ISRECIPE + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_CONSISTOF + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_FARM_GROUP + " TEXT , "+
                DrugContract.DrugEntry.COLUMN_ATC1 + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_ATC2 + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_ATC3 + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_SELLER_UKR + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_SELLER_COUNTRY + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_SELLER_ADDRESS + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_MANUFACTURER_COUNT + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_MANUFACTURER_UKR1 + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_MANUFACTURER_COUNTRY1 + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_MANUFACTURER_ADDRESS1 + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_MANUFACTURER_UKR2 + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_MANUFACTURER_COUNTRY2 + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_MANUFACTURER_ADDRESS2 + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_MANUFACTURER_UKR3 + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_MANUFACTURER_COUNTRY3 + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_MANUFACTURER_ADDRESS3 + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_MANUFACTURER_UKR4 + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_MANUFACTURER_COUNTRY4 + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_MANUFACTURER_ADDRESS4 + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_MANUFACTURER_UKR5 + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_MANUFACTURER_COUNTRY5 + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_MANUFACTURER_ADDRESS5 + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_REGISTRATION_NUMBER + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_START_DATE + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_END_DATE + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_TYPE + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_BIO + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_HERBAL + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_ORPHAN + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_HOMEO + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_INN_TYPE + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_STOP + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_STOP_LASTDAY + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_STOP_REASON + " TEXT , " +
                DrugContract.DrugEntry.COLUMN_URL_MANUAL + " TEXT);";

        sqLiteDatabase.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + DrugContract.DrugEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
