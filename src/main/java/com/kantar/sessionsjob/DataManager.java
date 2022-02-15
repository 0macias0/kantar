package com.kantar.sessionsjob;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Comparator.comparing;

public class DataManager
{
    public List<HomeModel> prepare(Collection<List<HomeModel>> homeLists){
        for (List<HomeModel> homeModelList: homeLists){
            homeModelList.sort(comparing(HomeModel::getStarttime));
            HomeHandler handler = new HomeHandler(homeModelList);
            handler.process();
        }
        return postprocess(homeLists);
    }
    private List<HomeModel> postprocess(Collection<List<HomeModel>> homeLists){
        return homeLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
