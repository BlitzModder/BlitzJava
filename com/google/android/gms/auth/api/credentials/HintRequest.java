package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class HintRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<HintRequest> CREATOR = new zzd();
  final int mVersionCode;
  private final String[] zzUH;
  private final CredentialPickerConfig zzUK;
  private final boolean zzUL;
  private final boolean zzUM;
  
  HintRequest(int paramInt, CredentialPickerConfig paramCredentialPickerConfig, boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString)
  {
    this.mVersionCode = paramInt;
    this.zzUK = ((CredentialPickerConfig)zzx.zzy(paramCredentialPickerConfig));
    this.zzUL = paramBoolean1;
    this.zzUM = paramBoolean2;
    this.zzUH = ((String[])zzx.zzy(paramArrayOfString));
  }
  
  private HintRequest(Builder paramBuilder)
  {
    this(1, Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder), Builder.zzd(paramBuilder));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String[] getAccountTypes()
  {
    return this.zzUH;
  }
  
  public CredentialPickerConfig getHintPickerConfig()
  {
    return this.zzUK;
  }
  
  public boolean isEmailAddressIdentifierSupported()
  {
    return this.zzUL;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public boolean zzmh()
  {
    return this.zzUM;
  }
  
  public static final class Builder
  {
    private String[] zzUH;
    private CredentialPickerConfig zzUK = new CredentialPickerConfig.Builder().build();
    private boolean zzUL;
    private boolean zzUM;
    
    public HintRequest build()
    {
      if (this.zzUH == null) {
        this.zzUH = new String[0];
      }
      if ((!this.zzUL) && (!this.zzUM) && (this.zzUH.length == 0)) {
        throw new IllegalStateException("At least one authentication method must be specified");
      }
      return new HintRequest(this, null);
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
    
    public Builder setEmailAddressIdentifierSupported(boolean paramBoolean)
    {
      this.zzUL = paramBoolean;
      return this;
    }
    
    public Builder setHintPickerConfig(CredentialPickerConfig paramCredentialPickerConfig)
    {
      this.zzUK = ((CredentialPickerConfig)zzx.zzy(paramCredentialPickerConfig));
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/credentials/HintRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */