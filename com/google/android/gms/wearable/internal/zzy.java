package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;

public class zzy
  implements DataEvent
{
  private int zzZU;
  private DataItem zzbnq;
  
  public zzy(DataEvent paramDataEvent)
  {
    this.zzZU = paramDataEvent.getType();
    this.zzbnq = ((DataItem)paramDataEvent.getDataItem().freeze());
  }
  
  public DataItem getDataItem()
  {
    return this.zzbnq;
  }
  
  public int getType()
  {
    return this.zzZU;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    String str;
    if (getType() == 1) {
      str = "changed";
    }
    for (;;)
    {
      return "DataEventEntity{ type=" + str + ", dataitem=" + getDataItem() + " }";
      if (getType() == 2) {
        str = "deleted";
      } else {
        str = "unknown";
      }
    }
  }
  
  public DataEvent zzGM()
  {
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */