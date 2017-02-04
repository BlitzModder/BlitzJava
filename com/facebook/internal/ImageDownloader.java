package com.facebook.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import com.facebook.FacebookException;
import com.facebook.android.R.string;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class ImageDownloader
{
  private static final int CACHE_READ_QUEUE_MAX_CONCURRENT = 2;
  private static final int DOWNLOAD_QUEUE_MAX_CONCURRENT = 8;
  private static WorkQueue cacheReadQueue = new WorkQueue(2);
  private static WorkQueue downloadQueue = new WorkQueue(8);
  private static Handler handler;
  private static final Map<RequestKey, DownloaderContext> pendingRequests = new HashMap();
  
  public static boolean cancelRequest(ImageRequest arg0)
  {
    boolean bool = false;
    RequestKey localRequestKey = new RequestKey(???.getImageUri(), ???.getCallerTag());
    synchronized (pendingRequests)
    {
      DownloaderContext localDownloaderContext = (DownloaderContext)pendingRequests.get(localRequestKey);
      if (localDownloaderContext != null)
      {
        bool = true;
        if (localDownloaderContext.workItem.cancel()) {
          pendingRequests.remove(localRequestKey);
        }
      }
      else
      {
        return bool;
      }
      localDownloaderContext.isCancelled = true;
    }
  }
  
  public static void clearCache(Context paramContext)
  {
    ImageResponseCache.clearCache(paramContext);
    UrlRedirectCache.clearCache(paramContext);
  }
  
  private static void download(RequestKey paramRequestKey, Context paramContext)
  {
    Object localObject8 = null;
    Object localObject9 = null;
    Object localObject7 = null;
    Object localObject14 = null;
    Object localObject15 = null;
    Object localObject16 = null;
    Object localObject13 = null;
    Object localObject12 = null;
    Object localObject11 = null;
    Object localObject10 = null;
    int m = 1;
    int n = 1;
    int k = 1;
    int i = k;
    Object localObject2 = localObject13;
    int j = n;
    Object localObject3 = localObject15;
    Object localObject4 = localObject16;
    try
    {
      HttpURLConnection localHttpURLConnection = (HttpURLConnection)new URL(paramRequestKey.uri.toString()).openConnection();
      localObject7 = localHttpURLConnection;
      i = k;
      localObject2 = localObject13;
      localObject8 = localHttpURLConnection;
      j = n;
      localObject3 = localObject15;
      localObject9 = localHttpURLConnection;
      localObject4 = localObject16;
      localHttpURLConnection.setInstanceFollowRedirects(false);
      localObject7 = localHttpURLConnection;
      i = k;
      localObject2 = localObject13;
      localObject8 = localHttpURLConnection;
      j = n;
      localObject3 = localObject15;
      localObject9 = localHttpURLConnection;
      localObject4 = localObject16;
      switch (localHttpURLConnection.getResponseCode())
      {
      }
      Object localObject1;
      Object localObject5;
      int i1;
      Object localObject17;
      Object localObject6;
      for (;;)
      {
        localObject7 = localHttpURLConnection;
        i = k;
        localObject2 = localObject13;
        localObject8 = localHttpURLConnection;
        j = n;
        localObject3 = localObject15;
        localObject9 = localHttpURLConnection;
        localObject4 = localObject16;
        localObject1 = localHttpURLConnection.getErrorStream();
        localObject7 = localHttpURLConnection;
        i = k;
        localObject2 = localObject1;
        localObject8 = localHttpURLConnection;
        j = n;
        localObject3 = localObject1;
        localObject9 = localHttpURLConnection;
        localObject4 = localObject1;
        localObject5 = new StringBuilder();
        if (localObject1 != null)
        {
          localObject7 = localHttpURLConnection;
          i = k;
          localObject2 = localObject1;
          localObject8 = localHttpURLConnection;
          j = n;
          localObject3 = localObject1;
          localObject9 = localHttpURLConnection;
          localObject4 = localObject1;
          paramContext = new InputStreamReader((InputStream)localObject1);
          localObject7 = localHttpURLConnection;
          i = k;
          localObject2 = localObject1;
          localObject8 = localHttpURLConnection;
          j = n;
          localObject3 = localObject1;
          localObject9 = localHttpURLConnection;
          localObject4 = localObject1;
          char[] arrayOfChar = new char[''];
          for (;;)
          {
            localObject7 = localHttpURLConnection;
            i = k;
            localObject2 = localObject1;
            localObject8 = localHttpURLConnection;
            j = n;
            localObject3 = localObject1;
            localObject9 = localHttpURLConnection;
            localObject4 = localObject1;
            i1 = paramContext.read(arrayOfChar, 0, arrayOfChar.length);
            if (i1 <= 0) {
              break;
            }
            localObject7 = localHttpURLConnection;
            i = k;
            localObject2 = localObject1;
            localObject8 = localHttpURLConnection;
            j = n;
            localObject3 = localObject1;
            localObject9 = localHttpURLConnection;
            localObject4 = localObject1;
            ((StringBuilder)localObject5).append(arrayOfChar, 0, i1);
          }
        }
      }
    }
    catch (IOException localIOException)
    {
      Utility.closeQuietly((Closeable)localObject2);
      Utility.disconnectQuietly((URLConnection)localObject7);
      localObject5 = localObject10;
      if (i != 0) {
        issueResponse(paramRequestKey, localIOException, (Bitmap)localObject5, false);
      }
      return;
      n = 0;
      i1 = 0;
      m = 0;
      localObject7 = localHttpURLConnection;
      i = m;
      localObject2 = localObject13;
      localObject8 = localHttpURLConnection;
      j = i1;
      localObject3 = localObject15;
      localObject9 = localHttpURLConnection;
      localObject4 = localObject16;
      localObject17 = localHttpURLConnection.getHeaderField("location");
      localObject7 = localHttpURLConnection;
      i = m;
      localObject2 = localObject13;
      localObject5 = localObject11;
      localObject6 = localObject12;
      k = n;
      localObject1 = localObject14;
      localObject8 = localHttpURLConnection;
      j = i1;
      localObject3 = localObject15;
      localObject9 = localHttpURLConnection;
      localObject4 = localObject16;
      if (!Utility.isNullOrEmpty((String)localObject17))
      {
        localObject7 = localHttpURLConnection;
        i = m;
        localObject2 = localObject13;
        localObject8 = localHttpURLConnection;
        j = i1;
        localObject3 = localObject15;
        localObject9 = localHttpURLConnection;
        localObject4 = localObject16;
        localObject17 = new URI((String)localObject17);
        localObject7 = localHttpURLConnection;
        i = m;
        localObject2 = localObject13;
        localObject8 = localHttpURLConnection;
        j = i1;
        localObject3 = localObject15;
        localObject9 = localHttpURLConnection;
        localObject4 = localObject16;
        UrlRedirectCache.cacheUriRedirect(paramContext, paramRequestKey.uri, (URI)localObject17);
        localObject7 = localHttpURLConnection;
        i = m;
        localObject2 = localObject13;
        localObject8 = localHttpURLConnection;
        j = i1;
        localObject3 = localObject15;
        localObject9 = localHttpURLConnection;
        localObject4 = localObject16;
        paramContext = removePendingRequest(paramRequestKey);
        localObject5 = localObject11;
        localObject6 = localObject12;
        k = n;
        localObject1 = localObject14;
        if (paramContext != null)
        {
          localObject7 = localHttpURLConnection;
          i = m;
          localObject2 = localObject13;
          localObject5 = localObject11;
          localObject6 = localObject12;
          k = n;
          localObject1 = localObject14;
          localObject8 = localHttpURLConnection;
          j = i1;
          localObject3 = localObject15;
          localObject9 = localHttpURLConnection;
          localObject4 = localObject16;
          if (!paramContext.isCancelled)
          {
            localObject7 = localHttpURLConnection;
            i = m;
            localObject2 = localObject13;
            localObject8 = localHttpURLConnection;
            j = i1;
            localObject3 = localObject15;
            localObject9 = localHttpURLConnection;
            localObject4 = localObject16;
            enqueueCacheRead(paramContext.request, new RequestKey((URI)localObject17, paramRequestKey.tag), false);
            localObject1 = localObject14;
            k = n;
            localObject6 = localObject12;
            localObject5 = localObject11;
          }
        }
      }
      for (;;)
      {
        Utility.closeQuietly((Closeable)localObject1);
        Utility.disconnectQuietly(localHttpURLConnection);
        i = k;
        break;
        localObject7 = localHttpURLConnection;
        i = k;
        localObject2 = localObject13;
        localObject8 = localHttpURLConnection;
        j = n;
        localObject3 = localObject15;
        localObject9 = localHttpURLConnection;
        localObject4 = localObject16;
        paramContext = ImageResponseCache.interceptAndCacheImageStream(paramContext, localHttpURLConnection);
        localObject7 = localHttpURLConnection;
        i = k;
        localObject2 = paramContext;
        localObject8 = localHttpURLConnection;
        j = n;
        localObject3 = paramContext;
        localObject9 = localHttpURLConnection;
        localObject4 = paramContext;
        localObject5 = BitmapFactory.decodeStream(paramContext);
        localObject6 = localObject12;
        k = m;
        localObject1 = paramContext;
      }
      localObject7 = localHttpURLConnection;
      i = k;
      localObject2 = localObject1;
      localObject8 = localHttpURLConnection;
      j = n;
      localObject3 = localObject1;
      localObject9 = localHttpURLConnection;
      localObject4 = localObject1;
      Utility.closeQuietly(paramContext);
      for (;;)
      {
        localObject7 = localHttpURLConnection;
        i = k;
        localObject2 = localObject1;
        localObject8 = localHttpURLConnection;
        j = n;
        localObject3 = localObject1;
        localObject9 = localHttpURLConnection;
        localObject4 = localObject1;
        localObject6 = new FacebookException(((StringBuilder)localObject5).toString());
        localObject5 = localObject11;
        k = m;
        break;
        localObject7 = localHttpURLConnection;
        i = k;
        localObject2 = localObject1;
        localObject8 = localHttpURLConnection;
        j = n;
        localObject3 = localObject1;
        localObject9 = localHttpURLConnection;
        localObject4 = localObject1;
        ((StringBuilder)localObject5).append(paramContext.getString(R.string.com_facebook_image_download_unknown_error));
      }
    }
    catch (URISyntaxException localURISyntaxException)
    {
      for (;;)
      {
        Utility.closeQuietly((Closeable)localObject3);
        Utility.disconnectQuietly((URLConnection)localObject8);
        localObject5 = localObject10;
        i = j;
      }
    }
    finally
    {
      Utility.closeQuietly((Closeable)localObject4);
      Utility.disconnectQuietly((URLConnection)localObject9);
    }
  }
  
  public static void downloadAsync(ImageRequest paramImageRequest)
  {
    if (paramImageRequest == null) {
      return;
    }
    RequestKey localRequestKey = new RequestKey(paramImageRequest.getImageUri(), paramImageRequest.getCallerTag());
    for (;;)
    {
      synchronized (pendingRequests)
      {
        DownloaderContext localDownloaderContext = (DownloaderContext)pendingRequests.get(localRequestKey);
        if (localDownloaderContext != null)
        {
          localDownloaderContext.request = paramImageRequest;
          localDownloaderContext.isCancelled = false;
          localDownloaderContext.workItem.moveToFront();
          return;
        }
      }
      enqueueCacheRead(paramImageRequest, localRequestKey, paramImageRequest.isCachedRedirectAllowed());
    }
  }
  
  private static void enqueueCacheRead(ImageRequest paramImageRequest, RequestKey paramRequestKey, boolean paramBoolean)
  {
    enqueueRequest(paramImageRequest, paramRequestKey, cacheReadQueue, new CacheReadWorkItem(paramImageRequest.getContext(), paramRequestKey, paramBoolean));
  }
  
  private static void enqueueDownload(ImageRequest paramImageRequest, RequestKey paramRequestKey)
  {
    enqueueRequest(paramImageRequest, paramRequestKey, downloadQueue, new DownloadImageWorkItem(paramImageRequest.getContext(), paramRequestKey));
  }
  
  private static void enqueueRequest(ImageRequest paramImageRequest, RequestKey paramRequestKey, WorkQueue paramWorkQueue, Runnable paramRunnable)
  {
    synchronized (pendingRequests)
    {
      DownloaderContext localDownloaderContext = new DownloaderContext(null);
      localDownloaderContext.request = paramImageRequest;
      pendingRequests.put(paramRequestKey, localDownloaderContext);
      localDownloaderContext.workItem = paramWorkQueue.addActiveWorkItem(paramRunnable);
      return;
    }
  }
  
  private static Handler getHandler()
  {
    try
    {
      if (handler == null) {
        handler = new Handler(Looper.getMainLooper());
      }
      Handler localHandler = handler;
      return localHandler;
    }
    finally {}
  }
  
  private static void issueResponse(RequestKey paramRequestKey, final Exception paramException, final Bitmap paramBitmap, final boolean paramBoolean)
  {
    paramRequestKey = removePendingRequest(paramRequestKey);
    if ((paramRequestKey != null) && (!paramRequestKey.isCancelled))
    {
      paramRequestKey = paramRequestKey.request;
      final ImageRequest.Callback localCallback = paramRequestKey.getCallback();
      if (localCallback != null) {
        getHandler().post(new Runnable()
        {
          public void run()
          {
            ImageResponse localImageResponse = new ImageResponse(this.val$request, paramException, paramBoolean, paramBitmap);
            localCallback.onCompleted(localImageResponse);
          }
        });
      }
    }
  }
  
  public static void prioritizeRequest(ImageRequest arg0)
  {
    Object localObject1 = new RequestKey(???.getImageUri(), ???.getCallerTag());
    synchronized (pendingRequests)
    {
      localObject1 = (DownloaderContext)pendingRequests.get(localObject1);
      if (localObject1 != null) {
        ((DownloaderContext)localObject1).workItem.moveToFront();
      }
      return;
    }
  }
  
  private static void readFromCache(RequestKey paramRequestKey, Context paramContext, boolean paramBoolean)
  {
    Object localObject2 = null;
    boolean bool2 = false;
    Object localObject1 = localObject2;
    boolean bool1 = bool2;
    if (paramBoolean)
    {
      URI localURI = UrlRedirectCache.getRedirectedUri(paramContext, paramRequestKey.uri);
      localObject1 = localObject2;
      bool1 = bool2;
      if (localURI != null)
      {
        localObject1 = ImageResponseCache.getCachedImageStream(localURI, paramContext);
        if (localObject1 == null) {
          break label92;
        }
        bool1 = true;
      }
    }
    if (!bool1) {
      localObject1 = ImageResponseCache.getCachedImageStream(paramRequestKey.uri, paramContext);
    }
    if (localObject1 != null)
    {
      paramContext = BitmapFactory.decodeStream((InputStream)localObject1);
      Utility.closeQuietly((Closeable)localObject1);
      issueResponse(paramRequestKey, null, paramContext, bool1);
    }
    label92:
    do
    {
      return;
      bool1 = false;
      break;
      paramContext = removePendingRequest(paramRequestKey);
    } while ((paramContext == null) || (paramContext.isCancelled));
    enqueueDownload(paramContext.request, paramRequestKey);
  }
  
  private static DownloaderContext removePendingRequest(RequestKey paramRequestKey)
  {
    synchronized (pendingRequests)
    {
      paramRequestKey = (DownloaderContext)pendingRequests.remove(paramRequestKey);
      return paramRequestKey;
    }
  }
  
  private static class CacheReadWorkItem
    implements Runnable
  {
    private boolean allowCachedRedirects;
    private Context context;
    private ImageDownloader.RequestKey key;
    
    CacheReadWorkItem(Context paramContext, ImageDownloader.RequestKey paramRequestKey, boolean paramBoolean)
    {
      this.context = paramContext;
      this.key = paramRequestKey;
      this.allowCachedRedirects = paramBoolean;
    }
    
    public void run()
    {
      ImageDownloader.readFromCache(this.key, this.context, this.allowCachedRedirects);
    }
  }
  
  private static class DownloadImageWorkItem
    implements Runnable
  {
    private Context context;
    private ImageDownloader.RequestKey key;
    
    DownloadImageWorkItem(Context paramContext, ImageDownloader.RequestKey paramRequestKey)
    {
      this.context = paramContext;
      this.key = paramRequestKey;
    }
    
    public void run()
    {
      ImageDownloader.download(this.key, this.context);
    }
  }
  
  private static class DownloaderContext
  {
    boolean isCancelled;
    ImageRequest request;
    WorkQueue.WorkItem workItem;
  }
  
  private static class RequestKey
  {
    private static final int HASH_MULTIPLIER = 37;
    private static final int HASH_SEED = 29;
    Object tag;
    URI uri;
    
    RequestKey(URI paramURI, Object paramObject)
    {
      this.uri = paramURI;
      this.tag = paramObject;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2 = false;
      boolean bool1 = bool2;
      if (paramObject != null)
      {
        bool1 = bool2;
        if ((paramObject instanceof RequestKey))
        {
          paramObject = (RequestKey)paramObject;
          if ((((RequestKey)paramObject).uri != this.uri) || (((RequestKey)paramObject).tag != this.tag)) {
            break label48;
          }
          bool1 = true;
        }
      }
      return bool1;
      label48:
      return false;
    }
    
    public int hashCode()
    {
      return (this.uri.hashCode() + 1073) * 37 + this.tag.hashCode();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/facebook/internal/ImageDownloader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */