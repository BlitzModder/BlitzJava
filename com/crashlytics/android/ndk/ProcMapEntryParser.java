package com.crashlytics.android.ndk;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class ProcMapEntryParser
{
  private static final Pattern MAP_REGEX = Pattern.compile("\\s*(\\p{XDigit}+)-\\s*(\\p{XDigit}+)\\s+(.{4})\\s+\\p{XDigit}+\\s+.+\\s+\\d+\\s+(.+)");
  
  private static boolean isRelevant(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    return (paramString1.indexOf('x') != -1) && (paramString2.indexOf('/') != -1);
  }
  
  public static ProcMapEntry parse(String paramString)
  {
    Object localObject = MAP_REGEX.matcher(paramString);
    if (!((Matcher)localObject).matches()) {}
    long l1;
    long l2;
    do
    {
      return null;
      l1 = Long.valueOf(((Matcher)localObject).group(1), 16).longValue();
      l2 = Long.valueOf(((Matcher)localObject).group(2), 16).longValue() - l1;
      paramString = ((Matcher)localObject).group(3);
      localObject = ((Matcher)localObject).group(4);
    } while (!isRelevant(l1, l2, paramString, (String)localObject));
    return new ProcMapEntry(l1, l2, (String)localObject);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/crashlytics/android/ndk/ProcMapEntryParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */