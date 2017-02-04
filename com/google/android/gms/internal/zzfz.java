package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import org.json.JSONObject;

@zzha
public class zzfz
  extends Handler
{
  private final zzfy zzEp;
  
  public zzfz(Context paramContext)
  {
    this(new zzga(localContext));
  }
  
  public zzfz(zzfy paramzzfy)
  {
    this.zzEp = paramzzfy;
  }
  
  private void zzc(JSONObject paramJSONObject)
  {
    try
    {
      this.zzEp.zza(paramJSONObject.getString("request_id"), paramJSONObject.getString("base_url"), paramJSONObject.getString("html"));
      return;
    }
    catch (Exception paramJSONObject) {}
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      paramMessage = paramMessage.getData();
      if (paramMessage == null) {
        return;
      }
      paramMessage = new JSONObject(paramMessage.getString("data"));
      if ("fetch_html".equals(paramMessage.getString("message_name")))
      {
        zzc(paramMessage);
        return;
      }
    }
    catch (Exception paramMessage) {}
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzfz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */