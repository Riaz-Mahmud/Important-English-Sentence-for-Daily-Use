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
import com.backdoor.impenglishdialog.showClickDialogueActivity;

public class SubDialogueRecyclerAdapter extends RecyclerView.Adapter<SubDialogueRecyclerAdapter.MyViewHolder> {

    private Context mContext;
    String dialogueEng[];
    String dialogueBan[];


    public SubDialogueRecyclerAdapter(Context context, String s1[], String s2[]) {
        mContext = context;
        dialogueEng = s1;
        dialogueBan = s2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sub_dialogue_row, parent, false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.dialogueTextEng.setText(dialogueEng[position]);
        holder.dialogueTextBan.setText(dialogueBan[position]);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, showClickDialogueActivity.class);
                intent.putExtra("dialogueEnd", dialogueEng[position]);
                intent.putExtra("dialogueBan", dialogueBan[position]);
                mContext.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        if (dialogueEng == null && dialogueBan == null) {
            return 0;
        } else {
            return dialogueEng.length;
        }

    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView dialogueTextEng, dialogueTextBan;
        ImageView nextButton;
        LinearLayout layout;

        MyViewHolder(View itemView) {
            super(itemView);
            dialogueTextEng = itemView.findViewById(R.id.subDialogueEng);
            dialogueTextBan = itemView.findViewById(R.id.subDialogueBan);
            nextButton = itemView.findViewById(R.id.subDialogueNext);
            layout = itemView.findViewById(R.id.SubParentLayoutItem);
        }
    }

}
