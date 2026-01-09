package com.example.optimize_layout_xml.optimizations.recyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.optimize_layout_xml.R;
import java.util.ArrayList;
import java.util.List;

public class UnoptimizedListActivity extends AppCompatActivity {

    private LinearLayout container;
    private List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_unoptimized);

        // Enable back button in action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(R.string.unoptimized_list_layout);
        }

        container = findViewById(R.id.container);
        
        // Generate sample data
        personList = generatePersonList(1000);
        
        // Inflate and add all views manually (INEFFICIENT!)
        populateList();
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

    private void populateList() {
        LayoutInflater inflater = LayoutInflater.from(this);
        
        // Create a new view for EACH item - very inefficient!
        for (Person person : personList) {
            View itemView = inflater.inflate(R.layout.item_person_unoptimized, container, false);
            
            // findViewById called for EVERY item - slow!
            ImageView ivAvatar = itemView.findViewById(R.id.ivAvatar);
            TextView tvName = itemView.findViewById(R.id.tvName);
            TextView tvEmail = itemView.findViewById(R.id.tvEmail);
            TextView tvPhone = itemView.findViewById(R.id.tvPhone);
            
            ivAvatar.setImageResource(person.getAvatarResId());
            tvName.setText(person.getName());
            tvEmail.setText(person.getEmail());
            tvPhone.setText(person.getPhone());
            
            container.addView(itemView);
        }
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
