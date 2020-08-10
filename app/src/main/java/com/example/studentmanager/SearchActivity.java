package com.example.studentmanager;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.studentmanager.student.Student;
import com.example.studentmanager.student.StudentActivity;
import com.example.studentmanager.student.StudentAdapter;
import com.example.studentmanager.teacher.Teacher;
import com.example.studentmanager.teacher.TeacherActivity;
import com.example.studentmanager.teacher.TeacherAdapter;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchActivity extends AppCompatActivity {
    StudentAdapter adapterStudent;
    EditText editTextSearch;
    List<Student> listStudent;
    ListView listViewSearch;
    Button buttonSearchStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
        listStudent = readStudent();

        buttonSearchStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameSearch = editTextSearch.getText().toString().toLowerCase().trim();
                List<Student> listStudentSearch = searchStudent(nameSearch);
                setAdapterStudent(listStudentSearch);
                adapterStudent.notifyDataSetChanged();
            }
        });
    }

    public boolean checkKey(String key, String input) {
        key = key.toUpperCase();
        String regex = ".*" + key + ".*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input.toUpperCase());
        return matcher.matches();
    }

    public List<Student> searchStudent(String key) {
        List<Student> productsListsSearch = new ArrayList<>();
        Iterator<Student> iterator = listStudent.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (checkKey(key, student.getName())) {
                productsListsSearch.add(student);
            }
        }
        return productsListsSearch;
    }

    private void setAdapterStudent(List<Student> listStudentSearch) {
        adapterStudent = new StudentAdapter(this, R.layout.row_student, listStudentSearch);
        listViewSearch.setAdapter(adapterStudent);
    }

    private void initView() {
        listViewSearch = (ListView) findViewById(R.id.listViewSearch);
        editTextSearch = (EditText) findViewById(R.id.editTextSearchByName);
        buttonSearchStudent = (Button) findViewById(R.id.buttonSreachStudent);
    }

    private List<Student> readStudent() {
        List<Student> studentList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = this.openFileInput(StudentActivity.STUDENT_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            studentList = (List<Student>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            Toast.makeText(this, "Error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return studentList;
    }
}