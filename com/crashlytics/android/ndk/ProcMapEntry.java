package com.crashlytics.android.ndk;

class ProcMapEntry
{
  public final long address;
  public final String path;
  public final long size;
  
  public ProcMapEntry(long paramLong1, long paramLong2, String paramString)
  {
    this.address = paramLong1;
    this.size = paramLong2;
    this.path = paramString;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/crashlytics/android/ndk/ProcMapEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */