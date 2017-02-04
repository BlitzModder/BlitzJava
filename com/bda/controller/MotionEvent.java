package com.bda.controller;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.SparseArray;

public final class MotionEvent
  extends BaseEvent
  implements Parcelable
{
  public static final int AXIS_LTRIGGER = 17;
  public static final int AXIS_RTRIGGER = 18;
  public static final int AXIS_RZ = 14;
  public static final int AXIS_X = 0;
  public static final int AXIS_Y = 1;
  public static final int AXIS_Z = 11;
  public static final Parcelable.Creator<MotionEvent> CREATOR = new ParcelableCreator();
  final SparseArray<Float> mAxis;
  final SparseArray<Float> mPrecision;
  
  public MotionEvent(long paramLong, int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    super(paramLong, paramInt);
    this.mAxis = new SparseArray(4);
    this.mAxis.put(0, Float.valueOf(paramFloat1));
    this.mAxis.put(1, Float.valueOf(paramFloat2));
    this.mAxis.put(11, Float.valueOf(paramFloat3));
    this.mAxis.put(14, Float.valueOf(paramFloat4));
    this.mPrecision = new SparseArray(2);
    this.mPrecision.put(0, Float.valueOf(paramFloat5));
    this.mPrecision.put(1, Float.valueOf(paramFloat6));
  }
  
  public MotionEvent(long paramLong, int paramInt, int[] paramArrayOfInt1, float[] paramArrayOfFloat1, int[] paramArrayOfInt2, float[] paramArrayOfFloat2)
  {
    super(paramLong, paramInt);
    int i = paramArrayOfInt1.length;
    this.mAxis = new SparseArray(i);
    paramInt = 0;
    if (paramInt >= i)
    {
      i = paramArrayOfInt2.length;
      this.mPrecision = new SparseArray(i);
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt >= i)
      {
        return;
        this.mAxis.put(paramArrayOfInt1[paramInt], Float.valueOf(paramArrayOfFloat1[paramInt]));
        paramInt += 1;
        break;
      }
      this.mPrecision.put(paramArrayOfInt2[paramInt], Float.valueOf(paramArrayOfFloat2[paramInt]));
      paramInt += 1;
    }
  }
  
  MotionEvent(Parcel paramParcel)
  {
    super(paramParcel);
    int j = paramParcel.readInt();
    this.mAxis = new SparseArray(j);
    int i = 0;
    if (i >= j)
    {
      this.mPrecision = new SparseArray(paramParcel.readInt());
      i = 0;
    }
    for (;;)
    {
      if (i >= j)
      {
        return;
        k = paramParcel.readInt();
        f = paramParcel.readFloat();
        this.mAxis.put(k, Float.valueOf(f));
        i += 1;
        break;
      }
      int k = paramParcel.readInt();
      float f = paramParcel.readFloat();
      this.mPrecision.put(k, Float.valueOf(f));
      i += 1;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final int findPointerIndex(int paramInt)
  {
    return -1;
  }
  
  public final float getAxisValue(int paramInt)
  {
    return getAxisValue(paramInt, 0);
  }
  
  public final float getAxisValue(int paramInt1, int paramInt2)
  {
    float f = 0.0F;
    if (paramInt2 == 0) {
      f = ((Float)this.mAxis.get(paramInt1, Float.valueOf(0.0F))).floatValue();
    }
    return f;
  }
  
  public final int getPointerCount()
  {
    return 1;
  }
  
  public final int getPointerId(int paramInt)
  {
    return 0;
  }
  
  public final float getRawX()
  {
    return getX();
  }
  
  public final float getRawY()
  {
    return getY();
  }
  
  public final float getX()
  {
    return getAxisValue(0, 0);
  }
  
  public final float getX(int paramInt)
  {
    return getAxisValue(0, paramInt);
  }
  
  public final float getXPrecision()
  {
    return ((Float)this.mPrecision.get(0, Float.valueOf(0.0F))).floatValue();
  }
  
  public final float getY()
  {
    return getAxisValue(1, 0);
  }
  
  public final float getY(int paramInt)
  {
    return getAxisValue(1, paramInt);
  }
  
  public final float getYPrecision()
  {
    return ((Float)this.mPrecision.get(1, Float.valueOf(0.0F))).floatValue();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
    int i = this.mAxis.size();
    paramParcel.writeInt(i);
    paramInt = 0;
    if (paramInt >= i)
    {
      i = this.mPrecision.size();
      paramParcel.writeInt(i);
      paramInt = 0;
    }
    for (;;)
    {
      if (paramInt >= i)
      {
        return;
        paramParcel.writeInt(this.mAxis.keyAt(paramInt));
        paramParcel.writeFloat(((Float)this.mAxis.valueAt(paramInt)).floatValue());
        paramInt += 1;
        break;
      }
      paramParcel.writeInt(this.mPrecision.keyAt(paramInt));
      paramParcel.writeFloat(((Float)this.mPrecision.valueAt(paramInt)).floatValue());
      paramInt += 1;
    }
  }
  
  static class ParcelableCreator
    implements Parcelable.Creator<MotionEvent>
  {
    public MotionEvent createFromParcel(Parcel paramParcel)
    {
      return new MotionEvent(paramParcel);
    }
    
    public MotionEvent[] newArray(int paramInt)
    {
      return new MotionEvent[paramInt];
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/bda/controller/MotionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */