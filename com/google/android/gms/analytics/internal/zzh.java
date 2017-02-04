package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzh
{
  private final String zzOu;
  private final long zzPj;
  private final String zzPk;
  private final boolean zzPl;
  private long zzPm;
  private final Map<String, String> zzxc;
  
  public zzh(long paramLong1, String paramString1, String paramString2, boolean paramBoolean, long paramLong2, Map<String, String> paramMap)
  {
    zzx.zzcG(paramString1);
    zzx.zzcG(paramString2);
    this.zzPj = paramLong1;
    this.zzOu = paramString1;
    this.zzPk = paramString2;
    this.zzPl = paramBoolean;
    this.zzPm = paramLong2;
    if (paramMap != null)
    {
      this.zzxc = new HashMap(paramMap);
      return;
    }
    this.zzxc = Collections.emptyMap();
  }
  
  public String getClientId()
  {
    return this.zzOu;
  }
  
  public long zzjm()
  {
    return this.zzPj;
  }
  
  public String zzjn()
  {
    return this.zzPk;
  }
  
  public boolean zzjo()
  {
    return this.zzPl;
  }
  
  public long zzjp()
  {
    return this.zzPm;
  }
  
  public Map<String, String> zzn()
  {
    return this.zzxc;
  }
  
  public void zzn(long paramLong)
  {
    this.zzPm = paramLong;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */