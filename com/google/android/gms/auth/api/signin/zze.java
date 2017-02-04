package com.google.android.gms.auth.api.signin;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.google.android.gms.R.string;

public enum zze
{
  private final String zzUB;
  private final String zzVL;
  private final int zzVM;
  
  private zze(String paramString1, int paramInt, String paramString2)
  {
    this.zzVL = paramString1;
    this.zzVM = paramInt;
    this.zzUB = paramString2;
  }
  
  public static zze zzbI(String paramString)
  {
    if (paramString != null)
    {
      zze[] arrayOfzze = values();
      int j = arrayOfzze.length;
      int i = 0;
      while (i < j)
      {
        zze localzze = arrayOfzze[i];
        if (localzze.zzmC().equals(paramString)) {
          return localzze;
        }
        i += 1;
      }
      Log.w("IdProvider", "Unrecognized providerId: " + paramString);
    }
    return null;
  }
  
  public String toString()
  {
    return this.zzVL;
  }
  
  public CharSequence zzad(Context paramContext)
  {
    return paramContext.getResources().getString(this.zzVM);
  }
  
  public String zzmC()
  {
    return this.zzVL;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/signin/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */