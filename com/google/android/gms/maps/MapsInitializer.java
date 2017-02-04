package com.google.android.gms.maps;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.internal.zzc;
import com.google.android.gms.maps.internal.zzy;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class MapsInitializer
{
  private static boolean zznK = false;
  
  public static int initialize(Context paramContext)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        zzx.zzb(paramContext, "Context is null");
        boolean bool = zznK;
        if (!bool) {
          continue;
        }
      }
      finally
      {
        try
        {
          paramContext = zzy.zzaP(paramContext);
          zza(paramContext);
          zznK = true;
        }
        catch (GooglePlayServicesNotAvailableException paramContext)
        {
          i = paramContext.errorCode;
        }
        paramContext = finally;
      }
      return i;
    }
  }
  
  public static void zza(zzc paramzzc)
  {
    try
    {
      CameraUpdateFactory.zza(paramzzc.zzzp());
      BitmapDescriptorFactory.zza(paramzzc.zzzq());
      return;
    }
    catch (RemoteException paramzzc)
    {
      throw new RuntimeRemoteException(paramzzc);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/MapsInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */