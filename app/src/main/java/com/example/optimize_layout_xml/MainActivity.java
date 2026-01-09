package com.example.optimize_layout_xml;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.optimize_layout_xml.optimizations.hierarchy.HierarchySelectorActivity;
import com.example.optimize_layout_xml.optimizations.merge.MergeSelectorActivity;
import com.example.optimize_layout_xml.optimizations.overdraw.OverdrawSelectorActivity;
import com.example.optimize_layout_xml.optimizations.recyclerview.RecyclerViewSelectorActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnHierarchyOptimization;
    private Button btnMergeOptimization;
    private Button btnOverdrawOptimization;
    private Button btnRecyclerViewOptimization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHierarchyOptimization = findViewById(R.id.btnHierarchyOptimization);
        btnMergeOptimization = findViewById(R.id.btnMergeOptimization);
        btnOverdrawOptimization = findViewById(R.id.btnOverdrawOptimization);
        btnRecyclerViewOptimization = findViewById(R.id.btnRecyclerViewOptimization);

        btnHierarchyOptimization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HierarchySelectorActivity.class);
                startActivity(intent);
            }
        });

        btnMergeOptimization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MergeSelectorActivity.class);
                startActivity(intent);
            }
        });

        btnOverdrawOptimization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OverdrawSelectorActivity.class);
                startActivity(intent);
            }
        });

        btnRecyclerViewOptimization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerViewSelectorActivity.class);
                startActivity(intent);
            }
        });
    }
}
