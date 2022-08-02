package com.example.mareu;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mareu.Model.Reunion;
import com.example.mareu.databinding.FragmentMareuBinding;

import java.util.List;

public class MareuRecyclerViewAdapter extends RecyclerView.Adapter<MareuRecyclerViewAdapter.ViewHolder> {

    private final List<Reunion> mValues;

    public MareuRecyclerViewAdapter(List<Reunion> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentMareuBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        Reunion reunion = mValues.get(position);
        holder.mSubjectView.setText(mValues.get(position).getSubject());
        holder.mDateView.setText(mValues.get(position).getDate());
        holder.mLocationView.setText(mValues.get(position).getLocation());
        holder.mAttendeesView.setText(mValues.get(position).getAttendees());


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mSubjectView;
        private final TextView mDateView;
        private final TextView mLocationView;
        private final TextView mAttendeesView;


        public ViewHolder(FragmentMareuBinding binding) {
            super(binding.getRoot());

            mSubjectView = binding.itemListReunion;
            mDateView = binding.itemListDate;
            mLocationView = binding.itemListLocation;
            mAttendeesView = binding.itemListAttendees;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mSubjectView.getText() + "'";
        }
    }
}