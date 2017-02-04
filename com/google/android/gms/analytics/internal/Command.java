package com.google.android.gms.analytics.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Command
  implements Parcelable
{
  @Deprecated
  public static final Parcelable.Creator<Command> CREATOR = new Parcelable.Creator()
  {
    @Deprecated
    public Command[] zzag(int paramAnonymousInt)
    {
      return new Command[paramAnonymousInt];
    }
    
    @Deprecated
    public Command zzq(Parcel paramAnonymousParcel)
    {
      return new Command(paramAnonymousParcel);
    }
  };
  private String mValue;
  private String zzPZ;
  private String zzxX;
  
  @Deprecated
  public Command() {}
  
  @Deprecated
  Command(Parcel paramParcel)
  {
    readFromParcel(paramParcel);
  }
  
  @Deprecated
  private void readFromParcel(Parcel paramParcel)
  {
    this.zzxX = paramParcel.readString();
    this.zzPZ = paramParcel.readString();
    this.mValue = paramParcel.readString();
  }
  
  @Deprecated
  public int describeContents()
  {
    return 0;
  }
  
  public String getId()
  {
    return this.zzxX;
  }
  
  public String getValue()
  {
    return this.mValue;
  }
  
  @Deprecated
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.zzxX);
    paramParcel.writeString(this.zzPZ);
    paramParcel.writeString(this.mValue);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/Command.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */