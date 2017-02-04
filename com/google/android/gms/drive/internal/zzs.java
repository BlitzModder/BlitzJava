package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.internal.zzlx.zzb;
import java.util.List;

public class zzs
  implements DriveApi
{
  public PendingResult<Status> cancelPendingActions(GoogleApiClient paramGoogleApiClient, List<String> paramList)
  {
    return ((zzu)paramGoogleApiClient.zza(Drive.zzTo)).cancelPendingActions(paramGoogleApiClient, paramList);
  }
  
  public PendingResult<DriveApi.DriveIdResult> fetchDriveId(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.zza(new zzf(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramAnonymouszzu.zzsF().zza(new GetMetadataRequest(DriveId.zzcQ(paramString), false), new zzs.zzd(this));
      }
    });
  }
  
  public DriveFolder getAppFolder(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient = (zzu)paramGoogleApiClient.zza(Drive.zzTo);
    if (!paramGoogleApiClient.zzsI()) {
      throw new IllegalStateException("Client is not yet connected");
    }
    paramGoogleApiClient = paramGoogleApiClient.zzsH();
    if (paramGoogleApiClient != null) {
      return new zzy(paramGoogleApiClient);
    }
    return null;
  }
  
  public DriveFile getFile(GoogleApiClient paramGoogleApiClient, DriveId paramDriveId)
  {
    if (paramDriveId == null) {
      throw new IllegalArgumentException("Id must be provided.");
    }
    if (!paramGoogleApiClient.isConnected()) {
      throw new IllegalStateException("Client must be connected");
    }
    return new zzw(paramDriveId);
  }
  
  public DriveFolder getFolder(GoogleApiClient paramGoogleApiClient, DriveId paramDriveId)
  {
    if (paramDriveId == null) {
      throw new IllegalArgumentException("Id must be provided.");
    }
    if (!paramGoogleApiClient.isConnected()) {
      throw new IllegalStateException("Client must be connected");
    }
    return new zzy(paramDriveId);
  }
  
  public DriveFolder getRootFolder(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient = (zzu)paramGoogleApiClient.zza(Drive.zzTo);
    if (!paramGoogleApiClient.zzsI()) {
      throw new IllegalStateException("Client is not yet connected");
    }
    paramGoogleApiClient = paramGoogleApiClient.zzsG();
    if (paramGoogleApiClient != null) {
      return new zzy(paramGoogleApiClient);
    }
    return null;
  }
  
  public PendingResult<BooleanResult> isAutobackupEnabled(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zza(new zzt(paramGoogleApiClient)
    {
      protected BooleanResult zzB(Status paramAnonymousStatus)
      {
        return new BooleanResult(paramAnonymousStatus, false);
      }
      
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramAnonymouszzu.zzsF().zze(new zzd()
        {
          public void zzac(boolean paramAnonymous2Boolean)
          {
            jdField_this.zzb(new BooleanResult(Status.zzaeX, paramAnonymous2Boolean));
          }
        });
      }
    });
  }
  
  public CreateFileActivityBuilder newCreateFileActivityBuilder()
  {
    return new CreateFileActivityBuilder();
  }
  
  public PendingResult<DriveApi.DriveContentsResult> newDriveContents(GoogleApiClient paramGoogleApiClient)
  {
    return zza(paramGoogleApiClient, 536870912);
  }
  
  public OpenFileActivityBuilder newOpenFileActivityBuilder()
  {
    return new OpenFileActivityBuilder();
  }
  
  public PendingResult<DriveApi.MetadataBufferResult> query(GoogleApiClient paramGoogleApiClient, final Query paramQuery)
  {
    if (paramQuery == null) {
      throw new IllegalArgumentException("Query must be provided.");
    }
    paramGoogleApiClient.zza(new zzh(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramAnonymouszzu.zzsF().zza(new QueryRequest(paramQuery), new zzs.zzi(this));
      }
    });
  }
  
  public PendingResult<Status> requestSync(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zzb(new zzt.zza(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramAnonymouszzu.zzsF().zza(new zzbt(this));
      }
    });
  }
  
  public PendingResult<DriveApi.DriveContentsResult> zza(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.zza(new zzc(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        paramAnonymouszzu.zzsF().zza(new CreateContentsRequest(paramInt), new zzs.zza(this));
      }
    });
  }
  
  private static class zza
    extends zzd
  {
    private final zzlx.zzb<DriveApi.DriveContentsResult> zzakL;
    
    public zza(zzlx.zzb<DriveApi.DriveContentsResult> paramzzb)
    {
      this.zzakL = paramzzb;
    }
    
    public void zzA(Status paramStatus)
      throws RemoteException
    {
      this.zzakL.zzr(new zzs.zzb(paramStatus, null));
    }
    
    public void zza(OnContentsResponse paramOnContentsResponse)
      throws RemoteException
    {
      this.zzakL.zzr(new zzs.zzb(Status.zzaeX, new zzv(paramOnContentsResponse.zzsO())));
    }
  }
  
  static class zzb
    implements Releasable, DriveApi.DriveContentsResult
  {
    private final Status zzTA;
    private final DriveContents zzamI;
    
    public zzb(Status paramStatus, DriveContents paramDriveContents)
    {
      this.zzTA = paramStatus;
      this.zzamI = paramDriveContents;
    }
    
    public DriveContents getDriveContents()
    {
      return this.zzamI;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
    
    public void release()
    {
      if (this.zzamI != null) {
        this.zzamI.zzsi();
      }
    }
  }
  
  static abstract class zzc
    extends zzt<DriveApi.DriveContentsResult>
  {
    zzc(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public DriveApi.DriveContentsResult zzC(Status paramStatus)
    {
      return new zzs.zzb(paramStatus, null);
    }
  }
  
  static class zzd
    extends zzd
  {
    private final zzlx.zzb<DriveApi.DriveIdResult> zzakL;
    
    public zzd(zzlx.zzb<DriveApi.DriveIdResult> paramzzb)
    {
      this.zzakL = paramzzb;
    }
    
    public void zzA(Status paramStatus)
      throws RemoteException
    {
      this.zzakL.zzr(new zzs.zze(paramStatus, null));
    }
    
    public void zza(OnDriveIdResponse paramOnDriveIdResponse)
      throws RemoteException
    {
      this.zzakL.zzr(new zzs.zze(Status.zzaeX, paramOnDriveIdResponse.getDriveId()));
    }
    
    public void zza(OnMetadataResponse paramOnMetadataResponse)
      throws RemoteException
    {
      this.zzakL.zzr(new zzs.zze(Status.zzaeX, new zzp(paramOnMetadataResponse.zzsX()).getDriveId()));
    }
  }
  
  private static class zze
    implements DriveApi.DriveIdResult
  {
    private final Status zzTA;
    private final DriveId zzamF;
    
    public zze(Status paramStatus, DriveId paramDriveId)
    {
      this.zzTA = paramStatus;
      this.zzamF = paramDriveId;
    }
    
    public DriveId getDriveId()
    {
      return this.zzamF;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
  
  static abstract class zzf
    extends zzt<DriveApi.DriveIdResult>
  {
    zzf(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public DriveApi.DriveIdResult zzD(Status paramStatus)
    {
      return new zzs.zze(paramStatus, null);
    }
  }
  
  static class zzg
    implements DriveApi.MetadataBufferResult
  {
    private final Status zzTA;
    private final MetadataBuffer zzaoF;
    private final boolean zzaoG;
    
    public zzg(Status paramStatus, MetadataBuffer paramMetadataBuffer, boolean paramBoolean)
    {
      this.zzTA = paramStatus;
      this.zzaoF = paramMetadataBuffer;
      this.zzaoG = paramBoolean;
    }
    
    public MetadataBuffer getMetadataBuffer()
    {
      return this.zzaoF;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
    
    public void release()
    {
      if (this.zzaoF != null) {
        this.zzaoF.release();
      }
    }
  }
  
  static abstract class zzh
    extends zzt<DriveApi.MetadataBufferResult>
  {
    zzh(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public DriveApi.MetadataBufferResult zzE(Status paramStatus)
    {
      return new zzs.zzg(paramStatus, null, false);
    }
  }
  
  private static class zzi
    extends zzd
  {
    private final zzlx.zzb<DriveApi.MetadataBufferResult> zzakL;
    
    public zzi(zzlx.zzb<DriveApi.MetadataBufferResult> paramzzb)
    {
      this.zzakL = paramzzb;
    }
    
    public void zzA(Status paramStatus)
      throws RemoteException
    {
      this.zzakL.zzr(new zzs.zzg(paramStatus, null, false));
    }
    
    public void zza(OnListEntriesResponse paramOnListEntriesResponse)
      throws RemoteException
    {
      MetadataBuffer localMetadataBuffer = new MetadataBuffer(paramOnListEntriesResponse.zzsU());
      this.zzakL.zzr(new zzs.zzg(Status.zzaeX, localMetadataBuffer, paramOnListEntriesResponse.zzsV()));
    }
  }
  
  static class zzj
    extends zzt.zza
  {
    zzj(GoogleApiClient paramGoogleApiClient, Status paramStatus)
    {
      super();
      zzb(paramStatus);
    }
    
    protected void zza(zzu paramzzu) {}
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */