package com.test.ssl.server.binding;

import com.test.ssl.server.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v2/merchant")
public class SSLController {

    Logger logger = LoggerFactory.getLogger(SSLController.class);

    @PostMapping("/add")
    public String addMerchant(@RequestBody String request){
        logger.info("addMerchant request received: {}",request);
        return "SUCCESS";
    }

    @GetMapping("/get")
    public String getMerchant(@RequestParam(required = true, name = "merchantId") String merchantId){
        logger.info("getMerchant request received: {}",merchantId);

        if(merchantId.trim().length()<10)
            throw new BusinessException("Invalid merchantId: "+merchantId);

        return "SUCCESS";
    }

}
