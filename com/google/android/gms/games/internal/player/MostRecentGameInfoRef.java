package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;

public final class MostRecentGameInfoRef
  extends zzc
  implements MostRecentGameInfo
{
  private final PlayerColumnNames zzaAC;
  
  public MostRecentGameInfoRef(DataHolder paramDataHolder, int paramInt, PlayerColumnNames paramPlayerColumnNames)
  {
    super(paramDataHolder, paramInt);
    this.zzaAC = paramPlayerColumnNames;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return MostRecentGameInfoEntity.zza(this, paramObject);
  }
  
  public int hashCode()
  {
    return MostRecentGameInfoEntity.zza(this);
  }
  
  public String toString()
  {
    return MostRecentGameInfoEntity.zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((MostRecentGameInfoEntity)zzwX()).writeToParcel(paramParcel, paramInt);
  }
  
  public String zzwR()
  {
    return getString(this.zzaAC.zzaGa);
  }
  
  public String zzwS()
  {
    return getString(this.zzaAC.zzaGb);
  }
  
  public long zzwT()
  {
    return getLong(this.zzaAC.zzaGc);
  }
  
  public Uri zzwU()
  {
    return zzcu(this.zzaAC.zzaGd);
  }
  
  public Uri zzwV()
  {
    return zzcu(this.zzaAC.zzaGe);
  }
  
  public Uri zzwW()
  {
    return zzcu(this.zzaAC.zzaGf);
  }
  
  public MostRecentGameInfo zzwX()
  {
    return new MostRecentGameInfoEntity(this);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/player/MostRecentGameInfoRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */