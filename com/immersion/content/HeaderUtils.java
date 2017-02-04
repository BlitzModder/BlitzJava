package com.immersion.content;

import java.nio.ByteBuffer;

public abstract class HeaderUtils
{
  public abstract int calculateBlockRate();
  
  public abstract int calculateBlockSize();
  
  public abstract int calculateByteOffsetIntoHapticData(int paramInt);
  
  public abstract void dispose();
  
  public abstract String getContentUUID();
  
  public abstract int getEncryption();
  
  public abstract int getMajorVersionNumber();
  
  public abstract int getMinorVersionNumber();
  
  public abstract int getNumChannels();
  
  public abstract void setEncryptedHSI(ByteBuffer paramByteBuffer, int paramInt);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/immersion/content/HeaderUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */