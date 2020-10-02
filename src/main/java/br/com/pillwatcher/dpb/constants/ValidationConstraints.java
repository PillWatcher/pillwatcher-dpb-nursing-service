package br.com.pillwatcher.dpb.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ValidationConstraints {

    public static final String NURSE_ALREADY_EXISTS = "Nurse with Email {} already exists";

    public static final String NAME_SIZE_MUST_BE_BETWEEN = "Name size must be between {min} and {max} characters long";

    public static final int NAME_MIN_SIZE = 3;
    public static final int NAME_MAX_SIZE = 120;

}
