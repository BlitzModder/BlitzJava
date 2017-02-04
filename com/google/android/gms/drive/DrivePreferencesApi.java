package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public abstract interface DrivePreferencesApi
{
  public abstract PendingResult<FileUploadPreferencesResult> getFileUploadPreferences(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<Status> setFileUploadPreferences(GoogleApiClient paramGoogleApiClient, FileUploadPreferences paramFileUploadPreferences);
  
  public static abstract interface FileUploadPreferencesResult
    extends Result
  {
    public abstract FileUploadPreferences getFileUploadPreferences();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/DrivePreferencesApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */