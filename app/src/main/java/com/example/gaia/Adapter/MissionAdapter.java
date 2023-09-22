package com.example.gaia.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gaia.Home.Mission.Mission;
import com.example.gaia.R;

import java.util.List;

public class MissionAdapter extends RecyclerView.Adapter<MissionAdapter.ViewHolder> {

    private List<Mission> missions;
    private Context context;
    public MissionAdapter(List<Mission> missions) {
        //this.context = context;
        this.missions = missions;
    }
    public void updateMissions(List<Mission> newMissions) {
        missions.clear();
        missions.addAll(newMissions);
        notifyDataSetChanged();
    }
    public void setMissions(List<Mission> missions) {
        this.missions = missions;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mission mission = missions.get(position);
        String fullMissionId = mission.getUuid();
        String last6Characters = fullMissionId.substring(Math.max(0, fullMissionId.length() - 6));

        holder.missIdTextView.setText(last6Characters);
        holder.scheduledDateTextView.setText(mission.getScheduledDate());
        holder.fieldNameTextView.setText(mission.getField().getName());
        holder.fieldAreaTextView.setText(String.valueOf(mission.getField().getAreaClaimed()));
        holder.customerNameTextView.setText(mission.getCustomer().getName());
    }



    @Override
    public int getItemCount() {
        return missions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView scheduledDateTextView;
        TextView missIdTextView;

        TextView fieldNameTextView;

        TextView fieldAreaTextView, customerNameTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            scheduledDateTextView = itemView.findViewById(R.id.schedule_date); // Replace with actual view IDs
            missIdTextView = itemView.findViewById(R.id.mis_id);
            fieldNameTextView = itemView.findViewById(R.id.fieldName);
            fieldAreaTextView = itemView.findViewById(R.id.fieldArea);
            customerNameTextView = itemView.findViewById(R.id.cust_name);

            // Initialize other views here
        }
    }
}
