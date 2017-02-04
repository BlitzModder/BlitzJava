package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FieldMappingDictionary
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  private final int mVersionCode;
  private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zzale;
  private final ArrayList<Entry> zzalf;
  private final String zzalg;
  
  FieldMappingDictionary(int paramInt, ArrayList<Entry> paramArrayList, String paramString)
  {
    this.mVersionCode = paramInt;
    this.zzalf = null;
    this.zzale = zze(paramArrayList);
    this.zzalg = ((String)zzx.zzy(paramString));
    zzri();
  }
  
  public FieldMappingDictionary(Class<? extends FastJsonResponse> paramClass)
  {
    this.mVersionCode = 1;
    this.zzalf = null;
    this.zzale = new HashMap();
    this.zzalg = paramClass.getCanonicalName();
  }
  
  private static HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zze(ArrayList<Entry> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      Entry localEntry = (Entry)paramArrayList.get(i);
      localHashMap.put(localEntry.className, localEntry.zzrm());
      i += 1;
    }
    return localHashMap;
  }
  
  public int describeContents()
  {
    zzc localzzc = CREATOR;
    return 0;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = this.zzale.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localStringBuilder.append((String)localObject).append(":\n");
      localObject = (Map)this.zzale.get(localObject);
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str = (String)localIterator2.next();
        localStringBuilder.append("  ").append(str).append(": ");
        localStringBuilder.append(((Map)localObject).get(str));
      }
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc localzzc = CREATOR;
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public void zza(Class<? extends FastJsonResponse> paramClass, Map<String, FastJsonResponse.Field<?, ?>> paramMap)
  {
    this.zzale.put(paramClass.getCanonicalName(), paramMap);
  }
  
  public boolean zzb(Class<? extends FastJsonResponse> paramClass)
  {
    return this.zzale.containsKey(paramClass.getCanonicalName());
  }
  
  public Map<String, FastJsonResponse.Field<?, ?>> zzcL(String paramString)
  {
    return (Map)this.zzale.get(paramString);
  }
  
  public void zzri()
  {
    Iterator localIterator1 = this.zzale.keySet().iterator();
    while (localIterator1.hasNext())
    {
      Object localObject = (String)localIterator1.next();
      localObject = (Map)this.zzale.get(localObject);
      Iterator localIterator2 = ((Map)localObject).keySet().iterator();
      while (localIterator2.hasNext()) {
        ((FastJsonResponse.Field)((Map)localObject).get((String)localIterator2.next())).zza(this);
      }
    }
  }
  
  public void zzrj()
  {
    Iterator localIterator1 = this.zzale.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      Map localMap = (Map)this.zzale.get(str1);
      HashMap localHashMap = new HashMap();
      Iterator localIterator2 = localMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        localHashMap.put(str2, ((FastJsonResponse.Field)localMap.get(str2)).zzqY());
      }
      this.zzale.put(str1, localHashMap);
    }
  }
  
  ArrayList<Entry> zzrk()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzale.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new Entry(str, (Map)this.zzale.get(str)));
    }
    return localArrayList;
  }
  
  public String zzrl()
  {
    return this.zzalg;
  }
  
  public static class Entry
    implements SafeParcelable
  {
    public static final zzd CREATOR = new zzd();
    final String className;
    final int versionCode;
    final ArrayList<FieldMappingDictionary.FieldMapPair> zzalh;
    
    Entry(int paramInt, String paramString, ArrayList<FieldMappingDictionary.FieldMapPair> paramArrayList)
    {
      this.versionCode = paramInt;
      this.className = paramString;
      this.zzalh = paramArrayList;
    }
    
    Entry(String paramString, Map<String, FastJsonResponse.Field<?, ?>> paramMap)
    {
      this.versionCode = 1;
      this.className = paramString;
      this.zzalh = zzF(paramMap);
    }
    
    private static ArrayList<FieldMappingDictionary.FieldMapPair> zzF(Map<String, FastJsonResponse.Field<?, ?>> paramMap)
    {
      if (paramMap == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList.add(new FieldMappingDictionary.FieldMapPair(str, (FastJsonResponse.Field)paramMap.get(str)));
      }
      return localArrayList;
    }
    
    public int describeContents()
    {
      zzd localzzd = CREATOR;
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzd localzzd = CREATOR;
      zzd.zza(this, paramParcel, paramInt);
    }
    
    HashMap<String, FastJsonResponse.Field<?, ?>> zzrm()
    {
      HashMap localHashMap = new HashMap();
      int j = this.zzalh.size();
      int i = 0;
      while (i < j)
      {
        FieldMappingDictionary.FieldMapPair localFieldMapPair = (FieldMappingDictionary.FieldMapPair)this.zzalh.get(i);
        localHashMap.put(localFieldMapPair.key, localFieldMapPair.zzali);
        i += 1;
      }
      return localHashMap;
    }
  }
  
  public static class FieldMapPair
    implements SafeParcelable
  {
    public static final zzb CREATOR = new zzb();
    final String key;
    final int versionCode;
    final FastJsonResponse.Field<?, ?> zzali;
    
    FieldMapPair(int paramInt, String paramString, FastJsonResponse.Field<?, ?> paramField)
    {
      this.versionCode = paramInt;
      this.key = paramString;
      this.zzali = paramField;
    }
    
    FieldMapPair(String paramString, FastJsonResponse.Field<?, ?> paramField)
    {
      this.versionCode = 1;
      this.key = paramString;
      this.zzali = paramField;
    }
    
    public int describeContents()
    {
      zzb localzzb = CREATOR;
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzb localzzb = CREATOR;
      zzb.zza(this, paramParcel, paramInt);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/server/response/FieldMappingDictionary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */