package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.nearby.messages.devices.NearbyDevice;
import java.util.Arrays;

public class Message
  implements SafeParcelable
{
  public static final Parcelable.Creator<Message> CREATOR = new zza();
  public static final int MAX_CONTENT_SIZE_BYTES = 102400;
  public static final int MAX_TYPE_LENGTH = 32;
  private static final NearbyDevice[] zzaWC = { NearbyDevice.zzaXe };
  private final byte[] content;
  private final String type;
  final int versionCode;
  private final NearbyDevice[] zzaWD;
  private final String zzakM;
  
  Message(int paramInt, byte[] paramArrayOfByte, String paramString1, String paramString2, NearbyDevice[] paramArrayOfNearbyDevice)
  {
    this.versionCode = paramInt;
    this.type = ((String)zzx.zzy(paramString2));
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    this.zzakM = str;
    if (zzO(this.zzakM, this.type)) {
      if (paramArrayOfByte == null)
      {
        bool = true;
        zzx.zzb(bool, "Content must be null for a device presence message.");
        this.content = paramArrayOfByte;
        if (paramArrayOfNearbyDevice != null)
        {
          paramArrayOfByte = paramArrayOfNearbyDevice;
          if (paramArrayOfNearbyDevice.length != 0) {}
        }
        else
        {
          paramArrayOfByte = zzaWC;
        }
        this.zzaWD = paramArrayOfByte;
        if (paramString2.length() > 32) {
          break label195;
        }
      }
    }
    label195:
    for (boolean bool = true;; bool = false)
    {
      zzx.zzb(bool, "Type length(%d) must not exceed MAX_TYPE_LENGTH(%d)", new Object[] { Integer.valueOf(paramString2.length()), Integer.valueOf(32) });
      return;
      bool = false;
      break;
      zzx.zzy(paramArrayOfByte);
      if (paramArrayOfByte.length <= 102400) {}
      for (bool = true;; bool = false)
      {
        zzx.zzb(bool, "Content length(%d) must not exceed MAX_CONTENT_SIZE_BYTES(%d)", new Object[] { Integer.valueOf(paramArrayOfByte.length), Integer.valueOf(102400) });
        break;
      }
    }
  }
  
  public Message(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, "", "");
  }
  
  public Message(byte[] paramArrayOfByte, String paramString)
  {
    this(paramArrayOfByte, "", paramString);
  }
  
  public Message(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    this(paramArrayOfByte, paramString1, paramString2, zzaWC);
  }
  
  public Message(byte[] paramArrayOfByte, String paramString1, String paramString2, NearbyDevice[] paramArrayOfNearbyDevice)
  {
    this(2, paramArrayOfByte, paramString1, paramString2, paramArrayOfNearbyDevice);
  }
  
  public static boolean zzO(String paramString1, String paramString2)
  {
    return (paramString1.equals("__reserved_namespace")) && (paramString2.equals("__device_presence"));
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
      if (!(paramObject instanceof Message)) {
        return false;
      }
      paramObject = (Message)paramObject;
    } while ((TextUtils.equals(this.zzakM, ((Message)paramObject).zzakM)) && (TextUtils.equals(this.type, ((Message)paramObject).type)) && (Arrays.equals(this.content, ((Message)paramObject).content)));
    return false;
  }
  
  public byte[] getContent()
  {
    return this.content;
  }
  
  public String getNamespace()
  {
    return this.zzakM;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public int hashCode()
  {
    return zzw.hashCode(new Object[] { this.zzakM, this.type, Integer.valueOf(Arrays.hashCode(this.content)) });
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Message{namespace='").append(this.zzakM).append("'").append(", type='").append(this.type).append("'").append(", content=[");
    if (this.content == null) {}
    for (int i = 0;; i = this.content.length) {
      return i + " bytes]" + ", devices=" + Arrays.toString(zzCw()) + "}";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zza.zza(this, paramParcel, paramInt);
  }
  
  public NearbyDevice[] zzCw()
  {
    return this.zzaWD;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/Message.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */