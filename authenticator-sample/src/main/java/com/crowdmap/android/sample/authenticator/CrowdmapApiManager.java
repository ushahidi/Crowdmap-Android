package com.crowdmap.android.sample.authenticator;

import com.crowdmap.java.sdk.Crowdmap;
import com.crowdmap.java.sdk.CrowdmapApiKeys;

/**
 * Entry point for the Crowdmap API Services
 */
public class CrowdmapApiManager {

    private Crowdmap crowdmap;

    public CrowdmapApiManager(IApiConfig config) {
        crowdmap = new Crowdmap(new CrowdmapApiKeys(config.getPubKey(), config.getPrivKey()));
    }

    public Crowdmap getCrowdmap() {
        return crowdmap;
    }
}
