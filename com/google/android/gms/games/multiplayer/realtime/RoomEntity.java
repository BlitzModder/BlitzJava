package com.google.android.gms.games.multiplayer.realtime;

import android.database.CharArrayBuffer;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import com.google.android.gms.internal.zznn;
import java.util.ArrayList;

public final class RoomEntity
  extends GamesDowngradeableSafeParcel
  implements Room
{
  public static final Parcelable.Creator<RoomEntity> CREATOR = new RoomEntityCreatorCompat();
  private final int mVersionCode;
  private final String zzaBR;
  private final long zzaGV;
  private final ArrayList<ParticipantEntity> zzaGY;
  private final int zzaGZ;
  private final Bundle zzaHp;
  private final String zzaHr;
  private final int zzaHs;
  private final int zzaHt;
  private final String zzavc;
  
  RoomEntity(int paramInt1, String paramString1, String paramString2, long paramLong, int paramInt2, String paramString3, int paramInt3, Bundle paramBundle, ArrayList<ParticipantEntity> paramArrayList, int paramInt4)
  {
    this.mVersionCode = paramInt1;
    this.zzaBR = paramString1;
    this.zzaHr = paramString2;
    this.zzaGV = paramLong;
    this.zzaHs = paramInt2;
    this.zzavc = paramString3;
    this.zzaGZ = paramInt3;
    this.zzaHp = paramBundle;
    this.zzaGY = paramArrayList;
    this.zzaHt = paramInt4;
  }
  
  public RoomEntity(Room paramRoom)
  {
    this.mVersionCode = 2;
    this.zzaBR = paramRoom.getRoomId();
    this.zzaHr = paramRoom.getCreatorId();
    this.zzaGV = paramRoom.getCreationTimestamp();
    this.zzaHs = paramRoom.getStatus();
    this.zzavc = paramRoom.getDescription();
    this.zzaGZ = paramRoom.getVariant();
    this.zzaHp = paramRoom.getAutoMatchCriteria();
    ArrayList localArrayList = paramRoom.getParticipants();
    int j = localArrayList.size();
    this.zzaGY = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      this.zzaGY.add((ParticipantEntity)((Participant)localArrayList.get(i)).freeze());
      i += 1;
    }
    this.zzaHt = paramRoom.getAutoMatchWaitEstimateSeconds();
  }
  
  static int zza(Room paramRoom)
  {
    return zzw.hashCode(new Object[] { paramRoom.getRoomId(), paramRoom.getCreatorId(), Long.valueOf(paramRoom.getCreationTimestamp()), Integer.valueOf(paramRoom.getStatus()), paramRoom.getDescription(), Integer.valueOf(paramRoom.getVariant()), paramRoom.getAutoMatchCriteria(), paramRoom.getParticipants(), Integer.valueOf(paramRoom.getAutoMatchWaitEstimateSeconds()) });
  }
  
  static int zza(Room paramRoom, String paramString)
  {
    ArrayList localArrayList = paramRoom.getParticipants();
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      Participant localParticipant = (Participant)localArrayList.get(i);
      if (localParticipant.getParticipantId().equals(paramString)) {
        return localParticipant.getStatus();
      }
      i += 1;
    }
    throw new IllegalStateException("Participant " + paramString + " is not in room " + paramRoom.getRoomId());
  }
  
  static boolean zza(Room paramRoom, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Room)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramRoom == paramObject);
      paramObject = (Room)paramObject;
      if ((!zzw.equal(((Room)paramObject).getRoomId(), paramRoom.getRoomId())) || (!zzw.equal(((Room)paramObject).getCreatorId(), paramRoom.getCreatorId())) || (!zzw.equal(Long.valueOf(((Room)paramObject).getCreationTimestamp()), Long.valueOf(paramRoom.getCreationTimestamp()))) || (!zzw.equal(Integer.valueOf(((Room)paramObject).getStatus()), Integer.valueOf(paramRoom.getStatus()))) || (!zzw.equal(((Room)paramObject).getDescription(), paramRoom.getDescription())) || (!zzw.equal(Integer.valueOf(((Room)paramObject).getVariant()), Integer.valueOf(paramRoom.getVariant()))) || (!zzw.equal(((Room)paramObject).getAutoMatchCriteria(), paramRoom.getAutoMatchCriteria())) || (!zzw.equal(((Room)paramObject).getParticipants(), paramRoom.getParticipants()))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(Integer.valueOf(((Room)paramObject).getAutoMatchWaitEstimateSeconds()), Integer.valueOf(paramRoom.getAutoMatchWaitEstimateSeconds())));
    return false;
  }
  
  static String zzb(Room paramRoom)
  {
    return zzw.zzx(paramRoom).zzg("RoomId", paramRoom.getRoomId()).zzg("CreatorId", paramRoom.getCreatorId()).zzg("CreationTimestamp", Long.valueOf(paramRoom.getCreationTimestamp())).zzg("RoomStatus", Integer.valueOf(paramRoom.getStatus())).zzg("Description", paramRoom.getDescription()).zzg("Variant", Integer.valueOf(paramRoom.getVariant())).zzg("AutoMatchCriteria", paramRoom.getAutoMatchCriteria()).zzg("Participants", paramRoom.getParticipants()).zzg("AutoMatchWaitEstimateSeconds", Integer.valueOf(paramRoom.getAutoMatchWaitEstimateSeconds())).toString();
  }
  
  static String zzb(Room paramRoom, String paramString)
  {
    paramRoom = paramRoom.getParticipants();
    int j = paramRoom.size();
    int i = 0;
    while (i < j)
    {
      Participant localParticipant = (Participant)paramRoom.get(i);
      Player localPlayer = localParticipant.getPlayer();
      if ((localPlayer != null) && (localPlayer.getPlayerId().equals(paramString))) {
        return localParticipant.getParticipantId();
      }
      i += 1;
    }
    return null;
  }
  
  static Participant zzc(Room paramRoom, String paramString)
  {
    ArrayList localArrayList = paramRoom.getParticipants();
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      Participant localParticipant = (Participant)localArrayList.get(i);
      if (localParticipant.getParticipantId().equals(paramString)) {
        return localParticipant;
      }
      i += 1;
    }
    throw new IllegalStateException("Participant " + paramString + " is not in match " + paramRoom.getRoomId());
  }
  
  static ArrayList<String> zzc(Room paramRoom)
  {
    paramRoom = paramRoom.getParticipants();
    int j = paramRoom.size();
    ArrayList localArrayList = new ArrayList(j);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(((Participant)paramRoom.get(i)).getParticipantId());
      i += 1;
    }
    return localArrayList;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public Room freeze()
  {
    return this;
  }
  
  public Bundle getAutoMatchCriteria()
  {
    return this.zzaHp;
  }
  
  public int getAutoMatchWaitEstimateSeconds()
  {
    return this.zzaHt;
  }
  
  public long getCreationTimestamp()
  {
    return this.zzaGV;
  }
  
  public String getCreatorId()
  {
    return this.zzaHr;
  }
  
  public String getDescription()
  {
    return this.zzavc;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    zznn.zzb(this.zzavc, paramCharArrayBuffer);
  }
  
  public Participant getParticipant(String paramString)
  {
    return zzc(this, paramString);
  }
  
  public String getParticipantId(String paramString)
  {
    return zzb(this, paramString);
  }
  
  public ArrayList<String> getParticipantIds()
  {
    return zzc(this);
  }
  
  public int getParticipantStatus(String paramString)
  {
    return zza(this, paramString);
  }
  
  public ArrayList<Participant> getParticipants()
  {
    return new ArrayList(this.zzaGY);
  }
  
  public String getRoomId()
  {
    return this.zzaBR;
  }
  
  public int getStatus()
  {
    return this.zzaHs;
  }
  
  public int getVariant()
  {
    return this.zzaGZ;
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
    if (!zzqk()) {
      RoomEntityCreator.zza(this, paramParcel, paramInt);
    }
    for (;;)
    {
      return;
      paramParcel.writeString(this.zzaBR);
      paramParcel.writeString(this.zzaHr);
      paramParcel.writeLong(this.zzaGV);
      paramParcel.writeInt(this.zzaHs);
      paramParcel.writeString(this.zzavc);
      paramParcel.writeInt(this.zzaGZ);
      paramParcel.writeBundle(this.zzaHp);
      int j = this.zzaGY.size();
      paramParcel.writeInt(j);
      int i = 0;
      while (i < j)
      {
        ((ParticipantEntity)this.zzaGY.get(i)).writeToParcel(paramParcel, paramInt);
        i += 1;
      }
    }
  }
  
  static final class RoomEntityCreatorCompat
    extends RoomEntityCreator
  {
    public RoomEntity zzen(Parcel paramParcel)
    {
      if ((RoomEntity.zzc(RoomEntity.zzuW())) || (RoomEntity.zzds(RoomEntity.class.getCanonicalName()))) {
        return super.zzen(paramParcel);
      }
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      long l = paramParcel.readLong();
      int j = paramParcel.readInt();
      String str3 = paramParcel.readString();
      int k = paramParcel.readInt();
      Bundle localBundle = paramParcel.readBundle();
      int m = paramParcel.readInt();
      ArrayList localArrayList = new ArrayList(m);
      int i = 0;
      while (i < m)
      {
        localArrayList.add(ParticipantEntity.CREATOR.createFromParcel(paramParcel));
        i += 1;
      }
      return new RoomEntity(2, str1, str2, l, j, str3, k, localBundle, localArrayList, -1);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/multiplayer/realtime/RoomEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */