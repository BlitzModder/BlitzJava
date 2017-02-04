package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznm;
import java.util.Set;
import java.util.regex.Pattern;

public class DriveSpace
  implements SafeParcelable
{
  public static final Parcelable.Creator<DriveSpace> CREATOR = new zzh();
  public static final DriveSpace zzamW = new DriveSpace("DRIVE");
  public static final DriveSpace zzamX = new DriveSpace("APP_DATA_FOLDER");
  public static final DriveSpace zzamY = new DriveSpace("PHOTOS");
  public static final Set<DriveSpace> zzamZ = zznm.zza(zzamW, zzamX, zzamY);
  public static final String zzana = TextUtils.join(",", zzamZ.toArray());
  private static final Pattern zzanb = Pattern.compile("[A-Z0-9_]*");
  private final String mName;
  final int mVersionCode;
  
  DriveSpace(int paramInt, String paramString)
  {
    this.mVersionCode = paramInt;
    this.mName = ((String)zzx.zzy(paramString));
  }
  
  private DriveSpace(String paramString)
  {
    this(1, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (paramObject.getClass() != DriveSpace.class)) {
      return false;
    }
    return this.mName.equals(((DriveSpace)paramObject).mName);
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int hashCode()
  {
    return 0x4A54C0DE ^ this.mName.hashCode();
  }
  
  public String toString()
  {
    return this.mName;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/DriveSpace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */