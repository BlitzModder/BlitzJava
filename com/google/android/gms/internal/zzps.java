package com.google.android.gms.internal;

public class zzps
{
  private static final ThreadLocal<String> zzaxs = new ThreadLocal();
  
  public static String zzE(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return paramString1;
    }
    byte[] arrayOfByte = new byte[paramString1.length() + paramString2.length()];
    System.arraycopy(paramString1.getBytes(), 0, arrayOfByte, 0, paramString1.length());
    System.arraycopy(paramString2.getBytes(), 0, arrayOfByte, paramString1.length(), paramString2.length());
    return Integer.toHexString(zznw.zza(arrayOfByte, 0, arrayOfByte.length, 0));
  }
  
  public static String zzdr(String paramString)
  {
    if (zzue()) {
      return paramString;
    }
    return zzE(paramString, (String)zzaxs.get());
  }
  
  public static boolean zzue()
  {
    String str = (String)zzaxs.get();
    return (str == null) || (str.startsWith("com.google"));
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */