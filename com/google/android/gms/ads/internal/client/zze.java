package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;
import com.google.android.gms.internal.zzbv;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzeg;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzha;

@zzha
public class zze
  extends zzg<zzt>
{
  public zze()
  {
    super("com.google.android.gms.ads.AdManagerCreatorImpl");
  }
  
  private zzs zza(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzev paramzzev, int paramInt)
  {
    try
    {
      com.google.android.gms.dynamic.zzd localzzd = com.google.android.gms.dynamic.zze.zzB(paramContext);
      paramContext = zzs.zza.zzk(((zzt)zzaA(paramContext)).zza(localzzd, paramAdSizeParcel, paramString, paramzzev, 8298000, paramInt));
      return paramContext;
    }
    catch (zzg.zza paramContext)
    {
      zzb.zza("Could not create remote AdManager.", paramContext);
      return null;
    }
    catch (RemoteException paramContext)
    {
      for (;;) {}
    }
  }
  
  public zzs zza(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzev paramzzev)
  {
    Object localObject;
    if (zzl.zzcN().zzT(paramContext))
    {
      zzs localzzs = zza(paramContext, paramAdSizeParcel, paramString, paramzzev, 1);
      localObject = localzzs;
      if (localzzs != null) {}
    }
    else
    {
      zzb.zzaF("Using BannerAdManager from the client jar.");
      localObject = new zzf(paramContext, paramAdSizeParcel, paramString, paramzzev, new VersionInfoParcel(8298000, 8298000, true), com.google.android.gms.ads.internal.zzd.zzbf());
    }
    return (zzs)localObject;
  }
  
  public zzs zzb(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzev paramzzev)
  {
    Object localObject;
    if (zzl.zzcN().zzT(paramContext))
    {
      zzs localzzs = zza(paramContext, paramAdSizeParcel, paramString, paramzzev, 2);
      localObject = localzzs;
      if (localzzs != null) {}
    }
    else
    {
      zzb.zzaH("Using InterstitialAdManager from the client jar.");
      localObject = new VersionInfoParcel(8298000, 8298000, true);
      if (!((Boolean)zzbz.zzwj.get()).booleanValue()) {
        break label86;
      }
      localObject = new zzeg(paramContext, paramString, paramzzev, (VersionInfoParcel)localObject, com.google.android.gms.ads.internal.zzd.zzbf());
    }
    return (zzs)localObject;
    label86:
    return new zzk(paramContext, paramAdSizeParcel, paramString, paramzzev, (VersionInfoParcel)localObject, com.google.android.gms.ads.internal.zzd.zzbf());
  }
  
  protected zzt zze(IBinder paramIBinder)
  {
    return zzt.zza.zzl(paramIBinder);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/client/zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */