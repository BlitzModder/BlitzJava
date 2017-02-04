package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.devices.NearbyDeviceFilter;
import com.google.android.gms.nearby.messages.internal.MessageType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessageFilter
  implements SafeParcelable
{
  public static final Parcelable.Creator<MessageFilter> CREATOR = new zzb();
  public static final MessageFilter INCLUDE_ALL_MY_TYPES = new Builder().includeAllMyTypes().build();
  final int mVersionCode;
  private final List<MessageType> zzaWE;
  private final List<NearbyDeviceFilter> zzaWF;
  private final boolean zzaWG;
  
  MessageFilter(int paramInt, List<MessageType> paramList, List<NearbyDeviceFilter> paramList1, boolean paramBoolean)
  {
    this.mVersionCode = paramInt;
    this.zzaWE = Collections.unmodifiableList((List)zzx.zzy(paramList));
    this.zzaWG = paramBoolean;
    paramList = paramList1;
    if (paramList1 == null) {
      paramList = Collections.emptyList();
    }
    this.zzaWF = Collections.unmodifiableList(paramList);
  }
  
  private MessageFilter(List<MessageType> paramList, List<NearbyDeviceFilter> paramList1, boolean paramBoolean)
  {
    this(1, paramList, paramList1, paramBoolean);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof MessageFilter)) {
        return false;
      }
      paramObject = (MessageFilter)paramObject;
    } while ((this.zzaWG == ((MessageFilter)paramObject).zzaWG) && (zzw.equal(this.zzaWE, ((MessageFilter)paramObject).zzaWE)) && (zzw.equal(this.zzaWF, ((MessageFilter)paramObject).zzaWF)));
    return false;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzaWE, this.zzaWF, Boolean.valueOf(this.zzaWG) });
  }
  
  public String toString()
  {
    return "MessageFilter{includeAllMyTypes=" + this.zzaWG + ", messageTypes=" + this.zzaWE + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzb.zza(this, paramParcel, paramInt);
  }
  
  List<MessageType> zzCx()
  {
    return this.zzaWE;
  }
  
  boolean zzCy()
  {
    return this.zzaWG;
  }
  
  List<NearbyDeviceFilter> zzCz()
  {
    return this.zzaWF;
  }
  
  public static final class Builder
  {
    private final List<NearbyDeviceFilter> zzaWF = new ArrayList();
    private boolean zzaWG;
    private final List<MessageType> zzaWH = new ArrayList();
    
    private Builder zzP(String paramString1, String paramString2)
    {
      this.zzaWH.add(new MessageType(paramString1, paramString2));
      return this;
    }
    
    public MessageFilter build()
    {
      if ((this.zzaWG) || (!this.zzaWH.isEmpty())) {}
      for (boolean bool = true;; bool = false)
      {
        zzx.zza(bool, "At least one of the include methods must be called.");
        return new MessageFilter(this.zzaWH, this.zzaWF, this.zzaWG, null);
      }
    }
    
    public Builder includeAllMyTypes()
    {
      this.zzaWG = true;
      return this;
    }
    
    public Builder includeFilter(MessageFilter paramMessageFilter)
    {
      this.zzaWH.addAll(paramMessageFilter.zzCx());
      this.zzaWF.addAll(paramMessageFilter.zzCz());
      this.zzaWG |= paramMessageFilter.zzCy();
      return this;
    }
    
    public Builder includeNamespacedType(String paramString1, String paramString2)
    {
      return zzP(paramString1, paramString2);
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/MessageFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */