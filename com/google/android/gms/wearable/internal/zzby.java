package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.wearable.Channel;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;

final class zzby
  implements ChannelApi.ChannelListener
{
  private final String zzTR;
  private final ChannelApi.ChannelListener zzboG;
  
  zzby(String paramString, ChannelApi.ChannelListener paramChannelListener)
  {
    this.zzTR = ((String)zzx.zzy(paramString));
    this.zzboG = ((ChannelApi.ChannelListener)zzx.zzy(paramChannelListener));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof zzby)) {
        return false;
      }
      paramObject = (zzby)paramObject;
    } while ((this.zzboG.equals(((zzby)paramObject).zzboG)) && (this.zzTR.equals(((zzby)paramObject).zzTR)));
    return false;
  }
  
  public int hashCode()
  {
    return this.zzTR.hashCode() * 31 + this.zzboG.hashCode();
  }
  
  public void onChannelClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    this.zzboG.onChannelClosed(paramChannel, paramInt1, paramInt2);
  }
  
  public void onChannelOpened(Channel paramChannel)
  {
    this.zzboG.onChannelOpened(paramChannel);
  }
  
  public void onInputClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    this.zzboG.onInputClosed(paramChannel, paramInt1, paramInt2);
  }
  
  public void onOutputClosed(Channel paramChannel, int paramInt1, int paramInt2)
  {
    this.zzboG.onOutputClosed(paramChannel, paramInt1, paramInt2);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/wearable/internal/zzby.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */