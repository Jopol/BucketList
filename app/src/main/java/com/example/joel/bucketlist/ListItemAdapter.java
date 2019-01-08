package com.example.joel.bucketlist;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ViewHolder> {

    private List<ListItem> mListItems;
    private final ListItemCheckedListener mListItemCheckedListener;

    public ListItemAdapter(List<ListItem> mListItems, ListItemCheckedListener mListItemCheckedListener) {
        this.mListItems = mListItems;
        this.mListItemCheckedListener = mListItemCheckedListener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                parent.getContext()
        ).inflate(
                R.layout.listitem,
                parent,
                false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Gets a single item in the list from its position
        final ListItem listItem = mListItems.get(position);
        // The holder argument is used to reference the views inside the viewHolder
        // Populate the views with the data from the list
        holder.checkBox.setChecked(listItem.isCheckbox());
        holder.title.setText(listItem.getTitle());
        ifChecked(holder.checkBox, holder.title);
    }

    @Override
    public int getItemCount() {
        return mListItems.size();
    }

    public void swapList(List<ListItem> newList) {
        mListItems = newList;
        if (newList != null) {
            // Force the RecyclerView to refresh
            this.notifyDataSetChanged();
        }
    }

    public void ifChecked(CheckBox checkBox, TextView title){
        if(checkBox.isChecked()){
            title.setPaintFlags(title.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public CheckBox checkBox;
        public TextView title;


        public ViewHolder(View itemView) {
            super(itemView);
            this.checkBox = itemView.findViewById(R.id.checkBox);
            this.title = itemView.findViewById(R.id.textViewTitle);
            this.view = itemView;

            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int clickedPosition = getAdapterPosition();
                    mListItemCheckedListener.onCheckBoxChanged(
                            clickedPosition,
                            checkBox.isChecked()
                    );
                    ifChecked(checkBox, title);
                }
            });
        }
    }
}
