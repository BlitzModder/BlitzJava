package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzha;
import com.google.android.gms.internal.zzip;

@zzha
public class zza
{
  public boolean zza(Context paramContext, AdLauncherIntentInfoParcel paramAdLauncherIntentInfoParcel, zzn paramzzn)
  {
    if (paramAdLauncherIntentInfoParcel == null)
    {
      zzb.zzaH("No intent data for launcher overlay.");
      return false;
    }
    Intent localIntent = new Intent();
    if (TextUtils.isEmpty(paramAdLauncherIntentInfoParcel.url))
    {
      zzb.zzaH("Open GMSG did not contain a URL.");
      return false;
    }
    if (!TextUtils.isEmpty(paramAdLauncherIntentInfoParcel.mimeType)) {
      localIntent.setDataAndType(Uri.parse(paramAdLauncherIntentInfoParcel.url), paramAdLauncherIntentInfoParcel.mimeType);
    }
    String[] arrayOfString;
    for (;;)
    {
      localIntent.setAction("android.intent.action.VIEW");
      if (!TextUtils.isEmpty(paramAdLauncherIntentInfoParcel.packageName)) {
        localIntent.setPackage(paramAdLauncherIntentInfoParcel.packageName);
      }
      if (TextUtils.isEmpty(paramAdLauncherIntentInfoParcel.zzCK)) {
        break label178;
      }
      arrayOfString = paramAdLauncherIntentInfoParcel.zzCK.split("/", 2);
      if (arrayOfString.length >= 2) {
        break;
      }
      zzb.zzaH("Could not parse component name from open GMSG: " + paramAdLauncherIntentInfoParcel.zzCK);
      return false;
      localIntent.setData(Uri.parse(paramAdLauncherIntentInfoParcel.url));
    }
    localIntent.setClassName(arrayOfString[0], arrayOfString[1]);
    label178:
    paramAdLauncherIntentInfoParcel = paramAdLauncherIntentInfoParcel.zzCL;
    if (!TextUtils.isEmpty(paramAdLauncherIntentInfoParcel)) {}
    try
    {
      i = Integer.parseInt(paramAdLauncherIntentInfoParcel);
      localIntent.addFlags(i);
    }
    catch (NumberFormatException paramAdLauncherIntentInfoParcel)
    {
      for (;;)
      {
        try
        {
          zzb.v("Launching an intent: " + localIntent.toURI());
          zzp.zzbx().zzb(paramContext, localIntent);
          if (paramzzn != null) {
            paramzzn.zzaQ();
          }
          return true;
        }
        catch (ActivityNotFoundException paramContext)
        {
          int i;
          zzb.zzaH(paramContext.getMessage());
        }
        paramAdLauncherIntentInfoParcel = paramAdLauncherIntentInfoParcel;
        zzb.zzaH("Could not parse intent flags.");
        i = 0;
      }
    }
    return false;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/overlay/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */