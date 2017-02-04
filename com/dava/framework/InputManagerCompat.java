package com.dava.framework;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.InputDevice;
import android.view.MotionEvent;

public abstract interface InputManagerCompat
{
  public abstract InputDevice getInputDevice(int paramInt);
  
  public abstract int[] getInputDeviceIds();
  
  public abstract void onGenericMotionEvent(MotionEvent paramMotionEvent);
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void registerInputDeviceListener(InputDeviceListener paramInputDeviceListener, Handler paramHandler);
  
  public abstract void unregisterInputDeviceListener(InputDeviceListener paramInputDeviceListener);
  
  public static class Factory
  {
    public static InputManagerCompat getInputManager(Context paramContext)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        return new InputManagerV16(paramContext);
      }
      return new InputManagerV9();
    }
  }
  
  public static abstract interface InputDeviceListener
  {
    public abstract void onInputDeviceAdded(int paramInt);
    
    public abstract void onInputDeviceChanged(int paramInt);
    
    public abstract void onInputDeviceRemoved(int paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/InputManagerCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */