package com.crowdmap.android.sample.authenticator;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Service to handle Account authentication. It instantiates the authenticator
 * and returns its IBinder.
 */
public class AuthenticationService extends Service {

    private static final String TAG = AuthenticationService.class.getSimpleName();

    private Authenticator mAuthenticator;

    @Override
    public void onCreate() {

        Logger.log(TAG, "Crowdmap authentication service started.");
        mAuthenticator = new Authenticator(this, App.getInstance());
    }

    @Override
    public void onDestroy() {
        Logger.log(TAG,"Authentication service stopped." );
    }

    @Override
    public IBinder onBind(Intent intent) {
        Logger.log(TAG,"getBinder()...  returning the AccountAuthenticator binder for intent "
                + intent );
        return mAuthenticator.getIBinder();
    }
}

