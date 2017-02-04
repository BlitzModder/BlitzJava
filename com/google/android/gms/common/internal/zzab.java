package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;

public final class zzab
  extends zzg<zzu>
{
  private static final zzab zzakF = new zzab();
  
  private zzab()
  {
    super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
  }
  
  public static View zzb(Context paramContext, int paramInt1, int paramInt2, Scope[] paramArrayOfScope)
    throws zzg.zza
  {
    return zzakF.zzc(paramContext, paramInt1, paramInt2, paramArrayOfScope);
  }
  
  private View zzc(Context paramContext, int paramInt1, int paramInt2, Scope[] paramArrayOfScope)
    throws zzg.zza
  {
    try
    {
      paramArrayOfScope = new SignInButtonConfig(paramInt1, paramInt2, paramArrayOfScope);
      zzd localzzd = zze.zzB(paramContext);
      paramContext = (View)zze.zzp(((zzu)zzaA(paramContext)).zza(localzzd, paramArrayOfScope));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      throw new zzg.zza("Could not get button with size " + paramInt1 + " and color " + paramInt2, paramContext);
    }
  }
  
  public zzu zzaV(IBinder paramIBinder)
  {
    return zzu.zza.zzaU(paramIBinder);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/internal/zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */