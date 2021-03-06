package com.google.android.gms.games.quest;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public final class MilestoneEntity
  implements SafeParcelable, Milestone
{
  public static final Parcelable.Creator<MilestoneEntity> CREATOR = new MilestoneEntityCreator();
  private final int mState;
  private final int mVersionCode;
  private final String zzaBp;
  private final String zzaCx;
  private final long zzaHJ;
  private final long zzaHK;
  private final byte[] zzaHL;
  
  MilestoneEntity(int paramInt1, String paramString1, long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt2, String paramString2)
  {
    this.mVersionCode = paramInt1;
    this.zzaCx = paramString1;
    this.zzaHJ = paramLong1;
    this.zzaHK = paramLong2;
    this.zzaHL = paramArrayOfByte;
    this.mState = paramInt2;
    this.zzaBp = paramString2;
  }
  
  public MilestoneEntity(Milestone paramMilestone)
  {
    this.mVersionCode = 4;
    this.zzaCx = paramMilestone.getMilestoneId();
    this.zzaHJ = paramMilestone.getCurrentProgress();
    this.zzaHK = paramMilestone.getTargetProgress();
    this.mState = paramMilestone.getState();
    this.zzaBp = paramMilestone.getEventId();
    paramMilestone = paramMilestone.getCompletionRewardData();
    if (paramMilestone == null)
    {
      this.zzaHL = null;
      return;
    }
    this.zzaHL = new byte[paramMilestone.length];
    System.arraycopy(paramMilestone, 0, this.zzaHL, 0, paramMilestone.length);
  }
  
  static int zza(Milestone paramMilestone)
  {
    return zzw.hashCode(new Object[] { paramMilestone.getMilestoneId(), Long.valueOf(paramMilestone.getCurrentProgress()), Long.valueOf(paramMilestone.getTargetProgress()), Integer.valueOf(paramMilestone.getState()), paramMilestone.getEventId() });
  }
  
  static boolean zza(Milestone paramMilestone, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Milestone)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramMilestone == paramObject);
      paramObject = (Milestone)paramObject;
      if ((!zzw.equal(((Milestone)paramObject).getMilestoneId(), paramMilestone.getMilestoneId())) || (!zzw.equal(Long.valueOf(((Milestone)paramObject).getCurrentProgress()), Long.valueOf(paramMilestone.getCurrentProgress()))) || (!zzw.equal(Long.valueOf(((Milestone)paramObject).getTargetProgress()), Long.valueOf(paramMilestone.getTargetProgress()))) || (!zzw.equal(Integer.valueOf(((Milestone)paramObject).getState()), Integer.valueOf(paramMilestone.getState())))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(((Milestone)paramObject).getEventId(), paramMilestone.getEventId()));
    return false;
  }
  
  static String zzb(Milestone paramMilestone)
  {
    return zzw.zzx(paramMilestone).zzg("MilestoneId", paramMilestone.getMilestoneId()).zzg("CurrentProgress", Long.valueOf(paramMilestone.getCurrentProgress())).zzg("TargetProgress", Long.valueOf(paramMilestone.getTargetProgress())).zzg("State", Integer.valueOf(paramMilestone.getState())).zzg("CompletionRewardData", paramMilestone.getCompletionRewardData()).zzg("EventId", paramMilestone.getEventId()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public Milestone freeze()
  {
    return this;
  }
  
  public byte[] getCompletionRewardData()
  {
    return this.zzaHL;
  }
  
  public long getCurrentProgress()
  {
    return this.zzaHJ;
  }
  
  public String getEventId()
  {
    return this.zzaBp;
  }
  
  public String getMilestoneId()
  {
    return this.zzaCx;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public long getTargetProgress()
  {
    return this.zzaHK;
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
    MilestoneEntityCreator.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/quest/MilestoneEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */