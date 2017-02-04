package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class PlayerLevelInfo
  implements SafeParcelable
{
  public static final Parcelable.Creator<PlayerLevelInfo> CREATOR = new PlayerLevelInfoCreator();
  private final int mVersionCode;
  private final PlayerLevel zzaAA;
  private final PlayerLevel zzaAB;
  private final long zzaAy;
  private final long zzaAz;
  
  PlayerLevelInfo(int paramInt, long paramLong1, long paramLong2, PlayerLevel paramPlayerLevel1, PlayerLevel paramPlayerLevel2)
  {
    if (paramLong1 != -1L) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzaa(bool);
      zzx.zzy(paramPlayerLevel1);
      zzx.zzy(paramPlayerLevel2);
      this.mVersionCode = paramInt;
      this.zzaAy = paramLong1;
      this.zzaAz = paramLong2;
      this.zzaAA = paramPlayerLevel1;
      this.zzaAB = paramPlayerLevel2;
      return;
    }
  }
  
  public PlayerLevelInfo(long paramLong1, long paramLong2, PlayerLevel paramPlayerLevel1, PlayerLevel paramPlayerLevel2)
  {
    this(1, paramLong1, paramLong2, paramPlayerLevel1, paramPlayerLevel2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof PlayerLevelInfo)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == this);
      paramObject = (PlayerLevelInfo)paramObject;
      if ((!zzw.equal(Long.valueOf(this.zzaAy), Long.valueOf(((PlayerLevelInfo)paramObject).zzaAy))) || (!zzw.equal(Long.valueOf(this.zzaAz), Long.valueOf(((PlayerLevelInfo)paramObject).zzaAz))) || (!zzw.equal(this.zzaAA, ((PlayerLevelInfo)paramObject).zzaAA))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(this.zzaAB, ((PlayerLevelInfo)paramObject).zzaAB));
    return false;
  }
  
  public PlayerLevel getCurrentLevel()
  {
    return this.zzaAA;
  }
  
  public long getCurrentXpTotal()
  {
    return this.zzaAy;
  }
  
  public long getLastLevelUpTimestamp()
  {
    return this.zzaAz;
  }
  
  public PlayerLevel getNextLevel()
  {
    return this.zzaAB;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Long.valueOf(this.zzaAy), Long.valueOf(this.zzaAz), this.zzaAA, this.zzaAB });
  }
  
  public boolean isMaxLevel()
  {
    return this.zzaAA.equals(this.zzaAB);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    PlayerLevelInfoCreator.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/PlayerLevelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */