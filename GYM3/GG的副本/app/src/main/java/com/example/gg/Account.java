package com.example.gg;

import android.widget.Toast;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.*;

import static cn.bmob.v3.Bmob.getApplicationContext;

public class Account extends BmobObject {
    private String id;
    private String ps;

    public String getName() {
        return id;
    }
    public void setName(String name) {
        this.id = name;
    }
    public String getAddress() {
        return ps;
    }
    public void setAddress(String address) {
        this.ps = address;
    }
}