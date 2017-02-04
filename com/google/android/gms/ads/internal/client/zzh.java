package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzip;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzha
public class zzh
{
  public static final zzh zztU = new zzh();
  
  public static zzh zzcJ()
  {
    return zztU;
  }
  
  public AdRequestParcel zza(Context paramContext, zzy paramzzy)
  {
    Object localObject1 = paramzzy.getBirthday();
    long l;
    String str1;
    int i;
    label59:
    boolean bool1;
    int j;
    Location localLocation;
    Bundle localBundle;
    boolean bool2;
    String str2;
    if (localObject1 != null)
    {
      l = ((Date)localObject1).getTime();
      str1 = paramzzy.getContentUrl();
      i = paramzzy.getGender();
      localObject1 = paramzzy.getKeywords();
      if (((Set)localObject1).isEmpty()) {
        break label231;
      }
      localObject1 = Collections.unmodifiableList(new ArrayList((Collection)localObject1));
      bool1 = paramzzy.isTestDevice(paramContext);
      j = paramzzy.zzcX();
      localLocation = paramzzy.getLocation();
      localBundle = paramzzy.getNetworkExtrasBundle(AdMobAdapter.class);
      bool2 = paramzzy.getManualImpressionsEnabled();
      str2 = paramzzy.getPublisherProvidedId();
      localObject2 = paramzzy.zzcU();
      if (localObject2 == null) {
        break label237;
      }
    }
    label231:
    label237:
    for (Object localObject2 = new SearchAdRequestParcel((SearchAdRequest)localObject2);; localObject2 = null)
    {
      Object localObject3 = null;
      Context localContext = paramContext.getApplicationContext();
      paramContext = (Context)localObject3;
      if (localContext != null)
      {
        paramContext = localContext.getPackageName();
        paramContext = zzp.zzbx().zza(Thread.currentThread().getStackTrace(), paramContext);
      }
      boolean bool3 = paramzzy.isDesignedForFamilies();
      return new AdRequestParcel(7, l, localBundle, i, (List)localObject1, bool1, j, bool2, str2, (SearchAdRequestParcel)localObject2, localLocation, str1, paramzzy.zzcW(), paramzzy.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(paramzzy.zzcY())), paramzzy.zzcT(), paramContext, bool3);
      l = -1L;
      break;
      localObject1 = null;
      break label59;
    }
  }
  
  public RewardedVideoAdRequestParcel zza(Context paramContext, zzy paramzzy, String paramString)
  {
    return new RewardedVideoAdRequestParcel(zza(paramContext, paramzzy), paramString);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/client/zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */