package com.test.api.intuitive.infrastructure.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface LoggerSlf4j {
    default Logger LOGGER() {
        return LoggerFactory.getLogger(this.getClass());
    }
}
