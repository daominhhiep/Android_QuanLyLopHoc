package com.example.studentmanager;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MenuActivity extends AppCompatActivity {
    Button buttonStudentManager, buttonTeacherManager, buttonChangePassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        buttonTeacherManager = (Button) findViewById(R.id.teacherManager);
        buttonStudentManager = (Button) findViewById(R.id.studentManager);
        buttonChangePassword = (Button) findViewById(R.id.changePass);

        buttonTeacherManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MenuActivity.this, TeacherActivity.class);
                MenuActivity.this.startActivity(myIntent);
            }
        });

        buttonStudentManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MenuActivity.this, StudentActivity.class);
                MenuActivity.this.startActivity(myIntent);
            }
        });
    }
}