package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.zzb;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import org.json.JSONArray;
import org.json.JSONException;

public class zzn
  extends zzb<String>
{
  public zzn(String paramString, int paramInt)
  {
    super(paramString, Collections.singleton(paramString), Collections.emptySet(), paramInt);
  }
  
  public static final Collection<String> zzcV(String paramString)
    throws JSONException
  {
    if (paramString == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramString = new JSONArray(paramString);
    int i = 0;
    while (i < paramString.length())
    {
      localArrayList.add(paramString.getString(i));
      i += 1;
    }
    return Collections.unmodifiableCollection(localArrayList);
  }
  
  protected void zza(Bundle paramBundle, Collection<String> paramCollection)
  {
    paramBundle.putStringArrayList(getName(), new ArrayList(paramCollection));
  }
  
  protected Collection<String> zzd(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    try
    {
      paramDataHolder = zzcV(paramDataHolder.zzd(getName(), paramInt1, paramInt2));
      return paramDataHolder;
    }
    catch (JSONException paramDataHolder)
    {
      throw new IllegalStateException("DataHolder supplied invalid JSON", paramDataHolder);
    }
  }
  
  protected Collection<String> zzs(Bundle paramBundle)
  {
    return paramBundle.getStringArrayList(getName());
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/metadata/internal/zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */