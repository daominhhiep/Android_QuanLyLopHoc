package com.example.studentmanager.classroom;

import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.studentmanager.R;
import com.example.studentmanager.student.Student;
import com.example.studentmanager.student.StudentActivity;
import com.example.studentmanager.student.StudentAdapter;
import com.example.studentmanager.teacher.Teacher;
import com.example.studentmanager.teacher.TeacherActivity;
import com.example.studentmanager.teacher.TeacherAdapter;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class JavaActivity extends AppCompatActivity {
    StudentAdapter adapterStudent;
    TeacherAdapter adapterTeacher;
    TextView textViewStudent, textViewTeacher;
    List<Student> listStudent;
    List<Teacher> listTeacher;
    ListView listViewJava, listViewJavaTeacher;

    List<Student> listStudentClassJava = new ArrayList<>();
    List<Teacher> listTeacherClassJava = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java);
        initView();
        listStudent = readStudent();
        listTeacher = readTeacher();
        filterJava();
        getCount();
        setAdapter();
    }

    private void initView() {
        listViewJava = (ListView) findViewById(R.id.listViewJavaStudent);
        listViewJavaTeacher = (ListView) findViewById(R.id.listViewJavaTeacher);
        textViewTeacher = (TextView) findViewById(R.id.textViewTeacherJava);
        textViewStudent = (TextView) findViewById(R.id.textViewStudentJava);
    }

    private void setAdapter() {
        adapterStudent = new StudentAdapter(this, R.layout.row_student, listStudentClassJava);
        listViewJava.setAdapter(adapterStudent);
        adapterTeacher = new TeacherAdapter(this, R.layout.row_teacher, listTeacherClassJava);
        listViewJavaTeacher.setAdapter(adapterTeacher);
    }

    private void getCount() {
        textViewTeacher.setText("Giáo viên lớp Java: " + listTeacherClassJava.size());
        textViewStudent.setText("Học viên : " + listStudentClassJava.size());
    }

    private void filterJava() {
        for (Student student : listStudent)
            if (student.getClassroom().toLowerCase().matches(".*java*.")) {
                listStudentClassJava.add(student);
            }
        for (Teacher teacher : listTeacher)
            if (teacher.getClassroom().toLowerCase().matches(".*java*.")) {
                listTeacherClassJava.add(teacher);
            }
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

    private List<Teacher> readTeacher() {
        List<Teacher> teacherList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = this.openFileInput(TeacherActivity.TEACHER_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            teacherList = (List<Teacher>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            Toast.makeText(this, "Error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return teacherList;
    }
}