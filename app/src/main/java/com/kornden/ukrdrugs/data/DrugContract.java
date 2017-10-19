package com.kornden.ukrdrugs.data;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by kornd on 19-Oct-17.
 */

public class DrugContract {
    public static final String AUTHORITY = "com.kornden.ukrdrugs";

    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    public static final String PATH_DRUGS = "drugs";

    public static final class DrugEntry implements BaseColumns{

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon()
                .appendPath(PATH_DRUGS).build();

        public static final String TABLE_NAME = "drugs-table";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_INN = "inn";
        public static final String COLUMN_FORM = "form";
        public static final String COLUMN_RECIPE = "conditions";
        public static final String COLUMN_COMPOSITION = "composition";
        public static final String COLUMN_GROUP = "group";
        public static final String COLUMN_ATC = "atc";
        public static final String COLUMN_MANUFACTURER = "manufacturer";
        public static final String COLUMN_COUNTRY = "country";
        public static final String COLUMN_END_REGISTRATION = "end_registration";
        public static final String COLUMN_IS_HERBAL = "is-herbal";
        public static final String COLUMN_IS_HOMEPATHIC = "is-homeopathic";
        public static final String COLUMN_URL_MANUAL = "url-manual";

    }
}
