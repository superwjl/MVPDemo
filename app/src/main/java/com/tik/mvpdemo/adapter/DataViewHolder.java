package com.tik.mvpdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.tik.mvpdemo.R;


class DataViewHolder extends RecyclerView.ViewHolder {

    TextView tvTitle;
    TextView tvSource;

    DataViewHolder(View itemView) {
        super(itemView);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvSource = itemView.findViewById(R.id.tvSource);
    }
}
