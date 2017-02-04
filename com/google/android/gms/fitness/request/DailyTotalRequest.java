package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zzoz;
import com.google.android.gms.internal.zzoz.zza;

public class DailyTotalRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DailyTotalRequest> CREATOR = new zzc();
  private final int mVersionCode;
  private DataType zzatO;
  private final zzoz zzayk;
  
  DailyTotalRequest(int paramInt, IBinder paramIBinder, DataType paramDataType)
  {
    this.mVersionCode = paramInt;
    this.zzayk = zzoz.zza.zzbB(paramIBinder);
    this.zzatO = paramDataType;
  }
  
  public DailyTotalRequest(zzoz paramzzoz, DataType paramDataType)
  {
    this.mVersionCode = 2;
    this.zzayk = paramzzoz;
    this.zzatO = paramDataType;
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
  
  public String toString()
  {
    return String.format("DailyTotalRequest{%s}", new Object[] { this.zzatO.zztM() });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzui()
  {
    return this.zzayk.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/DailyTotalRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */