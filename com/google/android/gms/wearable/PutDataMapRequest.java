package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.zzsy;
import com.google.android.gms.internal.zzsy.zza;
import com.google.android.gms.internal.zztk;
import java.util.List;

public class PutDataMapRequest
{
  private final DataMap zzblU;
  private final PutDataRequest zzblV;
  
  private PutDataMapRequest(PutDataRequest paramPutDataRequest, DataMap paramDataMap)
  {
    this.zzblV = paramPutDataRequest;
    this.zzblU = new DataMap();
    if (paramDataMap != null) {
      this.zzblU.putAll(paramDataMap);
    }
  }
  
  public static PutDataMapRequest create(String paramString)
  {
    return new PutDataMapRequest(PutDataRequest.create(paramString), null);
  }
  
  public static PutDataMapRequest createFromDataMapItem(DataMapItem paramDataMapItem)
  {
    return new PutDataMapRequest(PutDataRequest.zzr(paramDataMapItem.getUri()), paramDataMapItem.getDataMap());
  }
  
  public static PutDataMapRequest createWithAutoAppendedId(String paramString)
  {
    return new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(paramString), null);
  }
  
  public PutDataRequest asPutDataRequest()
  {
    zzsy.zza localzza = zzsy.zza(this.zzblU);
    this.zzblV.setData(zztk.toByteArray(localzza.zzbpf));
    int j = localzza.zzbpg.size();
    int i = 0;
    while (i < j)
    {
      String str = Integer.toString(i);
      Asset localAsset = (Asset)localzza.zzbpg.get(i);
      if (str == null) {
        throw new IllegalStateException("asset key cannot be null: " + localAsset);
      }
      if (localAsset == null) {
        throw new IllegalStateException("asset cannot be null: key=" + str);
      }
      if (Log.isLoggable("DataMap", 3)) {
        Log.d("DataMap", "asPutDataRequest: adding asset: " + str + " " + localAsset);
      }
      this.zzblV.putAsset(str, localAsset);
      i += 1;
    }
    return this.zzblV;
  }
  
  public DataMap getDataMap()
  {
    return this.zzblU;
  }
  
  public Uri getUri()
  {
    return this.zzblV.getUri();
  }
  
  public boolean isUrgent()
  {
    return this.zzblV.isUrgent();
  }
  
  public PutDataMapRequest setUrgent()
  {
    this.zzblV.setUrgent();
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/PutDataMapRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */