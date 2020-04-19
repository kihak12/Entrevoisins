package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;

import butterknife.BindView;


public class UserInfo extends AppCompatActivity {

    @BindView(R.id.item_avatar)
    public ImageView mAvatarUser;

    public String mAvatar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        Toolbar returnToMainMenu = (Toolbar) findViewById(R.id.returnToMainMenu);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        mAvatar = randomImage();
        Glide.with(this).load(mAvatar).into(mAvatarUser);
    }


    String randomImage() {
        return "https://i.pravatar.cc/150?u="+ System.currentTimeMillis();
    }
}