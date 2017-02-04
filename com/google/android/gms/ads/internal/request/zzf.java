package com.google.android.gms.ads.internal.request;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzf
  implements Parcelable.Creator<AdRequestInfoParcel>
{
  static void zza(AdRequestInfoParcel paramAdRequestInfoParcel, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramAdRequestInfoParcel.versionCode);
    zzb.zza(paramParcel, 2, paramAdRequestInfoParcel.zzGp, false);
    zzb.zza(paramParcel, 3, paramAdRequestInfoParcel.zzGq, paramInt, false);
    zzb.zza(paramParcel, 4, paramAdRequestInfoParcel.zzqV, paramInt, false);
    zzb.zza(paramParcel, 5, paramAdRequestInfoParcel.zzqP, false);
    zzb.zza(paramParcel, 6, paramAdRequestInfoParcel.applicationInfo, paramInt, false);
    zzb.zza(paramParcel, 7, paramAdRequestInfoParcel.zzGr, paramInt, false);
    zzb.zza(paramParcel, 8, paramAdRequestInfoParcel.zzGs, false);
    zzb.zza(paramParcel, 9, paramAdRequestInfoParcel.zzGt, false);
    zzb.zza(paramParcel, 10, paramAdRequestInfoParcel.zzGu, false);
    zzb.zza(paramParcel, 11, paramAdRequestInfoParcel.zzqR, paramInt, false);
    zzb.zza(paramParcel, 12, paramAdRequestInfoParcel.zzGv, false);
    zzb.zzc(paramParcel, 13, paramAdRequestInfoParcel.zzGw);
    zzb.zzb(paramParcel, 14, paramAdRequestInfoParcel.zzrl, false);
    zzb.zza(paramParcel, 15, paramAdRequestInfoParcel.zzGx, false);
    zzb.zza(paramParcel, 17, paramAdRequestInfoParcel.zzGz, paramInt, false);
    zzb.zza(paramParcel, 16, paramAdRequestInfoParcel.zzGy);
    zzb.zzc(paramParcel, 19, paramAdRequestInfoParcel.zzGB);
    zzb.zzc(paramParcel, 18, paramAdRequestInfoParcel.zzGA);
    zzb.zza(paramParcel, 21, paramAdRequestInfoParcel.zzGD, false);
    zzb.zza(paramParcel, 20, paramAdRequestInfoParcel.zzGC);
    zzb.zza(paramParcel, 25, paramAdRequestInfoParcel.zzGE);
    zzb.zzb(paramParcel, 27, paramAdRequestInfoParcel.zzGG, false);
    zzb.zza(paramParcel, 26, paramAdRequestInfoParcel.zzGF, false);
    zzb.zza(paramParcel, 29, paramAdRequestInfoParcel.zzrj, paramInt, false);
    zzb.zza(paramParcel, 28, paramAdRequestInfoParcel.zzqO, false);
    zzb.zza(paramParcel, 31, paramAdRequestInfoParcel.zzGI);
    zzb.zzb(paramParcel, 30, paramAdRequestInfoParcel.zzGH, false);
    zzb.zza(paramParcel, 32, paramAdRequestInfoParcel.zzGJ, paramInt, false);
    zzb.zza(paramParcel, 33, paramAdRequestInfoParcel.zzGK, false);
    zzb.zzI(paramParcel, i);
  }
  
  public AdRequestInfoParcel[] zzG(int paramInt)
  {
    return new AdRequestInfoParcel[paramInt];
  }
  
  public AdRequestInfoParcel zzi(Parcel paramParcel)
  {
    int n = zza.zzau(paramParcel);
    int m = 0;
    Bundle localBundle3 = null;
    AdRequestParcel localAdRequestParcel = null;
    AdSizeParcel localAdSizeParcel = null;
    String str8 = null;
    ApplicationInfo localApplicationInfo = null;
    PackageInfo localPackageInfo = null;
    String str7 = null;
    String str6 = null;
    String str5 = null;
    VersionInfoParcel localVersionInfoParcel = null;
    Bundle localBundle2 = null;
    int k = 0;
    ArrayList localArrayList3 = null;
    Bundle localBundle1 = null;
    boolean bool = false;
    Messenger localMessenger = null;
    int j = 0;
    int i = 0;
    float f = 0.0F;
    String str4 = null;
    long l2 = 0L;
    String str3 = null;
    ArrayList localArrayList2 = null;
    String str2 = null;
    NativeAdOptionsParcel localNativeAdOptionsParcel = null;
    ArrayList localArrayList1 = null;
    long l1 = 0L;
    CapabilityParcel localCapabilityParcel = null;
    String str1 = null;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zza.zzat(paramParcel);
      switch (zza.zzcc(i1))
      {
      case 22: 
      case 23: 
      case 24: 
      default: 
        zza.zzb(paramParcel, i1);
        break;
      case 1: 
        m = zza.zzg(paramParcel, i1);
        break;
      case 2: 
        localBundle3 = zza.zzr(paramParcel, i1);
        break;
      case 3: 
        localAdRequestParcel = (AdRequestParcel)zza.zza(paramParcel, i1, AdRequestParcel.CREATOR);
        break;
      case 4: 
        localAdSizeParcel = (AdSizeParcel)zza.zza(paramParcel, i1, AdSizeParcel.CREATOR);
        break;
      case 5: 
        str8 = zza.zzp(paramParcel, i1);
        break;
      case 6: 
        localApplicationInfo = (ApplicationInfo)zza.zza(paramParcel, i1, ApplicationInfo.CREATOR);
        break;
      case 7: 
        localPackageInfo = (PackageInfo)zza.zza(paramParcel, i1, PackageInfo.CREATOR);
        break;
      case 8: 
        str7 = zza.zzp(paramParcel, i1);
        break;
      case 9: 
        str6 = zza.zzp(paramParcel, i1);
        break;
      case 10: 
        str5 = zza.zzp(paramParcel, i1);
        break;
      case 11: 
        localVersionInfoParcel = (VersionInfoParcel)zza.zza(paramParcel, i1, VersionInfoParcel.CREATOR);
        break;
      case 12: 
        localBundle2 = zza.zzr(paramParcel, i1);
        break;
      case 13: 
        k = zza.zzg(paramParcel, i1);
        break;
      case 14: 
        localArrayList3 = zza.zzD(paramParcel, i1);
        break;
      case 15: 
        localBundle1 = zza.zzr(paramParcel, i1);
        break;
      case 17: 
        localMessenger = (Messenger)zza.zza(paramParcel, i1, Messenger.CREATOR);
        break;
      case 16: 
        bool = zza.zzc(paramParcel, i1);
        break;
      case 19: 
        i = zza.zzg(paramParcel, i1);
        break;
      case 18: 
        j = zza.zzg(paramParcel, i1);
        break;
      case 21: 
        str4 = zza.zzp(paramParcel, i1);
        break;
      case 20: 
        f = zza.zzl(paramParcel, i1);
        break;
      case 25: 
        l2 = zza.zzi(paramParcel, i1);
        break;
      case 27: 
        localArrayList2 = zza.zzD(paramParcel, i1);
        break;
      case 26: 
        str3 = zza.zzp(paramParcel, i1);
        break;
      case 29: 
        localNativeAdOptionsParcel = (NativeAdOptionsParcel)zza.zza(paramParcel, i1, NativeAdOptionsParcel.CREATOR);
        break;
      case 28: 
        str2 = zza.zzp(paramParcel, i1);
        break;
      case 31: 
        l1 = zza.zzi(paramParcel, i1);
        break;
      case 30: 
        localArrayList1 = zza.zzD(paramParcel, i1);
        break;
      case 32: 
        localCapabilityParcel = (CapabilityParcel)zza.zza(paramParcel, i1, CapabilityParcel.CREATOR);
        break;
      case 33: 
        str1 = zza.zzp(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zza.zza("Overread allowed size end=" + n, paramParcel);
    }
    return new AdRequestInfoParcel(m, localBundle3, localAdRequestParcel, localAdSizeParcel, str8, localApplicationInfo, localPackageInfo, str7, str6, str5, localVersionInfoParcel, localBundle2, k, localArrayList3, localBundle1, bool, localMessenger, j, i, f, str4, l2, str3, localArrayList2, str2, localNativeAdOptionsParcel, localArrayList1, l1, localCapabilityParcel, str1);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/request/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */