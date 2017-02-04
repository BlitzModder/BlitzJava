package com.chartboost.sdk.Libraries;

import android.app.Activity;
import android.content.Context;
import com.chartboost.sdk.c;
import java.lang.ref.WeakReference;

public final class k
  extends WeakReference<Activity>
{
  private static k b;
  private int a;
  
  private k(Activity paramActivity)
  {
    super(paramActivity);
    this.a = paramActivity.hashCode();
  }
  
  public static k a(Activity paramActivity)
  {
    if ((b == null) || (b.a != paramActivity.hashCode())) {
      b = new k(paramActivity);
    }
    return b;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public boolean a(k paramk)
  {
    if (paramk == null) {}
    while (paramk.a() != this.a) {
      return false;
    }
    return true;
  }
  
  public Context b()
  {
    Context localContext2 = (Context)get();
    Context localContext1 = localContext2;
    if (localContext2 == null) {
      localContext1 = c.y();
    }
    return localContext1;
  }
  
  public boolean b(Activity paramActivity)
  {
    if (paramActivity == null) {}
    while (paramActivity.hashCode() != this.a) {
      return false;
    }
    return true;
  }
  
  public int hashCode()
  {
    return a();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/Libraries/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */