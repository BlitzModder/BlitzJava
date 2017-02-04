package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import java.util.List;

public abstract interface AppContentCard
  extends Parcelable, Freezable<AppContentCard>
{
  public abstract List<AppContentAction> getActions();
  
  public abstract String getDescription();
  
  public abstract Bundle getExtras();
  
  public abstract String getId();
  
  public abstract String getTitle();
  
  public abstract String getType();
  
  public abstract List<AppContentCondition> zzvj();
  
  public abstract String zzvk();
  
  public abstract List<AppContentAnnotation> zzvu();
  
  public abstract int zzvv();
  
  public abstract String zzvw();
  
  public abstract int zzvx();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/appcontent/AppContentCard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */