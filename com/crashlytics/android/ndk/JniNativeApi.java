package com.crashlytics.android.ndk;

import android.content.res.AssetManager;

class JniNativeApi
  implements NativeApi
{
  static
  {
    System.loadLibrary("crashlytics");
  }
  
  private native boolean nativeInit(String paramString, Object paramObject);
  
  public boolean initialize(String paramString, AssetManager paramAssetManager)
  {
    return nativeInit(paramString, paramAssetManager);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/crashlytics/android/ndk/JniNativeApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */