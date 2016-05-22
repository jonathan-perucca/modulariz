package com.github.jperucca.web.controller;

import java.util.function.Function;

public interface DTOAdapter<T, R> extends Function<T, R> {}