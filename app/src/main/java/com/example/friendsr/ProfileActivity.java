/*
*
* if a profile is clickt this function loads the data and saves the rating in SharedPreferences.
 */

package com.example.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {
    private Friend retrievedFriend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Intent intent = getIntent();
        this.retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        TextView Name = findViewById(R.id.name);
        TextView Bio = findViewById(R.id.bio);
        ImageView avatar =findViewById(R.id.avatar);
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        Name.setText(retrievedFriend.getName());
        Bio.setText(retrievedFriend.getBio());
        avatar.setImageResource(retrievedFriend.getDrawableId());

        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        ratingBar.setRating(prefs.getFloat(retrievedFriend.getName(), 0));

        ratingBar.setOnRatingBarChangeListener(new SetRating());

    }

    private class SetRating implements RatingBar.OnRatingBarChangeListener {
        SharedPreferences.Editor editor;
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean user) {
            editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            editor.putFloat(retrievedFriend.getName(), rating).apply();
        }
    }
}

