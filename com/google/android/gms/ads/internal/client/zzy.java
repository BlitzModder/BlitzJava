package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.zzha;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@zzha
public final class zzy
{
  public static final String DEVICE_ID_EMULATOR = zzl.zzcN().zzaE("emulator");
  private final Date zzaW;
  private final Set<String> zzaY;
  private final Location zzba;
  private final boolean zzpt;
  private final int zztH;
  private final int zztK;
  private final String zztL;
  private final String zztN;
  private final Bundle zztP;
  private final String zztR;
  private final boolean zztT;
  private final Bundle zzul;
  private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzum;
  private final SearchAdRequest zzun;
  private final Set<String> zzuo;
  private final Set<String> zzup;
  
  public zzy(zza paramzza)
  {
    this(paramzza, null);
  }
  
  public zzy(zza paramzza, SearchAdRequest paramSearchAdRequest)
  {
    this.zzaW = zza.zza(paramzza);
    this.zztN = zza.zzb(paramzza);
    this.zztH = zza.zzc(paramzza);
    this.zzaY = Collections.unmodifiableSet(zza.zzd(paramzza));
    this.zzba = zza.zze(paramzza);
    this.zzpt = zza.zzf(paramzza);
    this.zzul = zza.zzg(paramzza);
    this.zzum = Collections.unmodifiableMap(zza.zzh(paramzza));
    this.zztL = zza.zzi(paramzza);
    this.zztR = zza.zzj(paramzza);
    this.zzun = paramSearchAdRequest;
    this.zztK = zza.zzk(paramzza);
    this.zzuo = Collections.unmodifiableSet(zza.zzl(paramzza));
    this.zztP = zza.zzm(paramzza);
    this.zzup = Collections.unmodifiableSet(zza.zzn(paramzza));
    this.zztT = zza.zzo(paramzza);
  }
  
  public Date getBirthday()
  {
    return this.zzaW;
  }
  
  public String getContentUrl()
  {
    return this.zztN;
  }
  
  public Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass)
  {
    Bundle localBundle = this.zzul.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
    if (localBundle != null) {
      return localBundle.getBundle(paramClass.getClass().getName());
    }
    return null;
  }
  
  public Bundle getCustomTargeting()
  {
    return this.zztP;
  }
  
  public int getGender()
  {
    return this.zztH;
  }
  
  public Set<String> getKeywords()
  {
    return this.zzaY;
  }
  
  public Location getLocation()
  {
    return this.zzba;
  }
  
  public boolean getManualImpressionsEnabled()
  {
    return this.zzpt;
  }
  
  @Deprecated
  public <T extends NetworkExtras> T getNetworkExtras(Class<T> paramClass)
  {
    return (NetworkExtras)this.zzum.get(paramClass);
  }
  
  public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> paramClass)
  {
    return this.zzul.getBundle(paramClass.getName());
  }
  
  public String getPublisherProvidedId()
  {
    return this.zztL;
  }
  
  public boolean isDesignedForFamilies()
  {
    return this.zztT;
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return this.zzuo.contains(zzl.zzcN().zzS(paramContext));
  }
  
  public String zzcT()
  {
    return this.zztR;
  }
  
  public SearchAdRequest zzcU()
  {
    return this.zzun;
  }
  
  public Map<Class<? extends NetworkExtras>, NetworkExtras> zzcV()
  {
    return this.zzum;
  }
  
  public Bundle zzcW()
  {
    return this.zzul;
  }
  
  public int zzcX()
  {
    return this.zztK;
  }
  
  public Set<String> zzcY()
  {
    return this.zzup;
  }
  
  public static final class zza
  {
    private Date zzaW;
    private Location zzba;
    private boolean zzpt = false;
    private int zztH = -1;
    private int zztK = -1;
    private String zztL;
    private String zztN;
    private final Bundle zztP = new Bundle();
    private String zztR;
    private boolean zztT;
    private final Bundle zzul = new Bundle();
    private final HashSet<String> zzuq = new HashSet();
    private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzur = new HashMap();
    private final HashSet<String> zzus = new HashSet();
    private final HashSet<String> zzut = new HashSet();
    
    public void setManualImpressionsEnabled(boolean paramBoolean)
    {
      this.zzpt = paramBoolean;
    }
    
    public void zzF(String paramString)
    {
      this.zzuq.add(paramString);
    }
    
    public void zzG(String paramString)
    {
      this.zzus.add(paramString);
    }
    
    public void zzH(String paramString)
    {
      this.zzus.remove(paramString);
    }
    
    public void zzI(String paramString)
    {
      this.zztN = paramString;
    }
    
    public void zzJ(String paramString)
    {
      this.zztL = paramString;
    }
    
    public void zzK(String paramString)
    {
      this.zztR = paramString;
    }
    
    public void zzL(String paramString)
    {
      this.zzut.add(paramString);
    }
    
    @Deprecated
    public void zza(NetworkExtras paramNetworkExtras)
    {
      if ((paramNetworkExtras instanceof AdMobExtras))
      {
        zza(AdMobAdapter.class, ((AdMobExtras)paramNetworkExtras).getExtras());
        return;
      }
      this.zzur.put(paramNetworkExtras.getClass(), paramNetworkExtras);
    }
    
    public void zza(Class<? extends MediationAdapter> paramClass, Bundle paramBundle)
    {
      this.zzul.putBundle(paramClass.getName(), paramBundle);
    }
    
    public void zza(Date paramDate)
    {
      this.zzaW = paramDate;
    }
    
    public void zzb(Location paramLocation)
    {
      this.zzba = paramLocation;
    }
    
    public void zzb(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
    {
      if (this.zzul.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
        this.zzul.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
      }
      this.zzul.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(paramClass.getName(), paramBundle);
    }
    
    public void zzb(String paramString1, String paramString2)
    {
      this.zztP.putString(paramString1, paramString2);
    }
    
    public void zzk(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        this.zztK = i;
        return;
      }
    }
    
    public void zzl(boolean paramBoolean)
    {
      this.zztT = paramBoolean;
    }
    
    public void zzn(int paramInt)
    {
      this.zztH = paramInt;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/client/zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */