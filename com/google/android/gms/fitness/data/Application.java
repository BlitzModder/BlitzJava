package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public final class Application
  implements SafeParcelable
{
  public static final Parcelable.Creator<Application> CREATOR = new zza();
  public static final Application zzatV = new Application("com.google.android.gms", String.valueOf(GooglePlayServicesUtil.GOOGLE_PLAY_SERVICES_VERSION_CODE), null);
  private final int mVersionCode;
  private final String zzSp;
  private final String zzabv;
  private final String zzatW;
  
  Application(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.mVersionCode = paramInt;
    this.zzSp = ((String)zzx.zzy(paramString1));
    this.zzabv = "";
    this.zzatW = paramString3;
  }
  
  public Application(String paramString1, String paramString2, String paramString3)
  {
    this(1, paramString1, "", paramString3);
  }
  
  private boolean zza(Application paramApplication)
  {
    return (this.zzSp.equals(paramApplication.zzSp)) && (zzw.equal(this.zzabv, paramApplication.zzabv)) && (zzw.equal(this.zzatW, paramApplication.zzatW));
  }
  
  public static Application zzde(String paramString)
  {
    return zze(paramString, null, null);
  }
  
  public static Application zze(String paramString1, String paramString2, String paramString3)
  {
    if ("com.google.android.gms".equals(paramString1)) {
      return zzatV;
    }
    return new Application(paramString1, paramString2, paramString3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof Application)) && (zza((Application)paramObject)));
  }
  
  public String getPackageName()
  {
    return this.zzSp;
  }
  
  public String getVersion()
  {
    return this.zzabv;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzSp, this.zzabv, this.zzatW });
  }
  
  public String toString()
  {
    return String.format("Application{%s:%s:%s}", new Object[] { this.zzSp, this.zzabv, this.zzatW });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public String zzty()
  {
    return this.zzatW;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/Application.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */