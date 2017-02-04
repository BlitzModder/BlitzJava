package com.google.android.gms.tagmanager;

import android.content.Context;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class zzz
  implements zzar
{
  private static final Object zzbcs = new Object();
  private static zzz zzbdF;
  private zzcd zzbcV;
  private String zzbdG;
  private String zzbdH;
  private zzas zzbdI;
  
  private zzz(Context paramContext)
  {
    this(zzat.zzaZ(paramContext), new zzcs());
  }
  
  zzz(zzas paramzzas, zzcd paramzzcd)
  {
    this.zzbdI = paramzzas;
    this.zzbcV = paramzzcd;
  }
  
  public static zzar zzaX(Context paramContext)
  {
    synchronized (zzbcs)
    {
      if (zzbdF == null) {
        zzbdF = new zzz(paramContext);
      }
      paramContext = zzbdF;
      return paramContext;
    }
  }
  
  public boolean zzfo(String paramString)
  {
    if (!this.zzbcV.zzlf())
    {
      zzbg.zzaH("Too many urls sent too quickly with the TagManagerSender, rate limiting invoked.");
      return false;
    }
    String str = paramString;
    if (this.zzbdG != null)
    {
      str = paramString;
      if (this.zzbdH == null) {}
    }
    try
    {
      str = this.zzbdG + "?" + this.zzbdH + "=" + URLEncoder.encode(paramString, "UTF-8");
      zzbg.v("Sending wrapped url hit: " + str);
      this.zzbdI.zzfs(str);
      return true;
    }
    catch (UnsupportedEncodingException paramString)
    {
      zzbg.zzd("Error wrapping URL for testing.", paramString);
    }
    return false;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */