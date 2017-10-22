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

        public static final String TABLE_NAME = "drugRegister";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_INN = "inn";
        public static final String COLUMN_FORM = "form";
        public static final String COLUMN_ISRECIPE = "isrecipe";
        public static final String COLUMN_CONSISTOF = "consistof";
        public static final String COLUMN_FARM_GROUP = "farmgroup";
        public static final String COLUMN_ATC1 = "atc1";
        public static final String COLUMN_ATC2 = "atc2";
        public static final String COLUMN_ATC3 = "atc3";
        public static final String COLUMN_SELLER_UKR = "sellerukr";
        public static final String COLUMN_SELLER_COUNTRY = "sellercountry";
        public static final String COLUMN_SELLER_ADDRESS = "selleraddress";
        public static final String COLUMN_MANUFACTURER_COUNT = "manufacturercount";
        public static final String COLUMN_MANUFACTURER_UKR1 = "manufacturerukr1";
        public static final String COLUMN_MANUFACTURER_COUNTRY1 = "manufacturercountry1";
        public static final String COLUMN_MANUFACTURER_ADDRESS1 = "manufactureraddress1";
        public static final String COLUMN_MANUFACTURER_UKR2 = "manufacturerukr2";
        public static final String COLUMN_MANUFACTURER_COUNTRY2 = "manufacturercountry2";
        public static final String COLUMN_MANUFACTURER_ADDRESS2 = "manufactureraddress2";
        public static final String COLUMN_MANUFACTURER_UKR3 = "manufacturerukr3";
        public static final String COLUMN_MANUFACTURER_COUNTRY3 = "manufacturercountry3";
        public static final String COLUMN_MANUFACTURER_ADDRESS3 = "manufactureraddress3";
        public static final String COLUMN_MANUFACTURER_UKR4 = "manufacturerukr4";
        public static final String COLUMN_MANUFACTURER_COUNTRY4 = "manufacturercountry4";
        public static final String COLUMN_MANUFACTURER_ADDRESS4 = "manufactureraddress4";
        public static final String COLUMN_MANUFACTURER_UKR5 = "manufacturerukr5";
        public static final String COLUMN_MANUFACTURER_COUNTRY5 = "manufacturercountry5";
        public static final String COLUMN_MANUFACTURER_ADDRESS5 = "manufactureraddress5";
        public static final String COLUMN_REGISTRATION_NUMBER = "registrationnumber";
        public static final String COLUMN_START_DATE = "startdate";
        public static final String COLUMN_END_DATE = "enddate";
        public static final String COLUMN_TYPE = "type";
        public static final String COLUMN_BIO = "bio";
        public static final String COLUMN_HERBAL = "herb";
        public static final String COLUMN_ORPHAN = "orphan";
        public static final String COLUMN_HOMEO = "homeo";
        public static final String COLUMN_INN_TYPE = "inntype";
        public static final String COLUMN_STOP = "stop";
        public static final String COLUMN_STOP_LASTDAY = "stoplastday";
        public static final String COLUMN_STOP_REASON = "stopreason";
        public static final String COLUMN_URL_MANUAL = "URL";

    }
}
