package com.github.jperucca.component.exchange.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Setter @Getter @Builder @ToString
public class Exchange {

    private UUID uuid;
    private State state;
    private UUID owner;
    private UUID receiver;

    public boolean pushState() {
        switch (state) {
            case PENDING: {
                this.state = State.IN_PROGRESS;
                return true;
            }
            case IN_PROGRESS: {
                this.state = State.COMPLETE;
                return true;
            }
            case COMPLETE:
            default:
                return false;
        }
    }
}
