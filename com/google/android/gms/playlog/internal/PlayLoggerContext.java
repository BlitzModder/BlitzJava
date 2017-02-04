package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class PlayLoggerContext
  implements SafeParcelable
{
  public static final zze CREATOR = new zze();
  public final String packageName;
  public final int versionCode;
  public final String zzaYA;
  public final String zzaYB;
  public final boolean zzaYC;
  public final String zzaYD;
  public final boolean zzaYE;
  public final int zzaYF;
  public final int zzaYy;
  public final int zzaYz;
  
  public PlayLoggerContext(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, boolean paramBoolean1, String paramString4, boolean paramBoolean2, int paramInt4)
  {
    this.versionCode = paramInt1;
    this.packageName = paramString1;
    this.zzaYy = paramInt2;
    this.zzaYz = paramInt3;
    this.zzaYA = paramString2;
    this.zzaYB = paramString3;
    this.zzaYC = paramBoolean1;
    this.zzaYD = paramString4;
    this.zzaYE = paramBoolean2;
    this.zzaYF = paramInt4;
  }
  
  public PlayLoggerContext(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt3)
  {
    this.versionCode = 1;
    this.packageName = ((String)zzx.zzy(paramString1));
    this.zzaYy = paramInt1;
    this.zzaYz = paramInt2;
    this.zzaYD = paramString2;
    this.zzaYA = paramString3;
    this.zzaYB = paramString4;
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.zzaYC = bool;
      this.zzaYE = paramBoolean;
      this.zzaYF = paramInt3;
      return;
    }
  }
  
  @Deprecated
  public PlayLoggerContext(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.versionCode = 1;
    this.packageName = ((String)zzx.zzy(paramString1));
    this.zzaYy = paramInt1;
    this.zzaYz = paramInt2;
    this.zzaYD = null;
    this.zzaYA = paramString2;
    this.zzaYB = paramString3;
    this.zzaYC = paramBoolean;
    this.zzaYE = false;
    this.zzaYF = 0;
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
      if (!(paramObject instanceof PlayLoggerContext)) {
        break;
      }
      paramObject = (PlayLoggerContext)paramObject;
    } while ((this.versionCode == ((PlayLoggerContext)paramObject).versionCode) && (this.packageName.equals(((PlayLoggerContext)paramObject).packageName)) && (this.zzaYy == ((PlayLoggerContext)paramObject).zzaYy) && (this.zzaYz == ((PlayLoggerContext)paramObject).zzaYz) && (zzw.equal(this.zzaYD, ((PlayLoggerContext)paramObject).zzaYD)) && (zzw.equal(this.zzaYA, ((PlayLoggerContext)paramObject).zzaYA)) && (zzw.equal(this.zzaYB, ((PlayLoggerContext)paramObject).zzaYB)) && (this.zzaYC == ((PlayLoggerContext)paramObject).zzaYC) && (this.zzaYE == ((PlayLoggerContext)paramObject).zzaYE) && (this.zzaYF == ((PlayLoggerContext)paramObject).zzaYF));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { Integer.valueOf(this.versionCode), this.packageName, Integer.valueOf(this.zzaYy), Integer.valueOf(this.zzaYz), this.zzaYD, this.zzaYA, this.zzaYB, Boolean.valueOf(this.zzaYC), Boolean.valueOf(this.zzaYE), Integer.valueOf(this.zzaYF) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayLoggerContext[");
    localStringBuilder.append("versionCode=").append(this.versionCode).append(',');
    localStringBuilder.append("package=").append(this.packageName).append(',');
    localStringBuilder.append("packageVersionCode=").append(this.zzaYy).append(',');
    localStringBuilder.append("logSource=").append(this.zzaYz).append(',');
    localStringBuilder.append("logSourceName=").append(this.zzaYD).append(',');
    localStringBuilder.append("uploadAccount=").append(this.zzaYA).append(',');
    localStringBuilder.append("loggingId=").append(this.zzaYB).append(',');
    localStringBuilder.append("logAndroidId=").append(this.zzaYC).append(',');
    localStringBuilder.append("isAnonymous=").append(this.zzaYE).append(',');
    localStringBuilder.append("qosTier=").append(this.zzaYF);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/playlog/internal/PlayLoggerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */