package com.bda.controller;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;

public final class Controller
{
  public static final int ACTION_CONNECTED = 1;
  public static final int ACTION_CONNECTING = 2;
  public static final int ACTION_DISCONNECTED = 0;
  public static final int ACTION_DOWN = 0;
  public static final int ACTION_FALSE = 0;
  public static final int ACTION_TRUE = 1;
  public static final int ACTION_UP = 1;
  public static final int ACTION_VERSION_MOGA = 0;
  public static final int ACTION_VERSION_MOGAPRO = 1;
  public static final int AXIS_LTRIGGER = 17;
  public static final int AXIS_RTRIGGER = 18;
  public static final int AXIS_RZ = 14;
  public static final int AXIS_X = 0;
  public static final int AXIS_Y = 1;
  public static final int AXIS_Z = 11;
  static final int CONTROLLER_ID = 1;
  public static final int INFO_ACTIVE_DEVICE_COUNT = 2;
  public static final int INFO_KNOWN_DEVICE_COUNT = 1;
  public static final int INFO_UNKNOWN = 0;
  public static final int KEYCODE_BUTTON_A = 96;
  public static final int KEYCODE_BUTTON_B = 97;
  public static final int KEYCODE_BUTTON_L1 = 102;
  public static final int KEYCODE_BUTTON_L2 = 104;
  public static final int KEYCODE_BUTTON_R1 = 103;
  public static final int KEYCODE_BUTTON_R2 = 105;
  public static final int KEYCODE_BUTTON_SELECT = 109;
  public static final int KEYCODE_BUTTON_START = 108;
  public static final int KEYCODE_BUTTON_THUMBL = 106;
  public static final int KEYCODE_BUTTON_THUMBR = 107;
  public static final int KEYCODE_BUTTON_X = 99;
  public static final int KEYCODE_BUTTON_Y = 100;
  public static final int KEYCODE_DPAD_DOWN = 20;
  public static final int KEYCODE_DPAD_LEFT = 21;
  public static final int KEYCODE_DPAD_RIGHT = 22;
  public static final int KEYCODE_DPAD_UP = 19;
  public static final int KEYCODE_UNKNOWN = 0;
  static final int LEGACY_KEYCODE_BUTTON_X = 98;
  static final int LEGACY_KEYCODE_BUTTON_Y = 99;
  public static final int STATE_CONNECTION = 1;
  public static final int STATE_CURRENT_PRODUCT_VERSION = 4;
  public static final int STATE_POWER_LOW = 2;
  @Deprecated
  public static final int STATE_SELECTED_VERSION = 4;
  public static final int STATE_SUPPORTED_PRODUCT_VERSION = 3;
  @Deprecated
  public static final int STATE_SUPPORTED_VERSION = 3;
  public static final int STATE_UNKNOWN = 0;
  int mActivityEvent = 6;
  final Context mContext;
  Handler mHandler = null;
  boolean mIsBound = false;
  ControllerListener mListener = null;
  final IControllerListener.Stub mListenerStub = new IControllerListenerStub();
  ControllerMonitor mMonitor = null;
  final IControllerMonitor.Stub mMonitorStub = new IControllerMonitorStub();
  IControllerService mService = null;
  final ServiceConnection mServiceConnection = new ServiceConnection();
  
  Controller(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public static final Controller getInstance(Context paramContext)
  {
    return new Controller(paramContext);
  }
  
  public void allowNewConnections()
  {
    if (this.mService != null) {}
    try
    {
      this.mService.allowNewConnections();
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
  
  public void disallowNewConnections()
  {
    if (this.mService != null) {}
    try
    {
      this.mService.disallowNewConnections();
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
  
  public final void exit()
  {
    setListener(null, null);
    setMonitor(null);
    if (this.mIsBound)
    {
      this.mContext.unbindService(this.mServiceConnection);
      this.mIsBound = false;
    }
  }
  
  public final float getAxisValue(int paramInt)
  {
    if (this.mService != null) {
      try
      {
        float f = this.mService.getAxisValue(1, paramInt);
        return f;
      }
      catch (RemoteException localRemoteException) {}
    }
    return 0.0F;
  }
  
  public final int getInfo(int paramInt)
  {
    if (this.mService != null) {
      try
      {
        paramInt = this.mService.getInfo(paramInt);
        return paramInt;
      }
      catch (RemoteException localRemoteException) {}
    }
    return 0;
  }
  
  public final int getKeyCode(int paramInt)
  {
    int i = 1;
    if (this.mService != null) {}
    try
    {
      i = this.mService.getKeyCode2(1, paramInt);
      return i;
    }
    catch (RemoteException localRemoteException1)
    {
      switch (paramInt)
      {
      }
      for (;;)
      {
        try
        {
          paramInt = this.mService.getKeyCode(1, paramInt);
          return paramInt;
        }
        catch (RemoteException localRemoteException2) {}
        paramInt = 98;
        continue;
        paramInt = 99;
      }
    }
    return 1;
  }
  
  public final int getState(int paramInt)
  {
    if (this.mService != null) {
      try
      {
        paramInt = this.mService.getState(1, paramInt);
        return paramInt;
      }
      catch (RemoteException localRemoteException) {}
    }
    return 0;
  }
  
  public final boolean init()
  {
    if (!this.mIsBound)
    {
      Intent localIntent = new Intent(IControllerService.class.getName());
      this.mContext.startService(localIntent);
      this.mContext.bindService(localIntent, this.mServiceConnection, 1);
      this.mIsBound = true;
    }
    return this.mIsBound;
  }
  
  public void isAllowingNewConnections()
  {
    if (this.mService != null) {}
    try
    {
      this.mService.isAllowingNewConnections();
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
  
  public final void onPause()
  {
    this.mActivityEvent = 6;
    sendMessage(1, this.mActivityEvent);
    registerListener();
  }
  
  public final void onResume()
  {
    this.mActivityEvent = 5;
    sendMessage(1, this.mActivityEvent);
    registerListener();
  }
  
  void registerListener()
  {
    if ((this.mListener != null) && (this.mService != null)) {}
    try
    {
      this.mService.registerListener2(this.mListenerStub, this.mActivityEvent);
      return;
    }
    catch (RemoteException localRemoteException1)
    {
      try
      {
        this.mService.registerListener(this.mListenerStub, this.mActivityEvent);
        return;
      }
      catch (RemoteException localRemoteException2) {}
    }
  }
  
  void registerMonitor()
  {
    if ((this.mMonitor != null) && (this.mService != null)) {}
    try
    {
      this.mService.registerMonitor(this.mMonitorStub, this.mActivityEvent);
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
  
  void sendMessage(int paramInt1, int paramInt2)
  {
    if (this.mService != null) {}
    try
    {
      this.mService.sendMessage(paramInt1, paramInt2);
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
  
  public final void setListener(ControllerListener paramControllerListener, Handler paramHandler)
  {
    unregisterListener();
    this.mListener = paramControllerListener;
    this.mHandler = paramHandler;
    registerListener();
  }
  
  public final void setMonitor(ControllerMonitor paramControllerMonitor)
  {
    unregisterMonitor();
    this.mMonitor = paramControllerMonitor;
    registerMonitor();
  }
  
  void unregisterListener()
  {
    if (this.mService != null) {}
    try
    {
      this.mService.unregisterListener(this.mListenerStub, this.mActivityEvent);
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
  
  void unregisterMonitor()
  {
    if (this.mService != null) {}
    try
    {
      this.mService.unregisterMonitor(this.mMonitorStub, this.mActivityEvent);
      return;
    }
    catch (RemoteException localRemoteException) {}
  }
  
  class IControllerListenerStub
    extends IControllerListener.Stub
  {
    IControllerListenerStub() {}
    
    public void onKeyEvent(KeyEvent paramKeyEvent)
      throws RemoteException
    {
      if ((paramKeyEvent.getControllerId() == 1) && (Controller.this.mListener != null))
      {
        paramKeyEvent = new Controller.KeyRunnable(Controller.this, paramKeyEvent);
        if (Controller.this.mHandler != null) {
          Controller.this.mHandler.post(paramKeyEvent);
        }
      }
      else
      {
        return;
      }
      paramKeyEvent.run();
    }
    
    public void onMotionEvent(MotionEvent paramMotionEvent)
      throws RemoteException
    {
      if ((paramMotionEvent.getControllerId() == 1) && (Controller.this.mListener != null))
      {
        paramMotionEvent = new Controller.MotionRunnable(Controller.this, paramMotionEvent);
        if (Controller.this.mHandler != null) {
          Controller.this.mHandler.post(paramMotionEvent);
        }
      }
      else
      {
        return;
      }
      paramMotionEvent.run();
    }
    
    public void onStateEvent(StateEvent paramStateEvent)
      throws RemoteException
    {
      if ((paramStateEvent.getControllerId() == 1) && (Controller.this.mListener != null))
      {
        paramStateEvent = new Controller.StateRunnable(Controller.this, paramStateEvent);
        if (Controller.this.mHandler != null) {
          Controller.this.mHandler.post(paramStateEvent);
        }
      }
      else
      {
        return;
      }
      paramStateEvent.run();
    }
  }
  
  class IControllerMonitorStub
    extends IControllerMonitor.Stub
  {
    IControllerMonitorStub() {}
    
    public void onLog(int paramInt1, int paramInt2, String paramString)
      throws RemoteException
    {
      if (Controller.this.mMonitor != null) {
        Controller.this.mMonitor.onLog(paramInt1, paramInt2, paramString);
      }
    }
  }
  
  class KeyRunnable
    implements Runnable
  {
    final KeyEvent mEvent;
    
    public KeyRunnable(KeyEvent paramKeyEvent)
    {
      this.mEvent = paramKeyEvent;
    }
    
    public void run()
    {
      if (Controller.this.mListener != null) {
        Controller.this.mListener.onKeyEvent(this.mEvent);
      }
    }
  }
  
  class MotionRunnable
    implements Runnable
  {
    final MotionEvent mEvent;
    
    public MotionRunnable(MotionEvent paramMotionEvent)
    {
      this.mEvent = paramMotionEvent;
    }
    
    public void run()
    {
      if (Controller.this.mListener != null) {
        Controller.this.mListener.onMotionEvent(this.mEvent);
      }
    }
  }
  
  class ServiceConnection
    implements ServiceConnection
  {
    ServiceConnection() {}
    
    public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      Controller.this.mService = IControllerService.Stub.asInterface(paramIBinder);
      Controller.this.registerListener();
      Controller.this.registerMonitor();
      if (Controller.this.mActivityEvent == 5)
      {
        Controller.this.sendMessage(1, 5);
        Controller.this.sendMessage(1, 7);
      }
    }
    
    public final void onServiceDisconnected(ComponentName paramComponentName)
    {
      Controller.this.mService = null;
    }
  }
  
  class StateRunnable
    implements Runnable
  {
    final StateEvent mEvent;
    
    public StateRunnable(StateEvent paramStateEvent)
    {
      this.mEvent = paramStateEvent;
    }
    
    public void run()
    {
      if (Controller.this.mListener != null) {
        Controller.this.mListener.onStateEvent(this.mEvent);
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/bda/controller/Controller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */