package com.example.doanpmth.SQLHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    // Tên cơ sở dữ liệu
    private static final String DATABASE_NAME = "bookstore.db";

    // Phiên bản cơ sở dữ liệu
    private static final int DATABASE_VERSION = 1;

    // Bảng users
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_USER_USERNAME = "username";
    public static final String COLUMN_USER_PASSWORD = "password";
    public static final String COLUMN_USER_NAME = "name";
    public static final String COLUMN_USER_EMAIL = "email";
    public static final String COLUMN_USER_PHONE = "phone";

    // Bảng categories
    public static final String TABLE_CATEGORIES = "categories";
    public static final String COLUMN_CATEGORY_ID = "categorie_id";
    public static final String COLUMN_CATEGORY_NAME = "name";

    // Bảng books
    public static final String TABLE_BOOKS = "books";
    public static final String COLUMN_BOOK_ID = "book_id";
    public static final String COLUMN_BOOK_CATEGORY_ID = "book_category_id";
    public static final String COLUMN_BOOK_NAME = "book_name";
    public static final String COLUMN_BOOK_AUTHOR = "book_author";
    public static final String COLUMN_BOOK_DESCRIPTION = "book_description";
    public static final String COLUMN_BOOK_PRICE = "book_price";
    public static final String COLUMN_BOOK_IMAGE_1 = "imagebook_1";
    public static final String COLUMN_BOOK_IMAGE_2 = "imagebook_2";
    public static final String COLUMN_BOOK_IMAGE_3 = "imagebook_3";
    public static final String COLUMN_BOOK_HISTORY = "book_history";
    public static final String COLUMN_BOOK_LIKED = "book_liked";

    // Bảng historyorder
    public static final String TABLE_HISTORY_ORDER = "historyorder";
    public static final String COLUMN_ORDER_ID = "order_id";
    public static final String COLUMN_ORDER_USER_ID = "user_id";
    public static final String COLUMN_ORDER_TOTAL_PRICE = "total_price";
    public static final String COLUMN_ORDER_DATE = "order_date";
    public static final String COLUMN_HISTORY_RECEIVER_NAME = "receiver_name";
    public static final String COLUMN_HISTORY_RECEIVER_PHONE = "receiver_phone";
    public static final String COLUMN_HISTORY_RECEIVER_ADDRESS = "receiver_address";
    public static final String COLUMN_HISTORY_PAYMENT_METHOD = "payment_method";

    // Bảng order_detail
    public static final String TABLE_ORDER_DETAIL = "order_detail";
    public static final String COLUMN_ORDER_DETAIL_ID = "order_detail_id";
    public static final String COLUMN_ORDER_DETAIL_ORDER_ID = "order_id";
    public static final String COLUMN_ORDER_DETAIL_BOOK_ID = "book_id";
    public static final String COLUMN_ORDER_DETAIL_QUANTITY = "quantity";

//--------------------------------------------------------------------------------------------------
    private static final String CREATE_TABLE_USERS = "CREATE TABLE " + TABLE_USERS + "("
            + COLUMN_USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_USER_USERNAME + " TEXT ,"
            + COLUMN_USER_PASSWORD + " TEXT ,"
            + COLUMN_USER_NAME + " TEXT ,"
            + COLUMN_USER_EMAIL + " TEXT ,"
            + COLUMN_USER_PHONE + " TEXT "
            + ")";

    // Tạo bảng categories
    private static final String CREATE_TABLE_CATEGORIES = "CREATE TABLE " + TABLE_CATEGORIES + "("
            + COLUMN_CATEGORY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_CATEGORY_NAME + " TEXT "
            + ")";

    // Tạo bảng books
    private static final String CREATE_TABLE_BOOKS = "CREATE TABLE " + TABLE_BOOKS + "("
            + COLUMN_BOOK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_BOOK_CATEGORY_ID + " INTEGER ,"
            + COLUMN_BOOK_NAME + " TEXT ,"
            + COLUMN_BOOK_AUTHOR + " TEXT ,"
            + COLUMN_BOOK_DESCRIPTION + " TEXT ,"
            + COLUMN_BOOK_PRICE + " INTEGER ,"
            + COLUMN_BOOK_IMAGE_1 + " TEXT ,"
            + COLUMN_BOOK_IMAGE_2 + " TEXT ,"
            + COLUMN_BOOK_IMAGE_3 + " TEXT ,"
            + COLUMN_BOOK_HISTORY + " INT ,"
            + COLUMN_BOOK_LIKED + " INT ,"
            + "FOREIGN KEY(" + COLUMN_BOOK_CATEGORY_ID + ") REFERENCES " + TABLE_CATEGORIES + "(" + COLUMN_CATEGORY_ID + ") "
            + ")";

    public DatabaseHelper( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
