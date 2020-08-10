package com.example.studentmanager.student;


import android.content.DialogInterface;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.studentmanager.*;
import com.example.studentmanager.commom.SortByAge;
import com.example.studentmanager.commom.SortByGpa;
import com.example.studentmanager.commom.SortByIdToDown;
import com.example.studentmanager.commom.SortByIdToUp;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentActivity extends AppCompatActivity {
    public static final String STUDENT_FILE = "student.txt";
    int index = -1;
    ListView listViewStudent;
    List<Student> listStudent;
    StudentAdapter adapter;
    Button buttonAdd, buttonEdit, buttonSort;
    EditText editTextId, editTextClass, editTextName, editTextBirth, editTextAddress, editTextGpa;
    RadioGroup groupGender;
    RadioButton checkMale, checkFemale;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        initView();
        listStudent = read();
        setAdapter();
        onCheckGender();
        onClickButtonAdd();
        onClickButtonEdit();
        onClickButtonSort();
        onClickListView();
        onLongClickListView();
    }

    private void initView() {
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonEdit = (Button) findViewById(R.id.buttonEdit);
        buttonSort = (Button) findViewById(R.id.buttonSort);
        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextClass = (EditText) findViewById(R.id.editTextClass);
        editTextBirth = (EditText) findViewById(R.id.editTextBirth);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        editTextGpa = (EditText) findViewById(R.id.editTextGpa);
        groupGender = (RadioGroup) findViewById(R.id.checkGender);
        checkMale = (RadioButton) findViewById(R.id.checkMale);
        checkFemale = (RadioButton) findViewById(R.id.checkFemale);
        listViewStudent = (ListView) findViewById(R.id.listViewStudent);
    }

    private void setAdapter() {
        adapter = new StudentAdapter(this, R.layout.row_student, listStudent);
        listViewStudent.setAdapter(adapter);
    }

    private void onCheckGender() {
        groupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.checkMale:
                        break;
                    case R.id.checkFemale:
                        break;
                }
            }
        });
    }

    private int getGender() {
        int gender = 0;
        if (checkMale.isChecked()) {
            gender = R.drawable.student_man;
        }
        if (checkFemale.isChecked()) {
            gender = R.drawable.student_woman;
        }
        return gender;
    }

    private void onClickListView() {
        listViewStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editTextId.setText(listStudent.get(i).getId());
                editTextName.setText(listStudent.get(i).getName());
                editTextBirth.setText(listStudent.get(i).getAge());
                editTextAddress.setText(listStudent.get(i).getAddress());
                editTextClass.setText(listStudent.get(i).getClassroom());
                editTextGpa.setText(listStudent.get(i).getGpa());
                index = i;
            }
        });
    }

    private void onLongClickListView() {
        listViewStudent.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                confirmDelete(i);
                return false;
            }
        });
    }

    private void confirmDelete(final int location) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông Báo");
        alertDialog.setMessage("Bạn có muốn xóa thông tin sinh viên này không?");
        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listStudent.remove(location);
                write(listStudent);
                adapter.notifyDataSetChanged();
            }
        });
        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                adapter.notifyDataSetChanged();
            }
        });
        alertDialog.show();
    }

    private void onClickButtonSort() {
        buttonSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenuSort();
            }
        });
    }

    private void showMenuSort() {
        PopupMenu popupMenu = new PopupMenu(this, buttonSort);
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.sortByIdToUp:
                        Collections.sort(listStudent, new SortByIdToUp());
                        write(listStudent);
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.sortByIdToDown:
                        Collections.sort(listStudent, new SortByIdToDown());
                        write(listStudent);
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.sortByAge:
                        Collections.sort(listStudent, new SortByAge());
                        write(listStudent);
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.sortByGpa:
                        Collections.sort(listStudent, new SortByGpa());
                        write(listStudent);
                        adapter.notifyDataSetChanged();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    public void onClickButtonAdd() {
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editTextId.getText().toString();
                String name = editTextName.getText().toString();
                String birth = editTextBirth.getText().toString();
                String address = editTextAddress.getText().toString();
                String classroom = editTextClass.getText().toString();
                String gpa = editTextGpa.getText().toString();
                int gender = getGender();
                if (id.equals("")) {
                    Toast.makeText(StudentActivity.this, "Vui lòng nhập ID", Toast.LENGTH_SHORT).show();
                } else if (name.equals("") && birth.equals("") && address.equals("")) {
                    Toast.makeText(StudentActivity.this, "Vui lòng nhập đầy đủ thông tin cá nhân", Toast.LENGTH_SHORT).show();
                } else if (gender == 0) {
                    Toast.makeText(StudentActivity.this, "Vui lòng chọn giới tính", Toast.LENGTH_SHORT).show();
                } else {
                    listStudent.add(new Student(id, name, birth, address, classroom, gpa, gender));
                    write(listStudent);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    private void onClickButtonEdit() {
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editTextId.getText().toString();
                String name = editTextName.getText().toString();
                String birth = editTextBirth.getText().toString();
                String address = editTextAddress.getText().toString();
                String classroom = editTextClass.getText().toString();
                String gpa = editTextGpa.getText().toString();
                int gender = getGender();
                if (index != -1) {
                    if (id.equals("")) {
                        Toast.makeText(StudentActivity.this, "Vui lòng nhập ID", Toast.LENGTH_SHORT).show();
                    } else if (name.equals("") && birth.equals("") && address.equals("")) {
                        Toast.makeText(StudentActivity.this, "Vui lòng nhập đầy đủ thông tin cá nhân", Toast.LENGTH_SHORT).show();
                    } else if (gender == 0) {
                        Toast.makeText(StudentActivity.this, "Vui lòng chọn giới tính", Toast.LENGTH_SHORT).show();
                    } else {
                        listStudent.add(new Student(id, name, birth, address, classroom, gpa, gender));
                        listStudent.remove(index);
                        write(listStudent);
                        adapter.notifyDataSetChanged();
                    }
                } else {
                    Toast.makeText(StudentActivity.this, "Vui lòng chọn sinh viên muốn sửa", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void write(List<Student> studentList) {
        try {
            FileOutputStream fileOutputStream = this.openFileOutput(STUDENT_FILE, MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(studentList);
            objectOutputStream.close();
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi : " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public List<Student> read() {
        List<Student> studentList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = this.openFileInput(STUDENT_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            studentList = (List<Student>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi : " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return studentList;
    }
}