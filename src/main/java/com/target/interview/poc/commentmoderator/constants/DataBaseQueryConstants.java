package com.target.interview.poc.commentmoderator.constants;

public class DataBaseQueryConstants {

    public static String FIND_NOISE = "select " + DataBaseConstats.NOISE_NAME  + " , "
             + DataBaseConstats.NOISE_TYPE  + " from "
             + DataBaseConstats.NOISE_TABLE  + " where " + DataBaseConstats.NOISE_NAME  + " IN(:" + DataBaseConstats.NOISE_NAME  + ")";

    public static String INSERT_NOISE = "insert into " + DataBaseConstats.NOISE_TABLE  + "(" + DataBaseConstats.ID  + ", " + DataBaseConstats.NOISE_NAME
            + "," + DataBaseConstats.NOISE_TYPE  + ") values(:" + DataBaseConstats.ID  + ",:" + DataBaseConstats.NOISE_NAME
            + ",:" + DataBaseConstats.NOISE_TYPE  + ")";

    public static String DELETE_NOISE = "delete from  " + DataBaseConstats.NOISE_TABLE  + " where " + DataBaseConstats.NOISE_NAME
            + "=:" + DataBaseConstats.NOISE_NAME  + "";



    public static void main(String[] args) {
        System.out.println(DELETE_NOISE);
    }
}
