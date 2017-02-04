package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity
  implements SafeParcelable, GameRequest
{
  public static final Parcelable.Creator<GameRequestEntity> CREATOR = new GameRequestEntityCreator();
  private final int mVersionCode;
  private final int zzAk;
  private final String zzDX;
  private final int zzZU;
  private final GameEntity zzaGU;
  private final long zzaGV;
  private final byte[] zzaHC;
  private final PlayerEntity zzaHW;
  private final ArrayList<PlayerEntity> zzaHX;
  private final long zzaHY;
  private final Bundle zzaHZ;
  
  GameRequestEntity(int paramInt1, GameEntity paramGameEntity, PlayerEntity paramPlayerEntity, byte[] paramArrayOfByte, String paramString, ArrayList<PlayerEntity> paramArrayList, int paramInt2, long paramLong1, long paramLong2, Bundle paramBundle, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzaGU = paramGameEntity;
    this.zzaHW = paramPlayerEntity;
    this.zzaHC = paramArrayOfByte;
    this.zzDX = paramString;
    this.zzaHX = paramArrayList;
    this.zzZU = paramInt2;
    this.zzaGV = paramLong1;
    this.zzaHY = paramLong2;
    this.zzaHZ = paramBundle;
    this.zzAk = paramInt3;
  }
  
  public GameRequestEntity(GameRequest paramGameRequest)
  {
    this.mVersionCode = 2;
    this.zzaGU = new GameEntity(paramGameRequest.getGame());
    this.zzaHW = new PlayerEntity(paramGameRequest.getSender());
    this.zzDX = paramGameRequest.getRequestId();
    this.zzZU = paramGameRequest.getType();
    this.zzaGV = paramGameRequest.getCreationTimestamp();
    this.zzaHY = paramGameRequest.getExpirationTimestamp();
    this.zzAk = paramGameRequest.getStatus();
    Object localObject = paramGameRequest.getData();
    if (localObject == null) {
      this.zzaHC = null;
    }
    for (;;)
    {
      localObject = paramGameRequest.getRecipients();
      int j = ((List)localObject).size();
      this.zzaHX = new ArrayList(j);
      this.zzaHZ = new Bundle();
      int i = 0;
      while (i < j)
      {
        Player localPlayer = (Player)((Player)((List)localObject).get(i)).freeze();
        String str = localPlayer.getPlayerId();
        this.zzaHX.add((PlayerEntity)localPlayer);
        this.zzaHZ.putInt(str, paramGameRequest.getRecipientStatus(str));
        i += 1;
      }
      this.zzaHC = new byte[localObject.length];
      System.arraycopy(localObject, 0, this.zzaHC, 0, localObject.length);
    }
  }
  
  static int zza(GameRequest paramGameRequest)
  {
    return zzw.hashCode(new Object[] { paramGameRequest.getGame(), paramGameRequest.getRecipients(), paramGameRequest.getRequestId(), paramGameRequest.getSender(), zzb(paramGameRequest), Integer.valueOf(paramGameRequest.getType()), Long.valueOf(paramGameRequest.getCreationTimestamp()), Long.valueOf(paramGameRequest.getExpirationTimestamp()) });
  }
  
  static boolean zza(GameRequest paramGameRequest, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof GameRequest)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramGameRequest == paramObject);
      paramObject = (GameRequest)paramObject;
      if ((!zzw.equal(((GameRequest)paramObject).getGame(), paramGameRequest.getGame())) || (!zzw.equal(((GameRequest)paramObject).getRecipients(), paramGameRequest.getRecipients())) || (!zzw.equal(((GameRequest)paramObject).getRequestId(), paramGameRequest.getRequestId())) || (!zzw.equal(((GameRequest)paramObject).getSender(), paramGameRequest.getSender())) || (!Arrays.equals(zzb((GameRequest)paramObject), zzb(paramGameRequest))) || (!zzw.equal(Integer.valueOf(((GameRequest)paramObject).getType()), Integer.valueOf(paramGameRequest.getType()))) || (!zzw.equal(Long.valueOf(((GameRequest)paramObject).getCreationTimestamp()), Long.valueOf(paramGameRequest.getCreationTimestamp())))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(Long.valueOf(((GameRequest)paramObject).getExpirationTimestamp()), Long.valueOf(paramGameRequest.getExpirationTimestamp())));
    return false;
  }
  
  private static int[] zzb(GameRequest paramGameRequest)
  {
    List localList = paramGameRequest.getRecipients();
    int j = localList.size();
    int[] arrayOfInt = new int[j];
    int i = 0;
    while (i < j)
    {
      arrayOfInt[i] = paramGameRequest.getRecipientStatus(((Player)localList.get(i)).getPlayerId());
      i += 1;
    }
    return arrayOfInt;
  }
  
  static String zzc(GameRequest paramGameRequest)
  {
    return zzw.zzx(paramGameRequest).zzg("Game", paramGameRequest.getGame()).zzg("Sender", paramGameRequest.getSender()).zzg("Recipients", paramGameRequest.getRecipients()).zzg("Data", paramGameRequest.getData()).zzg("RequestId", paramGameRequest.getRequestId()).zzg("Type", Integer.valueOf(paramGameRequest.getType())).zzg("CreationTimestamp", Long.valueOf(paramGameRequest.getCreationTimestamp())).zzg("ExpirationTimestamp", Long.valueOf(paramGameRequest.getExpirationTimestamp())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public GameRequest freeze()
  {
    return this;
  }
  
  public long getCreationTimestamp()
  {
    return this.zzaGV;
  }
  
  public byte[] getData()
  {
    return this.zzaHC;
  }
  
  public long getExpirationTimestamp()
  {
    return this.zzaHY;
  }
  
  public Game getGame()
  {
    return this.zzaGU;
  }
  
  public int getRecipientStatus(String paramString)
  {
    return this.zzaHZ.getInt(paramString, 0);
  }
  
  public List<Player> getRecipients()
  {
    return new ArrayList(this.zzaHX);
  }
  
  public String getRequestId()
  {
    return this.zzDX;
  }
  
  public Player getSender()
  {
    return this.zzaHW;
  }
  
  public int getStatus()
  {
    return this.zzAk;
  }
  
  public int getType()
  {
    return this.zzZU;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zza(this);
  }
  
  public boolean isConsumed(String paramString)
  {
    return getRecipientStatus(paramString) == 1;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return zzc(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GameRequestEntityCreator.zza(this, paramParcel, paramInt);
  }
  
  public Bundle zzxm()
  {
    return this.zzaHZ;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/request/GameRequestEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */