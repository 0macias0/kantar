package com.kantar.sessionsjob;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HomeHandlerTest
{

    @Test
    void process()
    {
        HomeHandler homeHandler = new HomeHandler(prepareTestData());
        homeHandler.process();
        Assertions.assertEquals(4,homeHandler.getHomeModelsList().size());
        Assertions.assertEquals("1",homeHandler.getHomeModelsList().get(0).getHomeNo());
        Assertions.assertEquals("10",homeHandler.getHomeModelsList().get(0).getChannel());
        Assertions.assertEquals("20200101070000",homeHandler.getHomeModelsList().get(0).getStarttime());
        Assertions.assertEquals(39600, homeHandler.getHomeModelsList().get(0).getDuration());
        Assertions.assertEquals("20200101175959", homeHandler.getHomeModelsList().get(0).getEndTime());
        Assertions.assertEquals(1800,homeHandler.getHomeModelsList().get(1).getDuration());
        Assertions.assertEquals("20200101182959",homeHandler.getHomeModelsList().get(1).getEndTime());
        Assertions.assertEquals(7200,homeHandler.getHomeModelsList().get(2).getDuration());
        Assertions.assertEquals("20200101202959",homeHandler.getHomeModelsList().get(2).getEndTime());
        Assertions.assertEquals(12600, homeHandler.getHomeModelsList().get(3).getDuration());
        Assertions.assertEquals("20200101235959", homeHandler.getHomeModelsList().get(3).getEndTime());
    }
    private List<HomeModel> prepareTestData(){
        List<HomeModel> homeModelList= new ArrayList<>();
        homeModelList.add(new HomeModel("1","10", "20200101070000","Live"));
        homeModelList.add(new HomeModel("1","10", "20200101180000","Live"));
        homeModelList.add(new HomeModel("1","10", "20200101183000","PlayBack"));
        homeModelList.add(new HomeModel("1","10", "20200101203000","PlayBack"));

        return homeModelList;
    }
}
