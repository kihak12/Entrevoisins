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


public class UserInfo extends AppCompatActivity {


    private ImageButton mainMenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        Toolbar returnToMainMenu = (Toolbar) findViewById(R.id.returnToMainMenu);
        ActionBar ab = getSupportActionBar();
        ab.hide();


        this.mainMenu = findViewById(R.id.mainMenu);

        Intent intent = getIntent();

            long userId;
            if (intent.hasExtra("userId"));
            userId = intent.getLongExtra("userId", 2);



        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mainReturn = new Intent(getApplicationContext(), ListNeighbourActivity.class);
                startActivity(mainReturn);
                finish();

            }
        });


    }


}