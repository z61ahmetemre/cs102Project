package com.example.ahmet.billib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ahmet on 22.07.2017.
 */

public class BookViewAcivity extends AppCompatActivity
{
    //DB db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    public BookListItem find(Book b)
    {
        return null;
    }
}
