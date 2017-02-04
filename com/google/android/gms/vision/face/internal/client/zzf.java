package com.google.android.gms.vision.face.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;

class zzf
  extends zzg<zzd>
{
  private static zzf zzbiS;
  
  zzf()
  {
    super("com.google.android.gms.vision.client.DynamiteNativeFaceDetectorCreator");
  }
  
  static zzc zza(Context paramContext, FaceSettingsParcel paramFaceSettingsParcel)
  {
    if (zzbiS == null) {
      zzbiS = new zzf();
    }
    return zzbiS.zzb(paramContext, paramFaceSettingsParcel);
  }
  
  private zzc zzb(Context paramContext, FaceSettingsParcel paramFaceSettingsParcel)
  {
    try
    {
      com.google.android.gms.dynamic.zzd localzzd = zze.zzB(paramContext);
      paramContext = ((zzd)zzaA(paramContext)).zza(localzzd, paramFaceSettingsParcel);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e("FaceDetectorHandle", "Could not create native face detector", paramContext);
    }
    return null;
  }
  
  protected zzd zzed(IBinder paramIBinder)
  {
    return zzd.zza.zzec(paramIBinder);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/vision/face/internal/client/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */