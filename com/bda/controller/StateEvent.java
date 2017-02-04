package com.bda.controller;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class StateEvent
  extends BaseEvent
  implements Parcelable
{
  public static final int ACTION_CONNECTED = 1;
  public static final int ACTION_CONNECTING = 2;
  public static final int ACTION_DISCONNECTED = 0;
  public static final int ACTION_FALSE = 0;
  public static final int ACTION_TRUE = 1;
  public static final int ACTION_VERSION_MOGA = 0;
  public static final int ACTION_VERSION_MOGAPRO = 1;
  public static final Parcelable.Creator<StateEvent> CREATOR = new ParcelableCreator();
  public static final int STATE_CONNECTION = 1;
  public static final int STATE_CURRENT_PRODUCT_VERSION = 4;
  public static final int STATE_POWER_LOW = 2;
  @Deprecated
  public static final int STATE_SELECTED_VERSION = 4;
  public static final int STATE_SUPPORTED_PRODUCT_VERSION = 3;
  @Deprecated
  public static final int STATE_SUPPORTED_VERSION = 3;
  public static final int STATE_UNKNOWN = 0;
  final int mAction;
  final int mState;
  
  public StateEvent(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramLong, paramInt1);
    this.mState = paramInt2;
    this.mAction = paramInt3;
  }
  
  StateEvent(Parcel paramParcel)
  {
    super(paramParcel);
    this.mState = paramParcel.readInt();
    this.mAction = paramParcel.readInt();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final int getAction()
  {
    return this.mAction;
  }
  
  public final int getState()
  {
    return this.mState;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mState);
    paramParcel.writeInt(this.mAction);
  }
  
  static class ParcelableCreator
    implements Parcelable.Creator<StateEvent>
  {
    public StateEvent createFromParcel(Parcel paramParcel)
    {
      return new StateEvent(paramParcel);
    }
    
    public StateEvent[] newArray(int paramInt)
    {
      return new StateEvent[paramInt];
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/bda/controller/StateEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */