package com.google.android.gms.identity.intents;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.identity.intents.model.CountrySpecification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public final class UserAddressRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<UserAddressRequest> CREATOR = new zza();
  private final int mVersionCode;
  List<CountrySpecification> zzaJN;
  
  UserAddressRequest()
  {
    this.mVersionCode = 1;
  }
  
  UserAddressRequest(int paramInt, List<CountrySpecification> paramList)
  {
    this.mVersionCode = paramInt;
    this.zzaJN = paramList;
  }
  
  public static Builder newBuilder()
  {
    UserAddressRequest localUserAddressRequest = new UserAddressRequest();
    localUserAddressRequest.getClass();
    return new Builder(null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public final class Builder
  {
    private Builder() {}
    
    public Builder addAllowedCountrySpecification(CountrySpecification paramCountrySpecification)
    {
      if (UserAddressRequest.this.zzaJN == null) {
        UserAddressRequest.this.zzaJN = new ArrayList();
      }
      UserAddressRequest.this.zzaJN.add(paramCountrySpecification);
      return this;
    }
    
    public Builder addAllowedCountrySpecifications(Collection<CountrySpecification> paramCollection)
    {
      if (UserAddressRequest.this.zzaJN == null) {
        UserAddressRequest.this.zzaJN = new ArrayList();
      }
      UserAddressRequest.this.zzaJN.addAll(paramCollection);
      return this;
    }
    
    public UserAddressRequest build()
    {
      if (UserAddressRequest.this.zzaJN != null) {
        UserAddressRequest.this.zzaJN = Collections.unmodifiableList(UserAddressRequest.this.zzaJN);
      }
      return UserAddressRequest.this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/identity/intents/UserAddressRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */