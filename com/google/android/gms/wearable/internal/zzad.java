package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class zzad
  implements DataItem
{
  private Uri mUri;
  private byte[] zzaHC;
  private Map<String, DataItemAsset> zzbnt;
  
  public zzad(DataItem paramDataItem)
  {
    this.mUri = paramDataItem.getUri();
    this.zzaHC = paramDataItem.getData();
    HashMap localHashMap = new HashMap();
    paramDataItem = paramDataItem.getAssets().entrySet().iterator();
    while (paramDataItem.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramDataItem.next();
      if (localEntry.getKey() != null) {
        localHashMap.put(localEntry.getKey(), ((DataItemAsset)localEntry.getValue()).freeze());
      }
    }
    this.zzbnt = Collections.unmodifiableMap(localHashMap);
  }
  
  public Map<String, DataItemAsset> getAssets()
  {
    return this.zzbnt;
  }
  
  public byte[] getData()
  {
    return this.zzaHC;
  }
  
  public Uri getUri()
  {
    return this.mUri;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public DataItem setData(byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    return toString(Log.isLoggable("DataItem", 3));
  }
  
  public String toString(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder("DataItemEntity{ ");
    localStringBuilder.append("uri=" + this.mUri);
    Object localObject2 = new StringBuilder().append(", dataSz=");
    if (this.zzaHC == null) {}
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(this.zzaHC.length))
    {
      localStringBuilder.append(localObject1);
      localStringBuilder.append(", numAssets=" + this.zzbnt.size());
      if ((!paramBoolean) || (this.zzbnt.isEmpty())) {
        break label251;
      }
      localStringBuilder.append(", assets=[");
      localObject2 = this.zzbnt.entrySet().iterator();
      for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = ", ")
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        localStringBuilder.append((String)localObject1 + (String)localEntry.getKey() + ": " + ((DataItemAsset)localEntry.getValue()).getId());
      }
    }
    localStringBuilder.append("]");
    label251:
    localStringBuilder.append(" }");
    return localStringBuilder.toString();
  }
  
  public DataItem zzGO()
  {
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */