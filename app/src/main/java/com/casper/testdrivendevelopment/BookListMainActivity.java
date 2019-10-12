package com.casper.testdrivendevelopment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BookListMainActivity extends AppCompatActivity {

    ListView listViewBooks;
    String []bookNames={"Android开发","xin","创新工程实践"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list_main);

        listViewBooks=this.findViewById(R.id.list_view_books);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                BookListMainActivity.this, android.R.layout.simple_list_item_1, bookNames);
        listViewBooks.setAdapter(adapter);
    }
}
