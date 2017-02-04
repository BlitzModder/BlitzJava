package com.google.android.gms.wearable.internal;

import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx.zzb;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.FutureTask;

final class zzcd
{
  private static Map<String, CapabilityInfo> zzD(List<CapabilityInfoParcelable> paramList)
  {
    HashMap localHashMap = new HashMap(paramList.size() * 2);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      CapabilityInfoParcelable localCapabilityInfoParcelable = (CapabilityInfoParcelable)paramList.next();
      localHashMap.put(localCapabilityInfoParcelable.getName(), new zzj.zzc(localCapabilityInfoParcelable));
    }
    return localHashMap;
  }
  
  static final class zza
    extends zzcd.zzb<CapabilityApi.AddLocalCapabilityResult>
  {
    public zza(zzlx.zzb<CapabilityApi.AddLocalCapabilityResult> paramzzb)
    {
      super();
    }
    
    public void zza(AddLocalCapabilityResponse paramAddLocalCapabilityResponse)
    {
      zzX(new zzj.zza(zzbz.zzfU(paramAddLocalCapabilityResponse.statusCode)));
    }
  }
  
  static abstract class zzb<T>
    extends zza
  {
    private zzlx.zzb<T> zzTf;
    
    public zzb(zzlx.zzb<T> paramzzb)
    {
      this.zzTf = paramzzb;
    }
    
    public void zzX(T paramT)
    {
      zzlx.zzb localzzb = this.zzTf;
      if (localzzb != null)
      {
        localzzb.zzr(paramT);
        this.zzTf = null;
      }
    }
  }
  
  static final class zzc
    extends zzcd.zzb<Status>
  {
    public zzc(zzlx.zzb<Status> paramzzb)
    {
      super();
    }
    
    public void zza(CloseChannelResponse paramCloseChannelResponse)
    {
      zzX(new Status(paramCloseChannelResponse.statusCode));
    }
  }
  
  static final class zzd
    extends zzcd.zzb<Status>
  {
    public zzd(zzlx.zzb<Status> paramzzb)
    {
      super();
    }
    
    public void zzb(CloseChannelResponse paramCloseChannelResponse)
    {
      zzX(new Status(paramCloseChannelResponse.statusCode));
    }
  }
  
  static final class zze
    extends zzcd.zzb<DataApi.DeleteDataItemsResult>
  {
    public zze(zzlx.zzb<DataApi.DeleteDataItemsResult> paramzzb)
    {
      super();
    }
    
    public void zza(DeleteDataItemsResponse paramDeleteDataItemsResponse)
    {
      zzX(new zzx.zzb(zzbz.zzfU(paramDeleteDataItemsResponse.statusCode), paramDeleteDataItemsResponse.zzbnu));
    }
  }
  
  static final class zzf
    extends zzcd.zzb<CapabilityApi.GetAllCapabilitiesResult>
  {
    public zzf(zzlx.zzb<CapabilityApi.GetAllCapabilitiesResult> paramzzb)
    {
      super();
    }
    
    public void zza(GetAllCapabilitiesResponse paramGetAllCapabilitiesResponse)
    {
      zzX(new zzj.zzd(zzbz.zzfU(paramGetAllCapabilitiesResponse.statusCode), zzcd.zzE(paramGetAllCapabilitiesResponse.zzbnw)));
    }
  }
  
  static final class zzg
    extends zzcd.zzb<CapabilityApi.GetCapabilityResult>
  {
    public zzg(zzlx.zzb<CapabilityApi.GetCapabilityResult> paramzzb)
    {
      super();
    }
    
    public void zza(GetCapabilityResponse paramGetCapabilityResponse)
    {
      zzX(new zzj.zze(zzbz.zzfU(paramGetCapabilityResponse.statusCode), new zzj.zzc(paramGetCapabilityResponse.zzbnx)));
    }
  }
  
  static final class zzh
    extends zzcd.zzb<Channel.GetInputStreamResult>
  {
    private final zzt zzboI;
    
    public zzh(zzlx.zzb<Channel.GetInputStreamResult> paramzzb, zzt paramzzt)
    {
      super();
      this.zzboI = ((zzt)zzx.zzy(paramzzt));
    }
    
    public void zza(GetChannelInputStreamResponse paramGetChannelInputStreamResponse)
    {
      zzp localzzp = null;
      if (paramGetChannelInputStreamResponse.zzbny != null)
      {
        localzzp = new zzp(new ParcelFileDescriptor.AutoCloseInputStream(paramGetChannelInputStreamResponse.zzbny));
        this.zzboI.zza(localzzp.zzGL());
      }
      zzX(new ChannelImpl.zza(new Status(paramGetChannelInputStreamResponse.statusCode), localzzp));
    }
  }
  
  static final class zzi
    extends zzcd.zzb<Channel.GetOutputStreamResult>
  {
    private final zzt zzboI;
    
    public zzi(zzlx.zzb<Channel.GetOutputStreamResult> paramzzb, zzt paramzzt)
    {
      super();
      this.zzboI = ((zzt)zzx.zzy(paramzzt));
    }
    
    public void zza(GetChannelOutputStreamResponse paramGetChannelOutputStreamResponse)
    {
      zzq localzzq = null;
      if (paramGetChannelOutputStreamResponse.zzbny != null)
      {
        localzzq = new zzq(new ParcelFileDescriptor.AutoCloseOutputStream(paramGetChannelOutputStreamResponse.zzbny));
        this.zzboI.zza(localzzq.zzGL());
      }
      zzX(new ChannelImpl.zzb(new Status(paramGetChannelOutputStreamResponse.statusCode), localzzq));
    }
  }
  
  static final class zzj
    extends zzcd.zzb<NodeApi.GetConnectedNodesResult>
  {
    public zzj(zzlx.zzb<NodeApi.GetConnectedNodesResult> paramzzb)
    {
      super();
    }
    
    public void zza(GetConnectedNodesResponse paramGetConnectedNodesResponse)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(paramGetConnectedNodesResponse.zzbnE);
      zzX(new zzbo.zza(zzbz.zzfU(paramGetConnectedNodesResponse.statusCode), localArrayList));
    }
  }
  
  static final class zzk
    extends zzcd.zzb<DataApi.DataItemResult>
  {
    public zzk(zzlx.zzb<DataApi.DataItemResult> paramzzb)
    {
      super();
    }
    
    public void zza(GetDataItemResponse paramGetDataItemResponse)
    {
      zzX(new zzx.zza(zzbz.zzfU(paramGetDataItemResponse.statusCode), paramGetDataItemResponse.zzbnF));
    }
  }
  
  static final class zzl
    extends zzcd.zzb<DataItemBuffer>
  {
    public zzl(zzlx.zzb<DataItemBuffer> paramzzb)
    {
      super();
    }
    
    public void zzah(DataHolder paramDataHolder)
    {
      zzX(new DataItemBuffer(paramDataHolder));
    }
  }
  
  static final class zzm
    extends zzcd.zzb<DataApi.GetFdForAssetResult>
  {
    public zzm(zzlx.zzb<DataApi.GetFdForAssetResult> paramzzb)
    {
      super();
    }
    
    public void zza(GetFdForAssetResponse paramGetFdForAssetResponse)
    {
      zzX(new zzx.zzc(zzbz.zzfU(paramGetFdForAssetResponse.statusCode), paramGetFdForAssetResponse.zzbnG));
    }
  }
  
  static final class zzn
    extends zzcd.zzb<NodeApi.GetLocalNodeResult>
  {
    public zzn(zzlx.zzb<NodeApi.GetLocalNodeResult> paramzzb)
    {
      super();
    }
    
    public void zza(GetLocalNodeResponse paramGetLocalNodeResponse)
    {
      zzX(new zzbo.zzb(zzbz.zzfU(paramGetLocalNodeResponse.statusCode), paramGetLocalNodeResponse.zzbnI));
    }
  }
  
  static final class zzo
    extends zza
  {
    public void zza(Status paramStatus) {}
  }
  
  static final class zzp
    extends zzcd.zzb<ChannelApi.OpenChannelResult>
  {
    public zzp(zzlx.zzb<ChannelApi.OpenChannelResult> paramzzb)
    {
      super();
    }
    
    public void zza(OpenChannelResponse paramOpenChannelResponse)
    {
      zzX(new zzl.zza(zzbz.zzfU(paramOpenChannelResponse.statusCode), paramOpenChannelResponse.zzbmX));
    }
  }
  
  static final class zzq
    extends zzcd.zzb<DataApi.DataItemResult>
  {
    private final List<FutureTask<Boolean>> zzzm;
    
    zzq(zzlx.zzb<DataApi.DataItemResult> paramzzb, List<FutureTask<Boolean>> paramList)
    {
      super();
      this.zzzm = paramList;
    }
    
    public void zza(PutDataResponse paramPutDataResponse)
    {
      zzX(new zzx.zza(zzbz.zzfU(paramPutDataResponse.statusCode), paramPutDataResponse.zzbnF));
      if (paramPutDataResponse.statusCode != 0)
      {
        paramPutDataResponse = this.zzzm.iterator();
        while (paramPutDataResponse.hasNext()) {
          ((FutureTask)paramPutDataResponse.next()).cancel(true);
        }
      }
    }
  }
  
  static final class zzr
    extends zzcd.zzb<Status>
  {
    public zzr(zzlx.zzb<Status> paramzzb)
    {
      super();
    }
    
    public void zza(ChannelSendFileResponse paramChannelSendFileResponse)
    {
      zzX(new Status(paramChannelSendFileResponse.statusCode));
    }
  }
  
  static final class zzs
    extends zzcd.zzb<CapabilityApi.RemoveLocalCapabilityResult>
  {
    public zzs(zzlx.zzb<CapabilityApi.RemoveLocalCapabilityResult> paramzzb)
    {
      super();
    }
    
    public void zza(RemoveLocalCapabilityResponse paramRemoveLocalCapabilityResponse)
    {
      zzX(new zzj.zza(zzbz.zzfU(paramRemoveLocalCapabilityResponse.statusCode)));
    }
  }
  
  static final class zzt
    extends zzcd.zzb<MessageApi.SendMessageResult>
  {
    public zzt(zzlx.zzb<MessageApi.SendMessageResult> paramzzb)
    {
      super();
    }
    
    public void zza(SendMessageResponse paramSendMessageResponse)
    {
      zzX(new zzbm.zzb(zzbz.zzfU(paramSendMessageResponse.statusCode), paramSendMessageResponse.zzaKw));
    }
  }
  
  static final class zzu
    extends zzcd.zzb<Status>
  {
    public zzu(zzlx.zzb<Status> paramzzb)
    {
      super();
    }
    
    public void zza(ChannelReceiveFileResponse paramChannelReceiveFileResponse)
    {
      zzX(new Status(paramChannelReceiveFileResponse.statusCode));
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzcd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */