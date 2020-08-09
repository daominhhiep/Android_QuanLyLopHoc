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

public class PythonActivity extends AppCompatActivity {
    StudentAdapter adapterStudent;
    TeacherAdapter adapterTeacher;
    TextView textViewStudent, textViewTeacher;
    List<Student> listStudent;
    List<Teacher> listTeacher;
    ListView listViewPython, listViewPythonTeacher;

    List<Student> listStudentClassPython = new ArrayList<>();
    List<Teacher> listTeacherClassPython = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_python);
        initView();
        listStudent = readStudent();
        listTeacher = readTeacher();
        filterPython();
        getCount();
        setAdapter();
    }

    private void initView() {
        listViewPython = (ListView) findViewById(R.id.listViewPythonStudent);
        listViewPythonTeacher = (ListView) findViewById(R.id.listViewPythonTeacher);
        textViewTeacher = (TextView) findViewById(R.id.textViewTeacherPython);
        textViewStudent = (TextView) findViewById(R.id.textViewStudentPython);
    }

    private void setAdapter() {
        adapterStudent = new StudentAdapter(this, R.layout.row_student, listStudentClassPython);
        listViewPython.setAdapter(adapterStudent);
        adapterTeacher = new TeacherAdapter(this, R.layout.row_teacher, listTeacherClassPython);
        listViewPythonTeacher.setAdapter(adapterTeacher);
    }

    private void getCount() {
        textViewTeacher.setText("Giáo viên lớp Python: " + listTeacherClassPython.size());
        textViewStudent.setText("Học viên : " + listStudentClassPython.size());
    }

    private void filterPython() {
        for (int i = 0; i < listStudent.size(); i++)
            if (listStudent.get(i).getClassroom().toLowerCase().matches(".*python*.")) {
                listStudentClassPython.add(listStudent.get(i));
            }
        for (int i = 0; i < listTeacher.size(); i++)
            if (listTeacher.get(i).getClassroom().toLowerCase().matches(".*python*.")) {
                listTeacherClassPython.add(listTeacher.get(i));
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
