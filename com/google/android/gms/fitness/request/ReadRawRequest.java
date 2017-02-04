package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzpl;
import com.google.android.gms.internal.zzpl.zza;
import java.util.List;

public class ReadRawRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<ReadRawRequest> CREATOR = new zzq();
  private final int mVersionCode;
  private final zzpl zzayK;
  private final List<DataSourceQueryParams> zzayL;
  private final boolean zzayv;
  private final boolean zzayw;
  
  ReadRawRequest(int paramInt, IBinder paramIBinder, List<DataSourceQueryParams> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mVersionCode = paramInt;
    this.zzayK = zzpl.zza.zzbN(paramIBinder);
    this.zzayL = paramList;
    this.zzayv = paramBoolean1;
    this.zzayw = paramBoolean2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzq.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzui()
  {
    if (this.zzayK != null) {
      return this.zzayK.asBinder();
    }
    return null;
  }
  
  public boolean zzun()
  {
    return this.zzayw;
  }
  
  public boolean zzuo()
  {
    return this.zzayv;
  }
  
  public List<DataSourceQueryParams> zzut()
  {
    return this.zzayL;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/ReadRawRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */