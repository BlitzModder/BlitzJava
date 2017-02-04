package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzx;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class zzb<T>
  implements Iterator<T>
{
  protected final DataBuffer<T> zzaht;
  protected int zzahu;
  
  public zzb(DataBuffer<T> paramDataBuffer)
  {
    this.zzaht = ((DataBuffer)zzx.zzy(paramDataBuffer));
    this.zzahu = -1;
  }
  
  public boolean hasNext()
  {
    return this.zzahu < this.zzaht.getCount() - 1;
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException("Cannot advance the iterator beyond " + this.zzahu);
    }
    DataBuffer localDataBuffer = this.zzaht;
    int i = this.zzahu + 1;
    this.zzahu = i;
    return (T)localDataBuffer.get(i);
  }
  
  public void remove()
  {
    throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/data/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */