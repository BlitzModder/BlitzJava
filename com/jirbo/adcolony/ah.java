package com.jirbo.adcolony;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class ah
{
  public static String a(String paramString)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
    localMessageDigest.update(paramString.getBytes("iso-8859-1"), 0, paramString.length());
    return a(localMessageDigest.digest());
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int m = paramArrayOfByte.length;
    int i = 0;
    int n;
    int j;
    int k;
    if (i < m)
    {
      n = paramArrayOfByte[i];
      j = n >>> 4 & 0xF;
      k = 0;
    }
    for (;;)
    {
      if ((j >= 0) && (j <= 9)) {}
      for (char c = (char)(j + 48);; c = (char)(j - 10 + 97))
      {
        localStringBuilder.append(c);
        if (k < 1) {
          break label91;
        }
        i += 1;
        break;
      }
      return localStringBuilder.toString();
      label91:
      k += 1;
      j = n & 0xF;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/jirbo/adcolony/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */