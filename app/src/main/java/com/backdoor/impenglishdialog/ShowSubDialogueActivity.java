package com.backdoor.impenglishdialog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.backdoor.impenglishdialog.Model.SubDialogueRecyclerAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class ShowSubDialogueActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;

    private String s1[],s2[];

    private String ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_sub_dialgue);

        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }

        });

        if (getIntent().hasExtra("dialogueID")) {
            ID = getIntent().getStringExtra("dialogueID");
        }

        switch (ID) {
            case "1":
                s1 = getResources().getStringArray(R.array.subDialogue_Eng_list1);
                s2 = getResources().getStringArray(R.array.subDialogue_Ban_list1);
                break;
            case "2":
                s1 = getResources().getStringArray(R.array.subDialogue_Eng_list2);
                s2 = getResources().getStringArray(R.array.subDialogue_Ban_list2);
                break;
            default:
                Toast.makeText(this, "No Text available", Toast.LENGTH_SHORT).show();
                break;
        }

        RecyclerView recyclerView = findViewById(R.id.subDialogueRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ShowSubDialogueActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        SubDialogueRecyclerAdapter subDialogueRecyclerAdapter = new SubDialogueRecyclerAdapter(ShowSubDialogueActivity.this, s1, s2);
        recyclerView.setAdapter(subDialogueRecyclerAdapter);

    }
}