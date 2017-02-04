package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

@zzha
public final class zzft
  extends zzg<zzfv>
{
  private static final zzft zzEo = new zzft();
  
  private zzft()
  {
    super("com.google.android.gms.ads.AdOverlayCreatorImpl");
  }
  
  public static zzfu zzb(Activity paramActivity)
  {
    try
    {
      if (zzc(paramActivity))
      {
        zzb.zzaF("Using AdOverlay from the client jar.");
        return new com.google.android.gms.ads.internal.overlay.zzd(paramActivity);
      }
      paramActivity = zzEo.zzd(paramActivity);
      return paramActivity;
    }
    catch (zza paramActivity)
    {
      zzb.zzaH(paramActivity.getMessage());
    }
    return null;
  }
  
  private static boolean zzc(Activity paramActivity)
    throws zzft.zza
  {
    paramActivity = paramActivity.getIntent();
    if (!paramActivity.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
      throw new zza("Ad overlay requires the useClientJar flag in intent extras.");
    }
    return paramActivity.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
  }
  
  private zzfu zzd(Activity paramActivity)
  {
    try
    {
      com.google.android.gms.dynamic.zzd localzzd = zze.zzB(paramActivity);
      paramActivity = zzfu.zza.zzL(((zzfv)zzaA(paramActivity)).zze(localzzd));
      return paramActivity;
    }
    catch (RemoteException paramActivity)
    {
      zzb.zzd("Could not create remote AdOverlay.", paramActivity);
      return null;
    }
    catch (zzg.zza paramActivity)
    {
      zzb.zzd("Could not create remote AdOverlay.", paramActivity);
    }
    return null;
  }
  
  protected zzfv zzK(IBinder paramIBinder)
  {
    return zzfv.zza.zzM(paramIBinder);
  }
  
  private static final class zza
    extends Exception
  {
    public zza(String paramString)
    {
      super();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */