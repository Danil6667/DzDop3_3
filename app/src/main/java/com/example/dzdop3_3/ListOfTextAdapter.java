package com.example.dzdop3_3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListOfTextAdapter extends RecyclerView.Adapter<ListOfTextAdapter.TextViewHolder> {

    private List<String> listOfText;

    public void setData(List<String> listOfText) {
        this.listOfText = listOfText;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TextViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TextViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_first, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TextViewHolder holder, int position) {
        holder.onBind(listOfText.get(position));
    }

    @Override
    public int getItemCount() {
        return listOfText.size();
    }

    public class TextViewHolder extends RecyclerView.ViewHolder {

        private TextView tvText;

        public TextViewHolder(@NonNull View itemView) {
            super(itemView);
            tvText = itemView.findViewById(R.id.tv_item);
        }

        public void onBind(String addText) {
            tvText.setText(addText);
        }
    }
}
