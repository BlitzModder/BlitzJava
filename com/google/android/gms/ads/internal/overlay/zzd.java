package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzbv;
import com.google.android.gms.internal.zzbz;
import com.google.android.gms.internal.zzfu.zza;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzip;
import com.google.android.gms.internal.zziq;
import com.google.android.gms.internal.zzis;
import com.google.android.gms.internal.zzjn;
import com.google.android.gms.internal.zzjo;
import com.google.android.gms.internal.zzjo.zza;
import com.google.android.gms.internal.zzjp;
import java.util.Collections;

@zzha
public class zzd
  extends zzfu.zza
  implements zzo
{
  static final int zzDg = Color.argb(0, 0, 0, 0);
  private final Activity mActivity;
  RelativeLayout zzCm;
  AdOverlayInfoParcel zzDh;
  zzc zzDi;
  zzm zzDj;
  boolean zzDk = false;
  FrameLayout zzDl;
  WebChromeClient.CustomViewCallback zzDm;
  boolean zzDn = false;
  boolean zzDo = false;
  boolean zzDp = false;
  int zzDq = 0;
  private boolean zzDr;
  private boolean zzDs = false;
  private boolean zzDt = true;
  zzjn zzps;
  
  public zzd(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  public void close()
  {
    this.zzDq = 2;
    this.mActivity.finish();
  }
  
  public void onBackPressed()
  {
    this.zzDq = 0;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    if (paramBundle != null) {
      bool = paramBundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
    }
    this.zzDn = bool;
    try
    {
      this.zzDh = AdOverlayInfoParcel.zzb(this.mActivity.getIntent());
      if (this.zzDh != null) {
        break label71;
      }
      throw new zza("Could not get info for ad overlay.");
    }
    catch (zza paramBundle)
    {
      zzb.zzaH(paramBundle.getMessage());
      this.zzDq = 3;
      this.mActivity.finish();
    }
    return;
    label71:
    if (this.zzDh.zzqR.zzLG > 7500000) {
      this.zzDq = 3;
    }
    if (this.mActivity.getIntent() != null) {
      this.zzDt = this.mActivity.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
    }
    if (this.zzDh.zzDL != null)
    {
      this.zzDo = this.zzDh.zzDL.zzqa;
      label142:
      if ((((Boolean)zzbz.zzwI.get()).booleanValue()) && (this.zzDo) && (this.zzDh.zzDL.zzqc != null)) {
        new zzd(null).zzgX();
      }
      if (paramBundle == null)
      {
        if ((this.zzDh.zzDB != null) && (this.zzDt)) {
          this.zzDh.zzDB.zzaY();
        }
        if ((this.zzDh.zzDI != 1) && (this.zzDh.zzDA != null)) {
          this.zzDh.zzDA.onAdClicked();
        }
      }
      this.zzCm = new zzb(this.mActivity, this.zzDh.zzDK);
      switch (this.zzDh.zzDI)
      {
      }
    }
    for (;;)
    {
      throw new zza("Could not determine ad overlay type.");
      this.zzDo = false;
      break label142;
      zzx(false);
      return;
      this.zzDi = new zzc(this.zzDh.zzDC);
      zzx(false);
      return;
      zzx(true);
      return;
      if (this.zzDn)
      {
        this.zzDq = 3;
        this.mActivity.finish();
        return;
      }
      if (zzp.zzbu().zza(this.mActivity, this.zzDh.zzDz, this.zzDh.zzDH)) {
        break;
      }
      this.zzDq = 3;
      this.mActivity.finish();
      return;
    }
  }
  
  public void onDestroy()
  {
    if (this.zzps != null) {
      this.zzCm.removeView(this.zzps.getView());
    }
    zzfe();
  }
  
  public void onPause()
  {
    zzfa();
    if ((this.zzps != null) && ((!this.mActivity.isFinishing()) || (this.zzDi == null))) {
      zzp.zzbz().zzf(this.zzps);
    }
    zzfe();
  }
  
  public void onRestart() {}
  
  public void onResume()
  {
    if ((this.zzDh != null) && (this.zzDh.zzDI == 4))
    {
      if (!this.zzDn) {
        break label68;
      }
      this.zzDq = 3;
      this.mActivity.finish();
    }
    while ((this.zzps != null) && (!this.zzps.isDestroyed()))
    {
      zzp.zzbz().zzg(this.zzps);
      return;
      label68:
      this.zzDn = true;
    }
    zzb.zzaH("The webview does not exit. Ignoring action.");
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzDn);
  }
  
  public void onStart() {}
  
  public void onStop()
  {
    zzfe();
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    this.mActivity.setRequestedOrientation(paramInt);
  }
  
  public void zza(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    this.zzDl = new FrameLayout(this.mActivity);
    this.zzDl.setBackgroundColor(-16777216);
    this.zzDl.addView(paramView, -1, -1);
    this.mActivity.setContentView(this.zzDl);
    zzaF();
    this.zzDm = paramCustomViewCallback;
    this.zzDk = true;
  }
  
  public void zza(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.zzDj != null) {
      this.zzDj.zza(paramBoolean1, paramBoolean2);
    }
  }
  
  public void zzaF()
  {
    this.zzDr = true;
  }
  
  public void zzfa()
  {
    if ((this.zzDh != null) && (this.zzDk)) {
      setRequestedOrientation(this.zzDh.orientation);
    }
    if (this.zzDl != null)
    {
      this.mActivity.setContentView(this.zzCm);
      zzaF();
      this.zzDl.removeAllViews();
      this.zzDl = null;
    }
    if (this.zzDm != null)
    {
      this.zzDm.onCustomViewHidden();
      this.zzDm = null;
    }
    this.zzDk = false;
  }
  
  public void zzfb()
  {
    this.zzDq = 1;
    this.mActivity.finish();
  }
  
  public boolean zzfc()
  {
    this.zzDq = 0;
    boolean bool1;
    if (this.zzps == null) {
      bool1 = true;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = this.zzps.zzhI();
      bool1 = bool2;
    } while (bool2);
    this.zzps.zzb("onbackblocked", Collections.emptyMap());
    return bool2;
  }
  
  public void zzfd()
  {
    this.zzCm.removeView(this.zzDj);
    zzw(true);
  }
  
  protected void zzfe()
  {
    if ((!this.mActivity.isFinishing()) || (this.zzDs)) {}
    do
    {
      return;
      this.zzDs = true;
      if (this.zzps != null)
      {
        zzy(this.zzDq);
        this.zzCm.removeView(this.zzps.getView());
        if (this.zzDi != null)
        {
          this.zzps.setContext(this.zzDi.context);
          this.zzps.zzD(false);
          this.zzDi.zzDw.addView(this.zzps.getView(), this.zzDi.index, this.zzDi.zzDv);
          this.zzDi = null;
        }
        this.zzps = null;
      }
    } while ((this.zzDh == null) || (this.zzDh.zzDB == null));
    this.zzDh.zzDB.zzaX();
  }
  
  public void zzff()
  {
    if (this.zzDp)
    {
      this.zzDp = false;
      zzfg();
    }
  }
  
  protected void zzfg()
  {
    this.zzps.zzfg();
  }
  
  public void zzw(boolean paramBoolean)
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      i = 50;
      this.zzDj = new zzm(this.mActivity, i, this);
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(10);
      if (!paramBoolean) {
        break label88;
      }
    }
    label88:
    for (int i = 11;; i = 9)
    {
      localLayoutParams.addRule(i);
      this.zzDj.zza(paramBoolean, this.zzDh.zzDF);
      this.zzCm.addView(this.zzDj, localLayoutParams);
      return;
      i = 32;
      break;
    }
  }
  
  protected void zzx(boolean paramBoolean)
    throws zzd.zza
  {
    if (!this.zzDr) {
      this.mActivity.requestWindowFeature(1);
    }
    Object localObject = this.mActivity.getWindow();
    if (localObject == null) {
      throw new zza("Invalid activity, no window available.");
    }
    if ((!this.zzDo) || ((this.zzDh.zzDL != null) && (this.zzDh.zzDL.zzqb))) {
      ((Window)localObject).setFlags(1024, 1024);
    }
    boolean bool2 = this.zzDh.zzDC.zzhC().zzcb();
    this.zzDp = false;
    boolean bool1;
    if (bool2)
    {
      if (this.zzDh.orientation != zzp.zzbz().zzhd()) {
        break label527;
      }
      if (this.mActivity.getResources().getConfiguration().orientation == 1)
      {
        bool1 = true;
        this.zzDp = bool1;
      }
    }
    else
    {
      label147:
      zzb.zzaF("Delay onShow to next orientation change: " + this.zzDp);
      setRequestedOrientation(this.zzDh.orientation);
      if (zzp.zzbz().zza((Window)localObject)) {
        zzb.zzaF("Hardware acceleration on the AdActivity window enabled.");
      }
      if (this.zzDo) {
        break label575;
      }
      this.zzCm.setBackgroundColor(-16777216);
      label218:
      this.mActivity.setContentView(this.zzCm);
      zzaF();
      if (!paramBoolean) {
        break label642;
      }
      this.zzps = zzp.zzby().zza(this.mActivity, this.zzDh.zzDC.zzaP(), true, bool2, null, this.zzDh.zzqR);
      this.zzps.zzhC().zzb(null, null, this.zzDh.zzDD, this.zzDh.zzDH, true, this.zzDh.zzDJ, null, this.zzDh.zzDC.zzhC().zzhO(), null);
      this.zzps.zzhC().zza(new zzjo.zza()
      {
        public void zza(zzjn paramAnonymouszzjn, boolean paramAnonymousBoolean)
        {
          paramAnonymouszzjn.zzfg();
        }
      });
      if (this.zzDh.url == null) {
        break label588;
      }
      this.zzps.loadUrl(this.zzDh.url);
      label372:
      if (this.zzDh.zzDC != null) {
        this.zzDh.zzDC.zzc(this);
      }
    }
    for (;;)
    {
      this.zzps.zzb(this);
      localObject = this.zzps.getParent();
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        ((ViewGroup)localObject).removeView(this.zzps.getView());
      }
      if (this.zzDo) {
        this.zzps.setBackgroundColor(zzDg);
      }
      this.zzCm.addView(this.zzps.getView(), -1, -1);
      if ((!paramBoolean) && (!this.zzDp)) {
        zzfg();
      }
      zzw(bool2);
      if (this.zzps.zzhD()) {
        zza(bool2, true);
      }
      return;
      bool1 = false;
      break;
      label527:
      if (this.zzDh.orientation != zzp.zzbz().zzhe()) {
        break label147;
      }
      if (this.mActivity.getResources().getConfiguration().orientation == 2) {}
      for (bool1 = true;; bool1 = false)
      {
        this.zzDp = bool1;
        break;
      }
      label575:
      this.zzCm.setBackgroundColor(zzDg);
      break label218;
      label588:
      if (this.zzDh.zzDG != null)
      {
        this.zzps.loadDataWithBaseURL(this.zzDh.zzDE, this.zzDh.zzDG, "text/html", "UTF-8", null);
        break label372;
      }
      throw new zza("No URL or HTML to display in ad overlay.");
      label642:
      this.zzps = this.zzDh.zzDC;
      this.zzps.setContext(this.mActivity);
    }
  }
  
  protected void zzy(int paramInt)
  {
    this.zzps.zzy(paramInt);
  }
  
  @zzha
  private static final class zza
    extends Exception
  {
    public zza(String paramString)
    {
      super();
    }
  }
  
  @zzha
  static final class zzb
    extends RelativeLayout
  {
    zzis zzry;
    
    public zzb(Context paramContext, String paramString)
    {
      super();
      this.zzry = new zzis(paramContext, paramString);
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      this.zzry.zze(paramMotionEvent);
      return false;
    }
  }
  
  @zzha
  public static class zzc
  {
    public final Context context;
    public final int index;
    public final ViewGroup.LayoutParams zzDv;
    public final ViewGroup zzDw;
    
    public zzc(zzjn paramzzjn)
      throws zzd.zza
    {
      this.zzDv = paramzzjn.getLayoutParams();
      ViewParent localViewParent = paramzzjn.getParent();
      this.context = paramzzjn.zzhy();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup)))
      {
        this.zzDw = ((ViewGroup)localViewParent);
        this.index = this.zzDw.indexOfChild(paramzzjn.getView());
        this.zzDw.removeView(paramzzjn.getView());
        paramzzjn.zzD(true);
        return;
      }
      throw new zzd.zza("Could not get the parent of the WebView for an overlay.");
    }
  }
  
  @zzha
  private class zzd
    extends zzil
  {
    private zzd() {}
    
    public void onStop() {}
    
    public void zzbp()
    {
      final Object localObject = zzp.zzbx().zze(zzd.zza(zzd.this), zzd.this.zzDh.zzDL.zzqc);
      if (localObject != null)
      {
        localObject = zzp.zzbz().zza(zzd.zza(zzd.this), (Bitmap)localObject, zzd.this.zzDh.zzDL.zzqd, zzd.this.zzDh.zzDL.zzqe);
        zzip.zzKO.post(new Runnable()
        {
          public void run()
          {
            zzd.zza(zzd.this).getWindow().setBackgroundDrawable(localObject);
          }
        });
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/overlay/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */