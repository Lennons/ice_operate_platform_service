package com.shikonghulian.logicalhat;

import java.lang.annotation.*;

/**
 * Created by Lennon on 17/4/13.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface Param {
    String value();
}

