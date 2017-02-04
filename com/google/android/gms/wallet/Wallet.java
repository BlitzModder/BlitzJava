package com.google.android.gms.wallet;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.internal.zzlx.zza;
import com.google.android.gms.internal.zzst;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.internal.zzsw;
import com.google.android.gms.internal.zzsx;
import com.google.android.gms.wallet.firstparty.zza;
import com.google.android.gms.wallet.wobs.zzj;
import java.util.Locale;

public final class Wallet
{
  public static final Api<WalletOptions> API = new Api("Wallet.API", zzTp, zzTo);
  public static final Payments Payments = new zzst();
  private static final Api.zzc<zzsu> zzTo = new Api.zzc();
  private static final Api.zza<zzsu, WalletOptions> zzTp = new Api.zza()
  {
    public zzsu zza(Context paramAnonymousContext, Looper paramAnonymousLooper, zzf paramAnonymouszzf, Wallet.WalletOptions paramAnonymousWalletOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      if (paramAnonymousWalletOptions != null) {}
      for (;;)
      {
        return new zzsu(paramAnonymousContext, paramAnonymousLooper, paramAnonymouszzf, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, paramAnonymousWalletOptions.environment, paramAnonymousWalletOptions.theme, Wallet.WalletOptions.zza(paramAnonymousWalletOptions));
        paramAnonymousWalletOptions = new Wallet.WalletOptions(null);
      }
    }
  };
  public static final zzj zzbkA = new zzsx();
  public static final zza zzbkB = new zzsw();
  
  @Deprecated
  public static void changeMaskedWallet(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2, int paramInt)
  {
    Payments.changeMaskedWallet(paramGoogleApiClient, paramString1, paramString2, paramInt);
  }
  
  @Deprecated
  public static void checkForPreAuthorization(GoogleApiClient paramGoogleApiClient, int paramInt)
  {
    Payments.checkForPreAuthorization(paramGoogleApiClient, paramInt);
  }
  
  @Deprecated
  public static void loadFullWallet(GoogleApiClient paramGoogleApiClient, FullWalletRequest paramFullWalletRequest, int paramInt)
  {
    Payments.loadFullWallet(paramGoogleApiClient, paramFullWalletRequest, paramInt);
  }
  
  @Deprecated
  public static void loadMaskedWallet(GoogleApiClient paramGoogleApiClient, MaskedWalletRequest paramMaskedWalletRequest, int paramInt)
  {
    Payments.loadMaskedWallet(paramGoogleApiClient, paramMaskedWalletRequest, paramInt);
  }
  
  @Deprecated
  public static void notifyTransactionStatus(GoogleApiClient paramGoogleApiClient, NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest)
  {
    Payments.notifyTransactionStatus(paramGoogleApiClient, paramNotifyTransactionStatusRequest);
  }
  
  public static final class WalletOptions
    implements Api.ApiOptions.HasOptions
  {
    public final int environment;
    public final int theme;
    private final boolean zzbkC;
    
    private WalletOptions()
    {
      this(new Builder());
    }
    
    private WalletOptions(Builder paramBuilder)
    {
      this.environment = Builder.zza(paramBuilder);
      this.theme = Builder.zzb(paramBuilder);
      this.zzbkC = Builder.zzc(paramBuilder);
    }
    
    public static final class Builder
    {
      private int mTheme = 0;
      private int zzbkD = 3;
      private boolean zzbkE = true;
      
      public Wallet.WalletOptions build()
      {
        return new Wallet.WalletOptions(this, null);
      }
      
      public Builder setEnvironment(int paramInt)
      {
        if ((paramInt == 0) || (paramInt == 2) || (paramInt == 1) || (paramInt == 3))
        {
          this.zzbkD = paramInt;
          return this;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "Invalid environment value %d", new Object[] { Integer.valueOf(paramInt) }));
      }
      
      public Builder setTheme(int paramInt)
      {
        if ((paramInt == 0) || (paramInt == 1))
        {
          this.mTheme = paramInt;
          return this;
        }
        throw new IllegalArgumentException(String.format(Locale.US, "Invalid theme value %d", new Object[] { Integer.valueOf(paramInt) }));
      }
      
      public Builder useGoogleWallet()
      {
        this.zzbkE = false;
        return this;
      }
    }
  }
  
  public static abstract class zza<R extends Result>
    extends zzlx.zza<R, zzsu>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
  }
  
  public static abstract class zzb
    extends Wallet.zza<Status>
  {
    public zzb(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    protected Status zzb(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/Wallet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */