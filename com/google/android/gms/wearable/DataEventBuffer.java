package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;
import com.google.android.gms.wearable.internal.zzz;

public class DataEventBuffer
  extends zzf<DataEvent>
  implements Result
{
  private final Status zzTA;
  
  public DataEventBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.zzTA = new Status(paramDataHolder.getStatusCode());
  }
  
  public Status getStatus()
  {
    return this.zzTA;
  }
  
  protected String zzpO()
  {
    return "path";
  }
  
  protected DataEvent zzv(int paramInt1, int paramInt2)
  {
    return new zzz(this.zzafC, paramInt1, paramInt2);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/DataEventBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */