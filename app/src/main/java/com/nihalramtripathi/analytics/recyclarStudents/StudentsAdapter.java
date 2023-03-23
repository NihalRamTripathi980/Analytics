package com.nihalramtripathi.analytics.recyclarStudents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nihalramtripathi.analytics.R;

import java.util.ArrayList;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.holder> {

    Context context;
    ArrayList<PositionModel> arrayList;

    public StudentsAdapter(Context context, ArrayList<PositionModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_student_list,parent,false);
        return new holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull holder holder, int position) {
        holder.studentName.setText(arrayList.get(position).getStudentName());
        holder.studentPosition.setText(arrayList.get(position).getStudentPosition());



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class holder extends RecyclerView.ViewHolder{
        TextView studentName , studentPosition;

        public holder(@NonNull View itemView) {

            super(itemView);

            studentName=itemView.findViewById(R.id.studentName);
            studentPosition=itemView.findViewById(R.id.studentPosition);
        }
    }
}
