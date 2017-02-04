package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import org.json.JSONObject;

@zzha
public final class zzax
{
  private final String zzrA;
  private final JSONObject zzrB;
  private final String zzrC;
  private final String zzrD;
  private final boolean zzrE;
  private final boolean zzrF;
  
  public zzax(String paramString1, VersionInfoParcel paramVersionInfoParcel, String paramString2, JSONObject paramJSONObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.zzrD = paramVersionInfoParcel.afmaVersion;
    this.zzrB = paramJSONObject;
    this.zzrC = paramString1;
    this.zzrA = paramString2;
    this.zzrE = paramBoolean1;
    this.zzrF = paramBoolean2;
  }
  
  public String zzbX()
  {
    return this.zzrA;
  }
  
  public String zzbY()
  {
    return this.zzrD;
  }
  
  public JSONObject zzbZ()
  {
    return this.zzrB;
  }
  
  public String zzca()
  {
    return this.zzrC;
  }
  
  public boolean zzcb()
  {
    return this.zzrE;
  }
  
  public boolean zzcc()
  {
    return this.zzrF;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */