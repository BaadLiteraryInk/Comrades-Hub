package edu.uon.comradeshub.ac.ke;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        public CardViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            textView = itemView.findViewById(R.id.cardTitle);
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
        // Set the text for each card
        final String cardItem = cardItems[position];
        String[] parts = cardItem.split("-"); // Split into name and URL
        final String title = parts[0];
        final String url = parts.length > 1 ? parts[1] : null;

        holder.textView.setText(title);

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
}
