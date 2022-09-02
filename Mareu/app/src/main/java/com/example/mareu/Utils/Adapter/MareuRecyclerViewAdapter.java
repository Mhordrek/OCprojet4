
package com.example.mareu.Utils.Adapter;

import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mareu.Model.Reunion;
import com.example.mareu.R;
import com.example.mareu.Utils.Event.DeleteReunionEvent;
import com.example.mareu.databinding.RowReunionBinding;


import org.greenrobot.eventbus.EventBus;

import java.util.List;

public class MareuRecyclerViewAdapter extends RecyclerView.Adapter<MareuRecyclerViewAdapter.ViewHolder> {

    private List<Reunion> mReunions;


    public MareuRecyclerViewAdapter(List<Reunion> items) {
        mReunions = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(RowReunionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {


        Reunion reunion = mReunions.get(position);
        Log.d("Test", "Location: " + reunion.getLocation());

        switch (reunion.getLocation()) {

            case "Mario":
                holder.mAvatarView.setImageResource(R.drawable.red_circle);
                break;

            case "Luigi":
                holder.mAvatarView.setImageResource(R.drawable.green_circle);
                break;

            case "Peach":
                holder.mAvatarView.setImageResource(R.drawable.salmon_circle);
                break;

            case "Browser":
                holder.mAvatarView.setImageResource(R.drawable.purple_circle);
                break;

        }


        holder.mSubjectView.setText(reunion.getSubject() + " -");
        holder.mDateView.setText(reunion.getDate() + " -");
        holder.mLocationView.setText(reunion.getLocation());
        holder.mAttendeesView.setText(reunion.getAttendees());
        holder.mDeleteView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EventBus.getDefault().post(new DeleteReunionEvent(reunion));


            }
        });


    }


    @Override
    public int getItemCount() {
        return mReunions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final ImageView mAvatarView;
        public final TextView mSubjectView;
        private final TextView mDateView;
        private final TextView mLocationView;
        private final TextView mAttendeesView;
        public final ImageButton mDeleteView;


        public ViewHolder(RowReunionBinding binding) {
            super(binding.getRoot());

            mAvatarView = binding.itemListAvatar;
            mSubjectView = binding.itemListReunion;
            mDateView = binding.itemListDate;
            mLocationView = binding.itemListLocation;
            mAttendeesView = binding.itemListAttendees;
            mDeleteView = binding.itemListDeleteButton;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mSubjectView.getText() + "'";
        }
    }
}