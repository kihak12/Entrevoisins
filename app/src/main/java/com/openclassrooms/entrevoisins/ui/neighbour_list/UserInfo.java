package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;


import butterknife.BindView;


public class UserInfo extends AppCompatActivity {


    private ImageButton mainMenu;
    public NeighbourApiService mApiService;

    @BindView(R.id.item_avatar)
    public ImageView mNeighbourAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        Toolbar returnToMainMenu = (Toolbar) findViewById(R.id.returnToMainMenu);
        ActionBar ab = getSupportActionBar();
        ab.hide();

        this.mainMenu = findViewById(R.id.mainMenu);

        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        long userId = intent.getLongExtra("userId", 0);
        Neighbour neighbour = mApiService.getNeighbourById(userId);


        String name = neighbour.getName();
        String phone = neighbour.getPhoneNumber();
        String location = neighbour.getAddress();
        String about = neighbour.getAboutMe();


        ///AVATAR USER///
        Glide.with(this).load(neighbour.getAvatarUrl()).into(mNeighbourAvatar);

        ///NAME USER///
        TextView nameView1 = (TextView) findViewById(R.id.textView1);
        nameView1.setText(name);

        TextView nameView2 = (TextView) findViewById(R.id.textView2);
        nameView2.setText(name);

        ///LOCATION USER///
        TextView userLocation = (TextView) findViewById(R.id.user_location);
        userLocation.setText(location);

        ///PHONE USER///
        TextView phoneUser = (TextView) findViewById(R.id.phoneNumber);
        phoneUser.setText(phone);

        ///ABOUT USER///
        TextView aboutUser = (TextView) findViewById(R.id.about_user);
        aboutUser.setText(about);

    }
}