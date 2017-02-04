package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zznl;
import com.google.android.gms.internal.zzno;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount
  implements SafeParcelable
{
  public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zzc();
  public static zznl zzVs = zzno.zzrM();
  private static Comparator<Scope> zzVz = new Comparator()
  {
    public int zza(Scope paramAnonymousScope1, Scope paramAnonymousScope2)
    {
      return paramAnonymousScope1.zzoM().compareTo(paramAnonymousScope2.zzoM());
    }
  };
  final int versionCode;
  List<Scope> zzTV;
  private String zzUN;
  private String zzVt;
  private String zzVu;
  private Uri zzVv;
  private String zzVw;
  private long zzVx;
  private String zzVy;
  private String zzxX;
  
  GoogleSignInAccount(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, String paramString5, long paramLong, String paramString6, List<Scope> paramList)
  {
    this.versionCode = paramInt;
    this.zzxX = paramString1;
    this.zzUN = paramString2;
    this.zzVt = paramString3;
    this.zzVu = paramString4;
    this.zzVv = paramUri;
    this.zzVw = paramString5;
    this.zzVx = paramLong;
    this.zzVy = paramString6;
    this.zzTV = paramList;
  }
  
  public static GoogleSignInAccount zza(String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, Long paramLong, String paramString5, Set<Scope> paramSet)
  {
    Long localLong = paramLong;
    if (paramLong == null) {
      localLong = Long.valueOf(zzVs.currentTimeMillis() / 1000L);
    }
    return new GoogleSignInAccount(2, paramString1, paramString2, paramString3, paramString4, paramUri, null, localLong.longValue(), zzx.zzcG(paramString5), new ArrayList((Collection)zzx.zzy(paramSet)));
  }
  
  public static GoogleSignInAccount zzbE(String paramString)
    throws JSONException
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    paramString = localJSONObject.optString("photoUrl", null);
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = Uri.parse(paramString);; paramString = null)
    {
      long l = Long.parseLong(localJSONObject.getString("expirationTime"));
      HashSet localHashSet = new HashSet();
      JSONArray localJSONArray = localJSONObject.getJSONArray("grantedScopes");
      int j = localJSONArray.length();
      int i = 0;
      while (i < j)
      {
        localHashSet.add(new Scope(localJSONArray.getString(i)));
        i += 1;
      }
      return zza(localJSONObject.optString("id"), localJSONObject.optString("tokenId", null), localJSONObject.optString("email", null), localJSONObject.optString("displayName", null), paramString, Long.valueOf(l), localJSONObject.getString("obfuscatedIdentifier"), localHashSet).zzbF(localJSONObject.optString("serverAuthCode", null));
    }
  }
  
  private JSONObject zzms()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (getId() != null) {
        localJSONObject.put("id", getId());
      }
      if (getIdToken() != null) {
        localJSONObject.put("tokenId", getIdToken());
      }
      if (getEmail() != null) {
        localJSONObject.put("email", getEmail());
      }
      if (getDisplayName() != null) {
        localJSONObject.put("displayName", getDisplayName());
      }
      if (getPhotoUrl() != null) {
        localJSONObject.put("photoUrl", getPhotoUrl().toString());
      }
      if (getServerAuthCode() != null) {
        localJSONObject.put("serverAuthCode", getServerAuthCode());
      }
      localJSONObject.put("expirationTime", this.zzVx);
      localJSONObject.put("obfuscatedIdentifier", zzmw());
      JSONArray localJSONArray = new JSONArray();
      Collections.sort(this.zzTV, zzVz);
      Iterator localIterator = this.zzTV.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((Scope)localIterator.next()).zzoM());
      }
      localJSONException.put("grantedScopes", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
    return localJSONException;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GoogleSignInAccount)) {
      return false;
    }
    return ((GoogleSignInAccount)paramObject).zzmr().equals(zzmr());
  }
  
  public String getDisplayName()
  {
    return this.zzVu;
  }
  
  public String getEmail()
  {
    return this.zzVt;
  }
  
  public Set<Scope> getGrantedScopes()
  {
    return new HashSet(this.zzTV);
  }
  
  public String getId()
  {
    return this.zzxX;
  }
  
  public String getIdToken()
  {
    return this.zzUN;
  }
  
  public Uri getPhotoUrl()
  {
    return this.zzVv;
  }
  
  public String getServerAuthCode()
  {
    return this.zzVw;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public boolean zzb()
  {
    return zzVs.currentTimeMillis() / 1000L >= this.zzVx - 300L;
  }
  
  public GoogleSignInAccount zzbF(String paramString)
  {
    this.zzVw = paramString;
    return this;
  }
  
  public String zzmr()
  {
    return zzms().toString();
  }
  
  public long zzmv()
  {
    return this.zzVx;
  }
  
  public String zzmw()
  {
    return this.zzVy;
  }
  
  public String zzmx()
  {
    JSONObject localJSONObject = zzms();
    localJSONObject.remove("serverAuthCode");
    return localJSONObject.toString();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/signin/GoogleSignInAccount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */