package edu.orangecoastcollege.cs273.rmillett.petprotector;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * <code>PetListActivity</code> allows the user to add an image of a pet to a list of pets
 */
public class PetListActivity extends AppCompatActivity {
    private ImageView petImageView;
    private Uri imageUri;

    // Constants for permissions
    private static final int GRANTED = PackageManager.PERMISSION_GRANTED;
    private static final int DENIED = PackageManager.PERMISSION_DENIED;

    /**
     * Creates an instance of <code>PetListActivity</code> in the view
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_list);

        // Connect to view
        petImageView = (ImageView) findViewById(R.id.petImageView);
        // Set image from URI
        petImageView.setImageURI(getUriFromResource(this, R.drawable.none));
    }

    /**
     * Checks for permissions then starts an Intent to select an image
     * @param view
     */
    public void selectPetImage(View view) {
        List<String> permsList = new ArrayList<>();

        // Check each permission individually
        int hasCameraPerm = ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA);
        if (hasCameraPerm == DENIED) {
            permsList.add(Manifest.permission.CAMERA);
        }

        int hasReadStoragePerm = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        if (hasReadStoragePerm == DENIED) {
            permsList.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }

        int hasWriteStoragePerm = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (hasWriteStoragePerm == DENIED) {
            permsList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }

        // If some permission have not been granted
        if (permsList.size() > 0) {
            // Convert permsList into an array (to pass into ActivityCompat.requestPermissions())
            String[] permsArray = new String[permsList.size()];
            permsList.toArray(permsArray);

            // Ask user for permission
            ActivityCompat.requestPermissions(this, permsArray, 42); // make up an int ID
        }

        // Check for all the permissions, then start the Image Gallery
        if (hasCameraPerm == GRANTED && hasReadStoragePerm == GRANTED && hasWriteStoragePerm == GRANTED) {
            // Open the Image Gallery
            Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            // Start activity for a result (picture)
            startActivityForResult(galleryIntent, 1); // make up an int ID
        }
    }

    /**
     * Displays a selected image in the view
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            // data = data from galleryIntent (the URI of some image)
            imageUri = data.getData();
            petImageView.setImageURI(imageUri);
        }
    }

    /**
     * Constructs the URI for a given asset
     * @param context Context of the asset
     * @param resId rId of the asset
     * @return Uri of the asset
     */
    public static Uri getUriFromResource(Context context, int resId) {
        Resources res = context.getResources();
        // Build a String in the URI form
        String uri = ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                + res.getResourcePackageName(resId) + "/"
                + res.getResourceTypeName(resId) + "/"
                + res.getResourceEntryName(resId);

        // Parse the String to construct URI
        return Uri.parse(uri);
    }
}
