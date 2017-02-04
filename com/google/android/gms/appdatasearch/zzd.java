package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd
  implements Parcelable.Creator<DocumentSection>
{
  static void zza(DocumentSection paramDocumentSection, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zza(paramParcel, 1, paramDocumentSection.zzSu, false);
    zzb.zzc(paramParcel, 1000, paramDocumentSection.mVersionCode);
    zzb.zza(paramParcel, 3, paramDocumentSection.zzSv, paramInt, false);
    zzb.zzc(paramParcel, 4, paramDocumentSection.zzSw);
    zzb.zza(paramParcel, 5, paramDocumentSection.zzSx, false);
    zzb.zzI(paramParcel, i);
  }
  
  public DocumentSection[] zzak(int paramInt)
  {
    return new DocumentSection[paramInt];
  }
  
  public DocumentSection zzt(Parcel paramParcel)
  {
    byte[] arrayOfByte = null;
    int k = zza.zzau(paramParcel);
    int j = 0;
    int i = -1;
    RegisterSectionInfo localRegisterSectionInfo = null;
    String str = null;
    while (paramParcel.dataPosition() < k)
    {
      int m = zza.zzat(paramParcel);
      switch (zza.zzcc(m))
      {
      default: 
        zza.zzb(paramParcel, m);
        break;
      case 1: 
        str = zza.zzp(paramParcel, m);
        break;
      case 1000: 
        j = zza.zzg(paramParcel, m);
        break;
      case 3: 
        localRegisterSectionInfo = (RegisterSectionInfo)zza.zza(paramParcel, m, RegisterSectionInfo.CREATOR);
        break;
      case 4: 
        i = zza.zzg(paramParcel, m);
        break;
      case 5: 
        arrayOfByte = zza.zzs(paramParcel, m);
      }
    }
    if (paramParcel.dataPosition() != k) {
      throw new zza.zza("Overread allowed size end=" + k, paramParcel);
    }
    return new DocumentSection(j, str, localRegisterSectionInfo, i, arrayOfByte);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/appdatasearch/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */