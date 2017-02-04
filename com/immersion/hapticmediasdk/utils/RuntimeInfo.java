package com.immersion.hapticmediasdk.utils;

public class RuntimeInfo
{
  private boolean a = true;
  
  public boolean areHapticsEnabled()
  {
    try
    {
      boolean bool = this.a;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void mute()
  {
    try
    {
      this.a = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void unmute()
  {
    try
    {
      this.a = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/immersion/hapticmediasdk/utils/RuntimeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */