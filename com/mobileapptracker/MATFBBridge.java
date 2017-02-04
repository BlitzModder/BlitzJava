package com.mobileapptracker;

import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.Method;
import java.util.Locale;

class MATFBBridge
{
  public static final String EVENT_NAME_ACHIEVED_LEVEL = "fb_mobile_level_achieved";
  public static final String EVENT_NAME_ACTIVATED_APP = "fb_mobile_activate_app";
  public static final String EVENT_NAME_ADDED_PAYMENT_INFO = "fb_mobile_add_payment_info";
  public static final String EVENT_NAME_ADDED_TO_CART = "fb_mobile_add_to_cart";
  public static final String EVENT_NAME_ADDED_TO_WISHLIST = "fb_mobile_add_to_wishlist";
  public static final String EVENT_NAME_COMPLETED_REGISTRATION = "fb_mobile_complete_registration";
  public static final String EVENT_NAME_COMPLETED_TUTORIAL = "fb_mobile_tutorial_completion";
  public static final String EVENT_NAME_INITIATED_CHECKOUT = "fb_mobile_initiated_checkout";
  public static final String EVENT_NAME_PURCHASED = "fb_mobile_purchase";
  public static final String EVENT_NAME_RATED = "fb_mobile_rate";
  public static final String EVENT_NAME_SEARCHED = "fb_mobile_search";
  public static final String EVENT_NAME_SPENT_CREDITS = "fb_mobile_spent_credits";
  public static final String EVENT_NAME_UNLOCKED_ACHIEVEMENT = "fb_mobile_achievement_unlocked";
  public static final String EVENT_NAME_VIEWED_CONTENT = "fb_mobile_content_view";
  public static final String EVENT_PARAM_CONTENT_ID = "fb_content_id";
  public static final String EVENT_PARAM_CONTENT_TYPE = "fb_content_type";
  public static final String EVENT_PARAM_CURRENCY = "fb_currency";
  public static final String EVENT_PARAM_LEVEL = "fb_level";
  public static final String EVENT_PARAM_NUM_ITEMS = "fb_num_items";
  public static final String EVENT_PARAM_SEARCH_STRING = "fb_search_string";
  public static final String EVENT_PARAM_SOURCE_APPLICATION = "fb_mobile_launch_source";
  private static boolean justActivated = false;
  private static Object logger;
  
  private static void addBundleValue(Bundle paramBundle, String paramString1, String paramString2)
  {
    if (paramString2 != null) {
      paramBundle.putString(paramString1, paramString2);
    }
  }
  
  public static void logEvent(MATEvent paramMATEvent)
  {
    if (logger != null) {}
    for (;;)
    {
      Object localObject2;
      double d2;
      try
      {
        localObject2 = Double.TYPE;
        localMethod = logger.getClass().getMethod("logEvent", new Class[] { String.class, localObject2, Bundle.class });
        localObject2 = paramMATEvent.getEventName();
        d2 = paramMATEvent.getRevenue();
        localMATParameters = MATParameters.getInstance();
        localObject3 = paramMATEvent.getEventName().toLowerCase(Locale.US);
        if (!((String)localObject3).contains("session")) {
          break label231;
        }
        if (!justActivated) {
          break label506;
        }
        return;
      }
      catch (Exception paramMATEvent)
      {
        Method localMethod;
        MATParameters localMATParameters;
        Object localObject1;
        paramMATEvent.printStackTrace();
        return;
      }
      Object localObject3 = new Bundle();
      addBundleValue((Bundle)localObject3, "fb_currency", paramMATEvent.getCurrencyCode());
      addBundleValue((Bundle)localObject3, "fb_content_id", paramMATEvent.getContentId());
      addBundleValue((Bundle)localObject3, "fb_content_type", paramMATEvent.getContentType());
      addBundleValue((Bundle)localObject3, "fb_search_string", paramMATEvent.getSearchString());
      addBundleValue((Bundle)localObject3, "fb_num_items", Integer.toString(paramMATEvent.getQuantity()));
      addBundleValue((Bundle)localObject3, "fb_level", Integer.toString(paramMATEvent.getLevel()));
      addBundleValue((Bundle)localObject3, "tune_referral_source", localMATParameters.getReferralSource());
      addBundleValue((Bundle)localObject3, "tune_source_sdk", "TUNE-MAT");
      localMethod.invoke(logger, new Object[] { localObject2, Double.valueOf(localObject1), localObject3 });
      justActivated = false;
      return;
      label231:
      double d1;
      if (((String)localObject3).contains("registration"))
      {
        localObject2 = "fb_mobile_complete_registration";
        d1 = d2;
      }
      else if (((String)localObject3).contains("content_view"))
      {
        localObject2 = "fb_mobile_content_view";
        d1 = d2;
      }
      else if (((String)localObject3).contains("search"))
      {
        localObject2 = "fb_mobile_search";
        d1 = d2;
      }
      else
      {
        if (((String)localObject3).contains("rated")) {
          localObject2 = "fb_mobile_rate";
        }
        try
        {
          d1 = paramMATEvent.getRating();
          continue;
          if (((String)localObject3).contains("tutorial_complete"))
          {
            localObject2 = "fb_mobile_tutorial_completion";
            d1 = d2;
            continue;
          }
          if (((String)localObject3).contains("add_to_cart"))
          {
            localObject2 = "fb_mobile_add_to_cart";
            d1 = d2;
            continue;
          }
          if (((String)localObject3).contains("add_to_wishlist"))
          {
            localObject2 = "fb_mobile_add_to_wishlist";
            d1 = d2;
            continue;
          }
          if (((String)localObject3).contains("checkout_initiated"))
          {
            localObject2 = "fb_mobile_initiated_checkout";
            d1 = d2;
            continue;
          }
          if (((String)localObject3).contains("added_payment_info"))
          {
            localObject2 = "fb_mobile_add_payment_info";
            d1 = d2;
            continue;
          }
          if (((String)localObject3).contains("purchase"))
          {
            localObject2 = "fb_mobile_purchase";
            d1 = d2;
            continue;
          }
          if (((String)localObject3).contains("level_achieved"))
          {
            localObject2 = "fb_mobile_level_achieved";
            d1 = d2;
            continue;
          }
          if (((String)localObject3).contains("achievement_unlocked"))
          {
            localObject2 = "fb_mobile_achievement_unlocked";
            d1 = d2;
            continue;
          }
          d1 = d2;
          if (!((String)localObject3).contains("spent_credits")) {
            continue;
          }
          localObject2 = "fb_mobile_spent_credits";
        }
        catch (Exception localException1)
        {
          try
          {
            int i = paramMATEvent.getQuantity();
            d1 = i;
          }
          catch (Exception localException2)
          {
            d1 = d2;
          }
          localException1 = localException1;
          d1 = d2;
        }
        continue;
        continue;
        return;
        label506:
        localObject2 = "fb_mobile_activate_app";
        d1 = d2;
      }
    }
  }
  
  public static void startLogger(Context paramContext, boolean paramBoolean)
  {
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Context.class;
      Class localClass = Boolean.TYPE;
      Method localMethod = Class.forName("com.facebook.appevents.AppEventsLogger").getMethod("activateApp", arrayOfClass);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = paramContext;
      localMethod.invoke(null, arrayOfObject);
      justActivated = true;
      Class.forName("com.facebook.FacebookSdk").getMethod("setLimitEventAndDataUsage", new Class[] { Context.class, localClass }).invoke(null, new Object[] { paramContext, Boolean.valueOf(paramBoolean) });
      logger = Class.forName("com.facebook.appevents.AppEventsLogger").getMethod("newLogger", arrayOfClass).invoke(null, arrayOfObject);
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/mobileapptracker/MATFBBridge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */