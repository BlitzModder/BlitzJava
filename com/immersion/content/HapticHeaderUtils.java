package com.immersion.content;

import java.nio.ByteBuffer;

public class HapticHeaderUtils
  extends HeaderUtils
{
  private static final String b = "HapticHeaderUtils";
  long a;
  private byte[] c;
  private int d;
  
  private native int calculateBlockRateNative(long paramLong);
  
  private native int calculateBlockSizeNative(long paramLong);
  
  private native int calculateByteOffsetIntoHapticDataNative(long paramLong, int paramInt);
  
  private native void disposeNative(long paramLong);
  
  private native String getContentIdNative(long paramLong);
  
  private native int getEncryptionNative(long paramLong);
  
  private native int getMajorVersionNumberNative(long paramLong);
  
  private native int getMinorVersionNumberNative(long paramLong);
  
  private native int getNumChannelsNative(long paramLong);
  
  private native long init(byte[] paramArrayOfByte, int paramInt);
  
  public int calculateBlockRate()
  {
    return calculateBlockRateNative(this.a);
  }
  
  public int calculateBlockSize()
  {
    return calculateBlockSizeNative(this.a);
  }
  
  public int calculateByteOffsetIntoHapticData(int paramInt)
  {
    return calculateByteOffsetIntoHapticDataNative(this.a, paramInt);
  }
  
  public void dispose()
  {
    disposeNative(this.a);
  }
  
  public String getContentUUID()
  {
    return getContentIdNative(this.a);
  }
  
  public int getEncryption()
  {
    return getEncryptionNative(this.a);
  }
  
  public int getMajorVersionNumber()
  {
    return getMajorVersionNumberNative(this.a);
  }
  
  public int getMinorVersionNumber()
  {
    return getMinorVersionNumberNative(this.a);
  }
  
  public int getNumChannels()
  {
    return getNumChannelsNative(this.a);
  }
  
  public void setEncryptedHSI(ByteBuffer paramByteBuffer, int paramInt)
  {
    this.d = paramInt;
    this.c = new byte[this.d];
    paramByteBuffer.get(this.c, 0, this.d);
    this.a = init(this.c, this.d);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/immersion/content/HapticHeaderUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */