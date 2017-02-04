package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.formats.zzj;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

@zzha
public class zzdb
  extends zzg<zzcq>
{
  public zzdb()
  {
    super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
  }
  
  private zzcp zzb(Context paramContext, FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2)
  {
    try
    {
      zzd localzzd = zze.zzB(paramContext);
      paramFrameLayout1 = zze.zzB(paramFrameLayout1);
      paramFrameLayout2 = zze.zzB(paramFrameLayout2);
      paramContext = zzcp.zza.zzu(((zzcq)zzaA(paramContext)).zza(localzzd, paramFrameLayout1, paramFrameLayout2, 8298000));
      return paramContext;
    }
    catch (zzg.zza paramContext)
    {
      zzb.zzd("Could not create remote NativeAdViewDelegate.", paramContext);
      return null;
    }
    catch (RemoteException paramContext)
    {
      for (;;) {}
    }
  }
  
  protected zzcq zzD(IBinder paramIBinder)
  {
    return zzcq.zza.zzv(paramIBinder);
  }
  
  public zzcp zza(Context paramContext, FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2)
  {
    if (zzl.zzcN().zzT(paramContext))
    {
      zzcp localzzcp = zzb(paramContext, paramFrameLayout1, paramFrameLayout2);
      paramContext = localzzcp;
      if (localzzcp != null) {}
    }
    else
    {
      zzb.zzaF("Using NativeAdViewDelegate from the client jar.");
      paramContext = new zzj(paramFrameLayout1, paramFrameLayout2);
    }
    return paramContext;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzdb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */