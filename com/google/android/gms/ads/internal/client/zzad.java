package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;
import com.google.android.gms.internal.zzha;

@zzha
public class zzad
  extends zzg<zzx>
{
  public zzad()
  {
    super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
  }
  
  private zzw zzv(Context paramContext)
  {
    try
    {
      zzd localzzd = zze.zzB(paramContext);
      paramContext = zzw.zza.zzo(((zzx)zzaA(paramContext)).zza(localzzd, 8298000));
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      zzb.zzd("Could not get remote MobileAdsSettingManager.", paramContext);
      return null;
    }
    catch (zzg.zza paramContext)
    {
      zzb.zzd("Could not get remote MobileAdsSettingManager.", paramContext);
    }
    return null;
  }
  
  protected zzx zzq(IBinder paramIBinder)
  {
    return zzx.zza.zzp(paramIBinder);
  }
  
  public zzw zzu(Context paramContext)
  {
    Object localObject;
    if (zzl.zzcN().zzT(paramContext))
    {
      zzw localzzw = zzv(paramContext);
      localObject = localzzw;
      if (localzzw != null) {}
    }
    else
    {
      zzb.zzaF("Using MobileAdsSettingManager from the client jar.");
      new VersionInfoParcel(8298000, 8298000, true);
      localObject = zzm.zzr(paramContext);
    }
    return (zzw)localObject;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/client/zzad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */