package com.pows;

import com.pows.service.PowsPropertiesStoreService;
import com.pows.service.PowsTargetSystemService;
import com.pows.service.PowsUserService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

//Defines the base URI for all resource URIs.
@ApplicationPath("/api")
//The java class declares root resource and provider classes
public class MyApplication extends Application {
    //The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> h = new HashSet<>();
        h.add(PowsUserService.class);
        h.add(PowsTargetSystemService.class);
        h.add(PowsPropertiesStoreService.class);
        return h;
    }
}