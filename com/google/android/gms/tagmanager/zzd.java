package com.google.android.gms.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.Map;

class zzd
  implements DataLayer.zzb
{
  private final Context context;
  
  public zzd(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public void zzJ(Map<String, Object> paramMap)
  {
    Object localObject = paramMap.get("gtm.url");
    if (localObject == null)
    {
      paramMap = paramMap.get("gtm");
      if ((paramMap == null) || (!(paramMap instanceof Map))) {}
    }
    for (paramMap = ((Map)paramMap).get("url");; paramMap = (Map<String, Object>)localObject)
    {
      if ((paramMap == null) || (!(paramMap instanceof String))) {}
      do
      {
        return;
        paramMap = Uri.parse((String)paramMap).getQueryParameter("referrer");
      } while (paramMap == null);
      zzax.zzm(this.context, paramMap);
      return;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */