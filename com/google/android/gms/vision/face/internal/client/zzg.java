package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.graphics.PointF;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.Landmark;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import java.nio.ByteBuffer;

public class zzg
{
  private final Context mContext;
  private final FaceSettingsParcel zzbiT;
  private zzc zzbiU = null;
  private boolean zzbiV = false;
  private final Object zzpK = new Object();
  
  public zzg(Context paramContext, FaceSettingsParcel paramFaceSettingsParcel)
  {
    this.mContext = paramContext;
    this.zzbiT = paramFaceSettingsParcel;
    zzGn();
  }
  
  private zzc zzGn()
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        zzc localzzc;
        if (this.zzbiU != null)
        {
          localzzc = this.zzbiU;
          return localzzc;
        }
        this.zzbiU = zzf.zza(this.mContext, this.zzbiT);
        if ((!this.zzbiV) && (this.zzbiU == null))
        {
          Log.w("FaceDetectorHandle", "Native face detector not yet available.  Reverting to no-op detection.");
          this.zzbiV = true;
          localzzc = this.zzbiU;
          return localzzc;
        }
      }
      if ((this.zzbiV) && (this.zzbiU != null)) {
        Log.w("FaceDetectorHandle", "Native face detector is now available.");
      }
    }
  }
  
  private Face zza(FaceParcel paramFaceParcel)
  {
    return new Face(paramFaceParcel.id, new PointF(paramFaceParcel.centerX, paramFaceParcel.centerY), paramFaceParcel.width, paramFaceParcel.height, paramFaceParcel.zzbiI, paramFaceParcel.zzbiJ, zzb(paramFaceParcel), paramFaceParcel.zzbiL, paramFaceParcel.zzbiM, paramFaceParcel.zzbiN);
  }
  
  private Landmark zza(LandmarkParcel paramLandmarkParcel)
  {
    return new Landmark(new PointF(paramLandmarkParcel.x, paramLandmarkParcel.y), paramLandmarkParcel.type);
  }
  
  private Landmark[] zzb(FaceParcel paramFaceParcel)
  {
    int i = 0;
    paramFaceParcel = paramFaceParcel.zzbiK;
    if (paramFaceParcel == null) {
      return new Landmark[0];
    }
    Landmark[] arrayOfLandmark = new Landmark[paramFaceParcel.length];
    while (i < paramFaceParcel.length)
    {
      arrayOfLandmark[i] = zza(paramFaceParcel[i]);
      i += 1;
    }
    return arrayOfLandmark;
  }
  
  public boolean isOperational()
  {
    return zzGn() != null;
  }
  
  public void zzGm()
  {
    synchronized (this.zzpK)
    {
      if (this.zzbiU == null) {
        return;
      }
    }
    try
    {
      this.zzbiU.zzGm();
      return;
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        Log.e("FaceDetectorHandle", "Could not finalize native face detector", localRemoteException);
      }
    }
  }
  
  public Face[] zzb(ByteBuffer paramByteBuffer, FrameMetadataParcel paramFrameMetadataParcel)
  {
    int i = 0;
    zzc localzzc = zzGn();
    if (localzzc == null) {
      return new Face[0];
    }
    try
    {
      paramByteBuffer = localzzc.zzc(zze.zzB(paramByteBuffer), paramFrameMetadataParcel);
      paramFrameMetadataParcel = new Face[paramByteBuffer.length];
      while (i < paramByteBuffer.length)
      {
        paramFrameMetadataParcel[i] = zza(paramByteBuffer[i]);
        i += 1;
      }
      return paramFrameMetadataParcel;
    }
    catch (RemoteException paramByteBuffer)
    {
      Log.e("FaceDetectorHandle", "Could not call native face detector", paramByteBuffer);
      return new Face[0];
    }
  }
  
  public boolean zzks(int paramInt)
  {
    zzc localzzc = zzGn();
    if (localzzc == null) {
      return false;
    }
    try
    {
      boolean bool = localzzc.zzks(paramInt);
      return bool;
    }
    catch (RemoteException localRemoteException)
    {
      Log.e("FaceDetectorHandle", "Could not call native face detector", localRemoteException);
    }
    return false;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/vision/face/internal/client/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */