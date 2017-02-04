package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzx;

public final class RealTimeMessage
  implements Parcelable
{
  public static final Parcelable.Creator<RealTimeMessage> CREATOR = new Parcelable.Creator()
  {
    public RealTimeMessage zzem(Parcel paramAnonymousParcel)
    {
      return new RealTimeMessage(paramAnonymousParcel, null);
    }
    
    public RealTimeMessage[] zzgC(int paramAnonymousInt)
    {
      return new RealTimeMessage[paramAnonymousInt];
    }
  };
  public static final int RELIABLE = 1;
  public static final int UNRELIABLE = 0;
  private final String zzaHh;
  private final byte[] zzaHi;
  private final int zzaHj;
  
  private RealTimeMessage(Parcel paramParcel)
  {
    this(paramParcel.readString(), paramParcel.createByteArray(), paramParcel.readInt());
  }
  
  public RealTimeMessage(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    this.zzaHh = ((String)zzx.zzy(paramString));
    this.zzaHi = ((byte[])((byte[])zzx.zzy(paramArrayOfByte)).clone());
    this.zzaHj = paramInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public byte[] getMessageData()
  {
    return this.zzaHi;
  }
  
  public String getSenderParticipantId()
  {
    return this.zzaHh;
  }
  
  public boolean isReliable()
  {
    return this.zzaHj == 1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.zzaHh);
    paramParcel.writeByteArray(this.zzaHi);
    paramParcel.writeInt(this.zzaHj);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RealTimeMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */