package com.google.android.gms.ads.internal.formats;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzan;
import com.google.android.gms.internal.zzfa;
import com.google.android.gms.internal.zzfb;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzjn;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

@zzha
public class zzg
  extends zzh
{
  private Object zzpK = new Object();
  private zzfa zzxN;
  private zzfb zzxO;
  private final zzn zzxP;
  private zzh zzxQ;
  private boolean zzxR = false;
  
  private zzg(Context paramContext, zzn paramzzn, zzan paramzzan)
  {
    super(paramContext, paramzzn, null, paramzzan, null, null, null);
    this.zzxP = paramzzn;
  }
  
  public zzg(Context paramContext, zzn paramzzn, zzan paramzzan, zzfa paramzzfa)
  {
    this(paramContext, paramzzn, paramzzan);
    this.zzxN = paramzzfa;
  }
  
  public zzg(Context paramContext, zzn paramzzn, zzan paramzzan, zzfb paramzzfb)
  {
    this(paramContext, paramzzn, paramzzan);
    this.zzxO = paramzzfb;
  }
  
  public void recordImpression()
  {
    zzx.zzcx("recordImpression must be called on the main UI thread.");
    for (;;)
    {
      synchronized (this.zzpK)
      {
        zzn(true);
        if (this.zzxQ != null)
        {
          this.zzxQ.recordImpression();
          this.zzxP.recordImpression();
          return;
        }
        try
        {
          if ((this.zzxN != null) && (!this.zzxN.getOverrideClickHandling())) {
            this.zzxN.recordImpression();
          }
        }
        catch (RemoteException localRemoteException)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call recordImpression", localRemoteException);
        }
      }
      if ((this.zzxO != null) && (!this.zzxO.getOverrideClickHandling())) {
        this.zzxO.recordImpression();
      }
    }
  }
  
  public zzb zza(View.OnClickListener paramOnClickListener)
  {
    return null;
  }
  
  public void zza(View paramView, Map<String, WeakReference<View>> paramMap, JSONObject paramJSONObject1, JSONObject paramJSONObject2, JSONObject paramJSONObject3)
  {
    zzx.zzcx("performClick must be called on the main UI thread.");
    synchronized (this.zzpK)
    {
      if (this.zzxQ != null) {
        this.zzxQ.zza(paramView, paramMap, paramJSONObject1, paramJSONObject2, paramJSONObject3);
      }
      for (;;)
      {
        this.zzxP.onAdClicked();
        return;
        try
        {
          if ((this.zzxN != null) && (!this.zzxN.getOverrideClickHandling())) {
            this.zzxN.zzc(zze.zzB(paramView));
          }
          if ((this.zzxO == null) || (this.zzxO.getOverrideClickHandling())) {
            continue;
          }
          this.zzxN.zzc(zze.zzB(paramView));
        }
        catch (RemoteException paramView)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call performClick", paramView);
        }
      }
    }
  }
  
  public void zzc(zzh paramzzh)
  {
    synchronized (this.zzpK)
    {
      this.zzxQ = paramzzh;
      return;
    }
  }
  
  public boolean zzdI()
  {
    synchronized (this.zzpK)
    {
      boolean bool = this.zzxR;
      return bool;
    }
  }
  
  public zzh zzdJ()
  {
    synchronized (this.zzpK)
    {
      zzh localzzh = this.zzxQ;
      return localzzh;
    }
  }
  
  public zzjn zzdK()
  {
    return null;
  }
  
  public void zzh(View paramView)
  {
    synchronized (this.zzpK)
    {
      this.zzxR = true;
      try
      {
        if (this.zzxN != null) {
          this.zzxN.zzd(zze.zzB(paramView));
        }
        for (;;)
        {
          this.zzxR = false;
          return;
          if (this.zzxO != null) {
            this.zzxO.zzd(zze.zzB(paramView));
          }
        }
      }
      catch (RemoteException paramView)
      {
        for (;;)
        {
          com.google.android.gms.ads.internal.util.client.zzb.zzd("Failed to call prepareAd", paramView);
        }
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/formats/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */