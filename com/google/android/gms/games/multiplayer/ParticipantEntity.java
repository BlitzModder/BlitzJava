package com.google.android.gms.games.multiplayer;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.zznn;

public final class ParticipantEntity
  extends GamesDowngradeableSafeParcel
  implements Participant
{
  public static final Parcelable.Creator<ParticipantEntity> CREATOR = new ParticipantEntityCreatorCompat();
  private final int mVersionCode;
  private final int zzAk;
  private final String zzVu;
  private final int zzYv;
  private final PlayerEntity zzaAL;
  private final String zzaBt;
  private final String zzaCu;
  private final boolean zzaHc;
  private final ParticipantResult zzaHd;
  private final Uri zzazC;
  private final Uri zzazD;
  private final String zzazN;
  private final String zzazO;
  
  ParticipantEntity(int paramInt1, String paramString1, String paramString2, Uri paramUri1, Uri paramUri2, int paramInt2, String paramString3, boolean paramBoolean, PlayerEntity paramPlayerEntity, int paramInt3, ParticipantResult paramParticipantResult, String paramString4, String paramString5)
  {
    this.mVersionCode = paramInt1;
    this.zzaCu = paramString1;
    this.zzVu = paramString2;
    this.zzazC = paramUri1;
    this.zzazD = paramUri2;
    this.zzAk = paramInt2;
    this.zzaBt = paramString3;
    this.zzaHc = paramBoolean;
    this.zzaAL = paramPlayerEntity;
    this.zzYv = paramInt3;
    this.zzaHd = paramParticipantResult;
    this.zzazN = paramString4;
    this.zzazO = paramString5;
  }
  
  public ParticipantEntity(Participant paramParticipant)
  {
    this.mVersionCode = 3;
    this.zzaCu = paramParticipant.getParticipantId();
    this.zzVu = paramParticipant.getDisplayName();
    this.zzazC = paramParticipant.getIconImageUri();
    this.zzazD = paramParticipant.getHiResImageUri();
    this.zzAk = paramParticipant.getStatus();
    this.zzaBt = paramParticipant.zzvN();
    this.zzaHc = paramParticipant.isConnectedToRoom();
    Object localObject = paramParticipant.getPlayer();
    if (localObject == null) {}
    for (localObject = null;; localObject = new PlayerEntity((Player)localObject))
    {
      this.zzaAL = ((PlayerEntity)localObject);
      this.zzYv = paramParticipant.getCapabilities();
      this.zzaHd = paramParticipant.getResult();
      this.zzazN = paramParticipant.getIconImageUrl();
      this.zzazO = paramParticipant.getHiResImageUrl();
      return;
    }
  }
  
  static int zza(Participant paramParticipant)
  {
    return zzw.hashCode(new Object[] { paramParticipant.getPlayer(), Integer.valueOf(paramParticipant.getStatus()), paramParticipant.zzvN(), Boolean.valueOf(paramParticipant.isConnectedToRoom()), paramParticipant.getDisplayName(), paramParticipant.getIconImageUri(), paramParticipant.getHiResImageUri(), Integer.valueOf(paramParticipant.getCapabilities()), paramParticipant.getResult(), paramParticipant.getParticipantId() });
  }
  
  static boolean zza(Participant paramParticipant, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Participant)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramParticipant == paramObject);
      paramObject = (Participant)paramObject;
      if ((!zzw.equal(((Participant)paramObject).getPlayer(), paramParticipant.getPlayer())) || (!zzw.equal(Integer.valueOf(((Participant)paramObject).getStatus()), Integer.valueOf(paramParticipant.getStatus()))) || (!zzw.equal(((Participant)paramObject).zzvN(), paramParticipant.zzvN())) || (!zzw.equal(Boolean.valueOf(((Participant)paramObject).isConnectedToRoom()), Boolean.valueOf(paramParticipant.isConnectedToRoom()))) || (!zzw.equal(((Participant)paramObject).getDisplayName(), paramParticipant.getDisplayName())) || (!zzw.equal(((Participant)paramObject).getIconImageUri(), paramParticipant.getIconImageUri())) || (!zzw.equal(((Participant)paramObject).getHiResImageUri(), paramParticipant.getHiResImageUri())) || (!zzw.equal(Integer.valueOf(((Participant)paramObject).getCapabilities()), Integer.valueOf(paramParticipant.getCapabilities()))) || (!zzw.equal(((Participant)paramObject).getResult(), paramParticipant.getResult()))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((Participant)paramObject).getParticipantId(), paramParticipant.getParticipantId()));
    return false;
  }
  
  static String zzb(Participant paramParticipant)
  {
    return zzw.zzx(paramParticipant).zzg("ParticipantId", paramParticipant.getParticipantId()).zzg("Player", paramParticipant.getPlayer()).zzg("Status", Integer.valueOf(paramParticipant.getStatus())).zzg("ClientAddress", paramParticipant.zzvN()).zzg("ConnectedToRoom", Boolean.valueOf(paramParticipant.isConnectedToRoom())).zzg("DisplayName", paramParticipant.getDisplayName()).zzg("IconImage", paramParticipant.getIconImageUri()).zzg("IconImageUrl", paramParticipant.getIconImageUrl()).zzg("HiResImage", paramParticipant.getHiResImageUri()).zzg("HiResImageUrl", paramParticipant.getHiResImageUrl()).zzg("Capabilities", Integer.valueOf(paramParticipant.getCapabilities())).zzg("Result", paramParticipant.getResult()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public Participant freeze()
  {
    return this;
  }
  
  public int getCapabilities()
  {
    return this.zzYv;
  }
  
  public String getDisplayName()
  {
    if (this.zzaAL == null) {
      return this.zzVu;
    }
    return this.zzaAL.getDisplayName();
  }
  
  public void getDisplayName(CharArrayBuffer paramCharArrayBuffer)
  {
    if (this.zzaAL == null)
    {
      zznn.zzb(this.zzVu, paramCharArrayBuffer);
      return;
    }
    this.zzaAL.getDisplayName(paramCharArrayBuffer);
  }
  
  public Uri getHiResImageUri()
  {
    if (this.zzaAL == null) {
      return this.zzazD;
    }
    return this.zzaAL.getHiResImageUri();
  }
  
  public String getHiResImageUrl()
  {
    if (this.zzaAL == null) {
      return this.zzazO;
    }
    return this.zzaAL.getHiResImageUrl();
  }
  
  public Uri getIconImageUri()
  {
    if (this.zzaAL == null) {
      return this.zzazC;
    }
    return this.zzaAL.getIconImageUri();
  }
  
  public String getIconImageUrl()
  {
    if (this.zzaAL == null) {
      return this.zzazN;
    }
    return this.zzaAL.getIconImageUrl();
  }
  
  public String getParticipantId()
  {
    return this.zzaCu;
  }
  
  public Player getPlayer()
  {
    return this.zzaAL;
  }
  
  public ParticipantResult getResult()
  {
    return this.zzaHd;
  }
  
  public int getStatus()
  {
    return this.zzAk;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zza(this);
  }
  
  public boolean isConnectedToRoom()
  {
    return this.zzaHc;
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
    Object localObject2 = null;
    int j = 0;
    if (!zzqk())
    {
      ParticipantEntityCreator.zza(this, paramParcel, paramInt);
      return;
    }
    paramParcel.writeString(this.zzaCu);
    paramParcel.writeString(this.zzVu);
    Object localObject1;
    if (this.zzazC == null)
    {
      localObject1 = null;
      label46:
      paramParcel.writeString((String)localObject1);
      if (this.zzazD != null) {
        break label143;
      }
      localObject1 = localObject2;
      label63:
      paramParcel.writeString((String)localObject1);
      paramParcel.writeInt(this.zzAk);
      paramParcel.writeString(this.zzaBt);
      if (!this.zzaHc) {
        break label155;
      }
      i = 1;
      label94:
      paramParcel.writeInt(i);
      if (this.zzaAL != null) {
        break label160;
      }
    }
    label143:
    label155:
    label160:
    for (int i = j;; i = 1)
    {
      paramParcel.writeInt(i);
      if (this.zzaAL == null) {
        break;
      }
      this.zzaAL.writeToParcel(paramParcel, paramInt);
      return;
      localObject1 = this.zzazC.toString();
      break label46;
      localObject1 = this.zzazD.toString();
      break label63;
      i = 0;
      break label94;
    }
  }
  
  public String zzvN()
  {
    return this.zzaBt;
  }
  
  static final class ParticipantEntityCreatorCompat
    extends ParticipantEntityCreator
  {
    public ParticipantEntity zzek(Parcel paramParcel)
    {
      int i = 1;
      if ((ParticipantEntity.zzc(ParticipantEntity.zzuW())) || (ParticipantEntity.zzds(ParticipantEntity.class.getCanonicalName()))) {
        return super.zzek(paramParcel);
      }
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      Object localObject1 = paramParcel.readString();
      Object localObject2;
      label68:
      int j;
      String str3;
      boolean bool;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = paramParcel.readString();
        if (localObject2 != null) {
          break label151;
        }
        localObject2 = null;
        j = paramParcel.readInt();
        str3 = paramParcel.readString();
        if (paramParcel.readInt() <= 0) {
          break label161;
        }
        bool = true;
        label89:
        if (paramParcel.readInt() <= 0) {
          break label167;
        }
        label96:
        if (i == 0) {
          break label172;
        }
      }
      label151:
      label161:
      label167:
      label172:
      for (paramParcel = (PlayerEntity)PlayerEntity.CREATOR.createFromParcel(paramParcel);; paramParcel = null)
      {
        return new ParticipantEntity(3, str1, str2, (Uri)localObject1, (Uri)localObject2, j, str3, bool, paramParcel, 7, null, null, null);
        localObject1 = Uri.parse((String)localObject1);
        break;
        localObject2 = Uri.parse((String)localObject2);
        break label68;
        bool = false;
        break label89;
        i = 0;
        break label96;
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/multiplayer/ParticipantEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */