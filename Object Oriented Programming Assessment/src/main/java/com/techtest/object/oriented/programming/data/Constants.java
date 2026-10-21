package com.techtest.object.oriented.programming.data;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constants {

  public static final String SPACE = " ";
  public static final String ARCHITECT = "Architect";
  public static final String SOFTWARE = "Software";
  public static final String ENGINEER = "Engineer";
  public static final String SOFTWARE_ENGINEER = SOFTWARE + SPACE + ENGINEER;
  public static final String QUANTITY = "Quantity";
  public static final String SURVEYOR = "Surveyor";
  public static final String QUANTITY_SURVEYOR = QUANTITY + SPACE + SURVEYOR;
  public static final String ACCOUNTANT = "Accountant";

  public static final double HIGH = 1;
  public static final double LOW = 0.4;
}
