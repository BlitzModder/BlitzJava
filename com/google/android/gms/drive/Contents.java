package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Contents
  implements SafeParcelable
{
  public static final Parcelable.Creator<Contents> CREATOR = new zzb();
  final int mVersionCode;
  final ParcelFileDescriptor zzaid;
  final int zzamD;
  final int zzamE;
  final DriveId zzamF;
  final boolean zzamG;
  final String zzsL;
  
  Contents(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2, int paramInt3, DriveId paramDriveId, boolean paramBoolean, String paramString)
  {
    this.mVersionCode = paramInt1;
    this.zzaid = paramParcelFileDescriptor;
    this.zzamD = paramInt2;
    this.zzamE = paramInt3;
    this.zzamF = paramDriveId;
    this.zzamG = paramBoolean;
    this.zzsL = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DriveId getDriveId()
  {
    return this.zzamF;
  }
  
  public InputStream getInputStream()
  {
    return new FileInputStream(this.zzaid.getFileDescriptor());
  }
  
  public int getMode()
  {
    return this.zzamE;
  }
  
  public OutputStream getOutputStream()
  {
    return new FileOutputStream(this.zzaid.getFileDescriptor());
  }
  
  public ParcelFileDescriptor getParcelFileDescriptor()
  {
    return this.zzaid;
  }
  
  public int getRequestId()
  {
    return this.zzamD;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public boolean zzsf()
  {
    return this.zzamG;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/Contents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */