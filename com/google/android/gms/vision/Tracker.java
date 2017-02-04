package com.google.android.gms.vision;

public class Tracker<T>
{
  public void onDone() {}
  
  public void onMissing(Detector.Detections<T> paramDetections) {}
  
  public void onNewItem(int paramInt, T paramT) {}
  
  public void onUpdate(Detector.Detections<T> paramDetections, T paramT) {}
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/vision/Tracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */