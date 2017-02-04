package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj
  implements Parcelable.Creator<UsageInfo>
{
  static void zza(UsageInfo paramUsageInfo, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramUsageInfo.zzSY, paramInt, false);
    zzb.zzc(paramParcel, 1000, paramUsageInfo.mVersionCode);
    zzb.zza(paramParcel, 2, paramUsageInfo.zzSZ);
    zzb.zzc(paramParcel, 3, paramUsageInfo.zzTa);
    zzb.zza(paramParcel, 4, paramUsageInfo.zzuU, false);
    zzb.zza(paramParcel, 5, paramUsageInfo.zzTb, paramInt, false);
    zzb.zza(paramParcel, 6, paramUsageInfo.zzTc);
    zzb.zzc(paramParcel, 7, paramUsageInfo.zzTd);
    zzb.zzc(paramParcel, 8, paramUsageInfo.zzTe);
    zzb.zzI(paramParcel, i);
  }
  
  public UsageInfo[] zzat(int paramInt)
  {
    return new UsageInfo[paramInt];
  }
  
  public UsageInfo zzy(Parcel paramParcel)
  {
    DocumentContents localDocumentContents = null;
    int i = 0;
    int n = zza.zzau(paramParcel);
    long l = 0L;
    int j = -1;
    boolean bool = false;
    String str = null;
    int k = 0;
    DocumentId localDocumentId = null;
    int m = 0;
    while (paramParcel.dataPosition() < n)
    {
      int i1 = zza.zzat(paramParcel);
      switch (zza.zzcc(i1))
      {
      default: 
        zza.zzb(paramParcel, i1);
        break;
      case 1: 
        localDocumentId = (DocumentId)zza.zza(paramParcel, i1, DocumentId.CREATOR);
        break;
      case 1000: 
        m = zza.zzg(paramParcel, i1);
        break;
      case 2: 
        l = zza.zzi(paramParcel, i1);
        break;
      case 3: 
        k = zza.zzg(paramParcel, i1);
        break;
      case 4: 
        str = zza.zzp(paramParcel, i1);
        break;
      case 5: 
        localDocumentContents = (DocumentContents)zza.zza(paramParcel, i1, DocumentContents.CREATOR);
        break;
      case 6: 
        bool = zza.zzc(paramParcel, i1);
        break;
      case 7: 
        j = zza.zzg(paramParcel, i1);
        break;
      case 8: 
        i = zza.zzg(paramParcel, i1);
      }
    }
    if (paramParcel.dataPosition() != n) {
      throw new zza.zza("Overread allowed size end=" + n, paramParcel);
    }
    return new UsageInfo(m, localDocumentId, l, k, str, localDocumentContents, bool, j, i);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/appdatasearch/zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */