package com.dava.framework;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.util.Log;
import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.TimeZone;

public class JNIDeviceInfo
{
  private static final int MaxSignalLevel = 100;
  private static final int NETWORK_TYPE_BLUETOOTH = 6;
  private static final int NETWORK_TYPE_ETHERNET = 5;
  private static final int NETWORK_TYPE_MOBILE = 2;
  private static final int NETWORK_TYPE_NOT_CONNECTED = 0;
  private static final int NETWORK_TYPE_UNKNOWN = 1;
  private static final int NETWORK_TYPE_WIFI = 3;
  private static final int NETWORK_TYPE_WIMAX = 4;
  static final String TAG = "JNIDeviceInfo";
  
  public static String GetHTTPNonProxyHosts()
  {
    return System.getProperty("http.nonProxyHosts");
  }
  
  public static String GetHTTPProxyHost()
  {
    return System.getProperty("http.proxyHost");
  }
  
  public static int GetHTTPProxyPort()
  {
    String str = System.getProperty("http.proxyPort");
    if (str != null) {}
    for (;;)
    {
      return Integer.parseInt(str);
      str = "-1";
    }
  }
  
  public static StorageInfo GetInternalStorageInfo()
  {
    String str = Environment.getDataDirectory().getPath();
    str = str + "/";
    StorageCapacity localStorageCapacity = getCapacityAndFreeSpace(str);
    return new StorageInfo(str, false, false, false, localStorageCapacity.capacity, localStorageCapacity.free);
  }
  
  public static String GetLocale()
  {
    return Locale.getDefault().getDisplayLanguage(Locale.US);
  }
  
  public static String GetManufacturer()
  {
    return Build.MANUFACTURER;
  }
  
  public static String GetModel()
  {
    return Build.MODEL;
  }
  
  public static String GetName()
  {
    String str2 = Build.SERIAL;
    String str1;
    if (str2 != null)
    {
      str1 = str2;
      if (!str2.isEmpty()) {}
    }
    else
    {
      str1 = "ErrorGetSerialNumber";
    }
    return str1;
  }
  
  public static int GetNetworkType()
  {
    NetworkInfo localNetworkInfo = ((ConnectivityManager)JNIActivity.GetActivity().getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo == null) || (!localNetworkInfo.isConnected())) {
      return 0;
    }
    switch (localNetworkInfo.getType())
    {
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 8: 
    default: 
      return 1;
    case 0: 
      return 2;
    case 1: 
      return 3;
    case 6: 
      return 4;
    case 9: 
      return 5;
    }
    return 6;
  }
  
  public static StorageInfo GetPrimaryExternalStorageInfo()
  {
    if (IsPrimaryExternalStoragePresent())
    {
      Object localObject = JNIActivity.GetActivity().getApplicationContext().getExternalFilesDir(null);
      if (localObject != null)
      {
        localObject = ((File)localObject).getPath();
        localObject = (String)localObject + "/";
        try
        {
          StorageCapacity localStorageCapacity = getCapacityAndFreeSpace((String)localObject);
          boolean bool1 = Environment.isExternalStorageRemovable();
          boolean bool2 = Environment.isExternalStorageEmulated();
          localObject = new StorageInfo((String)localObject, Environment.getExternalStorageState().equals("mounted_ro"), bool1, bool2, localStorageCapacity.capacity, localStorageCapacity.free);
          return (StorageInfo)localObject;
        }
        catch (RuntimeException localRuntimeException)
        {
          Log.e("JNIDeviceInfo", "no permission to get capacity and free space(READ_EXTERNAL_STORAGE): " + localRuntimeException.toString());
        }
      }
    }
    return new StorageInfo("", false, false, false, -1L, -1L);
  }
  
  public static String GetRegion()
  {
    return JNIActivity.GetActivity().getResources().getConfiguration().locale.getCountry();
  }
  
  /* Error */
  public static StorageInfo[] GetSecondaryExternalStoragesList()
  {
    // Byte code:
    //   0: new 239	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 240	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: new 242	java/util/HashSet
    //   12: dup
    //   13: invokespecial 243	java/util/HashSet:<init>	()V
    //   16: astore 6
    //   18: aload 6
    //   20: invokestatic 246	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   23: invokevirtual 76	java/io/File:getPath	()Ljava/lang/String;
    //   26: invokevirtual 249	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   29: pop
    //   30: aconst_null
    //   31: astore_3
    //   32: aconst_null
    //   33: astore_1
    //   34: aconst_null
    //   35: astore 4
    //   37: new 251	java/io/BufferedReader
    //   40: dup
    //   41: new 253	java/io/FileReader
    //   44: dup
    //   45: ldc -1
    //   47: invokespecial 258	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   50: invokespecial 261	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   53: astore_2
    //   54: aload_2
    //   55: invokevirtual 264	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   58: astore_1
    //   59: aload_1
    //   60: ifnull +284 -> 344
    //   63: aload_1
    //   64: ldc_w 266
    //   67: invokevirtual 270	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   70: ifne -16 -> 54
    //   73: aload_1
    //   74: ldc_w 272
    //   77: invokevirtual 270	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   80: ifne -26 -> 54
    //   83: aload_1
    //   84: ldc_w 274
    //   87: invokevirtual 270	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   90: ifne -36 -> 54
    //   93: aload_1
    //   94: ldc_w 276
    //   97: invokevirtual 270	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   100: ifne -46 -> 54
    //   103: aload_1
    //   104: ldc_w 278
    //   107: invokevirtual 270	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   110: ifne -56 -> 54
    //   113: aload_1
    //   114: ldc_w 280
    //   117: invokevirtual 270	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   120: ifne -66 -> 54
    //   123: new 282	java/util/StringTokenizer
    //   126: dup
    //   127: aload_1
    //   128: ldc_w 284
    //   131: invokespecial 287	java/util/StringTokenizer:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: astore_1
    //   135: aload_1
    //   136: invokevirtual 290	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
    //   139: pop
    //   140: aload_1
    //   141: invokevirtual 290	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
    //   144: astore_3
    //   145: aload 6
    //   147: aload_3
    //   148: invokevirtual 292	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   151: ifne -97 -> 54
    //   154: aload_1
    //   155: invokevirtual 290	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
    //   158: astore 4
    //   160: aload_1
    //   161: invokevirtual 290	java/util/StringTokenizer:nextToken	()Ljava/lang/String;
    //   164: ldc_w 294
    //   167: invokevirtual 298	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   170: invokestatic 304	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   173: ldc_w 306
    //   176: invokeinterface 309 2 0
    //   181: istore_0
    //   182: aload 4
    //   184: ldc_w 311
    //   187: invokevirtual 197	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   190: ifne +23 -> 213
    //   193: aload_3
    //   194: ldc_w 313
    //   197: invokevirtual 317	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   200: ifne +13 -> 213
    //   203: aload_3
    //   204: ldc_w 319
    //   207: invokevirtual 317	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   210: ifeq -156 -> 54
    //   213: new 78	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 79	java/lang/StringBuilder:<init>	()V
    //   220: aload_3
    //   221: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: ldc 85
    //   226: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: astore_1
    //   233: aload 6
    //   235: aload_1
    //   236: invokevirtual 249	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   239: pop
    //   240: new 321	android/os/StatFs
    //   243: dup
    //   244: aload_1
    //   245: invokespecial 322	android/os/StatFs:<init>	(Ljava/lang/String;)V
    //   248: astore_3
    //   249: new 8	com/dava/framework/JNIDeviceInfo$StorageCapacity
    //   252: dup
    //   253: aconst_null
    //   254: invokespecial 325	com/dava/framework/JNIDeviceInfo$StorageCapacity:<init>	(Lcom/dava/framework/JNIDeviceInfo$1;)V
    //   257: astore 4
    //   259: aload_3
    //   260: aload 4
    //   262: invokestatic 329	com/dava/framework/JNIDeviceInfo:fillCapacityAndFreeSpace	(Landroid/os/StatFs;Lcom/dava/framework/JNIDeviceInfo$StorageCapacity;)V
    //   265: aload 5
    //   267: new 11	com/dava/framework/JNIDeviceInfo$StorageInfo
    //   270: dup
    //   271: aload_1
    //   272: iload_0
    //   273: iconst_1
    //   274: iconst_0
    //   275: aload 4
    //   277: getfield 96	com/dava/framework/JNIDeviceInfo$StorageCapacity:capacity	J
    //   280: aload 4
    //   282: getfield 99	com/dava/framework/JNIDeviceInfo$StorageCapacity:free	J
    //   285: invokespecial 102	com/dava/framework/JNIDeviceInfo$StorageInfo:<init>	(Ljava/lang/String;ZZZJJ)V
    //   288: invokeinterface 330 2 0
    //   293: pop
    //   294: goto -240 -> 54
    //   297: astore_3
    //   298: aload_2
    //   299: astore_1
    //   300: ldc 33
    //   302: aload_3
    //   303: invokevirtual 333	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   306: invokestatic 206	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   309: pop
    //   310: aload_2
    //   311: ifnull +7 -> 318
    //   314: aload_2
    //   315: invokevirtual 336	java/io/BufferedReader:close	()V
    //   318: aload 5
    //   320: invokeinterface 339 1 0
    //   325: anewarray 11	com/dava/framework/JNIDeviceInfo$StorageInfo
    //   328: astore_1
    //   329: aload 5
    //   331: aload_1
    //   332: invokeinterface 343 2 0
    //   337: pop
    //   338: aload_1
    //   339: areturn
    //   340: astore_1
    //   341: goto -287 -> 54
    //   344: aload_2
    //   345: ifnull +124 -> 469
    //   348: aload_2
    //   349: invokevirtual 336	java/io/BufferedReader:close	()V
    //   352: goto -34 -> 318
    //   355: astore_1
    //   356: ldc 33
    //   358: aload_1
    //   359: invokevirtual 344	java/io/IOException:getMessage	()Ljava/lang/String;
    //   362: invokestatic 206	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   365: pop
    //   366: goto -48 -> 318
    //   369: astore_1
    //   370: ldc 33
    //   372: aload_1
    //   373: invokevirtual 344	java/io/IOException:getMessage	()Ljava/lang/String;
    //   376: invokestatic 206	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   379: pop
    //   380: goto -62 -> 318
    //   383: astore_1
    //   384: aload_3
    //   385: astore_2
    //   386: aload_1
    //   387: astore_3
    //   388: aload_2
    //   389: astore_1
    //   390: ldc 33
    //   392: aload_3
    //   393: invokevirtual 344	java/io/IOException:getMessage	()Ljava/lang/String;
    //   396: invokestatic 206	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   399: pop
    //   400: aload_2
    //   401: ifnull -83 -> 318
    //   404: aload_2
    //   405: invokevirtual 336	java/io/BufferedReader:close	()V
    //   408: goto -90 -> 318
    //   411: astore_1
    //   412: ldc 33
    //   414: aload_1
    //   415: invokevirtual 344	java/io/IOException:getMessage	()Ljava/lang/String;
    //   418: invokestatic 206	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   421: pop
    //   422: goto -104 -> 318
    //   425: astore_3
    //   426: aload_1
    //   427: astore_2
    //   428: aload_3
    //   429: astore_1
    //   430: aload_2
    //   431: ifnull +7 -> 438
    //   434: aload_2
    //   435: invokevirtual 336	java/io/BufferedReader:close	()V
    //   438: aload_1
    //   439: athrow
    //   440: astore_2
    //   441: ldc 33
    //   443: aload_2
    //   444: invokevirtual 344	java/io/IOException:getMessage	()Ljava/lang/String;
    //   447: invokestatic 206	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   450: pop
    //   451: goto -13 -> 438
    //   454: astore_1
    //   455: goto -25 -> 430
    //   458: astore_3
    //   459: goto -71 -> 388
    //   462: astore_3
    //   463: aload 4
    //   465: astore_2
    //   466: goto -168 -> 298
    //   469: goto -151 -> 318
    // Local variable table:
    //   start	length	slot	name	signature
    //   181	92	0	bool	boolean
    //   33	306	1	localObject1	Object
    //   340	1	1	localException	Exception
    //   355	4	1	localIOException1	java.io.IOException
    //   369	4	1	localIOException2	java.io.IOException
    //   383	4	1	localIOException3	java.io.IOException
    //   389	1	1	localObject2	Object
    //   411	16	1	localIOException4	java.io.IOException
    //   429	10	1	localObject3	Object
    //   454	1	1	localObject4	Object
    //   53	382	2	localObject5	Object
    //   440	4	2	localIOException5	java.io.IOException
    //   465	1	2	localObject6	Object
    //   31	229	3	localObject7	Object
    //   297	88	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   387	6	3	localObject8	Object
    //   425	4	3	localObject9	Object
    //   458	1	3	localIOException6	java.io.IOException
    //   462	1	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   35	429	4	localObject10	Object
    //   7	323	5	localArrayList	java.util.ArrayList
    //   16	218	6	localHashSet	java.util.HashSet
    // Exception table:
    //   from	to	target	type
    //   54	59	297	java/io/FileNotFoundException
    //   63	213	297	java/io/FileNotFoundException
    //   213	240	297	java/io/FileNotFoundException
    //   240	249	297	java/io/FileNotFoundException
    //   249	294	297	java/io/FileNotFoundException
    //   240	249	340	java/lang/Exception
    //   348	352	355	java/io/IOException
    //   314	318	369	java/io/IOException
    //   37	54	383	java/io/IOException
    //   404	408	411	java/io/IOException
    //   37	54	425	finally
    //   300	310	425	finally
    //   390	400	425	finally
    //   434	438	440	java/io/IOException
    //   54	59	454	finally
    //   63	213	454	finally
    //   213	240	454	finally
    //   240	249	454	finally
    //   249	294	454	finally
    //   54	59	458	java/io/IOException
    //   63	213	458	java/io/IOException
    //   213	240	458	java/io/IOException
    //   240	249	458	java/io/IOException
    //   249	294	458	java/io/IOException
    //   37	54	462	java/io/FileNotFoundException
  }
  
  public static int GetSignalStrength(int paramInt)
  {
    switch (paramInt)
    {
    case 4: 
    default: 
    case 3: 
    case 2: 
      do
      {
        return 0;
        return WifiManager.calculateSignalLevel(((WifiManager)JNIActivity.GetActivity().getSystemService("wifi")).getConnectionInfo().getRssi(), 100);
      } while (JNIActivity.singalStrengthListner == null);
      paramInt = JNIActivity.singalStrengthListner.GetSignalStrength();
      if (paramInt == 99) {
        return -1;
      }
      return (int)(paramInt * 100 / 31.0F);
    }
    return 100;
  }
  
  public static String GetTimeZone()
  {
    return TimeZone.getDefault().getID();
  }
  
  public static String GetUDID()
  {
    String str2 = Settings.Secure.getString(JNIActivity.GetActivity().getApplicationContext().getContentResolver(), "android_id");
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(str2.getBytes(), 0, str2.length());
      localObject = String.format("%040X", new Object[] { new BigInteger(1, ((MessageDigest)localObject).digest()) });
      return localObject.toString().toLowerCase();
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      for (;;)
      {
        String str1 = str2.substring(0, 32);
      }
    }
  }
  
  public static String GetVersion()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static int GetZBufferSize()
  {
    return JNIConfigChooser.GetDepthBufferSize();
  }
  
  public static boolean IsPrimaryExternalStoragePresent()
  {
    String str = Environment.getExternalStorageState();
    return (str.equals("mounted")) || (str.equals("mounted_ro"));
  }
  
  private static void fillCapacityAndFreeSpace(StatFs paramStatFs, StorageCapacity paramStorageCapacity)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramStorageCapacity.capacity = (paramStatFs.getBlockCountLong() * paramStatFs.getBlockSizeLong());
      paramStorageCapacity.free = (paramStatFs.getAvailableBlocksLong() * paramStatFs.getBlockSizeLong());
      return;
    }
    paramStorageCapacity.capacity = (paramStatFs.getBlockCount() * paramStatFs.getBlockSize());
    paramStorageCapacity.free = (paramStatFs.getAvailableBlocks() * paramStatFs.getBlockSize());
  }
  
  private static StorageCapacity getCapacityAndFreeSpace(String paramString)
  {
    paramString = new StatFs(paramString);
    StorageCapacity localStorageCapacity = new StorageCapacity(null);
    fillCapacityAndFreeSpace(paramString, localStorageCapacity);
    return localStorageCapacity;
  }
  
  private static class StorageCapacity
  {
    public long capacity = 0L;
    public long free = 0L;
  }
  
  public static class StorageInfo
  {
    public final long capacity;
    public final boolean emulated;
    public final long freeSpace;
    public final String path;
    public final boolean readOnly;
    public final boolean removable;
    
    StorageInfo(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong1, long paramLong2)
    {
      this.path = paramString;
      this.readOnly = paramBoolean1;
      this.removable = paramBoolean2;
      this.emulated = paramBoolean3;
      this.capacity = paramLong1;
      this.freeSpace = paramLong2;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/JNIDeviceInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */