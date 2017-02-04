package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzip;

@zzha
public class zzk
{
  private final String zzux;
  
  public zzk(String paramString)
  {
    this.zzux = paramString;
  }
  
  public boolean zza(String paramString, int paramInt, Intent paramIntent)
  {
    if ((paramString == null) || (paramIntent == null)) {}
    String str;
    do
    {
      return false;
      str = zzp.zzbH().zze(paramIntent);
      paramIntent = zzp.zzbH().zzf(paramIntent);
    } while ((str == null) || (paramIntent == null));
    if (!paramString.equals(zzp.zzbH().zzap(str)))
    {
      zzb.zzaH("Developer payload not match.");
      return false;
    }
    if ((this.zzux != null) && (!zzl.zzc(this.zzux, str, paramIntent)))
    {
      zzb.zzaH("Fail to verify signature.");
      return false;
    }
    return true;
  }
  
  public String zzfN()
  {
    return zzp.zzbx().zzha();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/purchase/zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */