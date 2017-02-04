package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Patterns;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class EmailSignInOptions
  implements SafeParcelable
{
  public static final Parcelable.Creator<EmailSignInOptions> CREATOR = new zza();
  final int versionCode;
  private final Uri zzVo;
  private String zzVp;
  private Uri zzVq;
  
  EmailSignInOptions(int paramInt, Uri paramUri1, String paramString, Uri paramUri2)
  {
    zzx.zzb(paramUri1, "Server widget url cannot be null in order to use email/password sign in.");
    zzx.zzh(paramUri1.toString(), "Server widget url cannot be null in order to use email/password sign in.");
    zzx.zzb(Patterns.WEB_URL.matcher(paramUri1.toString()).matches(), "Invalid server widget url");
    this.versionCode = paramInt;
    this.zzVo = paramUri1;
    this.zzVp = paramString;
    this.zzVq = paramUri2;
  }
  
  private JSONObject zzms()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("serverWidgetUrl", this.zzVo.toString());
      if (!TextUtils.isEmpty(this.zzVp)) {
        localJSONObject.put("modeQueryName", this.zzVp);
      }
      if (this.zzVq != null) {
        localJSONObject.put("tosUrl", this.zzVq.toString());
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
        paramObject = (EmailSignInOptions)paramObject;
        if (this.zzVo.equals(((EmailSignInOptions)paramObject).zzmo())) {
          if (this.zzVq == null)
          {
            if (((EmailSignInOptions)paramObject).zzmp() != null) {}
          }
          else
          {
            for (;;)
            {
              if (!TextUtils.isEmpty(this.zzVp)) {
                break label79;
              }
              if (!TextUtils.isEmpty(((EmailSignInOptions)paramObject).zzmq())) {
                break;
              }
              break label101;
              if (!this.zzVq.equals(((EmailSignInOptions)paramObject).zzmp())) {
                break;
              }
            }
            label79:
            boolean bool = this.zzVp.equals(((EmailSignInOptions)paramObject).zzmq());
            if (!bool) {}
          }
        }
      }
      catch (ClassCastException paramObject)
      {
        return false;
      }
    }
    label101:
    return true;
  }
  
  public int hashCode()
  {
    return new zze().zzo(this.zzVo).zzo(this.zzVq).zzo(this.zzVp).zzmM();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public Uri zzmo()
  {
    return this.zzVo;
  }
  
  public Uri zzmp()
  {
    return this.zzVq;
  }
  
  public String zzmq()
  {
    return this.zzVp;
  }
  
  public String zzmr()
  {
    return zzms().toString();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/signin/EmailSignInOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */