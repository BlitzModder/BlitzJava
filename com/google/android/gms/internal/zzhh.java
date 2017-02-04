package com.google.android.gms.internal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@zzha
class zzhh
{
  private final String zzDX;
  private String zzF;
  private int zzFt;
  private final List<String> zzIs;
  private final List<String> zzIt;
  private final String zzIu;
  private final String zzIv;
  private final String zzIw;
  private final String zzIx;
  private final boolean zzIy;
  private final boolean zzIz;
  
  public zzhh(int paramInt, Map<String, String> paramMap)
  {
    this.zzF = ((String)paramMap.get("url"));
    this.zzIv = ((String)paramMap.get("base_uri"));
    this.zzIw = ((String)paramMap.get("post_parameters"));
    this.zzIy = parseBoolean((String)paramMap.get("drt_include"));
    this.zzIz = parseBoolean((String)paramMap.get("pan_include"));
    this.zzIu = ((String)paramMap.get("activation_overlay_url"));
    this.zzIt = zzau((String)paramMap.get("check_packages"));
    this.zzDX = ((String)paramMap.get("request_id"));
    this.zzIx = ((String)paramMap.get("type"));
    this.zzIs = zzau((String)paramMap.get("errors"));
    this.zzFt = paramInt;
  }
  
  private static boolean parseBoolean(String paramString)
  {
    return (paramString != null) && ((paramString.equals("1")) || (paramString.equals("true")));
  }
  
  private List<String> zzau(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return Arrays.asList(paramString.split(","));
  }
  
  public int getErrorCode()
  {
    return this.zzFt;
  }
  
  public String getRequestId()
  {
    return this.zzDX;
  }
  
  public String getType()
  {
    return this.zzIx;
  }
  
  public String getUrl()
  {
    return this.zzF;
  }
  
  public void setUrl(String paramString)
  {
    this.zzF = paramString;
  }
  
  public List<String> zzgr()
  {
    return this.zzIs;
  }
  
  public String zzgs()
  {
    return this.zzIw;
  }
  
  public boolean zzgt()
  {
    return this.zzIy;
  }
  
  public boolean zzgu()
  {
    return this.zzIz;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzhh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */