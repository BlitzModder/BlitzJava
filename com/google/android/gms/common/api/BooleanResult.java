package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzx;

public class BooleanResult
  implements Result
{
  private final Status zzTA;
  private final boolean zzaey;
  
  public BooleanResult(Status paramStatus, boolean paramBoolean)
  {
    this.zzTA = ((Status)zzx.zzb(paramStatus, "Status must not be null"));
    this.zzaey = paramBoolean;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof BooleanResult)) {
        return false;
      }
      paramObject = (BooleanResult)paramObject;
    } while ((this.zzTA.equals(((BooleanResult)paramObject).zzTA)) && (this.zzaey == ((BooleanResult)paramObject).zzaey));
    return false;
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
  
  public boolean getValue()
  {
    return this.zzaey;
  }
  
  public final int hashCode()
  {
    int j = this.zzTA.hashCode();
    if (this.zzaey) {}
    for (int i = 1;; i = 0) {
      return i + (j + 527) * 31;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/api/BooleanResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */