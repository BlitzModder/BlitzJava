package com.google.android.gms.internal;

import android.content.MutableContextWrapper;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.LinkedList;

@zzha
class zzef
{
  private final String zzpH;
  private AdRequestParcel zzqo;
  private final LinkedList<zza> zzzW;
  
  zzef(AdRequestParcel paramAdRequestParcel, String paramString)
  {
    zzx.zzy(paramAdRequestParcel);
    zzx.zzy(paramString);
    this.zzzW = new LinkedList();
    this.zzqo = paramAdRequestParcel;
    this.zzpH = paramString;
  }
  
  String getAdUnitId()
  {
    return this.zzpH;
  }
  
  int size()
  {
    return this.zzzW.size();
  }
  
  void zzb(zzea paramzzea)
  {
    paramzzea = new zza(paramzzea);
    this.zzzW.add(paramzzea);
    paramzzea.zzh(this.zzqo);
  }
  
  AdRequestParcel zzeb()
  {
    return this.zzqo;
  }
  
  zza zzec()
  {
    return (zza)this.zzzW.remove();
  }
  
  class zza
  {
    boolean zzAa;
    boolean zzAb;
    zzk zzzX;
    zzeb zzzY;
    long zzzZ;
    MutableContextWrapper zzzz;
    
    zza(zzea paramzzea)
    {
      zzea localzzea = paramzzea.zzdV();
      this.zzzz = paramzzea.zzdW();
      this.zzzX = localzzea.zzac(zzef.zza(zzef.this));
      this.zzzY = new zzeb();
      this.zzzY.zzc(this.zzzX);
    }
    
    private void zzed()
    {
      if ((!this.zzAa) && (zzef.zzc(zzef.this) != null))
      {
        this.zzAb = this.zzzX.zzb(zzef.zzc(zzef.this));
        this.zzAa = true;
        this.zzzZ = zzp.zzbB().currentTimeMillis();
      }
    }
    
    void zzc(zzea paramzzea)
    {
      paramzzea = paramzzea.zzdW().getBaseContext();
      this.zzzz.setBaseContext(paramzzea);
    }
    
    void zzh(AdRequestParcel paramAdRequestParcel)
    {
      if (paramAdRequestParcel != null) {
        zzef.zza(zzef.this, paramAdRequestParcel);
      }
      zzed();
      paramAdRequestParcel = zzef.zzb(zzef.this).iterator();
      while (paramAdRequestParcel.hasNext()) {
        ((zza)paramAdRequestParcel.next()).zzed();
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */