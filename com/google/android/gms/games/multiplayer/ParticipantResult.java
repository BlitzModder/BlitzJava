package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.MatchResult;

public final class ParticipantResult
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParticipantResult> CREATOR = new ParticipantResultCreator();
  public static final int MATCH_RESULT_DISAGREED = 5;
  public static final int MATCH_RESULT_DISCONNECT = 4;
  public static final int MATCH_RESULT_LOSS = 1;
  public static final int MATCH_RESULT_NONE = 3;
  public static final int MATCH_RESULT_TIE = 2;
  public static final int MATCH_RESULT_UNINITIALIZED = -1;
  public static final int MATCH_RESULT_WIN = 0;
  public static final int PLACING_UNINITIALIZED = -1;
  private final int mVersionCode;
  private final String zzaCu;
  private final int zzaHf;
  private final int zzaHg;
  
  public ParticipantResult(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzaCu = ((String)zzx.zzy(paramString));
    zzx.zzaa(MatchResult.isValid(paramInt2));
    this.zzaHf = paramInt2;
    this.zzaHg = paramInt3;
  }
  
  public ParticipantResult(String paramString, int paramInt1, int paramInt2)
  {
    this(1, paramString, paramInt1, paramInt2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getParticipantId()
  {
    return this.zzaCu;
  }
  
  public int getPlacing()
  {
    return this.zzaHg;
  }
  
  public int getResult()
  {
    return this.zzaHf;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ParticipantResultCreator.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/multiplayer/ParticipantResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */