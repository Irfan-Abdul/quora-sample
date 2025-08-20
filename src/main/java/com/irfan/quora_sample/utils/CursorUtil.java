package com.irfan.quora_sample.utils;


import java.time.LocalDateTime;

public class CursorUtil {

    public static boolean isValidCursor(String cursor){
        if(cursor==null || cursor.isEmpty()){
            return false;
        }
        try{
            LocalDateTime.parse(cursor);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }


    public static LocalDateTime parseCursor(String cursor){
        if(isValidCursor(cursor)){
            return LocalDateTime.parse(cursor);
        }
        else{
            throw new IllegalArgumentException("Invalid cursor");
        }
    }

}
