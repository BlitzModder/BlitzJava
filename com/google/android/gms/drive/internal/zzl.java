package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzl
{
  private String zzank;
  private DriveId zzann;
  protected MetadataChangeSet zzaoq;
  private Integer zzaor;
  private final int zzaos;
  
  public zzl(int paramInt)
  {
    this.zzaos = paramInt;
  }
  
  public IntentSender build(GoogleApiClient paramGoogleApiClient)
  {
    zzx.zzb(this.zzaoq, "Must provide initial metadata to CreateFileActivityBuilder.");
    zzx.zza(paramGoogleApiClient.isConnected(), "Client must be connected");
    paramGoogleApiClient = (zzu)paramGoogleApiClient.zza(Drive.zzTo);
    this.zzaoq.zzsp().setContext(paramGoogleApiClient.getContext());
    if (this.zzaor == null) {}
    for (int i = 0;; i = this.zzaor.intValue()) {
      try
      {
        paramGoogleApiClient = paramGoogleApiClient.zzsF().zza(new CreateFileIntentSenderRequest(this.zzaoq.zzsp(), i, this.zzank, this.zzann, this.zzaos));
        return paramGoogleApiClient;
      }
      catch (RemoteException paramGoogleApiClient)
      {
        throw new RuntimeException("Unable to connect Drive Play Service", paramGoogleApiClient);
      }
    }
  }
  
  public void zza(DriveId paramDriveId)
  {
    this.zzann = ((DriveId)zzx.zzy(paramDriveId));
  }
  
  public void zza(MetadataChangeSet paramMetadataChangeSet)
  {
    this.zzaoq = ((MetadataChangeSet)zzx.zzy(paramMetadataChangeSet));
  }
  
  public void zzcT(String paramString)
  {
    this.zzank = ((String)zzx.zzy(paramString));
  }
  
  public void zzcW(int paramInt)
  {
    this.zzaor = Integer.valueOf(paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */