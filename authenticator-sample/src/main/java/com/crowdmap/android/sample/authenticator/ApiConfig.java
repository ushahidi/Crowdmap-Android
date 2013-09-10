package com.crowdmap.android.sample.authenticator;

import com.crowdmap.java.sdk.Crowdmap;
import com.crowdmap.java.sdk.net.HttpClient;

/**
 *
 */
public class ApiConfig implements IApiConfig{

    private String mPubKey;

    private String mPrivKey;

    private HttpClient mHttpClient;


    @Override
    public IApiConfig setupKeys(String pubKey, String privKey) {
        mPubKey = pubKey;
        mPrivKey = privKey;
        return this;
    }

    public String getPubKey() {
        return mPubKey;
    }

    public String getPrivKey() {
        return mPrivKey;
    }

    public HttpClient getHttpClient() {
        return mHttpClient;
    }

    public void setHttpClient(HttpClient httpClient) {
        mHttpClient = httpClient;
    }
}
