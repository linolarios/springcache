package com.workshop.cache.processor;

import javax.cache.processor.EntryProcessor;
import javax.cache.processor.EntryProcessorException;
import javax.cache.processor.MutableEntry;

public class CustomEntryProcessor implements EntryProcessor {
    @Override
    public Object process(MutableEntry mutableEntry, Object... objects) throws EntryProcessorException {
        String oldValue = (String) mutableEntry.getValue();
        mutableEntry.setValue((String)objects[0]);
              return oldValue;
    }
}
