package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zzb;

@zzha
public class zzih
{
  final String zzJX;
  long zzKl = -1L;
  long zzKm = -1L;
  int zzKn = -1;
  int zzKo = 0;
  int zzKp = 0;
  private final Object zzpK = new Object();
  
  public zzih(String paramString)
  {
    this.zzJX = paramString;
  }
  
  public static boolean zzH(Context paramContext)
  {
    int i = paramContext.getResources().getIdentifier("Theme.Translucent", "style", "android");
    if (i == 0)
    {
      zzb.zzaG("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      return false;
    }
    ComponentName localComponentName = new ComponentName(paramContext.getPackageName(), "com.google.android.gms.ads.AdActivity");
    try
    {
      if (i == paramContext.getPackageManager().getActivityInfo(localComponentName, 0).theme) {
        return true;
      }
      zzb.zzaG("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      zzb.zzaH("Fail to fetch AdActivity theme");
      zzb.zzaG("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
    }
    return false;
  }
  
  public void zzb(AdRequestParcel paramAdRequestParcel, long paramLong)
  {
    synchronized (this.zzpK)
    {
      if (this.zzKm == -1L)
      {
        this.zzKm = paramLong;
        this.zzKl = this.zzKm;
        if ((paramAdRequestParcel.extras == null) || (paramAdRequestParcel.extras.getInt("gw", 2) != 1)) {}
      }
      else
      {
        this.zzKl = paramLong;
      }
    }
    this.zzKn += 1;
  }
  
  public Bundle zzc(Context paramContext, String paramString)
  {
    synchronized (this.zzpK)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("session_id", this.zzJX);
      localBundle.putLong("basets", this.zzKm);
      localBundle.putLong("currts", this.zzKl);
      localBundle.putString("seq_num", paramString);
      localBundle.putInt("preqs", this.zzKn);
      localBundle.putInt("pclick", this.zzKo);
      localBundle.putInt("pimp", this.zzKp);
      localBundle.putBoolean("support_transparent_background", zzH(paramContext));
      return localBundle;
    }
  }
  
  public void zzgD()
  {
    synchronized (this.zzpK)
    {
      this.zzKp += 1;
      return;
    }
  }
  
  public void zzgE()
  {
    synchronized (this.zzpK)
    {
      this.zzKo += 1;
      return;
    }
  }
  
  public long zzgV()
  {
    return this.zzKm;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzih.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */