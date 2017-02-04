package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

public final class ChannelEventParcelable
  implements SafeParcelable
{
  public static final Parcelable.Creator<ChannelEventParcelable> CREATOR = new zzn();
  final int mVersionCode;
  final int type;
  final int zzbmV;
  final int zzbmW;
  final ChannelImpl zzbmX;
  
  ChannelEventParcelable(int paramInt1, ChannelImpl paramChannelImpl, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mVersionCode = paramInt1;
    this.zzbmX = paramChannelImpl;
    this.type = paramInt2;
    this.zzbmV = paramInt3;
    this.zzbmW = paramInt4;
  }
  
  private static String zzlp(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Integer.toString(paramInt);
    case 1: 
      return "CHANNEL_OPENED";
    case 2: 
      return "CHANNEL_CLOSED";
    case 4: 
      return "OUTPUT_CLOSED";
    }
    return "INPUT_CLOSED";
  }
  
  private static String zzlq(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return Integer.toString(paramInt);
    case 1: 
      return "CLOSE_REASON_DISCONNECTED";
    case 2: 
      return "CLOSE_REASON_REMOTE_CLOSE";
    case 3: 
      return "CLOSE_REASON_LOCAL_CLOSE";
    }
    return "CLOSE_REASON_NORMAL";
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "ChannelEventParcelable[versionCode=" + this.mVersionCode + ", channel=" + this.zzbmX + ", type=" + zzlp(this.type) + ", closeReason=" + zzlq(this.zzbmV) + ", appErrorCode=" + this.zzbmW + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzn.zza(this, paramParcel, paramInt);
  }
  
  public void zza(ChannelApi.ChannelListener paramChannelListener)
  {
    switch (this.type)
    {
    default: 
      Log.w("ChannelEventParcelable", "Unknown type: " + this.type);
      return;
    case 1: 
      paramChannelListener.onChannelOpened(this.zzbmX);
      return;
    case 2: 
      paramChannelListener.onChannelClosed(this.zzbmX, this.zzbmV, this.zzbmW);
      return;
    case 3: 
      paramChannelListener.onInputClosed(this.zzbmX, this.zzbmV, this.zzbmW);
      return;
    }
    paramChannelListener.onOutputClosed(this.zzbmX, this.zzbmV, this.zzbmW);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/ChannelEventParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */