package com.backdoor.impenglishdialog.Model;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.backdoor.impenglishdialog.R;
import com.backdoor.impenglishdialog.ShowSubDialogueActivity;

import java.util.ArrayList;
import java.util.List;

public class DialogueRecyclerAdapter extends RecyclerView.Adapter<DialogueRecyclerAdapter.MyViewHolder> {

    private Context mContext;
    String dialogue[],id[];


    public DialogueRecyclerAdapter(Context context, String s1[],String diaId[]) {
        mContext= context;
        dialogue = s1;
        id = diaId;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dialogue_row, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.dialogueText.setText(dialogue[position]);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ShowSubDialogueActivity.class);
                intent.putExtra("dialogueID", id[position]);
                mContext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        if (dialogue == null ) {
            return 0;
        }
        return dialogue.length;

    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView dialogueText;
        ImageView nextButton;
        LinearLayout layout;

        MyViewHolder(View itemView) {
            super(itemView);
            dialogueText = itemView.findViewById(R.id.dialogueText);
            nextButton = itemView.findViewById(R.id.nextButton);
            layout = itemView.findViewById(R.id.parentLayoutItem);
        }
    }

}
