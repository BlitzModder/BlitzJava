package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.fitness.data.Field;
import java.util.ArrayList;

public class zzi
  implements Parcelable.Creator<DataTypeCreateRequest>
{
  static void zza(DataTypeCreateRequest paramDataTypeCreateRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramDataTypeCreateRequest.getName(), false);
    zzb.zzc(paramParcel, 1000, paramDataTypeCreateRequest.getVersionCode());
    zzb.zzc(paramParcel, 2, paramDataTypeCreateRequest.getFields(), false);
    zzb.zza(paramParcel, 3, paramDataTypeCreateRequest.zzui(), false);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public DataTypeCreateRequest zzdj(Parcel paramParcel)
  {
    IBinder localIBinder = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    ArrayList localArrayList = null;
    String str = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        str = zza.zzp(paramParcel, k);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        localArrayList = zza.zzc(paramParcel, k, Field.CREATOR);
        break;
      case 3: 
        localIBinder = zza.zzq(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new DataTypeCreateRequest(i, str, localArrayList, localIBinder);
  }
  
  public DataTypeCreateRequest[] zzfj(int paramInt)
  {
    return new DataTypeCreateRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */