package com.immersion.hapticmediasdk.utils;

import android.os.SystemClock;

public class Profiler
{
  public long mStartTime;
  public long mStartTimeII;
  
  public long getDuration()
  {
    return SystemClock.elapsedRealtime() - this.mStartTime;
  }
  
  public long getDurationII()
  {
    return SystemClock.elapsedRealtime() - this.mStartTimeII;
  }
  
  public void startTiming()
  {
    this.mStartTime = SystemClock.elapsedRealtime();
  }
  
  public void startTimingII()
  {
    this.mStartTimeII = SystemClock.elapsedRealtime();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/immersion/hapticmediasdk/utils/Profiler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */