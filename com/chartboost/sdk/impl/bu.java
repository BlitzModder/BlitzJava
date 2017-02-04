package com.chartboost.sdk.impl;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

public class bu
{
  public static final char a = File.separatorChar;
  public static final String b;
  
  static
  {
    bv localbv = new bv(4);
    PrintWriter localPrintWriter = new PrintWriter(localbv);
    localPrintWriter.println();
    b = localbv.toString();
    localPrintWriter.close();
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable) {}
  }
  
  public static void a(InputStream paramInputStream)
  {
    a(paramInputStream);
  }
  
  public static void a(OutputStream paramOutputStream)
  {
    a(paramOutputStream);
  }
  
  public static byte[] a(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    int i = 0;
    if (paramInt < 0) {
      throw new IllegalArgumentException("Size must be equal or greater than zero: " + paramInt);
    }
    if (paramInt == 0) {
      paramInputStream = new byte[0];
    }
    do
    {
      return paramInputStream;
      byte[] arrayOfByte = new byte[paramInt];
      while (i < paramInt)
      {
        int j = paramInputStream.read(arrayOfByte, i, paramInt - i);
        if (j == -1) {
          break;
        }
        i += j;
      }
      paramInputStream = arrayOfByte;
    } while (i == paramInt);
    throw new IOException("Unexpected readed size. current: " + i + ", excepted: " + paramInt);
  }
  
  public static byte[] a(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    if (paramLong > 2147483647L) {
      throw new IllegalArgumentException("Size cannot be greater than Integer max value: " + paramLong);
    }
    return a(paramInputStream, (int)paramLong);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/bu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */