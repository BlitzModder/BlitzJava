package net.wargaming.wot.util;

import org.json.JSONException;
import org.json.JSONObject;

public class SkuDetails
{
  String mItemType = "inapp";
  String mJson;
  String mSku;
  
  public SkuDetails(String paramString)
    throws JSONException
  {
    this.mJson = paramString;
    this.mSku = new JSONObject(this.mJson).optString("productId");
  }
  
  public String getJson()
  {
    return this.mJson;
  }
  
  public String getSku()
  {
    return this.mSku;
  }
  
  public String toString()
  {
    return "SkuDetails:" + this.mJson;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/net/wargaming/wot/util/SkuDetails.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */