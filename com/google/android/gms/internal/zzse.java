package com.google.android.gms.internal;

import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzd;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.stats.zzg;
import com.google.android.gms.common.stats.zzi;

public class zzse
{
  private static boolean DEBUG = false;
  private static String TAG = "WakeLock";
  private static String zzbce = "*gcore*:";
  private final Context mContext;
  private final String zzalZ;
  private final PowerManager.WakeLock zzbcf;
  private WorkSource zzbcg;
  private final int zzbch;
  private final String zzbci;
  private boolean zzbcj = true;
  private int zzbck;
  private int zzbcl;
  
  public zzse(Context paramContext, int paramInt, String paramString)
  {
    this(paramContext, paramInt, paramString, null, null);
  }
  
  public zzse(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    zzx.zzh(paramString1, "Wake lock name can NOT be empty");
    this.zzbch = paramInt;
    this.zzbci = paramString2;
    this.mContext = paramContext.getApplicationContext();
    if ((!zzob.zzcP(paramString3)) && ("com.google.android.gms" != paramString3))
    {
      this.zzalZ = (zzbce + paramString1);
      this.zzbcf = ((PowerManager)paramContext.getSystemService("power")).newWakeLock(paramInt, paramString1);
      if (zzoc.zzaz(this.mContext))
      {
        paramString1 = paramString3;
        if (zzob.zzcP(paramString3))
        {
          if ((!zzd.zzaiU) || (!zzmt.isInitialized())) {
            break label195;
          }
          Log.e(TAG, "callingPackage is not supposed to be empty for wakelock " + this.zzalZ + "!", new IllegalArgumentException());
        }
      }
    }
    label195:
    for (paramString1 = "com.google.android.gms";; paramString1 = paramContext.getPackageName())
    {
      this.zzbcg = zzoc.zzk(paramContext, paramString1);
      zzc(this.zzbcg);
      return;
      this.zzalZ = paramString1;
      break;
    }
  }
  
  private void zzeV(String paramString)
  {
    boolean bool = zzeW(paramString);
    String str = zzj(paramString, bool);
    if (DEBUG) {
      Log.d(TAG, "Release:\n mWakeLockName: " + this.zzalZ + "\n mSecondaryName: " + this.zzbci + "\nmReferenceCounted: " + this.zzbcj + "\nreason: " + paramString + "\n mOpenEventCount" + this.zzbcl + "\nuseWithReason: " + bool + "\ntrackingName: " + str);
    }
    try
    {
      if (this.zzbcj)
      {
        int i = this.zzbck - 1;
        this.zzbck = i;
        if ((i == 0) || (bool)) {}
      }
      else
      {
        if ((this.zzbcj) || (this.zzbcl != 1)) {
          break label205;
        }
      }
      zzi.zzrJ().zza(this.mContext, zzg.zza(this.zzbcf, str), 8, this.zzalZ, str, this.zzbch, zzoc.zzb(this.zzbcg));
      this.zzbcl -= 1;
      label205:
      return;
    }
    finally {}
  }
  
  private boolean zzeW(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!paramString.equals(this.zzbci));
  }
  
  private String zzj(String paramString, boolean paramBoolean)
  {
    if (this.zzbcj)
    {
      if (paramBoolean) {
        return paramString;
      }
      return this.zzbci;
    }
    return this.zzbci;
  }
  
  private void zzj(String paramString, long paramLong)
  {
    boolean bool = zzeW(paramString);
    String str = zzj(paramString, bool);
    if (DEBUG) {
      Log.d(TAG, "Acquire:\n mWakeLockName: " + this.zzalZ + "\n mSecondaryName: " + this.zzbci + "\nmReferenceCounted: " + this.zzbcj + "\nreason: " + paramString + "\nmOpenEventCount" + this.zzbcl + "\nuseWithReason: " + bool + "\ntrackingName: " + str + "\ntimeout: " + paramLong);
    }
    try
    {
      if (this.zzbcj)
      {
        int i = this.zzbck;
        this.zzbck = (i + 1);
        if ((i == 0) || (bool)) {}
      }
      else
      {
        if ((this.zzbcj) || (this.zzbcl != 0)) {
          break label221;
        }
      }
      zzi.zzrJ().zza(this.mContext, zzg.zza(this.zzbcf, str), 7, this.zzalZ, str, this.zzbch, zzoc.zzb(this.zzbcg), paramLong);
      this.zzbcl += 1;
      label221:
      return;
    }
    finally {}
  }
  
  public void acquire(long paramLong)
  {
    if ((!zznx.zzrQ()) && (this.zzbcj)) {
      Log.wtf(TAG, "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: " + this.zzalZ);
    }
    zzj(null, paramLong);
    this.zzbcf.acquire(paramLong);
  }
  
  public boolean isHeld()
  {
    return this.zzbcf.isHeld();
  }
  
  public void release()
  {
    zzeV(null);
    this.zzbcf.release();
  }
  
  public void setReferenceCounted(boolean paramBoolean)
  {
    this.zzbcf.setReferenceCounted(paramBoolean);
    this.zzbcj = paramBoolean;
  }
  
  public void zzc(WorkSource paramWorkSource)
  {
    if ((zzoc.zzaz(this.mContext)) && (paramWorkSource != null))
    {
      if (this.zzbcg == null) {
        break label42;
      }
      this.zzbcg.add(paramWorkSource);
    }
    for (;;)
    {
      this.zzbcf.setWorkSource(this.zzbcg);
      return;
      label42:
      this.zzbcg = paramWorkSource;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */