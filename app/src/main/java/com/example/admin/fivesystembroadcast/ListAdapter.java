package com.example.admin.fivesystembroadcast;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    ArrayList<ListObject> randomList = new ArrayList<>();
    Context context;

    public ListAdapter(ArrayList<ListObject> randomList) {
        this.randomList = randomList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvText1,tvText2,tvText3;
        ImageView ivImage;

        public ViewHolder(View itemView) {
            super(itemView);

            tvText1 = (TextView) itemView.findViewById(R.id.tvText1);
            tvText2 = (TextView) itemView.findViewById(R.id.tvText2);
            tvText3 = (TextView) itemView.findViewById(R.id.tvText3);
            ivImage= (ImageView) itemView.findViewById(R.id.ivImage);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    private int lastPosition = -1;
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        if(position > lastPosition){
        }
        final ListObject randoms = randomList.get(position);
        holder.tvText1.setText(""+randoms.getRandom1());
        holder.tvText2.setText(""+randoms.getRandom2());
        holder.tvText3.setText(""+randoms.getRandom3());
        holder.ivImage.setImageResource(randoms.getRandom4());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(context, AlarmService.class);
                myIntent.putExtra("element",randoms.getRandom1()+" "+randoms.getRandom2());
                PendingIntent pendingIntent = PendingIntent.getService(context, 0, myIntent, 0);
                AlarmManager alarmManager = (AlarmManager)context.getSystemService(ALARM_SERVICE);
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.add(Calendar.SECOND, 1);
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return randomList.size();
    }
}
