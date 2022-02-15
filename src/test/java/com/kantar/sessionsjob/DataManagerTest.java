package com.kantar.sessionsjob;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

class DataManagerTest
{
    @Test
    void prepare()
    {
        DataManager dataManager = new DataManager();
        Assertions.assertEquals(10, dataManager.prepare(prepareTestData()).size());
    }
    private Collection<List<HomeModel>> prepareTestData(){
        return prepareTestData1().stream().collect(Collectors.groupingBy(HomeModel::getHomeNo, LinkedHashMap::new, Collectors.toList())).values();
    }
    private List<HomeModel> prepareTestData1(){
        List<HomeModel> homeModelList= new ArrayList<>();
        homeModelList.add(new HomeModel("1234","603", "20200101070000","PlayBack"));
        homeModelList.get(0).setEndTime("20200101175959");
        homeModelList.get(0).setDuration(39600);
        homeModelList.add(new HomeModel("1234","101", "20200101180000","Live"));
        homeModelList.get(1).setEndTime("20200101182959");
        homeModelList.get(1).setDuration(1800);
        homeModelList.add(new HomeModel("1234","102", "20200101183000","Live"));
        homeModelList.get(2).setEndTime("20200101202959");
        homeModelList.get(2).setDuration(7200);
        homeModelList.add(new HomeModel("1234","601", "20200101203000","PlayBack"));
        homeModelList.get(3).setEndTime("20200101235959");
        homeModelList.get(3).setDuration(12600);
        homeModelList.add(new HomeModel("45678","621", "20200101060000","PlayBack"));
        homeModelList.get(4).setEndTime("20200101185959");
        homeModelList.get(4).setDuration(46800);
        homeModelList.add(new HomeModel("45678","103", "20200101190000","PlayBack"));
        homeModelList.get(5).setEndTime("20200101192959");
        homeModelList.get(5).setDuration(1800);
        homeModelList.add(new HomeModel("45678","104", "20200101193000","Live"));
        homeModelList.get(6).setEndTime("20200101205959");
        homeModelList.get(6).setDuration(5400);
        homeModelList.add(new HomeModel("45678","104", "20200101210000","PlayBack"));
        homeModelList.get(7).setEndTime("20200101235959");
        homeModelList.get(7).setDuration(10800);
        homeModelList.add(new HomeModel("777","602", "20200101200000","Live"));
        homeModelList.get(8).setEndTime("20200101235959");
        homeModelList.get(8).setDuration(14400);
        homeModelList.add(new HomeModel("900","621", "20200102060000","PlayBack"));
        homeModelList.get(9).setEndTime("20200102235959");
        homeModelList.get(9).setDuration(64800);

        return homeModelList;
    }
}