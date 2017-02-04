package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class PlaceImpl
  implements SafeParcelable, Place
{
  public static final zzl CREATOR = new zzl();
  private final String mName;
  final int mVersionCode;
  private final LatLng zzaMo;
  private final List<Integer> zzaMp;
  private final String zzaMq;
  private final Uri zzaMr;
  private final Bundle zzaND;
  @Deprecated
  private final PlaceLocalization zzaNE;
  private final float zzaNF;
  private final LatLngBounds zzaNG;
  private final String zzaNH;
  private final boolean zzaNI;
  private final float zzaNJ;
  private final int zzaNK;
  private final long zzaNL;
  private final List<Integer> zzaNM;
  private final String zzaNN;
  private final List<String> zzaNO;
  final boolean zzaNP;
  private final Map<Integer, String> zzaNQ;
  private final TimeZone zzaNR;
  private zzp zzaNS;
  private Locale zzaNy;
  private final String zzatX;
  private final String zzxX;
  
  PlaceImpl(int paramInt1, String paramString1, List<Integer> paramList1, List<Integer> paramList2, Bundle paramBundle, String paramString2, String paramString3, String paramString4, String paramString5, List<String> paramList, LatLng paramLatLng, float paramFloat1, LatLngBounds paramLatLngBounds, String paramString6, Uri paramUri, boolean paramBoolean1, float paramFloat2, int paramInt2, long paramLong, boolean paramBoolean2, PlaceLocalization paramPlaceLocalization)
  {
    this.mVersionCode = paramInt1;
    this.zzxX = paramString1;
    this.zzaMp = Collections.unmodifiableList(paramList1);
    this.zzaNM = paramList2;
    if (paramBundle != null)
    {
      this.zzaND = paramBundle;
      this.mName = paramString2;
      this.zzatX = paramString3;
      this.zzaMq = paramString4;
      this.zzaNN = paramString5;
      if (paramList == null) {
        break label182;
      }
      label68:
      this.zzaNO = paramList;
      this.zzaMo = paramLatLng;
      this.zzaNF = paramFloat1;
      this.zzaNG = paramLatLngBounds;
      if (paramString6 == null) {
        break label190;
      }
    }
    for (;;)
    {
      this.zzaNH = paramString6;
      this.zzaMr = paramUri;
      this.zzaNI = paramBoolean1;
      this.zzaNJ = paramFloat2;
      this.zzaNK = paramInt2;
      this.zzaNL = paramLong;
      this.zzaNQ = Collections.unmodifiableMap(new HashMap());
      this.zzaNR = null;
      this.zzaNy = null;
      this.zzaNP = paramBoolean2;
      this.zzaNE = paramPlaceLocalization;
      return;
      paramBundle = new Bundle();
      break;
      label182:
      paramList = Collections.emptyList();
      break label68;
      label190:
      paramString6 = "UTC";
    }
  }
  
  private void zzdW(String paramString)
  {
    if ((this.zzaNP) && (this.zzaNS != null)) {
      this.zzaNS.zzH(this.zzxX, paramString);
    }
  }
  
  public int describeContents()
  {
    zzl localzzl = CREATOR;
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PlaceImpl)) {
        return false;
      }
      paramObject = (PlaceImpl)paramObject;
    } while ((this.zzxX.equals(((PlaceImpl)paramObject).zzxX)) && (zzw.equal(this.zzaNy, ((PlaceImpl)paramObject).zzaNy)) && (this.zzaNL == ((PlaceImpl)paramObject).zzaNL));
    return false;
  }
  
  public String getAddress()
  {
    zzdW("getAddress");
    return this.zzatX;
  }
  
  public String getId()
  {
    zzdW("getId");
    return this.zzxX;
  }
  
  public LatLng getLatLng()
  {
    zzdW("getLatLng");
    return this.zzaMo;
  }
  
  public Locale getLocale()
  {
    zzdW("getLocale");
    return this.zzaNy;
  }
  
  public String getName()
  {
    zzdW("getName");
    return this.mName;
  }
  
  public String getPhoneNumber()
  {
    zzdW("getPhoneNumber");
    return this.zzaMq;
  }
  
  public List<Integer> getPlaceTypes()
  {
    zzdW("getPlaceTypes");
    return this.zzaMp;
  }
  
  public int getPriceLevel()
  {
    zzdW("getPriceLevel");
    return this.zzaNK;
  }
  
  public float getRating()
  {
    zzdW("getRating");
    return this.zzaNJ;
  }
  
  public LatLngBounds getViewport()
  {
    zzdW("getViewport");
    return this.zzaNG;
  }
  
  public Uri getWebsiteUri()
  {
    zzdW("getWebsiteUri");
    return this.zzaMr;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzxX, this.zzaNy, Long.valueOf(this.zzaNL) });
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public void setLocale(Locale paramLocale)
  {
    this.zzaNy = paramLocale;
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("id", this.zzxX).zzg("placeTypes", this.zzaMp).zzg("locale", this.zzaNy).zzg("name", this.mName).zzg("address", this.zzatX).zzg("phoneNumber", this.zzaMq).zzg("latlng", this.zzaMo).zzg("viewport", this.zzaNG).zzg("websiteUri", this.zzaMr).zzg("isPermanentlyClosed", Boolean.valueOf(this.zzaNI)).zzg("priceLevel", Integer.valueOf(this.zzaNK)).zzg("timestampSecs", Long.valueOf(this.zzaNL)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzl localzzl = CREATOR;
    zzl.zza(this, paramParcel, paramInt);
  }
  
  public void zza(zzp paramzzp)
  {
    this.zzaNS = paramzzp;
  }
  
  public List<Integer> zzyB()
  {
    zzdW("getTypesDeprecated");
    return this.zzaNM;
  }
  
  public float zzyC()
  {
    zzdW("getLevelNumber");
    return this.zzaNF;
  }
  
  public String zzyD()
  {
    zzdW("getRegularOpenHours");
    return this.zzaNN;
  }
  
  public List<String> zzyE()
  {
    zzdW("getAttributions");
    return this.zzaNO;
  }
  
  public boolean zzyF()
  {
    zzdW("isPermanentlyClosed");
    return this.zzaNI;
  }
  
  public long zzyG()
  {
    return this.zzaNL;
  }
  
  public Bundle zzyH()
  {
    return this.zzaND;
  }
  
  public String zzyI()
  {
    return this.zzaNH;
  }
  
  @Deprecated
  public PlaceLocalization zzyJ()
  {
    zzdW("getLocalization");
    return this.zzaNE;
  }
  
  public Place zzyK()
  {
    return this;
  }
  
  public static class zza
  {
    private String mName;
    private int mVersionCode = 0;
    private LatLng zzaMo;
    private String zzaMq;
    private Uri zzaMr;
    private float zzaNF;
    private LatLngBounds zzaNG;
    private String zzaNH;
    private boolean zzaNI;
    private float zzaNJ;
    private int zzaNK;
    private long zzaNL;
    private String zzaNN;
    private List<String> zzaNO;
    private boolean zzaNP;
    private Bundle zzaNT;
    private List<Integer> zzaNU;
    private String zzatX;
    private String zzxX;
    
    public zza zza(LatLng paramLatLng)
    {
      this.zzaMo = paramLatLng;
      return this;
    }
    
    public zza zza(LatLngBounds paramLatLngBounds)
    {
      this.zzaNG = paramLatLngBounds;
      return this;
    }
    
    public zza zzaj(boolean paramBoolean)
    {
      this.zzaNI = paramBoolean;
      return this;
    }
    
    public zza zzak(boolean paramBoolean)
    {
      this.zzaNP = paramBoolean;
      return this;
    }
    
    public zza zzdX(String paramString)
    {
      this.zzxX = paramString;
      return this;
    }
    
    public zza zzdY(String paramString)
    {
      this.mName = paramString;
      return this;
    }
    
    public zza zzdZ(String paramString)
    {
      this.zzatX = paramString;
      return this;
    }
    
    public zza zzea(String paramString)
    {
      this.zzaMq = paramString;
      return this;
    }
    
    public zza zzf(float paramFloat)
    {
      this.zzaNF = paramFloat;
      return this;
    }
    
    public zza zzg(float paramFloat)
    {
      this.zzaNJ = paramFloat;
      return this;
    }
    
    public zza zzhM(int paramInt)
    {
      this.zzaNK = paramInt;
      return this;
    }
    
    public zza zzo(Uri paramUri)
    {
      this.zzaMr = paramUri;
      return this;
    }
    
    public zza zzv(List<Integer> paramList)
    {
      this.zzaNU = paramList;
      return this;
    }
    
    public zza zzw(List<String> paramList)
    {
      this.zzaNO = paramList;
      return this;
    }
    
    public PlaceImpl zzyL()
    {
      return new PlaceImpl(this.mVersionCode, this.zzxX, this.zzaNU, Collections.emptyList(), this.zzaNT, this.mName, this.zzatX, this.zzaMq, this.zzaNN, this.zzaNO, this.zzaMo, this.zzaNF, this.zzaNG, this.zzaNH, this.zzaMr, this.zzaNI, this.zzaNJ, this.zzaNK, this.zzaNL, this.zzaNP, PlaceLocalization.zza(this.mName, this.zzatX, this.zzaMq, this.zzaNN, this.zzaNO));
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/internal/PlaceImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */