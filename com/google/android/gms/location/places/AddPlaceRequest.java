package com.google.android.gms.location.places;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzw.zza;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AddPlaceRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<AddPlaceRequest> CREATOR = new zzb();
  private final String mName;
  final int mVersionCode;
  private final LatLng zzaMo;
  private final List<Integer> zzaMp;
  private final String zzaMq;
  private final Uri zzaMr;
  private final String zzatX;
  
  AddPlaceRequest(int paramInt, String paramString1, LatLng paramLatLng, String paramString2, List<Integer> paramList, String paramString3, Uri paramUri)
  {
    this.mVersionCode = paramInt;
    this.mName = zzx.zzcG(paramString1);
    this.zzaMo = ((LatLng)zzx.zzy(paramLatLng));
    this.zzatX = zzx.zzcG(paramString2);
    this.zzaMp = new ArrayList((Collection)zzx.zzy(paramList));
    if (!this.zzaMp.isEmpty()) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      zzx.zzb(bool1, "At least one place type should be provided.");
      if (TextUtils.isEmpty(paramString3))
      {
        bool1 = bool2;
        if (paramUri == null) {}
      }
      else
      {
        bool1 = true;
      }
      zzx.zzb(bool1, "One of phone number or URI should be provided.");
      this.zzaMq = paramString3;
      this.zzaMr = paramUri;
      return;
    }
  }
  
  public AddPlaceRequest(String paramString1, LatLng paramLatLng, String paramString2, List<Integer> paramList, Uri paramUri)
  {
    this(paramString1, paramLatLng, paramString2, paramList, null, (Uri)zzx.zzy(paramUri));
  }
  
  public AddPlaceRequest(String paramString1, LatLng paramLatLng, String paramString2, List<Integer> paramList, String paramString3)
  {
    this(paramString1, paramLatLng, paramString2, paramList, zzx.zzcG(paramString3), null);
  }
  
  public AddPlaceRequest(String paramString1, LatLng paramLatLng, String paramString2, List<Integer> paramList, String paramString3, Uri paramUri)
  {
    this(0, paramString1, paramLatLng, paramString2, paramList, paramString3, paramUri);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAddress()
  {
    return this.zzatX;
  }
  
  public LatLng getLatLng()
  {
    return this.zzaMo;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getPhoneNumber()
  {
    return this.zzaMq;
  }
  
  public List<Integer> getPlaceTypes()
  {
    return this.zzaMp;
  }
  
  public Uri getWebsiteUri()
  {
    return this.zzaMr;
  }
  
  public String toString()
  {
    return zzw.zzx(this).zzg("name", this.mName).zzg("latLng", this.zzaMo).zzg("address", this.zzatX).zzg("placeTypes", this.zzaMp).zzg("phoneNumer", this.zzaMq).zzg("websiteUri", this.zzaMr).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/location/places/AddPlaceRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */