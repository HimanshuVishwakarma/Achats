package com.himanshu.achats;

import android.content.Intent;
import android.icu.text.LocaleDisplayNames;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class UserType extends AppCompatActivity {
        LinearLayout curtomer,admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_type);
        curtomer = (LinearLayout) findViewById(R.id.customer);
        admin = (LinearLayout) findViewById(R.id.admin);

        curtomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserType.this, Customer_Option_navdrawer.class);
                startActivity(intent);
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserType.this, Admin_Options.class);
                startActivity(intent);
            }
        });
    }
}
