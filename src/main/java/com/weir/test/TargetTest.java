package com.weir.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) 
public @interface TargetTest {
	    String hello();   
}
