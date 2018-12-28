package com.example.gg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class zhuce extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
    }
    public void Register(View view) {
        // Do something in response to button

        String str1="";
        EditText editText1 =(EditText)findViewById(R.id.aa);
        str1=editText1.getText().toString();
        String str2="";
        EditText editText2 =(EditText)findViewById(R.id.bb);
        str2=editText2.getText().toString();

        Account p2 = new Account();
        p2.setName(str1);
        p2.setAddress(str2);
        p2.save(new SaveListener<String>() {
            @Override
            public void done(String objectId,BmobException e) {
                if(e==null){
                    toast("添加数据成功，返回objectId为："+objectId);
                    Intent gotoMainContent=new Intent(zhuce.this,login.class);
                    startActivity(gotoMainContent);

                }else{
                    toast("创建数据失败：" + e.getMessage());
                    //System.out.print("666"+e.getMessage());
                }
            }
        });

    }
    public void toast(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
}
