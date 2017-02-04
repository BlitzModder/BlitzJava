package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class zzg<T>
  extends zzb<T>
{
  private T zzahQ;
  
  public zzg(DataBuffer<T> paramDataBuffer)
  {
    super(paramDataBuffer);
  }
  
  public T next()
  {
    if (!hasNext()) {
      throw new NoSuchElementException("Cannot advance the iterator beyond " + this.zzahu);
    }
    this.zzahu += 1;
    if (this.zzahu == 0)
    {
      this.zzahQ = this.zzaht.get(0);
      if (!(this.zzahQ instanceof zzc)) {
        throw new IllegalStateException("DataBuffer reference of type " + this.zzahQ.getClass() + " is not movable");
      }
    }
    else
    {
      ((zzc)this.zzahQ).zzbG(this.zzahu);
    }
    return (T)this.zzahQ;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/data/zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */