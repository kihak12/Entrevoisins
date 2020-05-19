package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toolbar;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;
import com.openclassrooms.entrevoisins.service.DummyNeighbourApiService;

import java.util.ArrayList;
import java.util.List;


public class UserInfo extends AppCompatActivity {


    private ImageButton mainMenu;
    private NeighbourApiService mApiService;

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
        mApiService.getNeighbourById(userId);



        //String name = mNeighbours.toString();
        String name = "Jeff";

        TextView nameView1 = (TextView) findViewById(R.id.textView1);
        nameView1.setText(name);

        TextView nameView2 = (TextView) findViewById(R.id.textView2);
        nameView2.setText(name);





    }
}