package com.weir.manage;

import java.util.Locale;

import org.springframework.context.support.ResourceBundleMessageSource;

public class Messages extends ResourceBundleMessageSource {
    public String getMessage(String key, Object... arguments) {
        return super.getMessage(key, arguments, Locale.getDefault());
    }
}
