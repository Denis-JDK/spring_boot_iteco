package com.iteco.spring_boot_iteco.home_worke;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
public class ExternalInfoProcess implements Process{
    @Value("${id-not-process}")
    private Integer id;
    @Override
    public boolean run(ExternalInfo externalInfo) {
        if (id.equals(externalInfo.getId())){
            log.info("Process not need: {}", externalInfo);
        return false;
        }
        log.info("Process with {}", externalInfo);
        return true;
    }

}