package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BleDevicesResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<BleDevicesResult> CREATOR = new zza();
  private final int mVersionCode;
  private final Status zzTA;
  private final List<BleDevice> zzazk;
  
  BleDevicesResult(int paramInt, List<BleDevice> paramList, Status paramStatus)
  {
    this.mVersionCode = paramInt;
    this.zzazk = Collections.unmodifiableList(paramList);
    this.zzTA = paramStatus;
  }
  
  public BleDevicesResult(List<BleDevice> paramList, Status paramStatus)
  {
    this.mVersionCode = 3;
    this.zzazk = Collections.unmodifiableList(paramList);
    this.zzTA = paramStatus;
  }
  
  public static BleDevicesResult zzR(Status paramStatus)
  {
    return new BleDevicesResult(Collections.emptyList(), paramStatus);
  }
  
  private boolean zzb(BleDevicesResult paramBleDevicesResult)
  {
    return (this.zzTA.equals(paramBleDevicesResult.zzTA)) && (zzw.equal(this.zzazk, paramBleDevicesResult.zzazk));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof BleDevicesResult)) && (zzb((BleDevicesResult)paramObject)));
  }
  
  public List<BleDevice> getClaimedBleDevices()
  {
    return this.zzazk;
  }
  
  public List<BleDevice> getClaimedBleDevices(DataType paramDataType)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzazk.iterator();
    while (localIterator.hasNext())
    {
      BleDevice localBleDevice = (BleDevice)localIterator.next();
      if (localBleDevice.getDataTypes().contains(paramDataType)) {
        localArrayList.add(localBleDevice);
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzTA, this.zzazk });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("status", this.zzTA).zzg("bleDevices", this.zzazk).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/result/BleDevicesResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */