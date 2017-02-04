package com.chartboost.sdk.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;

public class bt
{
  public static final BigInteger a = BigInteger.valueOf(1024L);
  public static final BigInteger b = a.multiply(a);
  public static final BigInteger c = a.multiply(b);
  public static final BigInteger d = a.multiply(c);
  public static final BigInteger e = a.multiply(d);
  public static final BigInteger f = a.multiply(e);
  public static final BigInteger g = BigInteger.valueOf(1024L).multiply(BigInteger.valueOf(1152921504606846976L));
  public static final BigInteger h = a.multiply(g);
  public static final File[] i = new File[0];
  private static final Charset j = Charset.forName("UTF-8");
  
  public static FileInputStream a(File paramFile)
    throws IOException
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      }
      if (!paramFile.canRead()) {
        throw new IOException("File '" + paramFile + "' cannot be read");
      }
    }
    else
    {
      throw new FileNotFoundException("File '" + paramFile + "' does not exist");
    }
    return new FileInputStream(paramFile);
  }
  
  public static FileOutputStream a(File paramFile, boolean paramBoolean)
    throws IOException
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory()) {
        throw new IOException("File '" + paramFile + "' exists but is a directory");
      }
      if (!paramFile.canWrite()) {
        throw new IOException("File '" + paramFile + "' cannot be written to");
      }
    }
    else
    {
      File localFile = paramFile.getParentFile();
      if ((localFile != null) && (!localFile.mkdirs()) && (!localFile.isDirectory())) {
        throw new IOException("Directory '" + localFile + "' could not be created");
      }
    }
    return new FileOutputStream(paramFile, paramBoolean);
  }
  
  public static void a(File paramFile, byte[] paramArrayOfByte)
    throws IOException
  {
    a(paramFile, paramArrayOfByte, false);
  }
  
  public static void a(File paramFile, byte[] paramArrayOfByte, boolean paramBoolean)
    throws IOException
  {
    File localFile = null;
    try
    {
      paramFile = a(paramFile, paramBoolean);
      localFile = paramFile;
      paramFile.write(paramArrayOfByte);
      localFile = paramFile;
      paramFile.close();
      return;
    }
    finally
    {
      bu.a(localFile);
    }
  }
  
  public static byte[] b(File paramFile)
    throws IOException
  {
    Object localObject = null;
    try
    {
      FileInputStream localFileInputStream = a(paramFile);
      localObject = localFileInputStream;
      paramFile = bu.a(localFileInputStream, paramFile.length());
      bu.a(localFileInputStream);
      return paramFile;
    }
    finally
    {
      bu.a((InputStream)localObject);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/bt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */