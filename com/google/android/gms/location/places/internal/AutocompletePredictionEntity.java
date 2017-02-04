package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.style.CharacterStyle;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.location.places.AutocompletePrediction;
import com.google.android.gms.location.places.AutocompletePrediction.Substring;
import java.util.Collections;
import java.util.List;

public class AutocompletePredictionEntity
  implements SafeParcelable, AutocompletePrediction
{
  public static final Parcelable.Creator<AutocompletePredictionEntity> CREATOR = new zza();
  private static final List<SubstringEntity> zzaNj = Collections.emptyList();
  final int mVersionCode;
  final String zzaMO;
  final List<Integer> zzaMp;
  final String zzaNk;
  final List<SubstringEntity> zzaNl;
  final int zzaNm;
  final String zzaNn;
  final List<SubstringEntity> zzaNo;
  final String zzaNp;
  final List<SubstringEntity> zzaNq;
  
  AutocompletePredictionEntity(int paramInt1, String paramString1, List<Integer> paramList, int paramInt2, String paramString2, List<SubstringEntity> paramList1, String paramString3, List<SubstringEntity> paramList2, String paramString4, List<SubstringEntity> paramList3)
  {
    this.mVersionCode = paramInt1;
    this.zzaMO = paramString1;
    this.zzaMp = paramList;
    this.zzaNm = paramInt2;
    this.zzaNk = paramString2;
    this.zzaNl = paramList1;
    this.zzaNn = paramString3;
    this.zzaNo = paramList2;
    this.zzaNp = paramString4;
    this.zzaNq = paramList3;
  }
  
  public static AutocompletePredictionEntity zza(String paramString1, List<Integer> paramList, int paramInt, String paramString2, List<SubstringEntity> paramList1, String paramString3, List<SubstringEntity> paramList2, String paramString4, List<SubstringEntity> paramList3)
  {
    return new AutocompletePredictionEntity(0, paramString1, paramList, paramInt, (String)zzx.zzy(paramString2), paramList1, paramString3, paramList2, paramString4, paramList3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof AutocompletePredictionEntity)) {
        return false;
      }
      paramObject = (AutocompletePredictionEntity)paramObject;
    } while ((zzw.equal(this.zzaMO, ((AutocompletePredictionEntity)paramObject).zzaMO)) && (zzw.equal(this.zzaMp, ((AutocompletePredictionEntity)paramObject).zzaMp)) && (zzw.equal(Integer.valueOf(this.zzaNm), Integer.valueOf(((AutocompletePredictionEntity)paramObject).zzaNm))) && (zzw.equal(this.zzaNk, ((AutocompletePredictionEntity)paramObject).zzaNk)) && (zzw.equal(this.zzaNl, ((AutocompletePredictionEntity)paramObject).zzaNl)) && (zzw.equal(this.zzaNn, ((AutocompletePredictionEntity)paramObject).zzaNn)) && (zzw.equal(this.zzaNo, ((AutocompletePredictionEntity)paramObject).zzaNo)) && (zzw.equal(this.zzaNp, ((AutocompletePredictionEntity)paramObject).zzaNp)) && (zzw.equal(this.zzaNq, ((AutocompletePredictionEntity)paramObject).zzaNq)));
    return false;
  }
  
  public String getDescription()
  {
    return this.zzaNk;
  }
  
  public CharSequence getFullText(CharacterStyle paramCharacterStyle)
  {
    return zzc.zza(this.zzaNk, this.zzaNl, paramCharacterStyle);
  }
  
  public List<? extends AutocompletePrediction.Substring> getMatchedSubstrings()
  {
    return this.zzaNl;
  }
  
  public String getPlaceId()
  {
    return this.zzaMO;
  }
  
  public List<Integer> getPlaceTypes()
  {
    return this.zzaMp;
  }
  
  public CharSequence getPrimaryText(CharacterStyle paramCharacterStyle)
  {
    return zzc.zza(this.zzaNn, this.zzaNo, paramCharacterStyle);
  }
  
  public CharSequence getSecondaryText(CharacterStyle paramCharacterStyle)
  {
    return zzc.zza(this.zzaNp, this.zzaNq, paramCharacterStyle);
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaMO, this.zzaMp, Integer.valueOf(this.zzaNm), this.zzaNk, this.zzaNl, this.zzaNn, this.zzaNo, this.zzaNp, this.zzaNq });
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("placeId", this.zzaMO).zzg("placeTypes", this.zzaMp).zzg("fullText", this.zzaNk).zzg("fullTextMatchedSubstrings", this.zzaNl).zzg("primaryText", this.zzaNn).zzg("primaryTextMatchedSubstrings", this.zzaNo).zzg("secondaryText", this.zzaNp).zzg("secondaryTextMatchedSubstrings", this.zzaNq).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public AutocompletePrediction zzyt()
  {
    return this;
  }
  
  public static class SubstringEntity
    implements SafeParcelable, AutocompletePrediction.Substring
  {
    public static final Parcelable.Creator<SubstringEntity> CREATOR = new zzv();
    final int mLength;
    final int mOffset;
    final int mVersionCode;
    
    public SubstringEntity(int paramInt1, int paramInt2, int paramInt3)
    {
      this.mVersionCode = paramInt1;
      this.mOffset = paramInt2;
      this.mLength = paramInt3;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof SubstringEntity)) {
          return false;
        }
        paramObject = (SubstringEntity)paramObject;
      } while ((zzw.equal(Integer.valueOf(this.mOffset), Integer.valueOf(((SubstringEntity)paramObject).mOffset))) && (zzw.equal(Integer.valueOf(this.mLength), Integer.valueOf(((SubstringEntity)paramObject).mLength))));
      return false;
    }
    
    public int getLength()
    {
      return this.mLength;
    }
    
    public int getOffset()
    {
      return this.mOffset;
    }
    
    public int hashCode()
    {
      return zzw.hashCode(new Object[] { Integer.valueOf(this.mOffset), Integer.valueOf(this.mLength) });
    }
    
    public String toString()
    {
      return zzw.zzx(this).zzg("offset", Integer.valueOf(this.mOffset)).zzg("length", Integer.valueOf(this.mLength)).toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      zzv.zza(this, paramParcel, paramInt);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/internal/AutocompletePredictionEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */