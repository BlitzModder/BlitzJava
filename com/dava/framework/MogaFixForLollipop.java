package com.dava.framework;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import com.bda.controller.Controller;
import com.bda.controller.IControllerService;
import java.lang.reflect.Field;
import java.util.List;

public class MogaFixForLollipop
{
  public static void init(Controller paramController, Context paramContext)
  {
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool1 = false;
    Object localObject8 = null;
    Object localObject9 = null;
    Field localField = null;
    Object localObject7 = null;
    Object localObject4 = localField;
    boolean bool2 = bool1;
    Object localObject5 = localObject8;
    boolean bool3 = bool5;
    Object localObject6 = localObject9;
    boolean bool4 = bool6;
    try
    {
      Class localClass = paramController.getClass();
      localObject4 = localField;
      bool2 = bool1;
      localObject5 = localObject8;
      bool3 = bool5;
      localObject6 = localObject9;
      bool4 = bool6;
      localField = localClass.getDeclaredField("mIsBound");
      localObject4 = localField;
      bool2 = bool1;
      localObject5 = localField;
      bool3 = bool5;
      localObject6 = localField;
      bool4 = bool6;
      localField.setAccessible(true);
      localObject4 = localField;
      bool2 = bool1;
      localObject5 = localField;
      bool3 = bool5;
      localObject6 = localField;
      bool4 = bool6;
      bool1 = localField.getBoolean(paramController);
      localObject4 = localField;
      bool2 = bool1;
      localObject5 = localField;
      bool3 = bool1;
      localObject6 = localField;
      bool4 = bool1;
      localObject8 = localClass.getDeclaredField("mServiceConnection");
      localObject4 = localField;
      bool2 = bool1;
      localObject5 = localField;
      bool3 = bool1;
      localObject6 = localField;
      bool4 = bool1;
      ((Field)localObject8).setAccessible(true);
      localObject4 = localField;
      bool2 = bool1;
      localObject5 = localField;
      bool3 = bool1;
      localObject6 = localField;
      bool4 = bool1;
      localObject8 = (ServiceConnection)((Field)localObject8).get(paramController);
      localObject4 = localObject8;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        Log.e("SuperMogaHack", "Lollipop Hack NoSuchFieldException (get)", localNoSuchFieldException);
        Object localObject1 = localObject4;
        bool1 = bool2;
        localObject4 = localObject7;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Log.e("SuperMogaHack", "Lollipop Hack IllegalAccessException (get)", localIllegalAccessException);
        Object localObject2 = localObject5;
        bool1 = bool3;
        localObject4 = localObject7;
      }
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      Object localObject3;
      for (;;)
      {
        Log.e("SuperMogaHack", "Lollipop Hack IllegalArgumentException (get)", localIllegalArgumentException);
        localObject3 = localObject6;
        bool1 = bool4;
        localObject4 = localObject7;
      }
      localObject6 = ((ResolveInfo)((List)localObject6).get(0)).serviceInfo;
      ((Intent)localObject5).setComponent(new ComponentName(((ServiceInfo)localObject6).packageName, ((ServiceInfo)localObject6).name));
      paramContext.startService((Intent)localObject5);
      paramContext.bindService((Intent)localObject5, (ServiceConnection)localObject4, 1);
      try
      {
        ((Field)localObject3).setBoolean(paramController, true);
        return;
      }
      catch (IllegalAccessException paramController)
      {
        Log.e("SuperMogaHack", "Lollipop Hack IllegalAccessException (set)", paramController);
        return;
      }
      catch (IllegalArgumentException paramController)
      {
        Log.e("SuperMogaHack", "Lollipop Hack IllegalArgumentException (set)", paramController);
      }
    }
    if ((!bool1) && (localObject4 != null))
    {
      localObject5 = new Intent(IControllerService.class.getName());
      localObject6 = paramContext.getPackageManager().queryIntentServices((Intent)localObject5, 0);
      if ((localObject6 == null) || (((List)localObject6).size() != 1)) {
        Log.e("SuperMogaHack", "Somebody is trying to intercept our intent. Disabling MOGA controller for security.");
      }
    }
    else
    {
      return;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/MogaFixForLollipop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */