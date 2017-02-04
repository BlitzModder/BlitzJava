package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;

public class zzb
  implements Parcelable.Creator<DocumentContents>
{
  static void zza(DocumentContents paramDocumentContents, Parcel paramParcel, int paramInt)
  {
    int i = com.google.android.gms.common.internal.safeparcel.zzb.zzav(paramParcel);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 1, paramDocumentContents.zzSi, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzc(paramParcel, 1000, paramDocumentContents.mVersionCode);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 2, paramDocumentContents.zzSj, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 3, paramDocumentContents.zzSk);
    com.google.android.gms.common.internal.safeparcel.zzb.zza(paramParcel, 4, paramDocumentContents.account, paramInt, false);
    com.google.android.gms.common.internal.safeparcel.zzb.zzI(paramParcel, i);
  }
  
  public DocumentContents[] zzai(int paramInt)
  {
    return new DocumentContents[paramInt];
  }
  
  public DocumentContents zzr(Parcel paramParcel)
  {
    boolean bool = false;
    Account localAccount = null;
    int j = zza.zzau(paramParcel);
    String str = null;
    DocumentSection[] arrayOfDocumentSection = null;
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        arrayOfDocumentSection = (DocumentSection[])zza.zzb(paramParcel, k, DocumentSection.CREATOR);
        break;
      case 1000: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        str = zza.zzp(paramParcel, k);
        break;
      case 3: 
        bool = zza.zzc(paramParcel, k);
        break;
      case 4: 
        localAccount = (Account)zza.zza(paramParcel, k, Account.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new DocumentContents(i, arrayOfDocumentSection, str, bool, localAccount);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/appdatasearch/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */