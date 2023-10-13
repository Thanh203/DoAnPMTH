package com.example.doanpmth;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Mydatabase {
    SQLiteDatabase db;
    DatabaseHelper DBhelper;
    public  Mydatabase(Context context){
        DBhelper = new DatabaseHelper(context);
        db = DBhelper.getWritableDatabase();
    }
    public boolean deleteBook(int bookId) {
        int result = db.delete(DBhelper.TABLE_BOOKS, DBhelper.COLUMN_BOOK_ID + " = ?",
                new String[]{String.valueOf(bookId)});
        return result > 0;
    }
    //Sửa sách
    public boolean updateBook(int bookid, int categoryId, String bookName, int bookPrice, String bookAuthor, String description, String image1, String image2, String image3) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_BOOK_CATEGORY_ID, categoryId);
        values.put(DatabaseHelper.COLUMN_BOOK_NAME, bookName);
        values.put(DatabaseHelper.COLUMN_BOOK_AUTHOR, bookAuthor);
        values.put(DatabaseHelper.COLUMN_BOOK_DESCRIPTION, description);
        values.put(DatabaseHelper.COLUMN_BOOK_PRICE, bookPrice);
        values.put(DatabaseHelper.COLUMN_BOOK_IMAGE_1, image1);
        values.put(DatabaseHelper.COLUMN_BOOK_IMAGE_2, image2);
        values.put(DatabaseHelper.COLUMN_BOOK_IMAGE_3, image3);
        int result = db.update(DBhelper.TABLE_BOOKS, values, DBhelper.COLUMN_BOOK_ID + " = ?",
                new String[]{String.valueOf(bookid)});
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public List<Book> getCategory4Books(int categoryId) {
        List<Book> bookList = new ArrayList<>();
        String query = "SELECT * FROM " + DBhelper.TABLE_BOOKS + " WHERE " + DBhelper.COLUMN_BOOK_CATEGORY_ID + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(categoryId)});
        if (cursor.moveToFirst()) {
            do {
                int bookId = cursor.getInt(0);
                int bookCategoryId = cursor.getInt(1);
                String bookName = cursor.getString(2);
                String bookAuthor = cursor.getString(3);
                String bookDescription = cursor.getString(4);
                int bookPrice = cursor.getInt(5);
                String bookImage1 = cursor.getString(6);
                String bookImage2 = cursor.getString(7);
                String bookImage3 = cursor.getString(8);

                Book book = new Book(bookId, bookCategoryId, bookName, bookAuthor, bookDescription, bookPrice, bookImage1, bookImage2, bookImage3);
                bookList.add(book);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return bookList;
    }
    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<Book>();

        Cursor cursor = db.query(DBhelper.TABLE_BOOKS, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int book_id = cursor.getInt(0);
                int category_id = cursor.getInt(1);
                String book_name = cursor.getString(2);
                String book_author = cursor.getString(3);
                String book_description = cursor.getString(4);
                int book_price = cursor.getInt(5);
                String book_image_1 = cursor.getString(6);
                String book_image_2 = cursor.getString(7);
                String book_image_3 = cursor.getString(8);

                Book book = new Book(book_id, category_id, book_name, book_author, book_description, book_price, book_image_1, book_image_2, book_image_3);
                books.add(book);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return books;
    }
    public boolean addBook(int categoryId, String bookName, int bookPrice, String bookAuthor, String description, String image1, String image2, String image3) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_BOOK_CATEGORY_ID, categoryId);
        values.put(DatabaseHelper.COLUMN_BOOK_NAME, bookName);
        values.put(DatabaseHelper.COLUMN_BOOK_AUTHOR, bookAuthor);
        values.put(DatabaseHelper.COLUMN_BOOK_DESCRIPTION, description);
        values.put(DatabaseHelper.COLUMN_BOOK_PRICE, bookPrice);
        values.put(DatabaseHelper.COLUMN_BOOK_IMAGE_1, image1);
        values.put(DatabaseHelper.COLUMN_BOOK_IMAGE_2, image2);
        values.put(DatabaseHelper.COLUMN_BOOK_IMAGE_3, image3);
        long result = db.insert(DatabaseHelper.TABLE_BOOKS, null, values);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }
    public ArrayList<String> getAllCatename() {
        ArrayList<String> cates = new ArrayList<>();

        Cursor cursor = db.query(DBhelper.TABLE_CATEGORIES, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                String cate_name = cursor.getString(1);
                cates.add(cate_name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return cates;
    }
}
