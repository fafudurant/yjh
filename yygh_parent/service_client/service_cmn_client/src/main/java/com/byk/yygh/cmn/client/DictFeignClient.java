package com.byk.yygh.cmn.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author byk
 */
@FeignClient("service-cmn")
@Repository
public interface DictFeignClient {

    //根据dictCode和value查询
    @PostMapping("/admin/cmn/dict/getName/{dictCode}/{value}")
    public String getName(@PathVariable("dictCode") String dictCode, @PathVariable("value") String value);

    //根据value查询
    @PostMapping("/admin/cmn/dict/getName/{value}")
    public String getName(@PathVariable("value") String value);
}
