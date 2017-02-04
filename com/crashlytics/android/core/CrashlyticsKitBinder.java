package com.crashlytics.android.core;

import com.crashlytics.android.ndk.CrashlyticsNdk;

public class CrashlyticsKitBinder
{
  public void bindCrashEventDataProvider(CrashlyticsCore paramCrashlyticsCore, CrashlyticsNdk paramCrashlyticsNdk)
  {
    paramCrashlyticsCore.setExternalCrashEventDataProvider(paramCrashlyticsNdk);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/crashlytics/android/core/CrashlyticsKitBinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */