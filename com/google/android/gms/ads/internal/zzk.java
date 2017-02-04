package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.view.View;
import android.view.Window;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzay;
import com.google.android.gms.internal.zzbv;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzch;
import com.google.android.gms.internal.zzdp;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzex;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzie;
import com.google.android.gms.internal.zzie.zza;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zziq;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzjp;

@zzha
public class zzk
  extends zzc
  implements zzdp
{
  protected transient boolean zzpR = false;
  private boolean zzpS;
  private float zzpT;
  private String zzpU = "background" + hashCode() + "." + "png";
  
  public zzk(Context paramContext, AdSizeParcel paramAdSizeParcel, String paramString, zzew paramzzew, VersionInfoParcel paramVersionInfoParcel, zzd paramzzd)
  {
    super(paramContext, paramAdSizeParcel, paramString, paramzzew, paramVersionInfoParcel, paramzzd);
  }
  
  private void zzb(Bundle paramBundle)
  {
    zzp.zzbx().zzb(this.zzoZ.context, this.zzoZ.zzqR.afmaVersion, "gmob-apps", paramBundle, false);
  }
  
  public void showInterstitial()
  {
    zzx.zzcx("showInterstitial must be called on the main UI thread.");
    if (this.zzoZ.zzqW == null)
    {
      zzb.zzaH("The interstitial has not loaded.");
      return;
    }
    if (((Boolean)zzbz.zzws.get()).booleanValue()) {
      if (this.zzoZ.context.getApplicationContext() == null) {
        break label211;
      }
    }
    label211:
    for (String str = this.zzoZ.context.getApplicationContext().getPackageName();; localObject = this.zzoZ.context.getPackageName())
    {
      Bundle localBundle;
      if (!this.zzpR)
      {
        zzb.zzaH("It is not recommended to show an interstitial before onAdLoaded completes.");
        localBundle = new Bundle();
        localBundle.putString("appid", str);
        localBundle.putString("action", "show_interstitial_before_load_finish");
        zzb(localBundle);
      }
      if (!zzp.zzbx().zzP(this.zzoZ.context))
      {
        zzb.zzaH("It is not recommended to show an interstitial when app is not in foreground.");
        localBundle = new Bundle();
        localBundle.putString("appid", str);
        localBundle.putString("action", "show_interstitial_app_not_in_foreground");
        zzb(localBundle);
      }
      if (this.zzoZ.zzbR()) {
        break;
      }
      if (!this.zzoZ.zzqW.zzGN) {
        break label225;
      }
      try
      {
        this.zzoZ.zzqW.zzBq.showInterstitial();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        zzb.zzd("Could not show interstitial.", localRemoteException);
        zzbo();
        return;
      }
    }
    label225:
    if (this.zzoZ.zzqW.zzDC == null)
    {
      zzb.zzaH("The interstitial failed to load.");
      return;
    }
    if (this.zzoZ.zzqW.zzDC.zzhG())
    {
      zzb.zzaH("The interstitial is already showing.");
      return;
    }
    this.zzoZ.zzqW.zzDC.zzD(true);
    if (this.zzoZ.zzqW.zzJE != null) {
      this.zzpb.zza(this.zzoZ.zzqV, this.zzoZ.zzqW);
    }
    if (this.zzoZ.zzqa) {}
    for (Object localObject = zzp.zzbx().zzQ(this.zzoZ.context); (((Boolean)zzbz.zzwI.get()).booleanValue()) && (localObject != null); localObject = null)
    {
      new zzb((Bitmap)localObject, this.zzpU).zzgX();
      return;
    }
    localObject = new InterstitialAdParameterParcel(this.zzoZ.zzqa, zzbn(), null, false, 0.0F);
    int j = this.zzoZ.zzqW.zzDC.getRequestedOrientation();
    int i = j;
    if (j == -1) {
      i = this.zzoZ.zzqW.orientation;
    }
    localObject = new AdOverlayInfoParcel(this, this, this, this.zzoZ.zzqW.zzDC, i, this.zzoZ.zzqR, this.zzoZ.zzqW.zzGS, (InterstitialAdParameterParcel)localObject);
    zzp.zzbv().zza(this.zzoZ.context, (AdOverlayInfoParcel)localObject);
  }
  
  protected zzjn zza(zzie.zza paramzza, zze paramzze)
  {
    zzjn localzzjn = zzp.zzby().zza(this.zzoZ.context, this.zzoZ.zzqV, false, false, this.zzoZ.zzqQ, this.zzoZ.zzqR, this.zzoU, this.zzpc);
    localzzjn.zzhC().zzb(this, null, this, this, ((Boolean)zzbz.zzwa.get()).booleanValue(), this, this, paramzze, null);
    localzzjn.zzaJ(paramzza.zzJK.zzGF);
    return localzzjn;
  }
  
  public void zza(boolean paramBoolean, float paramFloat)
  {
    this.zzpS = paramBoolean;
    this.zzpT = paramFloat;
  }
  
  public boolean zza(AdRequestParcel paramAdRequestParcel, zzch paramzzch)
  {
    if (this.zzoZ.zzqW != null)
    {
      zzb.zzaH("An interstitial is already loading. Aborting.");
      return false;
    }
    return super.zza(paramAdRequestParcel, paramzzch);
  }
  
  protected boolean zza(AdRequestParcel paramAdRequestParcel, zzie paramzzie, boolean paramBoolean)
  {
    if ((this.zzoZ.zzbQ()) && (paramzzie.zzDC != null)) {
      zzp.zzbz().zzf(paramzzie.zzDC);
    }
    return this.zzoY.zzbr();
  }
  
  public boolean zza(zzie paramzzie1, zzie paramzzie2)
  {
    if (!super.zza(paramzzie1, paramzzie2)) {
      return false;
    }
    if ((!this.zzoZ.zzbQ()) && (this.zzoZ.zzro != null) && (paramzzie2.zzJE != null)) {
      this.zzpb.zza(this.zzoZ.zzqV, paramzzie2, this.zzoZ.zzro);
    }
    return true;
  }
  
  protected boolean zzaS()
  {
    zzbo();
    return super.zzaS();
  }
  
  protected boolean zzaV()
  {
    if (super.zzaV())
    {
      this.zzpR = true;
      return true;
    }
    return false;
  }
  
  public void zzaY()
  {
    recordImpression();
    super.zzaY();
  }
  
  protected boolean zzbn()
  {
    if (!(this.zzoZ.context instanceof Activity)) {}
    Window localWindow;
    do
    {
      return false;
      localWindow = ((Activity)this.zzoZ.context).getWindow();
    } while ((localWindow == null) || (localWindow.getDecorView() == null));
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    localWindow.getDecorView().getGlobalVisibleRect(localRect1, null);
    localWindow.getDecorView().getWindowVisibleDisplayFrame(localRect2);
    if ((localRect1.bottom != 0) && (localRect2.bottom != 0) && (localRect1.top == localRect2.top)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void zzbo()
  {
    new zza(this.zzpU).zzgX();
    if (this.zzoZ.zzbQ())
    {
      this.zzoZ.zzbN();
      this.zzoZ.zzqW = null;
      this.zzoZ.zzqa = false;
      this.zzpR = false;
    }
  }
  
  public void zzd(boolean paramBoolean)
  {
    this.zzoZ.zzqa = paramBoolean;
  }
  
  @zzha
  private class zza
    extends zzil
  {
    private final String zzpV;
    
    public zza(String paramString)
    {
      this.zzpV = paramString;
    }
    
    public void onStop() {}
    
    public void zzbp()
    {
      zzp.zzbx().zzf(zzk.this.zzoZ.context, this.zzpV);
    }
  }
  
  @zzha
  private class zzb
    extends zzil
  {
    private final String zzpV;
    private final Bitmap zzpX;
    
    public zzb(Bitmap paramBitmap, String paramString)
    {
      this.zzpX = paramBitmap;
      this.zzpV = paramString;
    }
    
    public void onStop() {}
    
    public void zzbp()
    {
      boolean bool1;
      boolean bool2;
      boolean bool3;
      if (zzk.this.zzoZ.zzqa)
      {
        bool1 = zzp.zzbx().zza(zzk.this.zzoZ.context, this.zzpX, this.zzpV);
        bool2 = zzk.this.zzoZ.zzqa;
        bool3 = zzk.this.zzbn();
        if (!bool1) {
          break label221;
        }
      }
      label221:
      for (final Object localObject = this.zzpV;; localObject = null)
      {
        localObject = new InterstitialAdParameterParcel(bool2, bool3, (String)localObject, zzk.zza(zzk.this), zzk.zzb(zzk.this));
        int j = zzk.this.zzoZ.zzqW.zzDC.getRequestedOrientation();
        int i = j;
        if (j == -1) {
          i = zzk.this.zzoZ.zzqW.orientation;
        }
        localObject = new AdOverlayInfoParcel(zzk.this, zzk.this, zzk.this, zzk.this.zzoZ.zzqW.zzDC, i, zzk.this.zzoZ.zzqR, zzk.this.zzoZ.zzqW.zzGS, (InterstitialAdParameterParcel)localObject);
        zzip.zzKO.post(new Runnable()
        {
          public void run()
          {
            zzp.zzbv().zza(zzk.this.zzoZ.context, localObject);
          }
        });
        return;
        bool1 = false;
        break;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */