package com.mobileapptracker;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MATEvent
  implements Serializable
{
  public static final String ACHIEVEMENT_UNLOCKED = "achievement_unlocked";
  public static final String ADDED_PAYMENT_INFO = "added_payment_info";
  public static final String ADD_TO_CART = "add_to_cart";
  public static final String ADD_TO_WISHLIST = "add_to_wishlist";
  public static final String CHECKOUT_INITIATED = "checkout_initiated";
  public static final String CONTENT_VIEW = "content_view";
  public static final String DEVICE_FORM_WEARABLE = "wearable";
  public static final String INVITE = "invite";
  public static final String LEVEL_ACHIEVED = "level_achieved";
  public static final String LOGIN = "login";
  public static final String PURCHASE = "purchase";
  public static final String RATED = "rated";
  public static final String REGISTRATION = "registration";
  public static final String RESERVATION = "reservation";
  public static final String SEARCH = "search";
  public static final String SHARE = "share";
  public static final String SPENT_CREDITS = "spent_credits";
  public static final String TUTORIAL_COMPLETE = "tutorial_complete";
  private static final long serialVersionUID = -7616393848331704848L;
  private String attribute1;
  private String attribute2;
  private String attribute3;
  private String attribute4;
  private String attribute5;
  private String contentId;
  private String contentType;
  private String currencyCode;
  private Date date1;
  private Date date2;
  private String deviceForm;
  private int eventId;
  private List<MATEventItem> eventItems;
  private String eventName;
  private int level;
  private int quantity;
  private double rating;
  private String receiptData;
  private String receiptSignature;
  private String refId;
  private double revenue;
  private String searchString;
  
  public MATEvent(int paramInt)
  {
    this.eventId = paramInt;
  }
  
  public MATEvent(String paramString)
  {
    this.eventName = paramString;
  }
  
  public String getAttribute1()
  {
    return this.attribute1;
  }
  
  public String getAttribute2()
  {
    return this.attribute2;
  }
  
  public String getAttribute3()
  {
    return this.attribute3;
  }
  
  public String getAttribute4()
  {
    return this.attribute4;
  }
  
  public String getAttribute5()
  {
    return this.attribute5;
  }
  
  public String getContentId()
  {
    return this.contentId;
  }
  
  public String getContentType()
  {
    return this.contentType;
  }
  
  public String getCurrencyCode()
  {
    return this.currencyCode;
  }
  
  public Date getDate1()
  {
    return this.date1;
  }
  
  public Date getDate2()
  {
    return this.date2;
  }
  
  public String getDeviceForm()
  {
    return this.deviceForm;
  }
  
  public int getEventId()
  {
    return this.eventId;
  }
  
  public List<MATEventItem> getEventItems()
  {
    return this.eventItems;
  }
  
  public String getEventName()
  {
    return this.eventName;
  }
  
  public int getLevel()
  {
    return this.level;
  }
  
  public int getQuantity()
  {
    return this.quantity;
  }
  
  public double getRating()
  {
    return this.rating;
  }
  
  public String getReceiptData()
  {
    return this.receiptData;
  }
  
  public String getReceiptSignature()
  {
    return this.receiptSignature;
  }
  
  public String getRefId()
  {
    return this.refId;
  }
  
  public double getRevenue()
  {
    return this.revenue;
  }
  
  public String getSearchString()
  {
    return this.searchString;
  }
  
  public MATEvent withAdvertiserRefId(String paramString)
  {
    this.refId = paramString;
    return this;
  }
  
  public MATEvent withAttribute1(String paramString)
  {
    this.attribute1 = paramString;
    return this;
  }
  
  public MATEvent withAttribute2(String paramString)
  {
    this.attribute2 = paramString;
    return this;
  }
  
  public MATEvent withAttribute3(String paramString)
  {
    this.attribute3 = paramString;
    return this;
  }
  
  public MATEvent withAttribute4(String paramString)
  {
    this.attribute4 = paramString;
    return this;
  }
  
  public MATEvent withAttribute5(String paramString)
  {
    this.attribute5 = paramString;
    return this;
  }
  
  public MATEvent withContentId(String paramString)
  {
    this.contentId = paramString;
    return this;
  }
  
  public MATEvent withContentType(String paramString)
  {
    this.contentType = paramString;
    return this;
  }
  
  public MATEvent withCurrencyCode(String paramString)
  {
    this.currencyCode = paramString;
    return this;
  }
  
  public MATEvent withDate1(Date paramDate)
  {
    this.date1 = paramDate;
    return this;
  }
  
  public MATEvent withDate2(Date paramDate)
  {
    this.date2 = paramDate;
    return this;
  }
  
  public MATEvent withDeviceForm(String paramString)
  {
    this.deviceForm = paramString;
    return this;
  }
  
  public MATEvent withEventItems(List<MATEventItem> paramList)
  {
    this.eventItems = paramList;
    return this;
  }
  
  public MATEvent withLevel(int paramInt)
  {
    this.level = paramInt;
    return this;
  }
  
  public MATEvent withQuantity(int paramInt)
  {
    this.quantity = paramInt;
    return this;
  }
  
  public MATEvent withRating(double paramDouble)
  {
    this.rating = paramDouble;
    return this;
  }
  
  public MATEvent withReceipt(String paramString1, String paramString2)
  {
    this.receiptData = paramString1;
    this.receiptSignature = paramString2;
    return this;
  }
  
  public MATEvent withRevenue(double paramDouble)
  {
    this.revenue = paramDouble;
    return this;
  }
  
  public MATEvent withSearchString(String paramString)
  {
    this.searchString = paramString;
    return this;
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/mobileapptracker/MATEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */