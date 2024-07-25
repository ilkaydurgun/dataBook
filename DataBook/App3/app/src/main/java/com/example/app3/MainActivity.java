package com.example.app3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            SQLiteDatabase database = this.openOrCreateDatabase("Database", MODE_PRIVATE, null);
            database.execSQL("Create TABLE IF NOT EXISTS weapons(name Varchar ,ammo INT ,automatic Boolean)");
            //database.execSQL("INSERT INTO weapons (name,ammo,automatic) VALUES ('AK47',47,true)");

            Cursor cursor=database.rawQuery("SELECT * FROM weapons",null);
            int nameIx= cursor.getColumnIndex("name");
            int ammoIx= cursor.getColumnIndex("ammo");
            int autoIx= cursor.getColumnIndex("automatic");
            while(cursor.moveToNext()){
                System.out.println("Name: "+ cursor.getString(nameIx));
                System.out.println("Ammo: "+ cursor.getString(ammoIx));
                System.out.println("Automatic: "+ cursor.getString(autoIx));

            }
        }
        catch (Exception e){
            e.printStackTrace();

        }
    }
}