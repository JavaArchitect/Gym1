package com.example.gg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, "f4f8d4149893215ba412a29d8ac63ff1");
        setContentView(R.layout.activity_login);
    }
    public void denglu(View v){
        String name="";
        EditText editText1 =(EditText)findViewById(R.id.zhanghu);
        name=editText1.getText().toString();
        String pass="";
        EditText editText2 =(EditText)findViewById(R.id.mima);
        pass=editText2.getText().toString();
        BmobQuery<Account> query=new BmobQuery<Account>();
        query.addWhereEqualTo("id",name);
        query.addWhereEqualTo("ps",pass);
        query.findObjects(new FindListener<Account>() {
            @Override
            public void done(List<Account> list, BmobException e) {
                if(list.size()>0){
                    toast("成功登录");
                    Intent gotoMainContent=new Intent(login.this,article.class);
                    startActivity(gotoMainContent);
                }
                else {
                    toast("您输入的账户名或者密码有误");
                }
            }
        });
    }
    public void zhuce(View v){
        Intent gotoMainContent=new Intent(login.this,zhuce.class);
        startActivity(gotoMainContent);
    }
    public void toast(String msg){
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }
}
