package com.kornden.ukrdrugs.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by JOB on 20.10.2017.
 */

public class DrugsContentProvider extends ContentProvider {

    public static final String UNKNOWN_URI = "unknown uri ";

    public static final int DRUGS = 100;

    private static UriMatcher sUriMatcher = buildUriMatcher();

    public static UriMatcher buildUriMatcher(){
        UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(DrugContract.AUTHORITY,DrugContract.PATH_DRUGS,DRUGS);
        return uriMatcher;
    }

    private DrugDbHelper mDrugDbHelper;

    @Override
    public boolean onCreate() {
        mDrugDbHelper = new DrugDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] columns,
                        @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        final SQLiteDatabase db = mDrugDbHelper.getReadableDatabase();
        int match = sUriMatcher.match(uri);
        Cursor cursor;
        switch (match){
            case DRUGS:
                cursor = db.query(DrugContract.DrugEntry.TABLE_NAME,
                        columns,
                        selection,
                        selectionArgs,
                        null,
                        null,
                        sortOrder
                );
                break;
            default: throw new UnsupportedOperationException("unknown Uri " + uri);

        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        final SQLiteDatabase sqLiteDatabase = mDrugDbHelper.getWritableDatabase();
        int match = sUriMatcher.match(uri);
        long id = 0;
        switch (match){
            case DRUGS:
                id = sqLiteDatabase.insert(DrugContract.DrugEntry.TABLE_NAME,
                        null,
                        contentValues);
                uri = ContentUris.withAppendedId(uri, id);
                break;
            default: throw new UnsupportedOperationException(UNKNOWN_URI + uri);
        }
        return uri;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        final SQLiteDatabase db = mDrugDbHelper.getWritableDatabase();
        int match = sUriMatcher.match(uri);
        int num = 0;
                switch(match){
                    case DRUGS:
                       num =  db.delete(DrugContract.DrugEntry.TABLE_NAME, selection,selectionArgs);
                        break;
                    default: throw new UnsupportedOperationException(UNKNOWN_URI + uri);
                }
                if( num != 0){
                    getContext().getContentResolver().notifyChange(uri,null);
                }

        return num;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
