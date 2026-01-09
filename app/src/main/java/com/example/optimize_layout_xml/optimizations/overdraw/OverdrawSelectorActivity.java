package com.example.optimize_layout_xml.optimizations.overdraw;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.optimize_layout_xml.R;

public class OverdrawSelectorActivity extends AppCompatActivity {

    private Button btnWithOverdraw;
    private Button btnNoOverdraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overdraw_selector);

        // Enable back button in action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        btnWithOverdraw = findViewById(R.id.btnWithOverdraw);
        btnNoOverdraw = findViewById(R.id.btnNoOverdraw);

        btnWithOverdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OverdrawSelectorActivity.this, WithOverdrawActivity.class);
                startActivity(intent);
            }
        });

        btnNoOverdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OverdrawSelectorActivity.this, NoOverdrawActivity.class);
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
