package com.immersion.content;

import android.content.Context;
import android.util.Log;

public class EndpointWarp
{
  private static final String b = "EndpointWarp";
  long a;
  
  public EndpointWarp(Context paramContext, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, int paramInt, short paramShort, byte paramByte5, byte[] paramArrayOfByte, byte paramByte6)
  {
    this.a = create(paramContext, paramByte1, paramByte2, paramByte3, paramByte4, paramInt, paramShort, paramByte5, paramArrayOfByte, paramByte6);
  }
  
  public EndpointWarp(Context paramContext, byte[] paramArrayOfByte, int paramInt)
  {
    this.a = createWarp(paramContext, paramArrayOfByte, paramInt);
  }
  
  private native long create(Context paramContext, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, int paramInt, short paramShort, byte paramByte5, byte[] paramArrayOfByte, byte paramByte6);
  
  private native long createWarp(Context paramContext, byte[] paramArrayOfByte, int paramInt);
  
  private native void disposeWarp(long paramLong);
  
  private native void flushWarp(long paramLong);
  
  private native long getWarpCurrentPosition(long paramLong);
  
  public static boolean loadSharedLibrary()
  {
    try
    {
      System.loadLibrary("ImmEndpointWarpJ");
      return true;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      while (System.getProperty("java.vm.name").contains("Java HotSpot")) {}
      Log.e("EndpointWarp", "Unable to load libImmEndpointWarpJ.so.Please make sure this file is in the libs/armeabi folder.");
      localUnsatisfiedLinkError.printStackTrace();
    }
    return false;
  }
  
  private native void startWarp(long paramLong);
  
  private native void stopWarp(long paramLong);
  
  private native void updateWarp(long paramLong1, byte[] paramArrayOfByte, int paramInt, long paramLong2, long paramLong3);
  
  public void dispose()
  {
    disposeWarp(this.a);
  }
  
  public void flush()
  {
    flushWarp(this.a);
  }
  
  public long getCurrentPosition()
  {
    return getWarpCurrentPosition(this.a);
  }
  
  public void start()
  {
    startWarp(this.a);
  }
  
  public void stop()
  {
    stopWarp(this.a);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt, long paramLong1, long paramLong2)
  {
    updateWarp(this.a, paramArrayOfByte, paramInt, paramLong1, paramLong2);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/immersion/content/EndpointWarp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */