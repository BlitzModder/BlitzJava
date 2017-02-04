package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.zzap;
import com.google.android.gms.drive.internal.zzap.zza;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zznt;
import com.google.android.gms.internal.zzof;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent
  implements SafeParcelable, ResourceEvent
{
  public static final Parcelable.Creator<CompletionEvent> CREATOR = new zze();
  public static final int STATUS_CANCELED = 3;
  public static final int STATUS_CONFLICT = 2;
  public static final int STATUS_FAILURE = 1;
  public static final int STATUS_SUCCESS = 0;
  final int mVersionCode;
  final int zzAk;
  final String zzTD;
  final DriveId zzamF;
  final ParcelFileDescriptor zzanH;
  final ParcelFileDescriptor zzanI;
  final MetadataBundle zzanJ;
  final List<String> zzanK;
  final IBinder zzanL;
  private boolean zzanM = false;
  private boolean zzanN = false;
  private boolean zzanO = false;
  
  CompletionEvent(int paramInt1, DriveId paramDriveId, String paramString, ParcelFileDescriptor paramParcelFileDescriptor1, ParcelFileDescriptor paramParcelFileDescriptor2, MetadataBundle paramMetadataBundle, List<String> paramList, int paramInt2, IBinder paramIBinder)
  {
    this.mVersionCode = paramInt1;
    this.zzamF = paramDriveId;
    this.zzTD = paramString;
    this.zzanH = paramParcelFileDescriptor1;
    this.zzanI = paramParcelFileDescriptor2;
    this.zzanJ = paramMetadataBundle;
    this.zzanK = paramList;
    this.zzAk = paramInt2;
    this.zzanL = paramIBinder;
  }
  
  private void zzsx()
  {
    if (this.zzanO) {
      throw new IllegalStateException("Event has already been dismissed or snoozed.");
    }
  }
  
  private void zzv(boolean paramBoolean)
  {
    zzsx();
    this.zzanO = true;
    zznt.zza(this.zzanH);
    zznt.zza(this.zzanI);
    if ((this.zzanJ != null) && (this.zzanJ.zzc(zzof.zzart))) {
      ((BitmapTeleporter)this.zzanJ.zza(zzof.zzart)).release();
    }
    if (this.zzanL == null)
    {
      StringBuilder localStringBuilder1 = new StringBuilder().append("No callback on ");
      if (paramBoolean) {}
      for (str = "snooze";; str = "dismiss")
      {
        zzz.zzB("CompletionEvent", str);
        return;
      }
    }
    StringBuilder localStringBuilder2;
    try
    {
      zzap.zza.zzbd(this.zzanL).zzv(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localStringBuilder2 = new StringBuilder().append("RemoteException on ");
      if (!paramBoolean) {}
    }
    for (String str = "snooze";; str = "dismiss")
    {
      zzz.zzB("CompletionEvent", str + ": " + localRemoteException);
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void dismiss()
  {
    zzv(false);
  }
  
  public String getAccountName()
  {
    zzsx();
    return this.zzTD;
  }
  
  public InputStream getBaseContentsInputStream()
  {
    zzsx();
    if (this.zzanH == null) {
      return null;
    }
    if (this.zzanM) {
      throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
    }
    this.zzanM = true;
    return new FileInputStream(this.zzanH.getFileDescriptor());
  }
  
  public DriveId getDriveId()
  {
    zzsx();
    return this.zzamF;
  }
  
  public InputStream getModifiedContentsInputStream()
  {
    zzsx();
    if (this.zzanI == null) {
      return null;
    }
    if (this.zzanN) {
      throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
    }
    this.zzanN = true;
    return new FileInputStream(this.zzanI.getFileDescriptor());
  }
  
  public MetadataChangeSet getModifiedMetadataChangeSet()
  {
    zzsx();
    if (this.zzanJ != null) {
      return new MetadataChangeSet(this.zzanJ);
    }
    return null;
  }
  
  public int getStatus()
  {
    zzsx();
    return this.zzAk;
  }
  
  public List<String> getTrackingTags()
  {
    zzsx();
    return new ArrayList(this.zzanK);
  }
  
  public int getType()
  {
    return 2;
  }
  
  public void snooze()
  {
    zzv(true);
  }
  
  public String toString()
  {
    if (this.zzanK == null) {}
    for (String str = "<null>";; str = "'" + TextUtils.join("','", this.zzanK) + "'") {
      return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", new Object[] { this.zzamF, Integer.valueOf(this.zzAk), str });
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zze.zza(this, paramParcel, paramInt | 0x1);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/events/CompletionEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */