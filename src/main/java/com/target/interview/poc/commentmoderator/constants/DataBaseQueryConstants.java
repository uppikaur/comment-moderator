package com.target.interview.poc.commentmoderator.constants;

public class DataBaseQueryConstants {

    public static String FIND_NOISE = "select " + DataBaseConstats.NOISE_NAME  + " , "
             + DataBaseConstats.NOISE_TYPE  + " from "
             + DataBaseConstats.NOISE_TABLE  + " where " + DataBaseConstats.NOISE_NAME  + " IN(:" + DataBaseConstats.NOISE_NAME  + ")";

    public static void main(String[] args) {
        System.out.println(FIND_NOISE);
    }
}
