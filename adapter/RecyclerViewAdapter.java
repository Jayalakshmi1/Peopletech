package com.example.peopeletech.adapter;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.databinding.DataBindingUtil;
import com.example.peopeletech.model.Info;
import com.example.peopeletech.R;
import com.example.peopeletech.databinding.RecyclerViewListRowBinding;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Info.Row> data;

    @Inject
    public RecyclerViewAdapter() {
        data = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        RecyclerViewListRowBinding listItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.recycler_view_list_row, viewGroup, false);
        return new ViewHolder(listItemBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Info.Row row = data.get(position);
        holder.listItemBinding.setFeed(row);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private RecyclerViewListRowBinding listItemBinding;

        public ViewHolder(@NonNull RecyclerViewListRowBinding listItemBinding) {
            super(listItemBinding.getRoot());

            this.listItemBinding = listItemBinding;
        }
    }

    public void setData(List<Info.Row> data) {
        this.data.addAll(data);
        notifyDataSetChanged();
    }
}
