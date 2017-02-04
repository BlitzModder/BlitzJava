package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONObject;

@zzha
public class zzbd
  implements zzbb
{
  private final zzjn zzps;
  
  public zzbd(Context paramContext, VersionInfoParcel paramVersionInfoParcel, zzan paramzzan)
  {
    this.zzps = zzp.zzby().zza(paramContext, new AdSizeParcel(), false, false, paramzzan, paramVersionInfoParcel);
    this.zzps.getWebView().setWillNotDraw(true);
  }
  
  private void runOnUiThread(Runnable paramRunnable)
  {
    if (zzl.zzcN().zzhr())
    {
      paramRunnable.run();
      return;
    }
    zzip.zzKO.post(paramRunnable);
  }
  
  public void destroy()
  {
    this.zzps.destroy();
  }
  
  public void zza(com.google.android.gms.ads.internal.client.zza paramzza, zzg paramzzg, zzdh paramzzdh, zzn paramzzn, boolean paramBoolean, zzdn paramzzdn, zzdp paramzzdp, zze paramzze, zzfs paramzzfs)
  {
    this.zzps.zzhC().zzb(paramzza, paramzzg, paramzzdh, paramzzn, paramBoolean, paramzzdn, paramzzdp, new zze(false), paramzzfs);
  }
  
  public void zza(final zzbb.zza paramzza)
  {
    this.zzps.zzhC().zza(new zzjo.zza()
    {
      public void zza(zzjn paramAnonymouszzjn, boolean paramAnonymousBoolean)
      {
        paramzza.zzcr();
      }
    });
  }
  
  public void zza(String paramString, zzdl paramzzdl)
  {
    this.zzps.zzhC().zza(paramString, paramzzdl);
  }
  
  public void zza(final String paramString1, final String paramString2)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        zzbd.zza(zzbd.this).zza(paramString1, paramString2);
      }
    });
  }
  
  public void zza(final String paramString, final JSONObject paramJSONObject)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        zzbd.zza(zzbd.this).zza(paramString, paramJSONObject);
      }
    });
  }
  
  public void zzb(String paramString, zzdl paramzzdl)
  {
    this.zzps.zzhC().zzb(paramString, paramzzdl);
  }
  
  public void zzb(String paramString, JSONObject paramJSONObject)
  {
    this.zzps.zzb(paramString, paramJSONObject);
  }
  
  public zzbf zzcq()
  {
    return new zzbg(this);
  }
  
  public void zzs(String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        zzbd.zza(zzbd.this).loadData(this.zzsy, "text/html", "UTF-8");
      }
    });
  }
  
  public void zzt(final String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        zzbd.zza(zzbd.this).loadUrl(paramString);
      }
    });
  }
  
  public void zzu(final String paramString)
  {
    runOnUiThread(new Runnable()
    {
      public void run()
      {
        zzbd.zza(zzbd.this).loadData(paramString, "text/html", "UTF-8");
      }
    });
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzbd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */