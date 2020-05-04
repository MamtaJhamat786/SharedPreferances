package com.example.preferancesandrecycleview;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class RecyclerViewFibonacciAdapter extends RecyclerView.Adapter<RecyclerViewFibonacciAdapter.FibonacciViewHolder> {

    private ArrayList<Long> list;

    public RecyclerViewFibonacciAdapter(ArrayList<Long> fibonacciList) {
        this.list = fibonacciList;
    }

    @NonNull
    @Override
    public FibonacciViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Context context;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View lineView = inflater.inflate(R.layout.recycler_row, parent, false);
        return new FibonacciViewHolder(lineView);
    }

    @Override
    public void onBindViewHolder(@NonNull FibonacciViewHolder holder, int position) {
        holder.lineText.setText("" + (position + 1) + ".   " + list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class FibonacciViewHolder extends RecyclerView.ViewHolder {
        TextView lineText;
        public FibonacciViewHolder(@NonNull View itemView) {
            super(itemView);
            this.lineText = itemView.findViewById(R.id.tv_line_recycler);
        }
    }
}
