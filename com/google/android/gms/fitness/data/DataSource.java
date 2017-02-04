package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.common.internal.zzx;

public class DataSource
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataSource> CREATOR = new zzf();
  public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
  public static final int TYPE_DERIVED = 1;
  public static final int TYPE_RAW = 0;
  private final String mName;
  private final int mVersionCode;
  private final int zzZU;
  private final DataType zzatO;
  private final Device zzaum;
  private final Application zzaun;
  private final String zzauo;
  private final String zzaup;
  
  DataSource(int paramInt1, DataType paramDataType, String paramString1, int paramInt2, Device paramDevice, Application paramApplication, String paramString2)
  {
    this.mVersionCode = paramInt1;
    this.zzatO = paramDataType;
    this.zzZU = paramInt2;
    this.mName = paramString1;
    this.zzaum = paramDevice;
    this.zzaun = paramApplication;
    this.zzauo = paramString2;
    this.zzaup = zztL();
  }
  
  private DataSource(Builder paramBuilder)
  {
    this.mVersionCode = 3;
    this.zzatO = Builder.zza(paramBuilder);
    this.zzZU = Builder.zzb(paramBuilder);
    this.mName = Builder.zzc(paramBuilder);
    this.zzaum = Builder.zzd(paramBuilder);
    this.zzaun = Builder.zze(paramBuilder);
    this.zzauo = Builder.zzf(paramBuilder);
    this.zzaup = zztL();
  }
  
  public static DataSource extract(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return (DataSource)zzc.zza(paramIntent, "vnd.google.fitness.data_source", CREATOR);
  }
  
  private String getTypeString()
  {
    switch (this.zzZU)
    {
    default: 
      throw new IllegalArgumentException("invalid type value");
    case 0: 
      return "raw";
    }
    return "derived";
  }
  
  private boolean zza(DataSource paramDataSource)
  {
    return this.zzaup.equals(paramDataSource.zzaup);
  }
  
  private String zztL()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getTypeString());
    localStringBuilder.append(":").append(this.zzatO.getName());
    if (this.zzaun != null) {
      localStringBuilder.append(":").append(this.zzaun.getPackageName());
    }
    if (this.zzaum != null) {
      localStringBuilder.append(":").append(this.zzaum.getStreamIdentifier());
    }
    if (this.zzauo != null) {
      localStringBuilder.append(":").append(this.zzauo);
    }
    return localStringBuilder.toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof DataSource)) && (zza((DataSource)paramObject)));
  }
  
  public String getAppPackageName()
  {
    if (this.zzaun == null) {
      return null;
    }
    return this.zzaun.getPackageName();
  }
  
  public DataType getDataType()
  {
    return this.zzatO;
  }
  
  public Device getDevice()
  {
    return this.zzaum;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getStreamIdentifier()
  {
    return this.zzaup;
  }
  
  public String getStreamName()
  {
    return this.zzauo;
  }
  
  public int getType()
  {
    return this.zzZU;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return this.zzaup.hashCode();
  }
  
  public String toDebugString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.zzZU == 0)
    {
      str = "r";
      localStringBuilder = localStringBuilder.append(str).append(":").append(this.zzatO.zztM());
      if (this.zzaun != null) {
        break label154;
      }
      str = "";
      label49:
      localStringBuilder = localStringBuilder.append(str);
      if (this.zzaum == null) {
        break label202;
      }
      str = ":" + this.zzaum.getModel() + ":" + this.zzaum.getUid();
      label103:
      localStringBuilder = localStringBuilder.append(str);
      if (this.zzauo == null) {
        break label208;
      }
    }
    label154:
    label202:
    label208:
    for (String str = ":" + this.zzauo;; str = "")
    {
      return str;
      str = "d";
      break;
      if (this.zzaun.equals(Application.zzatV))
      {
        str = ":gms";
        break label49;
      }
      str = ":" + this.zzaun.getPackageName();
      break label49;
      str = "";
      break label103;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("DataSource{");
    localStringBuilder.append(getTypeString());
    if (this.mName != null) {
      localStringBuilder.append(":").append(this.mName);
    }
    if (this.zzaun != null) {
      localStringBuilder.append(":").append(this.zzaun);
    }
    if (this.zzaum != null) {
      localStringBuilder.append(":").append(this.zzaum);
    }
    if (this.zzauo != null) {
      localStringBuilder.append(":").append(this.zzauo);
    }
    localStringBuilder.append(":").append(this.zzatO);
    return "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public Application zztK()
  {
    return this.zzaun;
  }
  
  public static final class Builder
  {
    private String mName;
    private int zzZU = -1;
    private DataType zzatO;
    private Device zzaum;
    private Application zzaun;
    private String zzauo = "";
    
    public DataSource build()
    {
      boolean bool2 = true;
      if (this.zzatO != null)
      {
        bool1 = true;
        zzx.zza(bool1, "Must set data type");
        if (this.zzZU < 0) {
          break label47;
        }
      }
      label47:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        zzx.zza(bool1, "Must set data source type");
        return new DataSource(this, null);
        bool1 = false;
        break;
      }
    }
    
    public Builder setAppPackageName(Context paramContext)
    {
      return setAppPackageName(paramContext.getPackageName());
    }
    
    public Builder setAppPackageName(String paramString)
    {
      this.zzaun = Application.zzde(paramString);
      return this;
    }
    
    public Builder setDataType(DataType paramDataType)
    {
      this.zzatO = paramDataType;
      return this;
    }
    
    public Builder setDevice(Device paramDevice)
    {
      this.zzaum = paramDevice;
      return this;
    }
    
    public Builder setName(String paramString)
    {
      this.mName = paramString;
      return this;
    }
    
    public Builder setStreamName(String paramString)
    {
      if (paramString != null) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "Must specify a valid stream name");
        this.zzauo = paramString;
        return this;
      }
    }
    
    public Builder setType(int paramInt)
    {
      this.zzZU = paramInt;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/DataSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */