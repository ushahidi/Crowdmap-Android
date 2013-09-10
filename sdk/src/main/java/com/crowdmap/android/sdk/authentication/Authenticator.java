package com.crowdmap.android.sdk.authentication;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.Bundle;

/**
 * This class implements AbstractAccountAuthenticator for handling authentication against the
 * crowdmap API. It stores the session token aka auth token for upon successful login when the
 * user's username and password is passed to the Crowdmap API. However subsequent authentication
 * will use the saved session token for authenticating against the Crowdmap API.
 */
public class Authenticator extends AbstractAccountAuthenticator {

    /** The tag used to log to adb console. **/
    private static final String TAG = "Authenticator";

    // Authentication Service context
    private final Context mContext;


    public Authenticator(Context context) {
        super(context);
        mContext = context;
    }
    @Override
    public Bundle editProperties(AccountAuthenticatorResponse response, String accountType) {
        return null;
    }

    @Override
    public Bundle addAccount(AccountAuthenticatorResponse response, String accountType,
            String authTokenType, String[] requiredFeatures, Bundle options)
            throws NetworkErrorException {
        return null;
    }

    @Override
    public Bundle confirmCredentials(AccountAuthenticatorResponse response, Account account,
            Bundle options) throws NetworkErrorException {
        return null;
    }

    @Override
    public Bundle getAuthToken(AccountAuthenticatorResponse response, Account account,
            String authTokenType, Bundle options) throws NetworkErrorException {
        return null;
    }

    @Override
    public String getAuthTokenLabel(String authTokenType) {
        return null;
    }

    @Override
    public Bundle updateCredentials(AccountAuthenticatorResponse response, Account account,
            String authTokenType, Bundle options) throws NetworkErrorException {
        return null;
    }

    @Override
    public Bundle hasFeatures(AccountAuthenticatorResponse response, Account account,
            String[] features) throws NetworkErrorException {
        return null;
    }
}
