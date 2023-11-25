package com.iteco.spring_boot_iteco.home_worke;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class ExternalServiceImpl implements ExternalService {

    private final Map<Integer, ExternalInfo> mapExternalInfo = new HashMap<>();
    @Value("${id-not-process}")
    private Integer id;


    public ExternalServiceImpl(){

    }
    @CacheResult
    public ExternalInfo getExternalInfo(Integer id){
        return mapExternalInfo.get(id);
    };

    @PostConstruct
    public void init(){
        mapExternalInfo.put(1, new ExternalInfo(1,null));
        mapExternalInfo.put(2, new ExternalInfo(2,"hasInfo"));
        mapExternalInfo.put(3, new ExternalInfo(3,"info"));
        mapExternalInfo.put(4, new ExternalInfo(4,"information"));
    }

    public void destroy(){
        log.info("Map before: {}", mapExternalInfo);
        mapExternalInfo.clear();
        log.info("Map after: {}", mapExternalInfo);
    }
}
