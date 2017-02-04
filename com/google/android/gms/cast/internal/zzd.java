package com.google.android.gms.cast.internal;

import android.text.TextUtils;
import java.io.IOException;

public abstract class zzd
{
  protected final zzl zzabN;
  private final String zzabO;
  private zzn zzabP;
  
  protected zzd(String paramString1, String paramString2, String paramString3)
  {
    zzf.zzcb(paramString1);
    this.zzabO = paramString1;
    this.zzabN = new zzl(paramString2);
    setSessionLabel(paramString3);
  }
  
  public final String getNamespace()
  {
    return this.zzabO;
  }
  
  public void setSessionLabel(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.zzabN.zzch(paramString);
    }
  }
  
  public final void zza(zzn paramzzn)
  {
    this.zzabP = paramzzn;
    if (this.zzabP == null) {
      zznN();
    }
  }
  
  protected final void zza(String paramString1, long paramLong, String paramString2)
    throws IOException
  {
    this.zzabN.zza("Sending text message: %s to: %s", new Object[] { paramString1, paramString2 });
    this.zzabP.zza(this.zzabO, paramString1, paramLong, paramString2);
  }
  
  public void zzb(long paramLong, int paramInt) {}
  
  public void zzbZ(String paramString) {}
  
  public void zznN() {}
  
  protected final long zznO()
  {
    return this.zzabP.zzny();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/cast/internal/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */