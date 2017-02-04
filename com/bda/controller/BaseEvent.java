package com.bda.controller;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class BaseEvent
  implements Parcelable
{
  public static final Parcelable.Creator<BaseEvent> CREATOR = new ParcelableCreator();
  final int mControllerId;
  final long mEventTime;
  
  public BaseEvent(long paramLong, int paramInt)
  {
    this.mEventTime = paramLong;
    this.mControllerId = paramInt;
  }
  
  BaseEvent(Parcel paramParcel)
  {
    this.mEventTime = paramParcel.readLong();
    this.mControllerId = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final int getControllerId()
  {
    return this.mControllerId;
  }
  
  public final long getEventTime()
  {
    return this.mEventTime;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.mEventTime);
    paramParcel.writeInt(this.mControllerId);
  }
  
  static class ParcelableCreator
    implements Parcelable.Creator<BaseEvent>
  {
    public BaseEvent createFromParcel(Parcel paramParcel)
    {
      return new BaseEvent(paramParcel);
    }
    
    public BaseEvent[] newArray(int paramInt)
    {
      return new BaseEvent[paramInt];
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/bda/controller/BaseEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */