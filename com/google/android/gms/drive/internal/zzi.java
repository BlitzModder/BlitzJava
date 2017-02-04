package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class zzi
  implements Parcelable.Creator<CloseContentsRequest>
{
  static void zza(CloseContentsRequest paramCloseContentsRequest, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramCloseContentsRequest.mVersionCode);
    zzb.zza(paramParcel, 2, paramCloseContentsRequest.zzaoj, paramInt, false);
    zzb.zza(paramParcel, 3, paramCloseContentsRequest.zzaon, false);
    zzb.zzc(paramParcel, 4, paramCloseContentsRequest.zzaol);
    zzb.zzI(paramParcel, i);
  }
  
  public CloseContentsRequest zzbd(Parcel paramParcel)
  {
    Object localObject2 = null;
    int i = 0;
    int k = zza.zzau(paramParcel);
    Object localObject1 = null;
    int j = 0;
    if (paramParcel.dataPosition() < k)
    {
      int m = zza.zzat(paramParcel);
      Object localObject3;
      switch (zza.zzcc(m))
      {
      default: 
        zza.zzb(paramParcel, m);
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
        j = zza.zzg(paramParcel, m);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = (Contents)zza.zza(paramParcel, m, Contents.CREATOR);
        localObject1 = localObject2;
        localObject2 = localObject3;
        continue;
        localObject3 = zza.zzd(paramParcel, m);
        localObject2 = localObject1;
        localObject1 = localObject3;
        continue;
        i = zza.zzg(paramParcel, m);
        localObject3 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new CloseContentsRequest(j, (Contents)localObject1, (Boolean)localObject2, i);
  }
  
  public CloseContentsRequest[] zzcT(int paramInt)
  {
    return new CloseContentsRequest[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */