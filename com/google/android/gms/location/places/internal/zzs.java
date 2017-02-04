package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class zzs
  extends zzu
  implements Place
{
  private final String zzaMO;
  private boolean zzaNP;
  private final zzp zzaNS;
  
  public zzs(DataHolder paramDataHolder, int paramInt, Context paramContext)
  {
    super(paramDataHolder, paramInt);
    if (paramContext != null) {}
    for (paramDataHolder = zzp.zzaN(paramContext);; paramDataHolder = null)
    {
      this.zzaNS = paramDataHolder;
      this.zzaNP = zzh("place_is_logging_enabled", false);
      this.zzaMO = zzI("place_id", "");
      return;
    }
  }
  
  private void zzdW(String paramString)
  {
    if ((this.zzaNP) && (this.zzaNS != null)) {
      this.zzaNS.zzH(this.zzaMO, paramString);
    }
  }
  
  public CharSequence getAddress()
  {
    zzdW("getAddress");
    return zzI("place_address", "");
  }
  
  public String getId()
  {
    zzdW("getId");
    return this.zzaMO;
  }
  
  public LatLng getLatLng()
  {
    zzdW("getLatLng");
    return (LatLng)zza("place_lat_lng", LatLng.CREATOR);
  }
  
  public Locale getLocale()
  {
    zzdW("getLocale");
    String str = zzI("place_locale", "");
    if (!TextUtils.isEmpty(str)) {
      return new Locale(str);
    }
    return Locale.getDefault();
  }
  
  public CharSequence getName()
  {
    zzdW("getName");
    return zzI("place_name", "");
  }
  
  public CharSequence getPhoneNumber()
  {
    zzdW("getPhoneNumber");
    return zzI("place_phone_number", "");
  }
  
  public List<Integer> getPlaceTypes()
  {
    zzdW("getPlaceTypes");
    return zza("place_types", Collections.emptyList());
  }
  
  public int getPriceLevel()
  {
    zzdW("getPriceLevel");
    return zzz("place_price_level", -1);
  }
  
  public float getRating()
  {
    zzdW("getRating");
    return zzb("place_rating", -1.0F);
  }
  
  public LatLngBounds getViewport()
  {
    zzdW("getViewport");
    return (LatLngBounds)zza("place_viewport", LatLngBounds.CREATOR);
  }
  
  public Uri getWebsiteUri()
  {
    zzdW("getWebsiteUri");
    String str = zzI("place_website_uri", null);
    if (str == null) {
      return null;
    }
    return Uri.parse(str);
  }
  
  public float zzyC()
  {
    zzdW("getLevelNumber");
    return zzb("place_level_number", 0.0F);
  }
  
  public boolean zzyF()
  {
    zzdW("isPermanentlyClosed");
    return zzh("place_is_permanently_closed", false);
  }
  
  public Place zzyK()
  {
    Object localObject = new PlaceImpl.zza().zzak(this.zzaNP);
    this.zzaNP = false;
    localObject = ((PlaceImpl.zza)localObject).zzdZ(getAddress().toString()).zzw(zzb("place_attributions", Collections.emptyList())).zzdX(getId()).zzaj(zzyF()).zza(getLatLng()).zzf(zzyC()).zzdY(getName().toString()).zzea(getPhoneNumber().toString()).zzhM(getPriceLevel()).zzg(getRating()).zzv(getPlaceTypes()).zza(getViewport()).zzo(getWebsiteUri()).zzyL();
    ((PlaceImpl)localObject).setLocale(getLocale());
    ((PlaceImpl)localObject).zza(this.zzaNS);
    return (Place)localObject;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/internal/zzs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */