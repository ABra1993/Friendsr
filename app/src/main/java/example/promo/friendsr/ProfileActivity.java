package example.promo.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // finds and stores views in variable
        TextView name = findViewById(R.id.name);
        TextView quote = findViewById(R.id.quote);
        TextView episode = findViewById(R.id.episode);
        ImageView imageView = findViewById(R.id.ImageViewProfile);
        RatingBar ratingBar = findViewById(R.id.ratingBar);

        // connects listener to rating bar
        ratingBar.setOnRatingBarChangeListener(new RatingBarChangeListener());

        // retrieves information from previous activity
        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // sets retrieved information
        name.setText(retrievedFriend.getName());
        quote.setText(retrievedFriend.getBio());
        episode.setText(retrievedFriend.getEpisode());
        imageView.setImageResource(retrievedFriend.getDrawableId());

        // retrieves and sets rating from shared preferences
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        Float nameRating = prefs.getFloat(name.getText().toString(), 0);

        if (nameRating != 0) {
            ratingBar.setRating(nameRating);
        } else {
            ratingBar.setRating(0);
        }
    }

    // stores score rating bar when clicked on in shared preferences
    private class RatingBarChangeListener implements RatingBar.OnRatingBarChangeListener {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            TextView name = findViewById(R.id.name);
            SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
            editor.putFloat(name.getText().toString(), rating);
            editor.apply();
        }
    }
}
