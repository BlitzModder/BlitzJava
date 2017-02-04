package com.crashlytics.android.ndk;

import java.io.File;

abstract interface CrashFileManager
{
  public abstract void clearCrashFiles();
  
  public abstract File getLastWrittenCrashFile();
  
  public abstract File getNewCrashFile();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/crashlytics/android/ndk/CrashFileManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */