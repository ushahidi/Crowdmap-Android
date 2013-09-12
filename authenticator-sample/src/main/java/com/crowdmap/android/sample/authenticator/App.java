package com.crowdmap.android.sample.authenticator;

import com.crowdmap.java.sdk.net.CrowdmapHttpClient;

import android.app.Application;

/**
 *
 */
public class App extends Application {

    private static CrowdmapApiManager mCrowdmapApiManager;

    private static ApiConfig config;

    private final String PUBLIC_KEY = "mcoSiLOiRUXiiAPv";

    private final String PRIVATE_KEY = "jodJljijJNiBSLLW";

    @Override
    public void onCreate() {
        config = new ApiConfig();
        config.setupKeys(PUBLIC_KEY, PRIVATE_KEY);
        //config.setHttpClient(new CrowdmapHttpClient("api.crdmp3.com/v1", "http"));
    }

    public static CrowdmapApiManager getInstance() {
        if (mCrowdmapApiManager == null) {
            mCrowdmapApiManager = new CrowdmapApiManager(config);
        }
        return mCrowdmapApiManager;
    }
}
