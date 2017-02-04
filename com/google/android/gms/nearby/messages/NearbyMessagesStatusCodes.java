package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.api.CommonStatusCodes;

public class NearbyMessagesStatusCodes
  extends CommonStatusCodes
{
  public static final int APP_NOT_OPTED_IN = 2802;
  public static final int BLE_ADVERTISING_UNSUPPORTED = 2821;
  public static final int BLE_SCANNING_UNSUPPORTED = 2822;
  public static final int BLUETOOTH_OFF = 2820;
  public static final int TOO_MANY_PENDING_INTENTS = 2801;
  
  public static String getStatusCodeString(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return CommonStatusCodes.getStatusCodeString(paramInt);
    case 2801: 
      return "TOO_MANY_PENDING_INTENTS";
    case 2802: 
      return "APP_NOT_OPTED_IN";
    case 2820: 
      return "BLUETOOTH_OFF";
    case 2821: 
      return "BLE_ADVERTISING_UNSUPPORTED";
    }
    return "BLE_SCANNING_UNSUPPORTED";
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/nearby/messages/NearbyMessagesStatusCodes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */