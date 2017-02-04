package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.internal.zzok;
import java.util.Collections;
import java.util.List;

public class BleDevice
  implements SafeParcelable
{
  public static final Parcelable.Creator<BleDevice> CREATOR = new zzb();
  private final String mName;
  private final int mVersionCode;
  private final String zzatX;
  private final List<String> zzatY;
  private final List<DataType> zzatZ;
  
  BleDevice(int paramInt, String paramString1, String paramString2, List<String> paramList, List<DataType> paramList1)
  {
    this.mVersionCode = paramInt;
    this.zzatX = paramString1;
    this.mName = paramString2;
    this.zzatY = Collections.unmodifiableList(paramList);
    this.zzatZ = Collections.unmodifiableList(paramList1);
  }
  
  private boolean zza(BleDevice paramBleDevice)
  {
    return (this.mName.equals(paramBleDevice.mName)) && (this.zzatX.equals(paramBleDevice.zzatX)) && (zzok.zza(paramBleDevice.zzatY, this.zzatY)) && (zzok.zza(this.zzatZ, paramBleDevice.zzatZ));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof BleDevice)) && (zza((BleDevice)paramObject)));
  }
  
  public String getAddress()
  {
    return this.zzatX;
  }
  
  public List<DataType> getDataTypes()
  {
    return this.zzatZ;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public List<String> getSupportedProfiles()
  {
    return this.zzatY;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.mName, this.zzatX, this.zzatY, this.zzatZ });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("name", this.mName).zzg("address", this.zzatX).zzg("dataTypes", this.zzatZ).zzg("supportedProfiles", this.zzatY).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/BleDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */