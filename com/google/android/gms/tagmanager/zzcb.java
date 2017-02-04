package com.google.android.gms.tagmanager;

import android.net.Uri;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

class zzcb
{
  private static zzcb zzbeJ;
  private volatile String zzbcF;
  private volatile zza zzbeK;
  private volatile String zzbeL;
  private volatile String zzbeM;
  
  zzcb()
  {
    clear();
  }
  
  static zzcb zzEY()
  {
    try
    {
      if (zzbeJ == null) {
        zzbeJ = new zzcb();
      }
      zzcb localzzcb = zzbeJ;
      return localzzcb;
    }
    finally {}
  }
  
  private String zzfw(String paramString)
  {
    return paramString.split("&")[0].split("=")[1];
  }
  
  private String zzq(Uri paramUri)
  {
    return paramUri.getQuery().replace("&gtm_debug=x", "");
  }
  
  void clear()
  {
    this.zzbeK = zza.zzbeN;
    this.zzbeL = null;
    this.zzbcF = null;
    this.zzbeM = null;
  }
  
  String getContainerId()
  {
    return this.zzbcF;
  }
  
  zza zzEZ()
  {
    return this.zzbeK;
  }
  
  String zzFa()
  {
    return this.zzbeL;
  }
  
  boolean zzp(Uri paramUri)
  {
    boolean bool = true;
    String str;
    try
    {
      str = URLDecoder.decode(paramUri.toString(), "UTF-8");
      if (!str.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_auth=\\S+&gtm_preview=\\d+(&gtm_debug=x)?$")) {
        break label153;
      }
      zzbg.v("Container preview url: " + str);
      if (!str.matches(".*?&gtm_debug=x$")) {
        break label138;
      }
      this.zzbeK = zza.zzbeP;
    }
    catch (UnsupportedEncodingException paramUri)
    {
      for (;;)
      {
        bool = false;
        continue;
        this.zzbeK = zza.zzbeO;
      }
    }
    finally {}
    this.zzbeM = zzq(paramUri);
    if ((this.zzbeK == zza.zzbeO) || (this.zzbeK == zza.zzbeP)) {
      this.zzbeL = ("/r?" + this.zzbeM);
    }
    this.zzbcF = zzfw(this.zzbeM);
    for (;;)
    {
      return bool;
      label138:
      label153:
      if (str.matches("^tagmanager.c.\\S+:\\/\\/preview\\/p\\?id=\\S+&gtm_preview=$"))
      {
        if (zzfw(paramUri.getQuery()).equals(this.zzbcF))
        {
          zzbg.v("Exit preview mode for container: " + this.zzbcF);
          this.zzbeK = zza.zzbeN;
          this.zzbeL = null;
        }
      }
      else
      {
        zzbg.zzaH("Invalid preview uri: " + str);
        bool = false;
        continue;
      }
      bool = false;
    }
  }
  
  static enum zza
  {
    private zza() {}
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/tagmanager/zzcb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */