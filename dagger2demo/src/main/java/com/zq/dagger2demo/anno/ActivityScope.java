package com.zq.dagger2demo.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by zhangqi on 2019/8/12
 */

@Scope
@Documented
@Retention(RUNTIME)
public @interface ActivityScope {
}
