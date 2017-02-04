package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.zzh;

public class zzbj
  implements zzh
{
  private final LargeAssetSyncRequestPayload zzbog;
  private final zzay zzboh;
  private boolean zzboi;
  private ParcelFileDescriptor zzboj;
  private long zzbok;
  private int zzbol;
  
  public zzbj(LargeAssetSyncRequestPayload paramLargeAssetSyncRequestPayload, zzay paramzzay)
  {
    this.zzbog = ((LargeAssetSyncRequestPayload)zzx.zzy(paramLargeAssetSyncRequestPayload));
    this.zzboh = ((zzay)zzx.zzy(paramzzay));
    zzx.zzy(paramLargeAssetSyncRequestPayload.zzbnK);
    if (paramLargeAssetSyncRequestPayload.zzbom >= 0L) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Got negative offset: %s", new Object[] { Long.valueOf(paramLargeAssetSyncRequestPayload.zzbom) });
      return;
    }
  }
  
  /* Error */
  public void zzGX()
    throws android.os.RemoteException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 62	com/google/android/gms/wearable/internal/zzbj:zzboi	Z
    //   4: ldc 64
    //   6: invokestatic 68	com/google/android/gms/common/internal/zzx:zza	(ZLjava/lang/Object;)V
    //   9: aload_0
    //   10: getfield 70	com/google/android/gms/wearable/internal/zzbj:zzboj	Landroid/os/ParcelFileDescriptor;
    //   13: ifnull +35 -> 48
    //   16: aload_0
    //   17: getfield 37	com/google/android/gms/wearable/internal/zzbj:zzboh	Lcom/google/android/gms/wearable/internal/zzay;
    //   20: aload_0
    //   21: getfield 70	com/google/android/gms/wearable/internal/zzbj:zzboj	Landroid/os/ParcelFileDescriptor;
    //   24: aload_0
    //   25: getfield 72	com/google/android/gms/wearable/internal/zzbj:zzbok	J
    //   28: invokeinterface 75 4 0
    //   33: aload_0
    //   34: getfield 70	com/google/android/gms/wearable/internal/zzbj:zzboj	Landroid/os/ParcelFileDescriptor;
    //   37: ifnull +10 -> 47
    //   40: aload_0
    //   41: getfield 70	com/google/android/gms/wearable/internal/zzbj:zzboj	Landroid/os/ParcelFileDescriptor;
    //   44: invokestatic 80	com/google/android/gms/internal/zznt:zza	(Landroid/os/ParcelFileDescriptor;)V
    //   47: return
    //   48: aload_0
    //   49: getfield 37	com/google/android/gms/wearable/internal/zzbj:zzboh	Lcom/google/android/gms/wearable/internal/zzay;
    //   52: aload_0
    //   53: getfield 82	com/google/android/gms/wearable/internal/zzbj:zzbol	I
    //   56: invokeinterface 86 2 0
    //   61: goto -28 -> 33
    //   64: astore_1
    //   65: aload_0
    //   66: getfield 70	com/google/android/gms/wearable/internal/zzbj:zzboj	Landroid/os/ParcelFileDescriptor;
    //   69: ifnull +10 -> 79
    //   72: aload_0
    //   73: getfield 70	com/google/android/gms/wearable/internal/zzbj:zzboj	Landroid/os/ParcelFileDescriptor;
    //   76: invokestatic 80	com/google/android/gms/internal/zznt:zza	(Landroid/os/ParcelFileDescriptor;)V
    //   79: aload_1
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	zzbj
    //   64	16	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	33	64	finally
    //   48	61	64	finally
  }
  
  public void zzli(int paramInt)
  {
    if (!this.zzboi) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zza(bool, "createOutputFileDescriptor called when response already set");
      this.zzbol = paramInt;
      this.zzboi = true;
      return;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzbj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */