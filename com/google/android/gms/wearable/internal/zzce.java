package com.google.android.gms.wearable.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlx.zzb;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.CapabilityApi.AddLocalCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.google.android.gms.wearable.CapabilityApi.GetAllCapabilitiesResult;
import com.google.android.gms.wearable.CapabilityApi.GetCapabilityResult;
import com.google.android.gms.wearable.CapabilityApi.RemoveLocalCapabilityResult;
import com.google.android.gms.wearable.Channel.GetInputStreamResult;
import com.google.android.gms.wearable.Channel.GetOutputStreamResult;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.LargeAssetApi.zza;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.NodeApi.zza;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.zza.zza;
import com.google.android.gms.wearable.zzc.zza;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class zzce
  extends zzj<zzbb>
{
  private final ExecutorService zzbfg = Executors.newCachedThreadPool();
  private final zzbl<zzc.zza> zzboJ = new zzbl();
  private final zzbl<zza.zza> zzboK = new zzbl();
  private final zzbl<ChannelApi.ChannelListener> zzboL = new zzbl();
  private final zzbl<LargeAssetApi.zza> zzboM = new zzbl();
  private final zzbl<DataApi.DataListener> zzboN = new zzbl();
  private final zzbl<MessageApi.MessageListener> zzboO = new zzbl();
  private final zzbl<NodeApi.NodeListener> zzboP = new zzbl();
  private final zzbl<NodeApi.zza> zzboQ = new zzbl();
  private final zzbl<CapabilityApi.CapabilityListener> zzboR = new zzbl();
  
  public zzce(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, zzf paramzzf)
  {
    super(paramContext, paramLooper, 14, paramzzf, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  private FutureTask<Boolean> zza(final ParcelFileDescriptor paramParcelFileDescriptor, final byte[] paramArrayOfByte)
  {
    new FutureTask(new Callable()
    {
      /* Error */
      public Boolean zzGY()
      {
        // Byte code:
        //   0: ldc 43
        //   2: iconst_3
        //   3: invokestatic 49	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
        //   6: ifeq +31 -> 37
        //   9: ldc 43
        //   11: new 51	java/lang/StringBuilder
        //   14: dup
        //   15: invokespecial 52	java/lang/StringBuilder:<init>	()V
        //   18: ldc 54
        //   20: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   23: aload_0
        //   24: getfield 24	com/google/android/gms/wearable/internal/zzce$1:zzboS	Landroid/os/ParcelFileDescriptor;
        //   27: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   30: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   33: invokestatic 69	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   36: pop
        //   37: new 71	android/os/ParcelFileDescriptor$AutoCloseOutputStream
        //   40: dup
        //   41: aload_0
        //   42: getfield 24	com/google/android/gms/wearable/internal/zzce$1:zzboS	Landroid/os/ParcelFileDescriptor;
        //   45: invokespecial 74	android/os/ParcelFileDescriptor$AutoCloseOutputStream:<init>	(Landroid/os/ParcelFileDescriptor;)V
        //   48: astore_1
        //   49: aload_1
        //   50: aload_0
        //   51: getfield 26	com/google/android/gms/wearable/internal/zzce$1:zzboq	[B
        //   54: invokevirtual 78	android/os/ParcelFileDescriptor$AutoCloseOutputStream:write	([B)V
        //   57: aload_1
        //   58: invokevirtual 81	android/os/ParcelFileDescriptor$AutoCloseOutputStream:flush	()V
        //   61: ldc 43
        //   63: iconst_3
        //   64: invokestatic 49	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
        //   67: ifeq +31 -> 98
        //   70: ldc 43
        //   72: new 51	java/lang/StringBuilder
        //   75: dup
        //   76: invokespecial 52	java/lang/StringBuilder:<init>	()V
        //   79: ldc 83
        //   81: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   84: aload_0
        //   85: getfield 24	com/google/android/gms/wearable/internal/zzce$1:zzboS	Landroid/os/ParcelFileDescriptor;
        //   88: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   91: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   94: invokestatic 69	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   97: pop
        //   98: iconst_1
        //   99: invokestatic 89	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   102: astore_2
        //   103: ldc 43
        //   105: iconst_3
        //   106: invokestatic 49	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
        //   109: ifeq +31 -> 140
        //   112: ldc 43
        //   114: new 51	java/lang/StringBuilder
        //   117: dup
        //   118: invokespecial 52	java/lang/StringBuilder:<init>	()V
        //   121: ldc 91
        //   123: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   126: aload_0
        //   127: getfield 24	com/google/android/gms/wearable/internal/zzce$1:zzboS	Landroid/os/ParcelFileDescriptor;
        //   130: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   133: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   136: invokestatic 69	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   139: pop
        //   140: aload_1
        //   141: invokevirtual 94	android/os/ParcelFileDescriptor$AutoCloseOutputStream:close	()V
        //   144: aload_2
        //   145: areturn
        //   146: astore_2
        //   147: ldc 43
        //   149: new 51	java/lang/StringBuilder
        //   152: dup
        //   153: invokespecial 52	java/lang/StringBuilder:<init>	()V
        //   156: ldc 96
        //   158: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   161: aload_0
        //   162: getfield 24	com/google/android/gms/wearable/internal/zzce$1:zzboS	Landroid/os/ParcelFileDescriptor;
        //   165: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   168: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   171: invokestatic 99	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
        //   174: pop
        //   175: ldc 43
        //   177: iconst_3
        //   178: invokestatic 49	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
        //   181: ifeq +31 -> 212
        //   184: ldc 43
        //   186: new 51	java/lang/StringBuilder
        //   189: dup
        //   190: invokespecial 52	java/lang/StringBuilder:<init>	()V
        //   193: ldc 91
        //   195: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   198: aload_0
        //   199: getfield 24	com/google/android/gms/wearable/internal/zzce$1:zzboS	Landroid/os/ParcelFileDescriptor;
        //   202: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   205: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   208: invokestatic 69	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   211: pop
        //   212: aload_1
        //   213: invokevirtual 94	android/os/ParcelFileDescriptor$AutoCloseOutputStream:close	()V
        //   216: iconst_0
        //   217: invokestatic 89	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   220: areturn
        //   221: astore_2
        //   222: ldc 43
        //   224: iconst_3
        //   225: invokestatic 49	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
        //   228: ifeq +31 -> 259
        //   231: ldc 43
        //   233: new 51	java/lang/StringBuilder
        //   236: dup
        //   237: invokespecial 52	java/lang/StringBuilder:<init>	()V
        //   240: ldc 91
        //   242: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   245: aload_0
        //   246: getfield 24	com/google/android/gms/wearable/internal/zzce$1:zzboS	Landroid/os/ParcelFileDescriptor;
        //   249: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   252: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   255: invokestatic 69	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
        //   258: pop
        //   259: aload_1
        //   260: invokevirtual 94	android/os/ParcelFileDescriptor$AutoCloseOutputStream:close	()V
        //   263: aload_2
        //   264: athrow
        //   265: astore_1
        //   266: goto -3 -> 263
        //   269: astore_1
        //   270: goto -54 -> 216
        //   273: astore_1
        //   274: aload_2
        //   275: areturn
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	276	0	this	1
        //   48	212	1	localAutoCloseOutputStream	android.os.ParcelFileDescriptor.AutoCloseOutputStream
        //   265	1	1	localIOException1	IOException
        //   269	1	1	localIOException2	IOException
        //   273	1	1	localIOException3	IOException
        //   102	43	2	localBoolean1	Boolean
        //   146	1	2	localIOException4	IOException
        //   221	54	2	localBoolean2	Boolean
        // Exception table:
        //   from	to	target	type
        //   49	98	146	java/io/IOException
        //   98	103	146	java/io/IOException
        //   49	98	221	finally
        //   98	103	221	finally
        //   147	175	221	finally
        //   222	259	265	java/io/IOException
        //   259	263	265	java/io/IOException
        //   175	212	269	java/io/IOException
        //   212	216	269	java/io/IOException
        //   103	140	273	java/io/IOException
        //   140	144	273	java/io/IOException
      }
    });
  }
  
  private Runnable zzb(final zzlx.zzb<Status> paramzzb, final String paramString, final Uri paramUri, final long paramLong1, long paramLong2)
  {
    zzx.zzy(paramzzb);
    zzx.zzy(paramString);
    zzx.zzy(paramUri);
    if (paramLong1 >= 0L)
    {
      bool = true;
      zzx.zzb(bool, "startOffset is negative: %s", new Object[] { Long.valueOf(paramLong1) });
      if (paramLong2 < -1L) {
        break label97;
      }
    }
    label97:
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "invalid length: %s", new Object[] { Long.valueOf(paramLong2) });
      new Runnable()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: ldc 49
          //   2: iconst_2
          //   3: invokestatic 55	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
          //   6: ifeq +11 -> 17
          //   9: ldc 49
          //   11: ldc 57
          //   13: invokestatic 61	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
          //   16: pop
          //   17: ldc 63
          //   19: aload_0
          //   20: getfield 28	com/google/android/gms/wearable/internal/zzce$3:zzaYf	Landroid/net/Uri;
          //   23: invokevirtual 69	android/net/Uri:getScheme	()Ljava/lang/String;
          //   26: invokevirtual 75	java/lang/String:equals	(Ljava/lang/Object;)Z
          //   29: ifne +32 -> 61
          //   32: ldc 49
          //   34: ldc 77
          //   36: invokestatic 80	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
          //   39: pop
          //   40: aload_0
          //   41: getfield 30	com/google/android/gms/wearable/internal/zzce$3:zzboU	Lcom/google/android/gms/internal/zzlx$zzb;
          //   44: new 82	com/google/android/gms/common/api/Status
          //   47: dup
          //   48: bipush 10
          //   50: ldc 77
          //   52: invokespecial 85	com/google/android/gms/common/api/Status:<init>	(ILjava/lang/String;)V
          //   55: invokeinterface 91 2 0
          //   60: return
          //   61: new 93	java/io/File
          //   64: dup
          //   65: aload_0
          //   66: getfield 28	com/google/android/gms/wearable/internal/zzce$3:zzaYf	Landroid/net/Uri;
          //   69: invokevirtual 96	android/net/Uri:getPath	()Ljava/lang/String;
          //   72: invokespecial 99	java/io/File:<init>	(Ljava/lang/String;)V
          //   75: astore_2
          //   76: aload_2
          //   77: ldc 100
          //   79: invokestatic 106	android/os/ParcelFileDescriptor:open	(Ljava/io/File;I)Landroid/os/ParcelFileDescriptor;
          //   82: astore_1
          //   83: aload_0
          //   84: getfield 26	com/google/android/gms/wearable/internal/zzce$3:zzboT	Lcom/google/android/gms/wearable/internal/zzce;
          //   87: invokevirtual 110	com/google/android/gms/wearable/internal/zzce:zzqs	()Landroid/os/IInterface;
          //   90: checkcast 112	com/google/android/gms/wearable/internal/zzbb
          //   93: new 114	com/google/android/gms/wearable/internal/zzcd$zzr
          //   96: dup
          //   97: aload_0
          //   98: getfield 30	com/google/android/gms/wearable/internal/zzce$3:zzboU	Lcom/google/android/gms/internal/zzlx$zzb;
          //   101: invokespecial 117	com/google/android/gms/wearable/internal/zzcd$zzr:<init>	(Lcom/google/android/gms/internal/zzlx$zzb;)V
          //   104: aload_0
          //   105: getfield 32	com/google/android/gms/wearable/internal/zzce$3:zzTM	Ljava/lang/String;
          //   108: aload_1
          //   109: aload_0
          //   110: getfield 34	com/google/android/gms/wearable/internal/zzce$3:zzbna	J
          //   113: aload_0
          //   114: getfield 36	com/google/android/gms/wearable/internal/zzce$3:zzbnb	J
          //   117: invokeinterface 121 8 0
          //   122: aload_1
          //   123: invokevirtual 124	android/os/ParcelFileDescriptor:close	()V
          //   126: return
          //   127: astore_1
          //   128: ldc 49
          //   130: ldc 126
          //   132: aload_1
          //   133: invokestatic 129	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
          //   136: pop
          //   137: return
          //   138: astore_1
          //   139: ldc 49
          //   141: new 131	java/lang/StringBuilder
          //   144: dup
          //   145: invokespecial 132	java/lang/StringBuilder:<init>	()V
          //   148: ldc -122
          //   150: invokevirtual 138	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
          //   153: aload_2
          //   154: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
          //   157: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
          //   160: invokestatic 80	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
          //   163: pop
          //   164: aload_0
          //   165: getfield 30	com/google/android/gms/wearable/internal/zzce$3:zzboU	Lcom/google/android/gms/internal/zzlx$zzb;
          //   168: new 82	com/google/android/gms/common/api/Status
          //   171: dup
          //   172: bipush 13
          //   174: invokespecial 147	com/google/android/gms/common/api/Status:<init>	(I)V
          //   177: invokeinterface 91 2 0
          //   182: return
          //   183: astore_2
          //   184: ldc 49
          //   186: ldc -107
          //   188: aload_2
          //   189: invokestatic 129	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
          //   192: pop
          //   193: aload_0
          //   194: getfield 30	com/google/android/gms/wearable/internal/zzce$3:zzboU	Lcom/google/android/gms/internal/zzlx$zzb;
          //   197: new 82	com/google/android/gms/common/api/Status
          //   200: dup
          //   201: bipush 8
          //   203: invokespecial 147	com/google/android/gms/common/api/Status:<init>	(I)V
          //   206: invokeinterface 91 2 0
          //   211: aload_1
          //   212: invokevirtual 124	android/os/ParcelFileDescriptor:close	()V
          //   215: return
          //   216: astore_1
          //   217: ldc 49
          //   219: ldc 126
          //   221: aload_1
          //   222: invokestatic 129	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
          //   225: pop
          //   226: return
          //   227: astore_2
          //   228: aload_1
          //   229: invokevirtual 124	android/os/ParcelFileDescriptor:close	()V
          //   232: aload_2
          //   233: athrow
          //   234: astore_1
          //   235: ldc 49
          //   237: ldc 126
          //   239: aload_1
          //   240: invokestatic 129	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
          //   243: pop
          //   244: goto -12 -> 232
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	247	0	this	3
          //   82	41	1	localParcelFileDescriptor	ParcelFileDescriptor
          //   127	6	1	localIOException1	IOException
          //   138	74	1	localFileNotFoundException	FileNotFoundException
          //   216	13	1	localIOException2	IOException
          //   234	6	1	localIOException3	IOException
          //   75	79	2	localFile	File
          //   183	6	2	localRemoteException	RemoteException
          //   227	6	2	localObject	Object
          // Exception table:
          //   from	to	target	type
          //   122	126	127	java/io/IOException
          //   76	83	138	java/io/FileNotFoundException
          //   83	122	183	android/os/RemoteException
          //   211	215	216	java/io/IOException
          //   83	122	227	finally
          //   184	211	227	finally
          //   228	232	234	java/io/IOException
        }
      };
      bool = false;
      break;
    }
  }
  
  private Runnable zzb(final zzlx.zzb<Status> paramzzb, final String paramString, final Uri paramUri, final boolean paramBoolean)
  {
    zzx.zzy(paramzzb);
    zzx.zzy(paramString);
    zzx.zzy(paramUri);
    new Runnable()
    {
      public void run()
      {
        if (Log.isLoggable("WearableClient", 2)) {
          Log.v("WearableClient", "Executing receiveFileFromChannelTask");
        }
        if (!"file".equals(paramUri.getScheme()))
        {
          Log.w("WearableClient", "Channel.receiveFile used with non-file URI");
          paramzzb.zzx(new Status(10, "Channel.receiveFile used with non-file URI"));
          return;
        }
        File localFile = new File(paramUri.getPath());
        int i;
        if (paramBoolean) {
          i = 33554432;
        }
        try
        {
          localParcelFileDescriptor = ParcelFileDescriptor.open(localFile, i | 0x20000000);
        }
        catch (FileNotFoundException localRemoteException)
        {
          try
          {
            for (;;)
            {
              ParcelFileDescriptor localParcelFileDescriptor;
              ((zzbb)zzce.this.zzqs()).zza(new zzcd.zzu(paramzzb), paramString, localParcelFileDescriptor);
              try
              {
                localParcelFileDescriptor.close();
                return;
              }
              catch (IOException localIOException1)
              {
                Log.w("WearableClient", "Failed to close targetFd", localIOException1);
                return;
              }
              i = 0;
            }
          }
          catch (RemoteException localRemoteException)
          {
            localRemoteException = localRemoteException;
            Log.w("WearableClient", "Channel.receiveFile failed.", localRemoteException);
            paramzzb.zzx(new Status(8));
            try
            {
              localFileNotFoundException.close();
              return;
            }
            catch (IOException localIOException2)
            {
              Log.w("WearableClient", "Failed to close targetFd", localIOException2);
              return;
            }
          }
          finally {}
          localFileNotFoundException = localFileNotFoundException;
          Log.w("WearableClient", "File couldn't be opened for Channel.receiveFile: " + localFile);
          paramzzb.zzx(new Status(13));
          return;
        }
        try
        {
          localIOException2.close();
          throw ((Throwable)localObject);
        }
        catch (IOException localIOException3)
        {
          for (;;)
          {
            Log.w("WearableClient", "Failed to close targetFd", localIOException3);
          }
        }
      }
    };
  }
  
  public void disconnect()
  {
    this.zzboJ.zzb(this);
    this.zzboK.zzb(this);
    this.zzboL.zzb(this);
    this.zzboM.zzb(this);
    this.zzboN.zzb(this);
    this.zzboO.zzb(this);
    this.zzboP.zzb(this);
    this.zzboQ.zzb(this);
    this.zzboR.zzb(this);
    super.disconnect();
  }
  
  protected void zza(int paramInt1, IBinder paramIBinder, Bundle paramBundle, int paramInt2)
  {
    if (Log.isLoggable("WearableClient", 2)) {
      Log.d("WearableClient", "onPostInitHandler: statusCode " + paramInt1);
    }
    if (paramInt1 == 0)
    {
      this.zzboJ.zzes(paramIBinder);
      this.zzboK.zzes(paramIBinder);
      this.zzboL.zzes(paramIBinder);
      this.zzboM.zzes(paramIBinder);
      this.zzboN.zzes(paramIBinder);
      this.zzboO.zzes(paramIBinder);
      this.zzboP.zzes(paramIBinder);
      this.zzboQ.zzes(paramIBinder);
      this.zzboR.zzes(paramIBinder);
    }
    super.zza(paramInt1, paramIBinder, paramBundle, paramInt2);
  }
  
  public void zza(zzlx.zzb<DataApi.DataItemResult> paramzzb, Uri paramUri)
    throws RemoteException
  {
    ((zzbb)zzqs()).zza(new zzcd.zzk(paramzzb), paramUri);
  }
  
  public void zza(zzlx.zzb<DataItemBuffer> paramzzb, Uri paramUri, int paramInt)
    throws RemoteException
  {
    ((zzbb)zzqs()).zza(new zzcd.zzl(paramzzb), paramUri, paramInt);
  }
  
  public void zza(zzlx.zzb<DataApi.GetFdForAssetResult> paramzzb, Asset paramAsset)
    throws RemoteException
  {
    ((zzbb)zzqs()).zza(new zzcd.zzm(paramzzb), paramAsset);
  }
  
  public void zza(zzlx.zzb<Status> paramzzb, CapabilityApi.CapabilityListener paramCapabilityListener)
    throws RemoteException
  {
    this.zzboR.zza(this, paramzzb, paramCapabilityListener);
  }
  
  public void zza(zzlx.zzb<Status> paramzzb, CapabilityApi.CapabilityListener paramCapabilityListener, zzmn<CapabilityApi.CapabilityListener> paramzzmn, IntentFilter[] paramArrayOfIntentFilter)
    throws RemoteException
  {
    this.zzboR.zza(this, paramzzb, paramCapabilityListener, zzcf.zze(paramzzmn, paramArrayOfIntentFilter));
  }
  
  public void zza(zzlx.zzb<Status> paramzzb, ChannelApi.ChannelListener paramChannelListener, zzmn<ChannelApi.ChannelListener> paramzzmn, String paramString, IntentFilter[] paramArrayOfIntentFilter)
    throws RemoteException
  {
    if (paramString == null)
    {
      this.zzboL.zza(this, paramzzb, paramChannelListener, zzcf.zzd(paramzzmn, paramArrayOfIntentFilter));
      return;
    }
    paramChannelListener = new zzby(paramString, paramChannelListener);
    this.zzboL.zza(this, paramzzb, paramChannelListener, zzcf.zza(paramzzmn, paramString, paramArrayOfIntentFilter));
  }
  
  public void zza(zzlx.zzb<Status> paramzzb, ChannelApi.ChannelListener paramChannelListener, String paramString)
    throws RemoteException
  {
    if (paramString == null)
    {
      this.zzboL.zza(this, paramzzb, paramChannelListener);
      return;
    }
    paramChannelListener = new zzby(paramString, paramChannelListener);
    this.zzboL.zza(this, paramzzb, paramChannelListener);
  }
  
  public void zza(zzlx.zzb<Status> paramzzb, DataApi.DataListener paramDataListener)
    throws RemoteException
  {
    this.zzboN.zza(this, paramzzb, paramDataListener);
  }
  
  public void zza(zzlx.zzb<Status> paramzzb, DataApi.DataListener paramDataListener, zzmn<DataApi.DataListener> paramzzmn, IntentFilter[] paramArrayOfIntentFilter)
    throws RemoteException
  {
    this.zzboN.zza(this, paramzzb, paramDataListener, zzcf.zza(paramzzmn, paramArrayOfIntentFilter));
  }
  
  public void zza(zzlx.zzb<DataApi.GetFdForAssetResult> paramzzb, DataItemAsset paramDataItemAsset)
    throws RemoteException
  {
    zza(paramzzb, Asset.createFromRef(paramDataItemAsset.getId()));
  }
  
  public void zza(zzlx.zzb<Status> paramzzb, MessageApi.MessageListener paramMessageListener)
    throws RemoteException
  {
    this.zzboO.zza(this, paramzzb, paramMessageListener);
  }
  
  public void zza(zzlx.zzb<Status> paramzzb, MessageApi.MessageListener paramMessageListener, zzmn<MessageApi.MessageListener> paramzzmn, IntentFilter[] paramArrayOfIntentFilter)
    throws RemoteException
  {
    this.zzboO.zza(this, paramzzb, paramMessageListener, zzcf.zzb(paramzzmn, paramArrayOfIntentFilter));
  }
  
  public void zza(zzlx.zzb<Status> paramzzb, NodeApi.NodeListener paramNodeListener)
    throws RemoteException
  {
    this.zzboP.zza(this, paramzzb, paramNodeListener);
  }
  
  public void zza(zzlx.zzb<Status> paramzzb, NodeApi.NodeListener paramNodeListener, zzmn<NodeApi.NodeListener> paramzzmn, IntentFilter[] paramArrayOfIntentFilter)
    throws RemoteException
  {
    this.zzboP.zza(this, paramzzb, paramNodeListener, zzcf.zzc(paramzzmn, paramArrayOfIntentFilter));
  }
  
  public void zza(zzlx.zzb<DataApi.DataItemResult> paramzzb, PutDataRequest paramPutDataRequest)
    throws RemoteException
  {
    Object localObject1 = paramPutDataRequest.getAssets().entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Asset)((Map.Entry)((Iterator)localObject1).next()).getValue();
      if ((((Asset)localObject2).getData() == null) && (((Asset)localObject2).getDigest() == null) && (((Asset)localObject2).getFd() == null) && (((Asset)localObject2).getUri() == null)) {
        throw new IllegalArgumentException("Put for " + paramPutDataRequest.getUri() + " contains invalid asset: " + localObject2);
      }
    }
    Object localObject2 = PutDataRequest.zzr(paramPutDataRequest.getUri());
    ((PutDataRequest)localObject2).setData(paramPutDataRequest.getData());
    if (paramPutDataRequest.isUrgent()) {
      ((PutDataRequest)localObject2).setUrgent();
    }
    localObject1 = new ArrayList();
    Iterator localIterator = paramPutDataRequest.getAssets().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Object localObject3 = (Asset)localEntry.getValue();
      Object localObject4;
      if (((Asset)localObject3).getData() != null) {
        try
        {
          localObject4 = ParcelFileDescriptor.createPipe();
          if (Log.isLoggable("WearableClient", 3)) {
            Log.d("WearableClient", "processAssets: replacing data with FD in asset: " + localObject3 + " read:" + localObject4[0] + " write:" + localObject4[1]);
          }
          ((PutDataRequest)localObject2).putAsset((String)localEntry.getKey(), Asset.createFromFd(localObject4[0]));
          localObject3 = zza(localObject4[1], ((Asset)localObject3).getData());
          ((List)localObject1).add(localObject3);
          this.zzbfg.submit((Runnable)localObject3);
        }
        catch (IOException paramzzb)
        {
          throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + paramPutDataRequest, paramzzb);
        }
      } else if (((Asset)localObject3).getUri() != null) {
        try
        {
          localObject4 = Asset.createFromFd(getContext().getContentResolver().openFileDescriptor(((Asset)localObject3).getUri(), "r"));
          ((PutDataRequest)localObject2).putAsset((String)localEntry.getKey(), (Asset)localObject4);
        }
        catch (FileNotFoundException paramPutDataRequest)
        {
          new zzcd.zzq(paramzzb, (List)localObject1).zza(new PutDataResponse(4005, null));
          Log.w("WearableClient", "Couldn't resolve asset URI: " + ((Asset)localObject3).getUri());
          return;
        }
      } else {
        ((PutDataRequest)localObject2).putAsset((String)localEntry.getKey(), (Asset)localObject3);
      }
    }
    ((zzbb)zzqs()).zza(new zzcd.zzq(paramzzb, (List)localObject1), (PutDataRequest)localObject2);
  }
  
  public void zza(zzlx.zzb<Status> paramzzb, String paramString, Uri paramUri, long paramLong1, long paramLong2)
  {
    try
    {
      this.zzbfg.execute(zzb(paramzzb, paramString, paramUri, paramLong1, paramLong2));
      return;
    }
    catch (RuntimeException paramString)
    {
      paramzzb.zzx(new Status(8));
      throw paramString;
    }
  }
  
  public void zza(zzlx.zzb<Status> paramzzb, String paramString, Uri paramUri, boolean paramBoolean)
  {
    try
    {
      this.zzbfg.execute(zzb(paramzzb, paramString, paramUri, paramBoolean));
      return;
    }
    catch (RuntimeException paramString)
    {
      paramzzb.zzx(new Status(8));
      throw paramString;
    }
  }
  
  public void zza(zzlx.zzb<MessageApi.SendMessageResult> paramzzb, String paramString1, String paramString2, byte[] paramArrayOfByte)
    throws RemoteException
  {
    ((zzbb)zzqs()).zza(new zzcd.zzt(paramzzb), paramString1, paramString2, paramArrayOfByte);
  }
  
  public void zzb(zzlx.zzb<CapabilityApi.GetAllCapabilitiesResult> paramzzb, int paramInt)
    throws RemoteException
  {
    ((zzbb)zzqs()).zza(new zzcd.zzf(paramzzb), paramInt);
  }
  
  public void zzb(zzlx.zzb<DataApi.DeleteDataItemsResult> paramzzb, Uri paramUri, int paramInt)
    throws RemoteException
  {
    ((zzbb)zzqs()).zzb(new zzcd.zze(paramzzb), paramUri, paramInt);
  }
  
  public void zze(zzlx.zzb<ChannelApi.OpenChannelResult> paramzzb, String paramString1, String paramString2)
    throws RemoteException
  {
    ((zzbb)zzqs()).zza(new zzcd.zzp(paramzzb), paramString1, paramString2);
  }
  
  protected zzbb zzet(IBinder paramIBinder)
  {
    return zzbb.zza.zzer(paramIBinder);
  }
  
  public void zzg(zzlx.zzb<CapabilityApi.GetCapabilityResult> paramzzb, String paramString, int paramInt)
    throws RemoteException
  {
    ((zzbb)zzqs()).zza(new zzcd.zzg(paramzzb), paramString, paramInt);
  }
  
  protected String zzgh()
  {
    return "com.google.android.gms.wearable.BIND";
  }
  
  protected String zzgi()
  {
    return "com.google.android.gms.wearable.internal.IWearableService";
  }
  
  public void zzh(zzlx.zzb<Status> paramzzb, String paramString, int paramInt)
    throws RemoteException
  {
    ((zzbb)zzqs()).zzb(new zzcd.zzd(paramzzb), paramString, paramInt);
  }
  
  public void zzo(zzlx.zzb<DataItemBuffer> paramzzb)
    throws RemoteException
  {
    ((zzbb)zzqs()).zzb(new zzcd.zzl(paramzzb));
  }
  
  public void zzp(zzlx.zzb<NodeApi.GetLocalNodeResult> paramzzb)
    throws RemoteException
  {
    ((zzbb)zzqs()).zzc(new zzcd.zzn(paramzzb));
  }
  
  public void zzq(zzlx.zzb<NodeApi.GetConnectedNodesResult> paramzzb)
    throws RemoteException
  {
    ((zzbb)zzqs()).zzd(new zzcd.zzj(paramzzb));
  }
  
  public void zzr(zzlx.zzb<CapabilityApi.AddLocalCapabilityResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((zzbb)zzqs()).zzd(new zzcd.zza(paramzzb), paramString);
  }
  
  public void zzs(zzlx.zzb<CapabilityApi.RemoveLocalCapabilityResult> paramzzb, String paramString)
    throws RemoteException
  {
    ((zzbb)zzqs()).zze(new zzcd.zzs(paramzzb), paramString);
  }
  
  public void zzt(zzlx.zzb<Status> paramzzb, String paramString)
    throws RemoteException
  {
    ((zzbb)zzqs()).zzf(new zzcd.zzc(paramzzb), paramString);
  }
  
  public void zzu(zzlx.zzb<Channel.GetInputStreamResult> paramzzb, String paramString)
    throws RemoteException
  {
    zzt localzzt = new zzt();
    ((zzbb)zzqs()).zza(new zzcd.zzh(paramzzb, localzzt), localzzt, paramString);
  }
  
  public void zzv(zzlx.zzb<Channel.GetOutputStreamResult> paramzzb, String paramString)
    throws RemoteException
  {
    zzt localzzt = new zzt();
    ((zzbb)zzqs()).zzb(new zzcd.zzi(paramzzb, localzzt), localzzt, paramString);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */