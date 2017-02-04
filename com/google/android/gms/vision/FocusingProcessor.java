package com.google.android.gms.vision;

import android.util.Log;
import android.util.SparseArray;

public abstract class FocusingProcessor<T>
  implements Detector.Processor<T>
{
  private Detector<T> zzbhH;
  private Tracker<T> zzbhX;
  private int zzbhY = 3;
  private boolean zzbhZ = false;
  private int zzbia;
  private int zzbib = 0;
  
  public FocusingProcessor(Detector<T> paramDetector, Tracker<T> paramTracker)
  {
    this.zzbhH = paramDetector;
    this.zzbhX = paramTracker;
  }
  
  public void receiveDetections(Detector.Detections<T> paramDetections)
  {
    Object localObject1 = paramDetections.getDetectedItems();
    if (((SparseArray)localObject1).size() == 0)
    {
      if (this.zzbib == this.zzbhY)
      {
        this.zzbhX.onDone();
        this.zzbhZ = false;
      }
      for (;;)
      {
        this.zzbib += 1;
        return;
        this.zzbhX.onMissing(paramDetections);
      }
    }
    this.zzbib = 0;
    if (this.zzbhZ)
    {
      Object localObject2 = ((SparseArray)localObject1).get(this.zzbia);
      if (localObject2 != null)
      {
        this.zzbhX.onUpdate(paramDetections, localObject2);
        return;
      }
      this.zzbhX.onDone();
      this.zzbhZ = false;
    }
    int i = selectFocus(paramDetections);
    localObject1 = ((SparseArray)localObject1).get(i);
    if (localObject1 == null)
    {
      Log.w("FocusingProcessor", "Invalid focus selected: " + i);
      return;
    }
    this.zzbhZ = true;
    this.zzbia = i;
    this.zzbhH.setFocus(this.zzbia);
    this.zzbhX.onNewItem(this.zzbia, localObject1);
    this.zzbhX.onUpdate(paramDetections, localObject1);
  }
  
  public void release()
  {
    this.zzbhX.onDone();
  }
  
  public abstract int selectFocus(Detector.Detections<T> paramDetections);
  
  protected void zzjZ(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Invalid max gap: " + paramInt);
    }
    this.zzbhY = paramInt;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/vision/FocusingProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */