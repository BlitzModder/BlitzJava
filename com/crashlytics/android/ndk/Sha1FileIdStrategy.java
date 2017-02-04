package com.crashlytics.android.ndk;

import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class Sha1FileIdStrategy
  implements FileIdStrategy
{
  private static String getFileSHA(String paramString)
    throws IOException
  {
    Object localObject3 = null;
    try
    {
      paramString = new BufferedInputStream(new FileInputStream(paramString));
      String str;
      CommonUtils.closeQuietly(paramString);
    }
    finally
    {
      try
      {
        str = CommonUtils.sha1(paramString);
        CommonUtils.closeQuietly(paramString);
        return str;
      }
      finally {}
      localObject1 = finally;
      paramString = (String)localObject3;
    }
    throw ((Throwable)localObject1);
  }
  
  public String getId(File paramFile)
    throws IOException
  {
    return getFileSHA(paramFile.getPath());
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/crashlytics/android/ndk/Sha1FileIdStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */