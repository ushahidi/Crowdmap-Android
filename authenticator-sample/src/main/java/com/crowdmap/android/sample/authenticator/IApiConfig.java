package com.crowdmap.android.sample.authenticator;

import com.crowdmap.java.sdk.net.HttpClient;

/**
 * Interface for API config
 */
public interface IApiConfig {

    public IApiConfig setupKeys(String pubKey, String privKey);

    public String getPubKey();

    public String getPrivKey();

    public HttpClient getHttpClient();

    public void setHttpClient(HttpClient httpClient);

}
