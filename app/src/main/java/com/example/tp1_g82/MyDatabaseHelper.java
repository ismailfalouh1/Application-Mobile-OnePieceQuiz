package com.example.tp1_g82;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "my_quiz.db";
    public static final int DATABASE_VERSION = 1;

    // Table name and column names
    public static final String TABLE_QUESTIONS = "questions";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_QUESTION = "question";
    public static final String COLUMN_ANSWER = "answer";

    // Create table SQL statement
    public static final String CREATE_TABLE_QUESTIONS =
            "CREATE TABLE " + TABLE_QUESTIONS + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_QUESTION + " TEXT,"
                    + COLUMN_ANSWER + " INTEGER" + ")";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create tables
        db.execSQL(CREATE_TABLE_QUESTIONS);

        // Insert sample questions
        db.execSQL("INSERT INTO " + TABLE_QUESTIONS + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ") " +
                "VALUES ('is this luffy ?', 1)");
        db.execSQL("INSERT INTO " + TABLE_QUESTIONS + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ") " +
                "VALUES ('is this zoro ?', 1)");
        db.execSQL("INSERT INTO " + TABLE_QUESTIONS + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ") " +
                "VALUES ('is this sanji ?', 1)");
        db.execSQL("INSERT INTO " + TABLE_QUESTIONS + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ") " +
                "VALUES ('is this tetch ?', 0)");
        db.execSQL("INSERT INTO " + TABLE_QUESTIONS + " (" + COLUMN_QUESTION + ", " + COLUMN_ANSWER + ") " +
                "VALUES ('is this ace ?', 0)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTIONS);

        // Create tables again
        onCreate(db);
    }
}

