package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

public final class zzc
  extends com.google.android.gms.common.data.zzc
  implements Moment
{
  private MomentEntity zzbax;
  
  public zzc(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  private MomentEntity zzDt()
  {
    try
    {
      if (this.zzbax == null)
      {
        byte[] arrayOfByte = getByteArray("momentImpl");
        Parcel localParcel = Parcel.obtain();
        localParcel.unmarshall(arrayOfByte, 0, arrayOfByte.length);
        localParcel.setDataPosition(0);
        this.zzbax = MomentEntity.CREATOR.zzgs(localParcel);
        localParcel.recycle();
      }
      return this.zzbax;
    }
    finally {}
  }
  
  public String getId()
  {
    return zzDt().getId();
  }
  
  public ItemScope getResult()
  {
    return zzDt().getResult();
  }
  
  public String getStartDate()
  {
    return zzDt().getStartDate();
  }
  
  public ItemScope getTarget()
  {
    return zzDt().getTarget();
  }
  
  public String getType()
  {
    return zzDt().getType();
  }
  
  public boolean hasId()
  {
    return zzDt().hasId();
  }
  
  public boolean hasResult()
  {
    return zzDt().hasResult();
  }
  
  public boolean hasStartDate()
  {
    return zzDt().hasStartDate();
  }
  
  public boolean hasTarget()
  {
    return zzDt().hasTarget();
  }
  
  public boolean hasType()
  {
    return zzDt().hasType();
  }
  
  public MomentEntity zzDs()
  {
    return zzDt();
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/plus/internal/model/moments/zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */