package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzpk;
import com.google.android.gms.internal.zzpk.zza;

public class ListSubscriptionsRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ListSubscriptionsRequest> CREATOR = new zzp();
  private final int mVersionCode;
  private final DataType zzatO;
  private final zzpk zzayJ;
  
  ListSubscriptionsRequest(int paramInt, DataType paramDataType, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzatO = paramDataType;
    this.zzayJ = zzpk.zza.zzbM(paramIBinder);
  }
  
  public ListSubscriptionsRequest(DataType paramDataType, zzpk paramzzpk)
  {
    this.mVersionCode = 3;
    this.zzatO = paramDataType;
    this.zzayJ = paramzzpk;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DataType getDataType()
  {
    return this.zzatO;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzp.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzui()
  {
    if (this.zzayJ == null) {
      return null;
    }
    return this.zzayJ.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/ListSubscriptionsRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */