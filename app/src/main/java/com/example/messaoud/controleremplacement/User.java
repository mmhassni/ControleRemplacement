package com.example.messaoud.controleremplacement;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class User {
    private String name;
    private String status;
    private int avatar;

    public User(String name, String status, int avatar) {
        this.name = name;
        this.status = status;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public int getAvatar() {
        return avatar;
    }
}
