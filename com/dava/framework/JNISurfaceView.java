package com.dava.framework;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JNISurfaceView
  extends SurfaceView
  implements SurfaceHolder.Callback
{
  private static final int MAX_KEYS = 256;
  private static Surface surface = null;
  private Integer[] gamepadAxises = null;
  private ArrayList<Pair<Integer, Integer>> gamepadButtonsAxisMap = new ArrayList();
  private boolean isMultitouchEnabled = true;
  private ArrayList<Runnable> mEventQueue = new ArrayList();
  private volatile boolean mEventQueueReady = true;
  private Integer[] overridedGamepadKeys = null;
  private int surfaceHeight = 0;
  private int surfaceWidth = 0;
  
  public JNISurfaceView(Context paramContext)
  {
    super(paramContext);
    Init();
  }
  
  public JNISurfaceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Init();
  }
  
  private void Init()
  {
    getHolder().setFormat(-3);
    this.gamepadButtonsAxisMap.add(new Pair(Integer.valueOf(104), Integer.valueOf(17)));
    this.gamepadButtonsAxisMap.add(new Pair(Integer.valueOf(104), Integer.valueOf(23)));
    this.gamepadButtonsAxisMap.add(new Pair(Integer.valueOf(105), Integer.valueOf(18)));
    this.gamepadButtonsAxisMap.add(new Pair(Integer.valueOf(105), Integer.valueOf(22)));
    getHolder().addCallback(this);
  }
  
  private native void nativeOnGamepadElement(int paramInt, float paramFloat, boolean paramBoolean);
  
  private native void nativeOnInput(int paramInt1, int paramInt2, int paramInt3, ArrayList<JNISurfaceView.InputRunnable.InputEvent> paramArrayList);
  
  private native void nativeOnKeyDown(int paramInt);
  
  private native void nativeOnKeyUp(int paramInt);
  
  private native void nativeProcessFrame();
  
  private native void nativeSurfaceChanged(Surface paramSurface, int paramInt1, int paramInt2);
  
  private native void nativeSurfaceCreated(Surface paramSurface);
  
  private native void nativeSurfaceDestroyed();
  
  boolean IsGamepadButton(int paramInt)
  {
    Integer[] arrayOfInteger = this.overridedGamepadKeys;
    int j = arrayOfInteger.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfInteger[i].intValue() == paramInt) {
        return false;
      }
      i += 1;
    }
    return KeyEvent.isGamepadButton(paramInt);
  }
  
  public void ProcessFrame()
  {
    if (!JNIAssert.waitUserInputOnAssertDialog) {
      nativeProcessFrame();
    }
  }
  
  public void ProcessQueuedEvents()
  {
    Object localObject1;
    synchronized (this.mEventQueue)
    {
      localObject1 = new ArrayList(this.mEventQueue);
    }
    try
    {
      this.mEventQueue.clear();
      localObject1 = ((ArrayList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((Runnable)((Iterator)localObject1).next()).run();
      }
      localObject2 = finally;
    }
    finally {}
    throw ((Throwable)localObject2);
    synchronized (this.mEventQueue)
    {
      this.mEventQueueReady = true;
      this.mEventQueue.notify();
      return;
    }
  }
  
  public void SetAvailableGamepadAxises(Integer[] paramArrayOfInteger)
  {
    this.gamepadAxises = paramArrayOfInteger;
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.gamepadButtonsAxisMap.iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      int j = paramArrayOfInteger.length;
      int i = 0;
      while (i < j)
      {
        if (paramArrayOfInteger[i] == localPair.second) {
          localHashSet.add(localPair.first);
        }
        i += 1;
      }
    }
    this.overridedGamepadKeys = ((Integer[])localHashSet.toArray(new Integer[localHashSet.size()]));
  }
  
  public void SetMultitouchEnabled(boolean paramBoolean)
  {
    this.isMultitouchEnabled = paramBoolean;
  }
  
  public void WaitQueuedEvents()
  {
    synchronized (this.mEventQueue)
    {
      if (!this.mEventQueue.isEmpty())
      {
        this.mEventQueueReady = false;
        for (;;)
        {
          boolean bool = this.mEventQueueReady;
          if (!bool) {
            try
            {
              this.mEventQueue.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    paramEditorInfo.imeOptions = JNITextField.GetLastKeyboardIMEOptions();
    paramEditorInfo.inputType = JNITextField.GetLastKeyboardInputType();
    return super.onCreateInputConnection(paramEditorInfo);
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    queueEvent(new InputRunnable(paramMotionEvent));
    return true;
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    if (paramInt >= 256) {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
    }
    do
    {
      return bool;
      queueEvent(new KeyInputRunnable(paramInt, true));
    } while (!paramKeyEvent.isSystem());
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt >= 256) {
      return super.onKeyUp(paramInt, paramKeyEvent);
    }
    queueEvent(new KeyInputRunnable(paramInt, false));
    if (paramKeyEvent.isSystem()) {
      return super.onKeyUp(paramInt, paramKeyEvent);
    }
    return true;
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = paramInt1;
    int i = paramInt2;
    if (paramInt1 < paramInt2)
    {
      i = paramInt1;
      j = paramInt2;
    }
    super.onSizeChanged(j, i, paramInt3, paramInt4);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    queueEvent(new InputRunnable(paramMotionEvent));
    return true;
  }
  
  public void queueEvent(Runnable paramRunnable)
  {
    synchronized (this.mEventQueue)
    {
      this.mEventQueue.add(paramRunnable);
      return;
    }
  }
  
  public void surfaceChanged(final SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    if (surface != paramSurfaceHolder.getSurface())
    {
      Log.d(JNIConst.LOG_TAG, "JNISurfaceView surfaceChanged for previous object! Do nothing");
      return;
    }
    Log.d(JNIConst.LOG_TAG, "JNISurfaceView surfaceChanged in");
    int i = paramInt2;
    paramInt1 = paramInt3;
    if (paramInt2 < paramInt3)
    {
      paramInt1 = paramInt2;
      i = paramInt3;
    }
    if ((i != this.surfaceWidth) || (paramInt1 != this.surfaceHeight))
    {
      this.surfaceWidth = i;
      this.surfaceHeight = paramInt1;
      queueEvent(new Runnable()
      {
        public void run()
        {
          Log.d(JNIConst.LOG_TAG, "JNISurfaceView surfaceChanged runnable in");
          JNISurfaceView.this.nativeSurfaceChanged(JNISurfaceView.surface, JNISurfaceView.this.surfaceWidth, JNISurfaceView.this.surfaceHeight);
          Log.d(JNIConst.LOG_TAG, "JNISurfaceView surfaceChanged runnable out");
        }
      });
      paramSurfaceHolder = JNIActivity.GetActivity();
      paramSurfaceHolder.runOnUiThread(new Runnable()
      {
        public void run()
        {
          paramSurfaceHolder.InitKeyboardLayout();
        }
      });
      WaitQueuedEvents();
    }
    JNIActivity.isSurfaceReady = true;
    Log.d(JNIConst.LOG_TAG, "JNISurfaceView surfaceChanged out");
  }
  
  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
    if (surface != null)
    {
      Log.d(JNIConst.LOG_TAG, "JNISurfaceView surfaceCreated: previous surface is alive, call nativeSurfaceDestroyed");
      queueEvent(new Runnable()
      {
        public void run()
        {
          Log.d(JNIConst.LOG_TAG, "JNISurfaceView surfaceCreated runnable in: call nativeSurfaceDestroyed");
          JNISurfaceView.this.nativeSurfaceDestroyed();
          Log.d(JNIConst.LOG_TAG, "JNISurfaceView surfaceCreated runnable out: call nativeSurfaceDestroyed");
        }
      });
    }
    Log.d(JNIConst.LOG_TAG, "JNISurfaceView surfaceCreated in");
    surface = paramSurfaceHolder.getSurface();
    this.surfaceHeight = 0;
    this.surfaceWidth = 0;
    queueEvent(new Runnable()
    {
      public void run()
      {
        Log.d(JNIConst.LOG_TAG, "JNISurfaceView surfaceCreated runnable in");
        JNISurfaceView.this.nativeSurfaceCreated(JNISurfaceView.surface);
        Log.d(JNIConst.LOG_TAG, "JNISurfaceView surfaceCreated runnable out");
      }
    });
    Log.d(JNIConst.LOG_TAG, "JNISurfaceView surfaceCreated out");
  }
  
  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    if (surface != paramSurfaceHolder.getSurface())
    {
      Log.d(JNIConst.LOG_TAG, "JNISurfaceView surfaceDestroyed for previous object! Do nothing");
      return;
    }
    Log.d(JNIConst.LOG_TAG, "JNISurfaceView surfaceDestroyed in");
    queueEvent(new Runnable()
    {
      public void run()
      {
        Log.d(JNIConst.LOG_TAG, "JNISurfaceView surfaceDestroyed runnable in");
        JNISurfaceView.this.nativeSurfaceDestroyed();
        Log.d(JNIConst.LOG_TAG, "JNISurfaceView surfaceDestroyed runnable out");
      }
    });
    WaitQueuedEvents();
    JNIActivity.isSurfaceReady = false;
    surface = null;
    Log.d(JNIConst.LOG_TAG, "JNISurfaceView surfaceDestroyed out");
  }
  
  public class InputRunnable
    implements Runnable
  {
    int action;
    ArrayList<InputEvent> activeEvents;
    ArrayList<InputEvent> allEvents = new ArrayList();
    int groupSize;
    int source;
    
    public InputRunnable(MotionEvent paramMotionEvent)
    {
      this.action = paramMotionEvent.getActionMasked();
      this.source = paramMotionEvent.getSource();
      this.groupSize = 1;
      int m = paramMotionEvent.getPointerCount();
      int i;
      int j;
      InputEvent localInputEvent;
      if ((this.source & 0x10) > 0)
      {
        int n = paramMotionEvent.getHistorySize();
        i = 0;
        while (i < n)
        {
          j = 0;
          while (j < m)
          {
            int k = 0;
            while (k < JNISurfaceView.this.gamepadAxises.length)
            {
              localInputEvent = new InputEvent(JNISurfaceView.this.gamepadAxises[k].intValue(), paramMotionEvent.getHistoricalAxisValue(JNISurfaceView.this.gamepadAxises[k].intValue(), j, i), 0.0F, paramMotionEvent.getHistoricalEventTime(i));
              this.allEvents.add(localInputEvent);
              k += 1;
            }
            j += 1;
          }
          i += 1;
        }
        i = 0;
        while (i < m)
        {
          j = 0;
          while (j < JNISurfaceView.this.gamepadAxises.length)
          {
            localInputEvent = new InputEvent(JNISurfaceView.this.gamepadAxises[j].intValue(), paramMotionEvent.getAxisValue(JNISurfaceView.this.gamepadAxises[j].intValue(), i), 0.0F, paramMotionEvent.getEventTime());
            this.allEvents.add(localInputEvent);
            j += 1;
          }
          i += 1;
        }
      }
      if ((this.source & 0x2) > 0)
      {
        i = paramMotionEvent.getActionIndex();
        j = paramMotionEvent.getPointerId(i);
        if ((2 == this.action) || (3 == this.action))
        {
          this.groupSize = m;
          i = 0;
        }
        while (i < m)
        {
          j = paramMotionEvent.getPointerId(i);
          if (JNISurfaceView.this.isMultitouchEnabled)
          {
            localInputEvent = new InputEvent(touchIdForPointerId(j), paramMotionEvent.getX(i), paramMotionEvent.getY(i), paramMotionEvent.getEventTime());
            this.allEvents.add(localInputEvent);
          }
          i += 1;
          continue;
          this$1 = new InputEvent(touchIdForPointerId(j), paramMotionEvent.getX(i), paramMotionEvent.getY(i), paramMotionEvent.getEventTime());
          this.allEvents.add(JNISurfaceView.this);
        }
        return;
      }
      Log.d(JNIConst.LOG_TAG, "unsupported moution input source: " + this.source);
    }
    
    public void run()
    {
      if ((this.source & 0x10) > 0)
      {
        Iterator localIterator = this.allEvents.iterator();
        while (localIterator.hasNext())
        {
          InputEvent localInputEvent = (InputEvent)localIterator.next();
          if ((localInputEvent.tid == 1) || (localInputEvent.tid == 14) || (localInputEvent.tid == 13)) {
            JNISurfaceView.this.nativeOnGamepadElement(localInputEvent.tid, -localInputEvent.x, false);
          } else {
            JNISurfaceView.this.nativeOnGamepadElement(localInputEvent.tid, localInputEvent.x, false);
          }
        }
      }
      if (this.allEvents.size() != 0) {
        JNISurfaceView.this.nativeOnInput(this.action, this.source, this.groupSize, this.allEvents);
      }
    }
    
    int touchIdForPointerId(int paramInt)
    {
      return paramInt + 1;
    }
    
    public class InputEvent
    {
      int tid;
      double time;
      float x;
      float y;
      
      InputEvent(int paramInt, float paramFloat1, float paramFloat2, double paramDouble)
      {
        this.tid = paramInt;
        this.x = paramFloat1;
        this.y = paramFloat2;
        this.time = paramDouble;
      }
    }
  }
  
  class KeyInputRunnable
    implements Runnable
  {
    boolean isDown;
    int keyCode;
    
    public KeyInputRunnable(int paramInt, boolean paramBoolean)
    {
      this.keyCode = paramInt;
      this.isDown = paramBoolean;
    }
    
    public void run()
    {
      if (JNISurfaceView.this.IsGamepadButton(this.keyCode))
      {
        JNISurfaceView localJNISurfaceView = JNISurfaceView.this;
        int i = this.keyCode;
        if (this.isDown) {}
        for (float f = 1.0F;; f = 0.0F)
        {
          localJNISurfaceView.nativeOnGamepadElement(i, f, true);
          return;
        }
      }
      if (this.isDown)
      {
        JNISurfaceView.this.nativeOnKeyDown(this.keyCode);
        return;
      }
      JNISurfaceView.this.nativeOnKeyUp(this.keyCode);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/JNISurfaceView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */