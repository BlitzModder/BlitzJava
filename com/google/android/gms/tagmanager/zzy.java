package com.google.android.gms.tagmanager;

import android.util.Log;

public class zzy
  implements zzbh
{
  private int zzQh = 5;
  
  public void e(String paramString)
  {
    if (this.zzQh <= 6) {
      Log.e("GoogleTagManager", paramString);
    }
  }
  
  public void setLogLevel(int paramInt)
  {
    this.zzQh = paramInt;
  }
  
  public void v(String paramString)
  {
    if (this.zzQh <= 2) {
      Log.v("GoogleTagManager", paramString);
    }
  }
  
  public void zzaF(String paramString)
  {
    if (this.zzQh <= 3) {
      Log.d("GoogleTagManager", paramString);
    }
  }
  
  public void zzaG(String paramString)
  {
    if (this.zzQh <= 4) {
      Log.i("GoogleTagManager", paramString);
    }
  }
  
  public void zzaH(String paramString)
  {
    if (this.zzQh <= 5) {
      Log.w("GoogleTagManager", paramString);
    }
  }
  
  public void zzb(String paramString, Throwable paramThrowable)
  {
    if (this.zzQh <= 6) {
      Log.e("GoogleTagManager", paramString, paramThrowable);
    }
  }
  
  public void zzd(String paramString, Throwable paramThrowable)
  {
    if (this.zzQh <= 5) {
      Log.w("GoogleTagManager", paramString, paramThrowable);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */