package com.google.android.gms.wearable;

import java.io.IOException;

public class ChannelIOException
  extends IOException
{
  private final int zzblN;
  private final int zzblO;
  
  public ChannelIOException(String paramString, int paramInt1, int paramInt2)
  {
    super(paramString);
    this.zzblN = paramInt1;
    this.zzblO = paramInt2;
  }
  
  public int getAppSpecificErrorCode()
  {
    return this.zzblO;
  }
  
  public int getCloseReason()
  {
    return this.zzblN;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/ChannelIOException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */