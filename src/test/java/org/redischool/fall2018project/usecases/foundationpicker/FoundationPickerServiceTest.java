package org.redischool.fall2018project.usecases.foundationpicker;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FoundationPickerServiceTest {
    private final FoundationPickerService subject = new FoundationPickerService();


    // @Test
    void exceptionNoSkinType() {
        // subject.tellMeTheRightFoundationForMySkinType(TypeOfSkin);


    }

    @Test
    void lightFoundationForLightSkin() {

        Foundation actualFoundation = subject.tellMeTheRightFoundationForMySkinType(TypeOfSkin.Light);
        Foundation expectedFoundation = Foundation.Light;
        assertEquals(expectedFoundation, actualFoundation);

    }

    @Test
    void darkFoundationForDarkSkin() {
        Foundation actualFoundation = subject.tellMeTheRightFoundationForMySkinType(TypeOfSkin.Dark);
        Foundation expectedFoundation = Foundation.Dark;
        assertEquals(expectedFoundation, actualFoundation);

    }

    @Test
    void mediumFoundationForMediumSkin() {
        Foundation actualFoundation = subject.tellMeTheRightFoundationForMySkinType(TypeOfSkin.Medium);
        Foundation expectedFoundation = Foundation.Medium;
        assertEquals(expectedFoundation, actualFoundation);
    }
}

