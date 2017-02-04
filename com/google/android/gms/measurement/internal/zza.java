package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;

class zza
{
  final String zzRl;
  final String zzaRd;
  final String zzaSe;
  final String zzaSf;
  final String zzaSg;
  final long zzaSh;
  final long zzaSi;
  final String zzaSj;
  final long zzaSk;
  final long zzaSl;
  final boolean zzaSm;
  
  zza(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, long paramLong2, String paramString5, String paramString6, long paramLong3, long paramLong4, boolean paramBoolean)
  {
    zzx.zzcG(paramString1);
    if (paramLong1 >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzab(bool);
      this.zzaRd = paramString1;
      this.zzaSe = paramString2;
      paramString1 = paramString3;
      if (TextUtils.isEmpty(paramString3)) {
        paramString1 = null;
      }
      this.zzaSf = paramString1;
      this.zzaSg = paramString4;
      this.zzaSh = paramLong1;
      this.zzaSi = paramLong2;
      this.zzRl = paramString5;
      this.zzaSj = paramString6;
      this.zzaSk = paramLong3;
      this.zzaSl = paramLong4;
      this.zzaSm = paramBoolean;
      return;
    }
  }
  
  public zza zzJ(String paramString1, String paramString2)
  {
    return new zza(this.zzaRd, paramString1, this.zzaSf, paramString2, this.zzaSh, this.zzaSi, this.zzRl, this.zzaSj, this.zzaSk, this.zzaSl, this.zzaSm);
  }
  
  public zza zzK(String paramString1, String paramString2)
  {
    return new zza(this.zzaRd, this.zzaSe, this.zzaSf, this.zzaSg, this.zzaSh, this.zzaSi, paramString1, paramString2, this.zzaSk, this.zzaSl, this.zzaSm);
  }
  
  public zza zzO(long paramLong)
  {
    return new zza(this.zzaRd, this.zzaSe, this.zzaSf, this.zzaSg, this.zzaSh, this.zzaSi, this.zzRl, this.zzaSj, this.zzaSk, paramLong, this.zzaSm);
  }
  
  public zza zza(zzo paramzzo, long paramLong)
  {
    zzx.zzy(paramzzo);
    long l2 = this.zzaSh + 1L;
    long l1 = l2;
    if (l2 > 2147483647L)
    {
      paramzzo.zzBm().zzez("Bundle index overflow");
      l1 = 0L;
    }
    return new zza(this.zzaRd, this.zzaSe, this.zzaSf, this.zzaSg, l1, paramLong, this.zzRl, this.zzaSj, this.zzaSk, this.zzaSl, this.zzaSm);
  }
  
  public zza zzao(boolean paramBoolean)
  {
    return new zza(this.zzaRd, this.zzaSe, this.zzaSf, this.zzaSg, this.zzaSh, this.zzaSi, this.zzRl, this.zzaSj, this.zzaSk, this.zzaSl, paramBoolean);
  }
  
  public zza zze(String paramString, long paramLong)
  {
    return new zza(this.zzaRd, this.zzaSe, paramString, this.zzaSg, this.zzaSh, this.zzaSi, this.zzRl, this.zzaSj, paramLong, this.zzaSl, this.zzaSm);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */