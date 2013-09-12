package com.crowdmap.android.sample.gallery;

import com.crowdmap.java.sdk.model.Media;
import com.squareup.picasso.Picasso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * GrideView
 */
public class GridViewAdapter extends BaseAdapter {

    private final Context context;

    private List<Media> mediaUrls = new ArrayList<Media>();

    public GridViewAdapter(Context context) {
        this.context = context;
    }

    public void loadMedia(List<Media> mediaUrls) {
        this.mediaUrls = mediaUrls;
    }

    @Override
    public int getCount() {
        return mediaUrls.size();
    }

    @Override
    public Media getItem(int position) {
        return mediaUrls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        SampleImageView image = (SampleImageView) convertView;
        if (image == null) {
            image = new SampleImageView(context);
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        final String url = getItem(position).getFileLocation() + getItem(position).getFilename();

        final int width = getItem(position).getThumbnailWidth();
        final int height = getItem(position).getThumbnailHeight();

        Picasso.with(context)
                .load(url)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .resize(width, height)
                .centerCrop()
                .into(image);

        return image;
    }
}
