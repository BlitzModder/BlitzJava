package com.google.android.gms.internal;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzmc
  implements Releasable, Result
{
  protected final Status zzTA;
  protected final DataHolder zzafC;
  
  protected zzmc(DataHolder paramDataHolder, Status paramStatus)
  {
    this.zzTA = paramStatus;
    this.zzafC = paramDataHolder;
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
  
  public void release()
  {
    if (this.zzafC != null) {
      this.zzafC.close();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzmc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */