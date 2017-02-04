package com.google.android.gms.games.appcontent;

import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;

public abstract interface AppContentTuple
  extends Parcelable, Freezable<AppContentTuple>
{
  public abstract String getName();
  
  public abstract String getValue();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/appcontent/AppContentTuple.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */