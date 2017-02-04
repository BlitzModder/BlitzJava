package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzab;
import com.google.android.gms.drive.internal.zzat;
import com.google.android.gms.drive.internal.zzau;
import com.google.android.gms.drive.internal.zzw;
import com.google.android.gms.drive.internal.zzy;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.internal.zztj;
import com.google.android.gms.internal.zztk;

public class DriveId
  implements SafeParcelable
{
  public static final Parcelable.Creator<DriveId> CREATOR = new zze();
  public static final int RESOURCE_TYPE_FILE = 0;
  public static final int RESOURCE_TYPE_FOLDER = 1;
  public static final int RESOURCE_TYPE_UNKNOWN = -1;
  final int mVersionCode;
  final long zzamA;
  private volatile String zzamC = null;
  final String zzamR;
  final long zzamS;
  final int zzamT;
  private volatile String zzamU = null;
  
  DriveId(int paramInt1, String paramString, long paramLong1, long paramLong2, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.zzamR = paramString;
    if (!"".equals(paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      zzx.zzab(bool1);
      if (paramString == null)
      {
        bool1 = bool2;
        if (paramLong1 == -1L) {}
      }
      else
      {
        bool1 = true;
      }
      zzx.zzab(bool1);
      this.zzamS = paramLong1;
      this.zzamA = paramLong2;
      this.zzamT = paramInt2;
      return;
    }
  }
  
  public DriveId(String paramString, long paramLong1, long paramLong2, int paramInt)
  {
    this(1, paramString, paramLong1, paramLong2, paramInt);
  }
  
  public static DriveId decodeFromString(String paramString)
  {
    zzx.zzb(paramString.startsWith("DriveId:"), "Invalid DriveId: " + paramString);
    return zzl(Base64.decode(paramString.substring("DriveId:".length()), 10));
  }
  
  public static DriveId zzcQ(String paramString)
  {
    zzx.zzy(paramString);
    return new DriveId(paramString, -1L, -1L, -1);
  }
  
  static DriveId zzl(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      zzat localzzat;
      try
      {
        localzzat = zzat.zzm(paramArrayOfByte);
        if ("".equals(localzzat.zzapV))
        {
          paramArrayOfByte = null;
          return new DriveId(localzzat.versionCode, paramArrayOfByte, localzzat.zzapW, localzzat.zzapT, localzzat.zzapX);
        }
      }
      catch (zztj paramArrayOfByte)
      {
        throw new IllegalArgumentException();
      }
      paramArrayOfByte = localzzat.zzapV;
    }
  }
  
  private byte[] zzsk()
  {
    zzau localzzau = new zzau();
    localzzau.zzapW = this.zzamS;
    localzzau.zzapT = this.zzamA;
    return zztk.toByteArray(localzzau);
  }
  
  public DriveFile asDriveFile()
  {
    if (this.zzamT == 1) {
      throw new IllegalStateException("This DriveId corresponds to a folder. Call asDriveFolder instead.");
    }
    return new zzw(this);
  }
  
  public DriveFolder asDriveFolder()
  {
    if (this.zzamT == 0) {
      throw new IllegalStateException("This DriveId corresponds to a file. Call asDriveFile instead.");
    }
    return new zzy(this);
  }
  
  public DriveResource asDriveResource()
  {
    if (this.zzamT == 1) {
      return asDriveFolder();
    }
    if (this.zzamT == 0) {
      return asDriveFile();
    }
    return new zzab(this);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String encodeToString()
  {
    if (this.zzamC == null)
    {
      String str = Base64.encodeToString(zzse(), 10);
      this.zzamC = ("DriveId:" + str);
    }
    return this.zzamC;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof DriveId)) {}
    do
    {
      do
      {
        return false;
        paramObject = (DriveId)paramObject;
      } while (((DriveId)paramObject).zzamA != this.zzamA);
      if ((((DriveId)paramObject).zzamS == -1L) && (this.zzamS == -1L)) {
        return ((DriveId)paramObject).zzamR.equals(this.zzamR);
      }
      if ((this.zzamR == null) || (((DriveId)paramObject).zzamR == null))
      {
        if (((DriveId)paramObject).zzamS == this.zzamS) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
    } while (((DriveId)paramObject).zzamS != this.zzamS);
    if (((DriveId)paramObject).zzamR.equals(this.zzamR)) {
      return true;
    }
    zzz.zzA("DriveId", "Unexpected unequal resourceId for same DriveId object.");
    return false;
  }
  
  public String getResourceId()
  {
    return this.zzamR;
  }
  
  public int getResourceType()
  {
    return this.zzamT;
  }
  
  public int hashCode()
  {
    if (this.zzamS == -1L) {
      return this.zzamR.hashCode();
    }
    return (String.valueOf(this.zzamA) + String.valueOf(this.zzamS)).hashCode();
  }
  
  public final String toInvariantString()
  {
    if (this.zzamU == null) {
      this.zzamU = Base64.encodeToString(zzsk(), 10);
    }
    return this.zzamU;
  }
  
  public String toString()
  {
    return encodeToString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt);
  }
  
  final byte[] zzse()
  {
    zzat localzzat = new zzat();
    localzzat.versionCode = this.mVersionCode;
    if (this.zzamR == null) {}
    for (String str = "";; str = this.zzamR)
    {
      localzzat.zzapV = str;
      localzzat.zzapW = this.zzamS;
      localzzat.zzapT = this.zzamA;
      localzzat.zzapX = this.zzamT;
      return zztk.toByteArray(localzzat);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/DriveId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */