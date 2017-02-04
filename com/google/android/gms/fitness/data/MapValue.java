package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public class MapValue
  implements SafeParcelable
{
  public static final Parcelable.Creator<MapValue> CREATOR = new zzl();
  private final int mVersionCode;
  private final int zzauR;
  private final float zzauV;
  
  public MapValue(int paramInt, float paramFloat)
  {
    this(1, paramInt, paramFloat);
  }
  
  MapValue(int paramInt1, int paramInt2, float paramFloat)
  {
    this.mVersionCode = paramInt1;
    this.zzauR = paramInt2;
    this.zzauV = paramFloat;
  }
  
  private boolean zza(MapValue paramMapValue)
  {
    if (this.zzauR == paramMapValue.zzauR)
    {
      switch (this.zzauR)
      {
      default: 
        if (this.zzauV != paramMapValue.zzauV) {
          break;
        }
      case 2: 
        do
        {
          return true;
        } while (asFloat() == paramMapValue.asFloat());
        return false;
      }
      return false;
    }
    return false;
  }
  
  public static MapValue zzc(float paramFloat)
  {
    return new MapValue(2, paramFloat);
  }
  
  public float asFloat()
  {
    if (this.zzauR == 2) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Value is not in float format");
      return this.zzauV;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof MapValue)) && (zza((MapValue)paramObject)));
  }
  
  int getFormat()
  {
    return this.zzauR;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return (int)this.zzauV;
  }
  
  public String toString()
  {
    switch (this.zzauR)
    {
    default: 
      return "unknown";
    }
    return Float.toString(asFloat());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl.zza(this, paramParcel, paramInt);
  }
  
  float zztR()
  {
    return this.zzauV;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/MapValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */