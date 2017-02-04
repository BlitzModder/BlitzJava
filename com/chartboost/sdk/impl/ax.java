package com.chartboost.sdk.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.c;
import java.util.Observable;

public class ax
  extends Observable
{
  private static ax c = null;
  private static b d = b.a;
  private boolean a = true;
  private boolean b = false;
  private a e = null;
  
  public static ax a()
  {
    if (c == null) {
      c = new ax();
    }
    return c;
  }
  
  public static Integer d()
  {
    try
    {
      Object localObject = ((ConnectivityManager)c.y().getSystemService("connectivity")).getActiveNetworkInfo();
      if ((localObject != null) && (((NetworkInfo)localObject).isConnectedOrConnecting())) {}
      for (int i = 1; i != 0; i = 0)
      {
        localObject = (TelephonyManager)c.y().getSystemService("phone");
        if (localObject == null) {
          break;
        }
        i = ((TelephonyManager)localObject).getNetworkType();
        return Integer.valueOf(i);
      }
      return null;
    }
    catch (SecurityException localSecurityException)
    {
      CBLogging.b("CBReachability", "Chartboost SDK requires 'android.permission.ACCESS_NETWORK_STATE' permission set in your AndroidManifest.xml");
    }
  }
  
  public void a(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramContext != null) && (paramContext.isConnectedOrConnecting()))
      {
        a(true);
        if (paramContext.getType() == 1)
        {
          d = b.c;
          CBLogging.a("CBReachability", "NETWORK TYPE: TYPE_WIFI");
          return;
        }
        if (paramContext.getType() != 0) {
          return;
        }
        d = b.d;
        CBLogging.a("CBReachability", "NETWORK TYPE: TYPE_MOBILE");
        return;
      }
    }
    catch (SecurityException paramContext)
    {
      d = b.a;
      CBLogging.b("CBReachability", "Chartboost SDK requires 'android.permission.ACCESS_NETWORK_STATE' permission set in your AndroidManifest.xml");
      return;
    }
    a(false);
    d = b.b;
    CBLogging.a("CBReachability", "NETWORK TYPE: NO Network");
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public int b()
  {
    return d.a();
  }
  
  public Intent b(Context paramContext)
  {
    if ((paramContext != null) && (!this.b))
    {
      b(true);
      CBLogging.a("CBReachability", "Network broadcast successfully registered");
      return paramContext.registerReceiver(this.e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }
    return null;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void c(Context paramContext)
  {
    if ((paramContext != null) && (this.b))
    {
      paramContext.unregisterReceiver(this.e);
      b(false);
      CBLogging.a("CBReachability", "Network broadcast successfully unregistered");
    }
  }
  
  public boolean c()
  {
    return this.a;
  }
  
  public void notifyObservers()
  {
    if (this.a)
    {
      setChanged();
      super.notifyObservers(this);
    }
  }
  
  private class a
    extends BroadcastReceiver
  {
    public a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramIntent = ax.a();
      paramIntent.a(paramContext);
      paramIntent.notifyObservers();
    }
  }
  
  public static enum b
  {
    private int e;
    
    private b(int paramInt)
    {
      this.e = paramInt;
    }
    
    public int a()
    {
      return this.e;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/impl/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */