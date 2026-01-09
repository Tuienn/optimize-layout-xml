package com.example.optimize_layout_xml.optimizations.merge;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.optimize_layout_xml.R;

public class MergeSelectorActivity extends AppCompatActivity {

    private Button btnWithoutMerge;
    private Button btnWithMerge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merge_selector);

        // Enable back button in action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        btnWithoutMerge = findViewById(R.id.btnWithoutMerge);
        btnWithMerge = findViewById(R.id.btnWithMerge);

        btnWithoutMerge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MergeSelectorActivity.this, WithoutMergeActivity.class);
                startActivity(intent);
            }
        });

        btnWithMerge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MergeSelectorActivity.this, WithMergeActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
