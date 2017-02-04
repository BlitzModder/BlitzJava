package com.google.android.gms.gcm;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.measurement.AppMeasurement;

class zza
{
  static AppMeasurement zzaIH;
  
  private static void zza(Context paramContext, String paramString, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("gcm.a.campaign");
    if (Log.isLoggable("GcmAnalytics", 3)) {
      Log.d("GcmAnalytics", "Sending event=" + paramString + " campaign=" + str);
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("nc", str);
    paramIntent = paramIntent.getStringExtra("from");
    if (!TextUtils.isEmpty(paramIntent))
    {
      if (!paramIntent.startsWith("/topics/")) {
        break label118;
      }
      localBundle.putString("nt", paramIntent);
    }
    try
    {
      if (zzaIH == null) {}
      for (paramContext = AppMeasurement.getInstance(paramContext);; paramContext = zzaIH)
      {
        paramContext.zzd("gcm", paramString, localBundle);
        return;
        try
        {
          label118:
          Long.parseLong(paramIntent);
          localBundle.putString("nsid", paramIntent);
        }
        catch (NumberFormatException localNumberFormatException)
        {
          Log.d("GcmAnalytics", "Unrecognised from address: " + paramIntent);
        }
        break;
      }
      return;
    }
    catch (NoClassDefFoundError paramContext)
    {
      Log.e("GcmAnalytics", "Unable to log event, missing GMS measurement library");
    }
  }
  
  public static void zze(Context paramContext, Intent paramIntent)
  {
    zza(paramContext, "_nr", paramIntent);
  }
  
  public static void zzf(Context paramContext, Intent paramIntent)
  {
    zza(paramContext, "_no", paramIntent);
  }
  
  public static void zzg(Context paramContext, Intent paramIntent)
  {
    zza(paramContext, "_nd", paramIntent);
  }
  
  public static void zzh(Context paramContext, Intent paramIntent)
  {
    zza(paramContext, "_nf", paramIntent);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/gcm/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */