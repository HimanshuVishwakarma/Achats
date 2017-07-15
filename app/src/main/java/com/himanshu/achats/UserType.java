package com.himanshu.achats;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.LocaleDisplayNames;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
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

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);

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
                final EditText edittext = new EditText(UserType.this);
                // edittext.setTransformationMethod(PasswordTransformationMethod.getInstance());
                edittext.setInputType(InputType.TYPE_CLASS_TEXT |
                        InputType.TYPE_TEXT_VARIATION_PASSWORD);
                edittext.setSelection(edittext.getText().length());
                alert.setMessage("Only Authorised Person");
                alert.setTitle("PASSWORD");

                alert.setView(edittext);

                alert.setPositiveButton("ENTER", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        String YouEditTextValue = edittext.getText().toString();
                        if(YouEditTextValue.equals("admin7")){
                            Intent intent = new Intent(UserType.this, Admin_Options.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(UserType.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                alert.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // what ever you want to do with No option.
                    }
                });

                alert.show();


            }
        });
    }
}
