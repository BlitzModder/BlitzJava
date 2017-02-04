package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.zznh;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpb.zza;
import java.util.Arrays;
import java.util.List;

public class DataSourcesRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataSourcesRequest> CREATOR = new zzh();
  private final int mVersionCode;
  private final List<DataType> zzatZ;
  private final List<Integer> zzayB;
  private final boolean zzayC;
  private final zzpb zzayD;
  
  DataSourcesRequest(int paramInt, List<DataType> paramList, List<Integer> paramList1, boolean paramBoolean, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzatZ = paramList;
    this.zzayB = paramList1;
    this.zzayC = paramBoolean;
    this.zzayD = zzpb.zza.zzbD(paramIBinder);
  }
  
  private DataSourcesRequest(Builder paramBuilder)
  {
    this(zznh.zzb(Builder.zza(paramBuilder)), Arrays.asList(zznh.zza(Builder.zzb(paramBuilder))), Builder.zzc(paramBuilder), null);
  }
  
  public DataSourcesRequest(DataSourcesRequest paramDataSourcesRequest, zzpb paramzzpb)
  {
    this(paramDataSourcesRequest.zzatZ, paramDataSourcesRequest.zzayB, paramDataSourcesRequest.zzayC, paramzzpb);
  }
  
  public DataSourcesRequest(List<DataType> paramList, List<Integer> paramList1, boolean paramBoolean, zzpb paramzzpb)
  {
    this.mVersionCode = 4;
    this.zzatZ = paramList;
    this.zzayB = paramList1;
    this.zzayC = paramBoolean;
    this.zzayD = paramzzpb;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<DataType> getDataTypes()
  {
    return this.zzatZ;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public String toString()
  {
    zzw.zza localzza = zzw.zzx(this).zzg("dataTypes", this.zzatZ).zzg("sourceTypes", this.zzayB);
    if (this.zzayC) {
      localzza.zzg("includeDbOnlySources", "true");
    }
    return localzza.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzui()
  {
    if (this.zzayD == null) {
      return null;
    }
    return this.zzayD.asBinder();
  }
  
  public List<Integer> zzur()
  {
    return this.zzayB;
  }
  
  public boolean zzus()
  {
    return this.zzayC;
  }
  
  public static class Builder
  {
    private boolean zzayC = false;
    private DataType[] zzayE = new DataType[0];
    private int[] zzayF = { 0, 1 };
    
    public DataSourcesRequest build()
    {
      boolean bool2 = true;
      if (this.zzayE.length > 0)
      {
        bool1 = true;
        zzx.zza(bool1, "Must add at least one data type");
        if (this.zzayF.length <= 0) {
          break label49;
        }
      }
      label49:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zza(bool1, "Must add at least one data source type");
        return new DataSourcesRequest(this, null);
        bool1 = false;
        break;
      }
    }
    
    public Builder setDataSourceTypes(int... paramVarArgs)
    {
      this.zzayF = paramVarArgs;
      return this;
    }
    
    public Builder setDataTypes(DataType... paramVarArgs)
    {
      this.zzayE = paramVarArgs;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/DataSourcesRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */