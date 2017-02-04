package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class zzbm
{
  private static MessageDigest zztd = null;
  protected Object zzpK = new Object();
  
  protected MessageDigest zzcG()
  {
    for (;;)
    {
      MessageDigest localMessageDigest;
      int i;
      synchronized (this.zzpK)
      {
        if (zztd != null)
        {
          localMessageDigest = zztd;
          return localMessageDigest;
        }
        i = 0;
        if (i >= 2) {}
      }
      try
      {
        zztd = MessageDigest.getInstance("MD5");
        i += 1;
        continue;
        localMessageDigest = zztd;
        return localMessageDigest;
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;) {}
      }
    }
  }
  
  abstract byte[] zzz(String paramString);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzbm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */