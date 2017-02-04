package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.MessageEvent;

public class MessageEventParcelable
  implements SafeParcelable, MessageEvent
{
  public static final Parcelable.Creator<MessageEventParcelable> CREATOR = new zzbn();
  private final String mPath;
  final int mVersionCode;
  private final byte[] zzaHC;
  private final String zzaMP;
  private final int zzamD;
  
  MessageEventParcelable(int paramInt1, int paramInt2, String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.mVersionCode = paramInt1;
    this.zzamD = paramInt2;
    this.mPath = paramString1;
    this.zzaHC = paramArrayOfByte;
    this.zzaMP = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public byte[] getData()
  {
    return this.zzaHC;
  }
  
  public String getPath()
  {
    return this.mPath;
  }
  
  public int getRequestId()
  {
    return this.zzamD;
  }
  
  public String getSourceNodeId()
  {
    return this.zzaMP;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("MessageEventParcelable[").append(this.zzamD).append(",").append(this.mPath).append(", size=");
    if (this.zzaHC == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.zzaHC.length)) {
      return localObject + "]";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzbn.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/MessageEventParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */