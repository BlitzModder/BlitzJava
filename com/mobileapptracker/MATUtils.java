package com.mobileapptracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MATUtils
{
  public static String bytesToHex(byte[] paramArrayOfByte)
  {
    Object localObject;
    if (paramArrayOfByte == null) {
      localObject = null;
    }
    int j;
    int i;
    do
    {
      return (String)localObject;
      j = paramArrayOfByte.length;
      str = "";
      i = 0;
      localObject = str;
    } while (i >= j);
    if ((paramArrayOfByte[i] & 0xFF) < 16) {}
    for (String str = str + "0" + Integer.toHexString(paramArrayOfByte[i] & 0xFF);; str = str + Integer.toHexString(paramArrayOfByte[i] & 0xFF))
    {
      i += 1;
      break;
    }
  }
  
  public static boolean getBooleanFromSharedPreferences(Context paramContext, String paramString)
  {
    boolean bool1 = false;
    try
    {
      boolean bool2 = paramContext.getSharedPreferences("com.mobileapptracking", 0).getBoolean(paramString, false);
      bool1 = bool2;
    }
    catch (ClassCastException paramContext)
    {
      for (;;)
      {
        paramContext = paramContext;
      }
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
    return bool1;
  }
  
  public static String getStringFromSharedPreferences(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getSharedPreferences("com.mobileapptracking", 0).getString(paramString, "");
      return paramContext;
    }
    catch (ClassCastException paramContext)
    {
      for (;;)
      {
        paramContext = paramContext;
        paramContext = "";
      }
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static byte[] hexToBytes(String paramString)
  {
    Object localObject = null;
    if (paramString == null) {}
    while (paramString.length() < 2) {
      return (byte[])localObject;
    }
    int j = paramString.length() / 2;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfByte;
      if (i >= j) {
        break;
      }
      arrayOfByte[i] = ((byte)Integer.parseInt(paramString.substring(i * 2, i * 2 + 2), 16));
      i += 1;
    }
  }
  
  public static String md5(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes());
      paramString = bytesToHex(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String readStream(InputStream paramInputStream)
    throws IOException, UnsupportedEncodingException
  {
    if (paramInputStream != null)
    {
      paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream, "UTF-8"));
      StringBuilder localStringBuilder = new StringBuilder();
      for (;;)
      {
        String str = paramInputStream.readLine();
        if (str == null)
        {
          paramInputStream.close();
          return localStringBuilder.toString();
        }
        localStringBuilder.append(str).append("\n");
      }
    }
    return "";
  }
  
  public static void saveToSharedPreferences(Context paramContext, String paramString1, String paramString2)
  {
    try
    {
      paramContext.getSharedPreferences("com.mobileapptracking", 0).edit().putString(paramString1, paramString2).commit();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static void saveToSharedPreferences(Context paramContext, String paramString, boolean paramBoolean)
  {
    try
    {
      paramContext.getSharedPreferences("com.mobileapptracking", 0).edit().putBoolean(paramString, paramBoolean).commit();
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public static String sha1(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-1");
      localMessageDigest.update(paramString.getBytes());
      paramString = bytesToHex(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String sha256(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
      localMessageDigest.update(paramString.getBytes());
      paramString = bytesToHex(localMessageDigest.digest());
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/mobileapptracker/MATUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */