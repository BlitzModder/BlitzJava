package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.util.ArrayMap;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.zzns;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class Value
  implements SafeParcelable
{
  public static final Parcelable.Creator<Value> CREATOR = new zzt();
  private final int mVersionCode;
  private final int zzauR;
  private float zzauV;
  private boolean zzavh;
  private String zzavi;
  private Map<String, MapValue> zzavj;
  private int[] zzavk;
  private float[] zzavl;
  private byte[] zzavm;
  
  public Value(int paramInt)
  {
    this(3, paramInt, false, 0.0F, null, null, null, null, null);
  }
  
  Value(int paramInt1, int paramInt2, boolean paramBoolean, float paramFloat, String paramString, Bundle paramBundle, int[] paramArrayOfInt, float[] paramArrayOfFloat, byte[] paramArrayOfByte)
  {
    this.mVersionCode = paramInt1;
    this.zzauR = paramInt2;
    this.zzavh = paramBoolean;
    this.zzauV = paramFloat;
    this.zzavi = paramString;
    this.zzavj = zzv(paramBundle);
    this.zzavk = paramArrayOfInt;
    this.zzavl = paramArrayOfFloat;
    this.zzavm = paramArrayOfByte;
  }
  
  private boolean zza(Value paramValue)
  {
    if ((this.zzauR == paramValue.zzauR) && (this.zzavh == paramValue.zzavh))
    {
      switch (this.zzauR)
      {
      default: 
        if (this.zzauV != paramValue.zzauV) {
          break;
        }
      case 1: 
      case 2: 
        do
        {
          do
          {
            return true;
          } while (asInt() == paramValue.asInt());
          return false;
        } while (this.zzauV == paramValue.zzauV);
        return false;
      case 3: 
        return zzw.equal(this.zzavi, paramValue.zzavi);
      case 4: 
        return zzw.equal(this.zzavj, paramValue.zzavj);
      case 5: 
        return Arrays.equals(this.zzavk, paramValue.zzavk);
      case 6: 
        return Arrays.equals(this.zzavl, paramValue.zzavl);
      case 7: 
        return Arrays.equals(this.zzavm, paramValue.zzavm);
      }
      return false;
    }
    return false;
  }
  
  private static Map<String, MapValue> zzv(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    paramBundle.setClassLoader(MapValue.class.getClassLoader());
    ArrayMap localArrayMap = new ArrayMap(paramBundle.size());
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayMap.put(str, paramBundle.getParcelable(str));
    }
    return localArrayMap;
  }
  
  public String asActivity()
  {
    return FitnessActivities.getName(asInt());
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
  
  public int asInt()
  {
    boolean bool = true;
    if (this.zzauR == 1) {}
    for (;;)
    {
      zzx.zza(bool, "Value is not in int format");
      return Float.floatToRawIntBits(this.zzauV);
      bool = false;
    }
  }
  
  public String asString()
  {
    if (this.zzauR == 3) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Value is not in string format");
      return this.zzavi;
    }
  }
  
  public void clearKey(String paramString)
  {
    if (this.zzauR == 4) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
      if (this.zzavj != null) {
        this.zzavj.remove(paramString);
      }
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof Value)) && (zza((Value)paramObject)));
  }
  
  public int getFormat()
  {
    return this.zzauR;
  }
  
  public Float getKeyValue(String paramString)
  {
    if (this.zzauR == 4) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Value is not in float map format");
      if ((this.zzavj == null) || (!this.zzavj.containsKey(paramString))) {
        break;
      }
      return Float.valueOf(((MapValue)this.zzavj.get(paramString)).asFloat());
    }
    return null;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Float.valueOf(this.zzauV), this.zzavi, this.zzavj, this.zzavk, this.zzavl, this.zzavm });
  }
  
  public boolean isSet()
  {
    return this.zzavh;
  }
  
  public void setActivity(String paramString)
  {
    setInt(FitnessActivities.zzdd(paramString));
  }
  
  public void setFloat(float paramFloat)
  {
    if (this.zzauR == 2) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
      this.zzavh = true;
      this.zzauV = paramFloat;
      return;
    }
  }
  
  public void setInt(int paramInt)
  {
    if (this.zzauR == 1) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
      this.zzavh = true;
      this.zzauV = Float.intBitsToFloat(paramInt);
      return;
    }
  }
  
  public void setKeyValue(String paramString, float paramFloat)
  {
    if (this.zzauR == 4) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
      this.zzavh = true;
      if (this.zzavj == null) {
        this.zzavj = new HashMap();
      }
      this.zzavj.put(paramString, MapValue.zzc(paramFloat));
      return;
    }
  }
  
  public void setString(String paramString)
  {
    if (this.zzauR == 3) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "Attempting to set a string value to a field that is not in STRING format.  Please check the data type definition and use the right format.");
      this.zzavh = true;
      this.zzavi = paramString;
      return;
    }
  }
  
  public String toString()
  {
    if (!this.zzavh) {
      return "unset";
    }
    switch (this.zzauR)
    {
    default: 
      return "unknown";
    case 1: 
      return Integer.toString(asInt());
    case 2: 
      return Float.toString(this.zzauV);
    case 3: 
      return this.zzavi;
    case 4: 
      return new TreeMap(this.zzavj).toString();
    case 5: 
      return Arrays.toString(this.zzavk);
    case 6: 
      return Arrays.toString(this.zzavl);
    }
    return zzns.zza(this.zzavm, 0, this.zzavm.length, false);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzt.zza(this, paramParcel, paramInt);
  }
  
  float zztR()
  {
    return this.zzauV;
  }
  
  String zztX()
  {
    return this.zzavi;
  }
  
  Bundle zztY()
  {
    if (this.zzavj == null) {
      return null;
    }
    Bundle localBundle = new Bundle(this.zzavj.size());
    Iterator localIterator = this.zzavj.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localBundle.putParcelable((String)localEntry.getKey(), (Parcelable)localEntry.getValue());
    }
    return localBundle;
  }
  
  int[] zztZ()
  {
    return this.zzavk;
  }
  
  float[] zzua()
  {
    return this.zzavl;
  }
  
  byte[] zzub()
  {
    return this.zzavm;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/Value.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */