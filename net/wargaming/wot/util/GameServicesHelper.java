package net.wargaming.wot.util;

import android.app.Dialog;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import com.dava.framework.JNIActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;

public class GameServicesHelper
  implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener
{
  private JNIActivity mActivity = null;
  private GoogleApiClient mApiClient = null;
  private GoogleApiClient.Builder mBuilder = null;
  private ConnectionResult mConnectionResult = null;
  private boolean mExpectingResolution = false;
  private boolean mSilentSignIn = false;
  
  public GameServicesHelper(JNIActivity paramJNIActivity)
  {
    this.mActivity = paramJNIActivity;
    this.mBuilder = new GoogleApiClient.Builder(this.mActivity, this, this);
    this.mBuilder.addApi(Games.API);
    this.mBuilder.addApi(Plus.API);
    this.mBuilder.addScope(Games.SCOPE_GAMES);
    this.mApiClient = this.mBuilder.build();
  }
  
  private static String errorCodeToString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "Unknown error code " + paramInt;
    case 10: 
      return "DEVELOPER_ERROR(" + paramInt + ")";
    case 8: 
      return "INTERNAL_ERROR(" + paramInt + ")";
    case 5: 
      return "INVALID_ACCOUNT(" + paramInt + ")";
    case 11: 
      return "LICENSE_CHECK_FAILED(" + paramInt + ")";
    case 7: 
      return "NETWORK_ERROR(" + paramInt + ")";
    case 6: 
      return "RESOLUTION_REQUIRED(" + paramInt + ")";
    case 3: 
      return "SERVICE_DISABLED(" + paramInt + ")";
    case 9: 
      return "SERVICE_INVALID(" + paramInt + ")";
    case 1: 
      return "SERVICE_MISSING(" + paramInt + ")";
    case 2: 
      return "SERVICE_VERSION_UPDATE_REQUIRED(" + paramInt + ")";
    case 4: 
      return "SIGN_IN_REQUIRED(" + paramInt + ")";
    }
    return "SUCCESS(" + paramInt + ")";
  }
  
  private static native void nativeOnSignInCancelled();
  
  private static native void nativeOnSignedIn();
  
  public void dispose() {}
  
  public void handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == 10001) {
      Log.d("DAVA", "onAR: Got RESULT_RECONNECT_REQUIRED from achievements activity: " + paramInt1);
    }
    if (paramInt1 == 3000)
    {
      this.mExpectingResolution = false;
      if (paramInt2 == -1)
      {
        Log.d("DAVA", "onAR: Resolution was RESULT_OK, so connecting current client again.");
        signIn();
      }
    }
    while ((paramInt1 != 3001) || (paramInt2 != 10001))
    {
      return;
      if (paramInt2 == 10001)
      {
        Log.d("DAVA", "onAR: Resolution was RECONNECT_REQUIRED, so reconnecting.");
        signIn();
        return;
      }
      if (paramInt2 == 0)
      {
        Log.d("DAVA", "onAR: Got a cancellation result, so disconnecting.");
        signOut();
        nativeOnSignInCancelled();
        return;
      }
      Log.d("DAVA", "onAR: resultCode=" + paramInt2 + ", so giving up.");
      return;
    }
    Log.d("DAVA", "onAR: Got RESULT_RECONNECT_REQUIRED from achievements activity, so disconnecting");
    this.mApiClient.disconnect();
  }
  
  public boolean isSignedIn()
  {
    return (this.mApiClient != null) && (this.mApiClient.isConnected());
  }
  
  public void onConnected(Bundle paramBundle)
  {
    Log.d("DAVA", "onConnected: connected!");
    this.mActivity.RunOnMainLoopThread(new Runnable()
    {
      public void run() {}
    });
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    Log.d("DAVA", "onConnectionFailed");
    this.mConnectionResult = paramConnectionResult;
    Log.d("DAVA", "Connection failure:");
    Log.d("DAVA", "   - code: " + errorCodeToString(this.mConnectionResult.getErrorCode()));
    Log.d("DAVA", "   - resolvable: " + this.mConnectionResult.hasResolution());
    Log.d("DAVA", "   - details: " + this.mConnectionResult.toString());
    Log.d("DAVA", "onConnectionFailed: resolving problem...");
    if (this.mSilentSignIn) {
      return;
    }
    resolveConnectionResult();
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    Log.d("DAVA", "onConnectionSuspended, cause=" + paramInt);
    signOut();
  }
  
  void resolveConnectionResult()
  {
    if (this.mExpectingResolution)
    {
      Log.d("DAVA", "We're already expecting the result of a previous resolution.");
      return;
    }
    final int i = this.mConnectionResult.getErrorCode();
    Log.d("DAVA", "resolveConnectionResult: trying to resolve result: " + this.mConnectionResult);
    if (this.mConnectionResult.hasResolution())
    {
      Log.d("DAVA", "Result has resolution. Starting it.");
      try
      {
        this.mExpectingResolution = true;
        this.mConnectionResult.startResolutionForResult(this.mActivity, 3000);
        return;
      }
      catch (IntentSender.SendIntentException localSendIntentException)
      {
        Log.d("DAVA", "SendIntentException, so connecting again.");
        signIn();
        return;
      }
    }
    if (GooglePlayServicesUtil.isUserRecoverableError(i))
    {
      this.mActivity.runOnUiThread(new Runnable()
      {
        public void run()
        {
          GooglePlayServicesUtil.getErrorDialog(i, GameServicesHelper.this.mActivity, 3002).show();
        }
      });
      return;
    }
    Log.d("DAVA", "resolveConnectionResult: result has no resolution. Giving up.");
  }
  
  public void setAchievementSteps(String paramString, int paramInt)
  {
    if (isSignedIn())
    {
      Resources localResources = this.mActivity.getResources();
      int i = localResources.getIdentifier(paramString, "string", this.mActivity.getPackageName());
      if (i > 0)
      {
        Log.d("DAVA", "Set " + paramInt + " steps for '" + paramString + "'");
        Games.Achievements.setSteps(this.mApiClient, localResources.getText(i).toString(), paramInt);
      }
    }
  }
  
  public void showAchievements()
  {
    if (isSignedIn())
    {
      Intent localIntent = Games.Achievements.getAchievementsIntent(this.mApiClient);
      this.mActivity.startActivityForResult(localIntent, 3001);
    }
  }
  
  public void signIn()
  {
    if (this.mApiClient.isConnected()) {
      return;
    }
    this.mExpectingResolution = false;
    this.mSilentSignIn = false;
    this.mApiClient.connect();
  }
  
  public void signInSilent()
  {
    if (this.mApiClient.isConnected()) {
      return;
    }
    this.mExpectingResolution = false;
    this.mSilentSignIn = true;
    this.mApiClient.connect();
  }
  
  public void signOut()
  {
    if (!this.mApiClient.isConnected()) {
      return;
    }
    Games.signOut(this.mApiClient);
    Plus.AccountApi.revokeAccessAndDisconnect(this.mApiClient);
    this.mApiClient.disconnect();
  }
  
  public void unlockAchievement(String paramString)
  {
    if (isSignedIn())
    {
      Resources localResources = this.mActivity.getResources();
      int i = localResources.getIdentifier(paramString, "string", this.mActivity.getPackageName());
      if (i > 0)
      {
        Log.d("DAVA", "Unlocking '" + paramString + "'");
        Games.Achievements.unlock(this.mApiClient, localResources.getText(i).toString());
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/net/wargaming/wot/util/GameServicesHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */