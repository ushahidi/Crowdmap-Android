package com.crowdmap.android.sample.gallery;

import com.crowdmap.java.sdk.Crowdmap;

/**
 * Entry point for the Crowdmap API Services
 */
public class CrowdmapApiManager {

    private Crowdmap crowdmap;

    public CrowdmapApiManager(ApiConfig config) {
        crowdmap = new Crowdmap(config.getHttpClient(), config.getPubKey(), config.getPrivKey());
    }

    public Crowdmap getCrowdmap() {
        return crowdmap;
    }
}
