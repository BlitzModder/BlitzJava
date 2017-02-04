package com.chartboost.sdk.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ab
  extends ByteArrayOutputStream
{
  private final v a;
  
  public ab(v paramv, int paramInt)
  {
    this.a = paramv;
    this.buf = this.a.a(Math.max(paramInt, 256));
  }
  
  private void a(int paramInt)
  {
    if (this.count + paramInt <= this.buf.length) {
      return;
    }
    byte[] arrayOfByte = this.a.a((this.count + paramInt) * 2);
    System.arraycopy(this.buf, 0, arrayOfByte, 0, this.count);
    this.a.a(this.buf);
    this.buf = arrayOfByte;
  }
  
  public void close()
    throws IOException
  {
    this.a.a(this.buf);
    this.buf = null;
    super.close();
  }
  
  public void finalize()
  {
    this.a.a(this.buf);
  }
  
  public void write(int paramInt)
  {
    try
    {
      a(1);
      super.write(paramInt);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      a(paramInt2);
      super.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    finally
    {
      paramArrayOfByte = finally;
      throw paramArrayOfByte;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */