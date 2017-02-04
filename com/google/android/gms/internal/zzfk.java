package com.google.android.gms.internal;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdRequest.Gender;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.zza;
import java.util.Date;
import java.util.HashSet;

@zzha
public final class zzfk
{
  public static int zza(AdRequest.ErrorCode paramErrorCode)
  {
    switch (1.zzBT[paramErrorCode.ordinal()])
    {
    default: 
      return 0;
    case 2: 
      return 1;
    case 3: 
      return 2;
    }
    return 3;
  }
  
  public static AdSize zzb(AdSizeParcel paramAdSizeParcel)
  {
    int i = 0;
    AdSize[] arrayOfAdSize = new AdSize[6];
    arrayOfAdSize[0] = AdSize.SMART_BANNER;
    arrayOfAdSize[1] = AdSize.BANNER;
    arrayOfAdSize[2] = AdSize.IAB_MRECT;
    arrayOfAdSize[3] = AdSize.IAB_BANNER;
    arrayOfAdSize[4] = AdSize.IAB_LEADERBOARD;
    arrayOfAdSize[5] = AdSize.IAB_WIDE_SKYSCRAPER;
    while (i < arrayOfAdSize.length)
    {
      if ((arrayOfAdSize[i].getWidth() == paramAdSizeParcel.width) && (arrayOfAdSize[i].getHeight() == paramAdSizeParcel.height)) {
        return arrayOfAdSize[i];
      }
      i += 1;
    }
    return new AdSize(zza.zza(paramAdSizeParcel.width, paramAdSizeParcel.height, paramAdSizeParcel.zztV));
  }
  
  public static MediationAdRequest zzi(AdRequestParcel paramAdRequestParcel)
  {
    if (paramAdRequestParcel.zzts != null) {}
    for (HashSet localHashSet = new HashSet(paramAdRequestParcel.zzts);; localHashSet = null) {
      return new MediationAdRequest(new Date(paramAdRequestParcel.zztq), zzu(paramAdRequestParcel.zztr), localHashSet, paramAdRequestParcel.zztt, paramAdRequestParcel.zzty);
    }
  }
  
  public static AdRequest.Gender zzu(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return AdRequest.Gender.UNKNOWN;
    case 2: 
      return AdRequest.Gender.FEMALE;
    }
    return AdRequest.Gender.MALE;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzfk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */