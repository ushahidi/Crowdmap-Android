package com.crowdmap.android.sample.gallery;


/**
 *
 */
public class ApiConfig implements IApiConfig {

    private String mPubKey;

    private String mPrivKey;


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

}
