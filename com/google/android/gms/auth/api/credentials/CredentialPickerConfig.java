package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class CredentialPickerConfig
  implements SafeParcelable
{
  public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new zzb();
  private final boolean mShowCancelButton;
  final int mVersionCode;
  private final boolean zzUE;
  private final boolean zzUF;
  
  CredentialPickerConfig(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.mVersionCode = paramInt;
    this.zzUE = paramBoolean1;
    this.mShowCancelButton = paramBoolean2;
    this.zzUF = paramBoolean3;
  }
  
  private CredentialPickerConfig(Builder paramBuilder)
  {
    this(1, Builder.zza(paramBuilder), Builder.zzb(paramBuilder), Builder.zzc(paramBuilder));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean isForNewAccount()
  {
    return this.zzUF;
  }
  
  public boolean shouldShowAddAccountButton()
  {
    return this.zzUE;
  }
  
  public boolean shouldShowCancelButton()
  {
    return this.mShowCancelButton;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private boolean mShowCancelButton = true;
    private boolean zzUE = false;
    private boolean zzUF = false;
    
    public CredentialPickerConfig build()
    {
      return new CredentialPickerConfig(this, null);
    }
    
    public Builder setForNewAccount(boolean paramBoolean)
    {
      this.zzUF = paramBoolean;
      return this;
    }
    
    public Builder setShowAddAccountButton(boolean paramBoolean)
    {
      this.zzUE = paramBoolean;
      return this;
    }
    
    public Builder setShowCancelButton(boolean paramBoolean)
    {
      this.mShowCancelButton = paramBoolean;
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/credentials/CredentialPickerConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */