package com.crowdmap.android.sample.gallery;

/**
 * A Wrapper for Android log class making sure logs are shown only when the build config is in a
 * release mode.
 */

import com.crowdmap.android.sdk.sample.BuildConfig;

import android.util.Log;

public class Logger {

    public static final boolean LOGGING_MODE = BuildConfig.DEBUG;

    public static void log(String tag, String message) {
        if (LOGGING_MODE) {
            Log.i(tag, message);
        }
    }

    public static void log(String tag, String format, Object... args) {
        if (LOGGING_MODE) {
            Log.i(tag, String.format(format, args));
        }
    }

    public static void log(String tag, String message, Exception ex) {
        if (LOGGING_MODE) {
            Log.e(tag, message, ex);
        }
    }
}
