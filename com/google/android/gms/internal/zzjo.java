package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

@zzha
public class zzjo
  extends WebViewClient
{
  private static final String[] zzMe = { "UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS" };
  private static final String[] zzMf = { "NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID" };
  private zzfs zzCk;
  private zza zzFl;
  private final HashMap<String, List<zzdl>> zzMg = new HashMap();
  private zzg zzMh;
  private zzb zzMi;
  private boolean zzMj = false;
  private boolean zzMk;
  private zzn zzMl;
  private final zzfq zzMm;
  private boolean zzMn;
  private boolean zzMo;
  private boolean zzMp;
  private boolean zzMq;
  private int zzMr;
  private final Object zzpK = new Object();
  protected zzjn zzps;
  private boolean zzrE;
  private zza zztn;
  private zzdp zzyZ;
  private zzdh zzyy;
  private com.google.android.gms.ads.internal.zze zzzb;
  private zzfm zzzc;
  private zzdn zzze;
  
  public zzjo(zzjn paramzzjn, boolean paramBoolean)
  {
    this(paramzzjn, paramBoolean, new zzfq(paramzzjn, paramzzjn.zzhy(), new zzbr(paramzzjn.getContext())), null);
  }
  
  zzjo(zzjn paramzzjn, boolean paramBoolean, zzfq paramzzfq, zzfm paramzzfm)
  {
    this.zzps = paramzzjn;
    this.zzrE = paramBoolean;
    this.zzMm = paramzzfq;
    this.zzzc = paramzzfm;
  }
  
  private void zza(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (!((Boolean)zzbz.zzwt.get()).booleanValue()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("err", paramString1);
    localBundle.putString("code", paramString2);
    localBundle.putString("host", zzaK(paramString3));
    zzp.zzbx().zza(paramContext, this.zzps.zzhF().afmaVersion, "gmob-apps", localBundle, true);
  }
  
  private String zzaK(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = Uri.parse(paramString);
    if (paramString.getHost() != null) {
      return paramString.getHost();
    }
    return "";
  }
  
  private static boolean zzg(Uri paramUri)
  {
    paramUri = paramUri.getScheme();
    return ("http".equalsIgnoreCase(paramUri)) || ("https".equalsIgnoreCase(paramUri));
  }
  
  private void zzhR()
  {
    synchronized (this.zzpK)
    {
      this.zzMk = true;
      this.zzMr += 1;
      zzhU();
      return;
    }
  }
  
  private void zzhS()
  {
    this.zzMr -= 1;
    zzhU();
  }
  
  private void zzhT()
  {
    this.zzMq = true;
    zzhU();
  }
  
  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    zzb.v("Loading resource: " + paramString);
    paramWebView = Uri.parse(paramString);
    if (("gmsg".equalsIgnoreCase(paramWebView.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(paramWebView.getHost()))) {
      zzh(paramWebView);
    }
  }
  
  public final void onPageFinished(WebView arg1, String paramString)
  {
    synchronized (this.zzpK)
    {
      if (this.zzMo)
      {
        zzb.v("Blank page loaded, 1...");
        this.zzps.zzhH();
        return;
      }
      this.zzMp = true;
      zzhU();
      return;
    }
  }
  
  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt < 0) && (-paramInt - 1 < zzMe.length)) {}
    for (String str = zzMe[(-paramInt - 1)];; str = String.valueOf(paramInt))
    {
      zza(this.zzps.getContext(), "http_err", str, paramString2);
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      return;
    }
  }
  
  public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    int i;
    if (paramSslError != null)
    {
      i = paramSslError.getPrimaryError();
      if ((i < 0) || (i >= zzMf.length)) {
        break label65;
      }
    }
    label65:
    for (String str = zzMf[i];; str = String.valueOf(i))
    {
      zza(this.zzps.getContext(), "ssl_err", str, zzp.zzbz().zza(paramSslError));
      super.onReceivedSslError(paramWebView, paramSslErrorHandler, paramSslError);
      return;
    }
  }
  
  public final void reset()
  {
    synchronized (this.zzpK)
    {
      this.zzMg.clear();
      this.zztn = null;
      this.zzMh = null;
      this.zzFl = null;
      this.zzyy = null;
      this.zzMj = false;
      this.zzrE = false;
      this.zzMk = false;
      this.zzze = null;
      this.zzMl = null;
      this.zzMi = null;
      if (this.zzzc != null)
      {
        this.zzzc.zzp(true);
        this.zzzc = null;
      }
      this.zzMn = false;
      return;
    }
  }
  
  public boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    switch (paramKeyEvent.getKeyCode())
    {
    default: 
      return false;
    }
    return true;
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    zzb.v("AdWebView shouldOverrideUrlLoading: " + paramString);
    Uri localUri = Uri.parse(paramString);
    if (("gmsg".equalsIgnoreCase(localUri.getScheme())) && ("mobileads.google.com".equalsIgnoreCase(localUri.getHost()))) {
      zzh(localUri);
    }
    for (;;)
    {
      return true;
      if ((this.zzMj) && (paramWebView == this.zzps.getWebView()) && (zzg(localUri)))
      {
        if (!this.zzMn)
        {
          this.zzMn = true;
          if ((this.zztn != null) && (((Boolean)zzbz.zzwb.get()).booleanValue())) {
            this.zztn.onAdClicked();
          }
        }
        return super.shouldOverrideUrlLoading(paramWebView, paramString);
      }
      if (!this.zzps.getWebView().willNotDraw())
      {
        try
        {
          zzan localzzan = this.zzps.zzhE();
          paramWebView = localUri;
          if (localzzan != null)
          {
            paramWebView = localUri;
            if (localzzan.zzb(localUri)) {
              paramWebView = localzzan.zza(localUri, this.zzps.getContext());
            }
          }
        }
        catch (zzao paramWebView)
        {
          for (;;)
          {
            zzb.zzaH("Unable to append parameter to URL: " + paramString);
            paramWebView = localUri;
          }
          this.zzzb.zzp(paramString);
        }
        if ((this.zzzb == null) || (this.zzzb.zzbg())) {
          zza(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", paramWebView.toString(), null, null, null, null, null));
        }
      }
      else
      {
        zzb.zzaH("AdWebView unable to handle URL: " + paramString);
      }
    }
  }
  
  public void zzG(boolean paramBoolean)
  {
    this.zzMj = paramBoolean;
  }
  
  public void zza(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.zzMm.zzf(paramInt1, paramInt2);
    if (this.zzzc != null) {
      this.zzzc.zza(paramInt1, paramInt2, paramBoolean);
    }
  }
  
  public final void zza(AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel)
  {
    zzg localzzg = null;
    boolean bool = this.zzps.zzhG();
    zza localzza;
    if ((bool) && (!this.zzps.zzaP().zztW))
    {
      localzza = null;
      if (!bool) {
        break label75;
      }
    }
    for (;;)
    {
      zza(new AdOverlayInfoParcel(paramAdLauncherIntentInfoParcel, localzza, localzzg, this.zzMl, this.zzps.zzhF()));
      return;
      localzza = this.zztn;
      break;
      label75:
      localzzg = this.zzMh;
    }
  }
  
  public void zza(AdOverlayInfoParcel paramAdOverlayInfoParcel)
  {
    boolean bool2 = false;
    if (this.zzzc != null) {}
    for (boolean bool1 = this.zzzc.zzeC();; bool1 = false)
    {
      com.google.android.gms.ads.internal.overlay.zze localzze = zzp.zzbv();
      Context localContext = this.zzps.getContext();
      if (!bool1) {
        bool2 = true;
      }
      localzze.zza(localContext, paramAdOverlayInfoParcel, bool2);
      return;
    }
  }
  
  public void zza(zza paramzza)
  {
    this.zzFl = paramzza;
  }
  
  public void zza(zzb paramzzb)
  {
    this.zzMi = paramzzb;
  }
  
  public void zza(String paramString, zzdl paramzzdl)
  {
    synchronized (this.zzpK)
    {
      List localList = (List)this.zzMg.get(paramString);
      Object localObject1 = localList;
      if (localList == null)
      {
        localObject1 = new CopyOnWriteArrayList();
        this.zzMg.put(paramString, localObject1);
      }
      ((List)localObject1).add(paramzzdl);
      return;
    }
  }
  
  public final void zza(boolean paramBoolean, int paramInt)
  {
    if ((this.zzps.zzhG()) && (!this.zzps.zzaP().zztW)) {}
    for (zza localzza = null;; localzza = this.zztn)
    {
      zza(new AdOverlayInfoParcel(localzza, this.zzMh, this.zzMl, this.zzps, paramBoolean, paramInt, this.zzps.zzhF()));
      return;
    }
  }
  
  public final void zza(boolean paramBoolean, int paramInt, String paramString)
  {
    Object localObject = null;
    boolean bool = this.zzps.zzhG();
    zza localzza;
    if ((bool) && (!this.zzps.zzaP().zztW))
    {
      localzza = null;
      if (!bool) {
        break label95;
      }
    }
    for (;;)
    {
      zza(new AdOverlayInfoParcel(localzza, (zzg)localObject, this.zzyy, this.zzMl, this.zzps, paramBoolean, paramInt, paramString, this.zzps.zzhF(), this.zzze));
      return;
      localzza = this.zztn;
      break;
      label95:
      localObject = new zzc(this.zzps, this.zzMh);
    }
  }
  
  public final void zza(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    boolean bool = this.zzps.zzhG();
    zza localzza;
    if ((bool) && (!this.zzps.zzaP().zztW))
    {
      localzza = null;
      if (!bool) {
        break label97;
      }
    }
    label97:
    for (Object localObject = null;; localObject = new zzc(this.zzps, this.zzMh))
    {
      zza(new AdOverlayInfoParcel(localzza, (zzg)localObject, this.zzyy, this.zzMl, this.zzps, paramBoolean, paramInt, paramString1, paramString2, this.zzps.zzhF(), this.zzze));
      return;
      localzza = this.zztn;
      break;
    }
  }
  
  public void zzb(zza paramzza, zzg paramzzg, zzdh paramzzdh, zzn paramzzn, boolean paramBoolean, zzdn paramzzdn, zzdp paramzzdp, com.google.android.gms.ads.internal.zze paramzze, zzfs paramzzfs)
  {
    com.google.android.gms.ads.internal.zze localzze = paramzze;
    if (paramzze == null) {
      localzze = new com.google.android.gms.ads.internal.zze(false);
    }
    this.zzzc = new zzfm(this.zzps, paramzzfs);
    zza("/appEvent", new zzdg(paramzzdh));
    zza("/backButton", zzdk.zzyI);
    zza("/canOpenURLs", zzdk.zzyA);
    zza("/canOpenIntents", zzdk.zzyB);
    zza("/click", zzdk.zzyC);
    zza("/close", zzdk.zzyD);
    zza("/customClose", zzdk.zzyE);
    zza("/instrument", zzdk.zzyL);
    zza("/delayPageLoaded", new zzd(null));
    zza("/httpTrack", zzdk.zzyF);
    zza("/log", zzdk.zzyG);
    zza("/mraid", new zzdr(localzze, this.zzzc));
    zza("/mraidLoaded", this.zzMm);
    zza("/open", new zzds(paramzzdn, localzze, this.zzzc));
    zza("/precache", zzdk.zzyK);
    zza("/touch", zzdk.zzyH);
    zza("/video", zzdk.zzyJ);
    if (paramzzdp != null) {
      zza("/setInterstitialProperties", new zzdo(paramzzdp));
    }
    this.zztn = paramzza;
    this.zzMh = paramzzg;
    this.zzyy = paramzzdh;
    this.zzze = paramzzdn;
    this.zzMl = paramzzn;
    this.zzzb = localzze;
    this.zzCk = paramzzfs;
    this.zzyZ = paramzzdp;
    zzG(paramBoolean);
    this.zzMn = false;
  }
  
  public void zzb(String paramString, zzdl paramzzdl)
  {
    synchronized (this.zzpK)
    {
      paramString = (List)this.zzMg.get(paramString);
      if (paramString == null) {
        return;
      }
      paramString.remove(paramzzdl);
      return;
    }
  }
  
  public boolean zzcb()
  {
    synchronized (this.zzpK)
    {
      boolean bool = this.zzrE;
      return bool;
    }
  }
  
  public void zze(int paramInt1, int paramInt2)
  {
    if (this.zzzc != null) {
      this.zzzc.zze(paramInt1, paramInt2);
    }
  }
  
  public void zze(zzjn paramzzjn)
  {
    this.zzps = paramzzjn;
  }
  
  public final void zzfd()
  {
    synchronized (this.zzpK)
    {
      this.zzMj = false;
      this.zzrE = true;
      zzip.runOnUiThread(new Runnable()
      {
        public void run()
        {
          zzjo.this.zzps.zzhM();
          zzd localzzd = zzjo.this.zzps.zzhA();
          if (localzzd != null) {
            localzzd.zzfd();
          }
          if (zzjo.zzd(zzjo.this) != null)
          {
            zzjo.zzd(zzjo.this).zzbh();
            zzjo.zza(zzjo.this, null);
          }
        }
      });
      return;
    }
  }
  
  public void zzh(Uri paramUri)
  {
    Object localObject2 = paramUri.getPath();
    Object localObject1 = (List)this.zzMg.get(localObject2);
    if (localObject1 != null)
    {
      paramUri = zzp.zzbx().zze(paramUri);
      if (zzb.zzQ(2))
      {
        zzb.v("Received GMSG: " + (String)localObject2);
        localObject2 = paramUri.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          zzb.v("  " + str + ": " + (String)paramUri.get(str));
        }
      }
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((zzdl)((Iterator)localObject1).next()).zza(this.zzps, paramUri);
      }
    }
    zzb.v("No GMSG handler found for GMSG: " + paramUri);
  }
  
  public com.google.android.gms.ads.internal.zze zzhO()
  {
    return this.zzzb;
  }
  
  public boolean zzhP()
  {
    synchronized (this.zzpK)
    {
      boolean bool = this.zzMk;
      return bool;
    }
  }
  
  public void zzhQ()
  {
    synchronized (this.zzpK)
    {
      zzb.v("Loading blank page in WebView, 2...");
      this.zzMo = true;
      this.zzps.zzaI("about:blank");
      return;
    }
  }
  
  public final void zzhU()
  {
    zza localzza;
    zzjn localzzjn;
    if ((this.zzFl != null) && (((this.zzMp) && (this.zzMr <= 0)) || (this.zzMq)))
    {
      localzza = this.zzFl;
      localzzjn = this.zzps;
      if (this.zzMq) {
        break label70;
      }
    }
    label70:
    for (boolean bool = true;; bool = false)
    {
      localzza.zza(localzzjn, bool);
      this.zzFl = null;
      this.zzps.zzhN();
      return;
    }
  }
  
  public static abstract interface zza
  {
    public abstract void zza(zzjn paramzzjn, boolean paramBoolean);
  }
  
  public static abstract interface zzb
  {
    public abstract void zzbh();
  }
  
  private static class zzc
    implements zzg
  {
    private zzg zzMh;
    private zzjn zzMt;
    
    public zzc(zzjn paramzzjn, zzg paramzzg)
    {
      this.zzMt = paramzzjn;
      this.zzMh = paramzzg;
    }
    
    public void zzaX()
    {
      this.zzMh.zzaX();
      this.zzMt.zzhw();
    }
    
    public void zzaY()
    {
      this.zzMh.zzaY();
      this.zzMt.zzfg();
    }
  }
  
  private class zzd
    implements zzdl
  {
    private zzd() {}
    
    public void zza(zzjn paramzzjn, Map<String, String> paramMap)
    {
      if (paramMap.keySet().contains("start")) {
        zzjo.zza(zzjo.this);
      }
      do
      {
        return;
        if (paramMap.keySet().contains("stop"))
        {
          zzjo.zzb(zzjo.this);
          return;
        }
      } while (!paramMap.keySet().contains("cancel"));
      zzjo.zzc(zzjo.this);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzjo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */