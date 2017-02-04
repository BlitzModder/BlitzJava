package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.internal.zzae;
import java.util.ArrayList;

public class ExceptionReporter
  implements Thread.UncaughtExceptionHandler
{
  private final Context mContext;
  private final Thread.UncaughtExceptionHandler zzNG;
  private final Tracker zzNH;
  private ExceptionParser zzNI;
  private GoogleAnalytics zzNJ;
  
  public ExceptionReporter(Tracker paramTracker, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler, Context paramContext)
  {
    if (paramTracker == null) {
      throw new NullPointerException("tracker cannot be null");
    }
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.zzNG = paramUncaughtExceptionHandler;
    this.zzNH = paramTracker;
    this.zzNI = new StandardExceptionParser(paramContext, new ArrayList());
    this.mContext = paramContext.getApplicationContext();
    paramContext = new StringBuilder().append("ExceptionReporter created, original handler is ");
    if (paramUncaughtExceptionHandler == null) {}
    for (paramTracker = "null";; paramTracker = paramUncaughtExceptionHandler.getClass().getName())
    {
      zzae.v(paramTracker);
      return;
    }
  }
  
  public ExceptionParser getExceptionParser()
  {
    return this.zzNI;
  }
  
  public void setExceptionParser(ExceptionParser paramExceptionParser)
  {
    this.zzNI = paramExceptionParser;
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    Object localObject = "UncaughtException";
    if (this.zzNI != null) {
      if (paramThread == null) {
        break label115;
      }
    }
    label115:
    for (localObject = paramThread.getName();; localObject = null)
    {
      localObject = this.zzNI.getDescription((String)localObject, paramThrowable);
      zzae.v("Reporting uncaught exception: " + (String)localObject);
      this.zzNH.send(new HitBuilders.ExceptionBuilder().setDescription((String)localObject).setFatal(true).build());
      localObject = zzik();
      ((GoogleAnalytics)localObject).dispatchLocalHits();
      ((GoogleAnalytics)localObject).zzio();
      if (this.zzNG != null)
      {
        zzae.v("Passing exception to the original handler");
        this.zzNG.uncaughtException(paramThread, paramThrowable);
      }
      return;
    }
  }
  
  GoogleAnalytics zzik()
  {
    if (this.zzNJ == null) {
      this.zzNJ = GoogleAnalytics.getInstance(this.mContext);
    }
    return this.zzNJ;
  }
  
  Thread.UncaughtExceptionHandler zzil()
  {
    return this.zzNG;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/ExceptionReporter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */