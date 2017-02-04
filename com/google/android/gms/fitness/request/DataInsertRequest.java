package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.internal.zzpp;
import com.google.android.gms.internal.zzpp.zza;

public class DataInsertRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataInsertRequest> CREATOR = new zze();
  private final int mVersionCode;
  private final DataSet zzave;
  private final zzpp zzayj;
  private final boolean zzayp;
  
  DataInsertRequest(int paramInt, DataSet paramDataSet, IBinder paramIBinder, boolean paramBoolean)
  {
    this.mVersionCode = paramInt;
    this.zzave = paramDataSet;
    this.zzayj = zzpp.zza.zzbR(paramIBinder);
    this.zzayp = paramBoolean;
  }
  
  public DataInsertRequest(DataSet paramDataSet, zzpp paramzzpp, boolean paramBoolean)
  {
    this.mVersionCode = 4;
    this.zzave = paramDataSet;
    this.zzayj = paramzzpp;
    this.zzayp = paramBoolean;
  }
  
  private boolean zzc(DataInsertRequest paramDataInsertRequest)
  {
    return zzw.equal(this.zzave, paramDataInsertRequest.zzave);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof DataInsertRequest)) && (zzc((DataInsertRequest)paramObject)));
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzave });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("dataSet", this.zzave).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
  
  public DataSet zztT()
  {
    return this.zzave;
  }
  
  public IBinder zzui()
  {
    if (this.zzayj == null) {
      return null;
    }
    return this.zzayj.asBinder();
  }
  
  public boolean zzum()
  {
    return this.zzayp;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/DataInsertRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */