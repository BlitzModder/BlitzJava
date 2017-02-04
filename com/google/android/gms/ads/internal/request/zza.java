package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzie.zza;
import com.google.android.gms.internal.zzil;

@zzha
public class zza
{
  public zzil zza(Context paramContext, AdRequestInfoParcel.zza paramzza, zzan paramzzan, zza paramzza1)
  {
    if (paramzza.zzGq.extras.getBundle("sdk_less_server_data") != null) {}
    for (paramContext = new zzm(paramContext, paramzza, paramzza1);; paramContext = new zzb(paramContext, paramzza, paramzzan, paramzza1))
    {
      paramContext.zzgX();
      return paramContext;
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zza(zzie.zza paramzza);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/request/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */