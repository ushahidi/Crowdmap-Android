package com.crowdmap.android.sample.gallery;

import com.crowdmap.android.sdk.sample.R;
import com.squareup.picasso.Picasso;

import android.content.Context;
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

    private List<String> mediaUrls = new ArrayList<String>();

    public GridViewAdapter(Context context) {
        this.context = context;
    }

    public void loadMedia(List<String> mediaUrls) {
        this.mediaUrls = mediaUrls;
    }
    @Override
    public int getCount() {
        return mediaUrls.size();
    }

    @Override
    public String getItem(int position) {
        return mediaUrls.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView image = (ImageView) convertView;
        if(image == null) {
            image = new ImageView(context);
            image.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }

        final String url = getItem(position);
        Picasso.with(context)
                .load(url)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .fit()
                .into(image);
        return image;
    }
}
