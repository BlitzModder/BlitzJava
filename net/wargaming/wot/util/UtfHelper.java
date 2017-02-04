package net.wargaming.wot.util;

import java.io.UnsupportedEncodingException;

public final class UtfHelper
{
  public static String fromUtf8(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = new String(paramArrayOfByte, "UTF-8");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte) {}
    return null;
  }
  
  public static byte[] toUtf8(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return null;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/net/wargaming/wot/util/UtfHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */