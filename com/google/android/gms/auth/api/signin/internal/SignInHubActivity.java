package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.gms.auth.api.signin.FacebookSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.auth.api.signin.zze;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzld;
import com.google.android.gms.internal.zzld.zza;
import com.google.android.gms.internal.zzlf;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SignInHubActivity
  extends FragmentActivity
{
  private zzn zzWm;
  private zzj zzWn;
  private SignInConfiguration zzWo;
  private boolean zzWp;
  private String zzWq;
  private boolean zzWr;
  private int zzWs;
  private Intent zzWt;
  
  private void zza(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Iterator localIterator = this.zzWn.zzmO().iterator();
    while ((localIterator.hasNext()) && (!((zzld)localIterator.next()).zza(paramInt1, paramInt2, paramIntent, zzmU()))) {}
    if (paramInt2 == 0) {
      finish();
    }
  }
  
  private void zza(int paramInt, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      Object localObject = (SignInAccount)paramIntent.getParcelableExtra("signInAccount");
      if ((localObject != null) && (((SignInAccount)localObject).zzmD() != null))
      {
        localObject = ((SignInAccount)localObject).zzmD();
        this.zzWm.zzb((GoogleSignInAccount)localObject, this.zzWo.zzmR());
        paramIntent.removeExtra("signInAccount");
        paramIntent.putExtra("googleSignInAccount", (Parcelable)localObject);
        this.zzWr = true;
        this.zzWs = paramInt;
        this.zzWt = paramIntent;
        zzd(paramInt, paramIntent);
        return;
      }
      if (paramIntent.hasExtra("errorCode"))
      {
        zzaS(paramIntent.getIntExtra("errorCode", 8));
        return;
      }
    }
    zzaS(8);
  }
  
  private void zzaR(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("errorCode", paramInt);
    setResult(0, localIntent);
    finish();
  }
  
  private void zzaS(int paramInt)
  {
    Status localStatus = new Status(paramInt);
    Intent localIntent = new Intent();
    localIntent.putExtra("googleSignInStatus", localStatus);
    setResult(0, localIntent);
    finish();
  }
  
  private void zzb(int paramInt, Intent paramIntent)
  {
    if (paramInt == -1)
    {
      localObject1 = (SignInAccount)paramIntent.getParcelableExtra("signInAccount");
      if (localObject1 != null)
      {
        this.zzWm.zzb((SignInAccount)localObject1, this.zzWo);
        setResult(-1, paramIntent);
        finish();
        return;
      }
      Log.w("AuthSignInClient", "[SignInHubActivity] SignInAccount is null.");
      zzaR(2);
      return;
    }
    if (paramIntent == null)
    {
      finish();
      return;
    }
    Object localObject1 = paramIntent.getStringExtra("email");
    zze localzze = zze.zzbI(paramIntent.getStringExtra("idProvider"));
    if (localzze == null)
    {
      setResult(paramInt, paramIntent);
      finish();
      return;
    }
    this.zzWq = paramIntent.getStringExtra("pendingToken");
    Object localObject2 = this.zzWo.zzmS().zzmt();
    if ((zze.zzVK.equals(localzze)) && (this.zzWo.zzmS() != null) && (localObject2 != null))
    {
      startActivityForResult((Intent)localObject2, 45057);
      return;
    }
    localObject2 = this.zzWn.zza(localzze);
    if (localObject2 == null)
    {
      paramIntent = localzze.zzad(this);
      Log.w("AuthSignInClient", paramIntent + " is not supported. Please check your configuration");
      zzaR(1);
      return;
    }
    paramInt = paramIntent.getIntExtra("userProfile", -1);
    if (paramInt == 0)
    {
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        ((zzld)localObject2).zza(zzmU());
        return;
      }
      ((zzld)localObject2).zza((String)localObject1, zzmU());
      return;
    }
    if ((paramInt == 1) && (!TextUtils.isEmpty(this.zzWq)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      ((zzld)localObject2).zza((String)localObject1, this.zzWq, zzmU());
      return;
    }
    Log.w("AuthSignInClient", "Internal error!");
    zzaR(2);
  }
  
  private void zzc(int paramInt, Intent paramIntent)
  {
    if (paramInt == 0)
    {
      setResult(0, paramIntent);
      finish();
      return;
    }
    Intent localIntent = new Intent("com.google.android.gms.auth.VERIFY_ASSERTION");
    localIntent.putExtra("idpTokenType", IdpTokenType.zzWc);
    localIntent.putExtra("idpToken", paramIntent.getStringExtra("idpToken"));
    localIntent.putExtra("pendingToken", this.zzWq);
    localIntent.putExtra("idProvider", zze.zzVK.zzmC());
    zzj(localIntent);
  }
  
  private void zzd(int paramInt, Intent paramIntent)
  {
    getSupportLoaderManager().initLoader(0, null, new zza(null));
  }
  
  private void zzj(Intent paramIntent)
  {
    paramIntent.setPackage("com.google.android.gms");
    paramIntent.putExtra("config", this.zzWo);
    if (this.zzWp) {}
    for (int i = 40962;; i = 40961) {
      try
      {
        startActivityForResult(paramIntent, i);
        return;
      }
      catch (ActivityNotFoundException paramIntent)
      {
        Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
        if (!this.zzWp) {
          break;
        }
        zzaS(8);
        return;
        zzaR(2);
      }
    }
  }
  
  private zzld.zza zzmU()
  {
    new zzld.zza()
    {
      public void zza(Exception paramAnonymousException)
      {
        if ((paramAnonymousException == null) || (paramAnonymousException.getMessage() == null)) {}
        for (paramAnonymousException = "";; paramAnonymousException = " " + paramAnonymousException.getMessage())
        {
          Log.w("AuthSignInClient", "Idp signin failed!" + paramAnonymousException);
          SignInHubActivity.zza(SignInHubActivity.this, 4);
          return;
        }
      }
      
      public void zzk(Intent paramAnonymousIntent)
      {
        if (paramAnonymousIntent != null)
        {
          SignInHubActivity.zza(SignInHubActivity.this, paramAnonymousIntent);
          return;
        }
        Log.w("AuthSignInClient", "Idp signin failed!");
        SignInHubActivity.zza(SignInHubActivity.this, 4);
      }
      
      public void zzmV()
      {
        SignInHubActivity.this.setResult(0);
        SignInHubActivity.this.finish();
      }
    };
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    setResult(0);
    switch (paramInt1)
    {
    default: 
      zza(paramInt1, paramInt2, paramIntent);
      return;
    case 40962: 
      zza(paramInt2, paramIntent);
      return;
    case 40961: 
      zzb(paramInt2, paramIntent);
      return;
    }
    zzc(paramInt2, paramIntent);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    int i = 0;
    super.onCreate(paramBundle);
    this.zzWm = zzn.zzae(this);
    this.zzWo = ((SignInConfiguration)getIntent().getParcelableExtra("config"));
    this.zzWp = "com.google.android.gms.auth.GOOGLE_SIGN_IN".equals(getIntent().getAction());
    if (this.zzWo == null)
    {
      Log.e("AuthSignInClient", "Activity started with invalid configuration.");
      setResult(0);
      finish();
      return;
    }
    Object localObject1 = new LinkedList();
    Object localObject2 = new HashMap();
    zzh.zza(this.zzWo, (List)localObject1, (Map)localObject2);
    this.zzWn = new zzj(this, (List)localObject1, (Map)localObject2);
    if (this.zzWo.zzmS() != null)
    {
      localObject1 = (zzlf)this.zzWn.zza(zze.zzVK);
      ((zzlf)localObject1).zzaf(this);
      if ((this.zzWo.zzmQ() == null) && (this.zzWo.zzmR() == null)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (paramBundle == null)
      {
        if (this.zzWp) {
          paramBundle = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        }
        while (i != 0)
        {
          ((zzlf)localObject1).zza(zzmU());
          return;
          localObject2 = new Intent("com.google.android.gms.auth.LOGIN_PICKER");
          if ("com.google.android.gms.auth.RESOLVE_CREDENTIAL".equals(getIntent().getAction()))
          {
            ((Intent)localObject2).fillIn(getIntent(), 3);
            paramBundle = (Bundle)localObject2;
          }
          else
          {
            this.zzWm.zzmY();
            paramBundle = (Bundle)localObject2;
            if (localObject1 != null) {
              try
              {
                zzlf.zzag(this);
                paramBundle = (Bundle)localObject2;
              }
              catch (IllegalStateException paramBundle)
              {
                paramBundle = (Bundle)localObject2;
              }
            }
          }
        }
        zzj(paramBundle);
        return;
      }
      this.zzWq = paramBundle.getString("pendingToken");
      this.zzWr = paramBundle.getBoolean("signingInGoogleApiClients");
      if (!this.zzWr) {
        break;
      }
      this.zzWs = paramBundle.getInt("signInResultCode");
      this.zzWt = ((Intent)paramBundle.getParcelable("signInResultData"));
      zzd(this.zzWs, this.zzWt);
      return;
      continue;
      localObject1 = null;
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("pendingToken", this.zzWq);
    paramBundle.putBoolean("signingInGoogleApiClients", this.zzWr);
    if (this.zzWr)
    {
      paramBundle.putInt("signInResultCode", this.zzWs);
      paramBundle.putParcelable("signInResultData", this.zzWt);
    }
  }
  
  private class zza
    implements LoaderManager.LoaderCallbacks<Void>
  {
    private zza() {}
    
    public Loader<Void> onCreateLoader(int paramInt, Bundle paramBundle)
    {
      return new zzb(SignInHubActivity.this, GoogleApiClient.zzoE());
    }
    
    public void onLoaderReset(Loader<Void> paramLoader) {}
    
    public void zza(Loader<Void> paramLoader, Void paramVoid)
    {
      SignInHubActivity.this.setResult(SignInHubActivity.zza(SignInHubActivity.this), SignInHubActivity.zzb(SignInHubActivity.this));
      SignInHubActivity.this.finish();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/signin/internal/SignInHubActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */