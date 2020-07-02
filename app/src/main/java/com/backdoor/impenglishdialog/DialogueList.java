package com.backdoor.impenglishdialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.backdoor.impenglishdialog.Model.DialogueRecyclerAdapter;
import com.backdoor.impenglishdialog.R;

public class DialogueList extends Fragment {

    private String s1[], id[];
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dialoges_list, container, false);

        s1 = getResources().getStringArray(R.array.dialogue_list);
        id = getResources().getStringArray(R.array.dialogue_id);

        recyclerView = v.findViewById(R.id.dialogueRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        DialogueRecyclerAdapter dialogueRecyclerAdapter = new DialogueRecyclerAdapter(getContext(),s1,id);
        recyclerView.setAdapter(dialogueRecyclerAdapter);

        return v;



    }
}