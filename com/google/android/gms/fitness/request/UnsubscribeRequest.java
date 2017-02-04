package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class UnsubscribeRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<UnsubscribeRequest> CREATOR = new zzae();
  private final int mVersionCode;
  private final DataType zzatO;
  private final DataSource zzatP;
  private final zzpp zzayj;
  
  UnsubscribeRequest(int paramInt, DataType paramDataType, DataSource paramDataSource, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzatO = paramDataType;
    this.zzatP = paramDataSource;
    this.zzayj = zzpp.zza.zzbR(paramIBinder);
  }
  
  public UnsubscribeRequest(DataType paramDataType, DataSource paramDataSource, zzpp paramzzpp)
  {
    this.mVersionCode = 3;
    this.zzatO = paramDataType;
    this.zzatP = paramDataSource;
    this.zzayj = paramzzpp;
  }
  
  private boolean zzb(UnsubscribeRequest paramUnsubscribeRequest)
  {
    return (zzw.equal(this.zzatP, paramUnsubscribeRequest.zzatP)) && (zzw.equal(this.zzatO, paramUnsubscribeRequest.zzatO));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof UnsubscribeRequest)) && (zzb((UnsubscribeRequest)paramObject)));
  }
  
  public DataSource getDataSource()
  {
    return this.zzatP;
  }
  
  public DataType getDataType()
  {
    return this.zzatO;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzatP, this.zzatO });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzae.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzui()
  {
    if (this.zzayj == null) {
      return null;
    }
    return this.zzayj.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/UnsubscribeRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */