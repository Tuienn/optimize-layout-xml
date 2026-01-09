package com.example.optimize_layout_xml;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.optimize_layout_xml.optimizations.hierarchy.HierarchySelectorActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnHierarchyOptimization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHierarchyOptimization = findViewById(R.id.btnHierarchyOptimization);

        btnHierarchyOptimization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HierarchySelectorActivity.class);
                startActivity(intent);
            }
        });
    }
}
