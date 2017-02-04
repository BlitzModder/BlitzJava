package com.google.android.gms.drive;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface DriveContents
{
  public abstract PendingResult<Status> commit(GoogleApiClient paramGoogleApiClient, MetadataChangeSet paramMetadataChangeSet);
  
  public abstract PendingResult<Status> commit(GoogleApiClient paramGoogleApiClient, MetadataChangeSet paramMetadataChangeSet, ExecutionOptions paramExecutionOptions);
  
  public abstract void discard(GoogleApiClient paramGoogleApiClient);
  
  public abstract DriveId getDriveId();
  
  public abstract InputStream getInputStream();
  
  public abstract int getMode();
  
  public abstract OutputStream getOutputStream();
  
  public abstract ParcelFileDescriptor getParcelFileDescriptor();
  
  public abstract PendingResult<DriveApi.DriveContentsResult> reopenForWrite(GoogleApiClient paramGoogleApiClient);
  
  public abstract Contents zzsh();
  
  public abstract void zzsi();
  
  public abstract boolean zzsj();
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/DriveContents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */