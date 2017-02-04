package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzd<T extends SafeParcelable>
  extends AbstractDataBuffer<T>
{
  private static final String[] zzahy = { "data" };
  private final Parcelable.Creator<T> zzahz;
  
  public zzd(DataHolder paramDataHolder, Parcelable.Creator<T> paramCreator)
  {
    super(paramDataHolder);
    this.zzahz = paramCreator;
  }
  
  public T zzbH(int paramInt)
  {
    Object localObject = this.zzafC.zzg("data", paramInt, this.zzafC.zzbI(paramInt));
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall((byte[])localObject, 0, localObject.length);
    localParcel.setDataPosition(0);
    localObject = (SafeParcelable)this.zzahz.createFromParcel(localParcel);
    localParcel.recycle();
    return (T)localObject;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/common/data/zzd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */