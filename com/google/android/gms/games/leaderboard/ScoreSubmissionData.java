package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.TimeSpan;
import java.util.HashMap;

public final class ScoreSubmissionData
{
  private static final String[] zzaGn = { "leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag" };
  private HashMap<Integer, Result> zzaGT;
  private String zzaGp;
  private String zzabq;
  private int zzabx;
  
  public ScoreSubmissionData(DataHolder paramDataHolder)
  {
    this.zzabx = paramDataHolder.getStatusCode();
    this.zzaGT = new HashMap();
    int j = paramDataHolder.getCount();
    if (j == 3) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzab(bool);
      int i = 0;
      while (i < j)
      {
        int k = paramDataHolder.zzbI(i);
        if (i == 0)
        {
          this.zzaGp = paramDataHolder.zzd("leaderboardId", i, k);
          this.zzabq = paramDataHolder.zzd("playerId", i, k);
        }
        if (paramDataHolder.zze("hasResult", i, k)) {
          zza(new Result(paramDataHolder.zzb("rawScore", i, k), paramDataHolder.zzd("formattedScore", i, k), paramDataHolder.zzd("scoreTag", i, k), paramDataHolder.zze("newBest", i, k)), paramDataHolder.zzc("timeSpan", i, k));
        }
        i += 1;
      }
    }
  }
  
  private void zza(Result paramResult, int paramInt)
  {
    this.zzaGT.put(Integer.valueOf(paramInt), paramResult);
  }
  
  public String getLeaderboardId()
  {
    return this.zzaGp;
  }
  
  public String getPlayerId()
  {
    return this.zzabq;
  }
  
  public Result getScoreResult(int paramInt)
  {
    return (Result)this.zzaGT.get(Integer.valueOf(paramInt));
  }
  
  public String toString()
  {
    zzw.zza localzza = zzw.zzx(this).zzg("PlayerId", this.zzabq).zzg("StatusCode", Integer.valueOf(this.zzabx));
    int i = 0;
    if (i < 3)
    {
      Object localObject = (Result)this.zzaGT.get(Integer.valueOf(i));
      localzza.zzg("TimesSpan", TimeSpan.zzgo(i));
      if (localObject == null) {}
      for (localObject = "null";; localObject = ((Result)localObject).toString())
      {
        localzza.zzg("Result", localObject);
        i += 1;
        break;
      }
    }
    return localzza.toString();
  }
  
  public static final class Result
  {
    public final String formattedScore;
    public final boolean newBest;
    public final long rawScore;
    public final String scoreTag;
    
    public Result(long paramLong, String paramString1, String paramString2, boolean paramBoolean)
    {
      this.rawScore = paramLong;
      this.formattedScore = paramString1;
      this.scoreTag = paramString2;
      this.newBest = paramBoolean;
    }
    
    public String toString()
    {
      return zzw.zzx(this).zzg("RawScore", Long.valueOf(this.rawScore)).zzg("FormattedScore", this.formattedScore).zzg("ScoreTag", this.scoreTag).zzg("NewBest", Boolean.valueOf(this.newBest)).toString();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/leaderboard/ScoreSubmissionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */