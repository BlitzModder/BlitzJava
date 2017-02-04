package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class CredentialRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<CredentialRequest> CREATOR = new zzc();
  final int mVersionCode;
  private final boolean zzUG;
  private final String[] zzUH;
  private final CredentialPickerConfig zzUI;
  private final CredentialPickerConfig zzUJ;
  
  CredentialRequest(int paramInt, boolean paramBoolean, String[] paramArrayOfString, CredentialPickerConfig paramCredentialPickerConfig1, CredentialPickerConfig paramCredentialPickerConfig2)
  {
    this.mVersionCode = paramInt;
    this.zzUG = paramBoolean;
    this.zzUH = ((String[])zzx.zzy(paramArrayOfString));
    paramArrayOfString = paramCredentialPickerConfig1;
    if (paramCredentialPickerConfig1 == null) {
      paramArrayOfString = new CredentialPickerConfig.Builder().build();
    }
    this.zzUI = paramArrayOfString;
    paramArrayOfString = paramCredentialPickerConfig2;
    if (paramCredentialPickerConfig2 == null) {
      paramArrayOfString = new CredentialPickerConfig.Builder().build();
    }
    this.zzUJ = paramArrayOfString;
  }
  
  private CredentialRequest(Builder paramBuilder)
  {
    this(2, Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder), Builder.zzd(paramBuilder));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String[] getAccountTypes()
  {
    return this.zzUH;
  }
  
  public CredentialPickerConfig getCredentialHintPickerConfig()
  {
    return this.zzUJ;
  }
  
  public CredentialPickerConfig getCredentialPickerConfig()
  {
    return this.zzUI;
  }
  
  @Deprecated
  public boolean getSupportsPasswordLogin()
  {
    return isPasswordLoginSupported();
  }
  
  public boolean isPasswordLoginSupported()
  {
    return this.zzUG;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzc.zza(this, paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    private boolean zzUG;
    private String[] zzUH;
    private CredentialPickerConfig zzUI;
    private CredentialPickerConfig zzUJ;
    
    public CredentialRequest build()
    {
      if (this.zzUH == null) {
        this.zzUH = new String[0];
      }
      if ((!this.zzUG) && (this.zzUH.length == 0)) {
        throw new IllegalStateException("At least one authentication method must be specified");
      }
      return new CredentialRequest(this, null);
    }
    
    public Builder setAccountTypes(String... paramVarArgs)
    {
      String[] arrayOfString = paramVarArgs;
      if (paramVarArgs == null) {
        arrayOfString = new String[0];
      }
      this.zzUH = arrayOfString;
      return this;
    }
    
    public Builder setCredentialHintPickerConfig(CredentialPickerConfig paramCredentialPickerConfig)
    {
      this.zzUJ = paramCredentialPickerConfig;
      return this;
    }
    
    public Builder setCredentialPickerConfig(CredentialPickerConfig paramCredentialPickerConfig)
    {
      this.zzUI = paramCredentialPickerConfig;
      return this;
    }
    
    public Builder setPasswordLoginSupported(boolean paramBoolean)
    {
      this.zzUG = paramBoolean;
      return this;
    }
    
    @Deprecated
    public Builder setSupportsPasswordLogin(boolean paramBoolean)
    {
      return setPasswordLoginSupported(paramBoolean);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/credentials/CredentialRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */