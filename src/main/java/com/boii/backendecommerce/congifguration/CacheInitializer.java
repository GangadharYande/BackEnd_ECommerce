package com.boii.backendecommerce.congifguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cache.CacheManager;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CacheInitializer {

    private final CacheManager cacheManager;

    @Autowired
    public CacheInitializer(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void clearCachesOnStartup() {
        System.out.println("Clearing caches on startup...");
        cacheManager.getCacheNames().forEach(name -> cacheManager.getCache(name).clear());
    }
}