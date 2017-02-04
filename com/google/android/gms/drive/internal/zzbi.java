package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbi
  implements Parcelable.Creator<OnStartStreamSession>
{
  static void zza(OnStartStreamSession paramOnStartStreamSession, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramOnStartStreamSession.mVersionCode);
    zzb.zza(paramParcel, 2, paramOnStartStreamSession.zzaqr, paramInt, false);
    zzb.zza(paramParcel, 3, paramOnStartStreamSession.zzaqs, false);
    zzb.zza(paramParcel, 4, paramOnStartStreamSession.zzsL, false);
    zzb.zzI(paramParcel, i);
  }
  
  public OnStartStreamSession zzbI(Parcel paramParcel)
  {
    String str = null;
    int j = zza.zzau(paramParcel);
    int i = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      Object localObject3;
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
      for (;;)
      {
        localObject3 = localObject2;
        localObject2 = localObject1;
        localObject1 = localObject3;
        break;
        i = zza.zzg(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (ParcelFileDescriptor)zza.zza(paramParcel, k, ParcelFileDescriptor.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = zza.zzq(paramParcel, k);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        str = zza.zzp(paramParcel, k);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new OnStartStreamSession(i, (ParcelFileDescriptor)localObject1, (IBinder)localObject2, str);
  }
  
  public OnStartStreamSession[] zzdD(int paramInt)
  {
    return new OnStartStreamSession[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */