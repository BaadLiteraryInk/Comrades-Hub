package edu.uon.comradeshub.ac.ke;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private final String[] cardItems;

    // Constructor to pass data
    public CardAdapter(String[] cardItems) {
        this.cardItems = cardItems;
    }

    // ViewHolder class for each item
    public static class CardViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView textView;
        public ImageView imageView;

        public CardViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            textView = itemView.findViewById(R.id.cardTitle);
            imageView = itemView.findViewById(R.id.cardIcon); // ImageView for icon
        }
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardViewHolder holder, int position) {
        final String cardItem = cardItems[position];
        String[] parts = cardItem.split("-"); // Split into name and URL
        final String title = parts[0];
        final String url = parts.length > 1 ? parts[1] : null;

        holder.textView.setText(title);

        // Set the icon based on the card title
        int iconResId = getIconResourceId(title);
        if (iconResId != 0) {
            holder.imageView.setImageResource(iconResId);
        }

        holder.cardView.setOnClickListener(v -> {
            if (url != null) {
                // Create an intent to open WebViewActivity with the URL
                Intent intent = new Intent(v.getContext(), WebViewActivity.class);
                intent.putExtra("url", url);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cardItems.length;
    }

    // Helper method to get the image resource ID based on the title
    private int getIconResourceId(String title) {
        switch (title) {
            case "HELB":
                return R.drawable.helb_logo;
            case "Health Services":
                return R.drawable.healthicn;
            case "Smis Portal":
                return R.drawable.uon_logo;
            case "Active Directory":
                return R.drawable.adaccounticn;
            case "Mtihani Platform":
                return R.drawable.examicn;
            case "UoN Library":
                return R.drawable.bookshelficn;
            case "UON Research":
                return R.drawable.researchicn;
            case "IPMO":
                return R.drawable.ipicn;
            case "Academics":
                return R.drawable.academicsicn;
            case "Developer":
                return R.drawable.developericn;
            default:
                return 0; // Return 0 if no match is found (no image)
        }
    }
}
