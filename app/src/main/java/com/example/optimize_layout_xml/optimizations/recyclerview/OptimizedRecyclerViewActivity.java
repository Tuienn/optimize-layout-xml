package com.example.optimize_layout_xml.optimizations.recyclerview;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.optimize_layout_xml.R;
import java.util.ArrayList;
import java.util.List;

public class OptimizedRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PersonAdapter adapter;
    private List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_optimized);

        // Enable back button in action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(R.string.optimized_recyclerview_layout);
        }

        recyclerView = findViewById(R.id.recyclerView);
        
        // Generate sample data
        personList = generatePersonList(1000);
        
        // Setup RecyclerView
        setupRecyclerView();
    }

    private List<Person> generatePersonList(int count) {
        List<Person> list = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            list.add(new Person(
                "Người dùng " + i,
                "user" + i + "@example.com",
                "090123" + String.format("%04d", i),
                R.drawable.ic_person
            ));
        }
        return list;
    }

    private void setupRecyclerView() {
        // Set LayoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        
        // OPTIMIZATION: setHasFixedSize(true) - skip unnecessary layout calculations
        // Use this when item size doesn't change
        recyclerView.setHasFixedSize(true);
        
        // Set Adapter with ViewHolder pattern
        adapter = new PersonAdapter(personList);
        recyclerView.setAdapter(adapter);
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
