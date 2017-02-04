package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.zzb;

public class AmsEntityUpdateParcelable
  implements SafeParcelable, zzb
{
  public static final Parcelable.Creator<AmsEntityUpdateParcelable> CREATOR = new zzf();
  private final String mValue;
  final int mVersionCode;
  private byte zzbmA;
  private final byte zzbmB;
  
  AmsEntityUpdateParcelable(int paramInt, byte paramByte1, byte paramByte2, String paramString)
  {
    this.zzbmA = paramByte1;
    this.mVersionCode = paramInt;
    this.zzbmB = paramByte2;
    this.mValue = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (AmsEntityUpdateParcelable)paramObject;
      if (this.zzbmA != ((AmsEntityUpdateParcelable)paramObject).zzbmA) {
        return false;
      }
      if (this.mVersionCode != ((AmsEntityUpdateParcelable)paramObject).mVersionCode) {
        return false;
      }
      if (this.zzbmB != ((AmsEntityUpdateParcelable)paramObject).zzbmB) {
        return false;
      }
    } while (this.mValue.equals(((AmsEntityUpdateParcelable)paramObject).mValue));
    return false;
  }
  
  public String getValue()
  {
    return this.mValue;
  }
  
  public int hashCode()
  {
    return ((this.mVersionCode * 31 + this.zzbmA) * 31 + this.zzbmB) * 31 + this.mValue.hashCode();
  }
  
  public String toString()
  {
    return "AmsEntityUpdateParcelable{mVersionCode=" + this.mVersionCode + ", mEntityId=" + this.zzbmA + ", mAttributeId=" + this.zzbmB + ", mValue='" + this.mValue + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public byte zzGC()
  {
    return this.zzbmA;
  }
  
  public byte zzGD()
  {
    return this.zzbmB;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/AmsEntityUpdateParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */