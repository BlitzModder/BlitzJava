package com.facebook;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.model.GraphObject;
import com.facebook.model.GraphObject.Factory;
import java.util.Iterator;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppLinkData
{
  private static final String APPLINK_BRIDGE_ARGS_KEY = "bridge_args";
  private static final String APPLINK_METHOD_ARGS_KEY = "method_args";
  private static final String APPLINK_VERSION_KEY = "version";
  public static final String ARGUMENTS_NATIVE_CLASS_KEY = "com.facebook.platform.APPLINK_NATIVE_CLASS";
  public static final String ARGUMENTS_NATIVE_URL = "com.facebook.platform.APPLINK_NATIVE_URL";
  public static final String ARGUMENTS_REFERER_DATA_KEY = "referer_data";
  public static final String ARGUMENTS_TAPTIME_KEY = "com.facebook.platform.APPLINK_TAP_TIME_UTC";
  private static final String BRIDGE_ARGS_METHOD_KEY = "method";
  private static final String BUNDLE_AL_APPLINK_DATA_KEY = "al_applink_data";
  static final String BUNDLE_APPLINK_ARGS_KEY = "com.facebook.platform.APPLINK_ARGS";
  private static final String DEFERRED_APP_LINK_ARGS_FIELD = "applink_args";
  private static final String DEFERRED_APP_LINK_CLASS_FIELD = "applink_class";
  private static final String DEFERRED_APP_LINK_CLICK_TIME_FIELD = "click_time";
  private static final String DEFERRED_APP_LINK_EVENT = "DEFERRED_APP_LINK";
  private static final String DEFERRED_APP_LINK_PATH = "%s/activities";
  private static final String DEFERRED_APP_LINK_URL_FIELD = "applink_url";
  private static final String METHOD_ARGS_REF_KEY = "ref";
  private static final String METHOD_ARGS_TARGET_URL_KEY = "target_url";
  private static final String REFERER_DATA_REF_KEY = "fb_ref";
  private static final String TAG = AppLinkData.class.getCanonicalName();
  private Bundle argumentBundle;
  private JSONObject arguments;
  private String ref;
  private Uri targetUri;
  
  public static AppLinkData createFromActivity(Activity paramActivity)
  {
    Validate.notNull(paramActivity, "activity");
    Intent localIntent = paramActivity.getIntent();
    Object localObject;
    if (localIntent == null) {
      localObject = null;
    }
    do
    {
      return (AppLinkData)localObject;
      localObject = createFromAlApplinkData(localIntent);
      paramActivity = (Activity)localObject;
      if (localObject == null) {
        paramActivity = createFromJson(localIntent.getStringExtra("com.facebook.platform.APPLINK_ARGS"));
      }
      localObject = paramActivity;
    } while (paramActivity != null);
    return createFromUri(localIntent.getData());
  }
  
  private static AppLinkData createFromAlApplinkData(Intent paramIntent)
  {
    Bundle localBundle = paramIntent.getBundleExtra("al_applink_data");
    if (localBundle == null) {
      paramIntent = null;
    }
    AppLinkData localAppLinkData;
    do
    {
      return paramIntent;
      localAppLinkData = new AppLinkData();
      localAppLinkData.targetUri = paramIntent.getData();
      if (localAppLinkData.targetUri == null)
      {
        paramIntent = localBundle.getString("target_url");
        if (paramIntent != null) {
          localAppLinkData.targetUri = Uri.parse(paramIntent);
        }
      }
      localAppLinkData.argumentBundle = localBundle;
      localAppLinkData.arguments = null;
      localBundle = localBundle.getBundle("referer_data");
      paramIntent = localAppLinkData;
    } while (localBundle == null);
    localAppLinkData.ref = localBundle.getString("fb_ref");
    return localAppLinkData;
  }
  
  private static AppLinkData createFromJson(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      localObject = paramString.getString("version");
      if ((paramString.getJSONObject("bridge_args").getString("method").equals("applink")) && (((String)localObject).equals("2")))
      {
        localObject = new AppLinkData();
        ((AppLinkData)localObject).arguments = paramString.getJSONObject("method_args");
        if (!((AppLinkData)localObject).arguments.has("ref")) {
          break label147;
        }
        ((AppLinkData)localObject).ref = ((AppLinkData)localObject).arguments.getString("ref");
        if (((AppLinkData)localObject).arguments.has("target_url")) {
          ((AppLinkData)localObject).targetUri = Uri.parse(((AppLinkData)localObject).arguments.getString("target_url"));
        }
        ((AppLinkData)localObject).argumentBundle = toBundle(((AppLinkData)localObject).arguments);
        return (AppLinkData)localObject;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        Object localObject;
        Log.d(TAG, "Unable to parse AppLink JSON", paramString);
        return null;
        if (((AppLinkData)localObject).arguments.has("referer_data"))
        {
          paramString = ((AppLinkData)localObject).arguments.getJSONObject("referer_data");
          if (paramString.has("fb_ref")) {
            ((AppLinkData)localObject).ref = paramString.getString("fb_ref");
          }
        }
      }
    }
    catch (FacebookException paramString)
    {
      for (;;)
      {
        label147:
        Log.d(TAG, "Unable to parse AppLink JSON", paramString);
      }
    }
  }
  
  private static AppLinkData createFromUri(Uri paramUri)
  {
    if (paramUri == null) {
      return null;
    }
    AppLinkData localAppLinkData = new AppLinkData();
    localAppLinkData.targetUri = paramUri;
    return localAppLinkData;
  }
  
  public static void fetchDeferredAppLinkData(Context paramContext, CompletionHandler paramCompletionHandler)
  {
    fetchDeferredAppLinkData(paramContext, null, paramCompletionHandler);
  }
  
  public static void fetchDeferredAppLinkData(Context paramContext, String paramString, final CompletionHandler paramCompletionHandler)
  {
    Validate.notNull(paramContext, "context");
    Validate.notNull(paramCompletionHandler, "completionHandler");
    final String str = paramString;
    if (paramString == null) {
      str = Utility.getMetadataApplicationId(paramContext);
    }
    Validate.notNull(str, "applicationId");
    paramContext = paramContext.getApplicationContext();
    Settings.getExecutor().execute(new Runnable()
    {
      public void run()
      {
        AppLinkData.fetchDeferredAppLinkFromServer(this.val$applicationContext, str, paramCompletionHandler);
      }
    });
  }
  
  private static void fetchDeferredAppLinkFromServer(Context paramContext, String paramString, CompletionHandler paramCompletionHandler)
  {
    localObject1 = GraphObject.Factory.create();
    ((GraphObject)localObject1).setProperty("event", "DEFERRED_APP_LINK");
    Utility.setAppEventAttributionParameters((GraphObject)localObject1, AttributionIdentifiers.getAttributionIdentifiers(paramContext), AppEventsLogger.getAnonymousAppDeviceGUID(paramContext), Settings.getLimitEventAndDataUsage(paramContext));
    ((GraphObject)localObject1).setProperty("application_package_name", paramContext.getPackageName());
    paramString = String.format("%s/activities", new Object[] { paramString });
    Object localObject3 = null;
    Object localObject2 = null;
    paramContext = (Context)localObject3;
    for (;;)
    {
      try
      {
        paramString = Request.newPostRequest(null, paramString, (GraphObject)localObject1, null).executeAndWait().getGraphObject();
        if (paramString != null)
        {
          paramContext = (Context)localObject3;
          localObject1 = paramString.getInnerJSONObject();
          paramString = (String)localObject2;
          if (localObject1 != null)
          {
            paramContext = (Context)localObject3;
            String str3 = ((JSONObject)localObject1).optString("applink_args");
            paramContext = (Context)localObject3;
            l = ((JSONObject)localObject1).optLong("click_time", -1L);
            paramContext = (Context)localObject3;
            str1 = ((JSONObject)localObject1).optString("applink_class");
            paramContext = (Context)localObject3;
            str2 = ((JSONObject)localObject1).optString("applink_url");
            paramString = (String)localObject2;
            paramContext = (Context)localObject3;
            if (!TextUtils.isEmpty(str3))
            {
              paramContext = (Context)localObject3;
              localObject1 = createFromJson(str3);
              if (l != -1L) {
                paramContext = (Context)localObject1;
              }
            }
          }
        }
      }
      catch (Exception paramString)
      {
        long l;
        String str1;
        String str2;
        Utility.logd(TAG, "Unable to fetch deferred applink from server");
        paramString = paramContext;
        continue;
      }
      try
      {
        if (((AppLinkData)localObject1).arguments != null)
        {
          paramContext = (Context)localObject1;
          ((AppLinkData)localObject1).arguments.put("com.facebook.platform.APPLINK_TAP_TIME_UTC", l);
        }
        paramContext = (Context)localObject1;
        if (((AppLinkData)localObject1).argumentBundle != null)
        {
          paramContext = (Context)localObject1;
          ((AppLinkData)localObject1).argumentBundle.putString("com.facebook.platform.APPLINK_TAP_TIME_UTC", Long.toString(l));
        }
      }
      catch (JSONException paramContext)
      {
        paramContext = (Context)localObject1;
        Log.d(TAG, "Unable to put tap time in AppLinkData.arguments");
        continue;
      }
      if (str1 != null) {
        paramContext = (Context)localObject1;
      }
      try
      {
        if (((AppLinkData)localObject1).arguments != null)
        {
          paramContext = (Context)localObject1;
          ((AppLinkData)localObject1).arguments.put("com.facebook.platform.APPLINK_NATIVE_CLASS", str1);
        }
        paramContext = (Context)localObject1;
        if (((AppLinkData)localObject1).argumentBundle != null)
        {
          paramContext = (Context)localObject1;
          ((AppLinkData)localObject1).argumentBundle.putString("com.facebook.platform.APPLINK_NATIVE_CLASS", str1);
        }
      }
      catch (JSONException paramContext)
      {
        paramContext = (Context)localObject1;
        Log.d(TAG, "Unable to put tap time in AppLinkData.arguments");
        continue;
      }
      paramString = (String)localObject1;
      if (str2 != null) {
        paramContext = (Context)localObject1;
      }
      try
      {
        if (((AppLinkData)localObject1).arguments != null)
        {
          paramContext = (Context)localObject1;
          ((AppLinkData)localObject1).arguments.put("com.facebook.platform.APPLINK_NATIVE_URL", str2);
        }
        paramString = (String)localObject1;
        paramContext = (Context)localObject1;
        if (((AppLinkData)localObject1).argumentBundle != null)
        {
          paramContext = (Context)localObject1;
          ((AppLinkData)localObject1).argumentBundle.putString("com.facebook.platform.APPLINK_NATIVE_URL", str2);
          paramString = (String)localObject1;
        }
      }
      catch (JSONException paramContext)
      {
        paramContext = (Context)localObject1;
        Log.d(TAG, "Unable to put tap time in AppLinkData.arguments");
        paramString = (String)localObject1;
        continue;
      }
      paramCompletionHandler.onDeferredAppLinkDataFetched(paramString);
      return;
      localObject1 = null;
    }
  }
  
  private static Bundle toBundle(JSONObject paramJSONObject)
    throws JSONException
  {
    Bundle localBundle = new Bundle();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject1 = paramJSONObject.get(str);
      if ((localObject1 instanceof JSONObject))
      {
        localBundle.putBundle(str, toBundle((JSONObject)localObject1));
      }
      else if ((localObject1 instanceof JSONArray))
      {
        localObject1 = (JSONArray)localObject1;
        if (((JSONArray)localObject1).length() == 0)
        {
          localBundle.putStringArray(str, new String[0]);
        }
        else
        {
          Object localObject2 = ((JSONArray)localObject1).get(0);
          int i;
          if ((localObject2 instanceof JSONObject))
          {
            localObject2 = new Bundle[((JSONArray)localObject1).length()];
            i = 0;
            while (i < ((JSONArray)localObject1).length())
            {
              localObject2[i] = toBundle(((JSONArray)localObject1).getJSONObject(i));
              i += 1;
            }
            localBundle.putParcelableArray(str, (Parcelable[])localObject2);
          }
          else
          {
            if ((localObject2 instanceof JSONArray)) {
              throw new FacebookException("Nested arrays are not supported.");
            }
            localObject2 = new String[((JSONArray)localObject1).length()];
            i = 0;
            while (i < ((JSONArray)localObject1).length())
            {
              localObject2[i] = ((JSONArray)localObject1).get(i).toString();
              i += 1;
            }
            localBundle.putStringArray(str, (String[])localObject2);
          }
        }
      }
      else
      {
        localBundle.putString(str, localObject1.toString());
      }
    }
    return localBundle;
  }
  
  public Bundle getArgumentBundle()
  {
    return this.argumentBundle;
  }
  
  @Deprecated
  public JSONObject getArguments()
  {
    return this.arguments;
  }
  
  public String getRef()
  {
    return this.ref;
  }
  
  public Bundle getRefererData()
  {
    if (this.argumentBundle != null) {
      return this.argumentBundle.getBundle("referer_data");
    }
    return null;
  }
  
  public Uri getTargetUri()
  {
    return this.targetUri;
  }
  
  public static abstract interface CompletionHandler
  {
    public abstract void onDeferredAppLinkDataFetched(AppLinkData paramAppLinkData);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/facebook/AppLinkData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */