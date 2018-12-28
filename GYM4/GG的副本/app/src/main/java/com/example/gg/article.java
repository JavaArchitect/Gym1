package com.example.gg;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class article extends AppCompatActivity {
    DatabaseHelper dbhelper ;
    SQLiteDatabase db ;
    TextView ssr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        // helper = new SQLiteDbHelper(getApplicationContext());
        // database = helper.getWritableDatabase();
        dbhelper = new DatabaseHelper(article.this, "test_db", null, 1);
        db = dbhelper.getWritableDatabase();
        final TextView tv = (TextView) findViewById(R.id.tx);
        tv.setText("无缓存");
        final Button btn = (Button) findViewById(R.id.bb);
//设置点击后TextView现实的内容
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = db.query("user", new String[]{"name"}, null, null, null, null, null);
                //利用游标遍历所有数据对象
                //为了显示全部，把所有对象连接起来，放到TextView中
                String textview_data = "";
                while (cursor.moveToNext()) {
                    String name = cursor.getString(cursor.getColumnIndex("name"));
                    textview_data = textview_data + "\n" + name;
                }
                tv.setText(textview_data);
            }
        });
    }
    public void huancun(View view) {
        ContentValues values = new ContentValues();
        values.put("name","abijklmnopqrstuvwxyzcdefgh");
        //数据库执行插入命令
        db.insert("user", null, values);
        toast("OK");
    }
    public void duqu(View view) {


    }

    public void toast(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
}
