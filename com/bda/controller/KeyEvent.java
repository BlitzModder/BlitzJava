package com.bda.controller;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class KeyEvent
  extends BaseEvent
  implements Parcelable
{
  public static final int ACTION_DOWN = 0;
  public static final int ACTION_UP = 1;
  public static final Parcelable.Creator<KeyEvent> CREATOR = new ParcelableCreator();
  public static final int KEYCODE_BUTTON_A = 96;
  public static final int KEYCODE_BUTTON_B = 97;
  public static final int KEYCODE_BUTTON_L1 = 102;
  public static final int KEYCODE_BUTTON_L2 = 104;
  public static final int KEYCODE_BUTTON_R1 = 103;
  public static final int KEYCODE_BUTTON_R2 = 105;
  public static final int KEYCODE_BUTTON_SELECT = 109;
  public static final int KEYCODE_BUTTON_START = 108;
  public static final int KEYCODE_BUTTON_THUMBL = 106;
  public static final int KEYCODE_BUTTON_THUMBR = 107;
  public static final int KEYCODE_BUTTON_X = 99;
  public static final int KEYCODE_BUTTON_Y = 100;
  public static final int KEYCODE_DPAD_DOWN = 20;
  public static final int KEYCODE_DPAD_LEFT = 21;
  public static final int KEYCODE_DPAD_RIGHT = 22;
  public static final int KEYCODE_DPAD_UP = 19;
  public static final int KEYCODE_UNKNOWN = 0;
  final int mAction;
  final int mKeyCode;
  
  public KeyEvent(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramLong, paramInt1);
    this.mKeyCode = paramInt2;
    this.mAction = paramInt3;
  }
  
  KeyEvent(Parcel paramParcel)
  {
    super(paramParcel);
    this.mKeyCode = paramParcel.readInt();
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
  
  public final int getKeyCode()
  {
    return this.mKeyCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeInt(this.mKeyCode);
    paramParcel.writeInt(this.mAction);
  }
  
  static class ParcelableCreator
    implements Parcelable.Creator<KeyEvent>
  {
    public KeyEvent createFromParcel(Parcel paramParcel)
    {
      return new KeyEvent(paramParcel);
    }
    
    public KeyEvent[] newArray(int paramInt)
    {
      return new KeyEvent[paramInt];
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/bda/controller/KeyEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */