package edu.orangecoastcollege.cs273.rmillett.petprotector;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan Millett
 * @version 1.0
 */
public class PetListAdapter extends ArrayAdapter {

    private Context mContext;
    private List<Pet> mPetsList = new ArrayList<>();
    private int mResourceId;

    public PetListAdapter(Context c, int rId, List<Pet> colleges) {
        super(c, rId, colleges);
        mContext = c;
        mResourceId = rId;
        mPetsList = colleges;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        LayoutInflater inflater =
                (LayoutInflater) mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResourceId, null);



        return view;
    }
}
