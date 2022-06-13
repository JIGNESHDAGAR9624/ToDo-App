package com.example.todoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;

import io.realm.RealmResults;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    Context context;

    public MyAdapter(Context context, RealmResults<Note> noteList) {
        this.context = context;
        this.noteList = noteList;
    }

    RealmResults<Note> noteList;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.item_view,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Note note = noteList.get(position);
        holder.titleOutput.setText(note.getTitle());
        holder.descriptionoutput.setText(note.getDescription());

        String formatedTime = DateFormat.getDateTimeInstance().format(note.createdTime);
        holder.timeoutput.setText(formatedTime);

    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleOutput, timeoutput,descriptionoutput;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleOutput =itemView.findViewById(R.id.titleoutput);
            timeoutput = itemView.findViewById(R.id.timeoutput);
            descriptionoutput = itemView.findViewById(R.id.descriptionoutput);
        }
    }
}
