package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.WeakHashMap;

@zzha
public final class zzhj
{
  private WeakHashMap<Context, zza> zzIW = new WeakHashMap();
  
  public zzhi zzE(Context paramContext)
  {
    Object localObject = (zza)this.zzIW.get(paramContext);
    if ((localObject != null) && (!((zza)localObject).hasExpired()) && (((Boolean)zzbz.zzwq.get()).booleanValue())) {}
    for (localObject = new zzhi.zza(paramContext, ((zza)localObject).zzIY).zzgv();; localObject = new zzhi.zza(paramContext).zzgv())
    {
      this.zzIW.put(paramContext, new zza((zzhi)localObject));
      return (zzhi)localObject;
    }
  }
  
  private class zza
  {
    public final long zzIX = zzp.zzbB().currentTimeMillis();
    public final zzhi zzIY;
    
    public zza(zzhi paramzzhi)
    {
      this.zzIY = paramzzhi;
    }
    
    public boolean hasExpired()
    {
      return this.zzIX + ((Long)zzbz.zzwr.get()).longValue() < zzp.zzbB().currentTimeMillis();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzhj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */