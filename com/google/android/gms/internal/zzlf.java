package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.IdpTokenType;
import com.google.android.gms.auth.api.signin.zze;
import com.google.android.gms.common.internal.zzx;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class zzlf
  extends zzle
{
  public static final List<String> zzWA = Collections.singletonList("email");
  private Class<?> zzWB;
  private Class<?> zzWC;
  private Object zzWD;
  private Object zzWE;
  
  public zzlf(Activity paramActivity, List<String> paramList)
  {
    super(paramActivity, zzWA, paramList);
  }
  
  /* Error */
  public static void zzag(Context paramContext)
    throws java.lang.IllegalStateException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 66	com/google/android/gms/common/internal/zzx:zzy	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: ldc 68
    //   7: invokestatic 74	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   10: astore_1
    //   11: aload_1
    //   12: ldc 76
    //   14: iconst_2
    //   15: anewarray 70	java/lang/Class
    //   18: dup
    //   19: iconst_0
    //   20: ldc 78
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: getstatic 83	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   28: aastore
    //   29: invokevirtual 87	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   32: aconst_null
    //   33: iconst_2
    //   34: anewarray 89	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: aload_0
    //   40: invokevirtual 93	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: ldc 94
    //   48: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   51: aastore
    //   52: invokevirtual 104	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   55: pop
    //   56: ldc 106
    //   58: invokestatic 74	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   61: astore_0
    //   62: aload_0
    //   63: ldc 108
    //   65: iconst_0
    //   66: anewarray 70	java/lang/Class
    //   69: invokevirtual 87	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   72: aconst_null
    //   73: iconst_0
    //   74: anewarray 89	java/lang/Object
    //   77: invokevirtual 104	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   80: astore_1
    //   81: aload_0
    //   82: ldc 110
    //   84: iconst_0
    //   85: anewarray 70	java/lang/Class
    //   88: invokevirtual 87	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   91: aload_1
    //   92: iconst_0
    //   93: anewarray 89	java/lang/Object
    //   96: invokevirtual 104	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   99: pop
    //   100: return
    //   101: astore_0
    //   102: ldc 112
    //   104: ldc 114
    //   106: aload_0
    //   107: invokestatic 120	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   110: pop
    //   111: new 52	java/lang/IllegalStateException
    //   114: dup
    //   115: ldc 122
    //   117: invokespecial 125	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   120: athrow
    //   121: astore_0
    //   122: ldc 127
    //   124: invokestatic 74	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   127: astore_0
    //   128: aload_0
    //   129: ldc -127
    //   131: iconst_0
    //   132: anewarray 70	java/lang/Class
    //   135: invokevirtual 87	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   138: aconst_null
    //   139: iconst_0
    //   140: anewarray 89	java/lang/Object
    //   143: invokevirtual 104	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull -48 -> 100
    //   151: aload_0
    //   152: ldc -125
    //   154: iconst_0
    //   155: anewarray 70	java/lang/Class
    //   158: invokevirtual 87	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   161: aload_1
    //   162: iconst_0
    //   163: anewarray 89	java/lang/Object
    //   166: invokevirtual 104	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   169: pop
    //   170: return
    //   171: astore_0
    //   172: ldc 112
    //   174: ldc 114
    //   176: aload_0
    //   177: invokestatic 120	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   180: pop
    //   181: new 52	java/lang/IllegalStateException
    //   184: dup
    //   185: ldc 122
    //   187: invokespecial 125	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   190: athrow
    //   191: astore_0
    //   192: goto -20 -> 172
    //   195: astore_0
    //   196: goto -24 -> 172
    //   199: astore_0
    //   200: goto -28 -> 172
    //   203: astore_0
    //   204: goto -102 -> 102
    //   207: astore_0
    //   208: goto -106 -> 102
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	paramContext	Context
    //   10	152	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	100	101	java/lang/NoSuchMethodException
    //   5	11	121	java/lang/ClassNotFoundException
    //   11	100	121	java/lang/ClassNotFoundException
    //   102	121	121	java/lang/ClassNotFoundException
    //   122	147	171	java/lang/ClassNotFoundException
    //   151	170	171	java/lang/ClassNotFoundException
    //   122	147	191	java/lang/NoSuchMethodException
    //   151	170	191	java/lang/NoSuchMethodException
    //   122	147	195	java/lang/IllegalAccessException
    //   151	170	195	java/lang/IllegalAccessException
    //   122	147	199	java/lang/reflect/InvocationTargetException
    //   151	170	199	java/lang/reflect/InvocationTargetException
    //   11	100	203	java/lang/IllegalAccessException
    //   11	100	207	java/lang/reflect/InvocationTargetException
  }
  
  private void zzne()
    throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException
  {
    if (this.zzWE != null)
    {
      Class.forName("com.facebook.login.LoginManager").getDeclaredMethod("logInWithReadPermissions", new Class[] { Activity.class, Collection.class }).invoke(this.zzWE, new Object[] { this.mActivity, new ArrayList(zznb()) });
      return;
    }
    Class localClass1 = Class.forName("com.facebook.Session$OpenRequest");
    Object localObject1 = localClass1.getConstructor(new Class[] { Activity.class }).newInstance(new Object[] { this.mActivity });
    localClass1.getDeclaredMethod("setPermissions", new Class[] { List.class }).invoke(localObject1, new Object[] { new ArrayList(zznb()) });
    localClass1.getDeclaredMethod("setRequestCode", new Class[] { Integer.TYPE }).invoke(localObject1, new Object[] { Integer.valueOf(64206) });
    Class localClass2 = Class.forName("com.facebook.Session");
    localClass1.getDeclaredMethod("setCallback", new Class[] { Class.forName("com.facebook.Session$StatusCallback") }).invoke(localObject1, new Object[] { zzng() });
    Object localObject2 = localClass2.getConstructor(new Class[] { Context.class }).newInstance(new Object[] { this.mActivity });
    localClass2.getDeclaredMethod("setActiveSession", new Class[] { localClass2 }).invoke(null, new Object[] { localObject2 });
    localClass2.getDeclaredMethod("openForRead", new Class[] { localClass1 }).invoke(localObject2, new Object[] { localObject1 });
  }
  
  private Object zznf()
    throws ClassNotFoundException
  {
    Class localClass = Class.forName("com.facebook.FacebookCallback");
    ClassLoader localClassLoader = localClass.getClassLoader();
    InvocationHandler local1 = new InvocationHandler()
    {
      public Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
        throws Throwable
      {
        paramAnonymousObject = Class.forName("com.facebook.login.LoginResult");
        Class localClass = Class.forName("com.facebook.FacebookException");
        Class[] arrayOfClass = paramAnonymousMethod.getParameterTypes();
        if ((paramAnonymousMethod.getName().equals("onSuccess")) && (arrayOfClass.length == 1) && (paramAnonymousArrayOfObject[0].getClass() == paramAnonymousObject))
        {
          paramAnonymousObject = ((Class)paramAnonymousObject).getDeclaredMethod("getAccessToken", new Class[0]).invoke(paramAnonymousArrayOfObject[0], new Object[0]);
          paramAnonymousObject = (String)Class.forName("com.facebook.AccessToken").getMethod("getToken", new Class[0]).invoke(paramAnonymousObject, new Object[0]);
          zzlf.zzb(zzlf.this).zzk(zzlf.zza(zzlf.this, IdpTokenType.zzWc, (String)paramAnonymousObject, zzlf.zza(zzlf.this)));
        }
        for (;;)
        {
          return null;
          if ((paramAnonymousMethod.getName().equals("onCancel")) && (arrayOfClass.length == 0))
          {
            zzlf.zzc(zzlf.this).zzmV();
          }
          else
          {
            if ((!paramAnonymousMethod.getName().equals("onError")) || (arrayOfClass.length != 1) || (arrayOfClass[0] != localClass)) {
              break;
            }
            Log.e("AuthSignInClient", "facebook login error!", (Exception)paramAnonymousArrayOfObject[0]);
            zzlf.zzd(zzlf.this).zza((Exception)paramAnonymousArrayOfObject[0]);
          }
        }
        throw new ExceptionInInitializerError("Method not supported!");
      }
    };
    return Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, local1);
  }
  
  private Object zzng()
    throws ClassNotFoundException
  {
    final Object localObject = Class.forName("com.facebook.Session");
    Class localClass = Class.forName("com.facebook.Session$StatusCallback");
    ClassLoader localClassLoader = localClass.getClassLoader();
    localObject = new InvocationHandler()
    {
      public Object invoke(Object paramAnonymousObject, Method paramAnonymousMethod, Object[] paramAnonymousArrayOfObject)
        throws Throwable
      {
        paramAnonymousObject = Class.forName("com.facebook.SessionState");
        Class[] arrayOfClass = paramAnonymousMethod.getParameterTypes();
        if ((!paramAnonymousMethod.getName().equals("call")) || (arrayOfClass.length != 3) || (arrayOfClass[0] != localObject) || (arrayOfClass[1] != paramAnonymousObject) || (arrayOfClass[2] != Exception.class)) {
          throw new ExceptionInInitializerError("Method not supported!");
        }
        if (((Boolean)localObject.getDeclaredMethod("isOpened", new Class[0]).invoke(paramAnonymousArrayOfObject[0], new Object[0])).booleanValue())
        {
          paramAnonymousObject = (String)localObject.getDeclaredMethod("getAccessToken", new Class[0]).invoke(paramAnonymousArrayOfObject[0], new Object[0]);
          zzlf.zzf(zzlf.this).zzk(zzlf.zzb(zzlf.this, IdpTokenType.zzWc, (String)paramAnonymousObject, zzlf.zze(zzlf.this)));
        }
        return null;
      }
    };
    return Proxy.newProxyInstance(localClassLoader, new Class[] { localClass }, (InvocationHandler)localObject);
  }
  
  public void zza(zzld.zza paramzza)
  {
    zzb(null, null, (zzld.zza)zzx.zzy(paramzza));
    try
    {
      zzne();
      return;
    }
    catch (ClassNotFoundException paramzza)
    {
      throw new RuntimeException(paramzza);
    }
    catch (NoSuchMethodException paramzza)
    {
      for (;;) {}
    }
    catch (IllegalAccessException paramzza)
    {
      for (;;) {}
    }
    catch (InvocationTargetException paramzza)
    {
      for (;;) {}
    }
    catch (InstantiationException paramzza)
    {
      for (;;) {}
    }
  }
  
  public void zza(String paramString, zzld.zza paramzza)
  {
    zzb((String)zzx.zzy(paramString), null, (zzld.zza)zzx.zzy(paramzza));
    try
    {
      zzne();
      return;
    }
    catch (ClassNotFoundException paramString)
    {
      throw new RuntimeException(paramString);
    }
    catch (NoSuchMethodException paramString)
    {
      for (;;) {}
    }
    catch (IllegalAccessException paramString)
    {
      for (;;) {}
    }
    catch (InvocationTargetException paramString)
    {
      for (;;) {}
    }
    catch (InstantiationException paramString)
    {
      for (;;) {}
    }
  }
  
  public void zza(String paramString1, String paramString2, zzld.zza paramzza)
  {
    zzb((String)zzx.zzy(paramString1), (String)zzx.zzy(paramString2), (zzld.zza)zzx.zzy(paramzza));
    try
    {
      zzne();
      return;
    }
    catch (ClassNotFoundException paramString1)
    {
      throw new RuntimeException(paramString1);
    }
    catch (NoSuchMethodException paramString1)
    {
      for (;;) {}
    }
    catch (IllegalAccessException paramString1)
    {
      for (;;) {}
    }
    catch (InvocationTargetException paramString1)
    {
      for (;;) {}
    }
    catch (InstantiationException paramString1)
    {
      for (;;) {}
    }
  }
  
  public boolean zza(int paramInt1, int paramInt2, Intent paramIntent, zzld.zza paramzza)
  {
    zzb(paramzza);
    if ((paramInt1 != 64206) && (this.zzWB == null)) {
      return false;
    }
    if ((this.zzWB != null) && (this.zzWC != null) && (this.zzWD != null)) {}
    try
    {
      if (!((Boolean)this.zzWB.getDeclaredMethod("isFacebookRequestCode", new Class[] { Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(paramInt1) })).booleanValue()) {
        return false;
      }
      bool = ((Boolean)this.zzWC.getDeclaredMethod("onActivityResult", new Class[] { Integer.TYPE, Integer.TYPE, Intent.class }).invoke(this.zzWD, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent })).booleanValue();
      return bool;
    }
    catch (NoSuchMethodException paramIntent)
    {
      boolean bool;
      throw new RuntimeException(paramIntent);
      try
      {
        Object localObject = Class.forName("com.facebook.Session");
        paramzza = ((Class)localObject).getDeclaredMethod("getActiveSession", new Class[0]).invoke(null, new Object[0]);
        localObject = ((Class)localObject).getDeclaredMethod("onActivityResult", new Class[] { Activity.class, Integer.TYPE, Integer.TYPE, Intent.class });
        if (paramzza == null) {
          return false;
        }
        bool = ((Boolean)((Method)localObject).invoke(paramzza, new Object[] { this.mActivity, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent })).booleanValue();
        return bool;
      }
      catch (NoSuchMethodException paramIntent)
      {
        throw new RuntimeException(paramIntent);
      }
      catch (ClassNotFoundException paramIntent)
      {
        for (;;) {}
      }
      catch (IllegalAccessException paramIntent)
      {
        for (;;) {}
      }
      catch (InvocationTargetException paramIntent)
      {
        for (;;) {}
      }
    }
    catch (IllegalAccessException paramIntent)
    {
      for (;;) {}
    }
    catch (InvocationTargetException paramIntent)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public void zzaf(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 66	com/google/android/gms/common/internal/zzx:zzy	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_0
    //   6: ldc 68
    //   8: invokestatic 74	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   11: putfield 236	com/google/android/gms/internal/zzlf:zzWB	Ljava/lang/Class;
    //   14: aload_0
    //   15: getfield 236	com/google/android/gms/internal/zzlf:zzWB	Ljava/lang/Class;
    //   18: ldc 76
    //   20: iconst_2
    //   21: anewarray 70	java/lang/Class
    //   24: dup
    //   25: iconst_0
    //   26: ldc 78
    //   28: aastore
    //   29: dup
    //   30: iconst_1
    //   31: getstatic 83	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   34: aastore
    //   35: invokevirtual 87	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   38: aconst_null
    //   39: iconst_2
    //   40: anewarray 89	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: aload_1
    //   46: invokevirtual 93	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   49: aastore
    //   50: dup
    //   51: iconst_1
    //   52: ldc 94
    //   54: invokestatic 98	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aastore
    //   58: invokevirtual 104	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   61: pop
    //   62: aload_0
    //   63: ldc -1
    //   65: invokestatic 74	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   68: ldc_w 257
    //   71: iconst_0
    //   72: anewarray 70	java/lang/Class
    //   75: invokevirtual 87	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   78: aconst_null
    //   79: iconst_0
    //   80: anewarray 89	java/lang/Object
    //   83: invokevirtual 104	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   86: putfield 240	com/google/android/gms/internal/zzlf:zzWD	Ljava/lang/Object;
    //   89: ldc 106
    //   91: invokestatic 74	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   94: astore_1
    //   95: aload_0
    //   96: aload_1
    //   97: ldc 108
    //   99: iconst_0
    //   100: anewarray 70	java/lang/Class
    //   103: invokevirtual 87	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   106: aconst_null
    //   107: iconst_0
    //   108: anewarray 89	java/lang/Object
    //   111: invokevirtual 104	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   114: putfield 147	com/google/android/gms/internal/zzlf:zzWE	Ljava/lang/Object;
    //   117: aload_0
    //   118: ldc_w 259
    //   121: invokestatic 74	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   124: putfield 238	com/google/android/gms/internal/zzlf:zzWC	Ljava/lang/Class;
    //   127: ldc -57
    //   129: invokestatic 74	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   132: astore_2
    //   133: aload_1
    //   134: ldc_w 261
    //   137: iconst_2
    //   138: anewarray 70	java/lang/Class
    //   141: dup
    //   142: iconst_0
    //   143: aload_0
    //   144: getfield 238	com/google/android/gms/internal/zzlf:zzWC	Ljava/lang/Class;
    //   147: aastore
    //   148: dup
    //   149: iconst_1
    //   150: aload_2
    //   151: aastore
    //   152: invokevirtual 87	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   155: aload_0
    //   156: getfield 147	com/google/android/gms/internal/zzlf:zzWE	Ljava/lang/Object;
    //   159: iconst_2
    //   160: anewarray 89	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: aload_0
    //   166: getfield 240	com/google/android/gms/internal/zzlf:zzWD	Ljava/lang/Object;
    //   169: aastore
    //   170: dup
    //   171: iconst_1
    //   172: aload_0
    //   173: invokespecial 263	com/google/android/gms/internal/zzlf:zznf	()Ljava/lang/Object;
    //   176: aastore
    //   177: invokevirtual 104	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   180: pop
    //   181: return
    //   182: astore_1
    //   183: ldc 127
    //   185: invokestatic 74	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   188: pop
    //   189: return
    //   190: astore_1
    //   191: new 225	java/lang/RuntimeException
    //   194: dup
    //   195: ldc_w 265
    //   198: invokespecial 266	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   201: athrow
    //   202: astore_1
    //   203: new 225	java/lang/RuntimeException
    //   206: dup
    //   207: aload_1
    //   208: invokespecial 228	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   211: athrow
    //   212: astore_1
    //   213: goto -10 -> 203
    //   216: astore_1
    //   217: goto -14 -> 203
    //   220: astore_1
    //   221: goto -18 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	zzlf
    //   0	224	1	paramContext	Context
    //   132	19	2	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   5	14	182	java/lang/ClassNotFoundException
    //   183	189	190	java/lang/ClassNotFoundException
    //   14	181	202	java/lang/NoSuchMethodException
    //   14	181	212	java/lang/ClassNotFoundException
    //   14	181	216	java/lang/IllegalAccessException
    //   14	181	220	java/lang/reflect/InvocationTargetException
  }
  
  public zze zzna()
  {
    return zze.zzVK;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzlf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */