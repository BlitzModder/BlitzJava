package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzmp;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class zzb
  extends AsyncTaskLoader<Void>
  implements zzmp
{
  private Semaphore zzVR = new Semaphore(0);
  private Set<GoogleApiClient> zzVS;
  
  public zzb(Context paramContext, Set<GoogleApiClient> paramSet)
  {
    super(paramContext);
    this.zzVS = paramSet;
  }
  
  protected void onStartLoading()
  {
    this.zzVR.drainPermits();
    forceLoad();
  }
  
  public Void zzmH()
  {
    Iterator localIterator = this.zzVS.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      if (!((GoogleApiClient)localIterator.next()).zza(this)) {
        break label80;
      }
      i += 1;
    }
    label80:
    for (;;)
    {
      break;
      try
      {
        this.zzVR.tryAcquire(i, 5L, TimeUnit.SECONDS);
        return null;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Log.i("GACSignInLoader", "Unexpected InterruptedException", localInterruptedException);
          Thread.currentThread().interrupt();
        }
      }
    }
  }
  
  public void zzmI()
  {
    this.zzVR.release();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/signin/internal/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */