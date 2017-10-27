package edu.orangecoastcollege.cs273.rmillett.petprotector;

import android.net.Uri;

/**
 * The <code>Pet</code> class models Pet objects which are added to a database of
 * <code>Pet</code> objects
 * @author Ryan Millett
 * @version 1.0
 */
public class Pet {

    private int mId;
    private String mName;
    private String mDetails;
    private String mPhone;
    private Uri mImageURI;

    /**
     * Full constructor for the <code>Pet</code> class
     * @param id Unique ID
     * @param name Name of the pet
     * @param details A brief description of the pet
     * @param phone Owner's phone number
     * @param imageURI URI of an image depicting the pet
     */
    public Pet(int id, String name, String details, String phone, Uri imageURI) {
        mId = id;
        mName = name;
        mDetails = details;
        mPhone = phone;
        mImageURI = imageURI;
    }

    /**
     * Partial constructor for the <code>Pet</code> class
     * @param name Name of the pet
     * @param details A brief description of the pet
     * @param phone Owner's phone number
     * @param imageURI URI of an image depicting the pet
     */
    public Pet(String name, String details, String phone, Uri imageURI) {
        mName = name;
        mDetails = details;
        mPhone = phone;
        mImageURI = imageURI;
    }

    /**
     * Gets the unique ID of a <code>Pet</code> object
     * @return an int representing the unique ID of a <code>Pet</code> object
     */
    public int getId() {
        return mId;
    }

    /**
     * Gets the name of a <code>Pet</code> object
     * @return a String representing the name of a <code>Pet</code> object
     */
    public String getName() {
        return mName;
    }

    /**
     * Sets the name of a <code>Pet</code> object
     * @param name a String representing the name of a <code>Pet</code> object
     */
    public void setName(String name) {
        mName = name;
    }

    /**
     * Gets the details of a <code>Pet</code> object
     * @return a String representing a <code>Pet</code> object
     */
    public String getDetails() {
        return mDetails;
    }

    /**
     * Sets the details of a <code>Pet</code> object
     * @param details a String representing the details of a <code>Pet</code> object
     */
    public void setDetails(String details) {
        mDetails = details;
    }

    /**
     * Gets the phone number of a <code>Pet</code> object
     * @return a String representing the phone number of a <code>Pet</code> object
     */
    public String getPhone() {
        return mPhone;
    }

    /**
     * Sets the phone number of a <code>Pet</code> object
     * @param phone a String representing the phone number of <code>Pet</code> object
     */
    public void setPhone(String phone) {
        mPhone = phone;
    }

    /**
     * Gets the URI of a <code>Pet</code> object
     * @return the URI of a <code>Pet</code> object
     */
    public Uri getImageURI() {
        return mImageURI;
    }

    /**
     * Sets the URI of a <code>Pet</code> object
     * @param imageURI the URI of a <code>Pet</code> object
     */
    public void setImageURI(Uri imageURI) {
        mImageURI = imageURI;
    }

    /**
     * Compares two <code>Pet</code> objects based on parameters
     * @param o <code>Pet</code> object
     * @return Truth value indicating whether or not two <code>Pet</code> objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        if (mId != pet.mId) return false;
        if (mName != null ? !mName.equals(pet.mName) : pet.mName != null) return false;
        if (mDetails != null ? !mDetails.equals(pet.mDetails) : pet.mDetails != null) return false;
        if (mPhone != null ? !mPhone.equals(pet.mPhone) : pet.mPhone != null) return false;
        return mImageURI != null ? mImageURI.equals(pet.mImageURI) : pet.mImageURI == null;
    }

    /**
     * Generates a unique hash code for a <code>Pet</code> object
     * @return int representing a unique hash code for a <code>Pet</code> object
     */
    @Override
    public int hashCode() {
        int result = mId;
        result = 31 * result + (mName != null ? mName.hashCode() : 0);
        result = 31 * result + (mDetails != null ? mDetails.hashCode() : 0);
        result = 31 * result + (mPhone != null ? mPhone.hashCode() : 0);
        result = 31 * result + (mImageURI != null ? mImageURI.hashCode() : 0);
        return result;
    }

    /**
     * Generates a string displaying the values of a <code>Pet</code> object's member variables
     * @return
     */
    @Override
    public String toString() {
        return "Pet{" +
                "Id=" + mId +
                ", Name='" + mName + '\'' +
                ", Details='" + mDetails + '\'' +
                ", Phone='" + mPhone + '\'' +
                ", ImageURI=" + mImageURI +
                '}';
    }
}
