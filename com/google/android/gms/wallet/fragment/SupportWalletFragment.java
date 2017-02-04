package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R.string;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.zza;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzf;
import com.google.android.gms.dynamic.zzh;
import com.google.android.gms.internal.zzsn;
import com.google.android.gms.internal.zzso.zza;
import com.google.android.gms.internal.zzsv;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class SupportWalletFragment
  extends Fragment
{
  private boolean mCreated = false;
  private final Fragment zzajv = this;
  private zzb zzbkN;
  private final zzh zzbkO = zzh.zza(this);
  private final zzc zzbkP = new zzc(null);
  private zza zzbkQ = new zza(this);
  private WalletFragmentOptions zzbkR;
  private WalletFragmentInitParams zzbkS;
  private MaskedWalletRequest zzbkT;
  private MaskedWallet zzbkU;
  private Boolean zzbkV;
  
  public static SupportWalletFragment newInstance(WalletFragmentOptions paramWalletFragmentOptions)
  {
    SupportWalletFragment localSupportWalletFragment = new SupportWalletFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extraWalletFragmentOptions", paramWalletFragmentOptions);
    localSupportWalletFragment.zzajv.setArguments(localBundle);
    return localSupportWalletFragment;
  }
  
  public int getState()
  {
    if (this.zzbkN != null) {
      return zzb.zza(this.zzbkN);
    }
    return 0;
  }
  
  public void initialize(WalletFragmentInitParams paramWalletFragmentInitParams)
  {
    if (this.zzbkN != null)
    {
      zzb.zza(this.zzbkN, paramWalletFragmentInitParams);
      this.zzbkS = null;
    }
    do
    {
      return;
      if (this.zzbkS != null) {
        break;
      }
      this.zzbkS = paramWalletFragmentInitParams;
      if (this.zzbkT != null) {
        Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
      }
    } while (this.zzbkU == null);
    Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
    return;
    Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.zzbkN != null) {
      zzb.zza(this.zzbkN, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject;
    if (paramBundle != null)
    {
      paramBundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
      localObject = (WalletFragmentInitParams)paramBundle.getParcelable("walletFragmentInitParams");
      if (localObject != null)
      {
        if (this.zzbkS != null) {
          Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
        }
        this.zzbkS = ((WalletFragmentInitParams)localObject);
      }
      if (this.zzbkT == null) {
        this.zzbkT = ((MaskedWalletRequest)paramBundle.getParcelable("maskedWalletRequest"));
      }
      if (this.zzbkU == null) {
        this.zzbkU = ((MaskedWallet)paramBundle.getParcelable("maskedWallet"));
      }
      if (paramBundle.containsKey("walletFragmentOptions")) {
        this.zzbkR = ((WalletFragmentOptions)paramBundle.getParcelable("walletFragmentOptions"));
      }
      if (paramBundle.containsKey("enabled")) {
        this.zzbkV = Boolean.valueOf(paramBundle.getBoolean("enabled"));
      }
    }
    for (;;)
    {
      this.mCreated = true;
      this.zzbkP.onCreate(paramBundle);
      return;
      if (this.zzajv.getArguments() != null)
      {
        localObject = (WalletFragmentOptions)this.zzajv.getArguments().getParcelable("extraWalletFragmentOptions");
        if (localObject != null)
        {
          ((WalletFragmentOptions)localObject).zzbc(this.zzajv.getActivity());
          this.zzbkR = ((WalletFragmentOptions)localObject);
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.zzbkP.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mCreated = false;
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    if (this.zzbkR == null) {
      this.zzbkR = WalletFragmentOptions.zzb(paramActivity, paramAttributeSet);
    }
    paramAttributeSet = new Bundle();
    paramAttributeSet.putParcelable("attrKeyWalletFragmentOptions", this.zzbkR);
    this.zzbkP.onInflate(paramActivity, paramAttributeSet, paramBundle);
  }
  
  public void onPause()
  {
    super.onPause();
    this.zzbkP.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.zzbkP.onResume();
    FragmentManager localFragmentManager = this.zzajv.getActivity().getSupportFragmentManager();
    Fragment localFragment = localFragmentManager.findFragmentByTag("GooglePlayServicesErrorDialog");
    if (localFragment != null)
    {
      localFragmentManager.beginTransaction().remove(localFragment).commit();
      GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzajv.getActivity()), this.zzajv.getActivity(), -1);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
    this.zzbkP.onSaveInstanceState(paramBundle);
    if (this.zzbkS != null)
    {
      paramBundle.putParcelable("walletFragmentInitParams", this.zzbkS);
      this.zzbkS = null;
    }
    if (this.zzbkT != null)
    {
      paramBundle.putParcelable("maskedWalletRequest", this.zzbkT);
      this.zzbkT = null;
    }
    if (this.zzbkU != null)
    {
      paramBundle.putParcelable("maskedWallet", this.zzbkU);
      this.zzbkU = null;
    }
    if (this.zzbkR != null)
    {
      paramBundle.putParcelable("walletFragmentOptions", this.zzbkR);
      this.zzbkR = null;
    }
    if (this.zzbkV != null)
    {
      paramBundle.putBoolean("enabled", this.zzbkV.booleanValue());
      this.zzbkV = null;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.zzbkP.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    this.zzbkP.onStop();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.zzbkN != null)
    {
      zzb.zza(this.zzbkN, paramBoolean);
      this.zzbkV = null;
      return;
    }
    this.zzbkV = Boolean.valueOf(paramBoolean);
  }
  
  public void setOnStateChangedListener(OnStateChangedListener paramOnStateChangedListener)
  {
    this.zzbkQ.zza(paramOnStateChangedListener);
  }
  
  public void updateMaskedWallet(MaskedWallet paramMaskedWallet)
  {
    if (this.zzbkN != null)
    {
      zzb.zza(this.zzbkN, paramMaskedWallet);
      this.zzbkU = null;
      return;
    }
    this.zzbkU = paramMaskedWallet;
  }
  
  public void updateMaskedWalletRequest(MaskedWalletRequest paramMaskedWalletRequest)
  {
    if (this.zzbkN != null)
    {
      zzb.zza(this.zzbkN, paramMaskedWalletRequest);
      this.zzbkT = null;
      return;
    }
    this.zzbkT = paramMaskedWalletRequest;
  }
  
  public static abstract interface OnStateChangedListener
  {
    public abstract void onStateChanged(SupportWalletFragment paramSupportWalletFragment, int paramInt1, int paramInt2, Bundle paramBundle);
  }
  
  static class zza
    extends zzso.zza
  {
    private SupportWalletFragment.OnStateChangedListener zzbkW;
    private final SupportWalletFragment zzbkX;
    
    zza(SupportWalletFragment paramSupportWalletFragment)
    {
      this.zzbkX = paramSupportWalletFragment;
    }
    
    public void zza(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      if (this.zzbkW != null) {
        this.zzbkW.onStateChanged(this.zzbkX, paramInt1, paramInt2, paramBundle);
      }
    }
    
    public void zza(SupportWalletFragment.OnStateChangedListener paramOnStateChangedListener)
    {
      this.zzbkW = paramOnStateChangedListener;
    }
  }
  
  private static class zzb
    implements LifecycleDelegate
  {
    private final zzsn zzbkY;
    
    private zzb(zzsn paramzzsn)
    {
      this.zzbkY = paramzzsn;
    }
    
    private int getState()
    {
      try
      {
        int i = this.zzbkY.getState();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    private void initialize(WalletFragmentInitParams paramWalletFragmentInitParams)
    {
      try
      {
        this.zzbkY.initialize(paramWalletFragmentInitParams);
        return;
      }
      catch (RemoteException paramWalletFragmentInitParams)
      {
        throw new RuntimeException(paramWalletFragmentInitParams);
      }
    }
    
    private void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      try
      {
        this.zzbkY.onActivityResult(paramInt1, paramInt2, paramIntent);
        return;
      }
      catch (RemoteException paramIntent)
      {
        throw new RuntimeException(paramIntent);
      }
    }
    
    private void setEnabled(boolean paramBoolean)
    {
      try
      {
        this.zzbkY.setEnabled(paramBoolean);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    private void updateMaskedWallet(MaskedWallet paramMaskedWallet)
    {
      try
      {
        this.zzbkY.updateMaskedWallet(paramMaskedWallet);
        return;
      }
      catch (RemoteException paramMaskedWallet)
      {
        throw new RuntimeException(paramMaskedWallet);
      }
    }
    
    private void updateMaskedWalletRequest(MaskedWalletRequest paramMaskedWalletRequest)
    {
      try
      {
        this.zzbkY.updateMaskedWalletRequest(paramMaskedWalletRequest);
        return;
      }
      catch (RemoteException paramMaskedWalletRequest)
      {
        throw new RuntimeException(paramMaskedWalletRequest);
      }
    }
    
    public void onCreate(Bundle paramBundle)
    {
      try
      {
        this.zzbkY.onCreate(paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeException(paramBundle);
      }
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      try
      {
        paramLayoutInflater = (View)zze.zzp(this.zzbkY.onCreateView(zze.zzB(paramLayoutInflater), zze.zzB(paramViewGroup), paramBundle));
        return paramLayoutInflater;
      }
      catch (RemoteException paramLayoutInflater)
      {
        throw new RuntimeException(paramLayoutInflater);
      }
    }
    
    public void onDestroy() {}
    
    public void onDestroyView() {}
    
    public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      paramBundle1 = (WalletFragmentOptions)paramBundle1.getParcelable("extraWalletFragmentOptions");
      try
      {
        this.zzbkY.zza(zze.zzB(paramActivity), paramBundle1, paramBundle2);
        return;
      }
      catch (RemoteException paramActivity)
      {
        throw new RuntimeException(paramActivity);
      }
    }
    
    public void onLowMemory() {}
    
    public void onPause()
    {
      try
      {
        this.zzbkY.onPause();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onResume()
    {
      try
      {
        this.zzbkY.onResume();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onSaveInstanceState(Bundle paramBundle)
    {
      try
      {
        this.zzbkY.onSaveInstanceState(paramBundle);
        return;
      }
      catch (RemoteException paramBundle)
      {
        throw new RuntimeException(paramBundle);
      }
    }
    
    public void onStart()
    {
      try
      {
        this.zzbkY.onStart();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onStop()
    {
      try
      {
        this.zzbkY.onStop();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
  }
  
  private class zzc
    extends zza<SupportWalletFragment.zzb>
    implements View.OnClickListener
  {
    private zzc() {}
    
    public void onClick(View paramView)
    {
      paramView = SupportWalletFragment.zza(SupportWalletFragment.this).getActivity();
      GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramView), paramView, -1);
    }
    
    protected void zza(FrameLayout paramFrameLayout)
    {
      Button localButton = new Button(SupportWalletFragment.zza(SupportWalletFragment.this).getActivity());
      localButton.setText(R.string.wallet_buy_button_place_holder);
      int k = -1;
      int m = -2;
      int j = m;
      int i = k;
      if (SupportWalletFragment.zze(SupportWalletFragment.this) != null)
      {
        WalletFragmentStyle localWalletFragmentStyle = SupportWalletFragment.zze(SupportWalletFragment.this).getFragmentStyle();
        j = m;
        i = k;
        if (localWalletFragmentStyle != null)
        {
          DisplayMetrics localDisplayMetrics = SupportWalletFragment.zza(SupportWalletFragment.this).getResources().getDisplayMetrics();
          i = localWalletFragmentStyle.zza("buyButtonWidth", localDisplayMetrics, -1);
          j = localWalletFragmentStyle.zza("buyButtonHeight", localDisplayMetrics, -2);
        }
      }
      localButton.setLayoutParams(new ViewGroup.LayoutParams(i, j));
      localButton.setOnClickListener(this);
      paramFrameLayout.addView(localButton);
    }
    
    protected void zza(zzf<SupportWalletFragment.zzb> paramzzf)
    {
      Object localObject = SupportWalletFragment.zza(SupportWalletFragment.this).getActivity();
      if ((SupportWalletFragment.zzb(SupportWalletFragment.this) == null) && (SupportWalletFragment.zzc(SupportWalletFragment.this)) && (localObject != null)) {}
      try
      {
        localObject = zzsv.zza((Activity)localObject, SupportWalletFragment.zzd(SupportWalletFragment.this), SupportWalletFragment.zze(SupportWalletFragment.this), SupportWalletFragment.zzf(SupportWalletFragment.this));
        SupportWalletFragment.zza(SupportWalletFragment.this, new SupportWalletFragment.zzb((zzsn)localObject, null));
        SupportWalletFragment.zza(SupportWalletFragment.this, null);
        paramzzf.zza(SupportWalletFragment.zzb(SupportWalletFragment.this));
        if (SupportWalletFragment.zzg(SupportWalletFragment.this) != null)
        {
          SupportWalletFragment.zzb.zza(SupportWalletFragment.zzb(SupportWalletFragment.this), SupportWalletFragment.zzg(SupportWalletFragment.this));
          SupportWalletFragment.zza(SupportWalletFragment.this, null);
        }
        if (SupportWalletFragment.zzh(SupportWalletFragment.this) != null)
        {
          SupportWalletFragment.zzb.zza(SupportWalletFragment.zzb(SupportWalletFragment.this), SupportWalletFragment.zzh(SupportWalletFragment.this));
          SupportWalletFragment.zza(SupportWalletFragment.this, null);
        }
        if (SupportWalletFragment.zzi(SupportWalletFragment.this) != null)
        {
          SupportWalletFragment.zzb.zza(SupportWalletFragment.zzb(SupportWalletFragment.this), SupportWalletFragment.zzi(SupportWalletFragment.this));
          SupportWalletFragment.zza(SupportWalletFragment.this, null);
        }
        if (SupportWalletFragment.zzj(SupportWalletFragment.this) != null)
        {
          SupportWalletFragment.zzb.zza(SupportWalletFragment.zzb(SupportWalletFragment.this), SupportWalletFragment.zzj(SupportWalletFragment.this).booleanValue());
          SupportWalletFragment.zza(SupportWalletFragment.this, null);
        }
        return;
      }
      catch (GooglePlayServicesNotAvailableException paramzzf) {}
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wallet/fragment/SupportWalletFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */