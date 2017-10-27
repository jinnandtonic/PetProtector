package edu.orangecoastcollege.cs273.rmillett.petprotector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import java.util.ArrayList;

/**
 * @author Ryan Millett
 * @version 1.0
 */
public class DBHelper extends SQLiteOpenHelper {

    //TASK 1: DEFINE THE DATABASE VERSION, NAME AND TABLE NAME
    static final String DATABASE_NAME = "PetProtector";
    private static final String DATABASE_TABLE = "Pets";
    private static final int DATABASE_VERSION = 1;


    //TASK 2: DEFINE THE FIELDS (COLUMN NAMES) FOR THE TABLE
    private static final String KEY_FIELD_ID = "id";
    private static final String FIELD_NAME = "name";
    private static final String FIELD_DETAILS = "details";
    private static final String FIELD_PHONE = "phone";
    private static final String FIELD_IMAGE_URI = "image_URI";

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    /**
     * Creates a new table in the PetProtector database
     * @param database
     */
    @Override
    public void onCreate (SQLiteDatabase database){

        // create the database
        String table = "CREATE TABLE " + DATABASE_TABLE
                + "("
                + KEY_FIELD_ID + " INTEGER PRIMARY KEY,"
                + FIELD_NAME + " TEXT,"
                + FIELD_DETAILS + " TEXT,"
                + FIELD_PHONE + " TEXT,"
                + FIELD_IMAGE_URI + " TEXT,"
                + ")";
        database.execSQL(table);
    }

    /**
     * Drops the previous table and creates a new one
     * @param database
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase database,
                          int oldVersion,
                          int newVersion) {

        database.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);
        onCreate(database);
    }

    /**
     * Adds a <code>Pet</code> object to the database
     * @param pet a <code>Pet</code> objected to be added to the database
     */
    public void addPet(Pet pet) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // add a College to the database
        values.put(FIELD_NAME, pet.getName());
        values.put(FIELD_DETAILS, pet.getDetails());
        values.put(FIELD_PHONE, pet.getPhone());
        values.put(FIELD_IMAGE_URI, pet.getImageURI().toString());

        db.close();
    }

    /**
     * Returns a list of all <code>Pet</code> objects
     * @return a list of all <code>Pet</code> objects
     */
    public ArrayList<Pet> getAllPets() {
        ArrayList<Pet> petList = new ArrayList<>();
        SQLiteDatabase database = this.getReadableDatabase();

        // get all the colleges from the database.
        Cursor cursor = database.query(DATABASE_TABLE,
                new String[]
                        {
                                KEY_FIELD_ID,
                                FIELD_NAME,
                                FIELD_DETAILS,
                                FIELD_PHONE,
                                FIELD_IMAGE_URI
                        },
                null, null, null, null, null);

        if (cursor.moveToFirst())
        {
            do
            {
                Pet college = new Pet
                        (
                                cursor.getInt(0),
                                cursor.getString(1),
                                cursor.getString(2),
                                cursor.getString(3),
                                Uri.parse(cursor.getString(4))
                        );
                petList.add(college);
            } while (cursor.moveToNext());
        }
        cursor.close();
        database.close();

        return petList;
    }
}
