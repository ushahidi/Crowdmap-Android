package com.crowdmap.android.sample.gallery;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Show a square Image
 */
final class SampleImageView extends ImageView {
    public SampleImageView(Context context) {
        super(context);
    }

    public SampleImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }
}