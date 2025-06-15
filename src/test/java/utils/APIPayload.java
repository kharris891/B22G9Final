package utils;

import org.json.JSONObject;

public class APIPayload {

    public static String createEmployeePayload(){
        String createdEmployee="{\n" +
                "  \"emp_firstname\": \"Shawn\",\n" +
                "  \"emp_lastname\": \"Beverly\",\n" +
                "  \"emp_middle_name\": \"S.\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"1990-03-09\",\n" +
                "   \"emp_status\": \"active\",\n" +
                "  \"emp_job_title\": \"Lead\"\n" +
                "}";
        return createdEmployee;
    }

    public static String createEmployeePayloadJson(){

        JSONObject obj = new JSONObject();
        obj.put("emp_firstname","Steve");
        obj.put("emp_lastname","John");
        obj.put("emp_middle_name","kenedy");
        obj.put("emp_gender","M");
        obj.put("emp_birthday","1976-06-16");
        obj.put("emp_status","permanent");
        obj.put("emp_job_title","QA Manager");
        return obj.toString();
    }

    public static String createEmployeePayloadJsonDynamic(String emp_firstname,
                                                          String emp_lastname,
                                                          String emp_middle_name,
                                                          String emp_gender,
                                                          String emp_birthday,
                                                          String emp_status,
                                                          String emp_job_title){
        JSONObject obj = new JSONObject();
        obj.put("emp_firstname",emp_firstname);
        obj.put("emp_lastname",emp_lastname);
        obj.put("emp_middle_name",emp_middle_name);
        obj.put("emp_gender",emp_gender);
        obj.put("emp_birthday",emp_birthday);
        obj.put("emp_status",emp_status);
        obj.put("emp_job_title",emp_job_title);
        return obj.toString();
    }


}
