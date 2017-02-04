package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

@zzha
public final class zzdt
  implements zzdl
{
  private final Map<zzjn, Integer> zzzi = new WeakHashMap();
  
  private static int zza(Context paramContext, Map<String, String> paramMap, String paramString, int paramInt)
  {
    paramMap = (String)paramMap.get(paramString);
    int i = paramInt;
    if (paramMap != null) {}
    try
    {
      i = zzl.zzcN().zzb(paramContext, Integer.parseInt(paramMap));
      return i;
    }
    catch (NumberFormatException paramContext)
    {
      zzb.zzaH("Could not parse " + paramString + " in a video GMSG: " + paramMap);
    }
    return paramInt;
  }
  
  public void zza(zzjn paramzzjn, Map<String, String> paramMap)
  {
    Object localObject2 = (String)paramMap.get("action");
    if (localObject2 == null) {
      zzb.zzaH("Action missing from video GMSG.");
    }
    int i;
    int j;
    for (;;)
    {
      return;
      if (zzb.zzQ(3))
      {
        localObject1 = new JSONObject(paramMap);
        ((JSONObject)localObject1).remove("google.afma.Notify_dt");
        zzb.zzaF("Video GMSG: " + (String)localObject2 + " " + ((JSONObject)localObject1).toString());
      }
      if ("background".equals(localObject2))
      {
        paramMap = (String)paramMap.get("color");
        if (TextUtils.isEmpty(paramMap))
        {
          zzb.zzaH("Color parameter missing from color video GMSG.");
          return;
        }
        try
        {
          i = Color.parseColor(paramMap);
          paramMap = paramzzjn.zzhJ();
          if (paramMap != null)
          {
            paramMap = paramMap.zzhv();
            if (paramMap != null)
            {
              paramMap.setBackgroundColor(i);
              return;
            }
          }
        }
        catch (IllegalArgumentException paramzzjn)
        {
          zzb.zzaH("Invalid color parameter in video GMSG.");
          return;
        }
        this.zzzi.put(paramzzjn, Integer.valueOf(i));
        return;
      }
      localObject1 = paramzzjn.zzhJ();
      if (localObject1 == null)
      {
        zzb.zzaH("Could not get underlay container for a video GMSG.");
        return;
      }
      boolean bool1 = "new".equals(localObject2);
      boolean bool2 = "position".equals(localObject2);
      if ((bool1) || (bool2))
      {
        localObject2 = paramzzjn.getContext();
        j = zza((Context)localObject2, paramMap, "x", 0);
        int k = zza((Context)localObject2, paramMap, "y", 0);
        int m = zza((Context)localObject2, paramMap, "w", -1);
        int n = zza((Context)localObject2, paramMap, "h", -1);
        try
        {
          i = Integer.parseInt((String)paramMap.get("player"));
          if ((bool1) && (((zzjm)localObject1).zzhv() == null))
          {
            ((zzjm)localObject1).zza(j, k, m, n, i);
            if (!this.zzzi.containsKey(paramzzjn)) {
              continue;
            }
            i = ((Integer)this.zzzi.get(paramzzjn)).intValue();
            paramzzjn = ((zzjm)localObject1).zzhv();
            paramzzjn.setBackgroundColor(i);
            paramzzjn.zzft();
          }
        }
        catch (NumberFormatException paramMap)
        {
          for (;;)
          {
            i = 0;
          }
          ((zzjm)localObject1).zze(j, k, m, n);
          return;
        }
      }
    }
    Object localObject1 = ((zzjm)localObject1).zzhv();
    if (localObject1 == null)
    {
      zzk.zzd(paramzzjn);
      return;
    }
    if ("click".equals(localObject2))
    {
      paramzzjn = paramzzjn.getContext();
      i = zza(paramzzjn, paramMap, "x", 0);
      j = zza(paramzzjn, paramMap, "y", 0);
      long l = SystemClock.uptimeMillis();
      paramzzjn = MotionEvent.obtain(l, l, 0, i, j, 0);
      ((zzk)localObject1).zzd(paramzzjn);
      paramzzjn.recycle();
      return;
    }
    if ("currentTime".equals(localObject2))
    {
      paramzzjn = (String)paramMap.get("time");
      if (paramzzjn == null)
      {
        zzb.zzaH("Time parameter missing from currentTime video GMSG.");
        return;
      }
      try
      {
        ((zzk)localObject1).seekTo((int)(Float.parseFloat(paramzzjn) * 1000.0F));
        return;
      }
      catch (NumberFormatException paramMap)
      {
        zzb.zzaH("Could not parse time parameter from currentTime video GMSG: " + paramzzjn);
        return;
      }
    }
    if ("hide".equals(localObject2))
    {
      ((zzk)localObject1).setVisibility(4);
      return;
    }
    if ("load".equals(localObject2))
    {
      ((zzk)localObject1).zzfs();
      return;
    }
    if ("mimetype".equals(localObject2))
    {
      ((zzk)localObject1).setMimeType((String)paramMap.get("mimetype"));
      return;
    }
    if ("muted".equals(localObject2))
    {
      if (Boolean.parseBoolean((String)paramMap.get("muted")))
      {
        ((zzk)localObject1).zzeU();
        return;
      }
      ((zzk)localObject1).zzeV();
      return;
    }
    if ("pause".equals(localObject2))
    {
      ((zzk)localObject1).pause();
      return;
    }
    if ("play".equals(localObject2))
    {
      ((zzk)localObject1).play();
      return;
    }
    if ("show".equals(localObject2))
    {
      ((zzk)localObject1).setVisibility(0);
      return;
    }
    if ("src".equals(localObject2))
    {
      ((zzk)localObject1).zzao((String)paramMap.get("src"));
      return;
    }
    if ("volume".equals(localObject2))
    {
      paramzzjn = (String)paramMap.get("volume");
      if (paramzzjn == null)
      {
        zzb.zzaH("Level parameter missing from volume video GMSG.");
        return;
      }
      try
      {
        ((zzk)localObject1).zza(Float.parseFloat(paramzzjn));
        return;
      }
      catch (NumberFormatException paramMap)
      {
        zzb.zzaH("Could not parse volume parameter from volume video GMSG: " + paramzzjn);
        return;
      }
    }
    if ("watermark".equals(localObject2))
    {
      ((zzk)localObject1).zzft();
      return;
    }
    zzb.zzaH("Unknown video action: " + (String)localObject2);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzdt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */