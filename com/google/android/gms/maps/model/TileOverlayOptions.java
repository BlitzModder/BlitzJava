package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.internal.zzi;
import com.google.android.gms.maps.model.internal.zzi.zza;

public final class TileOverlayOptions
  implements SafeParcelable
{
  public static final zzo CREATOR = new zzo();
  private final int mVersionCode;
  private zzi zzaQR;
  private TileProvider zzaQS;
  private boolean zzaQT = true;
  private float zzaQj;
  private boolean zzaQk = true;
  
  public TileOverlayOptions()
  {
    this.mVersionCode = 1;
  }
  
  TileOverlayOptions(int paramInt, IBinder paramIBinder, boolean paramBoolean1, float paramFloat, boolean paramBoolean2)
  {
    this.mVersionCode = paramInt;
    this.zzaQR = zzi.zza.zzdh(paramIBinder);
    if (this.zzaQR == null) {}
    for (paramIBinder = null;; paramIBinder = new TileProvider()
        {
          private final zzi zzaQU = TileOverlayOptions.zza(TileOverlayOptions.this);
          
          public Tile getTile(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            try
            {
              Tile localTile = this.zzaQU.getTile(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
              return localTile;
            }
            catch (RemoteException localRemoteException) {}
            return null;
          }
        })
    {
      this.zzaQS = paramIBinder;
      this.zzaQk = paramBoolean1;
      this.zzaQj = paramFloat;
      this.zzaQT = paramBoolean2;
      return;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public TileOverlayOptions fadeIn(boolean paramBoolean)
  {
    this.zzaQT = paramBoolean;
    return this;
  }
  
  public boolean getFadeIn()
  {
    return this.zzaQT;
  }
  
  public TileProvider getTileProvider()
  {
    return this.zzaQS;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public float getZIndex()
  {
    return this.zzaQj;
  }
  
  public boolean isVisible()
  {
    return this.zzaQk;
  }
  
  public TileOverlayOptions tileProvider(final TileProvider paramTileProvider)
  {
    this.zzaQS = paramTileProvider;
    if (this.zzaQS == null) {}
    for (paramTileProvider = null;; paramTileProvider = new zzi.zza()
        {
          public Tile getTile(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
          {
            return paramTileProvider.getTile(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
          }
        })
    {
      this.zzaQR = paramTileProvider;
      return this;
    }
  }
  
  public TileOverlayOptions visible(boolean paramBoolean)
  {
    this.zzaQk = paramBoolean;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzo.zza(this, paramParcel, paramInt);
  }
  
  public TileOverlayOptions zIndex(float paramFloat)
  {
    this.zzaQj = paramFloat;
    return this;
  }
  
  IBinder zzzx()
  {
    return this.zzaQR.asBinder();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/maps/model/TileOverlayOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */