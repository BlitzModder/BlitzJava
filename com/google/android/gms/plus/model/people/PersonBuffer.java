package com.google.android.gms.plus.model.people;

import android.os.Bundle;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzd;
import com.google.android.gms.plus.internal.model.people.PersonEntity;
import com.google.android.gms.plus.internal.model.people.zzk;

public final class PersonBuffer
  extends AbstractDataBuffer<Person>
{
  private final zzd<PersonEntity> zzbbg;
  
  public PersonBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    if ((paramDataHolder.zzpH() != null) && (paramDataHolder.zzpH().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)))
    {
      this.zzbbg = new zzd(paramDataHolder, PersonEntity.CREATOR);
      return;
    }
    this.zzbbg = null;
  }
  
  public Person get(int paramInt)
  {
    if (this.zzbbg != null) {
      return (Person)this.zzbbg.zzbH(paramInt);
    }
    return new zzk(this.zzafC, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/plus/model/people/PersonBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */