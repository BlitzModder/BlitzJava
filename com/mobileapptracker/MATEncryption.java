package com.mobileapptracker;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class MATEncryption
{
  private Cipher cipher;
  private IvParameterSpec ivspec;
  private SecretKeySpec keyspec;
  
  public MATEncryption(String paramString1, String paramString2)
  {
    this.ivspec = new IvParameterSpec(paramString2.getBytes());
    this.keyspec = new SecretKeySpec(paramString1.getBytes(), "AES");
    try
    {
      this.cipher = Cipher.getInstance("AES/CBC/NoPadding");
      return;
    }
    catch (NoSuchAlgorithmException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (NoSuchPaddingException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  private static String padString(String paramString)
  {
    int j = paramString.length();
    int i = 0;
    for (;;)
    {
      if (i >= 16 - j % 16) {
        return paramString;
      }
      paramString = paramString + ' ';
      i += 1;
    }
  }
  
  public byte[] decrypt(String paramString)
    throws Exception
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new Exception("Empty string");
    }
    try
    {
      this.cipher.init(2, this.keyspec, this.ivspec);
      paramString = this.cipher.doFinal(MATUtils.hexToBytes(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new Exception("[decrypt] " + paramString.getMessage());
    }
  }
  
  public byte[] encrypt(String paramString)
    throws Exception
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      throw new Exception("Empty string");
    }
    try
    {
      this.cipher.init(1, this.keyspec, this.ivspec);
      paramString = this.cipher.doFinal(padString(paramString).getBytes());
      return paramString;
    }
    catch (Exception paramString)
    {
      throw new Exception("[encrypt] " + paramString.getMessage());
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/mobileapptracker/MATEncryption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */