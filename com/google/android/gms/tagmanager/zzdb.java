package com.google.android.gms.tagmanager;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag.zza;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class zzdb
  extends zzak
{
  private static final String ID = zzad.zzdc.toString();
  private static final String NAME = zzae.zzgf.toString();
  private static final String zzbgj = zzae.zzfK.toString();
  private static final String zzbgk = zzae.zzfS.toString();
  private static final String zzbgl = zzae.zzhN.toString();
  private final Context mContext;
  private Handler mHandler;
  private DataLayer zzbcG;
  private boolean zzbgm;
  private boolean zzbgn;
  private final HandlerThread zzbgo;
  private final Set<String> zzbgp = new HashSet();
  
  public zzdb(Context paramContext, DataLayer paramDataLayer)
  {
    super(ID, new String[] { zzbgj, NAME });
    this.mContext = paramContext;
    this.zzbcG = paramDataLayer;
    this.zzbgo = new HandlerThread("Google GTM SDK Timer", 10);
    this.zzbgo.start();
    this.mHandler = new Handler(this.zzbgo.getLooper());
  }
  
  public boolean zzEa()
  {
    return false;
  }
  
  public zzag.zza zzI(Map<String, zzag.zza> paramMap)
  {
    String str2 = zzdf.zzg((zzag.zza)paramMap.get(NAME));
    String str1 = zzdf.zzg((zzag.zza)paramMap.get(zzbgl));
    String str3 = zzdf.zzg((zzag.zza)paramMap.get(zzbgj));
    paramMap = zzdf.zzg((zzag.zza)paramMap.get(zzbgk));
    try
    {
      l1 = Long.parseLong(str3);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      try
      {
        for (;;)
        {
          l2 = Long.parseLong(paramMap);
          if ((l1 > 0L) && (!TextUtils.isEmpty(str2)))
          {
            if (str1 != null)
            {
              paramMap = str1;
              if (!str1.isEmpty()) {}
            }
            else
            {
              paramMap = "0";
            }
            if (!this.zzbgp.contains(paramMap))
            {
              if (!"0".equals(paramMap)) {
                this.zzbgp.add(paramMap);
              }
              this.mHandler.postDelayed(new zza(str2, paramMap, l1, l2), l1);
            }
          }
          return zzdf.zzFJ();
          localNumberFormatException = localNumberFormatException;
          long l1 = 0L;
        }
      }
      catch (NumberFormatException paramMap)
      {
        for (;;)
        {
          long l2 = 0L;
        }
      }
    }
  }
  
  private final class zza
    implements Runnable
  {
    private final long zzBv;
    private final long zzaLk;
    private final String zzbgq;
    private final String zzbgr;
    private final long zzbgs;
    private long zzbgt;
    
    zza(String paramString1, String paramString2, long paramLong1, long paramLong2)
    {
      this.zzbgq = paramString1;
      this.zzbgr = paramString2;
      this.zzaLk = paramLong1;
      this.zzbgs = paramLong2;
      this.zzBv = System.currentTimeMillis();
    }
    
    public void run()
    {
      if ((this.zzbgs > 0L) && (this.zzbgt >= this.zzbgs))
      {
        if (!"0".equals(this.zzbgr)) {
          zzdb.zza(zzdb.this).remove(this.zzbgr);
        }
        return;
      }
      this.zzbgt += 1L;
      if (zzcC())
      {
        long l = System.currentTimeMillis();
        zzdb.zzb(zzdb.this).push(DataLayer.mapOf(new Object[] { "event", this.zzbgq, "gtm.timerInterval", String.valueOf(this.zzaLk), "gtm.timerLimit", String.valueOf(this.zzbgs), "gtm.timerStartTime", String.valueOf(this.zzBv), "gtm.timerCurrentTime", String.valueOf(l), "gtm.timerElapsedTime", String.valueOf(l - this.zzBv), "gtm.timerEventNumber", String.valueOf(this.zzbgt), "gtm.triggers", this.zzbgr }));
      }
      zzdb.zzc(zzdb.this).postDelayed(this, this.zzaLk);
    }
    
    protected boolean zzcC()
    {
      if (zzdb.zzd(zzdb.this)) {
        return zzdb.zze(zzdb.this);
      }
      Object localObject = (ActivityManager)zzdb.zzf(zzdb.this).getSystemService("activity");
      KeyguardManager localKeyguardManager = (KeyguardManager)zzdb.zzf(zzdb.this).getSystemService("keyguard");
      PowerManager localPowerManager = (PowerManager)zzdb.zzf(zzdb.this).getSystemService("power");
      localObject = ((ActivityManager)localObject).getRunningAppProcesses().iterator();
      while (((Iterator)localObject).hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
        if ((Process.myPid() == localRunningAppProcessInfo.pid) && (localRunningAppProcessInfo.importance == 100) && (!localKeyguardManager.inKeyguardRestrictedInputMode()) && (localPowerManager.isScreenOn())) {
          return true;
        }
      }
      return false;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzdb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */