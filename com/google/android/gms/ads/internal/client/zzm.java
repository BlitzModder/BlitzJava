package com.google.android.gms.ads.internal.client;

import com.google.android.gms.internal.zzha;
import java.util.Random;

@zzha
public class zzm
  extends zzv.zza
{
  private Object zzpK = new Object();
  private final Random zzuj = new Random();
  private long zzuk;
  
  public zzm()
  {
    zzcS();
  }
  
  public long getValue()
  {
    return this.zzuk;
  }
  
  public void zzcS()
  {
    Object localObject1 = this.zzpK;
    int i = 3;
    long l1 = 0L;
    for (;;)
    {
      int j = i - 1;
      if (j > 0) {}
      try
      {
        long l2 = this.zzuj.nextInt() + 2147483648L;
        l1 = l2;
        i = j;
        if (l2 == this.zzuk) {
          continue;
        }
        l1 = l2;
        i = j;
        if (l2 == 0L) {
          continue;
        }
        l1 = l2;
        this.zzuk = l1;
        return;
      }
      finally {}
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/client/zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */