package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzh
  implements Parcelable.Creator<AdResponseParcel>
{
  static void zza(AdResponseParcel paramAdResponseParcel, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramAdResponseParcel.versionCode);
    zzb.zza(paramParcel, 2, paramAdResponseParcel.zzDE, false);
    zzb.zza(paramParcel, 3, paramAdResponseParcel.body, false);
    zzb.zzb(paramParcel, 4, paramAdResponseParcel.zzAQ, false);
    zzb.zzc(paramParcel, 5, paramAdResponseParcel.errorCode);
    zzb.zzb(paramParcel, 6, paramAdResponseParcel.zzAR, false);
    zzb.zza(paramParcel, 7, paramAdResponseParcel.zzGM);
    zzb.zza(paramParcel, 8, paramAdResponseParcel.zzGN);
    zzb.zza(paramParcel, 9, paramAdResponseParcel.zzGO);
    zzb.zzb(paramParcel, 10, paramAdResponseParcel.zzGP, false);
    zzb.zza(paramParcel, 11, paramAdResponseParcel.zzAU);
    zzb.zzc(paramParcel, 12, paramAdResponseParcel.orientation);
    zzb.zza(paramParcel, 13, paramAdResponseParcel.zzGQ, false);
    zzb.zza(paramParcel, 14, paramAdResponseParcel.zzGR);
    zzb.zza(paramParcel, 15, paramAdResponseParcel.zzGS, false);
    zzb.zza(paramParcel, 19, paramAdResponseParcel.zzGU, false);
    zzb.zza(paramParcel, 18, paramAdResponseParcel.zzGT);
    zzb.zza(paramParcel, 21, paramAdResponseParcel.zzGV, false);
    zzb.zza(paramParcel, 23, paramAdResponseParcel.zztY);
    zzb.zza(paramParcel, 22, paramAdResponseParcel.zzGW);
    zzb.zza(paramParcel, 25, paramAdResponseParcel.zzGX);
    zzb.zza(paramParcel, 24, paramAdResponseParcel.zzGy);
    zzb.zzc(paramParcel, 27, paramAdResponseParcel.zzGZ);
    zzb.zza(paramParcel, 26, paramAdResponseParcel.zzGY);
    zzb.zza(paramParcel, 29, paramAdResponseParcel.zzHb, false);
    zzb.zza(paramParcel, 28, paramAdResponseParcel.zzHa, paramInt, false);
    zzb.zza(paramParcel, 31, paramAdResponseParcel.zztZ);
    zzb.zza(paramParcel, 30, paramAdResponseParcel.zzHc, false);
    zzb.zzI(paramParcel, i);
  }
  
  public AdResponseParcel[] zzH(int paramInt)
  {
    return new AdResponseParcel[paramInt];
  }
  
  public AdResponseParcel zzj(Parcel paramParcel)
  {
    int n = zza.zzau(paramParcel);
    int m = 0;
    String str8 = null;
    String str7 = null;
    ArrayList localArrayList3 = null;
    int k = 0;
    ArrayList localArrayList2 = null;
    long l4 = 0L;
    boolean bool8 = false;
    long l3 = 0L;
    ArrayList localArrayList1 = null;
    long l2 = 0L;
    int j = 0;
    String str6 = null;
    long l1 = 0L;
    String str5 = null;
    boolean bool7 = false;
    String str4 = null;
    String str3 = null;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    int i = 0;
    LargeParcelTeleporter localLargeParcelTeleporter = null;
    String str2 = null;
    String str1 = null;
    boolean bool1 = false;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zza.zzat(paramParcel);
      switch (zza.zzcc(i1))
      {
      case 16: 
      case 17: 
      case 20: 
      default: 
        zza.zzb(paramParcel, i1);
        break;
      case 1: 
        m = zza.zzg(paramParcel, i1);
        break;
      case 2: 
        str8 = zza.zzp(paramParcel, i1);
        break;
      case 3: 
        str7 = zza.zzp(paramParcel, i1);
        break;
      case 4: 
        localArrayList3 = zza.zzD(paramParcel, i1);
        break;
      case 5: 
        k = zza.zzg(paramParcel, i1);
        break;
      case 6: 
        localArrayList2 = zza.zzD(paramParcel, i1);
        break;
      case 7: 
        l4 = zza.zzi(paramParcel, i1);
        break;
      case 8: 
        bool8 = zza.zzc(paramParcel, i1);
        break;
      case 9: 
        l3 = zza.zzi(paramParcel, i1);
        break;
      case 10: 
        localArrayList1 = zza.zzD(paramParcel, i1);
        break;
      case 11: 
        l2 = zza.zzi(paramParcel, i1);
        break;
      case 12: 
        j = zza.zzg(paramParcel, i1);
        break;
      case 13: 
        str6 = zza.zzp(paramParcel, i1);
        break;
      case 14: 
        l1 = zza.zzi(paramParcel, i1);
        break;
      case 15: 
        str5 = zza.zzp(paramParcel, i1);
        break;
      case 19: 
        str4 = zza.zzp(paramParcel, i1);
        break;
      case 18: 
        bool7 = zza.zzc(paramParcel, i1);
        break;
      case 21: 
        str3 = zza.zzp(paramParcel, i1);
        break;
      case 23: 
        bool5 = zza.zzc(paramParcel, i1);
        break;
      case 22: 
        bool6 = zza.zzc(paramParcel, i1);
        break;
      case 25: 
        bool3 = zza.zzc(paramParcel, i1);
        break;
      case 24: 
        bool4 = zza.zzc(paramParcel, i1);
        break;
      case 27: 
        i = zza.zzg(paramParcel, i1);
        break;
      case 26: 
        bool2 = zza.zzc(paramParcel, i1);
        break;
      case 29: 
        str2 = zza.zzp(paramParcel, i1);
        break;
      case 28: 
        localLargeParcelTeleporter = (LargeParcelTeleporter)zza.zza(paramParcel, i1, LargeParcelTeleporter.CREATOR);
        break;
      case 31: 
        bool1 = zza.zzc(paramParcel, i1);
        break;
      case 30: 
        str1 = zza.zzp(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zza.zza("Overread allowed size end=" + n, paramParcel);
    }
    return new AdResponseParcel(m, str8, str7, localArrayList3, k, localArrayList2, l4, bool8, l3, localArrayList1, l2, j, str6, l1, str5, bool7, str4, str3, bool6, bool5, bool4, bool3, bool2, i, localLargeParcelTeleporter, str2, str1, bool1);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/request/zzh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */