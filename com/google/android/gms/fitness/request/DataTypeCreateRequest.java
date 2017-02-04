package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.zzpc;
import com.google.android.gms.internal.zzpc.zza;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTypeCreateRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataTypeCreateRequest> CREATOR = new zzi();
  private final String mName;
  private final int mVersionCode;
  private final List<Field> zzauz;
  private final zzpc zzayG;
  
  DataTypeCreateRequest(int paramInt, String paramString, List<Field> paramList, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.mName = paramString;
    this.zzauz = Collections.unmodifiableList(paramList);
    this.zzayG = zzpc.zza.zzbE(paramIBinder);
  }
  
  private DataTypeCreateRequest(Builder paramBuilder)
  {
    this(Builder.zza(paramBuilder), Builder.zzb(paramBuilder), null);
  }
  
  public DataTypeCreateRequest(DataTypeCreateRequest paramDataTypeCreateRequest, zzpc paramzzpc)
  {
    this(paramDataTypeCreateRequest.mName, paramDataTypeCreateRequest.zzauz, paramzzpc);
  }
  
  public DataTypeCreateRequest(String paramString, List<Field> paramList, zzpc paramzzpc)
  {
    this.mVersionCode = 3;
    this.mName = paramString;
    this.zzauz = Collections.unmodifiableList(paramList);
    this.zzayG = paramzzpc;
  }
  
  private boolean zzb(DataTypeCreateRequest paramDataTypeCreateRequest)
  {
    return (zzw.equal(this.mName, paramDataTypeCreateRequest.mName)) && (zzw.equal(this.zzauz, paramDataTypeCreateRequest.zzauz));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof DataTypeCreateRequest)) && (zzb((DataTypeCreateRequest)paramObject)));
  }
  
  public List<Field> getFields()
  {
    return this.zzauz;
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
    return zzw.hashCode(new Object[] { this.mName, this.zzauz });
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("name", this.mName).zzg("fields", this.zzauz).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
  
  public IBinder zzui()
  {
    if (this.zzayG == null) {
      return null;
    }
    return this.zzayG.asBinder();
  }
  
  public static class Builder
  {
    private String mName;
    private List<Field> zzauz = new ArrayList();
    
    public Builder addField(Field paramField)
    {
      if (!this.zzauz.contains(paramField)) {
        this.zzauz.add(paramField);
      }
      return this;
    }
    
    public Builder addField(String paramString, int paramInt)
    {
      if ((paramString != null) && (!paramString.isEmpty())) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Invalid name specified");
        return addField(Field.zzn(paramString, paramInt));
      }
    }
    
    public DataTypeCreateRequest build()
    {
      boolean bool2 = true;
      if (this.mName != null)
      {
        bool1 = true;
        zzx.zza(bool1, "Must set the name");
        if (this.zzauz.isEmpty()) {
          break label52;
        }
      }
      label52:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zza(bool1, "Must specify the data fields");
        return new DataTypeCreateRequest(this, null);
        bool1 = false;
        break;
      }
    }
    
    public Builder setName(String paramString)
    {
      this.mName = paramString;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/request/DataTypeCreateRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */