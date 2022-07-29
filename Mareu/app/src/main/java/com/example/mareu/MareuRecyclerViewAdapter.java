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
        holder.mContentView.setText(mValues.get(position).getSubject());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mContentView;


        public ViewHolder(FragmentMareuBinding binding) {
            super(binding.getRoot());

            mContentView = binding.itemListName;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}