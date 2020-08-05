package com.example.quanlysinhvien;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listViewStudent;
    List<Student> listStudent;
    StudentAdapter adapter;
    Button buttonAdd;
    EditText editTextId, editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        editTextId = (EditText) findViewById(R.id.editTextId);

        findView();
        adapter = new StudentAdapter(this, R.layout.row_student, listStudent);
        listViewStudent.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String name = editTextName.getText().toString();
//                listStudent.add(new Student("name"));
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void findView() {
        listViewStudent = (ListView) findViewById(R.id.listViewStudent);
        listStudent = new ArrayList<>();
        listStudent.add(new Student(1, "Nguyễn Trung Hiếu", (byte) 24, "Hà Nội", (float) 3.0, R.drawable.female));
        listStudent.add(new Student(2, "Đào Minh Hiệp", (byte) 23, "Hà Nội", (float) 8.5, R.drawable.batman));
        listStudent.add(new Student(3, "Nguyễn Đông Nam", (byte) 23, "Đông Anh", (float) 6.0, R.drawable.male));
        listStudent.add(new Student(4, "Lê ĐỨc Tâm", (byte) 28, "Hà Nội", (float) 9.0, R.drawable.male));
        listStudent.add(new Student(5, "Nguyễn Đông Nam", (byte) 23, "Đông Anh", (float) 6.0));
        listStudent.add(new Student("Hiep"));
    }
}