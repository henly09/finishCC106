package com.hcdc.cc106_finalproject_montera;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnotherDataAdapter extends RecyclerView.Adapter<AnotherDataAdapter.ViewHolder> {

    Context context;
    ArrayList arrayses;
    ArrayList arraycal;
    ArrayList arraystep;
    ArrayList arraydis;
    ArrayList arraydate;
    ArrayList arraydur;

    public AnotherDataAdapter(Context context, ArrayList arrayses, ArrayList arraycal, ArrayList arraystep, ArrayList arraydis, ArrayList arraydate, ArrayList arraydur) {
        this.context = context;
        this.arrayses = arrayses;
        this.arraycal = arraycal;
        this.arraystep = arraystep;
        this.arraydis = arraydis;
        this.arraydate = arraydate;
        this.arraydur = arraydur;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView session,cal,steps,distance,date,duration;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            session = itemView.findViewById(R.id.sessioniddisplay);
            cal = itemView.findViewById(R.id.calburndisplay);
            steps = itemView.findViewById(R.id.stepcountdisplay);
            distance = itemView.findViewById(R.id.distancedisplay);
            date = itemView.findViewById(R.id.datedisplay);
            duration = itemView.findViewById(R.id.durationdisplay);
        }
    }


    @NonNull
    @Override
    public AnotherDataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.data_adapt,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AnotherDataAdapter.ViewHolder holder, int position) {
        holder.session.setText(String.valueOf(arrayses.get(position)));
        holder.cal.setText(String.valueOf(arraycal.get(position)));
        holder.steps.setText(String.valueOf(arraystep.get(position)));
        holder.distance.setText(String.valueOf(arraydis.get(position)));
        holder.date.setText(String.valueOf(arraydate.get(position)));
        holder.duration.setText(String.valueOf(arraydur.get(position)));
    }

    @Override
    public int getItemCount() {
        return arrayses.size();
    }


}
