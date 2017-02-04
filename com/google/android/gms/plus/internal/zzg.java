package com.google.android.gms.plus.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.plus.PlusOneDummyView;

public final class zzg
  extends com.google.android.gms.dynamic.zzg<zzc>
{
  private static final zzg zzaZd = new zzg();
  
  private zzg()
  {
    super("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl");
  }
  
  public static View zza(Context paramContext, int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if (paramString == null) {
      try
      {
        throw new NullPointerException();
      }
      catch (Exception paramString)
      {
        return new PlusOneDummyView(paramContext, paramInt1);
      }
    }
    paramString = (View)zze.zzp(((zzc)zzaZd.zzaA(paramContext)).zza(zze.zzB(paramContext), paramInt1, paramInt2, paramString, paramInt3));
    return paramString;
  }
  
  protected zzc zzdO(IBinder paramIBinder)
  {
    return zzc.zza.zzdL(paramIBinder);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/plus/internal/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */