package com.example.nsundov.barcodescanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class HistoryActivity extends AppCompatActivity {

    HistoryFragment historyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

       // historyFragment = (HistoryFragment) getSupportFragmentManager().findFragmentById(R.id.history_fragment);
    }
}
