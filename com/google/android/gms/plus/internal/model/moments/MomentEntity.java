package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class MomentEntity
  extends FastSafeParcelableJsonResponse
  implements Moment
{
  public static final zzb CREATOR = new zzb();
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap();
  final int mVersionCode;
  String zzIx;
  final Set<Integer> zzaZA;
  String zzban;
  ItemScopeEntity zzbav;
  ItemScopeEntity zzbaw;
  String zzxX;
  
  static
  {
    zzaZz.put("id", FastJsonResponse.Field.zzl("id", 2));
    zzaZz.put("result", FastJsonResponse.Field.zza("result", 4, ItemScopeEntity.class));
    zzaZz.put("startDate", FastJsonResponse.Field.zzl("startDate", 5));
    zzaZz.put("target", FastJsonResponse.Field.zza("target", 6, ItemScopeEntity.class));
    zzaZz.put("type", FastJsonResponse.Field.zzl("type", 7));
  }
  
  public MomentEntity()
  {
    this.mVersionCode = 1;
    this.zzaZA = new HashSet();
  }
  
  MomentEntity(Set<Integer> paramSet, int paramInt, String paramString1, ItemScopeEntity paramItemScopeEntity1, String paramString2, ItemScopeEntity paramItemScopeEntity2, String paramString3)
  {
    this.zzaZA = paramSet;
    this.mVersionCode = paramInt;
    this.zzxX = paramString1;
    this.zzbav = paramItemScopeEntity1;
    this.zzban = paramString2;
    this.zzbaw = paramItemScopeEntity2;
    this.zzIx = paramString3;
  }
  
  public MomentEntity(Set<Integer> paramSet, String paramString1, ItemScopeEntity paramItemScopeEntity1, String paramString2, ItemScopeEntity paramItemScopeEntity2, String paramString3)
  {
    this.zzaZA = paramSet;
    this.mVersionCode = 1;
    this.zzxX = paramString1;
    this.zzbav = paramItemScopeEntity1;
    this.zzban = paramString2;
    this.zzbaw = paramItemScopeEntity2;
    this.zzIx = paramString3;
  }
  
  public int describeContents()
  {
    zzb localzzb = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof MomentEntity)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (MomentEntity)paramObject;
    Iterator localIterator = zzaZz.values().iterator();
    while (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (zza(localField))
      {
        if (((MomentEntity)paramObject).zza(localField))
        {
          if (!zzb(localField).equals(((MomentEntity)paramObject).zzb(localField))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (((MomentEntity)paramObject).zza(localField)) {
        return false;
      }
    }
    return true;
  }
  
  public String getId()
  {
    return this.zzxX;
  }
  
  public ItemScope getResult()
  {
    return this.zzbav;
  }
  
  public String getStartDate()
  {
    return this.zzban;
  }
  
  public ItemScope getTarget()
  {
    return this.zzbaw;
  }
  
  public String getType()
  {
    return this.zzIx;
  }
  
  public boolean hasId()
  {
    return this.zzaZA.contains(Integer.valueOf(2));
  }
  
  public boolean hasResult()
  {
    return this.zzaZA.contains(Integer.valueOf(4));
  }
  
  public boolean hasStartDate()
  {
    return this.zzaZA.contains(Integer.valueOf(5));
  }
  
  public boolean hasTarget()
  {
    return this.zzaZA.contains(Integer.valueOf(6));
  }
  
  public boolean hasType()
  {
    return this.zzaZA.contains(Integer.valueOf(7));
  }
  
  public int hashCode()
  {
    Iterator localIterator = zzaZz.values().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      FastJsonResponse.Field localField = (FastJsonResponse.Field)localIterator.next();
      if (!zza(localField)) {
        break label68;
      }
      int j = localField.zzrc();
      i = zzb(localField).hashCode() + (i + j);
    }
    label68:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb localzzb = CREATOR;
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public HashMap<String, FastJsonResponse.Field<?, ?>> zzDq()
  {
    return zzaZz;
  }
  
  public MomentEntity zzDs()
  {
    return this;
  }
  
  protected boolean zza(FastJsonResponse.Field paramField)
  {
    return this.zzaZA.contains(Integer.valueOf(paramField.zzrc()));
  }
  
  protected Object zzb(FastJsonResponse.Field paramField)
  {
    switch (paramField.zzrc())
    {
    case 3: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + paramField.zzrc());
    case 2: 
      return this.zzxX;
    case 4: 
      return this.zzbav;
    case 5: 
      return this.zzban;
    case 6: 
      return this.zzbaw;
    }
    return this.zzIx;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/plus/internal/model/moments/MomentEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */