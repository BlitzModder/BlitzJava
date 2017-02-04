package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.Collections;
import java.util.List;

public class Credential
  implements SafeParcelable
{
  public static final Parcelable.Creator<Credential> CREATOR = new zza();
  public static final String EXTRA_KEY = "com.google.android.gms.credentials.Credential";
  private final String mName;
  final int mVersionCode;
  private final String zzUA;
  private final String zzUB;
  private final String zzUC;
  private final String zzUD;
  private final Uri zzUy;
  private final List<IdToken> zzUz;
  private final String zzxX;
  
  Credential(int paramInt, String paramString1, String paramString2, Uri paramUri, List<IdToken> paramList, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.mVersionCode = paramInt;
    paramString1 = ((String)zzx.zzb(paramString1, "credential identifier cannot be null")).trim();
    zzx.zzh(paramString1, "credential identifier cannot be empty");
    this.zzxX = paramString1;
    this.mName = paramString2;
    this.zzUy = paramUri;
    if (paramList == null) {}
    for (paramString1 = Collections.emptyList();; paramString1 = Collections.unmodifiableList(paramList))
    {
      this.zzUz = paramString1;
      this.zzUA = paramString3;
      if ((paramString3 == null) || (!paramString3.isEmpty())) {
        break;
      }
      throw new IllegalArgumentException("password cannot be empty");
    }
    if (!TextUtils.isEmpty(paramString4))
    {
      paramString1 = Uri.parse(paramString4).getScheme();
      if ((!"http".equalsIgnoreCase(paramString1)) && (!"https".equalsIgnoreCase(paramString1))) {
        break label188;
      }
    }
    label188:
    for (boolean bool = true;; bool = false)
    {
      zzx.zzab(bool);
      this.zzUB = paramString4;
      this.zzUC = paramString5;
      this.zzUD = paramString6;
      if ((TextUtils.isEmpty(this.zzUA)) || (TextUtils.isEmpty(this.zzUB))) {
        break;
      }
      throw new IllegalStateException("password and accountType cannot both be set");
    }
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
      if (!(paramObject instanceof Credential)) {
        return false;
      }
      paramObject = (Credential)paramObject;
    } while ((TextUtils.equals(this.zzxX, ((Credential)paramObject).zzxX)) && (TextUtils.equals(this.mName, ((Credential)paramObject).mName)) && (zzw.equal(this.zzUy, ((Credential)paramObject).zzUy)) && (TextUtils.equals(this.zzUA, ((Credential)paramObject).zzUA)) && (TextUtils.equals(this.zzUB, ((Credential)paramObject).zzUB)) && (TextUtils.equals(this.zzUC, ((Credential)paramObject).zzUC)));
    return false;
  }
  
  public String getAccountType()
  {
    return this.zzUB;
  }
  
  public String getGeneratedPassword()
  {
    return this.zzUC;
  }
  
  public String getId()
  {
    return this.zzxX;
  }
  
  public List<IdToken> getIdTokens()
  {
    return this.zzUz;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getPassword()
  {
    return this.zzUA;
  }
  
  public Uri getProfilePictureUri()
  {
    return this.zzUy;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzxX, this.mName, this.zzUy, this.zzUA, this.zzUB, this.zzUC });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public String zzmg()
  {
    return this.zzUD;
  }
  
  public static class Builder
  {
    private String mName;
    private String zzUA;
    private String zzUB;
    private String zzUC;
    private String zzUD;
    private Uri zzUy;
    private List<IdToken> zzUz;
    private final String zzxX;
    
    public Builder(Credential paramCredential)
    {
      this.zzxX = Credential.zza(paramCredential);
      this.mName = Credential.zzb(paramCredential);
      this.zzUy = Credential.zzc(paramCredential);
      this.zzUz = Credential.zzd(paramCredential);
      this.zzUA = Credential.zze(paramCredential);
      this.zzUB = Credential.zzf(paramCredential);
      this.zzUC = Credential.zzg(paramCredential);
      this.zzUD = Credential.zzh(paramCredential);
    }
    
    public Builder(String paramString)
    {
      this.zzxX = paramString;
    }
    
    public Credential build()
    {
      return new Credential(3, this.zzxX, this.mName, this.zzUy, this.zzUz, this.zzUA, this.zzUB, this.zzUC, this.zzUD);
    }
    
    public Builder setAccountType(String paramString)
    {
      this.zzUB = paramString;
      return this;
    }
    
    public Builder setName(String paramString)
    {
      this.mName = paramString;
      return this;
    }
    
    public Builder setPassword(String paramString)
    {
      this.zzUA = paramString;
      return this;
    }
    
    public Builder setProfilePictureUri(Uri paramUri)
    {
      this.zzUy = paramUri;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/credentials/Credential.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */