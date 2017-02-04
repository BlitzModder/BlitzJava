package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzx;

class zzh
{
  final String mName;
  final String zzaRd;
  final long zzaSF;
  final long zzaSG;
  final long zzaSH;
  
  zzh(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3)
  {
    zzx.zzcG(paramString1);
    zzx.zzcG(paramString2);
    if (paramLong1 >= 0L)
    {
      bool1 = true;
      zzx.zzab(bool1);
      if (paramLong2 < 0L) {
        break label81;
      }
    }
    label81:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzab(bool1);
      this.zzaRd = paramString1;
      this.mName = paramString2;
      this.zzaSF = paramLong1;
      this.zzaSG = paramLong2;
      this.zzaSH = paramLong3;
      return;
      bool1 = false;
      break;
    }
  }
  
  zzh zzQ(long paramLong)
  {
    return new zzh(this.zzaRd, this.mName, this.zzaSF + 1L, this.zzaSG + 1L, paramLong);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */