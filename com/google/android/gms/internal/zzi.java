package com.google.android.gms.internal;

import java.util.Map;

public class zzi
{
  public final byte[] data;
  public final int statusCode;
  public final Map<String, String> zzA;
  public final boolean zzB;
  public final long zzC;
  
  public zzi(int paramInt, byte[] paramArrayOfByte, Map<String, String> paramMap, boolean paramBoolean, long paramLong)
  {
    this.statusCode = paramInt;
    this.data = paramArrayOfByte;
    this.zzA = paramMap;
    this.zzB = paramBoolean;
    this.zzC = paramLong;
  }
  
  public zzi(byte[] paramArrayOfByte, Map<String, String> paramMap)
  {
    this(200, paramArrayOfByte, paramMap, false, 0L);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */