package net.wargaming.wot.util;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import com.dava.framework.JNIActivity;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.common.AccountPicker;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.io.IOException;

public class AccountHelper
{
  private static final String AUTH_TOKEN_SCOPE = "oauth2:profile email";
  private static final String EMAIL_BUNDLE_KEY = "DAVA.AccountHelper.mEmail";
  private JNIActivity mActivity = null;
  private String mEmail = null;
  private boolean mIsPhone = false;
  
  public AccountHelper(JNIActivity paramJNIActivity)
  {
    this.mActivity = paramJNIActivity;
    if ((this.mActivity.getResources().getConfiguration().screenLayout & 0xF) < 3) {
      bool = true;
    }
    this.mIsPhone = bool;
  }
  
  private static native void nativeOnAccountPickCancelled();
  
  private static native void nativeOnAccountPickFailed();
  
  private static native void nativeOnAccountPicked(String paramString1, String paramString2);
  
  private void onAccountPickCancelled()
  {
    try
    {
      Log.d("DAVA", "!!!! onAccountPickCancelled");
      this.mEmail = "";
      this.mActivity.RunOnMainLoopThread(new Runnable()
      {
        public void run() {}
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void onAccountPickFailed()
  {
    try
    {
      Log.d("DAVA", "!!!! onAccountPickFailed");
      this.mActivity.RunOnMainLoopThread(new Runnable()
      {
        public void run() {}
      });
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void onAccountPicked(final String paramString1, final String paramString2)
  {
    try
    {
      Log.d("DAVA", "!!!! onAccountPicked");
      this.mActivity.RunOnMainLoopThread(new Runnable()
      {
        public void run()
        {
          AccountHelper.nativeOnAccountPicked(paramString1, paramString2);
        }
      });
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public boolean checkAccountEmail(String paramString)
  {
    return true;
  }
  
  public void clearToken(String paramString)
  {
    try
    {
      GoogleAuthUtil.clearToken(this.mActivity, paramString);
      return;
    }
    catch (GooglePlayServicesAvailabilityException paramString)
    {
      this.mActivity.startActivityForResult(paramString.getIntent(), 1002);
      return;
    }
    catch (GoogleAuthException paramString) {}catch (IOException paramString) {}
  }
  
  public void handleActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1000) {
      if (paramInt2 == -1)
      {
        this.mEmail = paramIntent.getStringExtra("authAccount");
        requestToken();
      }
    }
    while (paramInt1 != 1001)
    {
      return;
      onAccountPickCancelled();
      return;
    }
    if (paramInt2 == -1)
    {
      requestToken();
      return;
    }
    onAccountPickCancelled();
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null) {
      this.mEmail = paramBundle.getString("DAVA.AccountHelper.mEmail");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    if (paramBundle != null) {
      paramBundle.putString("DAVA.AccountHelper.mEmail", this.mEmail);
    }
  }
  
  public void pickAccount(String paramString)
  {
    final int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.mActivity);
    if (i == 0)
    {
      if ((paramString == null) || (paramString == ""))
      {
        paramString = AccountPicker.newChooseAccountIntent(null, null, new String[] { "com.google" }, false, null, null, null, null);
        this.mActivity.startActivityForResult(paramString, 1000);
        return;
      }
      this.mEmail = paramString;
      requestToken();
      return;
    }
    if (GooglePlayServicesUtil.isUserRecoverableError(i))
    {
      this.mActivity.runOnUiThread(new Runnable()
      {
        public void run()
        {
          GooglePlayServicesUtil.getErrorDialog(i, AccountHelper.this.mActivity, 1002).show();
        }
      });
      onAccountPickCancelled();
      return;
    }
    onAccountPickFailed();
  }
  
  public void requestToken()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          if ((AccountHelper.this.mEmail != null) && (AccountHelper.this.mEmail != "") && (AccountHelper.this.mActivity.getApplicationContext() != null))
          {
            String str = GoogleAuthUtil.getToken(AccountHelper.this.mActivity, AccountHelper.this.mEmail, "oauth2:profile email");
            AccountHelper.this.onAccountPicked(AccountHelper.this.mEmail, str);
            return;
          }
          AccountHelper.this.onAccountPickFailed();
          return;
        }
        catch (GooglePlayServicesAvailabilityException localGooglePlayServicesAvailabilityException)
        {
          final int i = localGooglePlayServicesAvailabilityException.getConnectionStatusCode();
          AccountHelper.this.mActivity.runOnUiThread(new Runnable()
          {
            public void run()
            {
              GooglePlayServicesUtil.getErrorDialog(i, AccountHelper.this.mActivity, 1001).show();
            }
          });
          AccountHelper.this.onAccountPickCancelled();
          return;
        }
        catch (UserRecoverableAuthException localUserRecoverableAuthException)
        {
          AccountHelper.this.mActivity.startActivityForResult(localUserRecoverableAuthException.getIntent(), 1001);
          return;
        }
        catch (IOException localIOException)
        {
          AccountHelper.this.onAccountPickFailed();
          return;
        }
        catch (GoogleAuthException localGoogleAuthException)
        {
          AccountHelper.this.onAccountPickFailed();
          return;
        }
        catch (SecurityException localSecurityException)
        {
          AccountHelper.this.onAccountPickFailed();
        }
      }
    }).start();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/net/wargaming/wot/util/AccountHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */