package com.example.quanlysinhvien;

import android.text.Editable;
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
    EditText editTextId, editTextName, editTextBirth, editTextAddress, editTextGpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextBirth = (EditText) findViewById(R.id.editTextBirth);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        editTextGpa = (EditText) findViewById(R.id.editTextGpa);

        findView();

        adapter = new StudentAdapter(this, R.layout.row_student, listStudent);
        listViewStudent.setAdapter(adapter);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editTextId.getText().toString();
                String name = editTextName.getText().toString();
                String birth = editTextBirth.getText().toString();
                String address = editTextAddress.getText().toString();
                String gpa = editTextGpa.getText().toString();


                listStudent.add(new Student(id, name, birth, address, gpa));
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void findView() {
        listViewStudent = (ListView) findViewById(R.id.listViewStudent);
        listStudent = new ArrayList<>();
        listStudent.add(new Student("1", "Nguyễn Trung Hiếu", "24", "Hà Nội", "3.0", R.drawable.female));
        listStudent.add(new Student("2", "Đào Minh Hiệp", "23", "Hà Nội", " 8.5", R.drawable.batman));
        listStudent.add(new Student("3", "Nguyễn Đông Nam", "23", "Đông Anh", "6.0", R.drawable.male));
        listStudent.add(new Student("4", "Lê ĐỨc Tâm", "28", "Hà Nội", "9.0", R.drawable.male));
        listStudent.add(new Student("5", "Nguyễn Đông Nam", "23", "Đông Anh", "6.0"));
    }
}