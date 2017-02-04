package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zze;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class zzqn
  extends zze<zzqn>
{
  private String zzaRS;
  private int zzaRT;
  private int zzaRU;
  private String zzaRV;
  private String zzaRW;
  private boolean zzaRX;
  private boolean zzaRY;
  private boolean zzaRZ;
  
  public zzqn()
  {
    this(false);
  }
  
  public zzqn(boolean paramBoolean)
  {
    this(paramBoolean, zzAl());
  }
  
  public zzqn(boolean paramBoolean, int paramInt)
  {
    zzx.zzbX(paramInt);
    this.zzaRT = paramInt;
    this.zzaRY = paramBoolean;
  }
  
  static int zzAl()
  {
    UUID localUUID = UUID.randomUUID();
    int i = (int)(localUUID.getLeastSignificantBits() & 0x7FFFFFFF);
    if (i != 0) {}
    int j;
    do
    {
      return i;
      j = (int)(localUUID.getMostSignificantBits() & 0x7FFFFFFF);
      i = j;
    } while (j != 0);
    Log.e("GAv4", "UUID.randomUUID() returned 0.");
    return Integer.MAX_VALUE;
  }
  
  private void zzAp()
  {
    if (this.zzaRZ) {
      throw new IllegalStateException("ScreenViewInfo is immutable");
    }
  }
  
  public void setScreenName(String paramString)
  {
    zzAp();
    this.zzaRS = paramString;
  }
  
  public String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("screenName", this.zzaRS);
    localHashMap.put("interstitial", Boolean.valueOf(this.zzaRX));
    localHashMap.put("automatic", Boolean.valueOf(this.zzaRY));
    localHashMap.put("screenId", Integer.valueOf(this.zzaRT));
    localHashMap.put("referrerScreenId", Integer.valueOf(this.zzaRU));
    localHashMap.put("referrerScreenName", this.zzaRV);
    localHashMap.put("referrerUri", this.zzaRW);
    return zzE(localHashMap);
  }
  
  public String zzAm()
  {
    return this.zzaRS;
  }
  
  public int zzAn()
  {
    return this.zzaRT;
  }
  
  public String zzAo()
  {
    return this.zzaRW;
  }
  
  public void zza(zzqn paramzzqn)
  {
    if (!TextUtils.isEmpty(this.zzaRS)) {
      paramzzqn.setScreenName(this.zzaRS);
    }
    if (this.zzaRT != 0) {
      paramzzqn.zzit(this.zzaRT);
    }
    if (this.zzaRU != 0) {
      paramzzqn.zziu(this.zzaRU);
    }
    if (!TextUtils.isEmpty(this.zzaRV)) {
      paramzzqn.zzeq(this.zzaRV);
    }
    if (!TextUtils.isEmpty(this.zzaRW)) {
      paramzzqn.zzer(this.zzaRW);
    }
    if (this.zzaRX) {
      paramzzqn.zzan(this.zzaRX);
    }
    if (this.zzaRY) {
      paramzzqn.zzam(this.zzaRY);
    }
  }
  
  public void zzam(boolean paramBoolean)
  {
    zzAp();
    this.zzaRY = paramBoolean;
  }
  
  public void zzan(boolean paramBoolean)
  {
    zzAp();
    this.zzaRX = paramBoolean;
  }
  
  public void zzeq(String paramString)
  {
    zzAp();
    this.zzaRV = paramString;
  }
  
  public void zzer(String paramString)
  {
    zzAp();
    if (TextUtils.isEmpty(paramString))
    {
      this.zzaRW = null;
      return;
    }
    this.zzaRW = paramString;
  }
  
  public void zzit(int paramInt)
  {
    zzAp();
    this.zzaRT = paramInt;
  }
  
  public void zziu(int paramInt)
  {
    zzAp();
    this.zzaRU = paramInt;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzqn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */