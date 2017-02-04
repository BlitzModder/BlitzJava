package com.crashlytics.android.ndk;

import android.content.Context;
import com.crashlytics.android.core.CrashlyticsCore;
import com.crashlytics.android.core.CrashlyticsKitBinder;
import com.crashlytics.android.core.internal.CrashEventDataProvider;
import com.crashlytics.android.core.internal.models.SessionEventData;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.concurrency.UnmetDependencyException;
import io.fabric.sdk.android.services.persistence.FileStoreImpl;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;

public class CrashlyticsNdk
  extends Kit<Void>
  implements CrashEventDataProvider
{
  private static final String TAG = "CrashlyticsNdk";
  private final JsonCrashDataParser crashDataParser;
  private CrashFileManager crashFileManager;
  SessionEventData lastCrashEventData;
  private final NativeApi nativeApi;
  
  public CrashlyticsNdk()
  {
    this(new JniNativeApi());
  }
  
  CrashlyticsNdk(NativeApi paramNativeApi)
  {
    this.nativeApi = paramNativeApi;
    this.crashDataParser = new JsonCrashDataParser();
  }
  
  public static CrashlyticsNdk getInstance()
  {
    return (CrashlyticsNdk)Fabric.getKit(CrashlyticsNdk.class);
  }
  
  private File getKitStorageDirectory()
  {
    return new FileStoreImpl(this).getFilesDir();
  }
  
  /* Error */
  private String readJsonCrashFile(File paramFile)
  {
    // Byte code:
    //   0: invokestatic 63	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   3: ldc 11
    //   5: ldc 65
    //   7: invokeinterface 71 3 0
    //   12: aconst_null
    //   13: astore_2
    //   14: aconst_null
    //   15: astore_3
    //   16: new 73	java/io/FileInputStream
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 76	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore_1
    //   25: aload_1
    //   26: invokestatic 82	io/fabric/sdk/android/services/common/CommonUtils:streamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   29: astore_2
    //   30: aload_1
    //   31: ldc 84
    //   33: invokestatic 88	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   36: aload_2
    //   37: areturn
    //   38: astore_2
    //   39: aload_3
    //   40: astore_1
    //   41: aload_2
    //   42: astore_3
    //   43: aload_1
    //   44: astore_2
    //   45: invokestatic 63	io/fabric/sdk/android/Fabric:getLogger	()Lio/fabric/sdk/android/Logger;
    //   48: ldc 11
    //   50: ldc 90
    //   52: aload_3
    //   53: invokeinterface 94 4 0
    //   58: aload_1
    //   59: ldc 84
    //   61: invokestatic 88	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   64: aconst_null
    //   65: areturn
    //   66: astore_1
    //   67: aload_2
    //   68: ldc 84
    //   70: invokestatic 88	io/fabric/sdk/android/services/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   73: aload_1
    //   74: athrow
    //   75: astore_3
    //   76: aload_1
    //   77: astore_2
    //   78: aload_3
    //   79: astore_1
    //   80: goto -13 -> 67
    //   83: astore_3
    //   84: goto -41 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	87	0	this	CrashlyticsNdk
    //   0	87	1	paramFile	File
    //   13	24	2	str	String
    //   38	4	2	localException1	Exception
    //   44	34	2	localFile	File
    //   15	38	3	localException2	Exception
    //   75	4	3	localObject	Object
    //   83	1	3	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   16	25	38	java/lang/Exception
    //   16	25	66	finally
    //   45	58	66	finally
    //   25	30	75	finally
    //   25	30	83	java/lang/Exception
  }
  
  protected Void doInBackground()
  {
    Object localObject = this.crashFileManager.getLastWrittenCrashFile();
    if ((localObject != null) && (((File)localObject).exists()))
    {
      Fabric.getLogger().d("CrashlyticsNdk", "Found NDK crash file...");
      localObject = readJsonCrashFile((File)localObject);
      if (localObject == null) {}
    }
    try
    {
      this.lastCrashEventData = this.crashDataParser.parseCrashEventData((String)localObject);
      this.crashFileManager.clearCrashFiles();
      return null;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Fabric.getLogger().e("CrashlyticsNdk", "Failed to parse NDK crash data.", localJSONException);
      }
    }
  }
  
  public SessionEventData getCrashEventData()
  {
    return this.lastCrashEventData;
  }
  
  public String getIdentifier()
  {
    return "com.crashlytics.sdk.android.crashlytics-ndk";
  }
  
  public String getVersion()
  {
    return "1.1.1.74";
  }
  
  protected boolean onPreExecute()
  {
    if (Fabric.getKit(CrashlyticsCore.class) == null) {
      throw new UnmetDependencyException("CrashlyticsNdk requires Crashlytics");
    }
    return onPreExecute(new TimeBasedCrashFileManager(getKitStorageDirectory()), CrashlyticsCore.getInstance(), new CrashlyticsKitBinder());
  }
  
  boolean onPreExecute(CrashFileManager paramCrashFileManager, CrashlyticsCore paramCrashlyticsCore, CrashlyticsKitBinder paramCrashlyticsKitBinder)
  {
    this.crashFileManager = paramCrashFileManager;
    boolean bool1 = false;
    try
    {
      paramCrashFileManager = paramCrashFileManager.getNewCrashFile().getCanonicalPath();
      boolean bool2 = this.nativeApi.initialize(paramCrashFileManager, getContext().getAssets());
      bool1 = bool2;
    }
    catch (IOException paramCrashFileManager)
    {
      for (;;)
      {
        Fabric.getLogger().e("CrashlyticsNdk", "Error initializing CrashlyticsNdk", paramCrashFileManager);
      }
    }
    if (bool1)
    {
      paramCrashlyticsKitBinder.bindCrashEventDataProvider(paramCrashlyticsCore, this);
      Fabric.getLogger().d("CrashlyticsNdk", "Crashlytics NDK initialization successful");
    }
    return bool1;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/crashlytics/android/ndk/CrashlyticsNdk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */