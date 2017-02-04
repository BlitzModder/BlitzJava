package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.gms.ads.internal.zzp;
import java.util.LinkedHashMap;
import java.util.Map;

@zzha
public class zzca
{
  private Context mContext = null;
  private String zzrD = null;
  private boolean zzwK;
  private String zzwL;
  private Map<String, String> zzwM;
  
  public zzca(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    this.zzrD = paramString;
    this.zzwK = ((Boolean)zzbz.zzvL.get()).booleanValue();
    this.zzwL = ((String)zzbz.zzvM.get());
    this.zzwM = new LinkedHashMap();
    this.zzwM.put("s", "gmob_sdk");
    this.zzwM.put("v", "3");
    this.zzwM.put("os", Build.VERSION.RELEASE);
    this.zzwM.put("sdk", Build.VERSION.SDK);
    this.zzwM.put("device", zzp.zzbx().zzhb());
    paramString = this.zzwM;
    if (paramContext.getApplicationContext() != null) {}
    for (paramContext = paramContext.getApplicationContext().getPackageName();; paramContext = paramContext.getPackageName())
    {
      paramString.put("app", paramContext);
      paramContext = zzp.zzbD().zzE(this.mContext);
      this.zzwM.put("network_coarse", Integer.toString(paramContext.zzIM));
      this.zzwM.put("network_fine", Integer.toString(paramContext.zzIN));
      return;
    }
  }
  
  Context getContext()
  {
    return this.mContext;
  }
  
  String zzbY()
  {
    return this.zzrD;
  }
  
  boolean zzdn()
  {
    return this.zzwK;
  }
  
  String zzdo()
  {
    return this.zzwL;
  }
  
  Map<String, String> zzdp()
  {
    return this.zzwM;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */