package com.google.android.gms.internal;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzh;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;

@zzha
public class zzay
  implements zzba
{
  private final VersionInfoParcel zzpI;
  private final Object zzpK = new Object();
  private final WeakHashMap<zzie, zzaz> zzrG = new WeakHashMap();
  private final ArrayList<zzaz> zzrH = new ArrayList();
  private final Context zzrI;
  private final zzei zzrJ;
  
  public zzay(Context paramContext, VersionInfoParcel paramVersionInfoParcel, zzei paramzzei)
  {
    this.zzrI = paramContext.getApplicationContext();
    this.zzpI = paramVersionInfoParcel;
    this.zzrJ = paramzzei;
  }
  
  public zzaz zza(AdSizeParcel paramAdSizeParcel, zzie paramzzie)
  {
    return zza(paramAdSizeParcel, paramzzie, paramzzie.zzDC.getView());
  }
  
  public zzaz zza(AdSizeParcel paramAdSizeParcel, zzie paramzzie, View paramView)
  {
    return zza(paramAdSizeParcel, paramzzie, new zzaz.zzd(paramView, paramzzie));
  }
  
  public zzaz zza(AdSizeParcel paramAdSizeParcel, zzie paramzzie, zzh paramzzh)
  {
    return zza(paramAdSizeParcel, paramzzie, new zzaz.zza(paramzzh));
  }
  
  public zzaz zza(AdSizeParcel paramAdSizeParcel, zzie paramzzie, zzbh paramzzbh)
  {
    synchronized (this.zzpK)
    {
      if (zzd(paramzzie))
      {
        paramAdSizeParcel = (zzaz)this.zzrG.get(paramzzie);
        return paramAdSizeParcel;
      }
      paramAdSizeParcel = new zzaz(this.zzrI, paramAdSizeParcel, paramzzie, this.zzpI, paramzzbh, this.zzrJ);
      paramAdSizeParcel.zza(this);
      this.zzrG.put(paramzzie, paramAdSizeParcel);
      this.zzrH.add(paramAdSizeParcel);
      return paramAdSizeParcel;
    }
  }
  
  public void zza(zzaz paramzzaz)
  {
    synchronized (this.zzpK)
    {
      if (!paramzzaz.zzch())
      {
        this.zzrH.remove(paramzzaz);
        Iterator localIterator = this.zzrG.entrySet().iterator();
        while (localIterator.hasNext()) {
          if (((Map.Entry)localIterator.next()).getValue() == paramzzaz) {
            localIterator.remove();
          }
        }
      }
    }
  }
  
  public boolean zzd(zzie paramzzie)
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        paramzzie = (zzaz)this.zzrG.get(paramzzie);
        if ((paramzzie != null) && (paramzzie.zzch()))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public void zze(zzie paramzzie)
  {
    synchronized (this.zzpK)
    {
      paramzzie = (zzaz)this.zzrG.get(paramzzie);
      if (paramzzie != null) {
        paramzzie.zzcf();
      }
      return;
    }
  }
  
  public void zzf(zzie paramzzie)
  {
    synchronized (this.zzpK)
    {
      paramzzie = (zzaz)this.zzrG.get(paramzzie);
      if (paramzzie != null) {
        paramzzie.stop();
      }
      return;
    }
  }
  
  public void zzg(zzie paramzzie)
  {
    synchronized (this.zzpK)
    {
      paramzzie = (zzaz)this.zzrG.get(paramzzie);
      if (paramzzie != null) {
        paramzzie.pause();
      }
      return;
    }
  }
  
  public void zzh(zzie paramzzie)
  {
    synchronized (this.zzpK)
    {
      paramzzie = (zzaz)this.zzrG.get(paramzzie);
      if (paramzzie != null) {
        paramzzie.resume();
      }
      return;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */