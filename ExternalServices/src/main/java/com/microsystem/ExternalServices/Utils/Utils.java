package com.microsystem.ExternalServices.Utils;

import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Map;
import java.time.temporal.ChronoUnit;

import com.github.wnameless.json.flattener.JsonFlattener;
import com.microsystem.ExternalServices.Model.Weather;

import org.apache.tomcat.jni.Local;
import org.json.JSONObject;

public class Utils {
    public static Weather convertJsontoWeather(String APIresponse, String checkInDate){

        LocalDate currentDate = LocalDate.now();
        LocalDate date = LocalDate.parse(checkInDate);
        long diff = Math.abs(ChronoUnit.DAYS.between(currentDate, date));        

        Weather weather = new Weather();

        JSONObject jsonObject = new JSONObject((String)APIresponse) ;
        Map<String, Object> jsonMap = JsonFlattener.flattenAsMap(jsonObject.toString());

        // Keys
        String dateKey = "forecast.forecastday["+ diff +"].date";
        String maxTempKey = "forecast.forecastday["+ diff +"].day.maxtemp_c";
        String minTempKey = "forecast.forecastday["+ diff +"].day.mintemp_c";
        String avgTempKey = "forecast.forecastday["+ diff +"].day.avgtemp_c";
        String conditionKey = "forecast.forecastday["+ diff +"].day.condition.text";

        try {
            Date parsed = parseDate(jsonMap.get(dateKey).toString());
            weather.setDate(parsed);
            weather.setMaxTemp(Double.parseDouble(jsonMap.get(maxTempKey).toString()));
            weather.setMinTemp(Double.parseDouble(jsonMap.get(minTempKey).toString()));
            weather.setAvgTemp(Double.parseDouble(jsonMap.get(avgTempKey).toString()));
            weather.setCondition(jsonMap.get(conditionKey).toString());
        } catch (Exception e) {
            throw new InvalidParameterException();
        }
        

        return weather;
    }

    public static Date parseDate(String date){
        Date parsed;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            parsed = sdf.parse(date);
        }
        catch(ParseException pe) {
            throw new IllegalArgumentException(pe);
        }
        return parsed;
    }
}
