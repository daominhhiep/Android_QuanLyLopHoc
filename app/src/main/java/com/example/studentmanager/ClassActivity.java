package com.example.studentmanager;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.studentmanager.student.StudentActivity;

public class ClassActivity extends AppCompatActivity {
    Button buttonClassJava, buttonClassPhp, buttonClassPython;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);

        buttonClassJava = (Button) findViewById(R.id.classJava);
        buttonClassPhp = (Button) findViewById(R.id.classPHP);
        buttonClassPython = (Button) findViewById(R.id.classPython);

        buttonClassJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ClassActivity.this, JavaActivity.class);
                ClassActivity.this.startActivity(myIntent);
            }
        });

        buttonClassPhp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ClassActivity.this, JavaActivity.class);
                ClassActivity.this.startActivity(myIntent);
            }
        });

        buttonClassPython.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(ClassActivity.this, JavaActivity.class);
                ClassActivity.this.startActivity(myIntent);
            }
        });

    }
}