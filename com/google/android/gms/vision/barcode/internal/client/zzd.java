package com.google.android.gms.vision.barcode.internal.client;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.dynamic.zzg.zza;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;
import java.nio.ByteBuffer;

public class zzd
{
  private final Context mContext;
  private final BarcodeDetectorOptions zzbip;
  private zzb zzbir = null;
  private final Object zzpK = new Object();
  
  public zzd(Context paramContext, BarcodeDetectorOptions paramBarcodeDetectorOptions)
  {
    this.mContext = paramContext;
    this.zzbip = paramBarcodeDetectorOptions;
    zzGl();
  }
  
  private zzb zzGl()
  {
    synchronized (this.zzpK)
    {
      if (this.zzbir == null) {
        this.zzbir = zza.zza(this.mContext, this.zzbip);
      }
      zzb localzzb = this.zzbir;
      return localzzb;
    }
  }
  
  public boolean isOperational()
  {
    return zzGl() != null;
  }
  
  public Barcode[] zza(Bitmap paramBitmap, FrameMetadataParcel paramFrameMetadataParcel)
  {
    zzb localzzb = zzGl();
    if (localzzb == null) {
      return new Barcode[0];
    }
    try
    {
      paramBitmap = localzzb.zzb(zze.zzB(paramBitmap), paramFrameMetadataParcel);
      return paramBitmap;
    }
    catch (RemoteException paramBitmap)
    {
      Log.e("NativeBarcodeDetectorHandle", "Error calling native barcode detector", paramBitmap);
    }
    return new Barcode[0];
  }
  
  public Barcode[] zza(ByteBuffer paramByteBuffer, FrameMetadataParcel paramFrameMetadataParcel)
  {
    zzb localzzb = zzGl();
    if (localzzb == null) {
      return new Barcode[0];
    }
    try
    {
      paramByteBuffer = localzzb.zza(zze.zzB(paramByteBuffer), paramFrameMetadataParcel);
      return paramByteBuffer;
    }
    catch (RemoteException paramByteBuffer)
    {
      Log.e("NativeBarcodeDetectorHandle", "Error calling native barcode detector", paramByteBuffer);
    }
    return new Barcode[0];
  }
  
  static class zza
    extends zzg<zzc>
  {
    private static zza zzbis;
    
    zza()
    {
      super();
    }
    
    static zzb zza(Context paramContext, BarcodeDetectorOptions paramBarcodeDetectorOptions)
    {
      if (zzbis == null) {
        zzbis = new zza();
      }
      return zzbis.zzb(paramContext, paramBarcodeDetectorOptions);
    }
    
    private zzb zzb(Context paramContext, BarcodeDetectorOptions paramBarcodeDetectorOptions)
    {
      try
      {
        com.google.android.gms.dynamic.zzd localzzd = zze.zzB(paramContext);
        paramContext = ((zzc)zzaA(paramContext)).zza(localzzd, paramBarcodeDetectorOptions);
        return paramContext;
      }
      catch (RemoteException paramContext)
      {
        Log.e("NativeBarcodeDetectorHandle", "Error creating native barcode detector", paramContext);
        return null;
      }
      catch (zzg.zza paramContext)
      {
        for (;;)
        {
          Log.e("NativeBarcodeDetectorHandle", "Error creating native barcode detector", paramContext);
        }
      }
    }
    
    protected zzc zzea(IBinder paramIBinder)
    {
      return zzc.zza.zzdZ(paramIBinder);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/vision/barcode/internal/client/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */