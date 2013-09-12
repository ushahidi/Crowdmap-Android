package com.crowdmap.android.sample.gallery;

import com.crowdmap.android.sdk.sample.R;
import com.crowdmap.java.sdk.json.Media;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.GridView;

/**
 *
 */
public class MediaGallerySampleActivity extends FragmentActivity {

    private GridView mGridView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mGridView = (GridView) findViewById(R.id.grid_view);
        mGridView.setAdapter(new GridViewAdapter(this));
    }

    public class FetchUserTask extends AsyncTask<Void, Void, Void> {

        private Media mMedia;
        @Override
        protected Void doInBackground(Void... params) {
            // Fetch the media from crowdmap
            mMedia = App.getInstance().getCrowdmap().mediaService().getMedia();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

    }
}
