package com.google.android.gms.clearcut;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.internal.zztp.zzd;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.Arrays;

public class LogEventParcelable
  implements SafeParcelable
{
  public static final zzc CREATOR = new zzc();
  public final int versionCode;
  public final zztp.zzd zzadA;
  public final zza.zzb zzadB;
  public final zza.zzb zzadC;
  public PlayLoggerContext zzadx;
  public byte[] zzady;
  public int[] zzadz;
  
  LogEventParcelable(int paramInt, PlayLoggerContext paramPlayLoggerContext, byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    this.versionCode = paramInt;
    this.zzadx = paramPlayLoggerContext;
    this.zzady = paramArrayOfByte;
    this.zzadz = paramArrayOfInt;
    this.zzadA = null;
    this.zzadB = null;
    this.zzadC = null;
  }
  
  public LogEventParcelable(PlayLoggerContext paramPlayLoggerContext, zztp.zzd paramzzd, zza.zzb paramzzb1, zza.zzb paramzzb2, int[] paramArrayOfInt)
  {
    this.versionCode = 1;
    this.zzadx = paramPlayLoggerContext;
    this.zzadA = paramzzd;
    this.zzadB = paramzzb1;
    this.zzadC = paramzzb2;
    this.zzadz = paramArrayOfInt;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof LogEventParcelable)) {
        break;
      }
      paramObject = (LogEventParcelable)paramObject;
    } while ((this.versionCode == ((LogEventParcelable)paramObject).versionCode) && (zzw.equal(this.zzadx, ((LogEventParcelable)paramObject).zzadx)) && (Arrays.equals(this.zzady, ((LogEventParcelable)paramObject).zzady)) && (Arrays.equals(this.zzadz, ((LogEventParcelable)paramObject).zzadz)) && (zzw.equal(this.zzadA, ((LogEventParcelable)paramObject).zzadA)) && (zzw.equal(this.zzadB, ((LogEventParcelable)paramObject).zzadB)) && (zzw.equal(this.zzadC, ((LogEventParcelable)paramObject).zzadC)));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.versionCode), this.zzadx, this.zzady, this.zzadz, this.zzadA, this.zzadB, this.zzadC });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("LogEventParcelable[");
    localStringBuilder.append(this.versionCode);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.zzadx);
    localStringBuilder.append(", ");
    if (this.zzady == null)
    {
      str = null;
      localStringBuilder.append(str);
      localStringBuilder.append(", ");
      if (this.zzadz != null) {
        break label157;
      }
    }
    label157:
    for (String str = (String)null;; str = zzv.zzcF(", ").zza(Arrays.asList(new int[][] { this.zzadz })))
    {
      localStringBuilder.append(str);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.zzadA);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.zzadB);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.zzadC);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      str = new String(this.zzady);
      break;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/clearcut/LogEventParcelable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */