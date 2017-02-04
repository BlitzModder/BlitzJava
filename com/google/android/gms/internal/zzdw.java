package com.google.android.gms.internal;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.common.api.Releasable;
import java.util.HashMap;
import java.util.Map;

@zzha
public abstract class zzdw
  implements Releasable
{
  protected zzjn zzps;
  
  public zzdw(zzjn paramzzjn)
  {
    this.zzps = paramzzjn;
  }
  
  private String zzab(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return "internal";
        if (paramString.equals("error"))
        {
          i = 0;
          continue;
          if (paramString.equals("playerFailed"))
          {
            i = 1;
            continue;
            if (paramString.equals("inProgress"))
            {
              i = 2;
              continue;
              if (paramString.equals("contentLengthMissing"))
              {
                i = 3;
                continue;
                if (paramString.equals("noCacheDir"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("expireFailed"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("badUrl"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("downloadTimeout"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("sizeExceeded"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("externalAbort")) {
                            i = 9;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return "internal";
    return "io";
    return "network";
    return "policy";
  }
  
  public abstract void abort();
  
  public void release() {}
  
  public abstract boolean zzZ(String paramString);
  
  protected void zza(final String paramString1, final String paramString2, final int paramInt)
  {
    zza.zzLE.post(new Runnable()
    {
      public void run()
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("event", "precacheComplete");
        localHashMap.put("src", paramString1);
        localHashMap.put("cachedSrc", paramString2);
        localHashMap.put("totalBytes", Integer.toString(paramInt));
        zzdw.this.zzps.zzb("onPrecacheEvent", localHashMap);
      }
    });
  }
  
  protected void zza(final String paramString1, final String paramString2, final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    zza.zzLE.post(new Runnable()
    {
      public void run()
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("event", "precacheProgress");
        localHashMap.put("src", paramString1);
        localHashMap.put("cachedSrc", paramString2);
        localHashMap.put("bytesLoaded", Integer.toString(paramInt1));
        localHashMap.put("totalBytes", Integer.toString(paramInt2));
        if (paramBoolean) {}
        for (String str = "1";; str = "0")
        {
          localHashMap.put("cacheReady", str);
          zzdw.this.zzps.zzb("onPrecacheEvent", localHashMap);
          return;
        }
      }
    });
  }
  
  protected void zza(final String paramString1, final String paramString2, final String paramString3, final String paramString4)
  {
    zza.zzLE.post(new Runnable()
    {
      public void run()
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("event", "precacheCanceled");
        localHashMap.put("src", paramString1);
        if (!TextUtils.isEmpty(paramString2)) {
          localHashMap.put("cachedSrc", paramString2);
        }
        localHashMap.put("type", zzdw.zza(zzdw.this, paramString3));
        localHashMap.put("reason", paramString3);
        if (!TextUtils.isEmpty(paramString4)) {
          localHashMap.put("message", paramString4);
        }
        zzdw.this.zzps.zzb("onPrecacheEvent", localHashMap);
      }
    });
  }
  
  protected String zzaa(String paramString)
  {
    return zzl.zzcN().zzaE(paramString);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzdw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */