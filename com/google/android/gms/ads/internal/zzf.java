package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzaz;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zzie.zza;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzjo.zzb;
import java.util.List;

@zzha
public class zzf
  extends zzc
{
  private boolean zzpt;
  
  public zzf(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzew paramzzew, VersionInfoParcel paramVersionInfoParcel, zzd paramzzd)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramzzew, paramVersionInfoParcel, paramzzd);
  }
  
  private AdSizeParcel zzb(zzie.zza paramzza)
  {
    if (paramzza.zzJL.zztZ) {
      return this.zzoZ.zzqV;
    }
    paramzza = paramzza.zzJL.zzGQ;
    if (paramzza != null)
    {
      paramzza = paramzza.split("[xX]");
      paramzza[0] = paramzza[0].trim();
      paramzza[1] = paramzza[1].trim();
    }
    for (paramzza = new AdSize(Integer.parseInt(paramzza[0]), Integer.parseInt(paramzza[1]));; paramzza = this.zzoZ.zzqV.zzcL()) {
      return new AdSizeParcel(this.zzoZ.context, paramzza);
    }
  }
  
  private boolean zzb(zzie paramzzie1, zzie paramzzie2)
  {
    if (paramzzie2.zzGN) {}
    for (;;)
    {
      try
      {
        paramzzie2 = paramzzie2.zzBq.getView();
        if (paramzzie2 == null)
        {
          zzb.zzaH("View in mediation adapter is null.");
          return false;
        }
        paramzzie2 = (View)com.google.android.gms.dynamic.zze.zzp(paramzzie2);
        View localView = this.zzoZ.zzqS.getNextView();
        if (localView != null)
        {
          if ((localView instanceof zzjn)) {
            ((zzjn)localView).destroy();
          }
          this.zzoZ.zzqS.removeView(localView);
        }
        if (paramzzie2.zzJG == null) {
          continue;
        }
      }
      catch (RemoteException paramzzie1)
      {
        try
        {
          zzb(paramzzie2);
          if (this.zzoZ.zzqS.getChildCount() > 1) {
            this.zzoZ.zzqS.showNext();
          }
          if (paramzzie1 != null)
          {
            paramzzie1 = this.zzoZ.zzqS.getNextView();
            if (!(paramzzie1 instanceof zzjn)) {
              break label281;
            }
            ((zzjn)paramzzie1).zza(this.zzoZ.context, this.zzoZ.zzqV, this.zzoU);
            this.zzoZ.zzbP();
          }
          this.zzoZ.zzqS.setVisibility(0);
          return true;
        }
        catch (Throwable paramzzie1)
        {
          zzb.zzd("Could not add mediation view to view hierarchy.", paramzzie1);
          return false;
        }
        paramzzie1 = paramzzie1;
        zzb.zzd("Could not get View from mediation adapter.", paramzzie1);
        return false;
      }
      if (paramzzie2.zzDC != null)
      {
        paramzzie2.zzDC.zza(paramzzie2.zzJG);
        this.zzoZ.zzqS.removeAllViews();
        this.zzoZ.zzqS.setMinimumWidth(paramzzie2.zzJG.widthPixels);
        this.zzoZ.zzqS.setMinimumHeight(paramzzie2.zzJG.heightPixels);
        zzb(paramzzie2.zzDC.getView());
        continue;
        label281:
        if (paramzzie1 != null) {
          this.zzoZ.zzqS.removeView(paramzzie1);
        }
      }
    }
  }
  
  public void setManualImpressionsEnabled(boolean paramBoolean)
  {
    zzx.zzcx("setManualImpressionsEnabled must be called from the main thread.");
    this.zzpt = paramBoolean;
  }
  
  public void showInterstitial()
  {
    throw new IllegalStateException("Interstitial is NOT supported by BannerAdManager.");
  }
  
  protected zzjn zza(zzie.zza paramzza, zze paramzze)
  {
    if (this.zzoZ.zzqV.zztZ) {
      this.zzoZ.zzqV = zzb(paramzza);
    }
    return super.zza(paramzza, paramzze);
  }
  
  public boolean zza(zzie paramzzie1, final zzie paramzzie2)
  {
    if (!super.zza(paramzzie1, paramzzie2)) {
      return false;
    }
    if ((this.zzoZ.zzbQ()) && (!zzb(paramzzie1, paramzzie2)))
    {
      zzf(0);
      return false;
    }
    zza(paramzzie2, false);
    if (this.zzoZ.zzbQ()) {
      if (paramzzie2.zzDC != null)
      {
        if (paramzzie2.zzJE != null) {
          this.zzpb.zza(this.zzoZ.zzqV, paramzzie2);
        }
        if (!paramzzie2.zzcb()) {
          break label115;
        }
        this.zzpb.zza(this.zzoZ.zzqV, paramzzie2).zza(paramzzie2.zzDC);
      }
    }
    for (;;)
    {
      return true;
      label115:
      paramzzie2.zzDC.zzhC().zza(new zzjo.zzb()
      {
        public void zzbh()
        {
          zzf.this.zzpb.zza(zzf.this.zzoZ.zzqV, paramzzie2).zza(paramzzie2.zzDC);
        }
      });
      continue;
      if ((this.zzoZ.zzro != null) && (paramzzie2.zzJE != null)) {
        this.zzpb.zza(this.zzoZ.zzqV, paramzzie2, this.zzoZ.zzro);
      }
    }
  }
  
  protected boolean zzaW()
  {
    boolean bool = true;
    if (!zzp.zzbx().zza(this.zzoZ.context.getPackageManager(), this.zzoZ.context.getPackageName(), "android.permission.INTERNET"))
    {
      zzl.zzcN().zza(this.zzoZ.zzqS, this.zzoZ.zzqV, "Missing internet permission in AndroidManifest.xml.", "Missing internet permission in AndroidManifest.xml. You must have the following declaration: <uses-permission android:name=\"android.permission.INTERNET\" />");
      bool = false;
    }
    if (!zzp.zzbx().zzJ(this.zzoZ.context))
    {
      zzl.zzcN().zza(this.zzoZ.zzqS, this.zzoZ.zzqV, "Missing AdActivity with android:configChanges in AndroidManifest.xml.", "Missing AdActivity with android:configChanges in AndroidManifest.xml. You must have the following declaration within the <application> element: <activity android:name=\"com.google.android.gms.ads.AdActivity\" android:configChanges=\"keyboard|keyboardHidden|orientation|screenLayout|uiMode|screenSize|smallestScreenSize\" />");
      bool = false;
    }
    if ((!bool) && (this.zzoZ.zzqS != null)) {
      this.zzoZ.zzqS.setVisibility(0);
    }
    return bool;
  }
  
  public boolean zzb(AdRequestParcel paramAdRequestParcel)
  {
    return super.zzb(zze(paramAdRequestParcel));
  }
  
  AdRequestParcel zze(AdRequestParcel paramAdRequestParcel)
  {
    if (paramAdRequestParcel.zztv == this.zzpt) {
      return paramAdRequestParcel;
    }
    int i = paramAdRequestParcel.versionCode;
    long l = paramAdRequestParcel.zztq;
    Bundle localBundle = paramAdRequestParcel.extras;
    int j = paramAdRequestParcel.zztr;
    List localList = paramAdRequestParcel.zzts;
    boolean bool2 = paramAdRequestParcel.zztt;
    int k = paramAdRequestParcel.zztu;
    if ((paramAdRequestParcel.zztv) || (this.zzpt)) {}
    for (boolean bool1 = true;; bool1 = false) {
      return new AdRequestParcel(i, l, localBundle, j, localList, bool2, k, bool1, paramAdRequestParcel.zztw, paramAdRequestParcel.zztx, paramAdRequestParcel.zzty, paramAdRequestParcel.zztz, paramAdRequestParcel.zztA, paramAdRequestParcel.zztB, paramAdRequestParcel.zztC, paramAdRequestParcel.zztD, paramAdRequestParcel.zztE, paramAdRequestParcel.zztF);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */