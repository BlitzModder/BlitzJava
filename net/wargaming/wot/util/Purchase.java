package net.wargaming.wot.util;

import org.json.JSONException;
import org.json.JSONObject;

public class Purchase
{
  String mItemType;
  String mOriginalJson;
  String mSignature;
  String mSku;
  String mToken;
  
  public Purchase(String paramString1, String paramString2, String paramString3)
    throws JSONException
  {
    this.mItemType = paramString1;
    this.mOriginalJson = paramString2;
    paramString1 = new JSONObject(this.mOriginalJson);
    this.mSku = paramString1.optString("productId");
    this.mToken = paramString1.optString("token", paramString1.optString("purchaseToken"));
    this.mSignature = paramString3;
  }
  
  public String getItemType()
  {
    return this.mItemType;
  }
  
  public String getOriginalJson()
  {
    return this.mOriginalJson;
  }
  
  public String getSignature()
  {
    return this.mSignature;
  }
  
  public String getSku()
  {
    return this.mSku;
  }
  
  public String getToken()
  {
    return this.mToken;
  }
  
  public String toString()
  {
    return "PurchaseInfo(type:" + this.mItemType + "):" + this.mOriginalJson;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/net/wargaming/wot/util/Purchase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */