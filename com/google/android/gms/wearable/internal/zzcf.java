package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmn.zzb;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.LargeAssetApi.zza;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.NodeApi.zza;
import com.google.android.gms.wearable.zza.zza;
import com.google.android.gms.wearable.zzc.zza;
import java.util.List;

final class zzcf<T>
  extends zzba.zza
{
  private zzmn<MessageApi.MessageListener> zzaWe;
  private zzmn<zza.zza> zzboV;
  private zzmn<zzc.zza> zzboW;
  private zzmn<DataApi.DataListener> zzboX;
  private zzmn<NodeApi.NodeListener> zzboY;
  private zzmn<NodeApi.zza> zzboZ;
  private final IntentFilter[] zzbou;
  private zzmn<ChannelApi.ChannelListener> zzbpa;
  private zzmn<LargeAssetApi.zza> zzbpb;
  private zzmn<CapabilityApi.CapabilityListener> zzbpc;
  private final String zzbpd;
  
  private zzcf(IntentFilter[] paramArrayOfIntentFilter, String paramString)
  {
    this.zzbou = ((IntentFilter[])zzx.zzy(paramArrayOfIntentFilter));
    this.zzbpd = paramString;
  }
  
  private static zzmn.zzb<NodeApi.zza> zzF(List<NodeParcelable> paramList)
  {
    new zzmn.zzb()
    {
      public void zza(NodeApi.zza paramAnonymouszza)
      {
        paramAnonymouszza.onConnectedNodes(this.zzbmq);
      }
      
      public void zzpb() {}
    };
  }
  
  public static zzcf<ChannelApi.ChannelListener> zza(zzmn<ChannelApi.ChannelListener> paramzzmn, String paramString, IntentFilter[] paramArrayOfIntentFilter)
  {
    paramString = new zzcf(paramArrayOfIntentFilter, (String)zzx.zzy(paramString));
    paramString.zzbpa = ((zzmn)zzx.zzy(paramzzmn));
    return paramString;
  }
  
  public static zzcf<DataApi.DataListener> zza(zzmn<DataApi.DataListener> paramzzmn, IntentFilter[] paramArrayOfIntentFilter)
  {
    paramArrayOfIntentFilter = new zzcf(paramArrayOfIntentFilter, null);
    paramArrayOfIntentFilter.zzboX = ((zzmn)zzx.zzy(paramzzmn));
    return paramArrayOfIntentFilter;
  }
  
  private static zzmn.zzb<DataApi.DataListener> zzai(DataHolder paramDataHolder)
  {
    new zzmn.zzb()
    {
      public void zza(DataApi.DataListener paramAnonymousDataListener)
      {
        try
        {
          paramAnonymousDataListener.onDataChanged(new DataEventBuffer(this.zzbmj));
          return;
        }
        finally
        {
          this.zzbmj.close();
        }
      }
      
      public void zzpb()
      {
        this.zzbmj.close();
      }
    };
  }
  
  private static zzmn.zzb<zza.zza> zzb(AmsEntityUpdateParcelable paramAmsEntityUpdateParcelable)
  {
    new zzmn.zzb()
    {
      public void zza(zza.zza paramAnonymouszza)
      {
        paramAnonymouszza.zza(this.zzbmt);
      }
      
      public void zzpb() {}
    };
  }
  
  private static zzmn.zzb<zzc.zza> zzb(AncsNotificationParcelable paramAncsNotificationParcelable)
  {
    new zzmn.zzb()
    {
      public void zza(zzc.zza paramAnonymouszza)
      {
        paramAnonymouszza.zza(this.zzbms);
      }
      
      public void zzpb() {}
    };
  }
  
  private static zzmn.zzb<CapabilityApi.CapabilityListener> zzb(CapabilityInfoParcelable paramCapabilityInfoParcelable)
  {
    new zzmn.zzb()
    {
      public void zza(CapabilityApi.CapabilityListener paramAnonymousCapabilityListener)
      {
        paramAnonymousCapabilityListener.onCapabilityChanged(this.zzbpe);
      }
      
      public void zzpb() {}
    };
  }
  
  private static zzmn.zzb<ChannelApi.ChannelListener> zzb(ChannelEventParcelable paramChannelEventParcelable)
  {
    new zzmn.zzb()
    {
      public void zzb(ChannelApi.ChannelListener paramAnonymousChannelListener)
      {
        this.zzbmu.zza(paramAnonymousChannelListener);
      }
      
      public void zzpb() {}
    };
  }
  
  private static zzmn.zzb<LargeAssetApi.zza> zzb(LargeAssetQueueStateChangeParcelable paramLargeAssetQueueStateChangeParcelable)
  {
    new zzmn.zzb()
    {
      public void zza(LargeAssetApi.zza paramAnonymouszza)
      {
        paramAnonymouszza.zza(this.zzbml);
        this.zzbml.release();
      }
      
      public void zzpb()
      {
        this.zzbml.release();
      }
    };
  }
  
  private static zzmn.zzb<MessageApi.MessageListener> zzb(MessageEventParcelable paramMessageEventParcelable)
  {
    new zzmn.zzb()
    {
      public void zza(MessageApi.MessageListener paramAnonymousMessageListener)
      {
        paramAnonymousMessageListener.onMessageReceived(this.zzbmo);
      }
      
      public void zzpb() {}
    };
  }
  
  public static zzcf<MessageApi.MessageListener> zzb(zzmn<MessageApi.MessageListener> paramzzmn, IntentFilter[] paramArrayOfIntentFilter)
  {
    paramArrayOfIntentFilter = new zzcf(paramArrayOfIntentFilter, null);
    paramArrayOfIntentFilter.zzaWe = ((zzmn)zzx.zzy(paramzzmn));
    return paramArrayOfIntentFilter;
  }
  
  private static zzmn.zzb<NodeApi.NodeListener> zzc(NodeParcelable paramNodeParcelable)
  {
    new zzmn.zzb()
    {
      public void zza(NodeApi.NodeListener paramAnonymousNodeListener)
      {
        paramAnonymousNodeListener.onPeerConnected(this.zzbmp);
      }
      
      public void zzpb() {}
    };
  }
  
  public static zzcf<NodeApi.NodeListener> zzc(zzmn<NodeApi.NodeListener> paramzzmn, IntentFilter[] paramArrayOfIntentFilter)
  {
    paramArrayOfIntentFilter = new zzcf(paramArrayOfIntentFilter, null);
    paramArrayOfIntentFilter.zzboY = ((zzmn)zzx.zzy(paramzzmn));
    return paramArrayOfIntentFilter;
  }
  
  private static zzmn.zzb<NodeApi.NodeListener> zzd(NodeParcelable paramNodeParcelable)
  {
    new zzmn.zzb()
    {
      public void zza(NodeApi.NodeListener paramAnonymousNodeListener)
      {
        paramAnonymousNodeListener.onPeerDisconnected(this.zzbmp);
      }
      
      public void zzpb() {}
    };
  }
  
  public static zzcf<ChannelApi.ChannelListener> zzd(zzmn<ChannelApi.ChannelListener> paramzzmn, IntentFilter[] paramArrayOfIntentFilter)
  {
    paramArrayOfIntentFilter = new zzcf(paramArrayOfIntentFilter, null);
    paramArrayOfIntentFilter.zzbpa = ((zzmn)zzx.zzy(paramzzmn));
    return paramArrayOfIntentFilter;
  }
  
  public static zzcf<CapabilityApi.CapabilityListener> zze(zzmn<CapabilityApi.CapabilityListener> paramzzmn, IntentFilter[] paramArrayOfIntentFilter)
  {
    paramArrayOfIntentFilter = new zzcf(paramArrayOfIntentFilter, null);
    paramArrayOfIntentFilter.zzbpc = ((zzmn)zzx.zzy(paramzzmn));
    return paramArrayOfIntentFilter;
  }
  
  private static void zze(zzmn<?> paramzzmn)
  {
    if (paramzzmn != null) {
      paramzzmn.clear();
    }
  }
  
  public void clear()
  {
    zze(this.zzboV);
    this.zzboV = null;
    zze(this.zzboW);
    this.zzboW = null;
    zze(this.zzboX);
    this.zzboX = null;
    zze(this.zzaWe);
    this.zzaWe = null;
    zze(this.zzboY);
    this.zzboY = null;
    zze(this.zzboZ);
    this.zzboZ = null;
    zze(this.zzbpa);
    this.zzbpa = null;
    zze(this.zzbpb);
    this.zzbpb = null;
    zze(this.zzbpc);
    this.zzbpc = null;
  }
  
  public void onConnectedNodes(List<NodeParcelable> paramList)
  {
    if (this.zzboZ != null) {
      this.zzboZ.zza(zzF(paramList));
    }
  }
  
  public IntentFilter[] zzGZ()
  {
    return this.zzbou;
  }
  
  public String zzHa()
  {
    return this.zzbpd;
  }
  
  public void zza(AmsEntityUpdateParcelable paramAmsEntityUpdateParcelable)
  {
    if (this.zzboV != null) {
      this.zzboV.zza(zzb(paramAmsEntityUpdateParcelable));
    }
  }
  
  public void zza(AncsNotificationParcelable paramAncsNotificationParcelable)
  {
    if (this.zzboW != null) {
      this.zzboW.zza(zzb(paramAncsNotificationParcelable));
    }
  }
  
  public void zza(CapabilityInfoParcelable paramCapabilityInfoParcelable)
  {
    if (this.zzbpc != null) {
      this.zzbpc.zza(zzb(paramCapabilityInfoParcelable));
    }
  }
  
  public void zza(ChannelEventParcelable paramChannelEventParcelable)
  {
    if (this.zzbpa != null) {
      this.zzbpa.zza(zzb(paramChannelEventParcelable));
    }
  }
  
  public void zza(LargeAssetQueueStateChangeParcelable paramLargeAssetQueueStateChangeParcelable)
  {
    if (this.zzbpb != null)
    {
      this.zzbpb.zza(zzb(paramLargeAssetQueueStateChangeParcelable));
      return;
    }
    paramLargeAssetQueueStateChangeParcelable.release();
  }
  
  public void zza(LargeAssetSyncRequestPayload paramLargeAssetSyncRequestPayload, zzay paramzzay)
  {
    throw new UnsupportedOperationException("onLargeAssetSyncRequest not supported on live listener");
  }
  
  public void zza(MessageEventParcelable paramMessageEventParcelable)
  {
    if (this.zzaWe != null) {
      this.zzaWe.zza(zzb(paramMessageEventParcelable));
    }
  }
  
  public void zza(NodeParcelable paramNodeParcelable)
  {
    if (this.zzboY != null) {
      this.zzboY.zza(zzc(paramNodeParcelable));
    }
  }
  
  public void zza(zzax paramzzax, String paramString, int paramInt)
  {
    throw new UnsupportedOperationException("openFileDescriptor not supported on live listener");
  }
  
  public void zzag(DataHolder paramDataHolder)
  {
    if (this.zzboX != null)
    {
      this.zzboX.zza(zzai(paramDataHolder));
      return;
    }
    paramDataHolder.close();
  }
  
  public void zzb(NodeParcelable paramNodeParcelable)
  {
    if (this.zzboY != null) {
      this.zzboY.zza(zzd(paramNodeParcelable));
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzcf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */