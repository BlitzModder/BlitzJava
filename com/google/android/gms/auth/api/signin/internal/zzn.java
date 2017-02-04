package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.internal.zzx;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

public class zzn
{
  private static final Lock zzWv = new ReentrantLock();
  private static zzn zzWw;
  private final Lock zzWx = new ReentrantLock();
  private final SharedPreferences zzWy;
  
  zzn(Context paramContext)
  {
    this.zzWy = paramContext.getSharedPreferences("com.google.android.gms.signin", 0);
  }
  
  public static zzn zzae(Context paramContext)
  {
    zzx.zzy(paramContext);
    zzWv.lock();
    try
    {
      if (zzWw == null) {
        zzWw = new zzn(paramContext.getApplicationContext());
      }
      paramContext = zzWw;
      return paramContext;
    }
    finally
    {
      zzWv.unlock();
    }
  }
  
  private String zzt(String paramString1, String paramString2)
  {
    return paramString1 + ":" + paramString2;
  }
  
  void zza(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzx.zzy(paramGoogleSignInAccount);
    zzx.zzy(paramGoogleSignInOptions);
    String str = paramGoogleSignInAccount.zzmw();
    zzs(zzt("googleSignInAccount", str), paramGoogleSignInAccount.zzmx());
    zzs(zzt("googleSignInOptions", str), paramGoogleSignInOptions.zzmr());
  }
  
  void zza(SignInAccount paramSignInAccount, SignInConfiguration paramSignInConfiguration)
  {
    zzx.zzy(paramSignInAccount);
    zzx.zzy(paramSignInConfiguration);
    String str = paramSignInAccount.getUserId();
    SignInAccount localSignInAccount = zzbK(str);
    if ((localSignInAccount != null) && (localSignInAccount.zzmD() != null)) {
      zzbP(localSignInAccount.zzmD().zzmw());
    }
    zzs(zzt("signInConfiguration", str), paramSignInConfiguration.zzmr());
    zzs(zzt("signInAccount", str), paramSignInAccount.zzmr());
    if (paramSignInAccount.zzmD() != null) {
      zza(paramSignInAccount.zzmD(), paramSignInConfiguration.zzmR());
    }
  }
  
  public void zzb(GoogleSignInAccount paramGoogleSignInAccount, GoogleSignInOptions paramGoogleSignInOptions)
  {
    zzx.zzy(paramGoogleSignInAccount);
    zzx.zzy(paramGoogleSignInOptions);
    zzs("defaultGoogleSignInAccount", paramGoogleSignInAccount.zzmw());
    zza(paramGoogleSignInAccount, paramGoogleSignInOptions);
  }
  
  public void zzb(SignInAccount paramSignInAccount, SignInConfiguration paramSignInConfiguration)
  {
    zzx.zzy(paramSignInAccount);
    zzx.zzy(paramSignInConfiguration);
    zzmY();
    zzs("defaultSignInAccount", paramSignInAccount.getUserId());
    if (paramSignInAccount.zzmD() != null) {
      zzs("defaultGoogleSignInAccount", paramSignInAccount.zzmD().zzmw());
    }
    zza(paramSignInAccount, paramSignInConfiguration);
  }
  
  SignInAccount zzbK(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = zzbN(zzt("signInAccount", paramString));
    } while (TextUtils.isEmpty(paramString));
    try
    {
      paramString = SignInAccount.zzbJ(paramString);
      if (paramString.zzmD() != null)
      {
        GoogleSignInAccount localGoogleSignInAccount = zzbL(paramString.zzmD().zzmw());
        if (localGoogleSignInAccount != null) {
          paramString.zza(localGoogleSignInAccount);
        }
      }
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  GoogleSignInAccount zzbL(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = zzbN(zzt("googleSignInAccount", paramString));
    } while (paramString == null);
    try
    {
      paramString = GoogleSignInAccount.zzbE(paramString);
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  GoogleSignInOptions zzbM(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = zzbN(zzt("googleSignInOptions", paramString));
    } while (paramString == null);
    try
    {
      paramString = GoogleSignInOptions.zzbG(paramString);
      return paramString;
    }
    catch (JSONException paramString) {}
    return null;
  }
  
  protected String zzbN(String paramString)
  {
    this.zzWx.lock();
    try
    {
      paramString = this.zzWy.getString(paramString, null);
      return paramString;
    }
    finally
    {
      this.zzWx.unlock();
    }
  }
  
  void zzbO(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    SignInAccount localSignInAccount;
    do
    {
      return;
      localSignInAccount = zzbK(paramString);
      zzbQ(zzt("signInAccount", paramString));
      zzbQ(zzt("signInConfiguration", paramString));
    } while ((localSignInAccount == null) || (localSignInAccount.zzmD() == null));
    zzbP(localSignInAccount.zzmD().zzmw());
  }
  
  void zzbP(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    zzbQ(zzt("googleSignInAccount", paramString));
    zzbQ(zzt("googleSignInOptions", paramString));
  }
  
  protected void zzbQ(String paramString)
  {
    this.zzWx.lock();
    try
    {
      this.zzWy.edit().remove(paramString).apply();
      return;
    }
    finally
    {
      this.zzWx.unlock();
    }
  }
  
  public GoogleSignInAccount zzmW()
  {
    return zzbL(zzbN("defaultGoogleSignInAccount"));
  }
  
  public GoogleSignInOptions zzmX()
  {
    return zzbM(zzbN("defaultGoogleSignInAccount"));
  }
  
  public void zzmY()
  {
    String str = zzbN("defaultSignInAccount");
    zzbQ("defaultSignInAccount");
    zzmZ();
    zzbO(str);
  }
  
  public void zzmZ()
  {
    String str = zzbN("defaultGoogleSignInAccount");
    zzbQ("defaultGoogleSignInAccount");
    zzbP(str);
  }
  
  protected void zzs(String paramString1, String paramString2)
  {
    this.zzWx.lock();
    try
    {
      this.zzWy.edit().putString(paramString1, paramString2).apply();
      return;
    }
    finally
    {
      this.zzWx.unlock();
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/signin/internal/zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */