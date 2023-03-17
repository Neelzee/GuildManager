package com.fof.nmf.entity.actor;

public enum ActorState {
    NONE(-1),
    STANDING_NORTH(0),
    STANDING_SOUTH(1),
    STANDING_WEST(2),
    STANDING_EAST(3),
    WALKING_SOUTH(4),
    WALKING_NORTH(5),
    WALKING_WEST(6),
    WALKING_EAST(7),
    ATTACKING_SOUTH(8),
    ATTACKING_NORTH(9),
    ATTACKING_EAST(10),
    ATTACKING_WEST(11);

    public final int value;

    ActorState(int value) {
        this.value = value;
    }
}
