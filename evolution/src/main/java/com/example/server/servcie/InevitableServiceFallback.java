package com.example.server.servcie;


import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class InevitableServiceFallback implements InevitableService {
    private static final Logger LOG = Logger.getLogger(InevitableServiceFallback.class);


    @Override
    public void inevitable() {
        LOG.error("can't access Inevitable");
    }
}
