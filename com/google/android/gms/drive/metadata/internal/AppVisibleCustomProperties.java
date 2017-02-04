package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties
  implements SafeParcelable, Iterable<CustomProperty>
{
  public static final Parcelable.Creator<AppVisibleCustomProperties> CREATOR = new zza();
  public static final AppVisibleCustomProperties zzaqF = new zza().zztb();
  final int mVersionCode;
  final List<CustomProperty> zzaqG;
  
  AppVisibleCustomProperties(int paramInt, Collection<CustomProperty> paramCollection)
  {
    this.mVersionCode = paramInt;
    zzx.zzy(paramCollection);
    this.zzaqG = new ArrayList(paramCollection);
  }
  
  private AppVisibleCustomProperties(Collection<CustomProperty> paramCollection)
  {
    this(1, paramCollection);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {
      return false;
    }
    return zzta().equals(((AppVisibleCustomProperties)paramObject).zzta());
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaqG });
  }
  
  public Iterator<CustomProperty> iterator()
  {
    return this.zzaqG.iterator();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public Map<CustomPropertyKey, String> zzta()
  {
    HashMap localHashMap = new HashMap(this.zzaqG.size());
    Iterator localIterator = this.zzaqG.iterator();
    while (localIterator.hasNext())
    {
      CustomProperty localCustomProperty = (CustomProperty)localIterator.next();
      localHashMap.put(localCustomProperty.zztc(), localCustomProperty.getValue());
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public static class zza
  {
    private final Map<CustomPropertyKey, CustomProperty> zzaqH = new HashMap();
    
    public zza zza(CustomPropertyKey paramCustomPropertyKey, String paramString)
    {
      zzx.zzb(paramCustomPropertyKey, "key");
      this.zzaqH.put(paramCustomPropertyKey, new CustomProperty(paramCustomPropertyKey, paramString));
      return this;
    }
    
    public zza zza(CustomProperty paramCustomProperty)
    {
      zzx.zzb(paramCustomProperty, "property");
      this.zzaqH.put(paramCustomProperty.zztc(), paramCustomProperty);
      return this;
    }
    
    public AppVisibleCustomProperties zztb()
    {
      return new AppVisibleCustomProperties(this.zzaqH.values(), null);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/AppVisibleCustomProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */