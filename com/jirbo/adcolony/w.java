package com.jirbo.adcolony;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

class w
  extends InputStream
{
  InputStream a;
  byte[] b = new byte['Ѐ'];
  int c;
  int d;
  int e;
  int f;
  int g;
  int h;
  
  w(String paramString)
    throws IOException
  {
    if (a.n != 0)
    {
      this.h = 23;
      this.g = 23;
    }
    this.c = ((int)new File(paramString).length());
    this.a = new FileInputStream(paramString);
  }
  
  void a()
    throws IOException
  {
    for (this.e = 0; this.e == 0; this.e = this.a.read(this.b, 0, 1024)) {}
    int i = 0;
    while (i < this.e)
    {
      this.b[i] = ((byte)(this.b[i] ^ this.g));
      this.g += this.h;
      i += 1;
    }
    this.f = 0;
  }
  
  public int available()
    throws IOException
  {
    return this.e - this.f + this.a.available();
  }
  
  public void close()
    throws IOException
  {
    this.a.close();
  }
  
  public void mark(int paramInt) {}
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
    throws IOException
  {
    if (this.d == this.c) {
      return -1;
    }
    if (this.f >= this.e) {
      a();
    }
    this.d += 1;
    byte[] arrayOfByte = this.b;
    int i = this.f;
    this.f = (i + 1);
    return arrayOfByte[i];
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.d == this.c) {
      return -1;
    }
    int j = this.c - this.d;
    int i = paramInt2;
    if (paramInt2 > j) {
      i = j;
    }
    j = 0;
    paramInt2 = i;
    i = j;
    while (paramInt2 > 0)
    {
      if (this.f == this.e) {
        a();
      }
      if (paramInt2 < this.e) {}
      for (j = paramInt2;; j = this.e)
      {
        int k = 0;
        while (k < j)
        {
          byte[] arrayOfByte = this.b;
          int m = this.f;
          this.f = (m + 1);
          paramArrayOfByte[paramInt1] = arrayOfByte[m];
          k += 1;
          paramInt1 += 1;
        }
      }
      paramInt2 -= j;
      i += j;
      this.d = (j + this.d);
    }
    return i;
  }
  
  public void reset()
    throws IOException
  {
    throw new IOException("ADCStreamReader does not support reset().");
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    throw new IOException("ADCStreamReader does not support skip().");
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */