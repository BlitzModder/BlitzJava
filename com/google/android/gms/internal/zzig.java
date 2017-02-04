package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.security.NetworkSecurityPolicy;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.Future;

@zzha
public class zzig
  implements zzin.zzb
{
  private Context mContext;
  private boolean zzIn = true;
  private boolean zzIo = true;
  private final String zzJX;
  private final zzih zzJY;
  private BigInteger zzJZ = BigInteger.ONE;
  private final HashSet<zzif> zzKa = new HashSet();
  private final HashMap<String, zzij> zzKb = new HashMap();
  private boolean zzKc = false;
  private int zzKd = 0;
  private zzcb zzKe = null;
  private zzbl zzKf = null;
  private final LinkedList<Thread> zzKg = new LinkedList();
  private Boolean zzKh = null;
  private String zzKi;
  private boolean zzKj = false;
  private boolean zzKk = false;
  private VersionInfoParcel zzpI;
  private final Object zzpK = new Object();
  private zzay zzpb;
  private boolean zzqh = false;
  private zzbk zzsP = null;
  private zzbj zzsQ = null;
  private final zzgz zzsR = null;
  
  public zzig(zzip paramzzip)
  {
    this.zzJX = paramzzip.zzha();
    this.zzJY = new zzih(this.zzJX);
  }
  
  public String getSessionId()
  {
    return this.zzJX;
  }
  
  public void zzB(boolean paramBoolean)
  {
    synchronized (this.zzpK)
    {
      if (this.zzIo != paramBoolean) {
        zzin.zzb(this.mContext, paramBoolean);
      }
      this.zzIo = paramBoolean;
      zzbl localzzbl = zzG(this.mContext);
      if ((localzzbl != null) && (!localzzbl.isAlive()))
      {
        zzb.zzaG("start fetching content...");
        localzzbl.zzcB();
      }
      return;
    }
  }
  
  public void zzC(boolean paramBoolean)
  {
    synchronized (this.zzpK)
    {
      this.zzKj = paramBoolean;
      return;
    }
  }
  
  public zzbl zzG(Context paramContext)
  {
    if ((!((Boolean)zzbz.zzvO.get()).booleanValue()) || (!zznx.zzrQ()) || (zzgJ())) {
      return null;
    }
    synchronized (this.zzpK)
    {
      if (this.zzsP == null)
      {
        if (!(paramContext instanceof Activity)) {
          return null;
        }
        this.zzsP = new zzbk((Application)paramContext.getApplicationContext(), (Activity)paramContext);
      }
      if (this.zzsQ == null) {
        this.zzsQ = new zzbj();
      }
      if (this.zzKf == null) {
        this.zzKf = new zzbl(this.zzsP, this.zzsQ, new zzgz(this.mContext, this.zzpI, null, null));
      }
      this.zzKf.zzcB();
      paramContext = this.zzKf;
      return paramContext;
    }
  }
  
  public Bundle zza(Context paramContext, zzii paramzzii, String paramString)
  {
    Bundle localBundle;
    synchronized (this.zzpK)
    {
      localBundle = new Bundle();
      localBundle.putBundle("app", this.zzJY.zzc(paramContext, paramString));
      paramContext = new Bundle();
      paramString = this.zzKb.keySet().iterator();
      if (paramString.hasNext())
      {
        String str = (String)paramString.next();
        paramContext.putBundle(str, ((zzij)this.zzKb.get(str)).toBundle());
      }
    }
    localBundle.putBundle("slots", paramContext);
    paramContext = new ArrayList();
    paramString = this.zzKa.iterator();
    while (paramString.hasNext()) {
      paramContext.add(((zzif)paramString.next()).toBundle());
    }
    localBundle.putParcelableArrayList("ads", paramContext);
    paramzzii.zza(this.zzKa);
    this.zzKa.clear();
    return localBundle;
  }
  
  public Future zza(Context paramContext, boolean paramBoolean)
  {
    synchronized (this.zzpK)
    {
      if (paramBoolean != this.zzIn)
      {
        this.zzIn = paramBoolean;
        paramContext = zzin.zza(paramContext, paramBoolean);
        return paramContext;
      }
      return null;
    }
  }
  
  public void zza(zzif paramzzif)
  {
    synchronized (this.zzpK)
    {
      this.zzKa.add(paramzzif);
      return;
    }
  }
  
  public void zza(String paramString, zzij paramzzij)
  {
    synchronized (this.zzpK)
    {
      this.zzKb.put(paramString, paramzzij);
      return;
    }
  }
  
  public void zza(Thread paramThread)
  {
    zzgz.zza(this.mContext, paramThread, this.zzpI);
  }
  
  public void zzb(Context paramContext, VersionInfoParcel paramVersionInfoParcel)
  {
    synchronized (this.zzpK)
    {
      if (!this.zzqh)
      {
        this.mContext = paramContext.getApplicationContext();
        this.zzpI = paramVersionInfoParcel;
        zzin.zza(paramContext, this);
        zzin.zzb(paramContext, this);
        zzin.zzc(paramContext, this);
        zza(Thread.currentThread());
        this.zzKi = zzp.zzbx().zzd(paramContext, paramVersionInfoParcel.afmaVersion);
        if ((zznx.zzrX()) && (!NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted())) {
          this.zzKk = true;
        }
        this.zzpb = new zzay(paramContext.getApplicationContext(), this.zzpI, new zzei(paramContext.getApplicationContext(), this.zzpI, (String)zzbz.zzvg.get()));
        zzgU();
        zzp.zzbH().zzz(this.mContext);
        this.zzqh = true;
      }
      return;
    }
  }
  
  public void zzb(Boolean paramBoolean)
  {
    synchronized (this.zzpK)
    {
      this.zzKh = paramBoolean;
      return;
    }
  }
  
  public void zzb(Throwable paramThrowable, boolean paramBoolean)
  {
    new zzgz(this.mContext, this.zzpI, null, null).zza(paramThrowable, paramBoolean);
  }
  
  public void zzb(HashSet<zzif> paramHashSet)
  {
    synchronized (this.zzpK)
    {
      this.zzKa.addAll(paramHashSet);
      return;
    }
  }
  
  public void zze(Bundle paramBundle)
  {
    synchronized (this.zzpK)
    {
      if (paramBundle.containsKey("use_https")) {}
      for (boolean bool = paramBundle.getBoolean("use_https");; bool = this.zzIn)
      {
        this.zzIn = bool;
        if (!paramBundle.containsKey("webview_cache_version")) {
          break;
        }
        i = paramBundle.getInt("webview_cache_version");
        this.zzKd = i;
        if (paramBundle.containsKey("content_url_opted_out")) {
          zzB(paramBundle.getBoolean("content_url_opted_out"));
        }
        return;
      }
      int i = this.zzKd;
    }
  }
  
  public String zzf(int paramInt, String paramString)
  {
    if (this.zzpI.zzLH) {}
    for (Resources localResources = this.mContext.getResources(); localResources == null; localResources = GooglePlayServicesUtil.getRemoteResource(this.mContext)) {
      return paramString;
    }
    return localResources.getString(paramInt);
  }
  
  public boolean zzgJ()
  {
    synchronized (this.zzpK)
    {
      boolean bool = this.zzIo;
      return bool;
    }
  }
  
  public String zzgK()
  {
    synchronized (this.zzpK)
    {
      String str = this.zzJZ.toString();
      this.zzJZ = this.zzJZ.add(BigInteger.ONE);
      return str;
    }
  }
  
  public zzih zzgL()
  {
    synchronized (this.zzpK)
    {
      zzih localzzih = this.zzJY;
      return localzzih;
    }
  }
  
  public zzcb zzgM()
  {
    synchronized (this.zzpK)
    {
      zzcb localzzcb = this.zzKe;
      return localzzcb;
    }
  }
  
  public boolean zzgN()
  {
    synchronized (this.zzpK)
    {
      boolean bool = this.zzKc;
      this.zzKc = true;
      return bool;
    }
  }
  
  public boolean zzgO()
  {
    for (;;)
    {
      synchronized (this.zzpK)
      {
        if (!this.zzIn)
        {
          if (!this.zzKk) {
            break label38;
          }
          break label33;
          return bool;
        }
      }
      label33:
      boolean bool = true;
      continue;
      label38:
      bool = false;
    }
  }
  
  public String zzgP()
  {
    synchronized (this.zzpK)
    {
      String str = this.zzKi;
      return str;
    }
  }
  
  public Boolean zzgQ()
  {
    synchronized (this.zzpK)
    {
      Boolean localBoolean = this.zzKh;
      return localBoolean;
    }
  }
  
  public zzay zzgR()
  {
    return this.zzpb;
  }
  
  public boolean zzgS()
  {
    synchronized (this.zzpK)
    {
      if (this.zzKd < ((Integer)zzbz.zzwf.get()).intValue())
      {
        this.zzKd = ((Integer)zzbz.zzwf.get()).intValue();
        zzin.zza(this.mContext, this.zzKd);
        return true;
      }
      return false;
    }
  }
  
  public boolean zzgT()
  {
    synchronized (this.zzpK)
    {
      boolean bool = this.zzKj;
      return bool;
    }
  }
  
  void zzgU()
  {
    zzca localzzca = new zzca(this.mContext, this.zzpI.afmaVersion);
    try
    {
      this.zzKe = zzp.zzbC().zza(localzzca);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      zzb.zzd("Cannot initialize CSI reporter.", localIllegalArgumentException);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/internal/zzig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */