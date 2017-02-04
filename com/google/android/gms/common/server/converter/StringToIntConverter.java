package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse.zza;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class StringToIntConverter
  implements SafeParcelable, FastJsonResponse.zza<String, Integer>
{
  public static final zzb CREATOR = new zzb();
  private final int mVersionCode;
  private final HashMap<String, Integer> zzakP;
  private final HashMap<Integer, String> zzakQ;
  private final ArrayList<Entry> zzakR;
  
  public StringToIntConverter()
  {
    this.mVersionCode = 1;
    this.zzakP = new HashMap();
    this.zzakQ = new HashMap();
    this.zzakR = null;
  }
  
  StringToIntConverter(int paramInt, ArrayList<Entry> paramArrayList)
  {
    this.mVersionCode = paramInt;
    this.zzakP = new HashMap();
    this.zzakQ = new HashMap();
    this.zzakR = null;
    zzd(paramArrayList);
  }
  
  private void zzd(ArrayList<Entry> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      Entry localEntry = (Entry)paramArrayList.next();
      zzh(localEntry.zzakS, localEntry.zzakT);
    }
  }
  
  public int describeContents()
  {
    zzb localzzb = CREATOR;
    return 0;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb localzzb = CREATOR;
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public String zzb(Integer paramInteger)
  {
    String str = (String)this.zzakQ.get(paramInteger);
    paramInteger = str;
    if (str == null)
    {
      paramInteger = str;
      if (this.zzakP.containsKey("gms_unknown")) {
        paramInteger = "gms_unknown";
      }
    }
    return paramInteger;
  }
  
  public StringToIntConverter zzh(String paramString, int paramInt)
  {
    this.zzakP.put(paramString, Integer.valueOf(paramInt));
    this.zzakQ.put(Integer.valueOf(paramInt), paramString);
    return this;
  }
  
  ArrayList<Entry> zzqS()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzakP.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new Entry(str, ((Integer)this.zzakP.get(str)).intValue()));
    }
    return localArrayList;
  }
  
  public int zzqT()
  {
    return 7;
  }
  
  public int zzqU()
  {
    return 0;
  }
  
  public static final class Entry
    implements SafeParcelable
  {
    public static final zzc CREATOR = new zzc();
    final int versionCode;
    final String zzakS;
    final int zzakT;
    
    Entry(int paramInt1, String paramString, int paramInt2)
    {
      this.versionCode = paramInt1;
      this.zzakS = paramString;
      this.zzakT = paramInt2;
    }
    
    Entry(String paramString, int paramInt)
    {
      this.versionCode = 1;
      this.zzakS = paramString;
      this.zzakT = paramInt;
    }
    
    public int describeContents()
    {
      zzc localzzc = CREATOR;
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzc localzzc = CREATOR;
      zzc.zza(this, paramParcel, paramInt);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/server/converter/StringToIntConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */