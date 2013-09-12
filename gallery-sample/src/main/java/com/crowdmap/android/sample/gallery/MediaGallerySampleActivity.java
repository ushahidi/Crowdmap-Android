package com.crowdmap.android.sample.gallery;

import com.crowdmap.java.sdk.CrowdmapException;
import com.crowdmap.java.sdk.json.Media;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.GridView;

/**
 *
 */
public class MediaGallerySampleActivity extends Activity {

    private GridView mGridView;
    private GridViewAdapter mGridViewAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_gallery_sample);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        mGridView = (GridView) findViewById(R.id.grid_view);
        mGridViewAdapter = new GridViewAdapter(this);
        mGridView.setAdapter(mGridViewAdapter);
        mGridView.setFocusable(true);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    public void onResume() {
        super.onResume();
        refresh();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }



    public class FetchMediaTask extends AsyncTask<Void, Void, Void> {

        private Media mMedia;
        @Override
        protected Void doInBackground(Void... params) {
            // Fetch 42 of the media stuff from crowdmap
            try{
                mMedia = App.getInstance().getCrowdmap().mediaService().offset(0).limit(42).getMedia();
            }catch(CrowdmapException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(mMedia != null)
                mGridViewAdapter.loadMedia(mMedia.getMedia());
        }

    }

    private void refresh() {
        new FetchMediaTask().execute();
    }

}
