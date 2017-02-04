package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;

public final class zzcc
{
  public static IntentFilter zza(String paramString, Uri paramUri, int paramInt)
  {
    paramString = new IntentFilter(paramString);
    if (paramUri.getScheme() != null) {
      paramString.addDataScheme(paramUri.getScheme());
    }
    if (paramUri.getAuthority() != null) {
      paramString.addDataAuthority(paramUri.getAuthority(), Integer.toString(paramUri.getPort()));
    }
    if (paramUri.getPath() != null) {
      paramString.addDataPath(paramUri.getPath(), paramInt);
    }
    return paramString;
  }
  
  public static IntentFilter zzfY(String paramString)
  {
    paramString = new IntentFilter(paramString);
    paramString.addDataScheme("wear");
    paramString.addDataAuthority("*", null);
    return paramString;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzcc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */