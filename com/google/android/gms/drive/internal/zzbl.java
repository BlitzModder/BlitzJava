package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.internal.zzlx.zzb;

class zzbl
  extends zzd
{
  private final zzlx.zzb<DriveApi.DriveContentsResult> zzakL;
  private final DriveFile.DownloadProgressListener zzaqu;
  
  zzbl(zzlx.zzb<DriveApi.DriveContentsResult> paramzzb, DriveFile.DownloadProgressListener paramDownloadProgressListener)
  {
    this.zzakL = paramzzb;
    this.zzaqu = paramDownloadProgressListener;
  }
  
  public void zzA(Status paramStatus)
    throws RemoteException
  {
    this.zzakL.zzr(new zzs.zzb(paramStatus, null));
  }
  
  public void zza(OnContentsResponse paramOnContentsResponse)
    throws RemoteException
  {
    if (paramOnContentsResponse.zzsP()) {}
    for (Status localStatus = new Status(-1);; localStatus = Status.zzaeX)
    {
      this.zzakL.zzr(new zzs.zzb(localStatus, new zzv(paramOnContentsResponse.zzsO())));
      return;
    }
  }
  
  public void zza(OnDownloadProgressResponse paramOnDownloadProgressResponse)
    throws RemoteException
  {
    if (this.zzaqu != null) {
      this.zzaqu.onProgress(paramOnDownloadProgressResponse.zzsR(), paramOnDownloadProgressResponse.zzsS());
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/internal/zzbl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */