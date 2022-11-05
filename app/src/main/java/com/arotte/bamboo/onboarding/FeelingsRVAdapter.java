
package com.arotte.bamboo.onboarding;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import com.arotte.bamboo.R;

import com.google.android.material.button.MaterialButton;

public class FeelingsRVAdapter extends RecyclerView.Adapter<FeelingsRVAdapter.ViewHolder> {

    private final List<String> data;
    private final LayoutInflater mInflater;
    private FeelingsRVAdapter.ItemClickListener mClickListener;

    // data is passed into the constructor
    public FeelingsRVAdapter(Context context, List<String> data) {
        this.mInflater = LayoutInflater.from(context);
        this.data = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public FeelingsRVAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.rv_feeling, parent, false);
        return new FeelingsRVAdapter.ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(FeelingsRVAdapter.ViewHolder holder, int position) {
        String feeling = data.get(position);

        // set recipe name
        holder.btnFeeling.setText(feeling);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return data.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        MaterialButton btnFeeling;

        ViewHolder(View itemView) {
            super(itemView);
            btnFeeling = itemView.findViewById(R.id.btnFeeling);

            // itemView.setOnClickListener(this);
            btnFeeling.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            // btnFeeling.setBackgroundColor();

            if (mClickListener != null) mClickListener.onRecItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return data.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(FeelingsRVAdapter.ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onRecItemClick(View view, int position);
    }


}
