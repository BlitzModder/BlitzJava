package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.Map;
import org.json.JSONObject;

@zzha
public abstract interface zzjn
  extends zzaw
{
  public abstract void clearCache(boolean paramBoolean);
  
  public abstract void destroy();
  
  public abstract Context getContext();
  
  public abstract ViewGroup.LayoutParams getLayoutParams();
  
  public abstract void getLocationOnScreen(int[] paramArrayOfInt);
  
  public abstract int getMeasuredHeight();
  
  public abstract int getMeasuredWidth();
  
  public abstract ViewParent getParent();
  
  public abstract String getRequestId();
  
  public abstract int getRequestedOrientation();
  
  public abstract View getView();
  
  public abstract WebView getWebView();
  
  public abstract boolean isDestroyed();
  
  public abstract void loadData(String paramString1, String paramString2, String paramString3);
  
  public abstract void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
  
  public abstract void loadUrl(String paramString);
  
  public abstract void measure(int paramInt1, int paramInt2);
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void setBackgroundColor(int paramInt);
  
  public abstract void setContext(Context paramContext);
  
  public abstract void setOnClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setOnTouchListener(View.OnTouchListener paramOnTouchListener);
  
  public abstract void setRequestedOrientation(int paramInt);
  
  public abstract void setWebChromeClient(WebChromeClient paramWebChromeClient);
  
  public abstract void setWebViewClient(WebViewClient paramWebViewClient);
  
  public abstract void stopLoading();
  
  public abstract void zzD(boolean paramBoolean);
  
  public abstract void zzE(boolean paramBoolean);
  
  public abstract void zzF(boolean paramBoolean);
  
  public abstract void zza(Context paramContext, AdSizeParcel paramAdSizeParcel, zzch paramzzch);
  
  public abstract void zza(AdSizeParcel paramAdSizeParcel);
  
  public abstract void zza(String paramString1, String paramString2);
  
  public abstract void zza(String paramString, JSONObject paramJSONObject);
  
  public abstract void zzaI(String paramString);
  
  public abstract void zzaJ(String paramString);
  
  public abstract AdSizeParcel zzaP();
  
  public abstract void zzb(com.google.android.gms.ads.internal.overlay.zzd paramzzd);
  
  public abstract void zzb(String paramString, Map<String, ?> paramMap);
  
  public abstract void zzb(String paramString, JSONObject paramJSONObject);
  
  public abstract void zzc(com.google.android.gms.ads.internal.overlay.zzd paramzzd);
  
  public abstract void zzfg();
  
  public abstract com.google.android.gms.ads.internal.overlay.zzd zzhA();
  
  public abstract com.google.android.gms.ads.internal.overlay.zzd zzhB();
  
  public abstract zzjo zzhC();
  
  public abstract boolean zzhD();
  
  public abstract zzan zzhE();
  
  public abstract VersionInfoParcel zzhF();
  
  public abstract boolean zzhG();
  
  public abstract void zzhH();
  
  public abstract boolean zzhI();
  
  public abstract zzjm zzhJ();
  
  public abstract zzcf zzhK();
  
  public abstract zzcg zzhL();
  
  public abstract void zzhM();
  
  public abstract void zzhN();
  
  public abstract void zzhw();
  
  public abstract Activity zzhx();
  
  public abstract Context zzhy();
  
  public abstract com.google.android.gms.ads.internal.zzd zzhz();
  
  public abstract void zzy(int paramInt);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzjn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */