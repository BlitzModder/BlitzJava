package com.crashlytics.android.ndk;

import java.io.File;
import java.io.IOException;

abstract interface FileIdStrategy
{
  public abstract String getId(File paramFile)
    throws IOException;
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/crashlytics/android/ndk/FileIdStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */