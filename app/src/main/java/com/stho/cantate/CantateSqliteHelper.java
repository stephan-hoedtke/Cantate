package com.stho.cantate;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.util.Output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CantateSqliteHelper extends SQLiteOpenHelper {

    private final static String DATABASE_NAME = "cantatas.sqlite";
    private final static int DATABASE_VERSION = 2;
    private final static String ASSETS_PATH = "databases";
    private final Context context;
    private SharedPreferences preferences;

    public CantateSqliteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
        this.preferences = context.getSharedPreferences(context.getPackageName() + "database_versions", Context.MODE_PRIVATE);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Nothing to do
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Nothing to do
    }

    synchronized
    private void installOrUpdateIfNecessary() {
        if (installedDatabaseIsOutdated()) {
            context.deleteDatabase(DATABASE_NAME);
            installDatabaseFromAssets();
            writeDatabaseVersionInPreferences();
        }
    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        throw new RuntimeException(String.format("The %s database is not writable.", DATABASE_NAME));
    }

    @Override
    public SQLiteDatabase getReadableDatabase() {
        installOrUpdateIfNecessary();
        return super.getReadableDatabase();
    }

    private boolean installedDatabaseIsOutdated() {
        return preferences.getInt(DATABASE_NAME, 0) < DATABASE_VERSION;
    }

    private void writeDatabaseVersionInPreferences() {
        preferences.edit()
                .putInt(DATABASE_NAME, DATABASE_VERSION)
                .apply();
    }

    private void installDatabaseFromAssets() {

        try {
            String fileName = String.format("%s/%s", ASSETS_PATH, DATABASE_NAME);
            InputStream inputStream = context.getAssets().open(fileName);

            File outputFile = new File(context.getDatabasePath(DATABASE_NAME).getPath());
            OutputStream outputStream = new FileOutputStream(outputFile);

            byte[] buffer = new byte[inputStream.available()];
            int length = inputStream.read(buffer);
            outputStream.write(buffer, 0, length);

            inputStream.close();
            outputStream.flush();
            outputStream.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException(String.format("The %s database couldn't be installed.", DATABASE_NAME), ex);
        }
    }
}
