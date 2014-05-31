package com.clinkworks.mechwarrior.api;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.google.inject.BindingAnnotation;

@BindingAnnotation 
@Target({ FIELD, PARAMETER, METHOD, TYPE }) 
@Retention(RUNTIME)
public @interface Smurfy {

}
