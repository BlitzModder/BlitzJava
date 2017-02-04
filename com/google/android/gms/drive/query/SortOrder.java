package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SortOrder
  implements SafeParcelable
{
  public static final Parcelable.Creator<SortOrder> CREATOR = new zzb();
  final int mVersionCode;
  final List<FieldWithSortOrder> zzarX;
  final boolean zzarY;
  
  SortOrder(int paramInt, List<FieldWithSortOrder> paramList, boolean paramBoolean)
  {
    this.mVersionCode = paramInt;
    this.zzarX = paramList;
    this.zzarY = paramBoolean;
  }
  
  private SortOrder(List<FieldWithSortOrder> paramList, boolean paramBoolean)
  {
    this(1, paramList, paramBoolean);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return String.format(Locale.US, "SortOrder[%s, %s]", new Object[] { TextUtils.join(",", this.zzarX), Boolean.valueOf(this.zzarY) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private final List<FieldWithSortOrder> zzarX = new ArrayList();
    private boolean zzarY = false;
    
    public Builder addSortAscending(SortableMetadataField paramSortableMetadataField)
    {
      this.zzarX.add(new FieldWithSortOrder(paramSortableMetadataField.getName(), true));
      return this;
    }
    
    public Builder addSortDescending(SortableMetadataField paramSortableMetadataField)
    {
      this.zzarX.add(new FieldWithSortOrder(paramSortableMetadataField.getName(), false));
      return this;
    }
    
    public SortOrder build()
    {
      return new SortOrder(this.zzarX, this.zzarY, null);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/query/SortOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */