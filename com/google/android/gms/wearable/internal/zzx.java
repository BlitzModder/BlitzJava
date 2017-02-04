package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzlx.zzb;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.io.InputStream;

public final class zzx
  implements DataApi
{
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, DataApi.DataListener paramDataListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    return zzb.zza(paramGoogleApiClient, zza(paramArrayOfIntentFilter), paramDataListener);
  }
  
  private static zzb.zza<DataApi.DataListener> zza(IntentFilter[] paramArrayOfIntentFilter)
  {
    new zzb.zza()
    {
      public void zza(zzce paramAnonymouszzce, zzlx.zzb<Status> paramAnonymouszzb, DataApi.DataListener paramAnonymousDataListener, zzmn<DataApi.DataListener> paramAnonymouszzmn)
        throws RemoteException
      {
        paramAnonymouszzce.zza(paramAnonymouszzb, paramAnonymousDataListener, paramAnonymouszzmn, this.zzbmK);
      }
    };
  }
  
  private void zza(Asset paramAsset)
  {
    if (paramAsset == null) {
      throw new IllegalArgumentException("asset is null");
    }
    if (paramAsset.getDigest() == null) {
      throw new IllegalArgumentException("invalid asset");
    }
    if (paramAsset.getData() != null) {
      throw new IllegalArgumentException("invalid asset");
    }
  }
  
  public PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, DataApi.DataListener paramDataListener)
  {
    return zza(paramGoogleApiClient, paramDataListener, new IntentFilter[] { zzcc.zzfY("com.google.android.gms.wearable.DATA_CHANGED") });
  }
  
  public PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, DataApi.DataListener paramDataListener, Uri paramUri, int paramInt)
  {
    if (paramUri != null)
    {
      bool = true;
      com.google.android.gms.common.internal.zzx.zzb(bool, "uri must not be null");
      if ((paramInt != 0) && (paramInt != 1)) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      com.google.android.gms.common.internal.zzx.zzb(bool, "invalid filter type");
      return zza(paramGoogleApiClient, paramDataListener, new IntentFilter[] { zzcc.zza("com.google.android.gms.wearable.DATA_CHANGED", paramUri, paramInt) });
      bool = false;
      break;
    }
  }
  
  public PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    return deleteDataItems(paramGoogleApiClient, paramUri, 0);
  }
  
  public PendingResult<DataApi.DeleteDataItemsResult> deleteDataItems(GoogleApiClient paramGoogleApiClient, final Uri paramUri, final int paramInt)
  {
    boolean bool2 = false;
    if (paramUri != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      com.google.android.gms.common.internal.zzx.zzb(bool1, "uri must not be null");
      if (paramInt != 0)
      {
        bool1 = bool2;
        if (paramInt != 1) {}
      }
      else
      {
        bool1 = true;
      }
      com.google.android.gms.common.internal.zzx.zzb(bool1, "invalid filter type");
      paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
      {
        protected void zza(zzce paramAnonymouszzce)
          throws RemoteException
        {
          paramAnonymouszzce.zzb(this, paramUri, paramInt);
        }
        
        protected DataApi.DeleteDataItemsResult zzbt(Status paramAnonymousStatus)
        {
          return new zzx.zzb(paramAnonymousStatus, 0);
        }
      });
    }
  }
  
  public PendingResult<DataApi.DataItemResult> getDataItem(GoogleApiClient paramGoogleApiClient, final Uri paramUri)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzce paramAnonymouszzce)
        throws RemoteException
      {
        paramAnonymouszzce.zza(this, paramUri);
      }
      
      protected DataApi.DataItemResult zzbr(Status paramAnonymousStatus)
      {
        return new zzx.zza(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzce paramAnonymouszzce)
        throws RemoteException
      {
        paramAnonymouszzce.zzo(this);
      }
      
      protected DataItemBuffer zzbs(Status paramAnonymousStatus)
      {
        return new DataItemBuffer(DataHolder.zzbJ(paramAnonymousStatus.getStatusCode()));
      }
    });
  }
  
  public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    return getDataItems(paramGoogleApiClient, paramUri, 0);
  }
  
  public PendingResult<DataItemBuffer> getDataItems(GoogleApiClient paramGoogleApiClient, final Uri paramUri, final int paramInt)
  {
    boolean bool2 = false;
    if (paramUri != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      com.google.android.gms.common.internal.zzx.zzb(bool1, "uri must not be null");
      if (paramInt != 0)
      {
        bool1 = bool2;
        if (paramInt != 1) {}
      }
      else
      {
        bool1 = true;
      }
      com.google.android.gms.common.internal.zzx.zzb(bool1, "invalid filter type");
      paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
      {
        protected void zza(zzce paramAnonymouszzce)
          throws RemoteException
        {
          paramAnonymouszzce.zza(this, paramUri, paramInt);
        }
        
        protected DataItemBuffer zzbs(Status paramAnonymousStatus)
        {
          return new DataItemBuffer(DataHolder.zzbJ(paramAnonymousStatus.getStatusCode()));
        }
      });
    }
  }
  
  public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient paramGoogleApiClient, final Asset paramAsset)
  {
    zza(paramAsset);
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzce paramAnonymouszzce)
        throws RemoteException
      {
        paramAnonymouszzce.zza(this, paramAsset);
      }
      
      protected DataApi.GetFdForAssetResult zzbu(Status paramAnonymousStatus)
      {
        return new zzx.zzc(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<DataApi.GetFdForAssetResult> getFdForAsset(GoogleApiClient paramGoogleApiClient, final DataItemAsset paramDataItemAsset)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzce paramAnonymouszzce)
        throws RemoteException
      {
        paramAnonymouszzce.zza(this, paramDataItemAsset);
      }
      
      protected DataApi.GetFdForAssetResult zzbu(Status paramAnonymousStatus)
      {
        return new zzx.zzc(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<DataApi.DataItemResult> putDataItem(GoogleApiClient paramGoogleApiClient, final PutDataRequest paramPutDataRequest)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzce paramAnonymouszzce)
        throws RemoteException
      {
        paramAnonymouszzce.zza(this, paramPutDataRequest);
      }
      
      public DataApi.DataItemResult zzbr(Status paramAnonymousStatus)
      {
        return new zzx.zza(paramAnonymousStatus, null);
      }
    });
  }
  
  public PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, final DataApi.DataListener paramDataListener)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzce paramAnonymouszzce)
        throws RemoteException
      {
        paramAnonymouszzce.zza(this, paramDataListener);
      }
      
      public Status zzb(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public static class zza
    implements DataApi.DataItemResult
  {
    private final Status zzTA;
    private final DataItem zzbnq;
    
    public zza(Status paramStatus, DataItem paramDataItem)
    {
      this.zzTA = paramStatus;
      this.zzbnq = paramDataItem;
    }
    
    public DataItem getDataItem()
    {
      return this.zzbnq;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
  
  public static class zzb
    implements DataApi.DeleteDataItemsResult
  {
    private final Status zzTA;
    private final int zzbnr;
    
    public zzb(Status paramStatus, int paramInt)
    {
      this.zzTA = paramStatus;
      this.zzbnr = paramInt;
    }
    
    public int getNumDeleted()
    {
      return this.zzbnr;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
  
  public static class zzc
    implements DataApi.GetFdForAssetResult
  {
    private volatile boolean mClosed = false;
    private final Status zzTA;
    private volatile InputStream zzbnc;
    private volatile ParcelFileDescriptor zzbns;
    
    public zzc(Status paramStatus, ParcelFileDescriptor paramParcelFileDescriptor)
    {
      this.zzTA = paramStatus;
      this.zzbns = paramParcelFileDescriptor;
    }
    
    public ParcelFileDescriptor getFd()
    {
      if (this.mClosed) {
        throw new IllegalStateException("Cannot access the file descriptor after release().");
      }
      return this.zzbns;
    }
    
    public InputStream getInputStream()
    {
      if (this.mClosed) {
        throw new IllegalStateException("Cannot access the input stream after release().");
      }
      if (this.zzbns == null) {
        return null;
      }
      if (this.zzbnc == null) {
        this.zzbnc = new ParcelFileDescriptor.AutoCloseInputStream(this.zzbns);
      }
      return this.zzbnc;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
    
    public void release()
    {
      if (this.zzbns == null) {
        return;
      }
      if (this.mClosed) {
        throw new IllegalStateException("releasing an already released result.");
      }
      try
      {
        if (this.zzbnc != null) {
          this.zzbnc.close();
        }
        for (;;)
        {
          this.mClosed = true;
          this.zzbns = null;
          this.zzbnc = null;
          return;
          this.zzbns.close();
        }
        return;
      }
      catch (IOException localIOException) {}
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */