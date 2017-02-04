package com.google.android.gms.gcm;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.iid.InstanceID;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GcmPubSub
{
  private static GcmPubSub zzaIQ;
  private static final Pattern zzaIS = Pattern.compile("/topics/[a-zA-Z0-9-_.~%]{1,900}");
  private InstanceID zzaIR;
  
  private GcmPubSub(Context paramContext)
  {
    this.zzaIR = InstanceID.getInstance(paramContext);
  }
  
  public static GcmPubSub getInstance(Context paramContext)
  {
    try
    {
      if (zzaIQ == null) {
        zzaIQ = new GcmPubSub(paramContext);
      }
      paramContext = zzaIQ;
      return paramContext;
    }
    finally {}
  }
  
  public void subscribe(String paramString1, String paramString2, Bundle paramBundle)
    throws IOException
  {
    if ((paramString1 == null) || (paramString1.isEmpty())) {
      throw new IllegalArgumentException("Invalid appInstanceToken: " + paramString1);
    }
    if ((paramString2 == null) || (!zzaIS.matcher(paramString2).matches())) {
      throw new IllegalArgumentException("Invalid topic name: " + paramString2);
    }
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("gcm.topic", paramString2);
    this.zzaIR.getToken(paramString1, paramString2, localBundle);
  }
  
  public void unsubscribe(String paramString1, String paramString2)
    throws IOException
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("gcm.topic", paramString2);
    this.zzaIR.zzb(paramString1, paramString2, localBundle);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/gcm/GcmPubSub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */