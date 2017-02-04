package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;

@zzha
public class zzfn
{
  private final boolean zzCp;
  private final String zzCq;
  private final zzjn zzps;
  
  public zzfn(zzjn paramzzjn, Map<String, String> paramMap)
  {
    this.zzps = paramzzjn;
    this.zzCq = ((String)paramMap.get("forceOrientation"));
    if (paramMap.containsKey("allowOrientationChange"))
    {
      this.zzCp = Boolean.parseBoolean((String)paramMap.get("allowOrientationChange"));
      return;
    }
    this.zzCp = true;
  }
  
  public void execute()
  {
    if (this.zzps == null)
    {
      zzb.zzaH("AdWebView is null");
      return;
    }
    int i;
    if ("portrait".equalsIgnoreCase(this.zzCq)) {
      i = zzp.zzbz().zzhe();
    }
    for (;;)
    {
      this.zzps.setRequestedOrientation(i);
      return;
      if ("landscape".equalsIgnoreCase(this.zzCq)) {
        i = zzp.zzbz().zzhd();
      } else if (this.zzCp) {
        i = -1;
      } else {
        i = zzp.zzbz().zzhf();
      }
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzfn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */