package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.ChannelIOException;
import java.io.IOException;
import java.io.InputStream;

public final class zzp
  extends InputStream
{
  private final InputStream zzbne;
  private volatile zzm zzbnf;
  
  public zzp(InputStream paramInputStream)
  {
    this.zzbne = ((InputStream)zzx.zzy(paramInputStream));
  }
  
  private int zzlt(int paramInt)
    throws ChannelIOException
  {
    if (paramInt == -1)
    {
      zzm localzzm = this.zzbnf;
      if (localzzm != null) {
        throw new ChannelIOException("Channel closed unexpectedly before stream was finished", localzzm.zzbmV, localzzm.zzbmW);
      }
    }
    return paramInt;
  }
  
  public int available()
    throws IOException
  {
    return this.zzbne.available();
  }
  
  public void close()
    throws IOException
  {
    this.zzbne.close();
  }
  
  public void mark(int paramInt)
  {
    this.zzbne.mark(paramInt);
  }
  
  public boolean markSupported()
  {
    return this.zzbne.markSupported();
  }
  
  public int read()
    throws IOException
  {
    return zzlt(this.zzbne.read());
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return zzlt(this.zzbne.read(paramArrayOfByte));
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return zzlt(this.zzbne.read(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public void reset()
    throws IOException
  {
    this.zzbne.reset();
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    return this.zzbne.skip(paramLong);
  }
  
  zzu zzGL()
  {
    new zzu()
    {
      public void zzb(zzm paramAnonymouszzm)
      {
        zzp.this.zza(paramAnonymouszzm);
      }
    };
  }
  
  void zza(zzm paramzzm)
  {
    this.zzbnf = ((zzm)zzx.zzy(paramzzm));
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */