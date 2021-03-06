package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzm
  implements Parcelable.Creator<RawBucket>
{
  static void zza(RawBucket paramRawBucket, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramRawBucket.zzQj);
    zzb.zzc(paramParcel, 1000, paramRawBucket.mVersionCode);
    zzb.zza(paramParcel, 2, paramRawBucket.zzatQ);
    zzb.zza(paramParcel, 3, paramRawBucket.zzatS, paramInt, false);
    zzb.zzc(paramParcel, 4, paramRawBucket.zzauW);
    zzb.zzc(paramParcel, 5, paramRawBucket.zzaub, false);
    zzb.zzc(paramParcel, 6, paramRawBucket.zzauc);
    zzb.zza(paramParcel, 7, paramRawBucket.zzaud);
    zzb.zzI(paramParcel, i);
  }
  
  public RawBucket zzcT(Parcel paramParcel)
  {
    long l1 = 0L;
    ArrayList localArrayList = null;
    boolean bool = false;
    int m = zza.zzau(paramParcel);
    int i = 0;
    int j = 0;
    Session localSession = null;
    long l2 = 0L;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzat(paramParcel);
      switch (zza.zzcc(n))
      {
      default: 
        zza.zzb(paramParcel, n);
        break;
      case 1: 
        l2 = zza.zzi(paramParcel, n);
        break;
      case 1000: 
        k = zza.zzg(paramParcel, n);
        break;
      case 2: 
        l1 = zza.zzi(paramParcel, n);
        break;
      case 3: 
        localSession = (Session)zza.zza(paramParcel, n, Session.CREATOR);
        break;
      case 4: 
        j = zza.zzg(paramParcel, n);
        break;
      case 5: 
        localArrayList = zza.zzc(paramParcel, n, RawDataSet.CREATOR);
        break;
      case 6: 
        i = zza.zzg(paramParcel, n);
        break;
      case 7: 
        bool = zza.zzc(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new RawBucket(k, l2, l1, localSession, j, localArrayList, i, bool);
  }
  
  public RawBucket[] zzeS(int paramInt)
  {
    return new RawBucket[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */