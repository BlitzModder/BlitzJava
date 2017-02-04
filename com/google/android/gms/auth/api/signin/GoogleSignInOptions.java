package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInOptions
  implements Api.ApiOptions.Optional, SafeParcelable
{
  public static final Parcelable.Creator<GoogleSignInOptions> CREATOR = new zzd();
  public static final GoogleSignInOptions DEFAULT_SIGN_IN;
  public static final Scope zzVA = new Scope("profile");
  public static final Scope zzVB = new Scope("email");
  public static final Scope zzVC = new Scope("openid");
  final int versionCode;
  private Account zzSo;
  private boolean zzVD;
  private final boolean zzVE;
  private final boolean zzVF;
  private String zzVG;
  private final ArrayList<Scope> zzVr;
  
  static
  {
    DEFAULT_SIGN_IN = new Builder().requestId().requestProfile().build();
  }
  
  GoogleSignInOptions(int paramInt, ArrayList<Scope> paramArrayList, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    this.versionCode = paramInt;
    this.zzVr = paramArrayList;
    this.zzSo = paramAccount;
    this.zzVD = paramBoolean1;
    this.zzVE = paramBoolean2;
    this.zzVF = paramBoolean3;
    this.zzVG = paramString;
  }
  
  private GoogleSignInOptions(Set<Scope> paramSet, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString)
  {
    this(1, new ArrayList(paramSet), paramAccount, paramBoolean1, paramBoolean2, paramBoolean3, paramString);
  }
  
  public static GoogleSignInOptions zzbG(String paramString)
    throws JSONException
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject(paramString);
    HashSet localHashSet = new HashSet();
    paramString = localJSONObject.getJSONArray("scopes");
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      localHashSet.add(new Scope(paramString.getString(i)));
      i += 1;
    }
    paramString = localJSONObject.optString("accountName", null);
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = new Account(paramString, "com.google");; paramString = null)
    {
      String str = localJSONObject.optString("serverClientId", null);
      return new GoogleSignInOptions(localHashSet, paramString, localJSONObject.getBoolean("idTokenRequested"), localJSONObject.getBoolean("serverAuthRequested"), localJSONObject.getBoolean("forceCodeForRefreshToken"), str);
    }
  }
  
  private JSONObject zzms()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.zzVr.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(((Scope)localIterator.next()).zzoM());
      }
      localJSONException.put("scopes", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      throw new RuntimeException(localJSONException);
    }
    if (this.zzSo != null) {
      localJSONException.put("accountName", this.zzSo.name);
    }
    localJSONException.put("idTokenRequested", this.zzVD);
    localJSONException.put("forceCodeForRefreshToken", this.zzVF);
    localJSONException.put("serverAuthRequested", this.zzVE);
    if (!TextUtils.isEmpty(this.zzVG)) {
      localJSONException.put("serverClientId", this.zzVG);
    }
    return localJSONException;
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
        paramObject = (GoogleSignInOptions)paramObject;
        if ((this.zzVr.size() != ((GoogleSignInOptions)paramObject).zzmu().size()) || (!this.zzVr.containsAll(((GoogleSignInOptions)paramObject).zzmu()))) {
          continue;
        }
        if (this.zzSo == null)
        {
          if (((GoogleSignInOptions)paramObject).getAccount() != null) {
            continue;
          }
          label56:
          if (!TextUtils.isEmpty(this.zzVG)) {
            break label128;
          }
          if (!TextUtils.isEmpty(((GoogleSignInOptions)paramObject).zzmB())) {
            continue;
          }
        }
        while ((this.zzVF == ((GoogleSignInOptions)paramObject).zzmA()) && (this.zzVD == ((GoogleSignInOptions)paramObject).zzmy()) && (this.zzVE == ((GoogleSignInOptions)paramObject).zzmz()))
        {
          return true;
          if (!this.zzSo.equals(((GoogleSignInOptions)paramObject).getAccount())) {
            break;
          }
          break label56;
          label128:
          boolean bool = this.zzVG.equals(((GoogleSignInOptions)paramObject).zzmB());
          if (!bool) {
            break;
          }
        }
        return false;
      }
      catch (ClassCastException paramObject) {}
    }
  }
  
  public Account getAccount()
  {
    return this.zzSo;
  }
  
  public Scope[] getScopeArray()
  {
    return (Scope[])this.zzVr.toArray(new Scope[this.zzVr.size()]);
  }
  
  public int hashCode()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zzVr.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Scope)localIterator.next()).zzoM());
    }
    Collections.sort(localArrayList);
    return new zze().zzo(localArrayList).zzo(this.zzSo).zzo(this.zzVG).zzP(this.zzVF).zzP(this.zzVD).zzP(this.zzVE).zzmM();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
  
  public boolean zzmA()
  {
    return this.zzVF;
  }
  
  public String zzmB()
  {
    return this.zzVG;
  }
  
  public String zzmr()
  {
    return zzms().toString();
  }
  
  public ArrayList<Scope> zzmu()
  {
    return new ArrayList(this.zzVr);
  }
  
  public boolean zzmy()
  {
    return this.zzVD;
  }
  
  public boolean zzmz()
  {
    return this.zzVE;
  }
  
  public static final class Builder
  {
    private Account zzSo;
    private boolean zzVD;
    private boolean zzVE;
    private boolean zzVF;
    private String zzVG;
    private Set<Scope> zzVH = new HashSet();
    
    public Builder() {}
    
    public Builder(GoogleSignInOptions paramGoogleSignInOptions)
    {
      zzx.zzy(paramGoogleSignInOptions);
      this.zzVH = new HashSet(GoogleSignInOptions.zzb(paramGoogleSignInOptions));
      this.zzVE = GoogleSignInOptions.zzc(paramGoogleSignInOptions);
      this.zzVF = GoogleSignInOptions.zzd(paramGoogleSignInOptions);
      this.zzVD = GoogleSignInOptions.zze(paramGoogleSignInOptions);
      this.zzVG = GoogleSignInOptions.zzf(paramGoogleSignInOptions);
      this.zzSo = GoogleSignInOptions.zzg(paramGoogleSignInOptions);
    }
    
    private String zzbH(String paramString)
    {
      zzx.zzcG(paramString);
      if ((this.zzVG == null) || (this.zzVG.equals(paramString))) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zzb(bool, "two different server client ids provided");
        return paramString;
      }
    }
    
    public GoogleSignInOptions build()
    {
      return new GoogleSignInOptions(this.zzVH, this.zzSo, this.zzVD, this.zzVE, this.zzVF, this.zzVG, null);
    }
    
    public Builder requestEmail()
    {
      this.zzVH.add(GoogleSignInOptions.zzVB);
      return this;
    }
    
    public Builder requestId()
    {
      this.zzVH.add(GoogleSignInOptions.zzVC);
      return this;
    }
    
    public Builder requestIdToken(String paramString)
    {
      requestId();
      this.zzVD = true;
      this.zzVG = zzbH(paramString);
      return this;
    }
    
    public Builder requestProfile()
    {
      this.zzVH.add(GoogleSignInOptions.zzVA);
      return this;
    }
    
    public Builder requestScopes(Scope paramScope, Scope... paramVarArgs)
    {
      this.zzVH.add(paramScope);
      this.zzVH.addAll(Arrays.asList(paramVarArgs));
      return this;
    }
    
    public Builder requestServerAuthCode(String paramString)
    {
      return requestServerAuthCode(paramString, false);
    }
    
    public Builder requestServerAuthCode(String paramString, boolean paramBoolean)
    {
      this.zzVE = true;
      this.zzVG = zzbH(paramString);
      this.zzVF = paramBoolean;
      return this;
    }
    
    public Builder setAccountName(String paramString)
    {
      this.zzSo = new Account(zzx.zzcG(paramString), "com.google");
      return this;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/auth/api/signin/GoogleSignInOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */