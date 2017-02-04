package com.crashlytics.android.ndk;

import io.fabric.sdk.android.services.common.CurrentTimeProvider;
import io.fabric.sdk.android.services.common.SystemCurrentTimeProvider;
import java.io.File;

class TimeBasedCrashFileManager
  implements CrashFileManager
{
  private static final String CRASHFILE_EXT = ".ndk.json";
  private static final File[] EMPTY_FILES = new File[0];
  private final File nativeCrashDirectory;
  private final CurrentTimeProvider timeProvider;
  
  public TimeBasedCrashFileManager(File paramFile)
  {
    this(paramFile, new SystemCurrentTimeProvider());
  }
  
  TimeBasedCrashFileManager(File paramFile, CurrentTimeProvider paramCurrentTimeProvider)
  {
    this.nativeCrashDirectory = paramFile;
    this.timeProvider = paramCurrentTimeProvider;
  }
  
  private File findLatestCrashFileByValue()
  {
    Object localObject = null;
    File[] arrayOfFile = getFiles();
    long l1 = 0L;
    int i = 0;
    while (i < arrayOfFile.length)
    {
      File localFile = arrayOfFile[i];
      long l3 = Long.parseLong(stripExtension(localFile.getName()));
      long l2 = l1;
      if (l3 > l1)
      {
        l2 = l3;
        localObject = localFile;
      }
      i += 1;
      l1 = l2;
    }
    return (File)localObject;
  }
  
  private File[] getFiles()
  {
    File[] arrayOfFile2 = this.nativeCrashDirectory.listFiles();
    File[] arrayOfFile1 = arrayOfFile2;
    if (arrayOfFile2 == null) {
      arrayOfFile1 = EMPTY_FILES;
    }
    return arrayOfFile1;
  }
  
  private String stripExtension(String paramString)
  {
    return paramString.substring(0, paramString.length() - ".ndk.json".length());
  }
  
  public void clearCrashFiles()
  {
    File[] arrayOfFile = getFiles();
    int j = arrayOfFile.length;
    int i = 0;
    while (i < j)
    {
      arrayOfFile[i].delete();
      i += 1;
    }
  }
  
  public File getLastWrittenCrashFile()
  {
    return findLatestCrashFileByValue();
  }
  
  public File getNewCrashFile()
  {
    String str = this.timeProvider.getCurrentTimeMillis() + ".ndk.json";
    return new File(this.nativeCrashDirectory, str);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/crashlytics/android/ndk/TimeBasedCrashFileManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */