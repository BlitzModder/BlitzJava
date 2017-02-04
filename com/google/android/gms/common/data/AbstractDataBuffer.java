package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T>
  implements DataBuffer<T>
{
  protected final DataHolder zzafC;
  
  protected AbstractDataBuffer(DataHolder paramDataHolder)
  {
    this.zzafC = paramDataHolder;
    if (this.zzafC != null) {
      this.zzafC.zzt(this);
    }
  }
  
  @Deprecated
  public final void close()
  {
    release();
  }
  
  public abstract T get(int paramInt);
  
  public int getCount()
  {
    if (this.zzafC == null) {
      return 0;
    }
    return this.zzafC.getCount();
  }
  
  @Deprecated
  public boolean isClosed()
  {
    return (this.zzafC == null) || (this.zzafC.isClosed());
  }
  
  public Iterator<T> iterator()
  {
    return new zzb(this);
  }
  
  public void release()
  {
    if (this.zzafC != null) {
      this.zzafC.close();
    }
  }
  
  public Iterator<T> singleRefIterator()
  {
    return new zzg(this);
  }
  
  public Bundle zzpH()
  {
    return this.zzafC.zzpH();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/data/AbstractDataBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */