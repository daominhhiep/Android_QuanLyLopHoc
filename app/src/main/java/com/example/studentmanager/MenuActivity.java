package com.example.studentmanager;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.studentmanager.student.StudentActivity;
import com.example.studentmanager.teacher.TeacherActivity;

public class MenuActivity extends AppCompatActivity {
    Button buttonStudentManager, buttonTeacherManager, buttonClassStudy, buttonSearchByName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        buttonTeacherManager = (Button) findViewById(R.id.teacherManager);
        buttonStudentManager = (Button) findViewById(R.id.studentManager);
        buttonClassStudy = (Button) findViewById(R.id.classStudy);
        buttonSearchByName = (Button) findViewById(R.id.searchByName);

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

        buttonClassStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MenuActivity.this, ClassActivity.class);
                MenuActivity.this.startActivity(myIntent);
            }
        });

        buttonSearchByName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MenuActivity.this, SearchActivity.class);
                MenuActivity.this.startActivity(myIntent);
            }
        });
    }
}