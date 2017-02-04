package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class zzth
  implements Cloneable
{
  private zztf<?, ?> zzbpX;
  private Object zzbpY;
  private List<zztm> zzbpZ = new ArrayList();
  
  private byte[] toByteArray()
    throws IOException
  {
    byte[] arrayOfByte = new byte[zzz()];
    writeTo(zztd.zzD(arrayOfByte));
    return arrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramObject == this) {
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramObject instanceof zzth));
      paramObject = (zzth)paramObject;
      if ((this.zzbpY == null) || (((zzth)paramObject).zzbpY == null)) {
        break;
      }
      bool1 = bool2;
    } while (this.zzbpX != ((zzth)paramObject).zzbpX);
    if (!this.zzbpX.zzbpR.isArray()) {
      return this.zzbpY.equals(((zzth)paramObject).zzbpY);
    }
    if ((this.zzbpY instanceof byte[])) {
      return Arrays.equals((byte[])this.zzbpY, (byte[])((zzth)paramObject).zzbpY);
    }
    if ((this.zzbpY instanceof int[])) {
      return Arrays.equals((int[])this.zzbpY, (int[])((zzth)paramObject).zzbpY);
    }
    if ((this.zzbpY instanceof long[])) {
      return Arrays.equals((long[])this.zzbpY, (long[])((zzth)paramObject).zzbpY);
    }
    if ((this.zzbpY instanceof float[])) {
      return Arrays.equals((float[])this.zzbpY, (float[])((zzth)paramObject).zzbpY);
    }
    if ((this.zzbpY instanceof double[])) {
      return Arrays.equals((double[])this.zzbpY, (double[])((zzth)paramObject).zzbpY);
    }
    if ((this.zzbpY instanceof boolean[])) {
      return Arrays.equals((boolean[])this.zzbpY, (boolean[])((zzth)paramObject).zzbpY);
    }
    return Arrays.deepEquals((Object[])this.zzbpY, (Object[])((zzth)paramObject).zzbpY);
    if ((this.zzbpZ != null) && (((zzth)paramObject).zzbpZ != null)) {
      return this.zzbpZ.equals(((zzth)paramObject).zzbpZ);
    }
    try
    {
      bool1 = Arrays.equals(toByteArray(), ((zzth)paramObject).toByteArray());
      return bool1;
    }
    catch (IOException paramObject)
    {
      throw new IllegalStateException((Throwable)paramObject);
    }
  }
  
  public int hashCode()
  {
    try
    {
      int i = Arrays.hashCode(toByteArray());
      return i + 527;
    }
    catch (IOException localIOException)
    {
      throw new IllegalStateException(localIOException);
    }
  }
  
  void writeTo(zztd paramzztd)
    throws IOException
  {
    if (this.zzbpY != null) {
      this.zzbpX.zza(this.zzbpY, paramzztd);
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.zzbpZ.iterator();
      while (localIterator.hasNext()) {
        ((zztm)localIterator.next()).writeTo(paramzztd);
      }
    }
  }
  
  public final zzth zzHB()
  {
    int i = 0;
    zzth localzzth = new zzth();
    try
    {
      localzzth.zzbpX = this.zzbpX;
      if (this.zzbpZ == null) {
        localzzth.zzbpZ = null;
      }
      while (this.zzbpY == null)
      {
        return localzzth;
        localzzth.zzbpZ.addAll(this.zzbpZ);
      }
      if (!(this.zzbpY instanceof zztk)) {
        break label92;
      }
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
    localCloneNotSupportedException.zzbpY = ((zztk)this.zzbpY).clone();
    return localCloneNotSupportedException;
    label92:
    if ((this.zzbpY instanceof byte[]))
    {
      localCloneNotSupportedException.zzbpY = ((byte[])this.zzbpY).clone();
      return localCloneNotSupportedException;
    }
    Object localObject1;
    Object localObject2;
    if ((this.zzbpY instanceof byte[][]))
    {
      localObject1 = (byte[][])this.zzbpY;
      localObject2 = new byte[localObject1.length][];
      localCloneNotSupportedException.zzbpY = localObject2;
      i = 0;
      while (i < localObject1.length)
      {
        localObject2[i] = ((byte[])localObject1[i].clone());
        i += 1;
      }
    }
    if ((this.zzbpY instanceof boolean[]))
    {
      localCloneNotSupportedException.zzbpY = ((boolean[])this.zzbpY).clone();
      return localCloneNotSupportedException;
    }
    if ((this.zzbpY instanceof int[]))
    {
      localCloneNotSupportedException.zzbpY = ((int[])this.zzbpY).clone();
      return localCloneNotSupportedException;
    }
    if ((this.zzbpY instanceof long[]))
    {
      localCloneNotSupportedException.zzbpY = ((long[])this.zzbpY).clone();
      return localCloneNotSupportedException;
    }
    if ((this.zzbpY instanceof float[]))
    {
      localCloneNotSupportedException.zzbpY = ((float[])this.zzbpY).clone();
      return localCloneNotSupportedException;
    }
    if ((this.zzbpY instanceof double[]))
    {
      localCloneNotSupportedException.zzbpY = ((double[])this.zzbpY).clone();
      return localCloneNotSupportedException;
    }
    if ((this.zzbpY instanceof zztk[]))
    {
      localObject1 = (zztk[])this.zzbpY;
      localObject2 = new zztk[localObject1.length];
      localCloneNotSupportedException.zzbpY = localObject2;
      while (i < localObject1.length)
      {
        localObject2[i] = localObject1[i].clone();
        i += 1;
      }
    }
    return localCloneNotSupportedException;
  }
  
  void zza(zztm paramzztm)
  {
    this.zzbpZ.add(paramzztm);
  }
  
  <T> T zzb(zztf<?, T> paramzztf)
  {
    if (this.zzbpY != null)
    {
      if (this.zzbpX != paramzztf) {
        throw new IllegalStateException("Tried to getExtension with a differernt Extension.");
      }
    }
    else
    {
      this.zzbpX = paramzztf;
      this.zzbpY = paramzztf.zzG(this.zzbpZ);
      this.zzbpZ = null;
    }
    return (T)this.zzbpY;
  }
  
  int zzz()
  {
    int j;
    if (this.zzbpY != null)
    {
      j = this.zzbpX.zzY(this.zzbpY);
      return j;
    }
    Iterator localIterator = this.zzbpZ.iterator();
    for (int i = 0;; i = ((zztm)localIterator.next()).zzz() + i)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */