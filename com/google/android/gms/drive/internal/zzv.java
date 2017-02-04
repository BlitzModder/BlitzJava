package com.google.android.gms.drive.internal;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.ExecutionOptions.Builder;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zznt;
import java.io.InputStream;
import java.io.OutputStream;

public class zzv
  implements DriveContents
{
  private boolean mClosed = false;
  private final Contents zzaoW;
  private boolean zzaoX = false;
  private boolean zzaoY = false;
  
  public zzv(Contents paramContents)
  {
    this.zzaoW = ((Contents)zzx.zzy(paramContents));
  }
  
  public PendingResult<Status> commit(GoogleApiClient paramGoogleApiClient, MetadataChangeSet paramMetadataChangeSet)
  {
    return commit(paramGoogleApiClient, paramMetadataChangeSet, null);
  }
  
  public PendingResult<Status> commit(GoogleApiClient paramGoogleApiClient, final MetadataChangeSet paramMetadataChangeSet, ExecutionOptions paramExecutionOptions)
  {
    final ExecutionOptions localExecutionOptions = paramExecutionOptions;
    if (paramExecutionOptions == null) {
      localExecutionOptions = new ExecutionOptions.Builder().build();
    }
    if (this.zzaoW.getMode() == 268435456) {
      throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
    }
    if ((ExecutionOptions.zzcy(localExecutionOptions.zzsn())) && (!this.zzaoW.zzsf())) {
      throw new IllegalStateException("DriveContents must be valid for conflict detection.");
    }
    ExecutionOptions.zza(paramGoogleApiClient, localExecutionOptions);
    if (zzsj()) {
      throw new IllegalStateException("DriveContents already closed.");
    }
    if (getDriveId() == null) {
      throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
    }
    if (paramMetadataChangeSet != null) {}
    for (;;)
    {
      zzsi();
      paramGoogleApiClient.zzb(new zzt.zza(paramGoogleApiClient)
      {
        protected void zza(zzu paramAnonymouszzu)
          throws RemoteException
        {
          paramMetadataChangeSet.zzsp().setContext(paramAnonymouszzu.getContext());
          paramAnonymouszzu.zzsF().zza(new CloseContentsAndUpdateMetadataRequest(zzv.zza(zzv.this).getDriveId(), paramMetadataChangeSet.zzsp(), zzv.zza(zzv.this).getRequestId(), zzv.zza(zzv.this).zzsf(), localExecutionOptions), new zzbt(this));
        }
      });
      paramMetadataChangeSet = MetadataChangeSet.zzanh;
    }
  }
  
  public void discard(GoogleApiClient paramGoogleApiClient)
  {
    if (zzsj()) {
      throw new IllegalStateException("DriveContents already closed.");
    }
    zzsi();
    ((4)paramGoogleApiClient.zzb(new zzt.zza(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramAnonymouszzu.zzsF().zza(new CloseContentsRequest(zzv.zza(zzv.this).getRequestId(), false), new zzbt(this));
      }
    })).setResultCallback(new ResultCallback()
    {
      public void zzp(Status paramAnonymousStatus)
      {
        if (!paramAnonymousStatus.isSuccess())
        {
          zzz.zzB("DriveContentsImpl", "Error discarding contents");
          return;
        }
        zzz.zzz("DriveContentsImpl", "Contents discarded");
      }
    });
  }
  
  public DriveId getDriveId()
  {
    return this.zzaoW.getDriveId();
  }
  
  public InputStream getInputStream()
  {
    if (zzsj()) {
      throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
    }
    if (this.zzaoW.getMode() != 268435456) {
      throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
    }
    if (this.zzaoX) {
      throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
    }
    this.zzaoX = true;
    return this.zzaoW.getInputStream();
  }
  
  public int getMode()
  {
    return this.zzaoW.getMode();
  }
  
  public OutputStream getOutputStream()
  {
    if (zzsj()) {
      throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }
    if (this.zzaoW.getMode() != 536870912) {
      throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
    }
    if (this.zzaoY) {
      throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
    }
    this.zzaoY = true;
    return this.zzaoW.getOutputStream();
  }
  
  public ParcelFileDescriptor getParcelFileDescriptor()
  {
    if (zzsj()) {
      throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }
    return this.zzaoW.getParcelFileDescriptor();
  }
  
  public PendingResult<DriveApi.DriveContentsResult> reopenForWrite(GoogleApiClient paramGoogleApiClient)
  {
    if (zzsj()) {
      throw new IllegalStateException("DriveContents already closed.");
    }
    if (this.zzaoW.getMode() != 268435456) {
      throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
    }
    zzsi();
    paramGoogleApiClient.zza(new zzs.zzc(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramAnonymouszzu.zzsF().zza(new OpenContentsRequest(zzv.this.getDriveId(), 536870912, zzv.zza(zzv.this).getRequestId()), new zzbl(this, null));
      }
    });
  }
  
  public Contents zzsh()
  {
    return this.zzaoW;
  }
  
  public void zzsi()
  {
    zznt.zza(this.zzaoW.getParcelFileDescriptor());
    this.mClosed = true;
  }
  
  public boolean zzsj()
  {
    return this.mClosed;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */