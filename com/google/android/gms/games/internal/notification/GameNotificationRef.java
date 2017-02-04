package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;

public final class GameNotificationRef
  extends zzc
  implements GameNotification
{
  GameNotificationRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public long getId()
  {
    return getLong("_id");
  }
  
  public String getText()
  {
    return getString("text");
  }
  
  public String getTitle()
  {
    return getString("title");
  }
  
  public int getType()
  {
    return getInteger("type");
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("Id", Long.valueOf(getId())).zzg("NotificationId", zzwM()).zzg("Type", Integer.valueOf(getType())).zzg("Title", getTitle()).zzg("Ticker", zzwN()).zzg("Text", getText()).zzg("CoalescedText", zzwO()).zzg("isAcknowledged", Boolean.valueOf(zzwP())).zzg("isSilent", Boolean.valueOf(zzwQ())).toString();
  }
  
  public String zzwM()
  {
    return getString("notification_id");
  }
  
  public String zzwN()
  {
    return getString("ticker");
  }
  
  public String zzwO()
  {
    return getString("coalesced_text");
  }
  
  public boolean zzwP()
  {
    return getInteger("acknowledged") > 0;
  }
  
  public boolean zzwQ()
  {
    return getInteger("alert_level") == 0;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/internal/notification/GameNotificationRef.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */