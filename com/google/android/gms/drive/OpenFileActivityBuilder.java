package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.zzam;
import com.google.android.gms.drive.internal.zzu;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.zzg;

public class OpenFileActivityBuilder
{
  public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
  private String zzank;
  private String[] zzanl;
  private Filter zzanm;
  private DriveId zzann;
  
  public IntentSender build(GoogleApiClient paramGoogleApiClient)
  {
    zzx.zza(paramGoogleApiClient.isConnected(), "Client must be connected");
    if (this.zzanl == null) {
      this.zzanl = new String[0];
    }
    if ((this.zzanl.length > 0) && (this.zzanm != null)) {
      throw new IllegalStateException("Cannot use a selection filter and set mimetypes simultaneously");
    }
    if (this.zzanm == null) {}
    for (FilterHolder localFilterHolder = null;; localFilterHolder = new FilterHolder(this.zzanm)) {
      try
      {
        paramGoogleApiClient = ((zzu)paramGoogleApiClient.zza(Drive.zzTo)).zzsF().zza(new OpenFileIntentSenderRequest(this.zzank, this.zzanl, this.zzann, localFilterHolder));
        return paramGoogleApiClient;
      }
      catch (RemoteException paramGoogleApiClient)
      {
        throw new RuntimeException("Unable to connect Drive Play Service", paramGoogleApiClient);
      }
    }
  }
  
  public OpenFileActivityBuilder setActivityStartFolder(DriveId paramDriveId)
  {
    this.zzann = ((DriveId)zzx.zzy(paramDriveId));
    return this;
  }
  
  public OpenFileActivityBuilder setActivityTitle(String paramString)
  {
    this.zzank = ((String)zzx.zzy(paramString));
    return this;
  }
  
  public OpenFileActivityBuilder setMimeType(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "mimeTypes may not be null");
      this.zzanl = paramArrayOfString;
      return this;
    }
  }
  
  public OpenFileActivityBuilder setSelectionFilter(Filter paramFilter)
  {
    boolean bool2 = true;
    if (paramFilter != null)
    {
      bool1 = true;
      zzx.zzb(bool1, "filter may not be null");
      if (zzg.zza(paramFilter)) {
        break label41;
      }
    }
    label41:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zzx.zzb(bool1, "FullTextSearchFilter cannot be used as a selection filter");
      this.zzanm = paramFilter;
      return this;
      bool1 = false;
      break;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/OpenFileActivityBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */