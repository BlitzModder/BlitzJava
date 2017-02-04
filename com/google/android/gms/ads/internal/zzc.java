package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzci;
import com.google.android.gms.internal.zzck;
import com.google.android.gms.internal.zzcl;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzgq;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zzie.zza;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzjp;

@zzha
public abstract class zzc
  extends zzb
  implements zzg, zzfs
{
  public zzc(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzew paramzzew, VersionInfoParcel paramVersionInfoParcel, zzd paramzzd)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramzzew, paramVersionInfoParcel, paramzzd);
  }
  
  public void recordClick()
  {
    onAdClicked();
  }
  
  public void recordImpression()
  {
    zza(this.zzoZ.zzqW, false);
  }
  
  protected zzjn zza(zzie.zza paramzza, zze paramzze)
  {
    Object localObject = this.zzoZ.zzqS.getNextView();
    if ((localObject instanceof zzjn))
    {
      com.google.android.gms.ads.internal.util.client.zzb.zzaF("Reusing webview...");
      localObject = (zzjn)localObject;
      ((zzjn)localObject).zza(this.zzoZ.context, this.zzoZ.zzqV, this.zzoU);
    }
    for (;;)
    {
      ((zzjn)localObject).zzhC().zzb(this, this, this, this, false, this, null, paramzze, this);
      ((zzjn)localObject).zzaJ(paramzza.zzJK.zzGF);
      return (zzjn)localObject;
      if (localObject != null) {
        this.zzoZ.zzqS.removeView((View)localObject);
      }
      localObject = zzp.zzby().zza(this.zzoZ.context, this.zzoZ.zzqV, false, false, this.zzoZ.zzqQ, this.zzoZ.zzqR, this.zzoU, this.zzpc);
      if (this.zzoZ.zzqV.zztX == null) {
        zzb(((zzjn)localObject).getView());
      }
    }
  }
  
  public void zza(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    zzaU();
  }
  
  public void zza(zzcl paramzzcl)
  {
    zzx.zzcx("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
    this.zzoZ.zzrk = paramzzcl;
  }
  
  protected void zza(final zzie.zza paramzza, final zzch paramzzch)
  {
    if (paramzza.errorCode != -2)
    {
      zzip.zzKO.post(new Runnable()
      {
        public void run()
        {
          zzc.this.zzb(new zzie(paramzza, null, null, null, null, null, null));
        }
      });
      return;
    }
    if (paramzza.zzqV != null) {
      this.zzoZ.zzqV = paramzza.zzqV;
    }
    if (paramzza.zzJL.zzGN)
    {
      this.zzoZ.zzrp = 0;
      this.zzoZ.zzqU = zzp.zzbw().zza(this.zzoZ.context, this, paramzza, this.zzoZ.zzqQ, null, this.zzpd, this, paramzzch);
      return;
    }
    zzip.zzKO.post(new Runnable()
    {
      public void run()
      {
        if ((paramzza.zzJL.zzGW) && (zzc.this.zzoZ.zzrk != null))
        {
          Object localObject = null;
          if (paramzza.zzJL.zzDE != null) {
            localObject = zzp.zzbx().zzaz(paramzza.zzJL.zzDE);
          }
          localObject = new zzci(zzc.this, (String)localObject, paramzza.zzJL.body);
          zzc.this.zzoZ.zzrp = 1;
          try
          {
            zzc.this.zzoZ.zzrk.zza((zzck)localObject);
            return;
          }
          catch (RemoteException localRemoteException)
          {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call the onCustomRenderedAdLoadedListener.", localRemoteException);
          }
        }
        final zze localzze = new zze();
        zzjn localzzjn = zzc.this.zza(paramzza, localzze);
        localzze.zza(new zze.zzb(paramzza, localzzjn));
        localzzjn.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
          {
            localzze.recordClick();
            return false;
          }
        });
        localzzjn.setOnClickListener(new View.OnClickListener()
        {
          public void onClick(View paramAnonymous2View)
          {
            localzze.recordClick();
          }
        });
        zzc.this.zzoZ.zzrp = 0;
        zzc.this.zzoZ.zzqU = zzp.zzbw().zza(zzc.this.zzoZ.context, zzc.this, paramzza, zzc.this.zzoZ.zzqQ, localzzjn, zzc.this.zzpd, zzc.this, paramzzch);
      }
    });
  }
  
  protected boolean zza(zzie paramzzie1, zzie paramzzie2)
  {
    if ((this.zzoZ.zzbQ()) && (this.zzoZ.zzqS != null)) {
      this.zzoZ.zzqS.zzbW().zzaC(paramzzie2.zzGS);
    }
    return super.zza(paramzzie1, paramzzie2);
  }
  
  public void zzbe()
  {
    zzaS();
  }
  
  public void zzc(View paramView)
  {
    this.zzoZ.zzro = paramView;
    zzb(new zzie(this.zzoZ.zzqX, null, null, null, null, null, null));
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */