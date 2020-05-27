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
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.request.RequestOptions;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;


import butterknife.BindView;


public class UserInfo extends AppCompatActivity {

    private ImageButton mainMenu;
    private NeighbourApiService mApiService;

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
        mApiService = DI.getNeighbourApiService();
        Neighbour neighbour = mApiService.getNeighbourById(userId);

        ///AVATAR USER///
        Glide.with(this)
                .load(neighbour.getAvatarUrl())
                .into(mNeighbourAvatar);

        ///NAME USER///
        TextView nameView1 = (TextView) findViewById(R.id.textView1);
        nameView1.setText(neighbour.getName());

        TextView nameView2 = (TextView) findViewById(R.id.textView2);
        nameView2.setText(neighbour.getName());

        ///LOCATION USER///
        TextView userLocation = (TextView) findViewById(R.id.user_location);
        userLocation.setText(neighbour.getAddress());

        ///PHONE USER///
        TextView phoneUser = (TextView) findViewById(R.id.user_phone);
        phoneUser.setText(neighbour.getPhoneNumber());

        ///ABOUT USER///
        TextView aboutUser = (TextView) findViewById(R.id.about_user);
        aboutUser.setText(neighbour.getAboutMe());

        if (neighbour.isFavorite() == false)
            neighbour.setFavorite(true);
        else neighbour.setFavorite(false);
    }
}