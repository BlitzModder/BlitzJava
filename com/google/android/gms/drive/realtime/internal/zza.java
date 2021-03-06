package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza
  implements Parcelable.Creator<BeginCompoundOperationRequest>
{
  static void zza(BeginCompoundOperationRequest paramBeginCompoundOperationRequest, Parcel paramParcel, int paramInt)
  {
    paramInt = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramBeginCompoundOperationRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramBeginCompoundOperationRequest.zzasA);
    zzb.zza(paramParcel, 3, paramBeginCompoundOperationRequest.mName, false);
    zzb.zza(paramParcel, 4, paramBeginCompoundOperationRequest.zzasB);
    zzb.zzI(paramParcel, paramInt);
  }
  
  public BeginCompoundOperationRequest zzct(Parcel paramParcel)
  {
    boolean bool1 = false;
    int j = com.google.android.gms.common.internal.safeparcel.zza.zzau(paramParcel);
    String str = null;
    boolean bool2 = true;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = com.google.android.gms.common.internal.safeparcel.zza.zzat(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.zza.zzcc(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = com.google.android.gms.common.internal.safeparcel.zza.zzg(paramParcel, k);
        break;
      case 2: 
        bool1 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, k);
        break;
      case 3: 
        str = com.google.android.gms.common.internal.safeparcel.zza.zzp(paramParcel, k);
        break;
      case 4: 
        bool2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new BeginCompoundOperationRequest(i, bool1, str, bool2);
  }
  
  public BeginCompoundOperationRequest[] zzeo(int paramInt)
  {
    return new BeginCompoundOperationRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */