package com.gonzobeans.codesample.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

/**
 * Created by Dave on 1/29/2017.
 */
public interface Logging {
    Logger LOG = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getClass());
}
