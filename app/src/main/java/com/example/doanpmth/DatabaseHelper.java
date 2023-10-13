package com.example.doanpmth;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
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
    //Bảng Cart
    public static final String TABLE_CART = "cart";
    public static final String COLUMN_CART_ID = "cart_id";
    public static final String COLUMN_CART_USER_ID = "cart_user_id";
    public static final String COLUMN_CART_BOOK_ID = "cart_book_id";
    public static final String COLUMN_CART_QUANTITY = "cart_quantity";
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
    // Tạo bảng users
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
            + "FOREIGN KEY(" + COLUMN_BOOK_CATEGORY_ID + ") REFERENCES " + TABLE_CATEGORIES + "(" + COLUMN_CATEGORY_ID + ") "
            + ")";
    //Tạo bảng Cart
    private static final String CREATE_TABLE_CART = "CREATE TABLE " + TABLE_CART + "("
            + COLUMN_CART_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CART_USER_ID + " INTEGER , "
            + COLUMN_CART_BOOK_ID + " INTEGER , "
            + COLUMN_CART_QUANTITY + " INTEGER , "
            + "FOREIGN KEY(" + COLUMN_CART_USER_ID + ") REFERENCES " + TABLE_USERS + "(" + COLUMN_USER_ID + "), "
            + "FOREIGN KEY(" + COLUMN_CART_BOOK_ID + ") REFERENCES " + TABLE_BOOKS + "(" + COLUMN_BOOK_ID + "));";
    // Tạo bảng historyorder
    private static final String CREATE_TABLE_HISTORY_ORDER = "CREATE TABLE " + TABLE_HISTORY_ORDER + "("
            + COLUMN_ORDER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_ORDER_USER_ID + " INTEGER,"
            + COLUMN_ORDER_TOTAL_PRICE + " INTEGER,"
            + COLUMN_ORDER_DATE + " TEXT,"
            + COLUMN_HISTORY_RECEIVER_NAME + " TEXT ,"
            + COLUMN_HISTORY_RECEIVER_PHONE + " TEXT ,"
            + COLUMN_HISTORY_RECEIVER_ADDRESS + " TEXT ,"
            + COLUMN_HISTORY_PAYMENT_METHOD + " TEXT ,"
            + "FOREIGN KEY(" + COLUMN_ORDER_USER_ID + ") REFERENCES " + TABLE_USERS + "(" + COLUMN_USER_ID + "));";
    // Tạo bảng order_detail
    private static final String CREATE_TABLE_ORDER_DETAIL = "CREATE TABLE " + TABLE_ORDER_DETAIL + "("
            + COLUMN_ORDER_DETAIL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COLUMN_ORDER_DETAIL_ORDER_ID + " INTEGER,"
            + COLUMN_ORDER_DETAIL_BOOK_ID + " INTEGER,"
            + COLUMN_ORDER_DETAIL_QUANTITY + " INTEGER,"
            + "FOREIGN KEY(" + COLUMN_ORDER_DETAIL_ORDER_ID + ") REFERENCES " + TABLE_HISTORY_ORDER + "(" + COLUMN_ORDER_ID + "),"
            + "FOREIGN KEY(" + COLUMN_ORDER_DETAIL_BOOK_ID + ") REFERENCES " + TABLE_BOOKS + "(" + COLUMN_BOOK_ID + "));";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_CATEGORIES);
        db.execSQL(CREATE_TABLE_BOOKS);
        db.execSQL(CREATE_TABLE_CART);
        db.execSQL(CREATE_TABLE_HISTORY_ORDER);
        db.execSQL(CREATE_TABLE_ORDER_DETAIL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i < i1) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORIES);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CART);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORY_ORDER);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDER_DETAIL);
            onCreate(db);
        }
    }
}
