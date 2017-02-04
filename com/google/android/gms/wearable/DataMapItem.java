package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.zzsy;
import com.google.android.gms.internal.zzsy.zza;
import com.google.android.gms.internal.zzsz;
import com.google.android.gms.internal.zztj;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataMapItem
{
  private final Uri mUri;
  private final DataMap zzblU;
  
  private DataMapItem(DataItem paramDataItem)
  {
    this.mUri = paramDataItem.getUri();
    this.zzblU = zza((DataItem)paramDataItem.freeze());
  }
  
  public static DataMapItem fromDataItem(DataItem paramDataItem)
  {
    if (paramDataItem == null) {
      throw new IllegalStateException("provided dataItem is null");
    }
    return new DataMapItem(paramDataItem);
  }
  
  private DataMap zza(DataItem paramDataItem)
  {
    if ((paramDataItem.getData() == null) && (paramDataItem.getAssets().size() > 0)) {
      throw new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
    }
    if (paramDataItem.getData() == null) {
      return new DataMap();
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      j = paramDataItem.getAssets().size();
      i = 0;
    }
    catch (zztj localzztj)
    {
      for (;;)
      {
        int j;
        int i;
        DataItemAsset localDataItemAsset;
        Log.w("DataItem", "Unable to parse datamap from dataItem. uri=" + paramDataItem.getUri() + ", data=" + Base64.encodeToString(paramDataItem.getData(), 0));
        throw new IllegalStateException("Unable to parse datamap from dataItem.  uri=" + paramDataItem.getUri(), localzztj);
        localzztj.add(Asset.createFromRef(localDataItemAsset.getId()));
        i += 1;
      }
      DataMap localDataMap = zzsy.zza(new zzsy.zza(zzsz.zzz(paramDataItem.getData()), localzztj));
      return localDataMap;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;) {}
    }
    if (i < j)
    {
      localDataItemAsset = (DataItemAsset)paramDataItem.getAssets().get(Integer.toString(i));
      if (localDataItemAsset == null) {
        throw new IllegalStateException("Cannot find DataItemAsset referenced in data at " + i + " for " + paramDataItem);
      }
    }
  }
  
  public DataMap getDataMap()
  {
    return this.zzblU;
  }
  
  public Uri getUri()
  {
    return this.mUri;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/DataMapItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */