package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmn.zzb;

public class zzw
  extends zzab
  implements DriveFile
{
  public zzw(DriveId paramDriveId)
  {
    super(paramDriveId);
  }
  
  private static DriveFile.DownloadProgressListener zza(GoogleApiClient paramGoogleApiClient, DriveFile.DownloadProgressListener paramDownloadProgressListener)
  {
    if (paramDownloadProgressListener == null) {
      return null;
    }
    return new zza(paramGoogleApiClient.zzq(paramDownloadProgressListener));
  }
  
  public PendingResult<DriveApi.DriveContentsResult> open(GoogleApiClient paramGoogleApiClient, final int paramInt, DriveFile.DownloadProgressListener paramDownloadProgressListener)
  {
    if ((paramInt != 268435456) && (paramInt != 536870912) && (paramInt != 805306368)) {
      throw new IllegalArgumentException("Invalid mode provided.");
    }
    paramGoogleApiClient.zza(new zzs.zzc(paramGoogleApiClient)
    {
      protected void zza(zzu paramAnonymouszzu)
        throws RemoteException
      {
        zza(paramAnonymouszzu.zzsF().zza(new OpenContentsRequest(zzw.this.getDriveId(), paramInt, 0), new zzbl(this, this.zzapc)).zzsK());
      }
    });
  }
  
  private static class zza
    implements DriveFile.DownloadProgressListener
  {
    private final zzmn<DriveFile.DownloadProgressListener> zzape;
    
    public zza(zzmn<DriveFile.DownloadProgressListener> paramzzmn)
    {
      this.zzape = paramzzmn;
    }
    
    public void onProgress(final long paramLong1, long paramLong2)
    {
      this.zzape.zza(new zzmn.zzb()
      {
        public void zza(DriveFile.DownloadProgressListener paramAnonymousDownloadProgressListener)
        {
          paramAnonymousDownloadProgressListener.onProgress(paramLong1, this.zzapg);
        }
        
        public void zzpb() {}
      });
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */