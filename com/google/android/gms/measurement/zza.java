package com.google.android.gms.measurement;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.R.string;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;

public final class zza
{
  private static volatile zza zzaRg;
  private final String zzaRd;
  private final Status zzaRe;
  private final boolean zzaRf;
  
  zza(Context paramContext)
  {
    paramContext = paramContext.getResources();
    String str = paramContext.getResourcePackageName(R.string.common_google_play_services_unknown_issue);
    int i = paramContext.getIdentifier("google_app_measurement_enable", "integer", str);
    boolean bool1 = bool2;
    if (i != 0)
    {
      if (paramContext.getInteger(i) != 0) {
        bool1 = bool2;
      }
    }
    else
    {
      this.zzaRf = bool1;
      i = paramContext.getIdentifier("google_app_id", "string", str);
      if (i != 0) {
        break label113;
      }
      if (!this.zzaRf) {
        break label103;
      }
    }
    label103:
    for (this.zzaRe = new Status(10, "Missing an expected resource: 'R.string.google_app_id' for initializing Google services.  Possible causes are missing google-services.json or com.google.gms.google-services gradle plugin.");; this.zzaRe = Status.zzaeX)
    {
      this.zzaRd = null;
      return;
      bool1 = false;
      break;
    }
    label113:
    paramContext = paramContext.getString(i);
    if (TextUtils.isEmpty(paramContext))
    {
      if (this.zzaRf) {}
      for (this.zzaRe = new Status(10, "The resource 'R.string.google_app_id' is invalid, expected an app  identifier and found: '" + paramContext + "'.");; this.zzaRe = Status.zzaeX)
      {
        this.zzaRd = null;
        return;
      }
    }
    this.zzaRd = paramContext;
    this.zzaRe = Status.zzaeX;
  }
  
  public static Status zzaS(Context paramContext)
  {
    zzx.zzb(paramContext, "Context must not be null.");
    if (zzaRg == null) {}
    try
    {
      if (zzaRg == null) {
        zzaRg = new zza(paramContext);
      }
      return zzaRg.zzaRe;
    }
    finally {}
  }
  
  public static String zzzA()
  {
    if (zzaRg == null) {
      try
      {
        if (zzaRg == null) {
          throw new IllegalStateException("Initialize must be called before getGoogleAppId.");
        }
      }
      finally {}
    }
    return zzaRg.zzzB();
  }
  
  public static boolean zzzC()
  {
    if (zzaRg == null) {
      try
      {
        if (zzaRg == null) {
          throw new IllegalStateException("Initialize must be called before isMeasurementEnabled.");
        }
      }
      finally {}
    }
    return zzaRg.zzzD();
  }
  
  String zzzB()
  {
    if (!this.zzaRe.isSuccess()) {
      throw new IllegalStateException("Initialize must be successful before calling getGoogleAppId.  The result of the previous call to initialize was: '" + this.zzaRe + "'.");
    }
    return this.zzaRd;
  }
  
  boolean zzzD()
  {
    if (!this.zzaRe.isSuccess()) {
      throw new IllegalStateException("Initialize must be successful before calling isMeasurementEnabledInternal.  The result of the previous call to initialize was: '" + this.zzaRe + "'.");
    }
    return this.zzaRf;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */