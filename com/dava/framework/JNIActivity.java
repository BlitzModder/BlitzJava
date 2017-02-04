package com.dava.framework;

import android.app.Activity;
import android.content.Intent;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.InputDevice;
import android.view.InputDevice.MotionRange;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import android.view.WindowManager;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.fmod.FMODAudioDevice;

public abstract class JNIActivity
  extends Activity
  implements JNIAccelerometer.JNIAccelerometerListener, InputManagerCompat.InputDeviceListener
{
  private static JNIActivity activity;
  private static String commandLineParams;
  private static int errorState;
  public static boolean isFocused;
  public static boolean isPaused;
  public static boolean isSurfaceReady;
  protected static SingalStrengthListner singalStrengthListner;
  private JNIAccelerometer accelerometer = null;
  private FMODAudioDevice fmodDevice = new FMODAudioDevice();
  private InputManagerCompat inputManager = null;
  private long mainLoopThreadID = 0L;
  private volatile boolean mainThreadNeedExit = false;
  private volatile boolean mainThreadNeedResume = true;
  private volatile boolean mainThreadNeedSuspend = false;
  private final Object mainThreadSync = new Object();
  private View splashView = null;
  protected final List<Integer> supportedAxises = Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(11), Integer.valueOf(12), Integer.valueOf(13), Integer.valueOf(14), Integer.valueOf(17), Integer.valueOf(18), Integer.valueOf(23), Integer.valueOf(22) });
  protected JNISurfaceView surfaceView = null;
  
  static
  {
    if (!JNIActivity.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      isPaused = true;
      isFocused = false;
      isSurfaceReady = false;
      errorState = 0;
      commandLineParams = null;
      activity = null;
      singalStrengthListner = null;
      return;
    }
  }
  
  private void FixNoClassDefFoundError81083()
  {
    try
    {
      Class.forName("android.os.AsyncTask");
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e(JNIConst.LOG_TAG, localThrowable.toString());
    }
  }
  
  public static JNIActivity GetActivity()
  {
    return activity;
  }
  
  public static void HideNavigationBar(View paramView)
  {
    int j = paramView.getSystemUiVisibility();
    int i = j;
    if (Build.VERSION.SDK_INT >= 16) {
      i = j | 0x4;
    }
    j = i;
    if (Build.VERSION.SDK_INT >= 19) {
      j = i | 0x1702;
    }
    paramView.setSystemUiVisibility(j);
  }
  
  public static void finishActivity()
  {
    Log.d(JNIConst.LOG_TAG, "[Activity::finishActivity] in");
    activity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        JNIActivity.activity.finish();
      }
    });
    Log.d(JNIConst.LOG_TAG, "[Activity::finishActivity] out");
  }
  
  private String initCommandLineParams()
  {
    String str1 = "";
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null)
    {
      str1 = "";
      Iterator localIterator = localBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        String str3 = localBundle.getString(str2);
        str1 = str1 + str2 + " " + str3 + " ";
      }
      str1 = str1.trim();
    }
    Log.i(JNIConst.LOG_TAG, "command line params: " + str1);
    return str1;
  }
  
  private boolean isScreenLocked()
  {
    PowerManager localPowerManager = (PowerManager)JNIApplication.GetApplication().getSystemService("power");
    if (Build.VERSION.SDK_INT >= 20) {
      return !localPowerManager.isInteractive();
    }
    return !localPowerManager.isScreenOn();
  }
  
  private native void nativeFinishing();
  
  private native int nativeGetDesiredFPS();
  
  private native boolean nativeIsMultitouchEnabled();
  
  private native void nativeOnAccelerometer(float paramFloat1, float paramFloat2, float paramFloat3);
  
  private native void nativeOnCreate();
  
  private native void nativeOnDestroy();
  
  private native void nativeOnGamepadAvailable(boolean paramBoolean);
  
  private native void nativeOnGamepadTriggersAvailable(boolean paramBoolean);
  
  private native void nativeOnPause(boolean paramBoolean);
  
  private native void nativeOnResume();
  
  private native void nativeOnStart();
  
  private native void nativeOnStop();
  
  void DestroyKeyboardLayout()
  {
    JNITextField.DestroyKeyboardLayout(getWindowManager());
  }
  
  public abstract JNISurfaceView FindSurfaceView();
  
  public boolean GetIsPausing()
  {
    return isPaused;
  }
  
  public long GetMainLoopThreadID()
  {
    return this.mainLoopThreadID;
  }
  
  public int GetNotificationIcon()
  {
    return 17301651;
  }
  
  public View GetSplashView()
  {
    return null;
  }
  
  public JNISurfaceView GetSurfaceView()
  {
    return this.surfaceView;
  }
  
  public void HideSplashScreenView()
  {
    if (this.splashView != null)
    {
      Log.d(JNIConst.LOG_TAG, "splashView hide");
      this.splashView.setVisibility(8);
    }
    JNITextField.ShowVisibleTextFields();
    JNIWebView.ShowVisibleWebViews();
    this.surfaceView.SetMultitouchEnabled(nativeIsMultitouchEnabled());
  }
  
  void InitKeyboardLayout()
  {
    final WindowManager localWindowManager = getWindowManager();
    JNITextField.DestroyKeyboardLayout(localWindowManager);
    View localView = findViewById(16908290);
    if (localView == null) {
      throw new RuntimeException("findViewById returned null - strange null pointer view");
    }
    if (localView.getWindowToken() != null)
    {
      JNITextField.InitializeKeyboardLayout(localWindowManager, localView.getWindowToken());
      return;
    }
    localView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public void onViewAttachedToWindow(View paramAnonymousView)
      {
        JNITextField.InitializeKeyboardLayout(localWindowManager, paramAnonymousView.getWindowToken());
        paramAnonymousView.removeOnAttachStateChangeListener(this);
      }
      
      public void onViewDetachedFromWindow(View paramAnonymousView)
      {
        paramAnonymousView.removeOnAttachStateChangeListener(this);
      }
    });
  }
  
  public void RunOnMainLoopThread(Runnable paramRunnable)
  {
    this.surfaceView.queueEvent(paramRunnable);
  }
  
  public void ShowSplashScreenView()
  {
    if (this.splashView != null)
    {
      Log.d(JNIConst.LOG_TAG, "splashView set visible");
      this.splashView.setVisibility(0);
    }
    JNITextField.HideAllTextFields();
    JNIWebView.HideAllWebViews();
  }
  
  protected void UpdateGamepadAxises()
  {
    RunOnMainLoopThread(new Runnable()
    {
      public void run()
      {
        boolean bool2 = false;
        Object localObject = InputDevice.getDeviceIds();
        HashSet localHashSet = new HashSet();
        int j = localObject.length;
        int i = 0;
        for (;;)
        {
          bool1 = bool2;
          if (i >= j) {
            break;
          }
          InputDevice localInputDevice = InputDevice.getDevice(localObject[i]);
          if ((localInputDevice.getSources() & 0x10) > 0)
          {
            bool2 = true;
            localObject = localInputDevice.getMotionRanges().iterator();
            for (;;)
            {
              bool1 = bool2;
              if (!((Iterator)localObject).hasNext()) {
                break;
              }
              i = ((InputDevice.MotionRange)((Iterator)localObject).next()).getAxis();
              if (JNIActivity.this.supportedAxises.contains(Integer.valueOf(i))) {
                localHashSet.add(Integer.valueOf(i));
              }
            }
          }
          i += 1;
        }
        localObject = new Integer[localHashSet.size()];
        JNIActivity.this.surfaceView.SetAvailableGamepadAxises((Integer[])localHashSet.toArray((Object[])localObject));
        JNIActivity.this.nativeOnGamepadAvailable(bool1);
        localObject = JNIActivity.this;
        if ((localHashSet.contains(Integer.valueOf(17))) || (localHashSet.contains(Integer.valueOf(23)))) {}
        for (boolean bool1 = true;; bool1 = false)
        {
          ((JNIActivity)localObject).nativeOnGamepadTriggersAvailable(bool1);
          return;
        }
      }
    });
  }
  
  protected void handleResume()
  {
    Log.d(JNIConst.LOG_TAG, "[Activity::handleResume] in");
    if ((isPaused) && (isSurfaceReady) && (isFocused))
    {
      isPaused = false;
      synchronized (this.mainThreadSync)
      {
        this.mainThreadNeedResume = true;
        for (;;)
        {
          boolean bool = this.mainThreadNeedResume;
          if (bool) {
            try
            {
              this.mainThreadSync.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
          }
        }
      }
      Log.d(JNIConst.LOG_TAG, "[Activity::handleResume] resumed");
    }
    Log.d(JNIConst.LOG_TAG, "[Activity::handleResume] out");
  }
  
  protected void handleSuspend()
  {
    Log.d(JNIConst.LOG_TAG, "[Activity::handleSuspend] in");
    if ((!isPaused) && (isSurfaceReady))
    {
      isPaused = true;
      synchronized (this.mainThreadSync)
      {
        this.mainThreadNeedSuspend = true;
        for (;;)
        {
          boolean bool = this.mainThreadNeedSuspend;
          if (bool) {
            try
            {
              this.mainThreadSync.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
          }
        }
      }
      Log.d(JNIConst.LOG_TAG, "[Activity::handleSuspend] suspended");
    }
    Log.d(JNIConst.LOG_TAG, "[Activity::handleSuspend] out");
  }
  
  public void onAccelerationChanged(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    nativeOnAccelerometer(paramFloat1, paramFloat2, paramFloat3);
  }
  
  public void onBackPressed() {}
  
  public void onCreate(final Bundle paramBundle)
  {
    Log.d(JNIConst.LOG_TAG, "[Activity::onCreate] in");
    FixNoClassDefFoundError81083();
    activity = this;
    super.onCreate(paramBundle);
    commandLineParams = initCommandLineParams();
    this.accelerometer = new JNIAccelerometer(this, (SensorManager)getSystemService("sensor"));
    getWindow().setSoftInputMode(51);
    getWindow().addFlags(1280);
    getWindow().requestFeature(10);
    getWindow().requestFeature(9);
    getWindow().requestFeature(1);
    paramBundle = getWindow().getDecorView();
    HideNavigationBar(paramBundle);
    paramBundle.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener()
    {
      public void onSystemUiVisibilityChange(int paramAnonymousInt)
      {
        if ((paramAnonymousInt & 0x2) == 0) {
          JNIActivity.HideNavigationBar(paramBundle);
        }
      }
    });
    this.surfaceView = FindSurfaceView();
    assert (this.surfaceView != null);
    this.surfaceView.setFocusableInTouchMode(true);
    this.surfaceView.setClickable(true);
    this.surfaceView.setFocusable(true);
    this.surfaceView.requestFocus();
    this.inputManager = InputManagerCompat.Factory.getInputManager(this);
    this.splashView = GetSplashView();
    paramBundle = (TelephonyManager)getSystemService("phone");
    if (paramBundle != null)
    {
      singalStrengthListner = new SingalStrengthListner();
      paramBundle.listen(singalStrengthListner, 256);
    }
    for (;;)
    {
      JNIApplication.mainCPPThread = new Thread(new Runnable()
      {
        long startTime;
        
        public void run()
        {
          Log.d(JNIConst.LOG_TAG, "[C++ main thread] started!");
          JNIApplication.GetApplication().InitFramework(JNIActivity.commandLineParams);
          JNIActivity.this.nativeOnCreate();
          JNIActivity.this.UpdateGamepadAxises();
          this.startTime = System.currentTimeMillis();
          while (!JNIActivity.this.mainThreadNeedExit)
          {
            long l1 = System.currentTimeMillis() - this.startTime;
            long l2 = JNIActivity.this.nativeGetDesiredFPS();
            if (l2 > 0L)
            {
              l2 = 1000L / l2;
              if (l2 <= l1) {}
            }
            try
            {
              Thread.sleep(l2 - l1);
              this.startTime = System.currentTimeMillis();
              JNIActivity.this.surfaceView.ProcessQueuedEvents();
              if (JNIActivity.this.mainThreadNeedResume)
              {
                Log.d(JNIConst.LOG_TAG, "[C++ main thread] resume native in");
                JNIActivity.this.nativeOnResume();
                Log.d(JNIConst.LOG_TAG, "[C++ main thread] resume native out");
                synchronized (JNIActivity.this.mainThreadSync)
                {
                  JNIActivity.access$402(JNIActivity.this, false);
                  JNIActivity.this.mainThreadSync.notify();
                }
              }
            }
            catch (InterruptedException localInterruptedException)
            {
              for (;;)
              {
                localInterruptedException.printStackTrace();
              }
              if (JNIActivity.this.mainThreadNeedSuspend)
              {
                Log.d(JNIConst.LOG_TAG, "[C++ main thread] suspend native in");
                boolean bool = JNIActivity.this.isScreenLocked();
                JNIActivity.this.nativeOnPause(bool);
                Log.d(JNIConst.LOG_TAG, "[C++ main thread] suspend native out");
                synchronized (JNIActivity.this.mainThreadSync)
                {
                  JNIActivity.access$702(JNIActivity.this, false);
                  JNIActivity.this.mainThreadSync.notify();
                }
              }
              JNIActivity.this.surfaceView.ProcessFrame();
            }
          }
          Log.d(JNIConst.LOG_TAG, "[C++ main thread] destroying native...");
          JNIActivity.this.nativeOnDestroy();
          Log.d(JNIConst.LOG_TAG, "[C++ main thread] finished!");
        }
      }, "cpp_main_thread");
      this.mainLoopThreadID = JNIApplication.mainCPPThread.getId();
      JNIApplication.mainCPPThread.start();
      JNINotificationProvider.AttachToActivity(this);
      RunOnMainLoopThread(new Runnable()
      {
        public void run()
        {
          if (this.val$intent != null)
          {
            String str = this.val$intent.getStringExtra("uid");
            if (str != null) {
              JNINotificationProvider.NotificationPressed(str);
            }
          }
        }
      });
      Log.d(JNIConst.LOG_TAG, "[Activity::onCreate] out");
      return;
      Log.d("", "no singalStrengthListner");
    }
  }
  
  protected void onDestroy()
  {
    Log.d(JNIConst.LOG_TAG, "[Activity::onDestroy] in");
    this.mainThreadNeedExit = true;
    Log.d(JNIConst.LOG_TAG, "[Activity::onDestroy] c++ main thread join start");
    if (JNIApplication.mainCPPThread != null) {}
    try
    {
      JNIApplication.mainCPPThread.join();
      JNIApplication.mainCPPThread = null;
      Log.d(JNIConst.LOG_TAG, "[Activity::onDestroy] c++ main thread join end");
      super.onDestroy();
      Log.d(JNIConst.LOG_TAG, "[Activity::onDestroy] out");
      Log.d(JNIConst.LOG_TAG, "[Activity::onDestroy] System exit");
      System.exit(0);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.v(JNIConst.LOG_TAG, "Problem stopping mainCPPThread: " + localException);
      }
    }
  }
  
  public void onInputDeviceAdded(int paramInt)
  {
    UpdateGamepadAxises();
  }
  
  public void onInputDeviceChanged(int paramInt)
  {
    UpdateGamepadAxises();
  }
  
  public void onInputDeviceRemoved(int paramInt)
  {
    UpdateGamepadAxises();
  }
  
  protected void onPause()
  {
    Log.d(JNIConst.LOG_TAG, "[Activity::onPause] in");
    this.inputManager.unregisterInputDeviceListener(this);
    if ((this.accelerometer != null) && (this.accelerometer.IsActive())) {
      this.accelerometer.Stop();
    }
    handleSuspend();
    DestroyKeyboardLayout();
    super.onPause();
    Log.d(JNIConst.LOG_TAG, "[Activity::onPause] out");
  }
  
  protected void onRestart()
  {
    Log.d(JNIConst.LOG_TAG, "[Activity::onRestart] in");
    super.onRestart();
    Log.d(JNIConst.LOG_TAG, "[Activity::onRestart] out");
  }
  
  protected void onResume()
  {
    Log.d(JNIConst.LOG_TAG, "[Activity::onResume] in");
    super.onResume();
    if ((this.accelerometer != null) && (this.accelerometer.IsSupported())) {
      this.accelerometer.Start();
    }
    this.inputManager.registerInputDeviceListener(this, null);
    UpdateGamepadAxises();
    JNIUtils.keepScreenOnOnResume();
    JNITextField.RelinkNativeControls();
    JNIWebView.RelinkNativeControls();
    handleResume();
    Runnable local5 = new Runnable()
    {
      public void run()
      {
        JNIActivity.HideNavigationBar(JNIActivity.this.getWindow().getDecorView());
      }
    };
    new Handler(Looper.getMainLooper()).postDelayed(local5, 500L);
    Log.d(JNIConst.LOG_TAG, "[Activity::onResume] out");
  }
  
  protected void onStart()
  {
    Log.d(JNIConst.LOG_TAG, "[Activity::onStart] in");
    super.onStart();
    this.fmodDevice.start();
    if (isFocused) {
      HideSplashScreenView();
    }
    RunOnMainLoopThread(new Runnable()
    {
      public void run()
      {
        JNIActivity.this.nativeOnStart();
      }
    });
    Log.d(JNIConst.LOG_TAG, "[Activity::onStart] out");
  }
  
  protected void onStop()
  {
    Log.d(JNIConst.LOG_TAG, "[Activity::onStop] in");
    ShowSplashScreenView();
    RunOnMainLoopThread(new Runnable()
    {
      public void run()
      {
        JNIActivity.this.nativeOnStop();
      }
    });
    this.fmodDevice.stop();
    super.onStop();
    Log.d(JNIConst.LOG_TAG, "[Activity::onStop] out");
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    Log.d(JNIConst.LOG_TAG, "[Activity::onWindowFocusChanged] in");
    super.onWindowFocusChanged(paramBoolean);
    isFocused = paramBoolean;
    handleResume();
    if (paramBoolean)
    {
      HideSplashScreenView();
      HideNavigationBar(getWindow().getDecorView());
      InitKeyboardLayout();
    }
    Log.d(JNIConst.LOG_TAG, "[Activity::onWindowFocusChanged] out");
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/JNIActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */