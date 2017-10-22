package com.kornden.ukrdrugs.data;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by kornd on 21-Oct-17.
 */

public class DrugAssetDbHepler extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "drugRegister.db";

    private static final int VERSION = 1;

    public DrugAssetDbHepler(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }


}
