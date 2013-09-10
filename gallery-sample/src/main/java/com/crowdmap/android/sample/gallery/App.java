package com.crowdmap.android.sample.gallery;

import android.app.Application;

/**
 *
 */
public class App extends Application {

    public static CrowdmapApiManager mCrowdmapApiManager;

    private static ApiConfig config;

    private final String PUBLIC_KEY = "mcoSiLOiRUXiiAPv";

    private final String PRIVATE_KEY = "jodJljijJNiBSLLW";

    @Override
    public void onCreate() {
        config  = new ApiConfig();
        config.setupKeys(PUBLIC_KEY, PRIVATE_KEY);
    }

    public static CrowdmapApiManager getInstance() {
        if(mCrowdmapApiManager == null) {
            mCrowdmapApiManager = new CrowdmapApiManager(config);
        }
        return mCrowdmapApiManager;
    }
}
