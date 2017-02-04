package com.google.android.gms.location.places.internal;

import android.text.style.CharacterStyle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.Collections;
import java.util.List;

public class zzb
  extends zzu
  implements AutocompletePrediction
{
  public zzb(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  private List<AutocompletePredictionEntity.SubstringEntity> zzyA()
  {
    return zza("ap_secondary_text_matched", AutocompletePredictionEntity.SubstringEntity.CREATOR, Collections.emptyList());
  }
  
  private String zzyv()
  {
    return zzI("ap_description", "");
  }
  
  private String zzyw()
  {
    return zzI("ap_primary_text", "");
  }
  
  private String zzyx()
  {
    return zzI("ap_secondary_text", "");
  }
  
  private List<AutocompletePredictionEntity.SubstringEntity> zzyy()
  {
    return zza("ap_matched_subscriptions", AutocompletePredictionEntity.SubstringEntity.CREATOR, Collections.emptyList());
  }
  
  private List<AutocompletePredictionEntity.SubstringEntity> zzyz()
  {
    return zza("ap_primary_text_matched", AutocompletePredictionEntity.SubstringEntity.CREATOR, Collections.emptyList());
  }
  
  public String getDescription()
  {
    return zzyv();
  }
  
  public CharSequence getFullText(CharacterStyle paramCharacterStyle)
  {
    return zzc.zza(zzyv(), zzyy(), paramCharacterStyle);
  }
  
  public List<AutocompletePredictionEntity.SubstringEntity> getMatchedSubstrings()
  {
    return zzyy();
  }
  
  public String getPlaceId()
  {
    return zzI("ap_place_id", null);
  }
  
  public List<Integer> getPlaceTypes()
  {
    return zza("ap_place_types", Collections.emptyList());
  }
  
  public CharSequence getPrimaryText(CharacterStyle paramCharacterStyle)
  {
    return zzc.zza(zzyw(), zzyz(), paramCharacterStyle);
  }
  
  public CharSequence getSecondaryText(CharacterStyle paramCharacterStyle)
  {
    return zzc.zza(zzyx(), zzyA(), paramCharacterStyle);
  }
  
  public AutocompletePrediction zzyt()
  {
    return AutocompletePredictionEntity.zza(getPlaceId(), getPlaceTypes(), zzyu(), zzyv(), zzyy(), zzyw(), zzyz(), zzyx(), zzyA());
  }
  
  public int zzyu()
  {
    return zzz("ap_personalization_type", 6);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/internal/zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */