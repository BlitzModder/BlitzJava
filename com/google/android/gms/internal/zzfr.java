package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import org.json.JSONException;
import org.json.JSONObject;

@zzha
public class zzfr
{
  private final String zzCJ;
  private final zzjn zzps;
  
  public zzfr(zzjn paramzzjn)
  {
    this(paramzzjn, "");
  }
  
  public zzfr(zzjn paramzzjn, String paramString)
  {
    this.zzps = paramzzjn;
    this.zzCJ = paramString;
  }
  
  public void zza(int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat, int paramInt5)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("width", paramInt1).put("height", paramInt2).put("maxSizeWidth", paramInt3).put("maxSizeHeight", paramInt4).put("density", paramFloat).put("rotation", paramInt5);
      this.zzps.zzb("onScreenInfoChanged", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      zzb.zzb("Error occured while obtaining screen information.", localJSONException);
    }
  }
  
  public void zzal(String paramString)
  {
    try
    {
      paramString = new JSONObject().put("message", paramString).put("action", this.zzCJ);
      this.zzps.zzb("onError", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      zzb.zzb("Error occurred while dispatching error event.", paramString);
    }
  }
  
  public void zzam(String paramString)
  {
    try
    {
      paramString = new JSONObject().put("js", paramString);
      this.zzps.zzb("onReadyEventReceived", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      zzb.zzb("Error occured while dispatching ready Event.", paramString);
    }
  }
  
  public void zzan(String paramString)
  {
    try
    {
      paramString = new JSONObject().put("state", paramString);
      this.zzps.zzb("onStateChanged", paramString);
      return;
    }
    catch (JSONException paramString)
    {
      zzb.zzb("Error occured while dispatching state change.", paramString);
    }
  }
  
  public void zzb(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("x", paramInt1).put("y", paramInt2).put("width", paramInt3).put("height", paramInt4);
      this.zzps.zzb("onSizeChanged", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      zzb.zzb("Error occured while dispatching size change.", localJSONException);
    }
  }
  
  public void zzc(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject().put("x", paramInt1).put("y", paramInt2).put("width", paramInt3).put("height", paramInt4);
      this.zzps.zzb("onDefaultPositionReceived", localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      zzb.zzb("Error occured while dispatching default position.", localJSONException);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzfr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */