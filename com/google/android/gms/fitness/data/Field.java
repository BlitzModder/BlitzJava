package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

public final class Field
  implements SafeParcelable
{
  public static final Parcelable.Creator<Field> CREATOR = new zzi();
  public static final Field FIELD_ACCURACY;
  public static final Field FIELD_ACTIVITY = zzdf("activity");
  public static final Field FIELD_ALTITUDE;
  public static final Field FIELD_AVERAGE;
  public static final Field FIELD_BPM;
  public static final Field FIELD_CALORIES;
  public static final Field FIELD_CIRCUMFERENCE;
  public static final Field FIELD_CONFIDENCE = zzdg("confidence");
  public static final Field FIELD_DISTANCE;
  public static final Field FIELD_DURATION;
  public static final Field FIELD_EXERCISE;
  public static final Field FIELD_FOOD_ITEM;
  public static final Field FIELD_HEIGHT;
  public static final Field FIELD_HIGH_LATITUDE;
  public static final Field FIELD_HIGH_LONGITUDE;
  public static final Field FIELD_LATITUDE;
  public static final Field FIELD_LONGITUDE;
  public static final Field FIELD_LOW_LATITUDE;
  public static final Field FIELD_LOW_LONGITUDE;
  public static final Field FIELD_MAX;
  public static final Field FIELD_MEAL_TYPE;
  public static final Field FIELD_MIN;
  public static final Field FIELD_NUM_SEGMENTS;
  public static final Field FIELD_NUTRIENTS;
  public static final Field FIELD_PERCENTAGE;
  public static final Field FIELD_REPETITIONS;
  public static final Field FIELD_RESISTANCE;
  public static final Field FIELD_RESISTANCE_TYPE;
  public static final Field FIELD_REVOLUTIONS;
  public static final Field FIELD_RPM;
  public static final Field FIELD_SPEED;
  public static final Field FIELD_STEPS;
  public static final Field FIELD_WATTS;
  public static final Field FIELD_WEIGHT;
  public static final int FORMAT_FLOAT = 2;
  public static final int FORMAT_INT32 = 1;
  public static final int FORMAT_MAP = 4;
  public static final int FORMAT_STRING = 3;
  public static final int MEAL_TYPE_BREAKFAST = 1;
  public static final int MEAL_TYPE_DINNER = 3;
  public static final int MEAL_TYPE_LUNCH = 2;
  public static final int MEAL_TYPE_SNACK = 4;
  public static final int MEAL_TYPE_UNKNOWN = 0;
  public static final String NUTRIENT_CALCIUM = "calcium";
  public static final String NUTRIENT_CALORIES = "calories";
  public static final String NUTRIENT_CHOLESTEROL = "cholesterol";
  public static final String NUTRIENT_DIETARY_FIBER = "dietary_fiber";
  public static final String NUTRIENT_IRON = "iron";
  public static final String NUTRIENT_MONOUNSATURATED_FAT = "fat.monounsaturated";
  public static final String NUTRIENT_POLYUNSATURATED_FAT = "fat.polyunsaturated";
  public static final String NUTRIENT_POTASSIUM = "potassium";
  public static final String NUTRIENT_PROTEIN = "protein";
  public static final String NUTRIENT_SATURATED_FAT = "fat.saturated";
  public static final String NUTRIENT_SODIUM = "sodium";
  public static final String NUTRIENT_SUGAR = "sugar";
  public static final String NUTRIENT_TOTAL_CARBS = "carbs.total";
  public static final String NUTRIENT_TOTAL_FAT = "fat.total";
  public static final String NUTRIENT_TRANS_FAT = "fat.trans";
  public static final String NUTRIENT_UNSATURATED_FAT = "fat.unsaturated";
  public static final String NUTRIENT_VITAMIN_A = "vitamin_a";
  public static final String NUTRIENT_VITAMIN_C = "vitamin_c";
  public static final int RESISTANCE_TYPE_BARBELL = 1;
  public static final int RESISTANCE_TYPE_BODY = 6;
  public static final int RESISTANCE_TYPE_CABLE = 2;
  public static final int RESISTANCE_TYPE_DUMBBELL = 3;
  public static final int RESISTANCE_TYPE_KETTLEBELL = 4;
  public static final int RESISTANCE_TYPE_MACHINE = 5;
  public static final int RESISTANCE_TYPE_UNKNOWN = 0;
  public static final Field zzauE = zzdi("activity_confidence");
  public static final Field zzauF;
  public static final Field zzauG;
  public static final Field zzauH;
  public static final Field zzauI;
  public static final Field zzauJ;
  public static final Field zzauK;
  public static final Field zzauL;
  public static final Field zzauM;
  public static final Field zzauN;
  public static final Field zzauO;
  public static final Field zzauP;
  public static final Field zzauQ;
  private final String mName;
  private final int mVersionCode;
  private final int zzauR;
  
  static
  {
    FIELD_STEPS = zzdf("steps");
    FIELD_DURATION = zzdf("duration");
    zzauF = zzdi("activity_duration");
    zzauG = zzdi("activity_duration.ascending");
    zzauH = zzdi("activity_duration.descending");
    FIELD_BPM = zzdg("bpm");
    FIELD_LATITUDE = zzdg("latitude");
    FIELD_LONGITUDE = zzdg("longitude");
    FIELD_ACCURACY = zzdg("accuracy");
    FIELD_ALTITUDE = zzdg("altitude");
    FIELD_DISTANCE = zzdg("distance");
    FIELD_HEIGHT = zzdg("height");
    FIELD_WEIGHT = zzdg("weight");
    FIELD_CIRCUMFERENCE = zzdg("circumference");
    FIELD_PERCENTAGE = zzdg("percentage");
    FIELD_SPEED = zzdg("speed");
    FIELD_RPM = zzdg("rpm");
    FIELD_REVOLUTIONS = zzdf("revolutions");
    FIELD_CALORIES = zzdg("calories");
    FIELD_WATTS = zzdg("watts");
    FIELD_MEAL_TYPE = zzdf("meal_type");
    FIELD_FOOD_ITEM = zzdh("food_item");
    FIELD_NUTRIENTS = zzdi("nutrients");
    zzauI = zzdg("elevation.change");
    zzauJ = zzdi("elevation.gain");
    zzauK = zzdi("elevation.loss");
    zzauL = zzdg("floors");
    zzauM = zzdi("floor.gain");
    zzauN = zzdi("floor.loss");
    FIELD_EXERCISE = zzdh("exercise");
    FIELD_REPETITIONS = zzdf("repetitions");
    FIELD_RESISTANCE = zzdg("resistance");
    FIELD_RESISTANCE_TYPE = zzdf("resistance_type");
    FIELD_NUM_SEGMENTS = zzdf("num_segments");
    FIELD_AVERAGE = zzdg("average");
    FIELD_MAX = zzdg("max");
    FIELD_MIN = zzdg("min");
    FIELD_LOW_LATITUDE = zzdg("low_latitude");
    FIELD_LOW_LONGITUDE = zzdg("low_longitude");
    FIELD_HIGH_LATITUDE = zzdg("high_latitude");
    FIELD_HIGH_LONGITUDE = zzdg("high_longitude");
    zzauO = zzdg("x");
    zzauP = zzdg("y");
    zzauQ = zzdg("z");
  }
  
  Field(int paramInt1, String paramString, int paramInt2)
  {
    this.mVersionCode = paramInt1;
    this.mName = ((String)zzx.zzy(paramString));
    this.zzauR = paramInt2;
  }
  
  private Field(String paramString, int paramInt)
  {
    this(1, paramString, paramInt);
  }
  
  private boolean zza(Field paramField)
  {
    return (this.mName.equals(paramField.mName)) && (this.zzauR == paramField.zzauR);
  }
  
  private static Field zzdf(String paramString)
  {
    return new Field(paramString, 1);
  }
  
  private static Field zzdg(String paramString)
  {
    return new Field(paramString, 2);
  }
  
  private static Field zzdh(String paramString)
  {
    return new Field(paramString, 3);
  }
  
  private static Field zzdi(String paramString)
  {
    return new Field(paramString, 4);
  }
  
  public static Field zzn(String paramString, int paramInt)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        return new Field(paramString, paramInt);
        if (paramString.equals("accuracy"))
        {
          i = 0;
          continue;
          if (paramString.equals("activity"))
          {
            i = 1;
            continue;
            if (paramString.equals("activity_duration"))
            {
              i = 2;
              continue;
              if (paramString.equals("activity_duration.ascending"))
              {
                i = 3;
                continue;
                if (paramString.equals("activity_duration.descending"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("altitude"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("average"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("bpm"))
                      {
                        i = 7;
                        continue;
                        if (paramString.equals("calories"))
                        {
                          i = 8;
                          continue;
                          if (paramString.equals("circumference"))
                          {
                            i = 9;
                            continue;
                            if (paramString.equals("confidence"))
                            {
                              i = 10;
                              continue;
                              if (paramString.equals("distance"))
                              {
                                i = 11;
                                continue;
                                if (paramString.equals("duration"))
                                {
                                  i = 12;
                                  continue;
                                  if (paramString.equals("elevation.change"))
                                  {
                                    i = 13;
                                    continue;
                                    if (paramString.equals("elevation.gain"))
                                    {
                                      i = 14;
                                      continue;
                                      if (paramString.equals("elevation.loss"))
                                      {
                                        i = 15;
                                        continue;
                                        if (paramString.equals("exercise"))
                                        {
                                          i = 16;
                                          continue;
                                          if (paramString.equals("floor.gain"))
                                          {
                                            i = 17;
                                            continue;
                                            if (paramString.equals("floor.loss"))
                                            {
                                              i = 18;
                                              continue;
                                              if (paramString.equals("floors"))
                                              {
                                                i = 19;
                                                continue;
                                                if (paramString.equals("food_item"))
                                                {
                                                  i = 20;
                                                  continue;
                                                  if (paramString.equals("height"))
                                                  {
                                                    i = 21;
                                                    continue;
                                                    if (paramString.equals("high_latitude"))
                                                    {
                                                      i = 22;
                                                      continue;
                                                      if (paramString.equals("high_longitude"))
                                                      {
                                                        i = 23;
                                                        continue;
                                                        if (paramString.equals("latitude"))
                                                        {
                                                          i = 24;
                                                          continue;
                                                          if (paramString.equals("longitude"))
                                                          {
                                                            i = 25;
                                                            continue;
                                                            if (paramString.equals("low_latitude"))
                                                            {
                                                              i = 26;
                                                              continue;
                                                              if (paramString.equals("low_longitude"))
                                                              {
                                                                i = 27;
                                                                continue;
                                                                if (paramString.equals("max"))
                                                                {
                                                                  i = 28;
                                                                  continue;
                                                                  if (paramString.equals("meal_type"))
                                                                  {
                                                                    i = 29;
                                                                    continue;
                                                                    if (paramString.equals("min"))
                                                                    {
                                                                      i = 30;
                                                                      continue;
                                                                      if (paramString.equals("num_segments"))
                                                                      {
                                                                        i = 31;
                                                                        continue;
                                                                        if (paramString.equals("nutrients"))
                                                                        {
                                                                          i = 32;
                                                                          continue;
                                                                          if (paramString.equals("percentage"))
                                                                          {
                                                                            i = 33;
                                                                            continue;
                                                                            if (paramString.equals("repetitions"))
                                                                            {
                                                                              i = 34;
                                                                              continue;
                                                                              if (paramString.equals("resistance"))
                                                                              {
                                                                                i = 35;
                                                                                continue;
                                                                                if (paramString.equals("resistance_type"))
                                                                                {
                                                                                  i = 36;
                                                                                  continue;
                                                                                  if (paramString.equals("revolutions"))
                                                                                  {
                                                                                    i = 37;
                                                                                    continue;
                                                                                    if (paramString.equals("rpm"))
                                                                                    {
                                                                                      i = 38;
                                                                                      continue;
                                                                                      if (paramString.equals("speed"))
                                                                                      {
                                                                                        i = 39;
                                                                                        continue;
                                                                                        if (paramString.equals("steps"))
                                                                                        {
                                                                                          i = 40;
                                                                                          continue;
                                                                                          if (paramString.equals("watts"))
                                                                                          {
                                                                                            i = 41;
                                                                                            continue;
                                                                                            if (paramString.equals("weight"))
                                                                                            {
                                                                                              i = 42;
                                                                                              continue;
                                                                                              if (paramString.equals("x"))
                                                                                              {
                                                                                                i = 43;
                                                                                                continue;
                                                                                                if (paramString.equals("y"))
                                                                                                {
                                                                                                  i = 44;
                                                                                                  continue;
                                                                                                  if (paramString.equals("z")) {
                                                                                                    i = 45;
                                                                                                  }
                                                                                                }
                                                                                              }
                                                                                            }
                                                                                          }
                                                                                        }
                                                                                      }
                                                                                    }
                                                                                  }
                                                                                }
                                                                              }
                                                                            }
                                                                          }
                                                                        }
                                                                      }
                                                                    }
                                                                  }
                                                                }
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
        break;
      }
    }
    return FIELD_ACCURACY;
    return FIELD_ACTIVITY;
    return zzauF;
    return zzauG;
    return zzauH;
    return FIELD_ALTITUDE;
    return FIELD_AVERAGE;
    return FIELD_BPM;
    return FIELD_CALORIES;
    return FIELD_CIRCUMFERENCE;
    return FIELD_CONFIDENCE;
    return FIELD_DISTANCE;
    return FIELD_DURATION;
    return zzauI;
    return zzauJ;
    return zzauK;
    return FIELD_EXERCISE;
    return zzauM;
    return zzauN;
    return zzauL;
    return FIELD_FOOD_ITEM;
    return FIELD_HEIGHT;
    return FIELD_HIGH_LATITUDE;
    return FIELD_HIGH_LONGITUDE;
    return FIELD_LATITUDE;
    return FIELD_LONGITUDE;
    return FIELD_LOW_LATITUDE;
    return FIELD_LOW_LONGITUDE;
    return FIELD_MAX;
    return FIELD_MEAL_TYPE;
    return FIELD_MIN;
    return FIELD_NUM_SEGMENTS;
    return FIELD_NUTRIENTS;
    return FIELD_PERCENTAGE;
    return FIELD_REPETITIONS;
    return FIELD_RESISTANCE;
    return FIELD_RESISTANCE_TYPE;
    return FIELD_REVOLUTIONS;
    return FIELD_RPM;
    return FIELD_SPEED;
    return FIELD_STEPS;
    return FIELD_WATTS;
    return FIELD_WEIGHT;
    return zzauO;
    return zzauP;
    return zzauQ;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof Field)) && (zza((Field)paramObject)));
  }
  
  public int getFormat()
  {
    return this.zzauR;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  int getVersionCode()
  {
    return this.mVersionCode;
  }
  
  public int hashCode()
  {
    return this.mName.hashCode();
  }
  
  public String toString()
  {
    String str2 = this.mName;
    if (this.zzauR == 1) {}
    for (String str1 = "i";; str1 = "f") {
      return String.format("%s(%s)", new Object[] { str2, str1 });
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    zzi.zza(this, paramParcel, paramInt);
  }
}


/* Location:              /Users/subdiox/Downloads/dex2jar-2.0/net.wargaming.wot.blitz-dex2jar.jar!/com/google/android/gms/fitness/data/Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */