package com.google.android.gms.wearable;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.AmsEntityUpdateParcelable;
import com.google.android.gms.wearable.internal.AncsNotificationParcelable;
import com.google.android.gms.wearable.internal.CapabilityInfoParcelable;
import com.google.android.gms.wearable.internal.ChannelEventParcelable;
import com.google.android.gms.wearable.internal.LargeAssetQueueStateChangeParcelable;
import com.google.android.gms.wearable.internal.LargeAssetSyncRequestPayload;
import com.google.android.gms.wearable.internal.MessageEventParcelable;
import com.google.android.gms.wearable.internal.NodeParcelable;
import com.google.android.gms.wearable.internal.zzay;
import com.google.android.gms.wearable.internal.zzba.zza;
import com.google.android.gms.wearable.internal.zzbj;
import java.util.List;

public abstract class WearableListenerService
  extends Service
  implements CapabilityApi.CapabilityListener, ChannelApi.ChannelListener, DataApi.DataListener, MessageApi.MessageListener, NodeApi.NodeListener, NodeApi.zza
{
  public static final String BIND_LISTENER_INTENT_ACTION = "com.google.android.gms.wearable.BIND_LISTENER";
  private boolean zzOR;
  private String zzSp;
  private IBinder zzaiT;
  private Handler zzbmg;
  private final Object zzbmh = new Object();
  
  public final IBinder onBind(Intent paramIntent)
  {
    if ("com.google.android.gms.wearable.BIND_LISTENER".equals(paramIntent.getAction())) {
      return this.zzaiT;
    }
    return null;
  }
  
  public void onCapabilityChanged(CapabilityInfo paramCapabilityInfo) {}
  
  public void onChannelClosed(Channel paramChannel, int paramInt1, int paramInt2) {}
  
  public void onChannelOpened(Channel paramChannel) {}
  
  public void onConnectedNodes(List<Node> paramList) {}
  
  public void onCreate()
  {
    super.onCreate();
    if (Log.isLoggable("WearableLS", 3)) {
      Log.d("WearableLS", "onCreate: " + getPackageName());
    }
    this.zzSp = getPackageName();
    HandlerThread localHandlerThread = new HandlerThread("WearableListenerService");
    localHandlerThread.start();
    this.zzbmg = new Handler(localHandlerThread.getLooper());
    this.zzaiT = new zza(null);
  }
  
  public void onDataChanged(DataEventBuffer paramDataEventBuffer) {}
  
  public void onDestroy()
  {
    synchronized (this.zzbmh)
    {
      this.zzOR = true;
      if (this.zzbmg == null) {
        throw new IllegalStateException("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()?");
      }
    }
    this.zzbmg.getLooper().quit();
    super.onDestroy();
  }
  
  public void onInputClosed(Channel paramChannel, int paramInt1, int paramInt2) {}
  
  public void onMessageReceived(MessageEvent paramMessageEvent) {}
  
  public void onOutputClosed(Channel paramChannel, int paramInt1, int paramInt2) {}
  
  public void onPeerConnected(Node paramNode) {}
  
  public void onPeerDisconnected(Node paramNode) {}
  
  private final class zza
    extends zzba.zza
  {
    private volatile int zzaiR = -1;
    
    private zza() {}
    
    private void zzGA()
      throws SecurityException
    {
      int i = Binder.getCallingUid();
      if (i == this.zzaiR) {
        return;
      }
      if (GooglePlayServicesUtil.zze(WearableListenerService.this, i))
      {
        this.zzaiR = i;
        return;
      }
      throw new SecurityException("Caller is not GooglePlayServices");
    }
    
    private boolean zza(Runnable paramRunnable, String paramString, Object paramObject)
    {
      if (!(WearableListenerService.this instanceof zzk)) {
        return false;
      }
      return zzb(paramRunnable, paramString, paramObject);
    }
    
    private boolean zzb(Runnable paramRunnable, String arg2, Object paramObject)
    {
      if (Log.isLoggable("WearableLS", 3)) {
        Log.d("WearableLS", String.format("%s: %s %s", new Object[] { ???, WearableListenerService.zzc(WearableListenerService.this), paramObject }));
      }
      zzGA();
      synchronized (WearableListenerService.zza(WearableListenerService.this))
      {
        if (WearableListenerService.zzb(WearableListenerService.this)) {
          return false;
        }
        WearableListenerService.zzd(WearableListenerService.this).post(paramRunnable);
        return true;
      }
    }
    
    public void onConnectedNodes(final List<NodeParcelable> paramList)
    {
      zzb(new Runnable()
      {
        public void run()
        {
          WearableListenerService.this.onConnectedNodes(paramList);
        }
      }, "onConnectedNodes", paramList);
    }
    
    public void zza(final AmsEntityUpdateParcelable paramAmsEntityUpdateParcelable)
    {
      zza(new Runnable()
      {
        public void run()
        {
          ((zzk)WearableListenerService.this).zza(paramAmsEntityUpdateParcelable);
        }
      }, "onEntityUpdate", paramAmsEntityUpdateParcelable);
    }
    
    public void zza(final AncsNotificationParcelable paramAncsNotificationParcelable)
    {
      zza(new Runnable()
      {
        public void run()
        {
          ((zzk)WearableListenerService.this).zza(paramAncsNotificationParcelable);
        }
      }, "onNotificationReceived", paramAncsNotificationParcelable);
    }
    
    public void zza(final CapabilityInfoParcelable paramCapabilityInfoParcelable)
    {
      zzb(new Runnable()
      {
        public void run()
        {
          WearableListenerService.this.onCapabilityChanged(paramCapabilityInfoParcelable);
        }
      }, "onConnectedCapabilityChanged", paramCapabilityInfoParcelable);
    }
    
    public void zza(final ChannelEventParcelable paramChannelEventParcelable)
    {
      zzb(new Runnable()
      {
        public void run()
        {
          paramChannelEventParcelable.zza(WearableListenerService.this);
        }
      }, "onChannelEvent", paramChannelEventParcelable);
    }
    
    public void zza(final LargeAssetQueueStateChangeParcelable paramLargeAssetQueueStateChangeParcelable)
    {
      Runnable local2 = new Runnable()
      {
        public void run()
        {
          try
          {
            ((zzk)WearableListenerService.this).zza(paramLargeAssetQueueStateChangeParcelable);
            return;
          }
          finally
          {
            paramLargeAssetQueueStateChangeParcelable.release();
          }
        }
      };
      try
      {
        boolean bool = zza(local2, "onLargeAssetStateChanged", paramLargeAssetQueueStateChangeParcelable);
        if (!bool) {}
        return;
      }
      finally
      {
        paramLargeAssetQueueStateChangeParcelable.release();
      }
    }
    
    public void zza(final LargeAssetSyncRequestPayload paramLargeAssetSyncRequestPayload, final zzay paramzzay)
    {
      zza(new Runnable()
      {
        public void run()
        {
          zzbj localzzbj = new zzbj(paramLargeAssetSyncRequestPayload, paramzzay);
          ((zzk)WearableListenerService.this).zza(localzzbj);
          try
          {
            localzzbj.zzGX();
            return;
          }
          catch (RemoteException localRemoteException)
          {
            Log.w("WearableLS", "Failed to respond to LargeAssetRequest", localRemoteException);
          }
        }
      }, "onLargeAssetSyncRequest", paramLargeAssetSyncRequestPayload);
    }
    
    public void zza(final MessageEventParcelable paramMessageEventParcelable)
    {
      zzb(new Runnable()
      {
        public void run()
        {
          WearableListenerService.this.onMessageReceived(paramMessageEventParcelable);
        }
      }, "onMessageReceived", paramMessageEventParcelable);
    }
    
    public void zza(final NodeParcelable paramNodeParcelable)
    {
      zzb(new Runnable()
      {
        public void run()
        {
          WearableListenerService.this.onPeerConnected(paramNodeParcelable);
        }
      }, "onPeerConnected", paramNodeParcelable);
    }
    
    /* Error */
    public void zza(com.google.android.gms.wearable.internal.zzax paramzzax, String paramString, int paramInt)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 7
      //   3: aconst_null
      //   4: astore 6
      //   6: aload_0
      //   7: getfield 37	com/google/android/gms/wearable/WearableListenerService$zza:zzbmi	Lcom/google/android/gms/wearable/WearableListenerService;
      //   10: instanceof 70
      //   13: ifne +4 -> 17
      //   16: return
      //   17: ldc 75
      //   19: iconst_3
      //   20: invokestatic 81	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
      //   23: ifeq +29 -> 52
      //   26: ldc 75
      //   28: ldc -69
      //   30: iconst_2
      //   31: anewarray 85	java/lang/Object
      //   34: dup
      //   35: iconst_0
      //   36: aload_2
      //   37: aastore
      //   38: dup
      //   39: iconst_1
      //   40: iload_3
      //   41: invokestatic 193	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   44: aastore
      //   45: invokestatic 95	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
      //   48: invokestatic 99	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
      //   51: pop
      //   52: aload_0
      //   53: invokespecial 101	com/google/android/gms/wearable/WearableListenerService$zza:zzGA	()V
      //   56: aload_0
      //   57: getfield 37	com/google/android/gms/wearable/WearableListenerService$zza:zzbmi	Lcom/google/android/gms/wearable/WearableListenerService;
      //   60: invokestatic 104	com/google/android/gms/wearable/WearableListenerService:zza	(Lcom/google/android/gms/wearable/WearableListenerService;)Ljava/lang/Object;
      //   63: astore 4
      //   65: aload 4
      //   67: monitorenter
      //   68: aload_0
      //   69: getfield 37	com/google/android/gms/wearable/WearableListenerService$zza:zzbmi	Lcom/google/android/gms/wearable/WearableListenerService;
      //   72: invokestatic 107	com/google/android/gms/wearable/WearableListenerService:zzb	(Lcom/google/android/gms/wearable/WearableListenerService;)Z
      //   75: ifeq +13 -> 88
      //   78: aload 4
      //   80: monitorexit
      //   81: return
      //   82: astore_1
      //   83: aload 4
      //   85: monitorexit
      //   86: aload_1
      //   87: athrow
      //   88: aload 4
      //   90: monitorexit
      //   91: aload 6
      //   93: astore 5
      //   95: aload 7
      //   97: astore 4
      //   99: new 195	java/io/File
      //   102: dup
      //   103: aload_2
      //   104: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
      //   107: invokevirtual 200	java/io/File:getParentFile	()Ljava/io/File;
      //   110: astore 8
      //   112: aload 6
      //   114: astore 5
      //   116: aload 7
      //   118: astore 4
      //   120: aload 8
      //   122: invokevirtual 204	java/io/File:exists	()Z
      //   125: ifne +76 -> 201
      //   128: aload 6
      //   130: astore 5
      //   132: aload 7
      //   134: astore 4
      //   136: aload 8
      //   138: invokevirtual 207	java/io/File:mkdirs	()Z
      //   141: ifne +60 -> 201
      //   144: aload 6
      //   146: astore 5
      //   148: aload 7
      //   150: astore 4
      //   152: ldc 75
      //   154: new 209	java/lang/StringBuilder
      //   157: dup
      //   158: invokespecial 210	java/lang/StringBuilder:<init>	()V
      //   161: ldc -44
      //   163: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   166: aload 8
      //   168: invokevirtual 220	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   171: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   174: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   177: invokestatic 226	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
      //   180: pop
      //   181: aload 6
      //   183: astore 5
      //   185: aload 7
      //   187: astore 4
      //   189: aload_1
      //   190: aconst_null
      //   191: invokeinterface 231 2 0
      //   196: aconst_null
      //   197: invokestatic 235	com/google/android/gms/internal/zznt:zza	(Landroid/os/ParcelFileDescriptor;)V
      //   200: return
      //   201: aload 6
      //   203: astore 5
      //   205: aload 7
      //   207: astore 4
      //   209: new 195	java/io/File
      //   212: dup
      //   213: aload_2
      //   214: invokespecial 196	java/io/File:<init>	(Ljava/lang/String;)V
      //   217: ldc -20
      //   219: iload_3
      //   220: ior
      //   221: invokestatic 242	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
      //   224: astore 8
      //   226: aload 8
      //   228: astore_2
      //   229: aload_2
      //   230: astore 5
      //   232: aload_2
      //   233: astore 4
      //   235: aload_1
      //   236: aload_2
      //   237: invokeinterface 231 2 0
      //   242: aload_2
      //   243: invokestatic 235	com/google/android/gms/internal/zznt:zza	(Landroid/os/ParcelFileDescriptor;)V
      //   246: return
      //   247: astore 8
      //   249: aload 6
      //   251: astore 5
      //   253: aload 7
      //   255: astore 4
      //   257: ldc 75
      //   259: new 209	java/lang/StringBuilder
      //   262: dup
      //   263: invokespecial 210	java/lang/StringBuilder:<init>	()V
      //   266: ldc -12
      //   268: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   271: aload_2
      //   272: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   275: invokevirtual 223	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   278: aload 8
      //   280: invokestatic 247	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   283: pop
      //   284: aload 6
      //   286: astore 5
      //   288: aload 7
      //   290: astore 4
      //   292: aload_1
      //   293: aconst_null
      //   294: invokeinterface 231 2 0
      //   299: aconst_null
      //   300: invokestatic 235	com/google/android/gms/internal/zznt:zza	(Landroid/os/ParcelFileDescriptor;)V
      //   303: return
      //   304: astore_1
      //   305: aload 5
      //   307: astore 4
      //   309: ldc 75
      //   311: ldc -7
      //   313: aload_1
      //   314: invokestatic 247	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   317: pop
      //   318: aload 5
      //   320: invokestatic 235	com/google/android/gms/internal/zznt:zza	(Landroid/os/ParcelFileDescriptor;)V
      //   323: return
      //   324: astore_1
      //   325: aload 4
      //   327: invokestatic 235	com/google/android/gms/internal/zznt:zza	(Landroid/os/ParcelFileDescriptor;)V
      //   330: aload_1
      //   331: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	332	0	this	zza
      //   0	332	1	paramzzax	com.google.android.gms.wearable.internal.zzax
      //   0	332	2	paramString	String
      //   0	332	3	paramInt	int
      //   63	263	4	localObject1	Object
      //   93	226	5	localObject2	Object
      //   4	281	6	localObject3	Object
      //   1	288	7	localObject4	Object
      //   110	117	8	localObject5	Object
      //   247	32	8	localFileNotFoundException	java.io.FileNotFoundException
      // Exception table:
      //   from	to	target	type
      //   68	81	82	finally
      //   83	86	82	finally
      //   88	91	82	finally
      //   209	226	247	java/io/FileNotFoundException
      //   99	112	304	android/os/RemoteException
      //   120	128	304	android/os/RemoteException
      //   136	144	304	android/os/RemoteException
      //   152	181	304	android/os/RemoteException
      //   189	196	304	android/os/RemoteException
      //   209	226	304	android/os/RemoteException
      //   235	242	304	android/os/RemoteException
      //   257	284	304	android/os/RemoteException
      //   292	299	304	android/os/RemoteException
      //   99	112	324	finally
      //   120	128	324	finally
      //   136	144	324	finally
      //   152	181	324	finally
      //   189	196	324	finally
      //   209	226	324	finally
      //   235	242	324	finally
      //   257	284	324	finally
      //   292	299	324	finally
      //   309	318	324	finally
    }
    
    public void zzag(final DataHolder paramDataHolder)
    {
      Runnable local1 = new Runnable()
      {
        public void run()
        {
          DataEventBuffer localDataEventBuffer = new DataEventBuffer(paramDataHolder);
          try
          {
            WearableListenerService.this.onDataChanged(localDataEventBuffer);
            return;
          }
          finally
          {
            localDataEventBuffer.release();
          }
        }
      };
      try
      {
        boolean bool = zzb(local1, "onDataItemChanged", paramDataHolder);
        if (!bool) {}
        return;
      }
      finally
      {
        paramDataHolder.close();
      }
    }
    
    public void zzb(final NodeParcelable paramNodeParcelable)
    {
      zzb(new Runnable()
      {
        public void run()
        {
          WearableListenerService.this.onPeerDisconnected(paramNodeParcelable);
        }
      }, "onPeerDisconnected", paramNodeParcelable);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/WearableListenerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */