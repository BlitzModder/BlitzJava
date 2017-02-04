package com.google.android.gms.vision;

import android.util.SparseArray;

public abstract class Detector<T>
{
  private Object zzbhS = new Object();
  private Processor<T> zzbhT;
  
  public abstract SparseArray<T> detect(Frame paramFrame);
  
  public boolean isOperational()
  {
    return true;
  }
  
  public void receiveFrame(Frame paramFrame)
  {
    synchronized (this.zzbhS)
    {
      if (this.zzbhT == null) {
        throw new IllegalStateException("Detector processor must first be set with setProcessor in order to receive detection results.");
      }
    }
    Frame.Metadata localMetadata = new Frame.Metadata(paramFrame.getMetadata());
    localMetadata.zzGk();
    paramFrame = new Detections(detect(paramFrame), localMetadata, isOperational());
    this.zzbhT.receiveDetections(paramFrame);
  }
  
  public void release()
  {
    synchronized (this.zzbhS)
    {
      if (this.zzbhT != null)
      {
        this.zzbhT.release();
        this.zzbhT = null;
      }
      return;
    }
  }
  
  public boolean setFocus(int paramInt)
  {
    return true;
  }
  
  public void setProcessor(Processor<T> paramProcessor)
  {
    this.zzbhT = paramProcessor;
  }
  
  public static class Detections<T>
  {
    private SparseArray<T> zzbhU;
    private Frame.Metadata zzbhV;
    private boolean zzbhW;
    
    public Detections(SparseArray<T> paramSparseArray, Frame.Metadata paramMetadata, boolean paramBoolean)
    {
      this.zzbhU = paramSparseArray;
      this.zzbhV = paramMetadata;
      this.zzbhW = paramBoolean;
    }
    
    public boolean detectorIsOperational()
    {
      return this.zzbhW;
    }
    
    public SparseArray<T> getDetectedItems()
    {
      return this.zzbhU;
    }
    
    public Frame.Metadata getFrameMetadata()
    {
      return this.zzbhV;
    }
  }
  
  public static abstract interface Processor<T>
  {
    public abstract void receiveDetections(Detector.Detections<T> paramDetections);
    
    public abstract void release();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/vision/Detector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */