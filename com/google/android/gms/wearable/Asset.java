package com.google.android.gms.wearable;

import android.net.Uri;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public class Asset
  implements SafeParcelable
{
  public static final Parcelable.Creator<Asset> CREATOR = new zze();
  final int mVersionCode;
  public Uri uri;
  private byte[] zzaHC;
  private String zzblL;
  public ParcelFileDescriptor zzblM;
  
  Asset(int paramInt, byte[] paramArrayOfByte, String paramString, ParcelFileDescriptor paramParcelFileDescriptor, Uri paramUri)
  {
    this.mVersionCode = paramInt;
    this.zzaHC = paramArrayOfByte;
    this.zzblL = paramString;
    this.zzblM = paramParcelFileDescriptor;
    this.uri = paramUri;
  }
  
  public static Asset createFromBytes(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("Asset data cannot be null");
    }
    return new Asset(1, paramArrayOfByte, null, null, null);
  }
  
  public static Asset createFromFd(ParcelFileDescriptor paramParcelFileDescriptor)
  {
    if (paramParcelFileDescriptor == null) {
      throw new IllegalArgumentException("Asset fd cannot be null");
    }
    return new Asset(1, null, null, paramParcelFileDescriptor, null);
  }
  
  public static Asset createFromRef(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Asset digest cannot be null");
    }
    return new Asset(1, null, paramString, null, null);
  }
  
  public static Asset createFromUri(Uri paramUri)
  {
    if (paramUri == null) {
      throw new IllegalArgumentException("Asset uri cannot be null");
    }
    return new Asset(1, null, null, null, paramUri);
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
      if (!(paramObject instanceof Asset)) {
        return false;
      }
      paramObject = (Asset)paramObject;
    } while ((zzw.equal(this.zzaHC, ((Asset)paramObject).zzaHC)) && (zzw.equal(this.zzblL, ((Asset)paramObject).zzblL)) && (zzw.equal(this.zzblM, ((Asset)paramObject).zzblM)) && (zzw.equal(this.uri, ((Asset)paramObject).uri)));
    return false;
  }
  
  public byte[] getData()
  {
    return this.zzaHC;
  }
  
  public String getDigest()
  {
    return this.zzblL;
  }
  
  public ParcelFileDescriptor getFd()
  {
    return this.zzblM;
  }
  
  public Uri getUri()
  {
    return this.uri;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaHC, this.zzblL, this.zzblM, this.uri });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Asset[@");
    localStringBuilder.append(Integer.toHexString(hashCode()));
    if (this.zzblL == null) {
      localStringBuilder.append(", nodigest");
    }
    for (;;)
    {
      if (this.zzaHC != null)
      {
        localStringBuilder.append(", size=");
        localStringBuilder.append(this.zzaHC.length);
      }
      if (this.zzblM != null)
      {
        localStringBuilder.append(", fd=");
        localStringBuilder.append(this.zzblM);
      }
      if (this.uri != null)
      {
        localStringBuilder.append(", uri=");
        localStringBuilder.append(this.uri);
      }
      localStringBuilder.append("]");
      return localStringBuilder.toString();
      localStringBuilder.append(", ");
      localStringBuilder.append(this.zzblL);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt | 0x1);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/Asset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */