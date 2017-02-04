package com.google.android.gms.games.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ConnectionInfo
  implements SafeParcelable
{
  public static final ConnectionInfoCreator CREATOR = new ConnectionInfoCreator();
  private final int mVersionCode;
  private final String zzaBt;
  private final int zzaBu;
  
  public ConnectionInfo(int paramInt1, String paramString, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.zzaBt = paramString;
    this.zzaBu = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ConnectionInfoCreator.zza(this, paramParcel, paramInt);
  }
  
  public String zzvN()
  {
    return this.zzaBt;
  }
  
  public int zzvO()
  {
    return this.zzaBu;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/ConnectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */