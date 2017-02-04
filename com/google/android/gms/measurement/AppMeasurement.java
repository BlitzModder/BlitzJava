package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.internal.zzt;
import com.google.android.gms.measurement.internal.zzy;

public class AppMeasurement
{
  private final zzt zzaQX;
  
  public AppMeasurement(zzt paramzzt)
  {
    zzx.zzy(paramzzt);
    this.zzaQX = paramzzt;
  }
  
  public static AppMeasurement getInstance(Context paramContext)
  {
    return zzt.zzaU(paramContext).zzBC();
  }
  
  public void setMeasurementEnabled(boolean paramBoolean)
  {
    this.zzaQX.zzBB().setMeasurementEnabled(paramBoolean);
  }
  
  public void zzd(String paramString1, String paramString2, Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    this.zzaQX.zzBB().zze(paramString1, paramString2, localBundle);
  }
  
  public static abstract interface zza
  {
    public abstract void zze(String paramString1, String paramString2, Bundle paramBundle);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/AppMeasurement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */