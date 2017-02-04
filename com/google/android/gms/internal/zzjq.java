package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

@zzha
class zzjq
  extends FrameLayout
  implements zzjn
{
  private final zzjn zzMu;
  private final zzjm zzMv;
  
  public zzjq(zzjn paramzzjn)
  {
    super(paramzzjn.getContext());
    this.zzMu = paramzzjn;
    this.zzMv = new zzjm(paramzzjn.zzhy(), this, this);
    paramzzjn = this.zzMu.zzhC();
    if (paramzzjn != null) {
      paramzzjn.zze(this);
    }
    addView(this.zzMu.getView());
  }
  
  public void clearCache(boolean paramBoolean)
  {
    this.zzMu.clearCache(paramBoolean);
  }
  
  public void destroy()
  {
    this.zzMu.destroy();
  }
  
  public String getRequestId()
  {
    return this.zzMu.getRequestId();
  }
  
  public int getRequestedOrientation()
  {
    return this.zzMu.getRequestedOrientation();
  }
  
  public View getView()
  {
    return this;
  }
  
  public WebView getWebView()
  {
    return this.zzMu.getWebView();
  }
  
  public boolean isDestroyed()
  {
    return this.zzMu.isDestroyed();
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    this.zzMu.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.zzMu.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    this.zzMu.loadUrl(paramString);
  }
  
  public void onPause()
  {
    this.zzMv.onPause();
    this.zzMu.onPause();
  }
  
  public void onResume()
  {
    this.zzMu.onResume();
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.zzMu.setBackgroundColor(paramInt);
  }
  
  public void setContext(Context paramContext)
  {
    this.zzMu.setContext(paramContext);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.zzMu.setOnClickListener(paramOnClickListener);
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.zzMu.setOnTouchListener(paramOnTouchListener);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    this.zzMu.setRequestedOrientation(paramInt);
  }
  
  public void setWebChromeClient(WebChromeClient paramWebChromeClient)
  {
    this.zzMu.setWebChromeClient(paramWebChromeClient);
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    this.zzMu.setWebViewClient(paramWebViewClient);
  }
  
  public void stopLoading()
  {
    this.zzMu.stopLoading();
  }
  
  public void zzD(boolean paramBoolean)
  {
    this.zzMu.zzD(paramBoolean);
  }
  
  public void zzE(boolean paramBoolean)
  {
    this.zzMu.zzE(paramBoolean);
  }
  
  public void zzF(boolean paramBoolean)
  {
    this.zzMu.zzF(paramBoolean);
  }
  
  public void zza(Context paramContext, AdSizeParcel paramAdSizeParcel, zzch paramzzch)
  {
    this.zzMu.zza(paramContext, paramAdSizeParcel, paramzzch);
  }
  
  public void zza(AdSizeParcel paramAdSizeParcel)
  {
    this.zzMu.zza(paramAdSizeParcel);
  }
  
  public void zza(zzaz paramzzaz, boolean paramBoolean)
  {
    this.zzMu.zza(paramzzaz, paramBoolean);
  }
  
  public void zza(String paramString1, String paramString2)
  {
    this.zzMu.zza(paramString1, paramString2);
  }
  
  public void zza(String paramString, JSONObject paramJSONObject)
  {
    this.zzMu.zza(paramString, paramJSONObject);
  }
  
  public void zzaI(String paramString)
  {
    this.zzMu.zzaI(paramString);
  }
  
  public void zzaJ(String paramString)
  {
    this.zzMu.zzaJ(paramString);
  }
  
  public AdSizeParcel zzaP()
  {
    return this.zzMu.zzaP();
  }
  
  public void zzb(com.google.android.gms.ads.internal.overlay.zzd paramzzd)
  {
    this.zzMu.zzb(paramzzd);
  }
  
  public void zzb(String paramString, Map<String, ?> paramMap)
  {
    this.zzMu.zzb(paramString, paramMap);
  }
  
  public void zzb(String paramString, JSONObject paramJSONObject)
  {
    this.zzMu.zzb(paramString, paramJSONObject);
  }
  
  public void zzc(com.google.android.gms.ads.internal.overlay.zzd paramzzd)
  {
    this.zzMu.zzc(paramzzd);
  }
  
  public void zzfg()
  {
    this.zzMu.zzfg();
  }
  
  public com.google.android.gms.ads.internal.overlay.zzd zzhA()
  {
    return this.zzMu.zzhA();
  }
  
  public com.google.android.gms.ads.internal.overlay.zzd zzhB()
  {
    return this.zzMu.zzhB();
  }
  
  public zzjo zzhC()
  {
    return this.zzMu.zzhC();
  }
  
  public boolean zzhD()
  {
    return this.zzMu.zzhD();
  }
  
  public zzan zzhE()
  {
    return this.zzMu.zzhE();
  }
  
  public VersionInfoParcel zzhF()
  {
    return this.zzMu.zzhF();
  }
  
  public boolean zzhG()
  {
    return this.zzMu.zzhG();
  }
  
  public void zzhH()
  {
    this.zzMv.onDestroy();
    this.zzMu.zzhH();
  }
  
  public boolean zzhI()
  {
    return this.zzMu.zzhI();
  }
  
  public zzjm zzhJ()
  {
    return this.zzMv;
  }
  
  public zzcf zzhK()
  {
    return this.zzMu.zzhK();
  }
  
  public zzcg zzhL()
  {
    return this.zzMu.zzhL();
  }
  
  public void zzhM()
  {
    this.zzMu.zzhM();
  }
  
  public void zzhN()
  {
    this.zzMu.zzhN();
  }
  
  public void zzhw()
  {
    this.zzMu.zzhw();
  }
  
  public Activity zzhx()
  {
    return this.zzMu.zzhx();
  }
  
  public Context zzhy()
  {
    return this.zzMu.zzhy();
  }
  
  public com.google.android.gms.ads.internal.zzd zzhz()
  {
    return this.zzMu.zzhz();
  }
  
  public void zzy(int paramInt)
  {
    this.zzMu.zzy(paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzjq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */