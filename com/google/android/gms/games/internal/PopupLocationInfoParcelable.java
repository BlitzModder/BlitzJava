package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class PopupLocationInfoParcelable
  implements SafeParcelable
{
  public static final PopupLocationInfoParcelableCreator CREATOR = new PopupLocationInfoParcelableCreator();
  private final int mVersionCode;
  private final Bundle zzaCZ;
  private final IBinder zzaDa;
  
  PopupLocationInfoParcelable(int paramInt, Bundle paramBundle, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt;
    this.zzaCZ = paramBundle;
    this.zzaDa = paramIBinder;
  }
  
  public PopupLocationInfoParcelable(PopupManager.PopupLocationInfo paramPopupLocationInfo)
  {
    this.mVersionCode = 1;
    this.zzaCZ = paramPopupLocationInfo.zzwz();
    this.zzaDa = paramPopupLocationInfo.zzaDd;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public IBinder getWindowToken()
  {
    return this.zzaDa;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    PopupLocationInfoParcelableCreator.zza(this, paramParcel, paramInt);
  }
  
  public Bundle zzwz()
  {
    return this.zzaCZ;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/PopupLocationInfoParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */