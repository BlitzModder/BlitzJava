package com.google.android.gms.common.api;

import com.google.android.gms.internal.zzly;

public abstract class ResultCallbacks<R extends Result>
  implements ResultCallback<R>
{
  public abstract void onFailure(Status paramStatus);
  
  public final void onResult(R paramR)
  {
    Status localStatus = paramR.getStatus();
    if (localStatus.isSuccess())
    {
      onSuccess(paramR);
      return;
    }
    onFailure(localStatus);
    zzly.zzd(paramR);
  }
  
  public abstract void onSuccess(R paramR);
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/api/ResultCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */