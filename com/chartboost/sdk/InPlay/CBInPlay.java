package com.chartboost.sdk.InPlay;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.e.a;
import com.chartboost.sdk.Model.CBError.CBImpressionError;
import com.chartboost.sdk.c;

public final class CBInPlay
{
  private static final String a = CBInPlay.class.getSimpleName();
  private static a f = null;
  private String b;
  private Bitmap c;
  private String d;
  private e.a e;
  
  public static void cacheInPlay(String paramString)
  {
    if (((c.H().booleanValue()) && (c.L())) || ((!c.N()) || (!c.R()) || (!c.r()))) {}
    do
    {
      return;
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
      CBLogging.b(a, "Inplay location cannot be empty");
    } while (c.h() == null);
    c.h().didFailToLoadInPlay(paramString, CBError.CBImpressionError.INVALID_LOCATION);
    return;
    if (f == null) {
      f = a.a();
    }
    f.a(paramString);
  }
  
  public static CBInPlay getInPlay(String paramString)
  {
    if (((c.H().booleanValue()) && (c.L())) || ((!c.N()) || (!c.R()) || (!c.r()))) {}
    do
    {
      return null;
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
      CBLogging.b(a, "Inplay location cannot be empty");
    } while (c.h() == null);
    c.h().didFailToLoadInPlay(paramString, CBError.CBImpressionError.INVALID_LOCATION);
    return null;
    if (f == null) {
      f = a.a();
    }
    return f.c(paramString);
  }
  
  public static boolean hasInPlay(String paramString)
  {
    if (!c.r()) {}
    do
    {
      return false;
      if (!TextUtils.isEmpty(paramString)) {
        break;
      }
      CBLogging.b(a, "Inplay location cannot be empty");
    } while (c.h() == null);
    c.h().didFailToLoadInPlay(paramString, CBError.CBImpressionError.INVALID_LOCATION);
    return false;
    if (f == null) {
      f = a.a();
    }
    return f.b(paramString);
  }
  
  protected e.a a()
  {
    return this.e;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    this.c = paramBitmap;
  }
  
  protected void a(e.a parama)
  {
    this.e = parama;
  }
  
  protected void a(String paramString)
  {
    this.b = paramString;
  }
  
  protected void b(String paramString)
  {
    this.d = paramString;
  }
  
  public void click()
  {
    a.a().b(this);
  }
  
  public Bitmap getAppIcon()
  {
    return this.c;
  }
  
  public String getAppName()
  {
    return this.d;
  }
  
  public String getLocation()
  {
    return this.b;
  }
  
  public void show()
  {
    a.a().a(this);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/chartboost/sdk/InPlay/CBInPlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */