package edu.uon.comradeshub.ac.ke;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private String[] cardItems = {
            "HELB","Health Services","Smis Portal","Active Directory",
            "Mtihani Plartform","UoN-Library","UON-Research",
            "IPMO","Academics","Developer"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Set GridLayoutManager with 2 columns
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // Set Adapter
        CardAdapter adapter = new CardAdapter(cardItems);
        recyclerView.setAdapter(adapter);
    }
}
