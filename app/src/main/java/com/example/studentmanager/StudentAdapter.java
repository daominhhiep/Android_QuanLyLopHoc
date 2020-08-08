package com.example.studentmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class StudentAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Student> studentList;

    public StudentAdapter(Context context, int layout, List<Student> studentList) {
        this.context = context;
        this.layout = layout;
        this.studentList = studentList;
    }


    @Override
    public int getCount() {
        return studentList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout,null);

        TextView txtID = (TextView) view.findViewById(R.id.textViewId);
        TextView txtName = (TextView) view.findViewById(R.id.textViewName);
        TextView txtAge = (TextView) view.findViewById(R.id.textViewAge);
        TextView txtAddress = (TextView) view.findViewById(R.id.textViewAddress);
        TextView txtGpa = (TextView) view.findViewById(R.id.textViewGpa);
        ImageView imgAvatar = (ImageView) view.findViewById(R.id.imageViewAvt);

        Student student = studentList.get(i);

//        String stringId  = String.valueOf(student.getId());
//        String stringAge = String.valueOf(student.getAge());
//        String stringGpa = String.valueOf(student.getGpa());

        txtID.setText(String.valueOf(student.getId()));
        txtName.setText(student.getName());
        txtAge.setText(String.valueOf(student.getAge()));
        txtAddress.setText(student.getAddress());
        txtGpa.setText(String.valueOf(student.getGpa()));
        imgAvatar.setImageResource(student.getAvatarStudent());

        return view;
    }
}