package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.internal.model.moments.zzc;

public final class MomentBuffer
  extends AbstractDataBuffer<Moment>
{
  public MomentBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public Moment get(int paramInt)
  {
    return new zzc(this.zzafC, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/plus/model/moments/MomentBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */