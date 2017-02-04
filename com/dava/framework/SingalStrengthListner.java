package com.dava.framework;

import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;

public class SingalStrengthListner
  extends PhoneStateListener
{
  private int singalStrength = 0;
  
  public int GetSignalStrength()
  {
    return this.singalStrength;
  }
  
  public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    this.singalStrength = paramSignalStrength.getGsmSignalStrength();
    super.onSignalStrengthsChanged(paramSignalStrength);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/dava/framework/SingalStrengthListner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */