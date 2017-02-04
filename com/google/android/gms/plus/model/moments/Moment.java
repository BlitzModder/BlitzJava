package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.plus.internal.model.moments.ItemScopeEntity;
import com.google.android.gms.plus.internal.model.moments.MomentEntity;
import java.util.HashSet;
import java.util.Set;

public abstract interface Moment
  extends Freezable<Moment>
{
  public abstract String getId();
  
  public abstract ItemScope getResult();
  
  public abstract String getStartDate();
  
  public abstract ItemScope getTarget();
  
  public abstract String getType();
  
  public abstract boolean hasId();
  
  public abstract boolean hasResult();
  
  public abstract boolean hasStartDate();
  
  public abstract boolean hasTarget();
  
  public abstract boolean hasType();
  
  public static class Builder
  {
    private String zzIx;
    private final Set<Integer> zzaZA = new HashSet();
    private String zzban;
    private ItemScopeEntity zzbav;
    private ItemScopeEntity zzbaw;
    private String zzxX;
    
    public Moment build()
    {
      return new MomentEntity(this.zzaZA, this.zzxX, this.zzbav, this.zzban, this.zzbaw, this.zzIx);
    }
    
    public Builder setId(String paramString)
    {
      this.zzxX = paramString;
      this.zzaZA.add(Integer.valueOf(2));
      return this;
    }
    
    public Builder setResult(ItemScope paramItemScope)
    {
      this.zzbav = ((ItemScopeEntity)paramItemScope);
      this.zzaZA.add(Integer.valueOf(4));
      return this;
    }
    
    public Builder setStartDate(String paramString)
    {
      this.zzban = paramString;
      this.zzaZA.add(Integer.valueOf(5));
      return this;
    }
    
    public Builder setTarget(ItemScope paramItemScope)
    {
      this.zzbaw = ((ItemScopeEntity)paramItemScope);
      this.zzaZA.add(Integer.valueOf(6));
      return this;
    }
    
    public Builder setType(String paramString)
    {
      this.zzIx = paramString;
      this.zzaZA.add(Integer.valueOf(7));
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/plus/model/moments/Moment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */