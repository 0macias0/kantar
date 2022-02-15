package com.kantar.sessionsjob;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class HomeHandler
{
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
    private final List<HomeModel> homeModelsList;

    public List<HomeModel> getHomeModelsList()
    {
        return homeModelsList;
    }

    public HomeHandler(List<HomeModel> homeModelsList)
    {
        this.homeModelsList = homeModelsList;
    }

    public void process(){
        for (int i=0, n = homeModelsList.size(); i<n; i++){
            HomeModel model = homeModelsList.get(i);
            long duration;
            LocalDateTime startDateTime = setDate(model.getStarttime());
            if (i + 1 != n){
                HomeModel model2 = homeModelsList.get(i+1);
                duration = calculateDuration(startDateTime,setDate(model2.getStarttime()));
            }
            else{
                duration = calculateDuration(startDateTime,startDateTime.plusDays(1));
            }
            model.setDuration(duration);
            model.setEndTime(calculateEndTime(setDate(model.getStarttime()), duration));
        }
    }
    private long calculateDuration(LocalDateTime x, LocalDateTime y)
    {
           if(ChronoUnit.DAYS.between(x,y) != 0){
               y = x.toLocalDate().atTime(LocalTime.MAX).plusSeconds(1);
           }
           return Duration.between(x,y).getSeconds();
    }
    private String calculateEndTime(LocalDateTime x, long duration){
        x = x.plusSeconds(duration).minusSeconds(1);
        return x.format(formatter);
    }
    private LocalDateTime setDate(String dateString){
        return  LocalDateTime.parse(dateString, formatter);
    }

}
