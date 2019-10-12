package com.casper.testdrivendevelopment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BookListMainActivity extends AppCompatActivity {

    ListView listViewBooks;
    private List<Book> listBooks=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list_main);

        init();
        listViewBooks=this.findViewById(R.id.list_view_books);

        BookAdapter adapter = new BookAdapter(BookListMainActivity.this, R.layout.list_item_book,listBooks);
        listViewBooks.setAdapter(adapter);

        this.registerForContextMenu(listViewBooks);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;

        menu.setHeaderTitle(listBooks.get(info.position).getTitle());

        menu.add(0, 1, 0, "新建");
        menu.add(0, 2, 0, "删除");
        menu.add(0, 3, 0, "关于...");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1 :
                break;
            case 2:
                Toast.makeText(BookListMainActivity.this,"删除成功", Toast.LENGTH_LONG).show();
                break;
            case 3:
                Toast.makeText(BookListMainActivity.this,"图书列表v2.0", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void init() {
        listBooks.add(new Book("软件项目管理案例教程（第4版）",R.drawable.book_2));
        listBooks.add(new Book("创新工程实践",R.drawable.book_no_name));
        listBooks.add(new Book("信息安全数学基础（第2版）",R.drawable.book_1));
    }

    class BookAdapter extends ArrayAdapter<Book> {

        private int resourceId;

        public BookAdapter(Context context, int resource, List<Book> objects) {
            super(context, resource, objects);
            resourceId = resource;
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Book book = getItem(position);//获取当前项的实例
            View view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            ((ImageView) view.findViewById(R.id.image_view_book_cover)).setImageResource(book.getCoverResourceID());
            ((TextView) view.findViewById(R.id.text_view_book_title)).setText(book.getTitle());
            return view;
        }
    }
}
