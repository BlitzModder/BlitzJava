package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder
  implements SafeParcelable
{
  public static final Parcelable.Creator<FilterHolder> CREATOR = new zzd();
  final int mVersionCode;
  private final Filter zzanm;
  final ComparisonFilter<?> zzase;
  final FieldOnlyFilter zzasf;
  final LogicalFilter zzasg;
  final NotFilter zzash;
  final InFilter<?> zzasi;
  final MatchAllFilter zzasj;
  final HasFilter zzask;
  final FullTextSearchFilter zzasl;
  final OwnedByMeFilter zzasm;
  
  FilterHolder(int paramInt, ComparisonFilter<?> paramComparisonFilter, FieldOnlyFilter paramFieldOnlyFilter, LogicalFilter paramLogicalFilter, NotFilter paramNotFilter, InFilter<?> paramInFilter, MatchAllFilter paramMatchAllFilter, HasFilter<?> paramHasFilter, FullTextSearchFilter paramFullTextSearchFilter, OwnedByMeFilter paramOwnedByMeFilter)
  {
    this.mVersionCode = paramInt;
    this.zzase = paramComparisonFilter;
    this.zzasf = paramFieldOnlyFilter;
    this.zzasg = paramLogicalFilter;
    this.zzash = paramNotFilter;
    this.zzasi = paramInFilter;
    this.zzasj = paramMatchAllFilter;
    this.zzask = paramHasFilter;
    this.zzasl = paramFullTextSearchFilter;
    this.zzasm = paramOwnedByMeFilter;
    if (this.zzase != null)
    {
      this.zzanm = this.zzase;
      return;
    }
    if (this.zzasf != null)
    {
      this.zzanm = this.zzasf;
      return;
    }
    if (this.zzasg != null)
    {
      this.zzanm = this.zzasg;
      return;
    }
    if (this.zzash != null)
    {
      this.zzanm = this.zzash;
      return;
    }
    if (this.zzasi != null)
    {
      this.zzanm = this.zzasi;
      return;
    }
    if (this.zzasj != null)
    {
      this.zzanm = this.zzasj;
      return;
    }
    if (this.zzask != null)
    {
      this.zzanm = this.zzask;
      return;
    }
    if (this.zzasl != null)
    {
      this.zzanm = this.zzasl;
      return;
    }
    if (this.zzasm != null)
    {
      this.zzanm = this.zzasm;
      return;
    }
    throw new IllegalArgumentException("At least one filter must be set.");
  }
  
  public FilterHolder(Filter paramFilter)
  {
    zzx.zzb(paramFilter, "Null filter.");
    this.mVersionCode = 2;
    if ((paramFilter instanceof ComparisonFilter))
    {
      localObject = (ComparisonFilter)paramFilter;
      this.zzase = ((ComparisonFilter)localObject);
      if (!(paramFilter instanceof FieldOnlyFilter)) {
        break label247;
      }
      localObject = (FieldOnlyFilter)paramFilter;
      label45:
      this.zzasf = ((FieldOnlyFilter)localObject);
      if (!(paramFilter instanceof LogicalFilter)) {
        break label252;
      }
      localObject = (LogicalFilter)paramFilter;
      label62:
      this.zzasg = ((LogicalFilter)localObject);
      if (!(paramFilter instanceof NotFilter)) {
        break label257;
      }
      localObject = (NotFilter)paramFilter;
      label79:
      this.zzash = ((NotFilter)localObject);
      if (!(paramFilter instanceof InFilter)) {
        break label262;
      }
      localObject = (InFilter)paramFilter;
      label96:
      this.zzasi = ((InFilter)localObject);
      if (!(paramFilter instanceof MatchAllFilter)) {
        break label267;
      }
      localObject = (MatchAllFilter)paramFilter;
      label113:
      this.zzasj = ((MatchAllFilter)localObject);
      if (!(paramFilter instanceof HasFilter)) {
        break label272;
      }
      localObject = (HasFilter)paramFilter;
      label130:
      this.zzask = ((HasFilter)localObject);
      if (!(paramFilter instanceof FullTextSearchFilter)) {
        break label277;
      }
      localObject = (FullTextSearchFilter)paramFilter;
      label147:
      this.zzasl = ((FullTextSearchFilter)localObject);
      if (!(paramFilter instanceof OwnedByMeFilter)) {
        break label282;
      }
    }
    label247:
    label252:
    label257:
    label262:
    label267:
    label272:
    label277:
    label282:
    for (Object localObject = (OwnedByMeFilter)paramFilter;; localObject = null)
    {
      this.zzasm = ((OwnedByMeFilter)localObject);
      if ((this.zzase != null) || (this.zzasf != null) || (this.zzasg != null) || (this.zzash != null) || (this.zzasi != null) || (this.zzasj != null) || (this.zzask != null) || (this.zzasl != null) || (this.zzasm != null)) {
        break label287;
      }
      throw new IllegalArgumentException("Invalid filter type.");
      localObject = null;
      break;
      localObject = null;
      break label45;
      localObject = null;
      break label62;
      localObject = null;
      break label79;
      localObject = null;
      break label96;
      localObject = null;
      break label113;
      localObject = null;
      break label130;
      localObject = null;
      break label147;
    }
    label287:
    this.zzanm = paramFilter;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Filter getFilter()
  {
    return this.zzanm;
  }
  
  public String toString()
  {
    return String.format("FilterHolder[%s]", new Object[] { this.zzanm });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzd.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/drive/query/internal/FilterHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */