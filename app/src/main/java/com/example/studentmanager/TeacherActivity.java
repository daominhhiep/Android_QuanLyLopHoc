package com.example.studentmanager;

import android.content.DialogInterface;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeacherActivity extends AppCompatActivity {
    private static final String TEACHER_FILE = "teacher.txt";
    int index = -1;
    ListView lisViewTeacher;
    List<Teacher> teacherList;
    TeacherAdapter adapter;
    Button buttonAdd, buttonEdit, buttonSort;
    EditText editTextId, editTextName, editTextBirth, editTextAddress, editTextRole;
    RadioGroup groupGender;
    RadioButton checkMale, checkFemale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        initView();
        teacherList = read();
        adapter = new TeacherAdapter(this, R.layout.row_teacher, teacherList);
        lisViewTeacher.setAdapter(adapter);

        onCheckGender();
        onClickButtonAdd();
        onClickButtonEdit();
        onClickButtonSort();
        onClickListView();
        onLongClickListView();
    }

    private void onCheckGender() {
        groupGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.checkMaleTeacher:
                        break;
                    case R.id.checkFemaleTeacher:
                        break;
                }
            }
        });
    }

    private int getGender() {
        int gender = 0;
        if (checkMale.isChecked()) {
            gender = R.drawable.teacher_man;
        }
        if (checkFemale.isChecked()) {
            gender = R.drawable.teacher_woman;
        }
        return gender;
    }

    private void onClickListView() {
        lisViewTeacher.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editTextId.setText(teacherList.get(i).getId());
                editTextName.setText(teacherList.get(i).getName());
                editTextBirth.setText(teacherList.get(i).getAge());
                editTextAddress.setText(teacherList.get(i).getAddress());
                editTextRole.setText(teacherList.get(i).getRoles());
                index = i;
            }
        });
    }

    private void onLongClickListView() {
        lisViewTeacher.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
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
        alertDialog.setMessage("Bạn có muốn xóa thông tin giáo viên này không?");
        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                teacherList.remove(location);
                write(teacherList);
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
        popupMenu.getMenuInflater().inflate(R.menu.menu_popup2, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.sortById:
                        Collections.sort(teacherList, new SortById());
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.sortByAge:
                        Collections.sort(teacherList, new SortByAge());
                        adapter.notifyDataSetChanged();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
    }

    private void onClickButtonAdd() {
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editTextId.getText().toString();
                String name = editTextName.getText().toString();
                String age = editTextBirth.getText().toString();
                String address = editTextAddress.getText().toString();
                String role = editTextRole.getText().toString();
                int gender = getGender();
                teacherList.add(new Teacher(id, name, age, address, role, gender));
                write(teacherList);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void onClickButtonEdit() {
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editTextId.getText().toString();
                String name = editTextName.getText().toString();
                String age = editTextBirth.getText().toString();
                String address = editTextAddress.getText().toString();
                String role = editTextRole.getText().toString();
                int gender = getGender();
                teacherList.add(new Teacher(id, name, age, address, role, gender));
                teacherList.remove(index);
                write(teacherList);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void initView() {
        buttonAdd = (Button) findViewById(R.id.buttonAddTeacher);
        buttonEdit = (Button) findViewById(R.id.buttonEditTeacher);
        buttonSort = (Button) findViewById(R.id.buttonSortTeacher);
        editTextId = (EditText) findViewById(R.id.editTextIdTeacher);
        editTextName = (EditText) findViewById(R.id.editTextNameTeacher);
        editTextBirth = (EditText) findViewById(R.id.editTextBirthTeacher);
        editTextAddress = (EditText) findViewById(R.id.editTextAddressTeacher);
        editTextRole = (EditText) findViewById(R.id.editTextRoleTeacher);
        groupGender = (RadioGroup) findViewById(R.id.checkGenderTeacher);
        checkMale = (RadioButton) findViewById(R.id.checkMaleTeacher);
        checkFemale = (RadioButton) findViewById(R.id.checkFemaleTeacher);
        lisViewTeacher = (ListView) findViewById(R.id.listViewTeacher);
    }

    private void write(List<Teacher> teacherList) {
        try {
            FileOutputStream fileOutputStream = this.openFileOutput(TEACHER_FILE, MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(teacherList);
            objectOutputStream.close();
        } catch (Exception e) {
            Toast.makeText(this, "Error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private List<Teacher> read() {
        List<Teacher> teacherList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = this.openFileInput(TEACHER_FILE);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            teacherList = (List<Teacher>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            Toast.makeText(this, "Error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return teacherList;
    }
}