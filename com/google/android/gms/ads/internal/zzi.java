package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.support.v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzo;
import com.google.android.gms.ads.internal.client.zzp.zza;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcx;
import com.google.android.gms.internal.zzcy;
import com.google.android.gms.internal.zzcz;
import com.google.android.gms.internal.zzda;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzip;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@zzha
public class zzi
  extends zzp.zza
{
  private final Context mContext;
  private final zzcx zzpA;
  private final zzcy zzpB;
  private final SimpleArrayMap<String, zzda> zzpC;
  private final SimpleArrayMap<String, zzcz> zzpD;
  private final NativeAdOptionsParcel zzpE;
  private final List<String> zzpF;
  private final zzv zzpG;
  private final String zzpH;
  private final VersionInfoParcel zzpI;
  private WeakReference<zzn> zzpJ;
  private final Object zzpK = new Object();
  private final zzew zzpd;
  private final zzo zzpz;
  
  zzi(Context paramContext, String paramString, zzew paramzzew, VersionInfoParcel paramVersionInfoParcel, zzo paramzzo, zzcx paramzzcx, zzcy paramzzcy, SimpleArrayMap<String, zzda> paramSimpleArrayMap, SimpleArrayMap<String, zzcz> paramSimpleArrayMap1, NativeAdOptionsParcel paramNativeAdOptionsParcel, zzv paramzzv)
  {
    this.mContext = paramContext;
    this.zzpH = paramString;
    this.zzpd = paramzzew;
    this.zzpI = paramVersionInfoParcel;
    this.zzpz = paramzzo;
    this.zzpB = paramzzcy;
    this.zzpA = paramzzcx;
    this.zzpC = paramSimpleArrayMap;
    this.zzpD = paramSimpleArrayMap1;
    this.zzpE = paramNativeAdOptionsParcel;
    this.zzpF = zzbk();
    this.zzpG = paramzzv;
  }
  
  private List<String> zzbk()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.zzpB != null) {
      localArrayList.add("1");
    }
    if (this.zzpA != null) {
      localArrayList.add("2");
    }
    if (this.zzpC.size() > 0) {
      localArrayList.add("3");
    }
    return localArrayList;
  }
  
  public String getMediationAdapterClassName()
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        if (this.zzpJ != null)
        {
          Object localObject1 = (zzn)this.zzpJ.get();
          if (localObject1 != null)
          {
            localObject1 = ((zzn)localObject1).getMediationAdapterClassName();
            return (String)localObject1;
          }
        }
        else
        {
          return null;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public boolean isLoading()
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        if (this.zzpJ != null)
        {
          zzn localzzn = (zzn)this.zzpJ.get();
          if (localzzn != null)
          {
            bool = localzzn.isLoading();
            return bool;
          }
        }
        else
        {
          return false;
        }
      }
      boolean bool = false;
    }
  }
  
  protected void runOnUiThread(Runnable paramRunnable)
  {
    zzip.zzKO.post(paramRunnable);
  }
  
  protected zzn zzbl()
  {
    return new zzn(this.mContext, AdSizeParcel.zzt(this.mContext), this.zzpH, this.zzpd, this.zzpI);
  }
  
  public void zzf(final AdRequestParcel paramAdRequestParcel)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        synchronized (zzi.zza(zzi.this))
        {
          zzn localzzn = zzi.this.zzbl();
          zzi.zza(zzi.this, new WeakReference(localzzn));
          localzzn.zzb(zzi.zzb(zzi.this));
          localzzn.zzb(zzi.zzc(zzi.this));
          localzzn.zza(zzi.zzd(zzi.this));
          localzzn.zza(zzi.zze(zzi.this));
          localzzn.zzb(zzi.zzf(zzi.this));
          localzzn.zza(zzi.zzg(zzi.this));
          localzzn.zzb(zzi.zzh(zzi.this));
          localzzn.zza(zzi.zzi(zzi.this));
          localzzn.zzb(paramAdRequestParcel);
          return;
        }
      }
    });
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */