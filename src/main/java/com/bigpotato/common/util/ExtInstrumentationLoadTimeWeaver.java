package com.bigpotato.common.util;

import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;

import java.lang.instrument.ClassFileTransformer;

/**
 * Created by hjy on 18/1/8.
 */
public class ExtInstrumentationLoadTimeWeaver extends InstrumentationLoadTimeWeaver {
    @Override
    public void addTransformer(ClassFileTransformer transformer) {
        try {
            super.addTransformer(transformer);
        } catch (Exception e) {

        }
    }
}
