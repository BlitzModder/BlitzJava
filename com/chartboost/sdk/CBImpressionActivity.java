package com.chartboost.sdk;

import android.app.Activity;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.RelativeLayout;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.k;
import com.chartboost.sdk.impl.az;

public class CBImpressionActivity
  extends Activity
{
  protected static final String a = CBImpressionActivity.class.getSimpleName();
  private Activity b = null;
  private PhoneStateListener c = new PhoneStateListener()
  {
    public void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
    {
      if (paramAnonymousInt == 1)
      {
        CBLogging.a(CBImpressionActivity.a, "##### Phone call State: Ringing");
        CBLogging.a(CBImpressionActivity.a, "##### Pausing the impression");
        CBImpressionActivity.this.onPause();
      }
      for (;;)
      {
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        return;
        if (paramAnonymousInt == 0)
        {
          CBLogging.a(CBImpressionActivity.a, "##### Phone call State: Idle");
          CBLogging.a(CBImpressionActivity.a, "##### Resuming the impression");
          CBImpressionActivity.this.onResume();
        }
        else if (paramAnonymousInt == 2)
        {
          CBLogging.a(CBImpressionActivity.a, "##### Phone call State: OffHook");
          CBLogging.a(CBImpressionActivity.a, "##### Pausing the impression");
          CBImpressionActivity.this.onPause();
        }
      }
    }
  };
  
  protected static void a(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT < 14) {
      CBUtility.e().post(new Runnable()
      {
        public void run()
        {
          CBLogging.e("VideoInit", "preparing activity for video surface");
          SurfaceView localSurfaceView = new SurfaceView(this.a);
          this.a.addContentView(localSurfaceView, new ViewGroup.LayoutParams(0, 0));
        }
      });
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.b != null) {
      return this.b.dispatchTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void forwardTouchEvents(Activity paramActivity)
  {
    this.b = paramActivity;
  }
  
  public void onBackPressed()
  {
    if (Chartboost.d()) {
      return;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setFlags(16777216, 16777216);
    requestWindowFeature(1);
    getWindow().setWindowAnimations(0);
    Chartboost.a(this);
    setContentView(new RelativeLayout(this));
    a(this);
    az.a(this).d();
    CBLogging.a(CBImpressionActivity.class.getName(), "Impression Activity onCreate() called");
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (!Chartboost.i()) {
      Chartboost.b(this);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (!Chartboost.i()) {
      Chartboost.b(k.a(this));
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (!Chartboost.i()) {
      Chartboost.a(k.a(this));
    }
    CBUtility.a(this);
  }
  
  protected void onStart()
  {
    super.onStart();
    if (!Chartboost.i()) {
      Chartboost.a(this);
    }
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)getSystemService("phone");
      if (localTelephonyManager != null) {
        localTelephonyManager.listen(this.c, 32);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (!Chartboost.i()) {
      Chartboost.c(k.a(this));
    }
    try
    {
      ((TelephonyManager)getSystemService("phone")).listen(this.c, 0);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/CBImpressionActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */