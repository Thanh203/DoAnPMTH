package com.example.doanpmth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddBook extends AppCompatActivity {
    EditText etName, etAuthor, etPrice, etDescription, etImage1, etImage2, etImage3;
    Spinner spinner;
    Button btn_add;
    Toolbar toolbar;
    private Mydatabase mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        etName = findViewById(R.id.edt_book_name);
        etAuthor = findViewById(R.id.edt_book_author);
        etPrice = findViewById(R.id.edt_book_price);
        etDescription = findViewById(R.id.edt_book_description);
        etImage1 = findViewById(R.id.imgBook1);
        etImage2 = findViewById(R.id.imgBook2);
        etImage3 = findViewById(R.id.imgBook3);
        spinner = findViewById(R.id.spinner_category);
        btn_add = findViewById(R.id.btn_addbook);
        mydb = new Mydatabase(this);


        toolbar = findViewById(R.id.toolbaraddbook);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        ArrayList<String> dscategory = mydb.getAllCatename();
        ArrayAdapter adapterspinner = new ArrayAdapter(this, android.R.layout.simple_spinner_item, dscategory);
        spinner.setAdapter(adapterspinner);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString().trim();
                String author = etAuthor.getText().toString().trim();
                String priceStr = etPrice.getText().toString().trim();
                String description = etDescription.getText().toString().trim();
                String image1 = etImage1.getText().toString().trim();
                String image2 = etImage2.getText().toString().trim();
                String image3 = etImage3.getText().toString().trim();
                int categoryId = (int) spinner.getSelectedItemId() + 1;
                if (name.isEmpty() || author.isEmpty() || priceStr.isEmpty()) {
                    Toast.makeText(AddBook.this, "Please enter book name, author, and price", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    int price = Integer.parseInt(priceStr);
                    boolean insertBook = mydb.addBook(categoryId, name, price, author, description, image1, image2, image3);
                    if (insertBook = true)
                    {
                        Toast.makeText(AddBook.this, "Add Book successful", Toast.LENGTH_SHORT).show();
                        etName.setText("");
                        etAuthor.setText("");
                        etPrice.setText("");
                        etDescription.setText("");
                        etImage1.setText("");
                        etImage2.setText("");
                        etImage3.setText("");
                    }
                    else {
                        Toast.makeText(AddBook.this, "Add Book failed", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
            }
        });
    }
}

