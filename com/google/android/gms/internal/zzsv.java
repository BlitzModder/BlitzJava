package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.zzc;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;
import com.google.android.gms.wallet.fragment.WalletFragmentOptions;

public class zzsv
  extends zzg<zzsq>
{
  private static zzsv zzblu;
  
  protected zzsv()
  {
    super("com.google.android.gms.wallet.dynamite.WalletDynamiteCreatorImpl");
  }
  
  private static zzsv zzGt()
  {
    if (zzblu == null) {
      zzblu = new zzsv();
    }
    return zzblu;
  }
  
  public static zzsn zza(Activity paramActivity, zzc paramzzc, WalletFragmentOptions paramWalletFragmentOptions, zzso paramzzso)
    throws GooglePlayServicesNotAvailableException
  {
    int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramActivity);
    if (i != 0) {
      throw new GooglePlayServicesNotAvailableException(i);
    }
    try
    {
      paramActivity = ((zzsq)zzGt().zzaA(paramActivity)).zza(zze.zzB(paramActivity), paramzzc, paramWalletFragmentOptions, paramzzso);
      return paramActivity;
    }
    catch (RemoteException paramActivity)
    {
      throw new RuntimeException(paramActivity);
    }
    catch (zzg.zza paramActivity)
    {
      throw new RuntimeException(paramActivity);
    }
  }
  
  protected zzsq zzel(IBinder paramIBinder)
  {
    return zzsq.zza.zzeh(paramIBinder);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzsv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */