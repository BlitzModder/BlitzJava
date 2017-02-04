package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.ExecutionOptions.Builder;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.Query.Builder;
import com.google.android.gms.drive.query.SearchableField;
import com.google.android.gms.internal.zzlx.zzb;

public class zzy
  extends zzab
  implements DriveFolder
{
  public zzy(DriveId paramDriveId)
  {
    super(paramDriveId);
  }
  
  private PendingResult<DriveFolder.DriveFileResult> zza(GoogleApiClient paramGoogleApiClient, final MetadataChangeSet paramMetadataChangeSet, final int paramInt1, final int paramInt2, final ExecutionOptions paramExecutionOptions)
  {
    ExecutionOptions.zza(paramGoogleApiClient, paramExecutionOptions);
    paramGoogleApiClient.zzb(new zzd(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramMetadataChangeSet.zzsp().setContext(paramAnonymouszzu.getContext());
        CreateFileRequest localCreateFileRequest = new CreateFileRequest(zzy.this.getDriveId(), paramMetadataChangeSet.zzsp(), paramInt1, paramInt2, paramExecutionOptions);
        paramAnonymouszzu.zzsF().zza(localCreateFileRequest, new zzy.zza(this));
      }
    });
  }
  
  private PendingResult<DriveFolder.DriveFileResult> zza(GoogleApiClient paramGoogleApiClient, MetadataChangeSet paramMetadataChangeSet, DriveContents paramDriveContents, ExecutionOptions paramExecutionOptions)
  {
    int i;
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
      i = paramDriveContents.zzsh().getRequestId();
      paramDriveContents.zzsi();
    }
    while (paramMetadataChangeSet == null)
    {
      throw new IllegalArgumentException("MetadataChangeSet must be provided.");
      i = 1;
    }
    if ("application/vnd.google-apps.folder".equals(paramMetadataChangeSet.getMimeType())) {
      throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
    }
    return zza(paramGoogleApiClient, paramMetadataChangeSet, i, 0, paramExecutionOptions);
  }
  
  private Query zza(Query paramQuery)
  {
    Query.Builder localBuilder = new Query.Builder().addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
    if (paramQuery != null)
    {
      if (paramQuery.getFilter() != null) {
        localBuilder.addFilter(paramQuery.getFilter());
      }
      localBuilder.setPageToken(paramQuery.getPageToken());
      localBuilder.setSortOrder(paramQuery.getSortOrder());
    }
    return localBuilder.build();
  }
  
  public PendingResult<DriveFolder.DriveFileResult> createFile(GoogleApiClient paramGoogleApiClient, MetadataChangeSet paramMetadataChangeSet, DriveContents paramDriveContents)
  {
    return createFile(paramGoogleApiClient, paramMetadataChangeSet, paramDriveContents, null);
  }
  
  public PendingResult<DriveFolder.DriveFileResult> createFile(GoogleApiClient paramGoogleApiClient, MetadataChangeSet paramMetadataChangeSet, DriveContents paramDriveContents, ExecutionOptions paramExecutionOptions)
  {
    ExecutionOptions localExecutionOptions = paramExecutionOptions;
    if (paramExecutionOptions == null) {
      localExecutionOptions = new ExecutionOptions.Builder().build();
    }
    if (localExecutionOptions.zzsn() != 0) {
      throw new IllegalStateException("May not set a conflict strategy for calls to createFile.");
    }
    return zza(paramGoogleApiClient, paramMetadataChangeSet, paramDriveContents, localExecutionOptions);
  }
  
  public PendingResult<DriveFolder.DriveFolderResult> createFolder(GoogleApiClient paramGoogleApiClient, final MetadataChangeSet paramMetadataChangeSet)
  {
    if (paramMetadataChangeSet == null) {
      throw new IllegalArgumentException("MetadataChangeSet must be provided.");
    }
    if ((paramMetadataChangeSet.getMimeType() != null) && (!paramMetadataChangeSet.getMimeType().equals("application/vnd.google-apps.folder"))) {
      throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
    }
    paramGoogleApiClient.zzb(new zzf(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramMetadataChangeSet.zzsp().setContext(paramAnonymouszzu.getContext());
        paramAnonymouszzu.zzsF().zza(new CreateFolderRequest(zzy.this.getDriveId(), paramMetadataChangeSet.zzsp()), new zzy.zzb(this));
      }
    });
  }
  
  public PendingResult<DriveApi.MetadataBufferResult> listChildren(GoogleApiClient paramGoogleApiClient)
  {
    return queryChildren(paramGoogleApiClient, null);
  }
  
  public PendingResult<DriveApi.MetadataBufferResult> queryChildren(GoogleApiClient paramGoogleApiClient, Query paramQuery)
  {
    return new zzs().query(paramGoogleApiClient, zza(paramQuery));
  }
  
  private static class zza
    extends zzd
  {
    private final zzlx.zzb<DriveFolder.DriveFileResult> zzakL;
    
    public zza(zzlx.zzb<DriveFolder.DriveFileResult> paramzzb)
    {
      this.zzakL = paramzzb;
    }
    
    public void zzA(Status paramStatus)
      throws RemoteException
    {
      this.zzakL.zzr(new zzy.zzc(paramStatus, null));
    }
    
    public void zza(OnDriveIdResponse paramOnDriveIdResponse)
      throws RemoteException
    {
      this.zzakL.zzr(new zzy.zzc(Status.zzaeX, new zzw(paramOnDriveIdResponse.getDriveId())));
    }
  }
  
  private static class zzb
    extends zzd
  {
    private final zzlx.zzb<DriveFolder.DriveFolderResult> zzakL;
    
    public zzb(zzlx.zzb<DriveFolder.DriveFolderResult> paramzzb)
    {
      this.zzakL = paramzzb;
    }
    
    public void zzA(Status paramStatus)
      throws RemoteException
    {
      this.zzakL.zzr(new zzy.zze(paramStatus, null));
    }
    
    public void zza(OnDriveIdResponse paramOnDriveIdResponse)
      throws RemoteException
    {
      this.zzakL.zzr(new zzy.zze(Status.zzaeX, new zzy(paramOnDriveIdResponse.getDriveId())));
    }
  }
  
  private static class zzc
    implements DriveFolder.DriveFileResult
  {
    private final Status zzTA;
    private final DriveFile zzapn;
    
    public zzc(Status paramStatus, DriveFile paramDriveFile)
    {
      this.zzTA = paramStatus;
      this.zzapn = paramDriveFile;
    }
    
    public DriveFile getDriveFile()
    {
      return this.zzapn;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
  
  static abstract class zzd
    extends zzt<DriveFolder.DriveFileResult>
  {
    zzd(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public DriveFolder.DriveFileResult zzF(Status paramStatus)
    {
      return new zzy.zzc(paramStatus, null);
    }
  }
  
  private static class zze
    implements DriveFolder.DriveFolderResult
  {
    private final Status zzTA;
    private final DriveFolder zzapo;
    
    public zze(Status paramStatus, DriveFolder paramDriveFolder)
    {
      this.zzTA = paramStatus;
      this.zzapo = paramDriveFolder;
    }
    
    public DriveFolder getDriveFolder()
    {
      return this.zzapo;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
  
  static abstract class zzf
    extends zzt<DriveFolder.DriveFolderResult>
  {
    zzf(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public DriveFolder.DriveFolderResult zzG(Status paramStatus)
    {
      return new zzy.zze(paramStatus, null);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */