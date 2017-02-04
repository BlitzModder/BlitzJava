package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import java.util.UUID;

public class zzai
  extends zzd
{
  private SharedPreferences zzRN;
  private long zzRO;
  private long zzRP = -1L;
  private final zza zzRQ = new zza("monitoring", zziV().zzkG(), null);
  
  protected zzai(zzf paramzzf)
  {
    super(paramzzf);
  }
  
  public void zzbm(String paramString)
  {
    zziS();
    zzje();
    SharedPreferences.Editor localEditor = this.zzRN.edit();
    if (TextUtils.isEmpty(paramString)) {
      localEditor.remove("installation_campaign");
    }
    for (;;)
    {
      if (!localEditor.commit()) {
        zzbd("Failed to commit campaign data");
      }
      return;
      localEditor.putString("installation_campaign", paramString);
    }
  }
  
  protected void zzir()
  {
    this.zzRN = getContext().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
  }
  
  public long zzlo()
  {
    zziS();
    zzje();
    long l;
    if (this.zzRO == 0L)
    {
      l = this.zzRN.getLong("first_run", 0L);
      if (l == 0L) {
        break label46;
      }
    }
    for (this.zzRO = l;; this.zzRO = l)
    {
      return this.zzRO;
      label46:
      l = zziT().currentTimeMillis();
      SharedPreferences.Editor localEditor = this.zzRN.edit();
      localEditor.putLong("first_run", l);
      if (!localEditor.commit()) {
        zzbd("Failed to commit first run time");
      }
    }
  }
  
  public zzaj zzlp()
  {
    return new zzaj(zziT(), zzlo());
  }
  
  public long zzlq()
  {
    zziS();
    zzje();
    if (this.zzRP == -1L) {
      this.zzRP = this.zzRN.getLong("last_dispatch", 0L);
    }
    return this.zzRP;
  }
  
  public void zzlr()
  {
    zziS();
    zzje();
    long l = zziT().currentTimeMillis();
    SharedPreferences.Editor localEditor = this.zzRN.edit();
    localEditor.putLong("last_dispatch", l);
    localEditor.apply();
    this.zzRP = l;
  }
  
  public String zzls()
  {
    zziS();
    zzje();
    String str = this.zzRN.getString("installation_campaign", null);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return str;
  }
  
  public zza zzlt()
  {
    return this.zzRQ;
  }
  
  public final class zza
  {
    private final String mName;
    private final long zzRR;
    
    private zza(String paramString, long paramLong)
    {
      zzx.zzcG(paramString);
      if (paramLong > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzab(bool);
        this.mName = paramString;
        this.zzRR = paramLong;
        return;
      }
    }
    
    private void zzlu()
    {
      long l = zzai.this.zziT().currentTimeMillis();
      SharedPreferences.Editor localEditor = zzai.zza(zzai.this).edit();
      localEditor.remove(zzlz());
      localEditor.remove(zzlA());
      localEditor.putLong(zzly(), l);
      localEditor.commit();
    }
    
    private long zzlv()
    {
      long l = zzlx();
      if (l == 0L) {
        return 0L;
      }
      return Math.abs(l - zzai.this.zziT().currentTimeMillis());
    }
    
    private long zzlx()
    {
      return zzai.zza(zzai.this).getLong(zzly(), 0L);
    }
    
    private String zzly()
    {
      return this.mName + ":start";
    }
    
    private String zzlz()
    {
      return this.mName + ":count";
    }
    
    public void zzbn(String paramString)
    {
      if (zzlx() == 0L) {
        zzlu();
      }
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      for (;;)
      {
        try
        {
          long l = zzai.zza(zzai.this).getLong(zzlz(), 0L);
          if (l <= 0L)
          {
            paramString = zzai.zza(zzai.this).edit();
            paramString.putString(zzlA(), str);
            paramString.putLong(zzlz(), 1L);
            paramString.apply();
            return;
          }
          if ((UUID.randomUUID().getLeastSignificantBits() & 0x7FFFFFFFFFFFFFFF) < Long.MAX_VALUE / (l + 1L))
          {
            i = 1;
            paramString = zzai.zza(zzai.this).edit();
            if (i != 0) {
              paramString.putString(zzlA(), str);
            }
            paramString.putLong(zzlz(), l + 1L);
            paramString.apply();
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    protected String zzlA()
    {
      return this.mName + ":value";
    }
    
    public Pair<String, Long> zzlw()
    {
      long l = zzlv();
      if (l < this.zzRR) {}
      String str;
      do
      {
        return null;
        if (l > this.zzRR * 2L)
        {
          zzlu();
          return null;
        }
        str = zzai.zza(zzai.this).getString(zzlA(), null);
        l = zzai.zza(zzai.this).getLong(zzlz(), 0L);
        zzlu();
      } while ((str == null) || (l <= 0L));
      return new Pair(str, Long.valueOf(l));
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/analytics/internal/zzai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */