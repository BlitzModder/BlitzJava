package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.UUID;

class zzr
  extends zzw
{
  static final Pair<String, Long> zzaTD = new Pair("", Long.valueOf(0L));
  private SharedPreferences zzRN;
  public final zzb zzaTE = new zzb("health_monitor", zzAX().zzkG(), null);
  public final zza zzaTF = new zza("last_upload", 0L);
  public final zza zzaTG = new zza("last_upload_attempt", 0L);
  public final zza zzaTH = new zza("backoff", 0L);
  public final zza zzaTI = new zza("last_delete_stale", 0L);
  private String zzaTJ;
  private boolean zzaTK;
  private long zzaTL;
  private final SecureRandom zzaTM = new SecureRandom();
  
  zzr(zzt paramzzt)
  {
    super(paramzzt);
  }
  
  private SharedPreferences zzBw()
  {
    zziS();
    zzje();
    return this.zzRN;
  }
  
  static MessageDigest zzbs(String paramString)
  {
    int i = 0;
    while (i < 2) {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance(paramString);
        if (localMessageDigest != null) {
          return localMessageDigest;
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        i += 1;
      }
    }
    return null;
  }
  
  void setMeasurementEnabled(boolean paramBoolean)
  {
    zziS();
    zzzz().zzBr().zzj("Setting measurementEnabled", Boolean.valueOf(paramBoolean));
    SharedPreferences.Editor localEditor = zzBw().edit();
    localEditor.putBoolean("measurement_enabled", paramBoolean);
    localEditor.apply();
  }
  
  Pair<String, Boolean> zzBt()
  {
    zziS();
    long l = zziT().elapsedRealtime();
    if ((this.zzaTJ != null) && (l < this.zzaTL)) {
      return new Pair(this.zzaTJ, Boolean.valueOf(this.zzaTK));
    }
    this.zzaTL = (l + zzAX().zzAD());
    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
    try
    {
      AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
      this.zzaTJ = localInfo.getId();
      this.zzaTK = localInfo.isLimitAdTrackingEnabled();
      AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
      return new Pair(this.zzaTJ, Boolean.valueOf(this.zzaTK));
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        zzzz().zzBq().zzj("Unable to get advertising id", localThrowable);
        this.zzaTJ = "";
      }
    }
  }
  
  String zzBu()
  {
    String str = (String)zzBt().first;
    MessageDigest localMessageDigest = zzbs("MD5");
    if (localMessageDigest == null) {
      return null;
    }
    return String.format(Locale.US, "%032X", new Object[] { new BigInteger(1, localMessageDigest.digest(str.getBytes())) });
  }
  
  String zzBv()
  {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }
  
  Boolean zzBx()
  {
    zziS();
    if (!zzBw().contains("use_service")) {
      return null;
    }
    return Boolean.valueOf(zzBw().getBoolean("use_service", false));
  }
  
  void zzap(boolean paramBoolean)
  {
    zziS();
    zzzz().zzBr().zzj("Setting useService", Boolean.valueOf(paramBoolean));
    SharedPreferences.Editor localEditor = zzBw().edit();
    localEditor.putBoolean("use_service", paramBoolean);
    localEditor.apply();
  }
  
  protected void zzir()
  {
    this.zzRN = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
  }
  
  boolean zzzC()
  {
    zziS();
    return zzBw().getBoolean("measurement_enabled", true);
  }
  
  public final class zza
  {
    private long zzaBq;
    private final long zzaTN;
    private boolean zzaTO;
    private final String zzuX;
    
    public zza(String paramString, long paramLong)
    {
      zzx.zzcG(paramString);
      this.zzuX = paramString;
      this.zzaTN = paramLong;
    }
    
    private void zzBy()
    {
      if (this.zzaTO) {
        return;
      }
      this.zzaTO = true;
      this.zzaBq = zzr.zza(zzr.this).getLong(this.zzuX, this.zzaTN);
    }
    
    public long get()
    {
      zzBy();
      return this.zzaBq;
    }
    
    public void set(long paramLong)
    {
      SharedPreferences.Editor localEditor = zzr.zza(zzr.this).edit();
      localEditor.putLong(this.zzuX, paramLong);
      localEditor.apply();
      this.zzaBq = paramLong;
    }
  }
  
  public final class zzb
  {
    private final long zzRR;
    final String zzaTQ;
    private final String zzaTR;
    private final String zzaTS;
    
    private zzb(String paramString, long paramLong)
    {
      zzx.zzcG(paramString);
      if (paramLong > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzab(bool);
        this.zzaTQ = (paramString + ":start");
        this.zzaTR = (paramString + ":count");
        this.zzaTS = (paramString + ":value");
        this.zzRR = paramLong;
        return;
      }
    }
    
    private void zzlu()
    {
      zzr.this.zziS();
      long l = zzr.this.zziT().currentTimeMillis();
      SharedPreferences.Editor localEditor = zzr.zza(zzr.this).edit();
      localEditor.remove(this.zzaTR);
      localEditor.remove(this.zzaTS);
      localEditor.putLong(this.zzaTQ, l);
      localEditor.apply();
    }
    
    private long zzlv()
    {
      zzr.this.zziS();
      long l = zzlx();
      if (l == 0L)
      {
        zzlu();
        return 0L;
      }
      return Math.abs(l - zzr.this.zziT().currentTimeMillis());
    }
    
    private long zzlx()
    {
      return zzr.zzc(zzr.this).getLong(this.zzaTQ, 0L);
    }
    
    public void zzbn(String paramString)
    {
      zzg(paramString, 1L);
    }
    
    public void zzg(String paramString, long paramLong)
    {
      zzr.this.zziS();
      if (zzlx() == 0L) {
        zzlu();
      }
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      long l = zzr.zza(zzr.this).getLong(this.zzaTR, 0L);
      if (l <= 0L)
      {
        paramString = zzr.zza(zzr.this).edit();
        paramString.putString(this.zzaTS, str);
        paramString.putLong(this.zzaTR, paramLong);
        paramString.apply();
        return;
      }
      if ((zzr.zzb(zzr.this).nextLong() & 0x7FFFFFFFFFFFFFFF) < Long.MAX_VALUE / (l + paramLong) * paramLong) {}
      for (int i = 1;; i = 0)
      {
        paramString = zzr.zza(zzr.this).edit();
        if (i != 0) {
          paramString.putString(this.zzaTS, str);
        }
        paramString.putLong(this.zzaTR, l + paramLong);
        paramString.apply();
        return;
      }
    }
    
    public Pair<String, Long> zzlw()
    {
      zzr.this.zziS();
      long l = zzlv();
      if (l < this.zzRR) {
        return null;
      }
      if (l > this.zzRR * 2L)
      {
        zzlu();
        return null;
      }
      String str = zzr.zzc(zzr.this).getString(this.zzaTS, null);
      l = zzr.zzc(zzr.this).getLong(this.zzaTR, 0L);
      zzlu();
      if ((str == null) || (l <= 0L)) {
        return zzr.zzaTD;
      }
      return new Pair(str, Long.valueOf(l));
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/measurement/internal/zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */