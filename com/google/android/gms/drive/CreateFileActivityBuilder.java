package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzl;
import com.google.android.gms.drive.internal.zzv;

public class CreateFileActivityBuilder
{
  public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
  private final zzl zzamH = new zzl(0);
  private DriveContents zzamI;
  private boolean zzamJ;
  
  public IntentSender build(GoogleApiClient paramGoogleApiClient)
  {
    zzx.zzb(Boolean.valueOf(this.zzamJ), "Must call setInitialDriveContents to CreateFileActivityBuilder.");
    zzx.zza(paramGoogleApiClient.isConnected(), "Client must be connected");
    if (this.zzamI != null) {
      this.zzamI.zzsi();
    }
    return this.zzamH.build(paramGoogleApiClient);
  }
  
  public CreateFileActivityBuilder setActivityStartFolder(DriveId paramDriveId)
  {
    this.zzamH.zza(paramDriveId);
    return this;
  }
  
  public CreateFileActivityBuilder setActivityTitle(String paramString)
  {
    this.zzamH.zzcT(paramString);
    return this;
  }
  
  public CreateFileActivityBuilder setInitialDriveContents(DriveContents paramDriveContents)
  {
    if (paramDriveContents != null)
    {
      if (!(paramDriveContents instanceof zzv)) {
        throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
      }
      if (paramDriveContents.getDriveId() != null) {
        throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
      }
      if (paramDriveContents.zzsj()) {
        throw new IllegalArgumentException("DriveContents are already closed.");
      }
      this.zzamH.zzcW(paramDriveContents.zzsh().getRequestId());
      this.zzamI = paramDriveContents;
    }
    for (;;)
    {
      this.zzamJ = true;
      return this;
      this.zzamH.zzcW(1);
    }
  }
  
  public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet paramMetadataChangeSet)
  {
    this.zzamH.zza(paramMetadataChangeSet);
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/CreateFileActivityBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */