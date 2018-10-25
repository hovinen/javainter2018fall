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

        Foundation actualFoundation = subject.tellMeTheRightFoundationForMySkinType(TypeOfSkin.Light, SkinConsistency.DRY);
        Foundation expectedFoundation = Foundation.LightDry;
        assertEquals(expectedFoundation, actualFoundation);

    }

    @Test
    void darkFoundationForDarkSkin() {
        Foundation actualFoundation = subject.tellMeTheRightFoundationForMySkinType(TypeOfSkin.Dark, SkinConsistency.DRY);
        Foundation expectedFoundation = Foundation.DarkDry;
        assertEquals(expectedFoundation, actualFoundation);

    }

    @Test
    void mediumFoundationForMediumSkin() {
        Foundation actualFoundation = subject.tellMeTheRightFoundationForMySkinType(TypeOfSkin.Medium, SkinConsistency.DRY);
        Foundation expectedFoundation = Foundation.MediumDry;
        assertEquals(expectedFoundation, actualFoundation);
    }
   // @Test
    // void oilyFoundationForOilySkin(){
     //   Foundation actualyFoundation = subject.tellMeTheRightFoundationForMySkinType(SkinConsistency.OILY)
   // }
}

