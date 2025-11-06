package com.exam.sales.util.enums;

import java.util.stream.Stream;

public enum UserRoleEnum {
    ADMIN("admin"),
    USER("user");

   private final String dbValue;

   UserRoleEnum(String dbValue) {
       this.dbValue = dbValue;
   }
   public String getDbValue() {
       return dbValue;
   }

   public static UserRoleEnum fromDbValue(String dbValue) {
       if(dbValue == null) {
           return USER;
       }
       return Stream.of(UserRoleEnum.values())
               .filter(role -> role.dbValue.equalsIgnoreCase(dbValue))
               .findFirst()
               .orElseThrow(() -> new IllegalArgumentException("Giá trị Role không hợp lệ từ CSDL: " + dbValue));
   }
}
