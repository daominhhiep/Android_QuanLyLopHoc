package com.example.studentmanager.teacher;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.studentmanager.R;


import java.util.List;

public class TeacherAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Teacher> teacherList;

    public TeacherAdapter(Context context, int layout, List<Teacher> teacherList) {
        this.context = context;
        this.layout = layout;
        this.teacherList = teacherList;
    }


    @Override
    public int getCount() {
        return teacherList.size();
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

        TextView txtIDTeacher = (TextView) view.findViewById(R.id.textViewIdTeacher);
        TextView txtNameTeacher = (TextView) view.findViewById(R.id.textViewNameTeacher);
        TextView txtAgeTeacher = (TextView) view.findViewById(R.id.textViewAgeTeacher);
        TextView txtAddressTeacher = (TextView) view.findViewById(R.id.textViewAddressTeacher);
        TextView txtRoleTeacher = (TextView) view.findViewById(R.id.textViewRoleTeacher);
        ImageView imgAvatarTeacher = (ImageView) view.findViewById(R.id.imageViewAvtTeacher);

        Teacher teacher = teacherList.get(i);

        txtIDTeacher.setText(String.valueOf(teacher.getId()));
        txtNameTeacher.setText(teacher.getName());
        txtAgeTeacher.setText(String.valueOf(teacher.getAge()));
        txtAddressTeacher.setText(teacher.getAddress());
        txtRoleTeacher.setText(String.valueOf(teacher.getRoles()));
        imgAvatarTeacher.setImageResource(teacher.getAvatarTeacher());

        return view;
    }
}