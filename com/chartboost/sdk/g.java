package com.chartboost.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Libraries.e.a;
import com.chartboost.sdk.Libraries.f;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.Model.a;
import com.chartboost.sdk.Model.a.b;
import com.chartboost.sdk.impl.bg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class g
{
  public static Handler a = ;
  public boolean b = false;
  protected e.a c;
  protected List<b> d = new ArrayList();
  protected List<b> e = new ArrayList();
  protected e.a f;
  protected a g;
  protected f h;
  public Map<Integer, Runnable> i = Collections.synchronizedMap(new HashMap());
  protected boolean j = true;
  protected boolean k = true;
  private boolean l;
  private a m;
  
  public g(a parama)
  {
    this.g = parama;
    this.m = null;
    this.h = CBUtility.c();
    this.l = false;
  }
  
  public static int a(String paramString)
  {
    int n = 0;
    String str2;
    if (paramString != null)
    {
      String str1 = paramString;
      if (paramString.startsWith("#")) {}
    }
    else
    {
      try
      {
        n = Color.parseColor(paramString);
        return n;
      }
      catch (IllegalArgumentException localIllegalArgumentException1)
      {
        str2 = "#" + paramString;
      }
    }
    if (str2.length() != 4)
    {
      paramString = str2;
      if (str2.length() != 5) {}
    }
    else
    {
      paramString = new StringBuilder(str2.length() * 2 + 1);
      paramString.append("#");
      n = 0;
      while (n < str2.length() - 1)
      {
        paramString.append(str2.charAt(n + 1));
        paramString.append(str2.charAt(n + 1));
        n += 1;
      }
      paramString = paramString.toString();
    }
    try
    {
      n = Color.parseColor(paramString);
      return n;
    }
    catch (IllegalArgumentException localIllegalArgumentException2)
    {
      CBLogging.d("CBViewProtocol", "error parsing color " + paramString, localIllegalArgumentException2);
    }
    return 0;
  }
  
  public static boolean a(Context paramContext)
  {
    return (paramContext.getResources().getConfiguration().screenLayout & 0xF) >= 4;
  }
  
  public f a()
  {
    return this.h;
  }
  
  protected void a(View paramView, Runnable paramRunnable, long paramLong)
  {
    Runnable localRunnable = (Runnable)this.i.get(Integer.valueOf(paramView.hashCode()));
    if (localRunnable != null) {
      a.removeCallbacks(localRunnable);
    }
    this.i.put(Integer.valueOf(paramView.hashCode()), paramRunnable);
    a.postDelayed(paramRunnable, paramLong);
  }
  
  protected void a(CBError.CBImpressionError paramCBImpressionError)
  {
    this.g.a(paramCBImpressionError);
  }
  
  public void a(b paramb)
  {
    if (paramb.a()) {
      this.e.remove(paramb);
    }
    this.d.remove(paramb);
    if ((!this.d.isEmpty()) || (b())) {
      return;
    }
    CBLogging.b("CBViewProtocol", "Error while downloading the assets");
    a(CBError.CBImpressionError.ASSETS_DOWNLOAD_FAILURE);
  }
  
  public void a(boolean paramBoolean, View paramView)
  {
    a(paramBoolean, paramView, true);
  }
  
  public void a(final boolean paramBoolean1, final View paramView, boolean paramBoolean2)
  {
    int n = 8;
    if (((paramBoolean1) && (paramView.getVisibility() == 0)) || ((!paramBoolean1) && (paramView.getVisibility() == 8) && (this.i.get(Integer.valueOf(paramView.hashCode())) == null))) {
      return;
    }
    if (!paramBoolean2)
    {
      if (paramBoolean1) {
        n = 0;
      }
      paramView.setVisibility(n);
      paramView.setClickable(paramBoolean1);
      return;
    }
    Runnable local1 = new Runnable()
    {
      public void run()
      {
        if (!paramBoolean1)
        {
          paramView.setVisibility(8);
          paramView.setClickable(false);
        }
        g.this.i.remove(Integer.valueOf(paramView.hashCode()));
      }
    };
    if (this.g.a == a.b.b) {}
    bg.a(paramBoolean1, paramView, 500L);
    a(paramView, local1, 500L);
  }
  
  public boolean a(e.a parama)
  {
    this.f = parama.a("assets");
    if (this.f.b())
    {
      CBLogging.b("CBViewProtocol", "Media got from the response is null or empty");
      a(CBError.CBImpressionError.INVALID_RESPONSE);
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString, e.a parama)
  {
    return this.g.a(paramString, parama);
  }
  
  protected abstract a b(Context paramContext);
  
  public void b(b paramb)
  {
    this.d.add(paramb);
    this.e.add(paramb);
  }
  
  public boolean b()
  {
    if (!this.e.isEmpty())
    {
      CBLogging.d("CBViewProtocol", "not completed loading assets for impression");
      return false;
    }
    i();
    return true;
  }
  
  public CBError.CBImpressionError c()
  {
    Object localObject2 = null;
    Activity localActivity = Chartboost.f();
    Object localObject1;
    if (localActivity == null)
    {
      this.m = null;
      localObject1 = CBError.CBImpressionError.NO_HOST_ACTIVITY;
    }
    do
    {
      do
      {
        return (CBError.CBImpressionError)localObject1;
        if ((!this.k) && (!this.j)) {
          return CBError.CBImpressionError.WRONG_ORIENTATION;
        }
        if (this.m == null) {
          this.m = b(localActivity);
        }
        localObject1 = localObject2;
      } while (this.g.a != a.b.a);
      localObject1 = localObject2;
    } while (this.m.a(localActivity));
    this.m = null;
    return CBError.CBImpressionError.ERROR_CREATING_VIEW;
  }
  
  public void d()
  {
    f();
    int n = 0;
    while (n < this.i.size())
    {
      a.removeCallbacks((Runnable)this.i.get(Integer.valueOf(n)));
      n += 1;
    }
    this.i.clear();
  }
  
  public a e()
  {
    return this.m;
  }
  
  public void f()
  {
    if (this.m != null) {
      this.m.b();
    }
    this.m = null;
  }
  
  public e.a g()
  {
    return this.f;
  }
  
  protected void h()
  {
    if (this.l) {
      return;
    }
    this.l = true;
    this.g.c();
  }
  
  protected void i()
  {
    this.g.d();
  }
  
  public float j()
  {
    return 0.0F;
  }
  
  public float k()
  {
    return 0.0F;
  }
  
  public boolean l()
  {
    return false;
  }
  
  public void m()
  {
    if (this.b) {
      this.b = false;
    }
    if ((e() != null) && (CBUtility.c() != a.a(e()))) {
      e().a(false);
    }
  }
  
  public void n()
  {
    this.b = true;
  }
  
  public abstract class a
    extends RelativeLayout
  {
    private boolean b = false;
    private int c = -1;
    private int d = -1;
    private int e = -1;
    private int f = -1;
    private f g = null;
    
    public a(Context paramContext)
    {
      super();
      g.a(g.this, this);
      g.a(g.this, false);
      setFocusableInTouchMode(true);
      requestFocus();
    }
    
    private boolean b(int paramInt1, int paramInt2)
    {
      bool = true;
      if ((g.this.g != null) && (g.this.g.a == a.b.b)) {}
      f localf;
      do
      {
        return true;
        if (this.b) {
          return false;
        }
        localf = CBUtility.c();
      } while ((this.c == paramInt1) && (this.d == paramInt2) && (this.g == localf));
      this.b = true;
      for (;;)
      {
        try
        {
          if ((!g.this.j) || (!localf.a())) {
            continue;
          }
          g.this.h = localf;
          a(paramInt1, paramInt2);
          post(new Runnable()
          {
            public void run()
            {
              g.a.this.requestLayout();
            }
          });
          this.c = paramInt1;
          this.d = paramInt2;
          this.g = localf;
        }
        catch (Exception localException)
        {
          CBLogging.b("CBViewProtocol", "Exception raised while layouting Subviews", localException);
          bool = false;
          continue;
        }
        this.b = false;
        return bool;
        if ((g.this.k) && (localf.b())) {
          g.this.h = localf;
        }
      }
    }
    
    public final void a()
    {
      a(false);
    }
    
    protected abstract void a(int paramInt1, int paramInt2);
    
    public final void a(View paramView)
    {
      int i = 200;
      if (200 == getId()) {
        i = 201;
      }
      for (View localView = findViewById(i); localView != null; localView = findViewById(i)) {
        i += 1;
      }
      paramView.setId(i);
      paramView.setSaveEnabled(false);
    }
    
    public final void a(boolean paramBoolean)
    {
      if (paramBoolean) {
        this.g = null;
      }
      a((Activity)getContext());
    }
    
    public boolean a(Activity paramActivity)
    {
      if ((this.e == -1) || (this.f == -1)) {}
      try
      {
        j = getWidth();
        k = getHeight();
        if (j != 0)
        {
          i = k;
          if (k != 0) {}
        }
        else
        {
          View localView = paramActivity.getWindow().findViewById(16908290);
          localObject = localView;
          if (localView == null) {
            localObject = paramActivity.getWindow().getDecorView();
          }
          j = ((View)localObject).getWidth();
          i = ((View)localObject).getHeight();
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int k;
          Object localObject;
          int i = 0;
          int j = 0;
        }
      }
      if (j != 0)
      {
        k = i;
        if (i != 0) {}
      }
      else
      {
        localObject = new DisplayMetrics();
        paramActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        j = ((DisplayMetrics)localObject).widthPixels;
        k = ((DisplayMetrics)localObject).heightPixels;
      }
      this.e = j;
      this.f = k;
      return b(this.e, this.f);
    }
    
    public void b() {}
    
    protected boolean c()
    {
      return g.a(getContext());
    }
    
    public void onDetachedFromWindow()
    {
      super.onDetachedFromWindow();
      int i = 0;
      while (i < g.this.i.size())
      {
        g.a.removeCallbacks((Runnable)g.this.i.get(Integer.valueOf(i)));
        i += 1;
      }
      g.this.i.clear();
    }
    
    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      this.e = paramInt1;
      this.f = paramInt2;
      if ((this.c != -1) && (this.d != -1) && (g.this.g != null) && (g.this.g.a == a.b.a)) {
        a();
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract boolean a();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */