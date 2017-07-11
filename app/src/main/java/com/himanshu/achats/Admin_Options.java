package com.himanshu.achats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Admin_Options extends AppCompatActivity {
    LinearLayout men, women, child;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__options);

        men = (LinearLayout) findViewById(R.id.men);
        women = (LinearLayout) findViewById(R.id.women);
        child = (LinearLayout) findViewById(R.id.child);


        men.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Options.this, Admin_Men.class);
                startActivity(intent);
            }
        });

        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Options.this, Admin_Women.class);
                startActivity(intent);
            }
        });

        child.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Options.this, Admin_Child.class);
                startActivity(intent);
            }
        });
    }
}
