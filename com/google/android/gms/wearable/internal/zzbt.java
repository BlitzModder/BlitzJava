package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.util.LongSparseArray;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.LargeAssetApi.zzb;
import com.google.android.gms.wearable.LargeAssetApi.zzc;

public final class zzbt
  extends AbstractDataBuffer<LargeAssetApi.zzb>
  implements LargeAssetApi.zzc
{
  private static final long[] zzboC = new long[0];
  private static final int[] zzboD = new int[0];
  private final Status zzTA;
  private final LongSparseArray<zza> zzboE;
  
  public zzbt(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.zzTA = zzbz.zzfU(paramDataHolder.getStatusCode());
    this.zzboE = zzM(paramDataHolder.zzpH());
  }
  
  private String zzA(int paramInt1, int paramInt2)
  {
    return this.zzafC.zzd("nodeId", paramInt1, paramInt2);
  }
  
  private Uri zzB(int paramInt1, int paramInt2)
  {
    return Uri.parse(this.zzafC.zzd("destinationUri", paramInt1, paramInt2));
  }
  
  private boolean zzC(int paramInt1, int paramInt2)
  {
    return this.zzafC.zze("append", paramInt1, paramInt2);
  }
  
  private boolean zzD(int paramInt1, int paramInt2)
  {
    return this.zzafC.zze("allowedOverMetered", paramInt1, paramInt2);
  }
  
  private boolean zzE(int paramInt1, int paramInt2)
  {
    return this.zzafC.zze("allowedWithLowBattery", paramInt1, paramInt2);
  }
  
  private static long[] zzK(Bundle paramBundle)
  {
    paramBundle = paramBundle.getLongArray("notPausedTransferIds");
    if (paramBundle != null) {
      return paramBundle;
    }
    return zzboC;
  }
  
  private static int[] zzL(Bundle paramBundle)
  {
    paramBundle = paramBundle.getIntArray("refuseCodes");
    if (paramBundle != null) {
      return paramBundle;
    }
    return zzboD;
  }
  
  private static LongSparseArray<zza> zzM(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return new LongSparseArray(0);
    }
    long[] arrayOfLong = zzK(paramBundle);
    int[] arrayOfInt = paramBundle.getIntArray("notPausedStates");
    if (arrayOfInt == null) {
      return zza(arrayOfLong, new zza(2, 0));
    }
    return zza(arrayOfLong, arrayOfInt, zzL(paramBundle));
  }
  
  private int zzY(long paramLong)
  {
    zza localzza = (zza)this.zzboE.get(paramLong);
    if (localzza == null) {
      return 1;
    }
    return localzza.state;
  }
  
  private int zzZ(long paramLong)
  {
    zza localzza = (zza)this.zzboE.get(paramLong);
    if (localzza == null) {
      return 0;
    }
    return localzza.zzboF;
  }
  
  private static <T> LongSparseArray<T> zza(long[] paramArrayOfLong, T paramT)
  {
    zzx.zzy(paramT);
    LongSparseArray localLongSparseArray = new LongSparseArray(paramArrayOfLong.length);
    int j = paramArrayOfLong.length;
    int i = 0;
    while (i < j)
    {
      localLongSparseArray.put(paramArrayOfLong[i], paramT);
      i += 1;
    }
    return localLongSparseArray;
  }
  
  private static LongSparseArray<zza> zza(long[] paramArrayOfLong, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    boolean bool;
    LongSparseArray localLongSparseArray;
    int i;
    label38:
    label61:
    int k;
    if (paramArrayOfLong.length == paramArrayOfInt1.length)
    {
      bool = true;
      zzx.zzb(bool, "transferIds and states differ in length.");
      zzx.zzy(paramArrayOfInt2);
      localLongSparseArray = new LongSparseArray(paramArrayOfLong.length);
      i = 0;
      int j = 0;
      if (i >= paramArrayOfLong.length) {
        break label123;
      }
      if (paramArrayOfInt1[i] != 4) {
        break label126;
      }
      if (j >= paramArrayOfInt2.length) {
        break label117;
      }
      bool = true;
      zzx.zzb(bool, "More entries in STATE_REFUSED than refuseCodes");
      k = paramArrayOfInt2[j];
      j += 1;
    }
    for (;;)
    {
      zza localzza = new zza(paramArrayOfInt1[i], k);
      localLongSparseArray.put(paramArrayOfLong[i], localzza);
      i += 1;
      break label38;
      bool = false;
      break;
      label117:
      bool = false;
      break label61;
      label123:
      return localLongSparseArray;
      label126:
      k = 0;
    }
  }
  
  private static int zzmd(int paramInt)
  {
    if ((paramInt == 2) || (paramInt == 1) || (paramInt == 3) || (paramInt == 4) || (paramInt == 5)) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Invalid queue entry state: %s", new Object[] { Integer.valueOf(paramInt) });
      return paramInt;
    }
  }
  
  private long zzy(int paramInt1, int paramInt2)
  {
    return this.zzafC.zzb("transferId", paramInt1, paramInt2);
  }
  
  private String zzz(int paramInt1, int paramInt2)
  {
    return this.zzafC.zzd("path", paramInt1, paramInt2);
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
  
  public String toString()
  {
    return "QueueEntryBufferImpl{status=" + this.zzTA + ", entryMetadataByTransferId=" + this.zzboE + "}";
  }
  
  public LargeAssetApi.zzb zzmc(int paramInt)
  {
    int i = this.zzafC.zzbI(paramInt);
    long l = zzy(paramInt, i);
    return new LargeAssetQueueEntryParcelable(l, zzY(l), zzz(paramInt, i), zzA(paramInt, i), zzB(paramInt, i), zzZ(l), zzC(paramInt, i), zzD(paramInt, i), zzE(paramInt, i));
  }
  
  private static final class zza
  {
    public final int state;
    public final int zzboF;
    
    public zza(int paramInt1, int paramInt2)
    {
      this.state = zzbt.zzme(paramInt1);
      this.zzboF = paramInt2;
    }
    
    public String toString()
    {
      return "EntryMetadata{state=" + this.state + ", refuseCode=" + this.zzboF + "}";
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzbt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */