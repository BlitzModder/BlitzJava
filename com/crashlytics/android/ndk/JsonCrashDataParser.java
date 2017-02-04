package com.crashlytics.android.ndk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.crashlytics.android.core.internal.models.BinaryImageData;
import com.crashlytics.android.core.internal.models.CustomAttributeData;
import com.crashlytics.android.core.internal.models.DeviceData;
import com.crashlytics.android.core.internal.models.SessionEventData;
import com.crashlytics.android.core.internal.models.SignalData;
import com.crashlytics.android.core.internal.models.ThreadData;
import com.crashlytics.android.core.internal.models.ThreadData.FrameData;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class JsonCrashDataParser
{
  private static final String CUSTOM_KEY_JSON_SESSION = "json_session";
  private static final String DATA_DIR = "/data";
  private static final BinaryImageData[] EMPTY_BINARY_IMAGES = new BinaryImageData[0];
  private static final ThreadData.FrameData[] EMPTY_FRAMES = new ThreadData.FrameData[0];
  private static final ThreadData[] EMPTY_THREADS = new ThreadData[0];
  static final String KEY_AVAILABLE_INTERNAL_STORAGE = "available_internal_storage";
  static final String KEY_AVAILABLE_PHYSICAL_MEMORY = "available_physical_memory";
  static final String KEY_BATTERY_CAPACITY = "battery";
  static final String KEY_BATTERY_VELOCITY = "battery_velocity";
  static final String KEY_CRASHED = "crashed";
  static final String KEY_FRAMES = "frames";
  static final String KEY_MAPS = "maps";
  static final String KEY_ORIENTATION = "orientation";
  static final String KEY_PC = "pc";
  static final String KEY_PROXIMITY_ENABLED = "proximity_enabled";
  static final String KEY_SIG_CODE = "sig_code";
  static final String KEY_SIG_NAME = "sig_name";
  static final String KEY_SI_ADDR = "si_addr";
  static final String KEY_SYMBOL = "symbol";
  static final String KEY_THREADS = "threads";
  static final String KEY_THREAD_NAME = "name";
  static final String KEY_TIME = "time";
  static final String KEY_TOTAL_INTERNAL_STORAGE = "total_internal_storage";
  static final String KEY_TOTAL_PHYSICAL_MEMORY = "total_physical_memory";
  private static final String TAG = "JsonCrashDataParser";
  private final FileIdStrategy fileIdStrategy;
  
  public JsonCrashDataParser()
  {
    this(new Sha1FileIdStrategy());
  }
  
  JsonCrashDataParser(FileIdStrategy paramFileIdStrategy)
  {
    this.fileIdStrategy = paramFileIdStrategy;
  }
  
  private static File correctDataPath(File paramFile)
  {
    Object localObject = paramFile;
    if (paramFile.getAbsolutePath().startsWith("/data")) {}
    try
    {
      localObject = CrashlyticsNdk.getInstance().getContext();
      localObject = new File(((Context)localObject).getPackageManager().getApplicationInfo(((Context)localObject).getPackageName(), 0).nativeLibraryDir, paramFile.getName());
      return (File)localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Fabric.getLogger().e("JsonCrashDataParser", "Error getting ApplicationInfo", localNameNotFoundException);
    }
    return paramFile;
  }
  
  private static File getLibraryFile(String paramString)
  {
    File localFile = new File(paramString);
    paramString = localFile;
    if (!localFile.exists()) {
      paramString = correctDataPath(localFile);
    }
    return paramString;
  }
  
  public BinaryImageData[] parseBinaryImageData(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("maps");
    if (paramJSONObject == null) {
      return EMPTY_BINARY_IMAGES;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    if (i < paramJSONObject.length())
    {
      ProcMapEntry localProcMapEntry = ProcMapEntryParser.parse(paramJSONObject.optString(i));
      if (localProcMapEntry == null) {}
      for (;;)
      {
        i += 1;
        break;
        String str = localProcMapEntry.path;
        Object localObject = getLibraryFile(str);
        try
        {
          localObject = this.fileIdStrategy.getId((File)localObject);
          localLinkedList.add(new BinaryImageData(localProcMapEntry.address, localProcMapEntry.size, str, (String)localObject));
        }
        catch (IOException localIOException)
        {
          Fabric.getLogger().d("JsonCrashDataParser", "Could not generate ID for file " + localProcMapEntry.path, localIOException);
        }
      }
    }
    return (BinaryImageData[])localLinkedList.toArray(new BinaryImageData[localLinkedList.size()]);
  }
  
  public SessionEventData parseCrashEventData(String paramString)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject(paramString);
    return new SessionEventData(localJSONObject.optLong("time"), parseSignalData(localJSONObject), parseThreadData(localJSONObject), parseBinaryImageData(localJSONObject), parseCustomAttributes(paramString), parseDeviceData(localJSONObject));
  }
  
  public CustomAttributeData[] parseCustomAttributes(String paramString)
  {
    return new CustomAttributeData[] { new CustomAttributeData("json_session", paramString) };
  }
  
  public DeviceData parseDeviceData(JSONObject paramJSONObject)
  {
    return new DeviceData(paramJSONObject.optInt("orientation"), paramJSONObject.optLong("total_physical_memory"), paramJSONObject.optLong("total_internal_storage"), paramJSONObject.optLong("available_physical_memory"), paramJSONObject.optLong("available_internal_storage"), paramJSONObject.optInt("battery"), paramJSONObject.optInt("battery_velocity", 1), paramJSONObject.optBoolean("proximity_enabled", false));
  }
  
  public ThreadData.FrameData[] parseFrameData(JSONObject paramJSONObject, int paramInt)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("frames");
    if (localJSONArray == null) {
      paramJSONObject = EMPTY_FRAMES;
    }
    int j;
    ThreadData.FrameData[] arrayOfFrameData;
    int i;
    do
    {
      return paramJSONObject;
      j = localJSONArray.length();
      arrayOfFrameData = new ThreadData.FrameData[j];
      i = 0;
      paramJSONObject = arrayOfFrameData;
    } while (i >= j);
    paramJSONObject = localJSONArray.optJSONObject(i);
    long l = paramJSONObject.optLong("pc");
    paramJSONObject = paramJSONObject.optString("symbol");
    if (paramJSONObject == null) {
      paramJSONObject = "";
    }
    for (;;)
    {
      arrayOfFrameData[i] = new ThreadData.FrameData(l, paramJSONObject, "", 0L, paramInt);
      i += 1;
      break;
    }
  }
  
  public SignalData parseSignalData(JSONObject paramJSONObject)
  {
    return new SignalData(paramJSONObject.optString("sig_name", ""), paramJSONObject.optString("sig_code", ""), paramJSONObject.optLong("si_addr"));
  }
  
  public ThreadData[] parseThreadData(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("threads");
    if (localJSONArray == null) {
      paramJSONObject = EMPTY_THREADS;
    }
    int k;
    ThreadData[] arrayOfThreadData;
    int i;
    do
    {
      return paramJSONObject;
      k = localJSONArray.length();
      arrayOfThreadData = new ThreadData[k];
      i = 0;
      paramJSONObject = arrayOfThreadData;
    } while (i >= k);
    paramJSONObject = localJSONArray.optJSONObject(i);
    String str = paramJSONObject.optString("name");
    if (paramJSONObject.optBoolean("crashed")) {}
    for (int j = 4;; j = 0)
    {
      arrayOfThreadData[i] = new ThreadData(str, j, parseFrameData(paramJSONObject, j));
      i += 1;
      break;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/crashlytics/android/ndk/JsonCrashDataParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */