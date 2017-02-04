package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

@zzha
public class zzbr
{
  private final Context mContext;
  
  public zzbr(Context paramContext)
  {
    zzx.zzb(paramContext, "Context can not be null");
    this.mContext = paramContext;
  }
  
  public static boolean zzdh()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }
  
  public boolean zza(Intent paramIntent)
  {
    boolean bool = false;
    zzx.zzb(paramIntent, "Intent can not be null");
    if (!this.mContext.getPackageManager().queryIntentActivities(paramIntent, 0).isEmpty()) {
      bool = true;
    }
    return bool;
  }
  
  public boolean zzdd()
  {
    Intent localIntent = new Intent("android.intent.action.DIAL");
    localIntent.setData(Uri.parse("tel:"));
    return zza(localIntent);
  }
  
  public boolean zzde()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse("sms:"));
    return zza(localIntent);
  }
  
  public boolean zzdf()
  {
    return (zzdh()) && (this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0);
  }
  
  public boolean zzdg()
  {
    return true;
  }
  
  public boolean zzdi()
  {
    Intent localIntent = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event");
    return (Build.VERSION.SDK_INT >= 14) && (zza(localIntent));
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzbr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */