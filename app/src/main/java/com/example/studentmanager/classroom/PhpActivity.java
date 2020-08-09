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

public class PhpActivity extends AppCompatActivity {
    StudentAdapter adapterStudent;
    TeacherAdapter adapterTeacher;
    TextView textViewStudent, textViewTeacher;
    List<Student> listStudent;
    List<Teacher> listTeacher;
    ListView listViewPhp, listViewPhpTeacher;

    List<Student> listStudentClassPhp = new ArrayList<>();
    List<Teacher> listTeacherClassPhp = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_php);

        initView();
        listStudent = readStudent();
        listTeacher = readTeacher();
        filterPhp();
        getCount();
        setAdapter();
    }

    private void initView() {
        listViewPhp = (ListView) findViewById(R.id.listViewPhpStudent);
        listViewPhpTeacher = (ListView) findViewById(R.id.listViewPhpTeacher);
        textViewTeacher = (TextView) findViewById(R.id.textViewTeacherPhp);
        textViewStudent = (TextView) findViewById(R.id.textViewStudentPhp);
    }

    private void setAdapter() {
        adapterStudent = new StudentAdapter(this, R.layout.row_student, listStudentClassPhp);
        listViewPhp.setAdapter(adapterStudent);
        adapterTeacher = new TeacherAdapter(this, R.layout.row_teacher, listTeacherClassPhp);
        listViewPhpTeacher.setAdapter(adapterTeacher);
    }

    private void getCount() {
        textViewTeacher.setText("Giáo viên lớp PHP: " + listTeacherClassPhp.size());
        textViewStudent.setText("Học viên : " + listStudentClassPhp.size());
    }

    private void filterPhp() {
        for (Student student : listStudent)
            if (student.getClassroom().toLowerCase().matches(".*php*.")) {
                listStudentClassPhp.add(student);
            }
        for (Teacher teacher : listTeacher)
            if (teacher.getClassroom().toLowerCase().matches(".*php*.")) {
                listTeacherClassPhp.add(teacher);
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
