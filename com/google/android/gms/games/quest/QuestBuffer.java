package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

public final class QuestBuffer
  extends zzf<Quest>
{
  public QuestBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  protected String zzpO()
  {
    return "external_quest_id";
  }
  
  protected Quest zzs(int paramInt1, int paramInt2)
  {
    return new QuestRef(this.zzafC, paramInt1, paramInt2);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/quest/QuestBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */