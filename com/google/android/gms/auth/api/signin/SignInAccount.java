package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

public class SignInAccount
  implements SafeParcelable
{
  public static final Parcelable.Creator<SignInAccount> CREATOR = new zzf();
  final int versionCode;
  private String zzJg;
  private String zzUN;
  private String zzVL;
  private GoogleSignInAccount zzVO;
  private String zzVP;
  private String zzVt;
  private String zzVu;
  private Uri zzVv;
  
  SignInAccount(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Uri paramUri, GoogleSignInAccount paramGoogleSignInAccount, String paramString5, String paramString6)
  {
    this.versionCode = paramInt;
    this.zzVt = zzx.zzh(paramString3, "Email cannot be empty.");
    this.zzVu = paramString4;
    this.zzVv = paramUri;
    this.zzVL = paramString1;
    this.zzUN = paramString2;
    this.zzVO = paramGoogleSignInAccount;
    this.zzJg = zzx.zzcG(paramString5);
    this.zzVP = paramString6;
  }
  
  public static SignInAccount zza(zze paramzze, String paramString1, String paramString2, String paramString3, Uri paramUri, String paramString4, String paramString5)
  {
    String str = null;
    if (paramzze != null) {
      str = paramzze.zzmC();
    }
    return new SignInAccount(2, str, paramString1, paramString2, paramString3, paramUri, null, paramString4, paramString5);
  }
  
  public static SignInAccount zzbJ(String paramString)
    throws JSONException
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    paramString = localJSONObject.optString("photoUrl", null);
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = Uri.parse(paramString);; paramString = null) {
      return zza(zze.zzbI(localJSONObject.optString("providerId", null)), localJSONObject.optString("tokenId", null), localJSONObject.getString("email"), localJSONObject.optString("displayName", null), paramString, localJSONObject.getString("localId"), localJSONObject.optString("refreshToken")).zza(GoogleSignInAccount.zzbE(localJSONObject.optString("googleSignInAccount")));
    }
  }
  
  private JSONObject zzms()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("email", getEmail());
      if (!TextUtils.isEmpty(this.zzVu)) {
        localJSONObject.put("displayName", this.zzVu);
      }
      if (this.zzVv != null) {
        localJSONObject.put("photoUrl", this.zzVv.toString());
      }
      if (!TextUtils.isEmpty(this.zzVL)) {
        localJSONObject.put("providerId", this.zzVL);
      }
      if (!TextUtils.isEmpty(this.zzUN)) {
        localJSONObject.put("tokenId", this.zzUN);
      }
      if (this.zzVO != null) {
        localJSONObject.put("googleSignInAccount", this.zzVO.zzmr());
      }
      if (!TextUtils.isEmpty(this.zzVP)) {
        localJSONObject.put("refreshToken", this.zzVP);
      }
      localJSONObject.put("localId", getUserId());
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getDisplayName()
  {
    return this.zzVu;
  }
  
  public String getEmail()
  {
    return this.zzVt;
  }
  
  public String getIdToken()
  {
    return this.zzUN;
  }
  
  public Uri getPhotoUrl()
  {
    return this.zzVv;
  }
  
  public String getUserId()
  {
    return this.zzJg;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzf.zza(this, paramParcel, paramInt);
  }
  
  public SignInAccount zza(GoogleSignInAccount paramGoogleSignInAccount)
  {
    this.zzVO = paramGoogleSignInAccount;
    return this;
  }
  
  String zzmC()
  {
    return this.zzVL;
  }
  
  public GoogleSignInAccount zzmD()
  {
    return this.zzVO;
  }
  
  public String zzmE()
  {
    return this.zzVP;
  }
  
  public String zzmr()
  {
    return zzms().toString();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/signin/SignInAccount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */