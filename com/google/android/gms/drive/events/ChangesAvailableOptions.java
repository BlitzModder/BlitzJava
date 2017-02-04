package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.DriveSpace;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class ChangesAvailableOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator<ChangesAvailableOptions> CREATOR = new zzd();
  final int mVersionCode;
  final int zzanD;
  final boolean zzanE;
  final List<DriveSpace> zzanF;
  private final Set<DriveSpace> zzanG;
  
  ChangesAvailableOptions(int paramInt1, int paramInt2, boolean paramBoolean, List<DriveSpace> paramList) {}
  
  private ChangesAvailableOptions(int paramInt1, int paramInt2, boolean paramBoolean, List<DriveSpace> paramList, Set<DriveSpace> paramSet)
  {
    this.mVersionCode = paramInt1;
    this.zzanD = paramInt2;
    this.zzanE = paramBoolean;
    this.zzanF = paramList;
    this.zzanG = paramSet;
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
      paramObject = (ChangesAvailableOptions)paramObject;
      if ((!zzw.equal(this.zzanG, ((ChangesAvailableOptions)paramObject).zzanG)) || (this.zzanD != ((ChangesAvailableOptions)paramObject).zzanD)) {
        break;
      }
      bool1 = bool2;
    } while (this.zzanE == ((ChangesAvailableOptions)paramObject).zzanE);
    return false;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzanG, Integer.valueOf(this.zzanD), Boolean.valueOf(this.zzanE) });
  }
  
  public String toString()
  {
    return String.format(Locale.US, "ChangesAvailableOptions[ChangesSizeLimit=%d, Repeats=%s, Spaces=%s]", new Object[] { Integer.valueOf(this.zzanD), Boolean.valueOf(this.zzanE), this.zzanF });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/events/ChangesAvailableOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */