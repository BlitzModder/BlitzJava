package com.google.android.gms.cast.internal;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.zzx;
import java.util.Locale;

public class zzl
{
  private static boolean zzacw = false;
  protected final String mTag;
  private String zzacA;
  private final boolean zzacx;
  private boolean zzacy;
  private boolean zzacz;
  
  public zzl(String paramString)
  {
    this(paramString, zzof());
  }
  
  public zzl(String paramString, boolean paramBoolean)
  {
    zzx.zzh(paramString, "The log tag cannot be null or empty.");
    this.mTag = paramString;
    if (paramString.length() <= 23) {}
    for (boolean bool = true;; bool = false)
    {
      this.zzacx = bool;
      this.zzacy = paramBoolean;
      this.zzacz = false;
      return;
    }
  }
  
  public static boolean zzof()
  {
    return zzacw;
  }
  
  public void zzY(boolean paramBoolean)
  {
    this.zzacy = paramBoolean;
  }
  
  public void zza(String paramString, Object... paramVarArgs)
  {
    if (zzoe()) {
      Log.v(this.mTag, zzg(paramString, paramVarArgs));
    }
  }
  
  public void zzb(String paramString, Object... paramVarArgs)
  {
    if ((zzod()) || (zzacw)) {
      Log.d(this.mTag, zzg(paramString, paramVarArgs));
    }
  }
  
  public void zzb(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if ((zzod()) || (zzacw)) {
      Log.d(this.mTag, zzg(paramString, paramVarArgs), paramThrowable);
    }
  }
  
  public void zzc(String paramString, Object... paramVarArgs)
  {
    Log.e(this.mTag, zzg(paramString, paramVarArgs));
  }
  
  public void zzc(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    Log.w(this.mTag, zzg(paramString, paramVarArgs), paramThrowable);
  }
  
  public void zzch(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = null;; paramString = String.format("[%s] ", new Object[] { paramString }))
    {
      this.zzacA = paramString;
      return;
    }
  }
  
  public void zze(String paramString, Object... paramVarArgs)
  {
    Log.i(this.mTag, zzg(paramString, paramVarArgs));
  }
  
  public void zzf(String paramString, Object... paramVarArgs)
  {
    Log.w(this.mTag, zzg(paramString, paramVarArgs));
  }
  
  protected String zzg(String paramString, Object... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {}
    for (;;)
    {
      paramVarArgs = paramString;
      if (!TextUtils.isEmpty(this.zzacA)) {
        paramVarArgs = this.zzacA + paramString;
      }
      return paramVarArgs;
      paramString = String.format(Locale.ROOT, paramString, paramVarArgs);
    }
  }
  
  public boolean zzod()
  {
    return (this.zzacy) || ((this.zzacx) && (Log.isLoggable(this.mTag, 3)));
  }
  
  public boolean zzoe()
  {
    return this.zzacz;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/cast/internal/zzl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */