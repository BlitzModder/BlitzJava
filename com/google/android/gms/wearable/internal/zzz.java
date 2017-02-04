package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public final class zzz
  extends zzc
  implements DataEvent
{
  private final int zzaBl;
  
  public zzz(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.zzaBl = paramInt2;
  }
  
  public DataItem getDataItem()
  {
    return new zzaf(this.zzafC, this.zzahw, this.zzaBl);
  }
  
  public int getType()
  {
    return getInteger("event_type");
  }
  
  public String toString()
  {
    String str;
    if (getType() == 1) {
      str = "changed";
    }
    for (;;)
    {
      return "DataEventRef{ type=" + str + ", dataitem=" + getDataItem() + " }";
      if (getType() == 2) {
        str = "deleted";
      } else {
        str = "unknown";
      }
    }
  }
  
  public DataEvent zzGM()
  {
    return new zzy(this);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */