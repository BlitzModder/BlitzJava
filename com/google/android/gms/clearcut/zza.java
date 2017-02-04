package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzlt;
import com.google.android.gms.internal.zzlu;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zzno;
import com.google.android.gms.internal.zztp.zzd;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public final class zza
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("ClearcutLogger.API", zzTp, zzTo);
  public static final Api.zzc<zzlu> zzTo = new Api.zzc();
  public static final Api.zza<zzlu, Api.ApiOptions.NoOptions> zzTp = new Api.zza()
  {
    public zzlu zze(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Api.ApiOptions.NoOptions paramAnonymousNoOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      return new zzlu(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
  };
  public static final zzb zzadh = new zzlt();
  private final Context mContext;
  private final String zzSp;
  private final int zzadi;
  private String zzadj;
  private int zzadk = -1;
  private String zzadl;
  private String zzadm;
  private final boolean zzadn;
  private int zzado = 0;
  private final zzb zzadp;
  private zzc zzadq;
  private final zznl zzqD;
  
  zza(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, boolean paramBoolean, zzb paramzzb, zznl paramzznl)
  {
    this.mContext = paramContext.getApplicationContext();
    this.zzSp = paramContext.getPackageName();
    this.zzadi = zzah(paramContext);
    this.zzadk = paramInt;
    this.zzadj = paramString1;
    this.zzadl = paramString2;
    this.zzadm = paramString3;
    this.zzadn = paramBoolean;
    this.zzadp = paramzzb;
    this.zzqD = paramzznl;
    this.zzadq = new zzc();
    this.zzado = 0;
    if (this.zzadn)
    {
      paramBoolean = bool;
      if (this.zzadl == null) {
        paramBoolean = true;
      }
      zzx.zzb(paramBoolean, "can't be anonymous with an upload account");
    }
  }
  
  @Deprecated
  public zza(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    this(paramContext, -1, paramString1, paramString2, paramString3, false, zzadh, zzno.zzrM());
  }
  
  private int zzah(Context paramContext)
  {
    try
    {
      int i = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      Log.wtf("ClearcutLogger", "This can't happen.");
    }
    return 0;
  }
  
  private static int[] zzb(ArrayList<Integer> paramArrayList)
  {
    if (paramArrayList == null) {
      return null;
    }
    int[] arrayOfInt = new int[paramArrayList.size()];
    paramArrayList = paramArrayList.iterator();
    int i = 0;
    while (paramArrayList.hasNext())
    {
      arrayOfInt[i] = ((Integer)paramArrayList.next()).intValue();
      i += 1;
    }
    return arrayOfInt;
  }
  
  public boolean zza(GoogleApiClient paramGoogleApiClient, long paramLong, TimeUnit paramTimeUnit)
  {
    return this.zzadp.zza(paramGoogleApiClient, paramLong, paramTimeUnit);
  }
  
  public zza zzi(byte[] paramArrayOfByte)
  {
    return new zza(paramArrayOfByte, null);
  }
  
  public class zza
  {
    private String zzadj = zza.zzb(zza.this);
    private int zzadk = zza.zza(zza.this);
    private String zzadl = zza.zzc(zza.this);
    private String zzadm = zza.zzd(zza.this);
    private int zzado = zza.zze(zza.this);
    private final zza.zzb zzadr;
    private zza.zzb zzads;
    private ArrayList<Integer> zzadt = null;
    private final zztp.zzd zzadu = new zztp.zzd();
    private boolean zzadv = false;
    
    private zza(byte[] paramArrayOfByte)
    {
      this(paramArrayOfByte, null);
    }
    
    private zza(byte[] paramArrayOfByte, zza.zzb paramzzb)
    {
      this.zzadu.zzbqw = zza.zzf(zza.this).currentTimeMillis();
      this.zzadu.zzbqx = zza.zzf(zza.this).elapsedRealtime();
      this.zzadu.zzbqI = zza.zzg(zza.this).zzC(this.zzadu.zzbqw);
      if (paramArrayOfByte != null) {
        this.zzadu.zzbqD = paramArrayOfByte;
      }
      this.zzadr = paramzzb;
    }
    
    public zza zzbq(int paramInt)
    {
      this.zzadu.zzbqz = paramInt;
      return this;
    }
    
    public zza zzbr(int paramInt)
    {
      this.zzadu.zznN = paramInt;
      return this;
    }
    
    public PendingResult<Status> zzc(GoogleApiClient paramGoogleApiClient)
    {
      if (this.zzadv) {
        throw new IllegalStateException("do not reuse LogEventBuilder");
      }
      this.zzadv = true;
      return zza.zzk(zza.this).zza(paramGoogleApiClient, zzom());
    }
    
    public LogEventParcelable zzom()
    {
      return new LogEventParcelable(new PlayLoggerContext(zza.zzi(zza.this), zza.zzj(zza.this), this.zzadk, this.zzadj, this.zzadl, this.zzadm, zza.zzh(zza.this), this.zzado), this.zzadu, this.zzadr, this.zzads, zza.zzc(this.zzadt));
    }
  }
  
  public static abstract interface zzb
  {
    public abstract byte[] zzon();
  }
  
  public static class zzc
  {
    public long zzC(long paramLong)
    {
      return TimeZone.getDefault().getOffset(paramLong) / 1000;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/clearcut/zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */