package edu.orangecoastcollege.cs273.rmillett.petprotector;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author Ryan Millett
 * @version 1.0
 */
public class PetDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_details);

        ImageView petDetailsImageView = (ImageView) findViewById(R.id.petDetailsImageView);
        TextView petDetailsNameTextView = (TextView) findViewById(R.id.petDetailsNameTextView);
        TextView petDetailsDetailsTextView = (TextView) findViewById(R.id.petDetailsDetailsTextView);
        TextView petDetailsPhoneTextView = (TextView) findViewById(R.id.petDetailsPhoneTextView);

        Intent detailsIntent = getIntent();
        Uri imageURI = Uri.parse(detailsIntent.getStringExtra("ImageURI"));
        String name = detailsIntent.getStringExtra("Name");
        String details = detailsIntent.getStringExtra("Details");
        String phone = detailsIntent.getStringExtra("Phone");

        petDetailsImageView.setImageURI(imageURI);
        petDetailsNameTextView.setText(name);
        petDetailsDetailsTextView.setText(details);
        petDetailsPhoneTextView.setText(phone);

    }
}
