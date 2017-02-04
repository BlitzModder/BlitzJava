package com.google.android.gms.analytics.internal;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

class zzs
  implements Logger
{
  private boolean zzNQ;
  private int zzQh = 2;
  
  public void error(Exception paramException) {}
  
  public void error(String paramString) {}
  
  public int getLogLevel()
  {
    return this.zzQh;
  }
  
  public void info(String paramString) {}
  
  public void setLogLevel(int paramInt)
  {
    this.zzQh = paramInt;
    if (!this.zzNQ)
    {
      Log.i((String)zzy.zzQr.get(), "Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag." + (String)zzy.zzQr.get() + " DEBUG");
      this.zzNQ = true;
    }
  }
  
  public void verbose(String paramString) {}
  
  public void warn(String paramString) {}
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */