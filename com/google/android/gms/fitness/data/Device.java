package com.google.android.gms.fitness.data;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.provider.Settings.Secure;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzoo;
import com.google.android.gms.internal.zzps;

public final class Device
  implements SafeParcelable
{
  public static final Parcelable.Creator<Device> CREATOR = new zzh();
  public static final int TYPE_CHEST_STRAP = 4;
  public static final int TYPE_PHONE = 1;
  public static final int TYPE_SCALE = 5;
  public static final int TYPE_TABLET = 2;
  public static final int TYPE_UNKNOWN = 0;
  public static final int TYPE_WATCH = 3;
  private final int mVersionCode;
  private final int zzZU;
  private final String zzabv;
  private final String zzauA;
  private final String zzauB;
  private final String zzauC;
  private final int zzauD;
  
  Device(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzauA = ((String)zzx.zzy(paramString1));
    this.zzauB = ((String)zzx.zzy(paramString2));
    this.zzabv = "";
    this.zzauC = ((String)zzx.zzy(paramString4));
    this.zzZU = paramInt2;
    this.zzauD = paramInt3;
  }
  
  public Device(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this(paramString1, paramString2, "", paramString3, paramInt, 0);
  }
  
  public Device(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    this(1, paramString1, paramString2, "", paramString4, paramInt1, paramInt2);
  }
  
  public static Device getLocalDevice(Context paramContext)
  {
    int i = zzoo.zzaF(paramContext);
    paramContext = zzaB(paramContext);
    return new Device(Build.MANUFACTURER, Build.MODEL, Build.VERSION.RELEASE, paramContext, i, 2);
  }
  
  private boolean zza(Device paramDevice)
  {
    return (zzw.equal(this.zzauA, paramDevice.zzauA)) && (zzw.equal(this.zzauB, paramDevice.zzauB)) && (zzw.equal(this.zzabv, paramDevice.zzabv)) && (zzw.equal(this.zzauC, paramDevice.zzauC)) && (this.zzZU == paramDevice.zzZU) && (this.zzauD == paramDevice.zzauD);
  }
  
  private static String zzaB(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
  
  private boolean zztO()
  {
    return zztN() == 1;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof Device)) && (zza((Device)paramObject)));
  }
  
  public String getManufacturer()
  {
    return this.zzauA;
  }
  
  public String getModel()
  {
    return this.zzauB;
  }
  
  String getStreamIdentifier()
  {
    return String.format("%s:%s:%s", new Object[] { this.zzauA, this.zzauB, this.zzauC });
  }
  
  public int getType()
  {
    return this.zzZU;
  }
  
  public String getUid()
  {
    return this.zzauC;
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
    return zzw.hashCode(new Object[] { this.zzauA, this.zzauB, this.zzabv, this.zzauC, Integer.valueOf(this.zzZU) });
  }
  
  public String toString()
  {
    return String.format("Device{%s:%s:%s:%s}", new Object[] { getStreamIdentifier(), this.zzabv, Integer.valueOf(this.zzZU), Integer.valueOf(this.zzauD) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzh.zza(this, paramParcel, paramInt);
  }
  
  public int zztN()
  {
    return this.zzauD;
  }
  
  public String zztP()
  {
    if (zztO()) {
      return this.zzauC;
    }
    return zzps.zzdr(this.zzauC);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/Device.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */