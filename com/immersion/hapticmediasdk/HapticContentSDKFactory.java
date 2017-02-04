package com.immersion.hapticmediasdk;

import android.content.Context;
import com.immersion.content.EndpointWarp;
import com.immersion.hapticmediasdk.utils.Log;

public class HapticContentSDKFactory
{
  private static final String a = "HapticContentSDKFactory";
  
  public static HapticContentSDK GetNewSDKInstance(int paramInt, Context paramContext)
  {
    if (!EndpointWarp.loadSharedLibrary()) {
      return null;
    }
    if (paramContext == null)
    {
      Log.e("HapticContentSDKFactory", "Failed to create a Haptic Content SDK instance. invalid context: null");
      return null;
    }
    switch (paramInt)
    {
    default: 
      Log.e("HapticContentSDKFactory", "Failed to create a Haptic Content SDK instance. Invalid mode");
      return null;
    }
    paramContext = new MediaPlaybackSDK(paramContext);
    paramInt = paramContext.bц04460446ц04460446();
    if (paramInt != 0)
    {
      Log.e("HapticContentSDKFactory", "Failed to create Haptic Content SDK instance. error=" + paramInt);
      return null;
    }
    Log.i("HapticContentSDKFactory", "Haptic Content SDK instance was created successfully");
    return paramContext;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/immersion/hapticmediasdk/HapticContentSDKFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */