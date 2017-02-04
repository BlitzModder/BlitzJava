package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public final class GameRequestCluster
  implements SafeParcelable, GameRequest
{
  public static final GameRequestClusterCreator CREATOR = new GameRequestClusterCreator();
  private final int mVersionCode;
  private final ArrayList<GameRequestEntity> zzaGm;
  
  GameRequestCluster(int paramInt, ArrayList<GameRequestEntity> paramArrayList)
  {
    this.mVersionCode = paramInt;
    this.zzaGm = paramArrayList;
    zzwK();
  }
  
  private void zzwK()
  {
    GameRequest localGameRequest1;
    int i;
    label39:
    GameRequest localGameRequest2;
    if (!this.zzaGm.isEmpty())
    {
      bool = true;
      zzb.zzaa(bool);
      localGameRequest1 = (GameRequest)this.zzaGm.get(0);
      int j = this.zzaGm.size();
      i = 1;
      if (i >= j) {
        return;
      }
      localGameRequest2 = (GameRequest)this.zzaGm.get(i);
      if (localGameRequest1.getType() != localGameRequest2.getType()) {
        break label116;
      }
    }
    label116:
    for (boolean bool = true;; bool = false)
    {
      zzb.zza(bool, "All the requests must be of the same type");
      zzb.zza(localGameRequest1.getSender().equals(localGameRequest2.getSender()), "All the requests must be from the same sender");
      i += 1;
      break label39;
      bool = false;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GameRequestCluster)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (GameRequestCluster)paramObject;
    if (((GameRequestCluster)paramObject).zzaGm.size() != this.zzaGm.size()) {
      return false;
    }
    int j = this.zzaGm.size();
    int i = 0;
    while (i < j)
    {
      if (!((GameRequest)this.zzaGm.get(i)).equals((GameRequest)((GameRequestCluster)paramObject).zzaGm.get(i))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public GameRequest freeze()
  {
    return this;
  }
  
  public long getCreationTimestamp()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public byte[] getData()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public long getExpirationTimestamp()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public Game getGame()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public int getRecipientStatus(String paramString)
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public String getRequestId()
  {
    return ((GameRequestEntity)this.zzaGm.get(0)).getRequestId();
  }
  
  public Player getSender()
  {
    return ((GameRequestEntity)this.zzaGm.get(0)).getSender();
  }
  
  public int getStatus()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public int getType()
  {
    return ((GameRequestEntity)this.zzaGm.get(0)).getType();
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(this.zzaGm.toArray());
  }
  
  public boolean isConsumed(String paramString)
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GameRequestClusterCreator.zza(this, paramParcel, paramInt);
  }
  
  public ArrayList<GameRequest> zzwY()
  {
    return new ArrayList(this.zzaGm);
  }
  
  public ArrayList<Player> zzwZ()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/request/GameRequestCluster.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */