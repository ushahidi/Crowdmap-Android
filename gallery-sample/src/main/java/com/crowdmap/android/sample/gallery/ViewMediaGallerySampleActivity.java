package com.crowdmap.android.sample.gallery;

import com.crowdmap.java.sdk.CrowdmapException;
import com.crowdmap.java.sdk.json.Media;
import com.crowdmap.java.sdk.model.User;
import com.squareup.picasso.Picasso;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import static com.crowdmap.android.sample.gallery.MediaGallerySampleActivity.MEDIA_ID;

public class ViewMediaGallerySampleActivity extends Activity {

    private TextView mDescription;

    private ImageView mImageView;

    private ProgressBar mProgressBar;

    private int mMediaId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_gallery);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        mDescription = (TextView) findViewById(R.id.description);
        mProgressBar = (ProgressBar) findViewById(R.id.img_progress);
        mImageView = (ImageView) findViewById(R.id.full_photo);
        mMediaId = getIntent().getExtras().getInt(MEDIA_ID, 0);
    }

    @Override
    public void onResume() {
        super.onResume();
        refresh();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public class FetchMediaTask extends AsyncTask<Void, Void, Void> {

        private Media mMedia;

        private User mUsers;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                // fetch the media item
                mMedia = App.getInstance().getCrowdmap().mediaService().getMedia(mMediaId);

                // fetch the user details
                if((mMedia.getMedia() != null) && (mMedia.getMedia().size() > 0)) {
                    final long userId = mMedia.getMedia().get(0).getUserId();
                    final List<User> users = App.getInstance().getCrowdmap().userService()
                        .getUser(userId).getUsers();

                    if ((users != null) && (users.size() > 0)) {
                        mUsers = users.get(0);
                    }
                }

            } catch (CrowdmapException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            mProgressBar.setVisibility(View.GONE);
            if (mMedia != null) {
                Picasso.with(ViewMediaGallerySampleActivity.this).load(
                        mMedia.getMedia().get(0).getFileLocation() + mMedia.getMedia().get(0)
                                .getFilename()).placeholder(R.drawable.placeholder)
                        .error(R.drawable.error).fit().into(mImageView);
                if(mUsers.getUsername() != null)
                    mDescription.setText("By @" + mUsers.getUsername());
            }
        }

    }

    private void refresh() {
        new FetchMediaTask().execute();
    }
}
