package com.dava.framework;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.util.Log;
import java.io.File;
import java.util.Locale;

public class JNIApplication
  extends Application
{
  static JNIApplication app;
  public static Thread mainCPPThread;
  private final String TAG = "JNIApplication";
  private String externalDocumentsDir;
  private boolean firstLaunch = true;
  private String internalDocumentsDir;
  private Locale launchLocale;
  
  static
  {
    System.loadLibrary("fmodex");
    System.loadLibrary("fmodevent");
  }
  
  public static JNIApplication GetApplication()
  {
    return app;
  }
  
  private boolean IsApplicationShouldBeRestarted()
  {
    return !this.launchLocale.equals(Locale.getDefault());
  }
  
  private native void OnConfigurationChanged();
  
  private native void OnCreateApplication(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6);
  
  private native void OnLowMemoryWarning();
  
  private native void OnTerminate();
  
  public String GetDocumentPath()
  {
    return this.externalDocumentsDir;
  }
  
  public void InitFramework(String paramString)
  {
    if (this.firstLaunch)
    {
      ApplicationInfo localApplicationInfo = getApplicationInfo();
      Log.w(JNIConst.LOG_TAG, String.format("[Application::InitFramework] Create Application. apkFilePath is %s", new Object[] { localApplicationInfo.publicSourceDir }));
      OnCreateApplication(this.externalDocumentsDir, this.internalDocumentsDir, localApplicationInfo.publicSourceDir, JNIConst.LOG_TAG, localApplicationInfo.packageName, paramString);
      this.firstLaunch = false;
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    Log.i(JNIConst.LOG_TAG, "[Application::onConfigurationChanged]");
    super.onConfigurationChanged(paramConfiguration);
    OnConfigurationChanged();
    if (IsApplicationShouldBeRestarted())
    {
      Log.w(JNIConst.LOG_TAG, "[Application::onConfigurationChanged] Application should now be closed");
      System.exit(0);
    }
  }
  
  public void onCreate()
  {
    app = this;
    super.onCreate();
    Log.i(JNIConst.LOG_TAG, "[Application::onCreate] start");
    JNINotificationProvider.Init();
    if (getExternalFilesDir(null) != null) {}
    for (this.externalDocumentsDir = (getExternalFilesDir(null).getAbsolutePath() + "/");; this.externalDocumentsDir = "")
    {
      this.internalDocumentsDir = (getFilesDir().getAbsolutePath() + "/");
      this.launchLocale = Locale.getDefault();
      Log.i(JNIConst.LOG_TAG, "[Application::onCreate] finish");
      return;
    }
  }
  
  public void onLowMemory()
  {
    Log.w(JNIConst.LOG_TAG, "[Application::onLowMemory]");
    OnLowMemoryWarning();
    super.onLowMemory();
  }
  
  public void onTerminate()
  {
    Log.w(JNIConst.LOG_TAG, "[Application::onTerminate]");
    super.onTerminate();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/JNIApplication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */