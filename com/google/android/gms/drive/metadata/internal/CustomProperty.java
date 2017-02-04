package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

public class CustomProperty
  implements SafeParcelable
{
  public static final Parcelable.Creator<CustomProperty> CREATOR = new zzc();
  final String mValue;
  final int mVersionCode;
  final CustomPropertyKey zzaqI;
  
  CustomProperty(int paramInt, CustomPropertyKey paramCustomPropertyKey, String paramString)
  {
    this.mVersionCode = paramInt;
    zzx.zzb(paramCustomPropertyKey, "key");
    this.zzaqI = paramCustomPropertyKey;
    this.mValue = paramString;
  }
  
  public CustomProperty(CustomPropertyKey paramCustomPropertyKey, String paramString)
  {
    this(1, paramCustomPropertyKey, paramString);
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
      if ((paramObject == null) || (paramObject.getClass() != getClass())) {
        return false;
      }
      paramObject = (CustomProperty)paramObject;
    } while ((zzw.equal(this.zzaqI, ((CustomProperty)paramObject).zzaqI)) && (zzw.equal(this.mValue, ((CustomProperty)paramObject).mValue)));
    return false;
  }
  
  public String getValue()
  {
    return this.mValue;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaqI, this.mValue });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public CustomPropertyKey zztc()
  {
    return this.zzaqI;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/CustomProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */