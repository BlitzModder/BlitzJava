package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbf
  implements Parcelable.Creator<LargeAssetQueueEntryParcelable>
{
  static void zza(LargeAssetQueueEntryParcelable paramLargeAssetQueueEntryParcelable, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramLargeAssetQueueEntryParcelable.mVersionCode);
    zzb.zza(paramParcel, 2, paramLargeAssetQueueEntryParcelable.zzGQ());
    zzb.zzc(paramParcel, 3, paramLargeAssetQueueEntryParcelable.getState());
    zzb.zza(paramParcel, 4, paramLargeAssetQueueEntryParcelable.getPath(), false);
    zzb.zza(paramParcel, 5, paramLargeAssetQueueEntryParcelable.getNodeId(), false);
    zzb.zza(paramParcel, 6, paramLargeAssetQueueEntryParcelable.zzCO(), paramInt, false);
    zzb.zzc(paramParcel, 8, paramLargeAssetQueueEntryParcelable.zzGU());
    zzb.zza(paramParcel, 9, paramLargeAssetQueueEntryParcelable.zzGR());
    zzb.zza(paramParcel, 10, paramLargeAssetQueueEntryParcelable.zzGS());
    zzb.zza(paramParcel, 11, paramLargeAssetQueueEntryParcelable.zzGT());
    zzb.zzI(paramParcel, i);
  }
  
  public LargeAssetQueueEntryParcelable zziq(Parcel paramParcel)
  {
    Uri localUri = null;
    boolean bool1 = false;
    int m = zza.zzau(paramParcel);
    long l = 0L;
    boolean bool2 = false;
    boolean bool3 = false;
    int i = 0;
    String str1 = null;
    String str2 = null;
    int j = 0;
    int k = 0;
    while (paramParcel.dataPosition() < m)
    {
      int n = zza.zzat(paramParcel);
      switch (zza.zzcc(n))
      {
      case 7: 
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
        j = zza.zzg(paramParcel, n);
        break;
      case 4: 
        str2 = zza.zzp(paramParcel, n);
        break;
      case 5: 
        str1 = zza.zzp(paramParcel, n);
        break;
      case 6: 
        localUri = (Uri)zza.zza(paramParcel, n, Uri.CREATOR);
        break;
      case 8: 
        i = zza.zzg(paramParcel, n);
        break;
      case 9: 
        bool3 = zza.zzc(paramParcel, n);
        break;
      case 10: 
        bool2 = zza.zzc(paramParcel, n);
        break;
      case 11: 
        bool1 = zza.zzc(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != m) {
      throw new zza.zza("Overread allowed size end=" + m, paramParcel);
    }
    return new LargeAssetQueueEntryParcelable(k, l, j, str2, str1, localUri, i, bool3, bool2, bool1);
  }
  
  public LargeAssetQueueEntryParcelable[] zzlR(int paramInt)
  {
    return new LargeAssetQueueEntryParcelable[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzbf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */