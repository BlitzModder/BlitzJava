package com.dava.framework;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.input.InputManager;
import android.hardware.input.InputManager.InputDeviceListener;
import android.os.Handler;
import android.view.InputDevice;
import android.view.MotionEvent;
import java.util.HashMap;
import java.util.Map;

@TargetApi(16)
public class InputManagerV16
  implements InputManagerCompat
{
  private final InputManager mInputManager;
  private final Map<InputManagerCompat.InputDeviceListener, V16InputDeviceListener> mListeners;
  
  public InputManagerV16(Context paramContext)
  {
    this.mInputManager = ((InputManager)paramContext.getSystemService("input"));
    this.mListeners = new HashMap();
  }
  
  public InputDevice getInputDevice(int paramInt)
  {
    return this.mInputManager.getInputDevice(paramInt);
  }
  
  public int[] getInputDeviceIds()
  {
    return this.mInputManager.getInputDeviceIds();
  }
  
  public void onGenericMotionEvent(MotionEvent paramMotionEvent) {}
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void registerInputDeviceListener(InputManagerCompat.InputDeviceListener paramInputDeviceListener, Handler paramHandler)
  {
    V16InputDeviceListener localV16InputDeviceListener = new V16InputDeviceListener(paramInputDeviceListener);
    this.mInputManager.registerInputDeviceListener(localV16InputDeviceListener, paramHandler);
    this.mListeners.put(paramInputDeviceListener, localV16InputDeviceListener);
  }
  
  public void unregisterInputDeviceListener(InputManagerCompat.InputDeviceListener paramInputDeviceListener)
  {
    paramInputDeviceListener = (V16InputDeviceListener)this.mListeners.remove(paramInputDeviceListener);
    if (paramInputDeviceListener != null) {
      this.mInputManager.unregisterInputDeviceListener(paramInputDeviceListener);
    }
  }
  
  static class V16InputDeviceListener
    implements InputManager.InputDeviceListener
  {
    final InputManagerCompat.InputDeviceListener mIDL;
    
    public V16InputDeviceListener(InputManagerCompat.InputDeviceListener paramInputDeviceListener)
    {
      this.mIDL = paramInputDeviceListener;
    }
    
    public void onInputDeviceAdded(int paramInt)
    {
      this.mIDL.onInputDeviceAdded(paramInt);
    }
    
    public void onInputDeviceChanged(int paramInt)
    {
      this.mIDL.onInputDeviceChanged(paramInt);
    }
    
    public void onInputDeviceRemoved(int paramInt)
    {
      this.mIDL.onInputDeviceRemoved(paramInt);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/InputManagerV16.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */