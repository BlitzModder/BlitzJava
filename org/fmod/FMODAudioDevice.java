package org.fmod;

import android.media.AudioTrack;
import android.util.Log;
import java.nio.ByteBuffer;

public class FMODAudioDevice
  implements Runnable
{
  private static int FMOD_INFO_CHANNELCOUNT = 4;
  private static int FMOD_INFO_DSPBUFFERLENGTH;
  private static int FMOD_INFO_DSPNUMBUFFERS;
  private static int FMOD_INFO_MIXERRUNNING;
  private static int FMOD_INFO_SAMPLERATE = 0;
  private boolean mInitialised = false;
  private boolean mRunning = false;
  private Thread mThread = null;
  private AudioTrack mTrack = null;
  
  static
  {
    FMOD_INFO_DSPBUFFERLENGTH = 1;
    FMOD_INFO_DSPNUMBUFFERS = 2;
    FMOD_INFO_MIXERRUNNING = 3;
  }
  
  private int fetchChannelConfigFromCount(int paramInt)
  {
    if (paramInt == 1) {
      return 2;
    }
    if (paramInt == 2) {
      return 3;
    }
    if (paramInt == 6) {
      return 252;
    }
    return 0;
  }
  
  private native int fmodGetInfo(int paramInt);
  
  private native int fmodProcess(ByteBuffer paramByteBuffer);
  
  private void shutDown()
  {
    if (this.mTrack != null)
    {
      this.mTrack.stop();
      this.mTrack.release();
      this.mTrack = null;
    }
    this.mInitialised = false;
  }
  
  public boolean isMixing()
  {
    return this.mInitialised;
  }
  
  public void run()
  {
    int i = 3;
    byte[] arrayOfByte = null;
    ByteBuffer localByteBuffer = null;
    int m;
    int n;
    int i1;
    int i2;
    int j;
    if (this.mRunning) {
      if (!this.mInitialised)
      {
        m = fmodGetInfo(FMOD_INFO_SAMPLERATE);
        n = fmodGetInfo(FMOD_INFO_DSPBUFFERLENGTH);
        int k = fmodGetInfo(FMOD_INFO_DSPNUMBUFFERS);
        i1 = fmodGetInfo(FMOD_INFO_CHANNELCOUNT);
        if ((m > 0) && (n > 0) && (k > 0) && (i1 > 0))
        {
          i2 = fetchChannelConfigFromCount(i1);
          j = AudioTrack.getMinBufferSize(m, i2, 2);
          if (j < 0)
          {
            Log.w("fmod", "FMOD: AudioDevice::run               : Couldn't query minimum buffer size, possibly unsupported sample rate or channel count");
            label105:
            k = k * n * i1 * 2;
            if (k <= j) {
              break label387;
            }
            j = k;
          }
        }
      }
    }
    label387:
    for (;;)
    {
      Log.i("fmod", "FMOD: AudioDevice::run               : Actual buffer size: " + j + " bytes");
      localByteBuffer = ByteBuffer.allocateDirect(n * i1 * 2);
      arrayOfByte = new byte[localByteBuffer.capacity()];
      this.mTrack = new AudioTrack(3, m, i2, 2, j, 1);
      if (this.mTrack.getState() == 1)
      {
        this.mTrack.play();
        this.mInitialised = true;
      }
      for (;;)
      {
        break;
        Log.i("fmod", "FMOD: AudioDevice::run               : Min buffer size: " + j + " bytes");
        break label105;
        this.mTrack.release();
        this.mTrack = null;
        i -= 1;
        if (i == 0)
        {
          Log.e("fmod", "FMOD: AudioDevice::run               : Couldn't initialize AudioTrack, giving up");
          this.mRunning = false;
        }
        else
        {
          Log.w("fmod", "FMOD: AudioDevice::run               : Couldn't initialize AudioTrack, retrying...");
          try
          {
            Thread.sleep(1000L);
          }
          catch (InterruptedException localInterruptedException1) {}
          continue;
          try
          {
            Thread.sleep(100L);
          }
          catch (InterruptedException localInterruptedException2) {}
        }
      }
      if (fmodGetInfo(FMOD_INFO_MIXERRUNNING) == 1)
      {
        fmodProcess(localByteBuffer);
        localByteBuffer.get(arrayOfByte);
        localByteBuffer.position(0);
        this.mTrack.write(arrayOfByte, 0, localByteBuffer.capacity());
        break;
      }
      shutDown();
      break;
      shutDown();
      return;
    }
  }
  
  public void start()
  {
    if (this.mThread != null) {
      stop();
    }
    this.mThread = new Thread(this);
    this.mThread.setPriority(10);
    this.mRunning = true;
    this.mThread.start();
  }
  
  public void stop()
  {
    while (this.mThread != null)
    {
      this.mRunning = false;
      try
      {
        this.mThread.join();
        this.mThread = null;
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/org/fmod/FMODAudioDevice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */