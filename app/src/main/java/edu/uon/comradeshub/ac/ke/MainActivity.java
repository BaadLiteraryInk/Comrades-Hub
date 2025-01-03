package edu.uon.comradeshub.ac.ke;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    // Array of items with name and corresponding URL
    private String[] cardItems = {
            "HELB-https://portal.hef.co.ke/auth/signin",
            "Health Services-https://healthservices.uonbi.ac.ke/",
            "Smis Portal-https://smis.uonbi.ac.ke/",
            "Active Directory-http://adstudents.uonbi.ac.ke/",
            "Mtihani Platform-https://mtihani.uonbi.ac.ke",
            "UoN Library-https://uonlibrary.uonbi.ac.ke/",
            "UON Research-https://uonresearch.uonbi.ac.ke/",
            "IPMO-https://ipmo.uonbi.ac.ke/",
            "Academics-https://academics.uonbi.ac.ke/",
            "Developer -https://www.tiktok.com/@pr0fess0rbaad"
    };

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
