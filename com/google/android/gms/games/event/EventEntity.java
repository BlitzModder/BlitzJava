package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zznn;

public final class EventEntity
  implements SafeParcelable, Event
{
  public static final EventEntityCreator CREATOR = new EventEntityCreator();
  private final String mName;
  private final int mVersionCode;
  private final PlayerEntity zzaAL;
  private final String zzaBp;
  private final long zzaBq;
  private final String zzaBr;
  private final boolean zzaBs;
  private final String zzavc;
  private final Uri zzazC;
  private final String zzazN;
  
  EventEntity(int paramInt, String paramString1, String paramString2, String paramString3, Uri paramUri, String paramString4, Player paramPlayer, long paramLong, String paramString5, boolean paramBoolean)
  {
    this.mVersionCode = paramInt;
    this.zzaBp = paramString1;
    this.mName = paramString2;
    this.zzavc = paramString3;
    this.zzazC = paramUri;
    this.zzazN = paramString4;
    this.zzaAL = new PlayerEntity(paramPlayer);
    this.zzaBq = paramLong;
    this.zzaBr = paramString5;
    this.zzaBs = paramBoolean;
  }
  
  public EventEntity(Event paramEvent)
  {
    this.mVersionCode = 1;
    this.zzaBp = paramEvent.getEventId();
    this.mName = paramEvent.getName();
    this.zzavc = paramEvent.getDescription();
    this.zzazC = paramEvent.getIconImageUri();
    this.zzazN = paramEvent.getIconImageUrl();
    this.zzaAL = ((PlayerEntity)paramEvent.getPlayer().freeze());
    this.zzaBq = paramEvent.getValue();
    this.zzaBr = paramEvent.getFormattedValue();
    this.zzaBs = paramEvent.isVisible();
  }
  
  static int zza(Event paramEvent)
  {
    return zzw.hashCode(new Object[] { paramEvent.getEventId(), paramEvent.getName(), paramEvent.getDescription(), paramEvent.getIconImageUri(), paramEvent.getIconImageUrl(), paramEvent.getPlayer(), Long.valueOf(paramEvent.getValue()), paramEvent.getFormattedValue(), Boolean.valueOf(paramEvent.isVisible()) });
  }
  
  static boolean zza(Event paramEvent, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!(paramObject instanceof Event)) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramEvent == paramObject);
      paramObject = (Event)paramObject;
      if ((!zzw.equal(((Event)paramObject).getEventId(), paramEvent.getEventId())) || (!zzw.equal(((Event)paramObject).getName(), paramEvent.getName())) || (!zzw.equal(((Event)paramObject).getDescription(), paramEvent.getDescription())) || (!zzw.equal(((Event)paramObject).getIconImageUri(), paramEvent.getIconImageUri())) || (!zzw.equal(((Event)paramObject).getIconImageUrl(), paramEvent.getIconImageUrl())) || (!zzw.equal(((Event)paramObject).getPlayer(), paramEvent.getPlayer())) || (!zzw.equal(Long.valueOf(((Event)paramObject).getValue()), Long.valueOf(paramEvent.getValue()))) || (!zzw.equal(((Event)paramObject).getFormattedValue(), paramEvent.getFormattedValue()))) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(Boolean.valueOf(((Event)paramObject).isVisible()), Boolean.valueOf(paramEvent.isVisible())));
    return false;
  }
  
  static String zzb(Event paramEvent)
  {
    return zzw.zzx(paramEvent).zzg("Id", paramEvent.getEventId()).zzg("Name", paramEvent.getName()).zzg("Description", paramEvent.getDescription()).zzg("IconImageUri", paramEvent.getIconImageUri()).zzg("IconImageUrl", paramEvent.getIconImageUrl()).zzg("Player", paramEvent.getPlayer()).zzg("Value", Long.valueOf(paramEvent.getValue())).zzg("FormattedValue", paramEvent.getFormattedValue()).zzg("isVisible", Boolean.valueOf(paramEvent.isVisible())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return zza(this, paramObject);
  }
  
  public Event freeze()
  {
    return this;
  }
  
  public String getDescription()
  {
    return this.zzavc;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    zznn.zzb(this.zzavc, paramCharArrayBuffer);
  }
  
  public String getEventId()
  {
    return this.zzaBp;
  }
  
  public String getFormattedValue()
  {
    return this.zzaBr;
  }
  
  public void getFormattedValue(CharArrayBuffer paramCharArrayBuffer)
  {
    zznn.zzb(this.zzaBr, paramCharArrayBuffer);
  }
  
  public Uri getIconImageUri()
  {
    return this.zzazC;
  }
  
  public String getIconImageUrl()
  {
    return this.zzazN;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public void getName(CharArrayBuffer paramCharArrayBuffer)
  {
    zznn.zzb(this.mName, paramCharArrayBuffer);
  }
  
  public Player getPlayer()
  {
    return this.zzaAL;
  }
  
  public long getValue()
  {
    return this.zzaBq;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zza(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean isVisible()
  {
    return this.zzaBs;
  }
  
  public String toString()
  {
    return zzb(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    EventEntityCreator.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/games/event/EventEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */