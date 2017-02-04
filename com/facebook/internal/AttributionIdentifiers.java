package com.facebook.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import com.facebook.FacebookException;
import java.lang.reflect.Method;

public class AttributionIdentifiers
{
  private static final String ANDROID_ID_COLUMN_NAME = "androidid";
  private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
  private static final Uri ATTRIBUTION_ID_CONTENT_URI = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
  private static final int CONNECTION_RESULT_SUCCESS = 0;
  private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000L;
  private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
  private static final String TAG = AttributionIdentifiers.class.getCanonicalName();
  private static AttributionIdentifiers recentlyFetchedIdentifiers;
  private String androidAdvertiserId;
  private String attributionId;
  private long fetchTime;
  private boolean limitTracking;
  
  private static AttributionIdentifiers getAndroidId(Context paramContext)
  {
    AttributionIdentifiers localAttributionIdentifiers = new AttributionIdentifiers();
    Object localObject;
    Method localMethod;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              try
              {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                  throw new FacebookException("getAndroidId cannot be called on the main thread.");
                }
              }
              catch (Exception paramContext)
              {
                Utility.logd("android_id", paramContext);
                return localAttributionIdentifiers;
              }
              localObject = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[] { Context.class });
            } while (localObject == null);
            localObject = Utility.invokeMethodQuietly(null, (Method)localObject, new Object[] { paramContext });
          } while ((!(localObject instanceof Integer)) || (((Integer)localObject).intValue() != 0));
          localObject = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[] { Context.class });
        } while (localObject == null);
        paramContext = Utility.invokeMethodQuietly(null, (Method)localObject, new Object[] { paramContext });
      } while (paramContext == null);
      localObject = Utility.getMethodQuietly(paramContext.getClass(), "getId", new Class[0]);
      localMethod = Utility.getMethodQuietly(paramContext.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
    } while ((localObject == null) || (localMethod == null));
    localAttributionIdentifiers.androidAdvertiserId = ((String)Utility.invokeMethodQuietly(paramContext, (Method)localObject, new Object[0]));
    localAttributionIdentifiers.limitTracking = ((Boolean)Utility.invokeMethodQuietly(paramContext, localMethod, new Object[0])).booleanValue();
    return localAttributionIdentifiers;
  }
  
  public static AttributionIdentifiers getAttributionIdentifiers(Context paramContext)
  {
    Object localObject1;
    if ((recentlyFetchedIdentifiers != null) && (System.currentTimeMillis() - recentlyFetchedIdentifiers.fetchTime < 3600000L)) {
      localObject1 = recentlyFetchedIdentifiers;
    }
    for (;;)
    {
      return (AttributionIdentifiers)localObject1;
      AttributionIdentifiers localAttributionIdentifiers = getAndroidId(paramContext);
      Object localObject2 = null;
      localObject1 = null;
      try
      {
        paramContext = paramContext.getContentResolver().query(ATTRIBUTION_ID_CONTENT_URI, new String[] { "aid", "androidid", "limit_tracking" }, null, null, null);
        if (paramContext != null)
        {
          localObject1 = paramContext;
          localObject2 = paramContext;
          boolean bool = paramContext.moveToFirst();
          if (bool) {}
        }
        else
        {
          localObject1 = localAttributionIdentifiers;
          if (paramContext == null) {
            continue;
          }
          paramContext.close();
          return localAttributionIdentifiers;
        }
        localObject1 = paramContext;
        localObject2 = paramContext;
        int i = paramContext.getColumnIndex("aid");
        localObject1 = paramContext;
        localObject2 = paramContext;
        int j = paramContext.getColumnIndex("androidid");
        localObject1 = paramContext;
        localObject2 = paramContext;
        int k = paramContext.getColumnIndex("limit_tracking");
        localObject1 = paramContext;
        localObject2 = paramContext;
        localAttributionIdentifiers.attributionId = paramContext.getString(i);
        if ((j > 0) && (k > 0))
        {
          localObject1 = paramContext;
          localObject2 = paramContext;
          if (localAttributionIdentifiers.getAndroidAdvertiserId() == null)
          {
            localObject1 = paramContext;
            localObject2 = paramContext;
            localAttributionIdentifiers.androidAdvertiserId = paramContext.getString(j);
            localObject1 = paramContext;
            localObject2 = paramContext;
            localAttributionIdentifiers.limitTracking = Boolean.parseBoolean(paramContext.getString(k));
          }
        }
        if (paramContext != null) {
          paramContext.close();
        }
        localAttributionIdentifiers.fetchTime = System.currentTimeMillis();
        recentlyFetchedIdentifiers = localAttributionIdentifiers;
        return localAttributionIdentifiers;
      }
      catch (Exception paramContext)
      {
        localObject2 = localObject1;
        Log.d(TAG, "Caught unexpected exception in getAttributionId(): " + paramContext.toString());
        return null;
      }
      finally
      {
        if (localObject2 != null) {
          ((Cursor)localObject2).close();
        }
      }
    }
  }
  
  public String getAndroidAdvertiserId()
  {
    return this.androidAdvertiserId;
  }
  
  public String getAttributionId()
  {
    return this.attributionId;
  }
  
  public boolean isTrackingLimited()
  {
    return this.limitTracking;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/facebook/internal/AttributionIdentifiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */