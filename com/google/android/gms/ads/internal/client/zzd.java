package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzha;

@zzha
public final class zzd
  extends zzg<zzr>
{
  private static final zzd zztp = new zzd();
  
  private zzd()
  {
    super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
  }
  
  public static zzq zza(Context paramContext, String paramString, zzev paramzzev)
  {
    Object localObject;
    if (zzl.zzcN().zzT(paramContext))
    {
      zzq localzzq = zztp.zzb(paramContext, paramString, paramzzev);
      localObject = localzzq;
      if (localzzq != null) {}
    }
    else
    {
      zzb.zzaF("Using AdLoader from the client jar.");
      localObject = new zzj(paramContext, paramString, paramzzev, new VersionInfoParcel(8298000, 8298000, true));
    }
    return (zzq)localObject;
  }
  
  private zzq zzb(Context paramContext, String paramString, zzev paramzzev)
  {
    try
    {
      com.google.android.gms.dynamic.zzd localzzd = zze.zzB(paramContext);
      paramContext = zzq.zza.zzi(((zzr)zzaA(paramContext)).zza(localzzd, paramString, paramzzev, 8298000));
      return paramContext;
    }
    catch (RemoteException paramContext)
    {
      zzb.zzd("Could not create remote builder for AdLoader.", paramContext);
      return null;
    }
    catch (zzg.zza paramContext)
    {
      for (;;)
      {
        zzb.zzd("Could not create remote builder for AdLoader.", paramContext);
      }
    }
  }
  
  protected zzr zzc(IBinder paramIBinder)
  {
    return zzr.zza.zzj(paramIBinder);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/client/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */