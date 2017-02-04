package com.google.android.gms.vision.face;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.internal.client.FaceSettingsParcel;
import com.google.android.gms.vision.face.internal.client.zzg;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import com.google.android.gms.vision.zza;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;

public final class FaceDetector
  extends Detector<Face>
{
  public static final int ACCURATE_MODE = 1;
  public static final int ALL_CLASSIFICATIONS = 1;
  public static final int ALL_LANDMARKS = 1;
  public static final int FAST_MODE = 0;
  public static final int NO_CLASSIFICATIONS = 0;
  public static final int NO_LANDMARKS = 0;
  private final zza zzbiA = new zza();
  private final zzg zzbiB;
  private boolean zzbiC = true;
  private final Object zzpK = new Object();
  
  private FaceDetector()
  {
    throw new IllegalStateException("Default constructor called");
  }
  
  private FaceDetector(zzg paramzzg)
  {
    this.zzbiB = paramzzg;
  }
  
  public SparseArray<Face> detect(Frame paramFrame)
  {
    if (paramFrame == null) {
      throw new IllegalArgumentException("No frame supplied.");
    }
    Object localObject2 = paramFrame.getGrayscaleImageData();
    synchronized (this.zzpK)
    {
      if (!this.zzbiC) {
        throw new RuntimeException("Cannot use detector after release()");
      }
    }
    paramFrame = this.zzbiB.zzb((ByteBuffer)localObject2, FrameMetadataParcel.zzc(paramFrame));
    ??? = new HashSet();
    localObject2 = new SparseArray(paramFrame.length);
    int i1 = paramFrame.length;
    int j = 0;
    int i = 0;
    while (j < i1)
    {
      Object localObject3 = paramFrame[j];
      int m = ((Face)localObject3).getId();
      int n = Math.max(i, m);
      int k = m;
      i = n;
      if (((Set)???).contains(Integer.valueOf(m)))
      {
        k = n + 1;
        i = k;
      }
      ((Set)???).add(Integer.valueOf(k));
      ((SparseArray)localObject2).append(this.zzbiA.zzka(k), localObject3);
      j += 1;
    }
    return (SparseArray<Face>)localObject2;
  }
  
  /* Error */
  protected void finalize()
    throws java.lang.Throwable
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 41	com/google/android/gms/vision/face/FaceDetector:zzpK	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 43	com/google/android/gms/vision/face/FaceDetector:zzbiC	Z
    //   11: ifeq +15 -> 26
    //   14: ldc -119
    //   16: ldc -117
    //   18: invokestatic 145	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   21: pop
    //   22: aload_0
    //   23: invokevirtual 148	com/google/android/gms/vision/face/FaceDetector:release	()V
    //   26: aload_1
    //   27: monitorexit
    //   28: aload_0
    //   29: invokespecial 150	java/lang/Object:finalize	()V
    //   32: return
    //   33: astore_2
    //   34: aload_1
    //   35: monitorexit
    //   36: aload_2
    //   37: athrow
    //   38: astore_1
    //   39: aload_0
    //   40: invokespecial 150	java/lang/Object:finalize	()V
    //   43: aload_1
    //   44: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	45	0	this	FaceDetector
    //   38	6	1	localObject2	Object
    //   33	4	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   7	26	33	finally
    //   26	28	33	finally
    //   34	36	33	finally
    //   0	7	38	finally
    //   36	38	38	finally
  }
  
  public boolean isOperational()
  {
    return this.zzbiB.isOperational();
  }
  
  public void release()
  {
    synchronized (this.zzpK)
    {
      if (!this.zzbiC) {
        return;
      }
      this.zzbiB.zzGm();
      this.zzbiC = false;
      return;
    }
  }
  
  public boolean setFocus(int paramInt)
  {
    paramInt = this.zzbiA.zzkb(paramInt);
    synchronized (this.zzpK)
    {
      if (!this.zzbiC) {
        throw new RuntimeException("Cannot use detector after release()");
      }
    }
    boolean bool = this.zzbiB.zzks(paramInt);
    return bool;
  }
  
  public static class Builder
  {
    private final Context mContext;
    private int zzamE = 0;
    private int zzbiD = 0;
    private boolean zzbiE = false;
    private int zzbiF = 0;
    private boolean zzbiG = true;
    
    public Builder(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    public FaceDetector build()
    {
      FaceSettingsParcel localFaceSettingsParcel = new FaceSettingsParcel();
      localFaceSettingsParcel.mode = this.zzamE;
      localFaceSettingsParcel.zzbiO = this.zzbiD;
      localFaceSettingsParcel.zzbiP = this.zzbiF;
      localFaceSettingsParcel.zzbiQ = this.zzbiE;
      localFaceSettingsParcel.zzbiR = this.zzbiG;
      return new FaceDetector(new zzg(this.mContext, localFaceSettingsParcel), null);
    }
    
    public Builder setClassificationType(int paramInt)
    {
      if ((paramInt != 0) && (paramInt != 1)) {
        throw new IllegalArgumentException("Invalid classification type: " + paramInt);
      }
      this.zzbiF = paramInt;
      return this;
    }
    
    public Builder setLandmarkType(int paramInt)
    {
      if ((paramInt != 0) && (paramInt != 1)) {
        throw new IllegalArgumentException("Invalid landmark type: " + paramInt);
      }
      this.zzbiD = paramInt;
      return this;
    }
    
    public Builder setMode(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("Invalid mode: " + paramInt);
      }
      this.zzamE = paramInt;
      return this;
    }
    
    public Builder setProminentFaceOnly(boolean paramBoolean)
    {
      this.zzbiE = paramBoolean;
      return this;
    }
    
    public Builder setTrackingEnabled(boolean paramBoolean)
    {
      this.zzbiG = paramBoolean;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/vision/face/FaceDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */