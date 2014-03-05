package com.crowdmap.android.sample.authenticator;

import com.crowdmap.java.sdk.json.Users;
import com.squareup.picasso.Picasso;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends Activity {

    private final static String TAG = MainActivity.class.getSimpleName();

    private LinearLayout mShowPromptLayout;

    private ImageView mImageView;

    private TextView username;

    private TextView description;

    private TextView name;

    private AccountManager mAccountManager;

    private Handler mHandler;

    private RelativeLayout mUserLayout;

    private Bundle bundle;

    private String mSession;

    private String mUserId;

    private AccountManagerFuture<Bundle> mFuture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        mShowPromptLayout = (LinearLayout) findViewById(R.id.prompt_layout);
        mUserLayout = (RelativeLayout) findViewById(R.id.crdmap_user);
        mImageView = (ImageView) findViewById(R.id.imageView);
        username = (TextView) findViewById(R.id.crdmap_username);
        name = (TextView) findViewById(R.id.crdmap_name);
        description = (TextView) findViewById(R.id.crdmap_user_desc);
        mAccountManager = AccountManager.get(this);
        mHandler = new Handler();
        initUi();
    }

    private void initUi() {

        getUserId();
        Logger.log(TAG, "sizes " + mSession);
        if (mSession == null) {
            mShowPromptLayout.setVisibility(View.VISIBLE);
            mUserLayout.setVisibility(View.GONE);
        } else {
            mUserLayout.setVisibility(View.VISIBLE);
            mShowPromptLayout.setVisibility(View.GONE);
            FetchUserTask fetchUserTask = new FetchUserTask(mUserId, mSession, this);
            fetchUserTask.execute();
        }
    }

    /**
     * Get the saved session token from the Android account manager.
     *
     * @return the saved session token.
     */
    private void getUserId() {

        final Account accounts[] = mAccountManager.getAccountsByType(AuthConstants.ACCOUNT_TYPE);

        if (accounts.length > 0) {

            mUserId = mAccountManager.getUserData(accounts[0], AuthConstants.PARAM_USER_ID);
            mSession = mAccountManager.getUserData(accounts[0], AuthConstants.PARAM_AUTHTOKEN_TYPE);

            Logger.log(TAG, "How u");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * Launch the login activity
     */
    public void showSignIn(View view) {
        Intent i = new Intent(this, AuthenticatorActivity.class);
        startActivity(i);
    }

    /**
     * Task to fetch the login user from the Crowdmap API
     */
    public class FetchUserTask extends AsyncTask<Void, Void, Void> {

        private String mUserId;

        private Users mUsers;

        private String mSessionToken;

        protected Context mContext;

        public FetchUserTask(String userId, String sessionToken, Context context) {
            mUserId = userId;
            mSessionToken = sessionToken;
            mContext = context;
        }

        @Override
        protected Void doInBackground(Void... params) {
            if ((mUserId != null) && (!TextUtils.isEmpty(mUserId))) {
                if ((mSessionToken != null) && (!TextUtils.isEmpty(mSessionToken)))

                {
                    getUserId();
                    App.getInstance().getCrowdmap().utilityService().about();
                    mUsers = App.getInstance().getCrowdmap().userService().getUser(Long.valueOf(mUserId));
                }

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if ((mUsers != null) && (mUsers.getUsers().size() > 0)) {
                username.setText("@"+mUsers.getUsers().get(0).getUsername());
                name.setText(mUsers.getUsers().get(0).getName());
                description.setText(mUsers.getUsers().get(0).getBio());
                Picasso.with(mContext).load(mUsers.getUsers().get(0).getAvatar()).resize(150,150).centerCrop().into(mImageView);
            }
        }

    }
}
