package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface AppContentAnnotation
  extends Parcelable, Freezable<AppContentAnnotation>
{
  public abstract String getDescription();
  
  public abstract String getId();
  
  public abstract String getTitle();
  
  public abstract String zzvn();
  
  public abstract int zzvo();
  
  public abstract Uri zzvp();
  
  public abstract Bundle zzvq();
  
  public abstract int zzvr();
  
  public abstract String zzvs();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/appcontent/AppContentAnnotation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */