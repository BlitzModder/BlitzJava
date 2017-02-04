package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx.zzb;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ChannelImpl
  implements SafeParcelable, Channel
{
  public static final Parcelable.Creator<ChannelImpl> CREATOR = new zzo();
  private final String mPath;
  final int mVersionCode;
  private final String zzTR;
  private final String zzblS;
  
  ChannelImpl(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.mVersionCode = paramInt;
    this.zzTR = ((String)zzx.zzy(paramString1));
    this.zzblS = ((String)zzx.zzy(paramString2));
    this.mPath = ((String)zzx.zzy(paramString3));
  }
  
  private static zzb.zza<ChannelApi.ChannelListener> zza(String paramString, final IntentFilter[] paramArrayOfIntentFilter)
  {
    new zzb.zza()
    {
      public void zza(zzce paramAnonymouszzce, zzlx.zzb<Status> paramAnonymouszzb, ChannelApi.ChannelListener paramAnonymousChannelListener, zzmn<ChannelApi.ChannelListener> paramAnonymouszzmn)
        throws RemoteException
      {
        paramAnonymouszzce.zza(paramAnonymouszzb, paramAnonymousChannelListener, paramAnonymouszzmn, this.zzTM, paramArrayOfIntentFilter);
      }
    };
  }
  
  public PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener)
  {
    IntentFilter localIntentFilter = zzcc.zzfY("com.google.android.gms.wearable.CHANNEL_EVENT");
    return zzb.zza(paramGoogleApiClient, zza(this.zzTR, new IntentFilter[] { localIntentFilter }), paramChannelListener);
  }
  
  public PendingResult<Status> close(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzce paramAnonymouszzce)
        throws RemoteException
      {
        paramAnonymouszzce.zzt(this, ChannelImpl.zza(ChannelImpl.this));
      }
      
      protected Status zzb(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public PendingResult<Status> close(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzce paramAnonymouszzce)
        throws RemoteException
      {
        paramAnonymouszzce.zzh(this, ChannelImpl.zza(ChannelImpl.this), paramInt);
      }
      
      protected Status zzb(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof ChannelImpl)) {
        return false;
      }
      paramObject = (ChannelImpl)paramObject;
    } while ((this.zzTR.equals(((ChannelImpl)paramObject).zzTR)) && (zzw.equal(((ChannelImpl)paramObject).zzblS, this.zzblS)) && (zzw.equal(((ChannelImpl)paramObject).mPath, this.mPath)) && (((ChannelImpl)paramObject).mVersionCode == this.mVersionCode));
    return false;
  }
  
  public PendingResult<Channel.GetInputStreamResult> getInputStream(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzce paramAnonymouszzce)
        throws RemoteException
      {
        paramAnonymouszzce.zzu(this, ChannelImpl.zza(ChannelImpl.this));
      }
      
      public Channel.GetInputStreamResult zzbp(Status paramAnonymousStatus)
      {
        return new ChannelImpl.zza(paramAnonymousStatus, null);
      }
    });
  }
  
  public String getNodeId()
  {
    return this.zzblS;
  }
  
  public PendingResult<Channel.GetOutputStreamResult> getOutputStream(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzce paramAnonymouszzce)
        throws RemoteException
      {
        paramAnonymouszzce.zzv(this, ChannelImpl.zza(ChannelImpl.this));
      }
      
      public Channel.GetOutputStreamResult zzbq(Status paramAnonymousStatus)
      {
        return new ChannelImpl.zzb(paramAnonymousStatus, null);
      }
    });
  }
  
  public String getPath()
  {
    return this.mPath;
  }
  
  public String getToken()
  {
    return this.zzTR;
  }
  
  public int hashCode()
  {
    return this.zzTR.hashCode();
  }
  
  public PendingResult<Status> receiveFile(GoogleApiClient paramGoogleApiClient, final Uri paramUri, final boolean paramBoolean)
  {
    zzx.zzb(paramGoogleApiClient, "client is null");
    zzx.zzb(paramUri, "uri is null");
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzce paramAnonymouszzce)
        throws RemoteException
      {
        paramAnonymouszzce.zza(this, ChannelImpl.zza(ChannelImpl.this), paramUri, paramBoolean);
      }
      
      public Status zzb(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, ChannelApi.ChannelListener paramChannelListener)
  {
    zzx.zzb(paramGoogleApiClient, "client is null");
    zzx.zzb(paramChannelListener, "listener is null");
    return paramGoogleApiClient.zza(new zzl.zzb(paramGoogleApiClient, paramChannelListener, this.zzTR));
  }
  
  public PendingResult<Status> sendFile(GoogleApiClient paramGoogleApiClient, Uri paramUri)
  {
    return sendFile(paramGoogleApiClient, paramUri, 0L, -1L);
  }
  
  public PendingResult<Status> sendFile(GoogleApiClient paramGoogleApiClient, final Uri paramUri, final long paramLong1, long paramLong2)
  {
    zzx.zzb(paramGoogleApiClient, "client is null");
    zzx.zzb(this.zzTR, "token is null");
    zzx.zzb(paramUri, "uri is null");
    if (paramLong1 >= 0L)
    {
      bool = true;
      zzx.zzb(bool, "startOffset is negative: %s", new Object[] { Long.valueOf(paramLong1) });
      if ((paramLong2 < 0L) && (paramLong2 != -1L)) {
        break label113;
      }
    }
    label113:
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "invalid length: %s", new Object[] { Long.valueOf(paramLong2) });
      paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
      {
        protected void zza(zzce paramAnonymouszzce)
          throws RemoteException
        {
          paramAnonymouszzce.zza(this, ChannelImpl.zza(ChannelImpl.this), paramUri, paramLong1, this.zzbnb);
        }
        
        public Status zzb(Status paramAnonymousStatus)
        {
          return paramAnonymousStatus;
        }
      });
      bool = false;
      break;
    }
  }
  
  public String toString()
  {
    return "ChannelImpl{versionCode=" + this.mVersionCode + ", token='" + this.zzTR + '\'' + ", nodeId='" + this.zzblS + '\'' + ", path='" + this.mPath + '\'' + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo.zza(this, paramParcel, paramInt);
  }
  
  static final class zza
    implements Channel.GetInputStreamResult
  {
    private final Status zzTA;
    private final InputStream zzbnc;
    
    zza(Status paramStatus, InputStream paramInputStream)
    {
      this.zzTA = ((Status)zzx.zzy(paramStatus));
      this.zzbnc = paramInputStream;
    }
    
    public InputStream getInputStream()
    {
      return this.zzbnc;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
    
    public void release()
    {
      if (this.zzbnc != null) {}
      try
      {
        this.zzbnc.close();
        return;
      }
      catch (IOException localIOException) {}
    }
  }
  
  static final class zzb
    implements Channel.GetOutputStreamResult
  {
    private final Status zzTA;
    private final OutputStream zzbnd;
    
    zzb(Status paramStatus, OutputStream paramOutputStream)
    {
      this.zzTA = ((Status)zzx.zzy(paramStatus));
      this.zzbnd = paramOutputStream;
    }
    
    public OutputStream getOutputStream()
    {
      return this.zzbnd;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
    
    public void release()
    {
      if (this.zzbnd != null) {}
      try
      {
        this.zzbnd.close();
        return;
      }
      catch (IOException localIOException) {}
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/ChannelImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */