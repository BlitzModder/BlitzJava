package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class zztm
{
  final int tag;
  final byte[] zzbqc;
  
  zztm(int paramInt, byte[] paramArrayOfByte)
  {
    this.tag = paramInt;
    this.zzbqc = paramArrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof zztm)) {
        return false;
      }
      paramObject = (zztm)paramObject;
    } while ((this.tag == ((zztm)paramObject).tag) && (Arrays.equals(this.zzbqc, ((zztm)paramObject).zzbqc)));
    return false;
  }
  
  public int hashCode()
  {
    return (this.tag + 527) * 31 + Arrays.hashCode(this.zzbqc);
  }
  
  void writeTo(zztd paramzztd)
    throws IOException
  {
    paramzztd.zzmy(this.tag);
    paramzztd.zzG(this.zzbqc);
  }
  
  int zzz()
  {
    return 0 + zztd.zzmz(this.tag) + this.zzbqc.length;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zztm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */