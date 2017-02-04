package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ParcelableEvent
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableEvent> CREATOR = new zzc();
  final int mVersionCode;
  final String zzJX;
  final String zzJg;
  final String zzasF;
  final List<String> zzasL;
  final boolean zzasM;
  final boolean zzasN;
  final boolean zzasO;
  final String zzasP;
  final TextInsertedDetails zzasQ;
  final TextDeletedDetails zzasR;
  final ValuesAddedDetails zzasS;
  final ValuesRemovedDetails zzasT;
  final ValuesSetDetails zzasU;
  final ValueChangedDetails zzasV;
  final ReferenceShiftedDetails zzasW;
  final ObjectChangedDetails zzasX;
  final FieldChangedDetails zzasY;
  
  ParcelableEvent(int paramInt, String paramString1, String paramString2, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3, String paramString4, TextInsertedDetails paramTextInsertedDetails, TextDeletedDetails paramTextDeletedDetails, ValuesAddedDetails paramValuesAddedDetails, ValuesRemovedDetails paramValuesRemovedDetails, ValuesSetDetails paramValuesSetDetails, ValueChangedDetails paramValueChangedDetails, ReferenceShiftedDetails paramReferenceShiftedDetails, ObjectChangedDetails paramObjectChangedDetails, FieldChangedDetails paramFieldChangedDetails)
  {
    this.mVersionCode = paramInt;
    this.zzJX = paramString1;
    this.zzJg = paramString2;
    this.zzasL = paramList;
    this.zzasM = paramBoolean1;
    this.zzasN = paramBoolean2;
    this.zzasO = paramBoolean3;
    this.zzasF = paramString3;
    this.zzasP = paramString4;
    this.zzasQ = paramTextInsertedDetails;
    this.zzasR = paramTextDeletedDetails;
    this.zzasS = paramValuesAddedDetails;
    this.zzasT = paramValuesRemovedDetails;
    this.zzasU = paramValuesSetDetails;
    this.zzasV = paramValueChangedDetails;
    this.zzasW = paramReferenceShiftedDetails;
    this.zzasX = paramObjectChangedDetails;
    this.zzasY = paramFieldChangedDetails;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/realtime/internal/event/ParcelableEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */