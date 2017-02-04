package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes
{
  private static final String[] zzaGn = { "requestId", "outcome" };
  private final HashMap<String, Integer> zzaGo;
  private final int zzabx;
  
  private RequestUpdateOutcomes(int paramInt, HashMap<String, Integer> paramHashMap)
  {
    this.zzabx = paramInt;
    this.zzaGo = paramHashMap;
  }
  
  public static RequestUpdateOutcomes zzab(DataHolder paramDataHolder)
  {
    Builder localBuilder = new Builder();
    localBuilder.zzgy(paramDataHolder.getStatusCode());
    int j = paramDataHolder.getCount();
    int i = 0;
    while (i < j)
    {
      int k = paramDataHolder.zzbI(i);
      localBuilder.zzx(paramDataHolder.zzd("requestId", i, k), paramDataHolder.zzc("outcome", i, k));
      i += 1;
    }
    return localBuilder.zzxa();
  }
  
  public Set<String> getRequestIds()
  {
    return this.zzaGo.keySet();
  }
  
  public int getRequestOutcome(String paramString)
  {
    zzx.zzb(this.zzaGo.containsKey(paramString), "Request " + paramString + " was not part of the update operation!");
    return ((Integer)this.zzaGo.get(paramString)).intValue();
  }
  
  public static final class Builder
  {
    private HashMap<String, Integer> zzaGo = new HashMap();
    private int zzabx = 0;
    
    public Builder zzgy(int paramInt)
    {
      this.zzabx = paramInt;
      return this;
    }
    
    public Builder zzx(String paramString, int paramInt)
    {
      if (RequestUpdateResultOutcome.isValid(paramInt)) {
        this.zzaGo.put(paramString, Integer.valueOf(paramInt));
      }
      return this;
    }
    
    public RequestUpdateOutcomes zzxa()
    {
      return new RequestUpdateOutcomes(this.zzabx, this.zzaGo, null);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/request/RequestUpdateOutcomes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */