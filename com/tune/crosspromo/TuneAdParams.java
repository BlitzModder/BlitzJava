package com.tune.crosspromo;

import android.location.Location;
import com.mobileapptracker.MATGender;
import com.mobileapptracker.MATParameters;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TuneAdParams
{
  public int adHeightLandscape;
  public int adHeightPortrait;
  public int adWidthLandscape;
  public int adWidthPortrait;
  private String advertiserId;
  private String altitude;
  private String androidId;
  private String appName;
  private String appVersion;
  private Date birthDate;
  private String connectionType;
  private String countryCode;
  private String currentOrientation;
  private JSONObject customTargets;
  public boolean debugMode;
  private String deviceBrand;
  private String deviceCarrier;
  private String deviceCpuType;
  private String deviceModel;
  private String facebookUserId;
  private MATGender gender;
  private String googleAdId;
  private boolean googleIsLATEnabled;
  private String googleUserId;
  private String installDate;
  private String installReferrer;
  private String installer;
  private String keyCheck;
  private Set<String> keywords;
  private String language;
  private String lastOpenLogId;
  private String latitude;
  private Location location;
  private String longitude;
  private TuneAdOrientation mOrientation;
  private String mPlacement;
  private String matId;
  private String mcc;
  private String mnc;
  private String osVersion;
  private String packageName;
  private boolean payingUser;
  private String pluginName;
  private String referralSource;
  private String referralUrl;
  private JSONObject refs;
  private float screenDensity;
  private int screenHeight;
  private int screenWidth;
  private String sdkVersion;
  private String timeZone;
  private String twitterUserId;
  private String userAgent;
  private String userEmailMd5;
  private String userEmailSha1;
  private String userEmailSha256;
  private String userId;
  private String userNameMd5;
  private String userNameSha1;
  private String userNameSha256;
  private String userPhoneMd5;
  private String userPhoneSha1;
  private String userPhoneSha256;
  
  public TuneAdParams(String paramString, MATParameters paramMATParameters, TuneAdMetadata paramTuneAdMetadata, TuneAdOrientation paramTuneAdOrientation, int paramInt)
  {
    this.mPlacement = paramString;
    this.mOrientation = paramTuneAdOrientation;
    boolean bool;
    if (paramInt == 2)
    {
      this.currentOrientation = "landscape";
      this.advertiserId = paramMATParameters.getAdvertiserId();
      this.androidId = paramMATParameters.getAndroidId();
      this.appName = paramMATParameters.getAppName();
      this.appVersion = paramMATParameters.getAppVersion();
      this.connectionType = paramMATParameters.getConnectionType();
      this.countryCode = paramMATParameters.getCountryCode();
      this.debugMode = paramMATParameters.getDebugMode();
      this.deviceBrand = paramMATParameters.getDeviceBrand();
      this.deviceCarrier = paramMATParameters.getDeviceCarrier();
      this.deviceCpuType = paramMATParameters.getDeviceCpuType();
      this.deviceModel = paramMATParameters.getDeviceModel();
      this.googleAdId = paramMATParameters.getGoogleAdvertisingId();
      if ((paramMATParameters.getGoogleAdTrackingLimited() == null) || (!paramMATParameters.getGoogleAdTrackingLimited().equals("1"))) {
        break label723;
      }
      bool = true;
      label145:
      this.googleIsLATEnabled = bool;
      this.installDate = paramMATParameters.getInstallDate();
      this.installReferrer = paramMATParameters.getInstallReferrer();
      this.installer = paramMATParameters.getInstaller();
      paramString = paramMATParameters.getConversionKey();
      this.keyCheck = paramString.substring(Math.max(0, paramString.length() - 4));
      this.language = paramMATParameters.getLanguage();
      this.lastOpenLogId = paramMATParameters.getLastOpenLogId();
      this.matId = paramMATParameters.getMatId();
      this.mcc = paramMATParameters.getMCC();
      this.mnc = paramMATParameters.getMNC();
      this.osVersion = paramMATParameters.getOsVersion();
      this.packageName = paramMATParameters.getPackageName();
      this.pluginName = paramMATParameters.getPluginName();
      this.referralSource = paramMATParameters.getReferralSource();
      this.referralUrl = paramMATParameters.getReferralUrl();
      this.screenDensity = Float.parseFloat(paramMATParameters.getScreenDensity());
      this.screenHeight = Integer.parseInt(paramMATParameters.getScreenHeight());
      this.screenWidth = Integer.parseInt(paramMATParameters.getScreenWidth());
      this.sdkVersion = paramMATParameters.getSdkVersion();
      this.timeZone = paramMATParameters.getTimeZone();
      this.userAgent = paramMATParameters.getUserAgent();
      this.gender = MATGender.UNKNOWN;
      paramString = paramMATParameters.getGender();
      if (paramString != null)
      {
        if (!paramString.equals("0")) {
          break label729;
        }
        this.gender = MATGender.MALE;
      }
      label368:
      this.facebookUserId = paramMATParameters.getFacebookUserId();
      this.googleUserId = paramMATParameters.getGoogleUserId();
      this.twitterUserId = paramMATParameters.getTwitterUserId();
      if (!paramMATParameters.getIsPayingUser().equals("1")) {
        break label748;
      }
      this.payingUser = true;
      label409:
      this.userEmailMd5 = paramMATParameters.getUserEmailMd5();
      this.userEmailSha1 = paramMATParameters.getUserEmailSha1();
      this.userEmailSha256 = paramMATParameters.getUserEmailSha256();
      this.userId = paramMATParameters.getUserId();
      this.userNameMd5 = paramMATParameters.getUserNameMd5();
      this.userNameSha1 = paramMATParameters.getUserNameSha1();
      this.userNameSha256 = paramMATParameters.getUserNameSha256();
      this.userPhoneMd5 = paramMATParameters.getPhoneNumberMd5();
      this.userPhoneSha1 = paramMATParameters.getPhoneNumberSha1();
      this.userPhoneSha256 = paramMATParameters.getPhoneNumberSha256();
      if (paramInt != 2) {
        break label756;
      }
      this.adWidthLandscape = this.screenWidth;
      this.adHeightLandscape = this.screenHeight;
      this.adWidthPortrait = this.screenHeight;
      this.adHeightPortrait = this.screenWidth;
    }
    for (;;)
    {
      if (paramTuneAdMetadata != null)
      {
        this.birthDate = paramTuneAdMetadata.getBirthDate();
        this.gender = paramTuneAdMetadata.getGender();
        this.keywords = paramTuneAdMetadata.getKeywords();
        this.location = paramTuneAdMetadata.getLocation();
        if (this.location != null)
        {
          this.altitude = String.valueOf(this.location.getAltitude());
          this.latitude = String.valueOf(this.location.getLatitude());
          this.longitude = String.valueOf(this.location.getLongitude());
        }
        if ((paramTuneAdMetadata.getLatitude() != 0.0D) && (paramTuneAdMetadata.getLongitude() != 0.0D))
        {
          this.latitude = String.valueOf(paramTuneAdMetadata.getLatitude());
          this.longitude = String.valueOf(paramTuneAdMetadata.getLongitude());
        }
        if (paramTuneAdMetadata.getCustomTargets() != null) {
          this.customTargets = new JSONObject(paramTuneAdMetadata.getCustomTargets());
        }
        if (paramTuneAdMetadata.isInDebugMode()) {
          this.debugMode = paramTuneAdMetadata.isInDebugMode();
        }
        paramMATParameters.setGender(this.gender);
        if (this.location != null) {
          paramMATParameters.setLocation(this.location);
        }
      }
      return;
      this.currentOrientation = "portrait";
      break;
      label723:
      bool = false;
      break label145;
      label729:
      if (!paramString.equals("1")) {
        break label368;
      }
      this.gender = MATGender.FEMALE;
      break label368;
      label748:
      this.payingUser = false;
      break label409;
      label756:
      this.adWidthPortrait = this.screenWidth;
      this.adHeightPortrait = this.screenHeight;
      this.adWidthLandscape = this.screenHeight;
      this.adHeightLandscape = this.screenWidth;
    }
  }
  
  public JSONObject getRefs()
  {
    return this.refs;
  }
  
  public void setRefs(JSONObject paramJSONObject)
  {
    this.refs = paramJSONObject;
  }
  
  public JSONObject toJSON()
  {
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      JSONObject localJSONObject6;
      Object localObject;
      Iterator localIterator;
      try
      {
        JSONObject localJSONObject2 = new JSONObject().put("advertiserId", this.advertiserId).put("keyCheck", this.keyCheck).put("name", this.appName).put("version", this.appVersion).put("installDate", this.installDate).put("installReferrer", this.installReferrer).put("installer", this.installer).put("referralSource", this.referralSource).put("referralUrl", this.referralUrl).put("package", this.packageName);
        JSONObject localJSONObject3 = new JSONObject().put("altitude", this.altitude).put("connectionType", this.connectionType).put("country", this.countryCode).put("deviceBrand", this.deviceBrand).put("deviceCarrier", this.deviceCarrier).put("deviceCpuType", this.deviceCpuType).put("deviceModel", this.deviceModel).put("language", this.language).put("latitude", this.latitude).put("longitude", this.longitude).put("mcc", this.mcc).put("mnc", this.mnc).put("os", "Android").put("osVersion", this.osVersion).put("timezone", this.timeZone).put("userAgent", this.userAgent);
        JSONObject localJSONObject4 = new JSONObject();
        localJSONObject4.put("androidId", this.androidId);
        localJSONObject4.put("gaid", this.googleAdId);
        localJSONObject4.put("googleAdTrackingDisabled", this.googleIsLATEnabled);
        localJSONObject4.put("matId", this.matId);
        JSONObject localJSONObject5 = new JSONObject().put("density", this.screenDensity).put("height", this.screenHeight).put("width", this.screenWidth);
        localJSONObject6 = new JSONObject();
        if (this.mOrientation.equals(TuneAdOrientation.ALL))
        {
          JSONObject localJSONObject7 = new JSONObject().put("width", this.adWidthPortrait).put("height", this.adHeightPortrait);
          localObject = new JSONObject().put("width", this.adWidthLandscape).put("height", this.adHeightLandscape);
          localJSONObject6.put("portrait", localJSONObject7).put("landscape", localObject);
          localJSONObject7 = new JSONObject();
          if (this.birthDate != null) {
            localJSONObject7.put("birthDate", Long.toString(this.birthDate.getTime() / 1000L));
          }
          localJSONObject7.put("facebookUserId", this.facebookUserId);
          localJSONObject7.put("gender", this.gender);
          localJSONObject7.put("googleUserId", this.googleUserId);
          if (this.keywords != null)
          {
            localObject = new JSONArray();
            localIterator = this.keywords.iterator();
            if (localIterator.hasNext()) {
              break label1047;
            }
            localJSONObject7.put("keywords", localObject);
          }
          localJSONObject7.put("payingUser", this.payingUser);
          localJSONObject7.put("twitterUserId", this.twitterUserId);
          localJSONObject7.put("userEmailMd5", this.userEmailMd5);
          localJSONObject7.put("userEmailSha1", this.userEmailSha1);
          localJSONObject7.put("userEmailSha256", this.userEmailSha256);
          if ((this.userId != null) && (this.userId.length() != 0)) {
            localJSONObject7.put("userId", this.userId);
          }
          localJSONObject7.put("userNameMd5", this.userNameMd5);
          localJSONObject7.put("userNameSha1", this.userNameSha1);
          localJSONObject7.put("userNameSha256", this.userNameSha256);
          localJSONObject7.put("userPhoneMd5", this.userPhoneMd5);
          localJSONObject7.put("userPhoneSha1", this.userPhoneSha1);
          localJSONObject7.put("userPhoneSha256", this.userPhoneSha256);
          localJSONObject1.put("currentOrientation", this.currentOrientation);
          localJSONObject1.put("debugMode", this.debugMode);
          localJSONObject1.put("sdkVersion", this.sdkVersion);
          localJSONObject1.put("plugin", this.pluginName);
          localJSONObject1.put("lastOpenLogId", this.lastOpenLogId);
          localJSONObject1.put("app", localJSONObject2);
          localJSONObject1.put("device", localJSONObject3);
          localJSONObject1.put("ids", localJSONObject4);
          localJSONObject1.put("screen", localJSONObject5);
          localJSONObject1.put("sizes", localJSONObject6);
          localJSONObject1.put("user", localJSONObject7);
          localJSONObject1.put("targets", this.customTargets);
          localJSONObject1.put("refs", this.refs);
          localJSONObject1.put("placement", this.mPlacement);
          return localJSONObject1;
        }
        if (this.mOrientation.equals(TuneAdOrientation.PORTRAIT_ONLY))
        {
          localJSONObject6.put("portrait", new JSONObject().put("width", this.adWidthPortrait).put("height", this.adHeightPortrait));
          continue;
        }
        if (!this.mOrientation.equals(TuneAdOrientation.LANDSCAPE_ONLY)) {
          continue;
        }
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return localJSONObject1;
      }
      localJSONObject6.put("landscape", new JSONObject().put("width", this.adWidthLandscape).put("height", this.adHeightLandscape));
      continue;
      label1047:
      ((JSONArray)localObject).put((String)localIterator.next());
    }
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/tune/crosspromo/TuneAdParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */