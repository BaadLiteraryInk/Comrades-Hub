package edu.uon.comradeshub.ac.ke;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

        private String[] cardItems;

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

        @Override
        public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
            return new CardViewHolder(view);
        }

        @Override
        public void onBindViewHolder(CardViewHolder holder, int position) {
            // Set the text for each card
            holder.textView.setText(cardItems[position]);
        }

        @Override
        public int getItemCount() {
            return cardItems.length;
        }
    }


