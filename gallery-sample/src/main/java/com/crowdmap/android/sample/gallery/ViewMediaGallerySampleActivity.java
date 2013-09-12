package com.mycompany.myapp;

import com.crowdmap.android.sample.gallery.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ViewMediaGallerySampleActivity extends Activity {

    TextViev
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_gallery);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
