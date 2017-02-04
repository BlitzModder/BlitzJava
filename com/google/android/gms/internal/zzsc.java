package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.signin.internal.zze;
import java.util.Set;

public abstract interface zzsc
  extends Api.zzb
{
  public abstract void connect();
  
  public abstract void zzDL();
  
  public abstract void zza(zzp paramzzp, Set<Scope> paramSet, zze paramzze);
  
  public abstract void zza(zzp paramzzp, boolean paramBoolean);
  
  public abstract void zza(zzt paramzzt);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzsc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */