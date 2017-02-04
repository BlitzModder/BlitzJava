package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq
  implements Parcelable.Creator<SessionDataSet>
{
  static void zza(SessionDataSet paramSessionDataSet, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramSessionDataSet.getSession(), paramInt, false);
    zzb.zzc(paramParcel, 1000, paramSessionDataSet.mVersionCode);
    zzb.zza(paramParcel, 2, paramSessionDataSet.zztT(), paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public SessionDataSet zzcX(Parcel paramParcel)
  {
    DataSet localDataSet = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    Session localSession = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
      }
      for (;;)
      {
        break;
        localSession = (Session)zza.zza(paramParcel, k, Session.CREATOR);
        continue;
        i = zza.zzg(paramParcel, k);
        continue;
        localDataSet = (DataSet)zza.zza(paramParcel, k, DataSet.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new SessionDataSet(i, localSession, localDataSet);
  }
  
  public SessionDataSet[] zzeX(int paramInt)
  {
    return new SessionDataSet[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/zzq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */