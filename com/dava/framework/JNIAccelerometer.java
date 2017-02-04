package com.dava.framework;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import java.util.List;

public class JNIAccelerometer
{
  private static Boolean isSupported = null;
  private static Sensor sensor = null;
  private static SensorManager sensorManager = null;
  private boolean isActive = false;
  private JNIAccelerometerListener jniListener = null;
  private JNISensorEventListener sensorEventListener = null;
  
  public JNIAccelerometer(JNIAccelerometerListener paramJNIAccelerometerListener, SensorManager paramSensorManager)
  {
    SetListener(paramJNIAccelerometerListener);
    SetManager(paramSensorManager);
  }
  
  private void SetListener(JNIAccelerometerListener paramJNIAccelerometerListener)
  {
    this.jniListener = paramJNIAccelerometerListener;
  }
  
  private void SetManager(SensorManager paramSensorManager)
  {
    sensorManager = paramSensorManager;
  }
  
  public boolean IsActive()
  {
    return this.isActive;
  }
  
  public boolean IsSupported()
  {
    boolean bool = true;
    if (isSupported == null)
    {
      if (sensorManager == null) {
        break label52;
      }
      if (sensorManager.getSensorList(1).size() <= 0) {
        break label47;
      }
    }
    label47:
    label52:
    for (isSupported = new Boolean(bool);; isSupported = Boolean.FALSE)
    {
      return isSupported.booleanValue();
      bool = false;
      break;
    }
  }
  
  public void Start()
  {
    if (sensorManager != null)
    {
      List localList = sensorManager.getSensorList(1);
      if (localList.size() > 0)
      {
        sensor = (Sensor)localList.get(0);
        this.isActive = sensorManager.registerListener(this.sensorEventListener, sensor, 1);
      }
    }
  }
  
  public void Stop()
  {
    this.isActive = false;
    try
    {
      if ((sensorManager != null) && (this.sensorEventListener != null)) {
        sensorManager.unregisterListener(this.sensorEventListener);
      }
      return;
    }
    catch (Exception localException)
    {
      Log.e(JNIConst.LOG_TAG, "[JNIAccelerometer.Stop] exception = " + localException.getMessage());
    }
  }
  
  public static abstract interface JNIAccelerometerListener
  {
    public abstract void onAccelerationChanged(float paramFloat1, float paramFloat2, float paramFloat3);
  }
  
  public class JNISensorEventListener
    implements SensorEventListener
  {
    public JNISensorEventListener() {}
    
    public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public void onSensorChanged(SensorEvent paramSensorEvent)
    {
      if (JNIAccelerometer.this.jniListener != null)
      {
        float f1 = paramSensorEvent.values[0];
        float f2 = paramSensorEvent.values[1];
        float f3 = paramSensorEvent.values[2];
        JNIAccelerometer.this.jniListener.onAccelerationChanged(f1, f2, f3);
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/JNIAccelerometer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */