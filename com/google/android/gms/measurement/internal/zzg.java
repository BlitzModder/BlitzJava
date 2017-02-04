package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.Set;

public class zzg
{
  final String mName;
  final String zzaRd;
  final String zzaSC;
  final long zzaSD;
  final EventParams zzaSE;
  final long zzacS;
  
  zzg(zzt paramzzt, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, Bundle paramBundle)
  {
    zzx.zzcG(paramString2);
    zzx.zzcG(paramString3);
    this.zzaRd = paramString2;
    this.mName = paramString3;
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = null;
    }
    this.zzaSC = paramString2;
    this.zzacS = paramLong1;
    this.zzaSD = paramLong2;
    if ((this.zzaSD != 0L) && (this.zzaSD > this.zzacS)) {
      paramzzt.zzzz().zzBm().zzez("Event created with reverse previous/current timestamps");
    }
    this.zzaSE = zza(paramzzt, paramBundle);
  }
  
  private zzg(zzt paramzzt, String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2, EventParams paramEventParams)
  {
    zzx.zzcG(paramString2);
    zzx.zzcG(paramString3);
    zzx.zzy(paramEventParams);
    this.zzaRd = paramString2;
    this.mName = paramString3;
    paramString2 = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      paramString2 = null;
    }
    this.zzaSC = paramString2;
    this.zzacS = paramLong1;
    this.zzaSD = paramLong2;
    if ((this.zzaSD != 0L) && (this.zzaSD > this.zzacS)) {
      paramzzt.zzzz().zzBm().zzez("Event created with reverse previous/current timestamps");
    }
    this.zzaSE = paramEventParams;
  }
  
  private EventParams zza(zzt paramzzt, Bundle paramBundle)
  {
    if ((paramBundle != null) && (!paramBundle.isEmpty()))
    {
      paramBundle = new Bundle(paramBundle);
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (str == null)
        {
          localIterator.remove();
        }
        else
        {
          Object localObject = paramzzt.zzAU().zzk(str, paramBundle.get(str));
          if (localObject == null) {
            localIterator.remove();
          } else {
            paramzzt.zzAU().zza(paramBundle, str, localObject);
          }
        }
      }
      return new EventParams(paramBundle);
    }
    return new EventParams(new Bundle());
  }
  
  public String toString()
  {
    return "Event{appId='" + this.zzaRd + '\'' + ", name='" + this.mName + '\'' + ", params=" + this.zzaSE + '}';
  }
  
  zzg zza(zzt paramzzt, long paramLong)
  {
    return new zzg(paramzzt, this.zzaSC, this.zzaRd, this.mName, this.zzacS, paramLong, this.zzaSE);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */