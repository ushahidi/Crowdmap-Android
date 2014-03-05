package com.crowdmap.android.sample.gallery;

/**
 * Interface for API config
 */
public interface IApiConfig {

    public IApiConfig setupKeys(String pubKey, String privKey);

    public String getPubKey();

    public String getPrivKey();

}
