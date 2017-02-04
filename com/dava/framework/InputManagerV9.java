package com.dava.framework;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.SparseArray;
import android.view.InputDevice;
import android.view.MotionEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class InputManagerV9
  implements InputManagerCompat
{
  private static final long CHECK_ELAPSED_TIME = 3000L;
  private static final String LOG_TAG = "InputManagerV9";
  private static final int MESSAGE_TEST_FOR_DISCONNECT = 101;
  private static final int ON_DEVICE_ADDED = 0;
  private static final int ON_DEVICE_CHANGED = 1;
  private static final int ON_DEVICE_REMOVED = 2;
  private final Handler mDefaultHandler = new PollingMessageHandler(this);
  private final SparseArray<long[]> mDevices = new SparseArray();
  private final Map<InputManagerCompat.InputDeviceListener, Handler> mListeners = new HashMap();
  
  public InputManagerV9()
  {
    getInputDeviceIds();
  }
  
  private void notifyListeners(int paramInt1, int paramInt2)
  {
    if (!this.mListeners.isEmpty())
    {
      Iterator localIterator = this.mListeners.keySet().iterator();
      while (localIterator.hasNext())
      {
        InputManagerCompat.InputDeviceListener localInputDeviceListener = (InputManagerCompat.InputDeviceListener)localIterator.next();
        ((Handler)this.mListeners.get(localInputDeviceListener)).post(DeviceEvent.getDeviceEvent(paramInt1, paramInt2, localInputDeviceListener));
      }
    }
  }
  
  public InputDevice getInputDevice(int paramInt)
  {
    return InputDevice.getDevice(paramInt);
  }
  
  public int[] getInputDeviceIds()
  {
    int[] arrayOfInt = InputDevice.getDeviceIds();
    long l = SystemClock.elapsedRealtime();
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      if ((long[])this.mDevices.get(k) == null) {
        this.mDevices.put(k, new long[] { l });
      }
      i += 1;
    }
    return arrayOfInt;
  }
  
  public void onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getDeviceId();
    long[] arrayOfLong = (long[])this.mDevices.get(i);
    paramMotionEvent = arrayOfLong;
    if (arrayOfLong == null)
    {
      notifyListeners(0, i);
      paramMotionEvent = new long[1];
      this.mDevices.put(i, paramMotionEvent);
    }
    paramMotionEvent[0] = SystemClock.elapsedRealtime();
  }
  
  public void onPause()
  {
    this.mDefaultHandler.removeMessages(101);
  }
  
  public void onResume()
  {
    this.mDefaultHandler.sendEmptyMessage(101);
  }
  
  public void registerInputDeviceListener(InputManagerCompat.InputDeviceListener paramInputDeviceListener, Handler paramHandler)
  {
    this.mListeners.remove(paramInputDeviceListener);
    Handler localHandler = paramHandler;
    if (paramHandler == null) {
      localHandler = this.mDefaultHandler;
    }
    this.mListeners.put(paramInputDeviceListener, localHandler);
  }
  
  public void unregisterInputDeviceListener(InputManagerCompat.InputDeviceListener paramInputDeviceListener)
  {
    this.mListeners.remove(paramInputDeviceListener);
  }
  
  private static class DeviceEvent
    implements Runnable
  {
    private static Queue<DeviceEvent> sEventQueue = new ArrayDeque();
    private int mId;
    private InputManagerCompat.InputDeviceListener mListener;
    private int mMessageType;
    
    static DeviceEvent getDeviceEvent(int paramInt1, int paramInt2, InputManagerCompat.InputDeviceListener paramInputDeviceListener)
    {
      DeviceEvent localDeviceEvent2 = (DeviceEvent)sEventQueue.poll();
      DeviceEvent localDeviceEvent1 = localDeviceEvent2;
      if (localDeviceEvent2 == null) {
        localDeviceEvent1 = new DeviceEvent();
      }
      localDeviceEvent1.mMessageType = paramInt1;
      localDeviceEvent1.mId = paramInt2;
      localDeviceEvent1.mListener = paramInputDeviceListener;
      return localDeviceEvent1;
    }
    
    public void run()
    {
      switch (this.mMessageType)
      {
      default: 
        Log.e("InputManagerV9", "Unknown Message Type");
      }
      for (;;)
      {
        sEventQueue.offer(this);
        return;
        this.mListener.onInputDeviceAdded(this.mId);
        continue;
        this.mListener.onInputDeviceChanged(this.mId);
        continue;
        this.mListener.onInputDeviceRemoved(this.mId);
      }
    }
  }
  
  private static class PollingMessageHandler
    extends Handler
  {
    private final WeakReference<InputManagerV9> mInputManager;
    
    PollingMessageHandler(InputManagerV9 paramInputManagerV9)
    {
      this.mInputManager = new WeakReference(paramInputManagerV9);
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      switch (paramMessage.what)
      {
      }
      do
      {
        return;
        paramMessage = (InputManagerV9)this.mInputManager.get();
      } while (paramMessage == null);
      long l = SystemClock.elapsedRealtime();
      int j = paramMessage.mDevices.size();
      int i = 0;
      if (i < j)
      {
        long[] arrayOfLong = (long[])paramMessage.mDevices.valueAt(i);
        if ((arrayOfLong != null) && (l - arrayOfLong[0] > 3000L))
        {
          int k = paramMessage.mDevices.keyAt(i);
          if (InputDevice.getDevice(k) != null) {
            break label137;
          }
          paramMessage.notifyListeners(2, k);
          paramMessage.mDevices.remove(k);
        }
        for (;;)
        {
          i += 1;
          break;
          label137:
          arrayOfLong[0] = l;
        }
      }
      sendEmptyMessageDelayed(101, 3000L);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/InputManagerV9.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */