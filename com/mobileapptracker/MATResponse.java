package com.mobileapptracker;

import org.json.JSONObject;

public abstract interface MATResponse
{
  public abstract void didFailWithError(JSONObject paramJSONObject);
  
  public abstract void didSucceedWithData(JSONObject paramJSONObject);
  
  public abstract void enqueuedActionWithRefId(String paramString);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/mobileapptracker/MATResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */