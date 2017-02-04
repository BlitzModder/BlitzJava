package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.auth.api.signin.zzh;
import com.google.android.gms.auth.api.signin.zzh.zza;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import java.util.Iterator;
import java.util.Set;

public class zzd
  extends zzj<zzg>
{
  private final GoogleSignInOptions zzVZ;
  
  public zzd(Context paramContext, Looper paramLooper, zzf paramzzf, GoogleSignInOptions paramGoogleSignInOptions, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 91, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
    if (paramGoogleSignInOptions != null) {}
    for (;;)
    {
      paramContext = paramGoogleSignInOptions;
      if (paramzzf.zzqb().isEmpty()) {
        break label103;
      }
      paramContext = new GoogleSignInOptions.Builder(paramGoogleSignInOptions);
      paramLooper = paramzzf.zzqb().iterator();
      while (paramLooper.hasNext()) {
        paramContext.requestScopes((Scope)paramLooper.next(), new Scope[0]);
      }
      paramGoogleSignInOptions = new GoogleSignInOptions.Builder().build();
    }
    paramContext = paramContext.build();
    label103:
    this.zzVZ = paramContext;
  }
  
  protected zzg zzaB(IBinder paramIBinder)
  {
    return zzg.zza.zzaD(paramIBinder);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.auth.api.signin.service.START";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.auth.api.signin.internal.ISignInService";
  }
  
  public boolean zzmJ()
  {
    return true;
  }
  
  public Intent zzmK()
  {
    SignInConfiguration localSignInConfiguration = new zzh.zza(getContext().getPackageName()).zzh(this.zzVZ).zzmG().zzmF();
    Intent localIntent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
    localIntent.setClass(getContext(), SignInHubActivity.class);
    localIntent.putExtra("config", localSignInConfiguration);
    return localIntent;
  }
  
  public GoogleSignInOptions zzmL()
  {
    return this.zzVZ;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/signin/internal/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */