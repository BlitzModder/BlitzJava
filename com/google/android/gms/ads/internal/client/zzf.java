package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.internal.zzha;
import java.util.ArrayList;
import java.util.List;

@zzha
public final class zzf
{
  private Bundle mExtras;
  private Location zzba;
  private boolean zzpt;
  private long zztG;
  private int zztH;
  private List<String> zztI;
  private boolean zztJ;
  private int zztK;
  private String zztL;
  private SearchAdRequestParcel zztM;
  private String zztN;
  private Bundle zztO;
  private Bundle zztP;
  private List<String> zztQ;
  private String zztR;
  private String zztS;
  private boolean zztT;
  
  public zzf()
  {
    this.zztG = -1L;
    this.mExtras = new Bundle();
    this.zztH = -1;
    this.zztI = new ArrayList();
    this.zztJ = false;
    this.zztK = -1;
    this.zzpt = false;
    this.zztL = null;
    this.zztM = null;
    this.zzba = null;
    this.zztN = null;
    this.zztO = new Bundle();
    this.zztP = new Bundle();
    this.zztQ = new ArrayList();
    this.zztR = null;
    this.zztS = null;
    this.zztT = false;
  }
  
  public zzf(AdRequestParcel paramAdRequestParcel)
  {
    this.zztG = paramAdRequestParcel.zztq;
    this.mExtras = paramAdRequestParcel.extras;
    this.zztH = paramAdRequestParcel.zztr;
    this.zztI = paramAdRequestParcel.zzts;
    this.zztJ = paramAdRequestParcel.zztt;
    this.zztK = paramAdRequestParcel.zztu;
    this.zzpt = paramAdRequestParcel.zztv;
    this.zztL = paramAdRequestParcel.zztw;
    this.zztM = paramAdRequestParcel.zztx;
    this.zzba = paramAdRequestParcel.zzty;
    this.zztN = paramAdRequestParcel.zztz;
    this.zztO = paramAdRequestParcel.zztA;
    this.zztP = paramAdRequestParcel.zztB;
    this.zztQ = paramAdRequestParcel.zztC;
    this.zztR = paramAdRequestParcel.zztD;
    this.zztS = paramAdRequestParcel.zztE;
  }
  
  public zzf zza(Location paramLocation)
  {
    this.zzba = paramLocation;
    return this;
  }
  
  public AdRequestParcel zzcI()
  {
    return new AdRequestParcel(7, this.zztG, this.mExtras, this.zztH, this.zztI, this.zztJ, this.zztK, this.zzpt, this.zztL, this.zztM, this.zzba, this.zztN, this.zztO, this.zztP, this.zztQ, this.zztR, this.zztS, this.zztT);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/ads/internal/client/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */