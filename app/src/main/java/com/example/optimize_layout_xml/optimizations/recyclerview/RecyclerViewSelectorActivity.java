package com.example.optimize_layout_xml.optimizations.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.optimize_layout_xml.R;

public class RecyclerViewSelectorActivity extends AppCompatActivity {

    private Button btnUnoptimized;
    private Button btnOptimized;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_selector);

        // Enable back button in action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        btnUnoptimized = findViewById(R.id.btnUnoptimized);
        btnOptimized = findViewById(R.id.btnOptimized);

        btnUnoptimized.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewSelectorActivity.this, UnoptimizedListActivity.class);
                startActivity(intent);
            }
        });

        btnOptimized.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerViewSelectorActivity.this, OptimizedRecyclerViewActivity.class);
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
