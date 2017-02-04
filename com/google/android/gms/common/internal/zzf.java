package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.zzsd;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class zzf
{
  private final Account zzSo;
  private final String zzTz;
  private final Set<Scope> zzaeA;
  private final int zzaeC;
  private final View zzaeD;
  private final String zzaeE;
  private final zzsd zzaeP;
  private final Set<Scope> zzajr;
  private final Map<Api<?>, zza> zzajs;
  private Integer zzajt;
  
  public zzf(Account paramAccount, Set<Scope> paramSet, Map<Api<?>, zza> paramMap, int paramInt, View paramView, String paramString1, String paramString2, zzsd paramzzsd)
  {
    this.zzSo = paramAccount;
    if (paramSet == null) {}
    for (paramAccount = Collections.EMPTY_SET;; paramAccount = Collections.unmodifiableSet(paramSet))
    {
      this.zzaeA = paramAccount;
      paramAccount = paramMap;
      if (paramMap == null) {
        paramAccount = Collections.EMPTY_MAP;
      }
      this.zzajs = paramAccount;
      this.zzaeD = paramView;
      this.zzaeC = paramInt;
      this.zzTz = paramString1;
      this.zzaeE = paramString2;
      this.zzaeP = paramzzsd;
      paramAccount = new HashSet(this.zzaeA);
      paramSet = this.zzajs.values().iterator();
      while (paramSet.hasNext()) {
        paramAccount.addAll(((zza)paramSet.next()).zzVH);
      }
    }
    this.zzajr = Collections.unmodifiableSet(paramAccount);
  }
  
  public static zzf zzas(Context paramContext)
  {
    return new GoogleApiClient.Builder(paramContext).zzoH();
  }
  
  public Account getAccount()
  {
    return this.zzSo;
  }
  
  @Deprecated
  public String getAccountName()
  {
    if (this.zzSo != null) {
      return this.zzSo.name;
    }
    return null;
  }
  
  public void zza(Integer paramInteger)
  {
    this.zzajt = paramInteger;
  }
  
  public Set<Scope> zzb(Api<?> paramApi)
  {
    paramApi = (zza)this.zzajs.get(paramApi);
    if ((paramApi == null) || (paramApi.zzVH.isEmpty())) {
      return this.zzaeA;
    }
    HashSet localHashSet = new HashSet(this.zzaeA);
    localHashSet.addAll(paramApi.zzVH);
    return localHashSet;
  }
  
  public Account zzpY()
  {
    if (this.zzSo != null) {
      return this.zzSo;
    }
    return new Account("<<default account>>", "com.google");
  }
  
  public int zzpZ()
  {
    return this.zzaeC;
  }
  
  public Set<Scope> zzqa()
  {
    return this.zzaeA;
  }
  
  public Set<Scope> zzqb()
  {
    return this.zzajr;
  }
  
  public Map<Api<?>, zza> zzqc()
  {
    return this.zzajs;
  }
  
  public String zzqd()
  {
    return this.zzTz;
  }
  
  public String zzqe()
  {
    return this.zzaeE;
  }
  
  public View zzqf()
  {
    return this.zzaeD;
  }
  
  public zzsd zzqg()
  {
    return this.zzaeP;
  }
  
  public Integer zzqh()
  {
    return this.zzajt;
  }
  
  public static final class zza
  {
    public final Set<Scope> zzVH;
    public final boolean zzaju;
    
    public zza(Set<Scope> paramSet, boolean paramBoolean)
    {
      zzx.zzy(paramSet);
      this.zzVH = Collections.unmodifiableSet(paramSet);
      this.zzaju = paramBoolean;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/internal/zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */