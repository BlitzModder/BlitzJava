package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import org.json.JSONException;
import org.json.JSONObject;

public final class WebImage
  implements SafeParcelable
{
  public static final Parcelable.Creator<WebImage> CREATOR = new zzb();
  private final int mVersionCode;
  private final Uri zzair;
  private final int zzov;
  private final int zzow;
  
  WebImage(int paramInt1, Uri paramUri, int paramInt2, int paramInt3)
  {
    this.mVersionCode = paramInt1;
    this.zzair = paramUri;
    this.zzov = paramInt2;
    this.zzow = paramInt3;
  }
  
  public WebImage(Uri paramUri)
    throws IllegalArgumentException
  {
    this(paramUri, 0, 0);
  }
  
  public WebImage(Uri paramUri, int paramInt1, int paramInt2)
    throws IllegalArgumentException
  {
    this(1, paramUri, paramInt1, paramInt2);
    if (paramUri == null) {
      throw new IllegalArgumentException("url cannot be null");
    }
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      throw new IllegalArgumentException("width and height must not be negative");
    }
  }
  
  public WebImage(JSONObject paramJSONObject)
    throws IllegalArgumentException
  {
    this(zzi(paramJSONObject), paramJSONObject.optInt("width", 0), paramJSONObject.optInt("height", 0));
  }
  
  private static Uri zzi(JSONObject paramJSONObject)
  {
    Uri localUri = null;
    if (paramJSONObject.has("url")) {}
    try
    {
      localUri = Uri.parse(paramJSONObject.getString("url"));
      return localUri;
    }
    catch (JSONException paramJSONObject) {}
    return null;
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
      if ((paramObject == null) || (!(paramObject instanceof WebImage))) {
        return false;
      }
      paramObject = (WebImage)paramObject;
    } while ((zzw.equal(this.zzair, ((WebImage)paramObject).zzair)) && (this.zzov == ((WebImage)paramObject).zzov) && (this.zzow == ((WebImage)paramObject).zzow));
    return false;
  }
  
  public int getHeight()
  {
    return this.zzow;
  }
  
  public Uri getUrl()
  {
    return this.zzair;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int getWidth()
  {
    return this.zzov;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzair, Integer.valueOf(this.zzov), Integer.valueOf(this.zzow) });
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("url", this.zzair.toString());
      localJSONObject.put("width", this.zzov);
      localJSONObject.put("height", this.zzow);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public String toString()
  {
    return String.format("Image %dx%d %s", new Object[] { Integer.valueOf(this.zzov), Integer.valueOf(this.zzow), this.zzair.toString() });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/images/WebImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */