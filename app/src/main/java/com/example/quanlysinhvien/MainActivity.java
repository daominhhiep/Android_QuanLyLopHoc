package com.example.quanlysinhvien;

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

public class MainActivity extends AppCompatActivity {
    ListView listViewStudent;
    List<Student> listStudent;
    StudentAdapter adapter;
    Button buttonAdd, buttonEdit, buttonSort;
    EditText editTextId, editTextName, editTextBirth, editTextAddress, editTextGpa;
    private static final String simpleFileName = "note.txt";
    int location = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        list();

        adapter = new StudentAdapter(this, R.layout.row_student, listStudent);
        listViewStudent.setAdapter(adapter);

        onClickButtonAdd();
        onClickButtonEdit();
        onClickButtonSort();
        onClickListView();
        onLongClickListView();
    }

    private void confirmDelete(final int location){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Thông Báo");
        alertDialog.setMessage("Bạn có muốn xóa thông tin sinh viên này không?");
        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listStudent.remove(location);
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
                    case R.id.sortById:
                        Collections.sort(listStudent, new SortById());
                        adapter.notifyDataSetChanged();
                        break;
                    case R.id.sortByGpa:
                        Collections.sort(listStudent, new SortByGpa());
                        adapter.notifyDataSetChanged();
                        break;
                }
                return false;
            }
        });
        popupMenu.show();
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

    private void onClickButtonEdit() {
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editTextId.getText().toString();
                String name = editTextName.getText().toString();
                String birth = editTextBirth.getText().toString();
                String address = editTextAddress.getText().toString();
                String gpa = editTextGpa.getText().toString();

                listStudent.add(new Student(id, name, birth, address, gpa));
                listStudent.remove(location);
//                saveData();
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void onClickListView() {
        listViewStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                editTextId.setText(listStudent.get(i).getId());
                editTextName.setText(listStudent.get(i).getName());
                editTextBirth.setText(listStudent.get(i).getBirth());
                editTextAddress.setText(listStudent.get(i).getAddress());
                editTextGpa.setText(listStudent.get(i).getGpa());
                location = i;
            }
        });
    }

    private void onClickButtonAdd() {
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

    private void initView() {
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonEdit = (Button) findViewById(R.id.buttonEdit);
        buttonSort = (Button) findViewById(R.id.buttonSort);
        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextBirth = (EditText) findViewById(R.id.editTextBirth);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        editTextGpa = (EditText) findViewById(R.id.editTextGpa);

    }

    private void list() {
        listViewStudent = (ListView) findViewById(R.id.listViewStudent);
        listStudent = new ArrayList<>();
        listStudent.add(new Student("1", "Nguyễn Trung Hiếu", "24", "Hà Nội", "3.0", R.drawable.female));
        listStudent.add(new Student("2", "Đào Minh Hiệp", "23", "Hà Nội", " 8.5", R.drawable.batman));
        listStudent.add(new Student("3", "Nguyễn Đông Nam", "23", "Đông Anh", "6.0", R.drawable.male));
        listStudent.add(new Student("4", "Lê Đức Tâm", "28", "Hà Nội", "9.0", R.drawable.male));
    }


//    private void saveData() {
//        try {
//            FileOutputStream fileOutputStream = this.openFileOutput(simpleFileName, MODE_APPEND);
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//            objectOutputStream.writeObject(listStudent);
//            objectOutputStream.close();
//            Toast.makeText(this, "File1  saved!", Toast.LENGTH_SHORT).show();
//        } catch (Exception e) {
//            Toast.makeText(this, "Error:" + e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//    }
//
//
//    private void readData() {
//        List<Student> studentList = new ArrayList<>();
//        try {
//            FileInputStream fileInputStream = this.openFileInput(simpleFileName);
//            ObjectInputStream objectInputStream= this.(fileInputStream);
//            studentList = (List<Student>) objectInputStream.readObject();
//            objectInputStream.close();
//        } catch (Exception e) {
//            Toast.makeText(this,"Error:"+ e.getMessage(),Toast.LENGTH_SHORT).show();
//        }
//    }
}