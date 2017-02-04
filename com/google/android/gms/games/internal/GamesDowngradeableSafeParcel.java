package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.internal.zznr;

public abstract class GamesDowngradeableSafeParcel
  extends DowngradeableSafeParcel
{
  protected static boolean zzd(Integer paramInteger)
  {
    if (paramInteger == null) {
      return false;
    }
    return zznr.zzcq(paramInteger.intValue());
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/GamesDowngradeableSafeParcel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */