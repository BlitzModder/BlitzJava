package com.google.android.gms.location.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

public class ParcelableGeofence
  implements SafeParcelable, Geofence
{
  public static final zzo CREATOR = new zzo();
  private final int mVersionCode;
  private final String zzDX;
  private final int zzaKO;
  private final short zzaKQ;
  private final double zzaKR;
  private final double zzaKS;
  private final float zzaKT;
  private final int zzaKU;
  private final int zzaKV;
  private final long zzaMl;
  
  public ParcelableGeofence(int paramInt1, String paramString, int paramInt2, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt3, int paramInt4)
  {
    zzdU(paramString);
    zze(paramFloat);
    zza(paramDouble1, paramDouble2);
    paramInt2 = zzhw(paramInt2);
    this.mVersionCode = paramInt1;
    this.zzaKQ = paramShort;
    this.zzDX = paramString;
    this.zzaKR = paramDouble1;
    this.zzaKS = paramDouble2;
    this.zzaKT = paramFloat;
    this.zzaMl = paramLong;
    this.zzaKO = paramInt2;
    this.zzaKU = paramInt3;
    this.zzaKV = paramInt4;
  }
  
  public ParcelableGeofence(String paramString, int paramInt1, short paramShort, double paramDouble1, double paramDouble2, float paramFloat, long paramLong, int paramInt2, int paramInt3)
  {
    this(1, paramString, paramInt1, paramShort, paramDouble1, paramDouble2, paramFloat, paramLong, paramInt2, paramInt3);
  }
  
  private static void zza(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 > 90.0D) || (paramDouble1 < -90.0D)) {
      throw new IllegalArgumentException("invalid latitude: " + paramDouble1);
    }
    if ((paramDouble2 > 180.0D) || (paramDouble2 < -180.0D)) {
      throw new IllegalArgumentException("invalid longitude: " + paramDouble2);
    }
  }
  
  private static void zzdU(String paramString)
  {
    if ((paramString == null) || (paramString.length() > 100)) {
      throw new IllegalArgumentException("requestId is null or too long: " + paramString);
    }
  }
  
  private static void zze(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      throw new IllegalArgumentException("invalid radius: " + paramFloat);
    }
  }
  
  private static int zzhw(int paramInt)
  {
    int i = paramInt & 0x7;
    if (i == 0) {
      throw new IllegalArgumentException("No supported transition specified: " + paramInt);
    }
    return i;
  }
  
  private static String zzhx(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    }
    return "CIRCLE";
  }
  
  public static ParcelableGeofence zzo(byte[] paramArrayOfByte)
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(paramArrayOfByte, 0, paramArrayOfByte.length);
    localParcel.setDataPosition(0);
    paramArrayOfByte = CREATOR.zzeQ(localParcel);
    localParcel.recycle();
    return paramArrayOfByte;
  }
  
  public int describeContents()
  {
    zzo localzzo = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (!(paramObject instanceof ParcelableGeofence)) {
        return false;
      }
      paramObject = (ParcelableGeofence)paramObject;
      if (this.zzaKT != ((ParcelableGeofence)paramObject).zzaKT) {
        return false;
      }
      if (this.zzaKR != ((ParcelableGeofence)paramObject).zzaKR) {
        return false;
      }
      if (this.zzaKS != ((ParcelableGeofence)paramObject).zzaKS) {
        return false;
      }
    } while (this.zzaKQ == ((ParcelableGeofence)paramObject).zzaKQ);
    return false;
  }
  
  public long getExpirationTime()
  {
    return this.zzaMl;
  }
  
  public double getLatitude()
  {
    return this.zzaKR;
  }
  
  public double getLongitude()
  {
    return this.zzaKS;
  }
  
  public int getNotificationResponsiveness()
  {
    return this.zzaKU;
  }
  
  public String getRequestId()
  {
    return this.zzDX;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.zzaKR);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.zzaKS);
    return ((((i + 31) * 31 + (int)(l ^ l >>> 32)) * 31 + Float.floatToIntBits(this.zzaKT)) * 31 + this.zzaKQ) * 31 + this.zzaKO;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", new Object[] { zzhx(this.zzaKQ), this.zzDX, Integer.valueOf(this.zzaKO), Double.valueOf(this.zzaKR), Double.valueOf(this.zzaKS), Float.valueOf(this.zzaKT), Integer.valueOf(this.zzaKU / 1000), Integer.valueOf(this.zzaKV), Long.valueOf(this.zzaMl) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo localzzo = CREATOR;
    zzo.zza(this, paramParcel, paramInt);
  }
  
  public short zzyh()
  {
    return this.zzaKQ;
  }
  
  public float zzyi()
  {
    return this.zzaKT;
  }
  
  public int zzyj()
  {
    return this.zzaKO;
  }
  
  public int zzyk()
  {
    return this.zzaKV;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/internal/ParcelableGeofence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */