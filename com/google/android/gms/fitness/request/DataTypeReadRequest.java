package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.internal.zzpc;
import com.google.android.gms.internal.zzpc.zza;

public class DataTypeReadRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataTypeReadRequest> CREATOR = new zzj();
  private final String mName;
  private final int mVersionCode;
  private final zzpc zzayG;
  
  DataTypeReadRequest(int paramInt, String paramString, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.mName = paramString;
    this.zzayG = zzpc.zza.zzbE(paramIBinder);
  }
  
  public DataTypeReadRequest(String paramString, zzpc paramzzpc)
  {
    this.mVersionCode = 3;
    this.mName = paramString;
    this.zzayG = paramzzpc;
  }
  
  private boolean zzb(DataTypeReadRequest paramDataTypeReadRequest)
  {
    return zzw.equal(this.mName, paramDataTypeReadRequest.mName);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof DataTypeReadRequest)) && (zzb((DataTypeReadRequest)paramObject)));
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.mName });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("name", this.mName).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzj.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzui()
  {
    return this.zzayG.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/DataTypeReadRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */