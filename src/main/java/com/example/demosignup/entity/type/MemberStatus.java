package com.example.demosignup.entity.type;

import lombok.RequiredArgsConstructor;

public enum MemberStatus {
    PENDING(false),
    ACTIVE(true),
    /** Same to BLOCKED */
    SUSPENDED(false),
    PROTECTED(false),
    SLEEP(false),
    REMOVED(false);

    final boolean canSignIn;

    MemberStatus(boolean canSignIn) {
        this.canSignIn = canSignIn;
    }
}

// enum Color { RED, YELLOW, GREEN, BLUE, BLACK, WHITE }
// Color colore = Colore.RED; // 객관식