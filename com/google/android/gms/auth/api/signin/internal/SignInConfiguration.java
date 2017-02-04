package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.FacebookSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

public final class SignInConfiguration
  implements SafeParcelable
{
  public static final Parcelable.Creator<SignInConfiguration> CREATOR = new zzm();
  final int versionCode;
  private String zzVG;
  private final String zzWh;
  private EmailSignInOptions zzWi;
  private GoogleSignInOptions zzWj;
  private FacebookSignInOptions zzWk;
  private String zzWl;
  
  SignInConfiguration(int paramInt, String paramString1, String paramString2, EmailSignInOptions paramEmailSignInOptions, GoogleSignInOptions paramGoogleSignInOptions, FacebookSignInOptions paramFacebookSignInOptions, String paramString3)
  {
    this.versionCode = paramInt;
    this.zzWh = zzx.zzcG(paramString1);
    this.zzVG = paramString2;
    this.zzWi = paramEmailSignInOptions;
    this.zzWj = paramGoogleSignInOptions;
    this.zzWk = paramFacebookSignInOptions;
    this.zzWl = paramString3;
  }
  
  public SignInConfiguration(String paramString)
  {
    this(2, paramString, null, null, null, null, null);
  }
  
  private JSONObject zzms()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("consumerPackageName", this.zzWh);
      if (!TextUtils.isEmpty(this.zzVG)) {
        localJSONObject.put("serverClientId", this.zzVG);
      }
      if (this.zzWi != null) {
        localJSONObject.put("emailSignInOptions", this.zzWi.zzmr());
      }
      if (this.zzWj != null) {
        localJSONObject.put("googleSignInOptions", this.zzWj.zzmr());
      }
      if (this.zzWk != null) {
        localJSONObject.put("facebookSignInOptions", this.zzWk.zzmr());
      }
      if (!TextUtils.isEmpty(this.zzWl)) {
        localJSONObject.put("apiKey", this.zzWl);
      }
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
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramObject = (SignInConfiguration)paramObject;
        if (this.zzWh.equals(((SignInConfiguration)paramObject).zzmP()))
        {
          if (TextUtils.isEmpty(this.zzVG))
          {
            if (!TextUtils.isEmpty(((SignInConfiguration)paramObject).zzmB())) {
              continue;
            }
            label45:
            if (!TextUtils.isEmpty(this.zzWl)) {
              break label127;
            }
            if (!TextUtils.isEmpty(((SignInConfiguration)paramObject).zzmT())) {
              continue;
            }
            label65:
            if (this.zzWi != null) {
              break label144;
            }
            if (((SignInConfiguration)paramObject).zzmQ() != null) {
              continue;
            }
            label79:
            if (this.zzWk != null) {
              break label161;
            }
            if (((SignInConfiguration)paramObject).zzmS() != null) {
              continue;
            }
          }
          for (;;)
          {
            if (this.zzWj != null) {
              break label178;
            }
            if (((SignInConfiguration)paramObject).zzmR() != null) {
              break;
            }
            break label200;
            if (!this.zzVG.equals(((SignInConfiguration)paramObject).zzmB())) {
              break;
            }
            break label45;
            label127:
            if (!this.zzWl.equals(((SignInConfiguration)paramObject).zzmT())) {
              break;
            }
            break label65;
            label144:
            if (!this.zzWi.equals(((SignInConfiguration)paramObject).zzmQ())) {
              break;
            }
            break label79;
            label161:
            if (!this.zzWk.equals(((SignInConfiguration)paramObject).zzmS())) {
              break;
            }
          }
          label178:
          boolean bool = this.zzWj.equals(((SignInConfiguration)paramObject).zzmR());
          if (!bool) {}
        }
      }
      catch (ClassCastException paramObject)
      {
        return false;
      }
    }
    label200:
    return true;
  }
  
  public int hashCode()
  {
    return new zze().zzo(this.zzWh).zzo(this.zzVG).zzo(this.zzWl).zzo(this.zzWi).zzo(this.zzWj).zzo(this.zzWk).zzmM();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzm.zza(this, paramParcel, paramInt);
  }
  
  public SignInConfiguration zzi(GoogleSignInOptions paramGoogleSignInOptions)
  {
    this.zzWj = ((GoogleSignInOptions)zzx.zzb(paramGoogleSignInOptions, "GoogleSignInOptions cannot be null."));
    return this;
  }
  
  public String zzmB()
  {
    return this.zzVG;
  }
  
  public String zzmP()
  {
    return this.zzWh;
  }
  
  public EmailSignInOptions zzmQ()
  {
    return this.zzWi;
  }
  
  public GoogleSignInOptions zzmR()
  {
    return this.zzWj;
  }
  
  public FacebookSignInOptions zzmS()
  {
    return this.zzWk;
  }
  
  public String zzmT()
  {
    return this.zzWl;
  }
  
  public String zzmr()
  {
    return zzms().toString();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/signin/internal/SignInConfiguration.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */