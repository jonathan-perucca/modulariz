package com.github.jperucca.component.account.model;

import lombok.*;

import java.util.UUID;

@Setter @Getter @Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private UUID uuid;
    private String name;
}
