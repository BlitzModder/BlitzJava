package com.google.ads.afma.nano;

import com.google.android.gms.internal.zztc;
import com.google.android.gms.internal.zztd;
import com.google.android.gms.internal.zzti;
import com.google.android.gms.internal.zztj;
import com.google.android.gms.internal.zztk;
import com.google.android.gms.internal.zztn;
import java.io.IOException;

public abstract interface NanoAfmaSignals
{
  public static final class AFMASignals
    extends zztk
  {
    public static final int DEVICE_IDENTIFIER_ADVERTISER_ID = 3;
    public static final int DEVICE_IDENTIFIER_ADVERTISER_ID_UNHASHED = 4;
    public static final int DEVICE_IDENTIFIER_ANDROID_AD_ID = 5;
    public static final int DEVICE_IDENTIFIER_APP_SPECIFIC_ID = 1;
    public static final int DEVICE_IDENTIFIER_GFIBER_ADVERTISING_ID = 6;
    public static final int DEVICE_IDENTIFIER_GLOBAL_ID = 2;
    public static final int DEVICE_IDENTIFIER_NO_ID = 0;
    private static volatile AFMASignals[] zzaL;
    public Long actSignal;
    public Long acxSignal;
    public Long acySignal;
    public Long aczSignal;
    public String afmaVersion;
    public Long attSignal;
    public Long atvSignal;
    public Long btlSignal;
    public Long btsSignal;
    public String cerSignal;
    public Boolean didOptOut;
    public String didSignal;
    public String didSignalAndroidAdId;
    public Integer didSignalType;
    public Long evtTime;
    public String intSignal;
    public Long jbkSignal;
    public Long netSignal;
    public Long ornSignal;
    public String osVersion;
    public Long psnSignal;
    public Long reqType;
    public String stkSignal;
    public Long swzSignal;
    public Long tctSignal;
    public Long tcxSignal;
    public Long tcySignal;
    public Long uhSignal;
    public Long uptSignal;
    public Long usgSignal;
    public Long utzSignal;
    public Long uwSignal;
    public Long vcdSignal;
    public Long visSignal;
    public String vnmSignal;
    
    public AFMASignals()
    {
      clear();
    }
    
    public static AFMASignals[] emptyArray()
    {
      if (zzaL == null) {}
      synchronized (zzti.zzbqa)
      {
        if (zzaL == null) {
          zzaL = new AFMASignals[0];
        }
        return zzaL;
      }
    }
    
    public static AFMASignals parseFrom(zztc paramzztc)
      throws IOException
    {
      return new AFMASignals().mergeFrom(paramzztc);
    }
    
    public static AFMASignals parseFrom(byte[] paramArrayOfByte)
      throws zztj
    {
      return (AFMASignals)zztk.mergeFrom(new AFMASignals(), paramArrayOfByte);
    }
    
    public AFMASignals clear()
    {
      this.osVersion = null;
      this.afmaVersion = null;
      this.atvSignal = null;
      this.attSignal = null;
      this.btsSignal = null;
      this.btlSignal = null;
      this.acxSignal = null;
      this.acySignal = null;
      this.aczSignal = null;
      this.actSignal = null;
      this.netSignal = null;
      this.ornSignal = null;
      this.stkSignal = null;
      this.tcxSignal = null;
      this.tcySignal = null;
      this.tctSignal = null;
      this.uptSignal = null;
      this.visSignal = null;
      this.swzSignal = null;
      this.psnSignal = null;
      this.jbkSignal = null;
      this.usgSignal = null;
      this.intSignal = null;
      this.cerSignal = null;
      this.uwSignal = null;
      this.uhSignal = null;
      this.utzSignal = null;
      this.vnmSignal = null;
      this.vcdSignal = null;
      this.reqType = null;
      this.didSignal = null;
      this.didSignalType = null;
      this.didOptOut = null;
      this.didSignalAndroidAdId = null;
      this.evtTime = null;
      this.zzbqb = -1;
      return this;
    }
    
    public AFMASignals mergeFrom(zztc paramzztc)
      throws IOException
    {
      for (;;)
      {
        int i = paramzztc.zzHi();
        switch (i)
        {
        default: 
          if (zztn.zzb(paramzztc, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          this.osVersion = paramzztc.readString();
          break;
        case 18: 
          this.afmaVersion = paramzztc.readString();
          break;
        case 24: 
          this.atvSignal = Long.valueOf(paramzztc.zzHk());
          break;
        case 32: 
          this.attSignal = Long.valueOf(paramzztc.zzHk());
          break;
        case 40: 
          this.btsSignal = Long.valueOf(paramzztc.zzHk());
          break;
        case 48: 
          this.btlSignal = Long.valueOf(paramzztc.zzHk());
          break;
        case 56: 
          this.acxSignal = Long.valueOf(paramzztc.zzHk());
          break;
        case 64: 
          this.acySignal = Long.valueOf(paramzztc.zzHk());
          break;
        case 72: 
          this.aczSignal = Long.valueOf(paramzztc.zzHk());
          break;
        case 80: 
          this.actSignal = Long.valueOf(paramzztc.zzHk());
          break;
        case 88: 
          this.netSignal = Long.valueOf(paramzztc.zzHk());
          break;
        case 96: 
          this.ornSignal = Long.valueOf(paramzztc.zzHk());
          break;
        case 106: 
          this.stkSignal = paramzztc.readString();
          break;
        case 112: 
          this.tcxSignal = Long.valueOf(paramzztc.zzHk());
          break;
        case 120: 
          this.tcySignal = Long.valueOf(paramzztc.zzHk());
          break;
        case 128: 
          this.tctSignal = Long.valueOf(paramzztc.zzHk());
          break;
        case 136: 
          this.uptSignal = Long.valueOf(paramzztc.zzHk());
          break;
        case 144: 
          this.visSignal = Long.valueOf(paramzztc.zzHk());
          break;
        case 152: 
          this.swzSignal = Long.valueOf(paramzztc.zzHk());
          break;
        case 160: 
          this.psnSignal = Long.valueOf(paramzztc.zzHk());
          break;
        case 168: 
          this.reqType = Long.valueOf(paramzztc.zzHk());
          break;
        case 176: 
          this.jbkSignal = Long.valueOf(paramzztc.zzHk());
          break;
        case 184: 
          this.usgSignal = Long.valueOf(paramzztc.zzHk());
          break;
        case 194: 
          this.didSignal = paramzztc.readString();
          break;
        case 200: 
          this.evtTime = Long.valueOf(paramzztc.zzHk());
          break;
        case 208: 
          i = paramzztc.zzHl();
          switch (i)
          {
          default: 
            break;
          case 0: 
          case 1: 
          case 2: 
          case 3: 
          case 4: 
          case 5: 
          case 6: 
            this.didSignalType = Integer.valueOf(i);
          }
          break;
        case 218: 
          this.intSignal = paramzztc.readString();
          break;
        case 224: 
          this.didOptOut = Boolean.valueOf(paramzztc.zzHm());
          break;
        case 234: 
          this.cerSignal = paramzztc.readString();
          break;
        case 242: 
          this.didSignalAndroidAdId = paramzztc.readString();
          break;
        case 248: 
          this.uwSignal = Long.valueOf(paramzztc.zzHk());
          break;
        case 256: 
          this.uhSignal = Long.valueOf(paramzztc.zzHk());
          break;
        case 264: 
          this.utzSignal = Long.valueOf(paramzztc.zzHk());
          break;
        case 274: 
          this.vnmSignal = paramzztc.readString();
          break;
        case 280: 
          this.vcdSignal = Long.valueOf(paramzztc.zzHk());
        }
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      if (this.osVersion != null) {
        paramzztd.zzb(1, this.osVersion);
      }
      if (this.afmaVersion != null) {
        paramzztd.zzb(2, this.afmaVersion);
      }
      if (this.atvSignal != null) {
        paramzztd.zzb(3, this.atvSignal.longValue());
      }
      if (this.attSignal != null) {
        paramzztd.zzb(4, this.attSignal.longValue());
      }
      if (this.btsSignal != null) {
        paramzztd.zzb(5, this.btsSignal.longValue());
      }
      if (this.btlSignal != null) {
        paramzztd.zzb(6, this.btlSignal.longValue());
      }
      if (this.acxSignal != null) {
        paramzztd.zzb(7, this.acxSignal.longValue());
      }
      if (this.acySignal != null) {
        paramzztd.zzb(8, this.acySignal.longValue());
      }
      if (this.aczSignal != null) {
        paramzztd.zzb(9, this.aczSignal.longValue());
      }
      if (this.actSignal != null) {
        paramzztd.zzb(10, this.actSignal.longValue());
      }
      if (this.netSignal != null) {
        paramzztd.zzb(11, this.netSignal.longValue());
      }
      if (this.ornSignal != null) {
        paramzztd.zzb(12, this.ornSignal.longValue());
      }
      if (this.stkSignal != null) {
        paramzztd.zzb(13, this.stkSignal);
      }
      if (this.tcxSignal != null) {
        paramzztd.zzb(14, this.tcxSignal.longValue());
      }
      if (this.tcySignal != null) {
        paramzztd.zzb(15, this.tcySignal.longValue());
      }
      if (this.tctSignal != null) {
        paramzztd.zzb(16, this.tctSignal.longValue());
      }
      if (this.uptSignal != null) {
        paramzztd.zzb(17, this.uptSignal.longValue());
      }
      if (this.visSignal != null) {
        paramzztd.zzb(18, this.visSignal.longValue());
      }
      if (this.swzSignal != null) {
        paramzztd.zzb(19, this.swzSignal.longValue());
      }
      if (this.psnSignal != null) {
        paramzztd.zzb(20, this.psnSignal.longValue());
      }
      if (this.reqType != null) {
        paramzztd.zzb(21, this.reqType.longValue());
      }
      if (this.jbkSignal != null) {
        paramzztd.zzb(22, this.jbkSignal.longValue());
      }
      if (this.usgSignal != null) {
        paramzztd.zzb(23, this.usgSignal.longValue());
      }
      if (this.didSignal != null) {
        paramzztd.zzb(24, this.didSignal);
      }
      if (this.evtTime != null) {
        paramzztd.zzb(25, this.evtTime.longValue());
      }
      if (this.didSignalType != null) {
        paramzztd.zzG(26, this.didSignalType.intValue());
      }
      if (this.intSignal != null) {
        paramzztd.zzb(27, this.intSignal);
      }
      if (this.didOptOut != null) {
        paramzztd.zzb(28, this.didOptOut.booleanValue());
      }
      if (this.cerSignal != null) {
        paramzztd.zzb(29, this.cerSignal);
      }
      if (this.didSignalAndroidAdId != null) {
        paramzztd.zzb(30, this.didSignalAndroidAdId);
      }
      if (this.uwSignal != null) {
        paramzztd.zzb(31, this.uwSignal.longValue());
      }
      if (this.uhSignal != null) {
        paramzztd.zzb(32, this.uhSignal.longValue());
      }
      if (this.utzSignal != null) {
        paramzztd.zzb(33, this.utzSignal.longValue());
      }
      if (this.vnmSignal != null) {
        paramzztd.zzb(34, this.vnmSignal);
      }
      if (this.vcdSignal != null) {
        paramzztd.zzb(35, this.vcdSignal.longValue());
      }
      super.writeTo(paramzztd);
    }
    
    protected int zzz()
    {
      int j = super.zzz();
      int i = j;
      if (this.osVersion != null) {
        i = j + zztd.zzp(1, this.osVersion);
      }
      j = i;
      if (this.afmaVersion != null) {
        j = i + zztd.zzp(2, this.afmaVersion);
      }
      i = j;
      if (this.atvSignal != null) {
        i = j + zztd.zzd(3, this.atvSignal.longValue());
      }
      j = i;
      if (this.attSignal != null) {
        j = i + zztd.zzd(4, this.attSignal.longValue());
      }
      i = j;
      if (this.btsSignal != null) {
        i = j + zztd.zzd(5, this.btsSignal.longValue());
      }
      j = i;
      if (this.btlSignal != null) {
        j = i + zztd.zzd(6, this.btlSignal.longValue());
      }
      i = j;
      if (this.acxSignal != null) {
        i = j + zztd.zzd(7, this.acxSignal.longValue());
      }
      j = i;
      if (this.acySignal != null) {
        j = i + zztd.zzd(8, this.acySignal.longValue());
      }
      i = j;
      if (this.aczSignal != null) {
        i = j + zztd.zzd(9, this.aczSignal.longValue());
      }
      j = i;
      if (this.actSignal != null) {
        j = i + zztd.zzd(10, this.actSignal.longValue());
      }
      i = j;
      if (this.netSignal != null) {
        i = j + zztd.zzd(11, this.netSignal.longValue());
      }
      j = i;
      if (this.ornSignal != null) {
        j = i + zztd.zzd(12, this.ornSignal.longValue());
      }
      i = j;
      if (this.stkSignal != null) {
        i = j + zztd.zzp(13, this.stkSignal);
      }
      j = i;
      if (this.tcxSignal != null) {
        j = i + zztd.zzd(14, this.tcxSignal.longValue());
      }
      i = j;
      if (this.tcySignal != null) {
        i = j + zztd.zzd(15, this.tcySignal.longValue());
      }
      j = i;
      if (this.tctSignal != null) {
        j = i + zztd.zzd(16, this.tctSignal.longValue());
      }
      i = j;
      if (this.uptSignal != null) {
        i = j + zztd.zzd(17, this.uptSignal.longValue());
      }
      j = i;
      if (this.visSignal != null) {
        j = i + zztd.zzd(18, this.visSignal.longValue());
      }
      i = j;
      if (this.swzSignal != null) {
        i = j + zztd.zzd(19, this.swzSignal.longValue());
      }
      j = i;
      if (this.psnSignal != null) {
        j = i + zztd.zzd(20, this.psnSignal.longValue());
      }
      i = j;
      if (this.reqType != null) {
        i = j + zztd.zzd(21, this.reqType.longValue());
      }
      j = i;
      if (this.jbkSignal != null) {
        j = i + zztd.zzd(22, this.jbkSignal.longValue());
      }
      i = j;
      if (this.usgSignal != null) {
        i = j + zztd.zzd(23, this.usgSignal.longValue());
      }
      j = i;
      if (this.didSignal != null) {
        j = i + zztd.zzp(24, this.didSignal);
      }
      i = j;
      if (this.evtTime != null) {
        i = j + zztd.zzd(25, this.evtTime.longValue());
      }
      j = i;
      if (this.didSignalType != null) {
        j = i + zztd.zzI(26, this.didSignalType.intValue());
      }
      i = j;
      if (this.intSignal != null) {
        i = j + zztd.zzp(27, this.intSignal);
      }
      j = i;
      if (this.didOptOut != null) {
        j = i + zztd.zzc(28, this.didOptOut.booleanValue());
      }
      i = j;
      if (this.cerSignal != null) {
        i = j + zztd.zzp(29, this.cerSignal);
      }
      j = i;
      if (this.didSignalAndroidAdId != null) {
        j = i + zztd.zzp(30, this.didSignalAndroidAdId);
      }
      i = j;
      if (this.uwSignal != null) {
        i = j + zztd.zzd(31, this.uwSignal.longValue());
      }
      j = i;
      if (this.uhSignal != null) {
        j = i + zztd.zzd(32, this.uhSignal.longValue());
      }
      i = j;
      if (this.utzSignal != null) {
        i = j + zztd.zzd(33, this.utzSignal.longValue());
      }
      j = i;
      if (this.vnmSignal != null) {
        j = i + zztd.zzp(34, this.vnmSignal);
      }
      i = j;
      if (this.vcdSignal != null) {
        i = j + zztd.zzd(35, this.vcdSignal.longValue());
      }
      return i;
    }
  }
  
  public static final class AdSignalsContainer
    extends zztk
  {
    private static volatile AdSignalsContainer[] zzaM;
    public byte[] encryptedDidSignal;
    public byte[] encryptedSpamSignals;
    
    public AdSignalsContainer()
    {
      clear();
    }
    
    public static AdSignalsContainer[] emptyArray()
    {
      if (zzaM == null) {}
      synchronized (zzti.zzbqa)
      {
        if (zzaM == null) {
          zzaM = new AdSignalsContainer[0];
        }
        return zzaM;
      }
    }
    
    public static AdSignalsContainer parseFrom(zztc paramzztc)
      throws IOException
    {
      return new AdSignalsContainer().mergeFrom(paramzztc);
    }
    
    public static AdSignalsContainer parseFrom(byte[] paramArrayOfByte)
      throws zztj
    {
      return (AdSignalsContainer)zztk.mergeFrom(new AdSignalsContainer(), paramArrayOfByte);
    }
    
    public AdSignalsContainer clear()
    {
      this.encryptedSpamSignals = null;
      this.encryptedDidSignal = null;
      this.zzbqb = -1;
      return this;
    }
    
    public AdSignalsContainer mergeFrom(zztc paramzztc)
      throws IOException
    {
      for (;;)
      {
        int i = paramzztc.zzHi();
        switch (i)
        {
        default: 
          if (zztn.zzb(paramzztc, i)) {}
          break;
        case 0: 
          return this;
        case 10: 
          this.encryptedSpamSignals = paramzztc.readBytes();
          break;
        case 18: 
          this.encryptedDidSignal = paramzztc.readBytes();
        }
      }
    }
    
    public void writeTo(zztd paramzztd)
      throws IOException
    {
      if (this.encryptedSpamSignals != null) {
        paramzztd.zza(1, this.encryptedSpamSignals);
      }
      if (this.encryptedDidSignal != null) {
        paramzztd.zza(2, this.encryptedDidSignal);
      }
      super.writeTo(paramzztd);
    }
    
    protected int zzz()
    {
      int j = super.zzz();
      int i = j;
      if (this.encryptedSpamSignals != null) {
        i = j + zztd.zzb(1, this.encryptedSpamSignals);
      }
      j = i;
      if (this.encryptedDidSignal != null) {
        j = i + zztd.zzb(2, this.encryptedDidSignal);
      }
      return j;
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/ads/afma/nano/NanoAfmaSignals.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */