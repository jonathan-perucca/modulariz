package com.github.jperucca.component.account.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter @Getter @Builder
public class Account {
    private UUID uuid;
    private String name;
}
