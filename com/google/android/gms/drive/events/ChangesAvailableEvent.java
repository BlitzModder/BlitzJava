package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

public final class ChangesAvailableEvent
  implements SafeParcelable, DriveEvent
{
  public static final Parcelable.Creator<ChangesAvailableEvent> CREATOR = new zzb();
  final int mVersionCode;
  final String zzTD;
  final ChangesAvailableOptions zzanC;
  
  ChangesAvailableEvent(int paramInt, String paramString, ChangesAvailableOptions paramChangesAvailableOptions)
  {
    this.mVersionCode = paramInt;
    this.zzTD = paramString;
    this.zzanC = paramChangesAvailableOptions;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (paramObject == this);
      paramObject = (ChangesAvailableEvent)paramObject;
      if (!zzw.equal(this.zzanC, ((ChangesAvailableEvent)paramObject).zzanC)) {
        break;
      }
      bool1 = bool2;
    } while (zzw.equal(this.zzTD, ((ChangesAvailableEvent)paramObject).zzTD));
    return false;
  }
  
  public int getType()
  {
    return 4;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzanC, this.zzTD });
  }
  
  public String toString()
  {
    return String.format(Locale.US, "ChangesAvailableEvent [changesAvailableOptions=%s]", new Object[] { this.zzanC });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/events/ChangesAvailableEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */