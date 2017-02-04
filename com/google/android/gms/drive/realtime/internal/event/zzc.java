package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zza.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc
  implements Parcelable.Creator<ParcelableEvent>
{
  static void zza(ParcelableEvent paramParcelableEvent, Parcel paramParcel, int paramInt)
  {
    int i = zzb.zzav(paramParcel);
    zzb.zzc(paramParcel, 1, paramParcelableEvent.mVersionCode);
    zzb.zza(paramParcel, 2, paramParcelableEvent.zzJX, false);
    zzb.zza(paramParcel, 3, paramParcelableEvent.zzJg, false);
    zzb.zzb(paramParcel, 4, paramParcelableEvent.zzasL, false);
    zzb.zza(paramParcel, 5, paramParcelableEvent.zzasM);
    zzb.zza(paramParcel, 6, paramParcelableEvent.zzasF, false);
    zzb.zza(paramParcel, 7, paramParcelableEvent.zzasP, false);
    zzb.zza(paramParcel, 8, paramParcelableEvent.zzasQ, paramInt, false);
    zzb.zza(paramParcel, 9, paramParcelableEvent.zzasR, paramInt, false);
    zzb.zza(paramParcel, 10, paramParcelableEvent.zzasS, paramInt, false);
    zzb.zza(paramParcel, 11, paramParcelableEvent.zzasT, paramInt, false);
    zzb.zza(paramParcel, 12, paramParcelableEvent.zzasU, paramInt, false);
    zzb.zza(paramParcel, 13, paramParcelableEvent.zzasV, paramInt, false);
    zzb.zza(paramParcel, 14, paramParcelableEvent.zzasW, paramInt, false);
    zzb.zza(paramParcel, 15, paramParcelableEvent.zzasX, paramInt, false);
    zzb.zza(paramParcel, 17, paramParcelableEvent.zzasO);
    zzb.zza(paramParcel, 16, paramParcelableEvent.zzasN);
    zzb.zza(paramParcel, 18, paramParcelableEvent.zzasY, paramInt, false);
    zzb.zzI(paramParcel, i);
  }
  
  public ParcelableEvent zzcA(Parcel paramParcel)
  {
    int j = zza.zzau(paramParcel);
    int i = 0;
    String str4 = null;
    String str3 = null;
    ArrayList localArrayList = null;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    String str2 = null;
    String str1 = null;
    TextInsertedDetails localTextInsertedDetails = null;
    TextDeletedDetails localTextDeletedDetails = null;
    ValuesAddedDetails localValuesAddedDetails = null;
    ValuesRemovedDetails localValuesRemovedDetails = null;
    ValuesSetDetails localValuesSetDetails = null;
    ValueChangedDetails localValueChangedDetails = null;
    ReferenceShiftedDetails localReferenceShiftedDetails = null;
    ObjectChangedDetails localObjectChangedDetails = null;
    FieldChangedDetails localFieldChangedDetails = null;
    while (paramParcel.dataPosition() < j)
    {
      int k = zza.zzat(paramParcel);
      switch (zza.zzcc(k))
      {
      default: 
        zza.zzb(paramParcel, k);
        break;
      case 1: 
        i = zza.zzg(paramParcel, k);
        break;
      case 2: 
        str4 = zza.zzp(paramParcel, k);
        break;
      case 3: 
        str3 = zza.zzp(paramParcel, k);
        break;
      case 4: 
        localArrayList = zza.zzD(paramParcel, k);
        break;
      case 5: 
        bool3 = zza.zzc(paramParcel, k);
        break;
      case 6: 
        str2 = zza.zzp(paramParcel, k);
        break;
      case 7: 
        str1 = zza.zzp(paramParcel, k);
        break;
      case 8: 
        localTextInsertedDetails = (TextInsertedDetails)zza.zza(paramParcel, k, TextInsertedDetails.CREATOR);
        break;
      case 9: 
        localTextDeletedDetails = (TextDeletedDetails)zza.zza(paramParcel, k, TextDeletedDetails.CREATOR);
        break;
      case 10: 
        localValuesAddedDetails = (ValuesAddedDetails)zza.zza(paramParcel, k, ValuesAddedDetails.CREATOR);
        break;
      case 11: 
        localValuesRemovedDetails = (ValuesRemovedDetails)zza.zza(paramParcel, k, ValuesRemovedDetails.CREATOR);
        break;
      case 12: 
        localValuesSetDetails = (ValuesSetDetails)zza.zza(paramParcel, k, ValuesSetDetails.CREATOR);
        break;
      case 13: 
        localValueChangedDetails = (ValueChangedDetails)zza.zza(paramParcel, k, ValueChangedDetails.CREATOR);
        break;
      case 14: 
        localReferenceShiftedDetails = (ReferenceShiftedDetails)zza.zza(paramParcel, k, ReferenceShiftedDetails.CREATOR);
        break;
      case 15: 
        localObjectChangedDetails = (ObjectChangedDetails)zza.zza(paramParcel, k, ObjectChangedDetails.CREATOR);
        break;
      case 17: 
        bool1 = zza.zzc(paramParcel, k);
        break;
      case 16: 
        bool2 = zza.zzc(paramParcel, k);
        break;
      case 18: 
        localFieldChangedDetails = (FieldChangedDetails)zza.zza(paramParcel, k, FieldChangedDetails.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != j) {
      throw new zza.zza("Overread allowed size end=" + j, paramParcel);
    }
    return new ParcelableEvent(i, str4, str3, localArrayList, bool3, bool2, bool1, str2, str1, localTextInsertedDetails, localTextDeletedDetails, localValuesAddedDetails, localValuesRemovedDetails, localValuesSetDetails, localValueChangedDetails, localReferenceShiftedDetails, localObjectChangedDetails, localFieldChangedDetails);
  }
  
  public ParcelableEvent[] zzew(int paramInt)
  {
    return new ParcelableEvent[paramInt];
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */