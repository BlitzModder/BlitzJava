package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public final class MostRecentGameInfoEntity
  implements SafeParcelable, MostRecentGameInfo
{
  public static final MostRecentGameInfoEntityCreator CREATOR = new MostRecentGameInfoEntityCreator();
  private final int mVersionCode;
  private final String zzaFC;
  private final String zzaFD;
  private final long zzaFE;
  private final Uri zzaFF;
  private final Uri zzaFG;
  private final Uri zzaFH;
  
  MostRecentGameInfoEntity(int paramInt, String paramString1, String paramString2, long paramLong, Uri paramUri1, Uri paramUri2, Uri paramUri3)
  {
    this.mVersionCode = paramInt;
    this.zzaFC = paramString1;
    this.zzaFD = paramString2;
    this.zzaFE = paramLong;
    this.zzaFF = paramUri1;
    this.zzaFG = paramUri2;
    this.zzaFH = paramUri3;
  }
  
  public MostRecentGameInfoEntity(MostRecentGameInfo paramMostRecentGameInfo)
  {
    this.mVersionCode = 2;
    this.zzaFC = paramMostRecentGameInfo.zzwR();
    this.zzaFD = paramMostRecentGameInfo.zzwS();
    this.zzaFE = paramMostRecentGameInfo.zzwT();
    this.zzaFF = paramMostRecentGameInfo.zzwU();
    this.zzaFG = paramMostRecentGameInfo.zzwV();
    this.zzaFH = paramMostRecentGameInfo.zzwW();
  }
  
  static int zza(MostRecentGameInfo paramMostRecentGameInfo)
  {
    return zzw.hashCode(new Object[] { paramMostRecentGameInfo.zzwR(), paramMostRecentGameInfo.zzwS(), Long.valueOf(paramMostRecentGameInfo.zzwT()), paramMostRecentGameInfo.zzwU(), paramMostRecentGameInfo.zzwV(), paramMostRecentGameInfo.zzwW() });
  }
  
  static boolean zza(MostRecentGameInfo paramMostRecentGameInfo, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof MostRecentGameInfo)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramMostRecentGameInfo == paramObject);
      paramObject = (MostRecentGameInfo)paramObject;
      if ((!zzw.equal(((MostRecentGameInfo)paramObject).zzwR(), paramMostRecentGameInfo.zzwR())) || (!zzw.equal(((MostRecentGameInfo)paramObject).zzwS(), paramMostRecentGameInfo.zzwS())) || (!zzw.equal(Long.valueOf(((MostRecentGameInfo)paramObject).zzwT()), Long.valueOf(paramMostRecentGameInfo.zzwT()))) || (!zzw.equal(((MostRecentGameInfo)paramObject).zzwU(), paramMostRecentGameInfo.zzwU())) || (!zzw.equal(((MostRecentGameInfo)paramObject).zzwV(), paramMostRecentGameInfo.zzwV()))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((MostRecentGameInfo)paramObject).zzwW(), paramMostRecentGameInfo.zzwW()));
    return false;
  }
  
  static String zzb(MostRecentGameInfo paramMostRecentGameInfo)
  {
    return zzw.zzx(paramMostRecentGameInfo).zzg("GameId", paramMostRecentGameInfo.zzwR()).zzg("GameName", paramMostRecentGameInfo.zzwS()).zzg("ActivityTimestampMillis", Long.valueOf(paramMostRecentGameInfo.zzwT())).zzg("GameIconUri", paramMostRecentGameInfo.zzwU()).zzg("GameHiResUri", paramMostRecentGameInfo.zzwV()).zzg("GameFeaturedUri", paramMostRecentGameInfo.zzwW()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zza(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    MostRecentGameInfoEntityCreator.zza(this, paramParcel, paramInt);
  }
  
  public String zzwR()
  {
    return this.zzaFC;
  }
  
  public String zzwS()
  {
    return this.zzaFD;
  }
  
  public long zzwT()
  {
    return this.zzaFE;
  }
  
  public Uri zzwU()
  {
    return this.zzaFF;
  }
  
  public Uri zzwV()
  {
    return this.zzaFG;
  }
  
  public Uri zzwW()
  {
    return this.zzaFH;
  }
  
  public MostRecentGameInfo zzwX()
  {
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/player/MostRecentGameInfoEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */