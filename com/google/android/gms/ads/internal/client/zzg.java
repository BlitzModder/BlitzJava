package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzg
  implements Parcelable.Creator<AdRequestParcel>
{
  static void zza(AdRequestParcel paramAdRequestParcel, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramAdRequestParcel.versionCode);
    zzb.zza(paramParcel, 2, paramAdRequestParcel.zztq);
    zzb.zza(paramParcel, 3, paramAdRequestParcel.extras, false);
    zzb.zzc(paramParcel, 4, paramAdRequestParcel.zztr);
    zzb.zzb(paramParcel, 5, paramAdRequestParcel.zzts, false);
    zzb.zza(paramParcel, 6, paramAdRequestParcel.zztt);
    zzb.zzc(paramParcel, 7, paramAdRequestParcel.zztu);
    zzb.zza(paramParcel, 8, paramAdRequestParcel.zztv);
    zzb.zza(paramParcel, 9, paramAdRequestParcel.zztw, false);
    zzb.zza(paramParcel, 10, paramAdRequestParcel.zztx, paramInt, false);
    zzb.zza(paramParcel, 11, paramAdRequestParcel.zzty, paramInt, false);
    zzb.zza(paramParcel, 12, paramAdRequestParcel.zztz, false);
    zzb.zza(paramParcel, 13, paramAdRequestParcel.zztA, false);
    zzb.zza(paramParcel, 14, paramAdRequestParcel.zztB, false);
    zzb.zzb(paramParcel, 15, paramAdRequestParcel.zztC, false);
    zzb.zza(paramParcel, 17, paramAdRequestParcel.zztE, false);
    zzb.zza(paramParcel, 16, paramAdRequestParcel.zztD, false);
    zzb.zza(paramParcel, 18, paramAdRequestParcel.zztF);
    zzb.zzI(paramParcel, i);
  }
  
  public AdRequestParcel zzb(Parcel paramParcel)
  {
    int m = zza.zzau(paramParcel);
    int k = 0;
    long l = 0L;
    Bundle localBundle3 = null;
    int j = 0;
    ArrayList localArrayList2 = null;
    boolean bool3 = false;
    int i = 0;
    boolean bool2 = false;
    String str4 = null;
    SearchAdRequestParcel localSearchAdRequestParcel = null;
    Location localLocation = null;
    String str3 = null;
    Bundle localBundle2 = null;
    Bundle localBundle1 = null;
    ArrayList localArrayList1 = null;
    String str2 = null;
    String str1 = null;
    boolean bool1 = false;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzat(paramParcel);
      switch (zza.zzcc(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        l = zza.zzi(paramParcel, n);
        break;
      case 3: 
        localBundle3 = zza.zzr(paramParcel, n);
        break;
      case 4: 
        j = zza.zzg(paramParcel, n);
        break;
      case 5: 
        localArrayList2 = zza.zzD(paramParcel, n);
        break;
      case 6: 
        bool3 = zza.zzc(paramParcel, n);
        break;
      case 7: 
        i = zza.zzg(paramParcel, n);
        break;
      case 8: 
        bool2 = zza.zzc(paramParcel, n);
        break;
      case 9: 
        str4 = zza.zzp(paramParcel, n);
        break;
      case 10: 
        localSearchAdRequestParcel = (SearchAdRequestParcel)zza.zza(paramParcel, n, SearchAdRequestParcel.CREATOR);
        break;
      case 11: 
        localLocation = (Location)zza.zza(paramParcel, n, Location.CREATOR);
        break;
      case 12: 
        str3 = zza.zzp(paramParcel, n);
        break;
      case 13: 
        localBundle2 = zza.zzr(paramParcel, n);
        break;
      case 14: 
        localBundle1 = zza.zzr(paramParcel, n);
        break;
      case 15: 
        localArrayList1 = zza.zzD(paramParcel, n);
        break;
      case 17: 
        str1 = zza.zzp(paramParcel, n);
        break;
      case 16: 
        str2 = zza.zzp(paramParcel, n);
        break;
      case 18: 
        bool1 = zza.zzc(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new AdRequestParcel(k, l, localBundle3, j, localArrayList2, bool3, i, bool2, str4, localSearchAdRequestParcel, localLocation, str3, localBundle2, localBundle1, localArrayList1, str2, str1, bool1);
  }
  
  public AdRequestParcel[] zzl(int paramInt)
  {
    return new AdRequestParcel[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/client/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */