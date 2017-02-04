package com.immersion.hapticmediasdk.controllers;

import com.immersion.hapticmediasdk.models.HapticFileInformation;
import com.immersion.hapticmediasdk.models.NotEnoughHapticBytesAvailableException;

public abstract interface IHapticFileReader
{
  public abstract boolean bufferAtPlaybackPosition(int paramInt);
  
  public abstract void close();
  
  public abstract long getBlockOffset(long paramLong);
  
  public abstract int getBlockSizeMS();
  
  public abstract byte[] getBufferForPlaybackPosition(int paramInt)
    throws NotEnoughHapticBytesAvailableException;
  
  public abstract byte[] getEncryptedHapticHeader();
  
  public abstract int getHapticBlockIndex(long paramLong);
  
  public abstract HapticFileInformation getHapticFileInformation();
  
  public abstract void setBlockSizeMS(int paramInt);
  
  public abstract void setBytesAvailable(int paramInt);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/immersion/hapticmediasdk/controllers/IHapticFileReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */