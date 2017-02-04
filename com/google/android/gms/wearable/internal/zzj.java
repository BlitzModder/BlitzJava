package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx.zzb;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.wearable.CapabilityApi;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import java.util.Map;
import java.util.Set;

public class zzj
  implements CapabilityApi
{
  private PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    return zzb.zza(paramGoogleApiClient, zza(paramArrayOfIntentFilter), paramCapabilityListener);
  }
  
  private static zzb.zza<CapabilityApi.CapabilityListener> zza(IntentFilter[] paramArrayOfIntentFilter)
  {
    new zzb.zza()
    {
      public void zza(zzce paramAnonymouszzce, zzlx.zzb<Status> paramAnonymouszzb, CapabilityApi.CapabilityListener paramAnonymousCapabilityListener, zzmn<CapabilityApi.CapabilityListener> paramAnonymouszzmn)
        throws RemoteException
      {
        paramAnonymouszzce.zza(paramAnonymouszzb, paramAnonymousCapabilityListener, paramAnonymouszzmn, this.zzbmK);
      }
    };
  }
  
  public PendingResult<Status> addCapabilityListener(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener, String paramString)
  {
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "capability must not be null");
      zzb localzzb = new zzb(paramCapabilityListener, paramString);
      IntentFilter localIntentFilter = zzcc.zzfY("com.google.android.gms.wearable.CAPABILITY_CHANGED");
      paramCapabilityListener = paramString;
      if (!paramString.startsWith("/")) {
        paramCapabilityListener = "/" + paramString;
      }
      localIntentFilter.addDataPath(paramCapabilityListener, 0);
      return zza(paramGoogleApiClient, localzzb, new IntentFilter[] { localIntentFilter });
    }
  }
  
  public PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener, Uri paramUri, int paramInt)
  {
    if (paramUri != null)
    {
      bool = true;
      zzx.zzb(bool, "uri must not be null");
      if ((paramInt != 0) && (paramInt != 1)) {
        break label63;
      }
    }
    label63:
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "invalid filter type");
      return zza(paramGoogleApiClient, paramCapabilityListener, new IntentFilter[] { zzcc.zza("com.google.android.gms.wearable.CAPABILITY_CHANGED", paramUri, paramInt) });
      bool = false;
      break;
    }
  }
  
  public PendingResult<CapabilityApi.AddLocalCapabilityResult> addLocalCapability(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzce paramAnonymouszzce)
        throws RemoteException
      {
        paramAnonymouszzce.zzr(this, paramString);
      }
      
      protected CapabilityApi.AddLocalCapabilityResult zzbm(Status paramAnonymousStatus)
      {
        return new zzj.zza(paramAnonymousStatus);
      }
    });
  }
  
  public PendingResult<CapabilityApi.GetAllCapabilitiesResult> getAllCapabilities(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 0) {
      if (paramInt != 1) {
        break label37;
      }
    }
    label37:
    for (bool1 = bool2;; bool1 = false)
    {
      zzx.zzab(bool1);
      paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
      {
        protected void zza(zzce paramAnonymouszzce)
          throws RemoteException
        {
          paramAnonymouszzce.zzb(this, paramInt);
        }
        
        protected CapabilityApi.GetAllCapabilitiesResult zzbl(Status paramAnonymousStatus)
        {
          return new zzj.zzd(paramAnonymousStatus, null);
        }
      });
    }
  }
  
  public PendingResult<CapabilityApi.GetCapabilityResult> getCapability(GoogleApiClient paramGoogleApiClient, final String paramString, final int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 0) {
      if (paramInt != 1) {
        break label41;
      }
    }
    label41:
    for (bool1 = bool2;; bool1 = false)
    {
      zzx.zzab(bool1);
      paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
      {
        protected void zza(zzce paramAnonymouszzce)
          throws RemoteException
        {
          paramAnonymouszzce.zzg(this, paramString, paramInt);
        }
        
        protected CapabilityApi.GetCapabilityResult zzbk(Status paramAnonymousStatus)
        {
          return new zzj.zze(paramAnonymousStatus, null);
        }
      });
    }
  }
  
  public PendingResult<Status> removeCapabilityListener(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener, String paramString)
  {
    return paramGoogleApiClient.zza(new zzf(paramGoogleApiClient, new zzb(paramCapabilityListener, paramString), null));
  }
  
  public PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener)
  {
    return paramGoogleApiClient.zza(new zzf(paramGoogleApiClient, paramCapabilityListener, null));
  }
  
  public PendingResult<CapabilityApi.RemoveLocalCapabilityResult> removeLocalCapability(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.zza(new zzi(paramGoogleApiClient)
    {
      protected void zza(zzce paramAnonymouszzce)
        throws RemoteException
      {
        paramAnonymouszzce.zzs(this, paramString);
      }
      
      protected CapabilityApi.RemoveLocalCapabilityResult zzbn(Status paramAnonymousStatus)
      {
        return new zzj.zza(paramAnonymousStatus);
      }
    });
  }
  
  public static class zza
    implements CapabilityApi.AddLocalCapabilityResult, CapabilityApi.RemoveLocalCapabilityResult
  {
    private final Status zzTA;
    
    public zza(Status paramStatus)
    {
      this.zzTA = paramStatus;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
  
  private static class zzb
    implements CapabilityApi.CapabilityListener
  {
    final CapabilityApi.CapabilityListener zzbmL;
    final String zzbmM;
    
    zzb(CapabilityApi.CapabilityListener paramCapabilityListener, String paramString)
    {
      this.zzbmL = paramCapabilityListener;
      this.zzbmM = paramString;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1;
      if (this == paramObject) {
        bool1 = true;
      }
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (paramObject == null);
          bool1 = bool2;
        } while (getClass() != paramObject.getClass());
        paramObject = (zzb)paramObject;
        bool1 = bool2;
      } while (!this.zzbmL.equals(((zzb)paramObject).zzbmL));
      return this.zzbmM.equals(((zzb)paramObject).zzbmM);
    }
    
    public int hashCode()
    {
      return this.zzbmL.hashCode() * 31 + this.zzbmM.hashCode();
    }
    
    public void onCapabilityChanged(CapabilityInfo paramCapabilityInfo)
    {
      this.zzbmL.onCapabilityChanged(paramCapabilityInfo);
    }
  }
  
  public static class zzc
    implements CapabilityInfo
  {
    private final String mName;
    private final Set<Node> zzbmN;
    
    public zzc(CapabilityInfo paramCapabilityInfo)
    {
      this(paramCapabilityInfo.getName(), paramCapabilityInfo.getNodes());
    }
    
    public zzc(String paramString, Set<Node> paramSet)
    {
      this.mName = paramString;
      this.zzbmN = paramSet;
    }
    
    public String getName()
    {
      return this.mName;
    }
    
    public Set<Node> getNodes()
    {
      return this.zzbmN;
    }
  }
  
  public static class zzd
    implements CapabilityApi.GetAllCapabilitiesResult
  {
    private final Status zzTA;
    private final Map<String, CapabilityInfo> zzbmO;
    
    public zzd(Status paramStatus, Map<String, CapabilityInfo> paramMap)
    {
      this.zzTA = paramStatus;
      this.zzbmO = paramMap;
    }
    
    public Map<String, CapabilityInfo> getAllCapabilities()
    {
      return this.zzbmO;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
  
  public static class zze
    implements CapabilityApi.GetCapabilityResult
  {
    private final Status zzTA;
    private final CapabilityInfo zzbmP;
    
    public zze(Status paramStatus, CapabilityInfo paramCapabilityInfo)
    {
      this.zzTA = paramStatus;
      this.zzbmP = paramCapabilityInfo;
    }
    
    public CapabilityInfo getCapability()
    {
      return this.zzbmP;
    }
    
    public Status getStatus()
    {
      return this.zzTA;
    }
  }
  
  private static final class zzf
    extends zzi<Status>
  {
    private CapabilityApi.CapabilityListener zzbmL;
    
    private zzf(GoogleApiClient paramGoogleApiClient, CapabilityApi.CapabilityListener paramCapabilityListener)
    {
      super();
      this.zzbmL = paramCapabilityListener;
    }
    
    protected void zza(zzce paramzzce)
      throws RemoteException
    {
      paramzzce.zza(this, this.zzbmL);
      this.zzbmL = null;
    }
    
    public Status zzb(Status paramStatus)
    {
      this.zzbmL = null;
      return paramStatus;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */