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
    void darkFoundationForDarkDrySkin() {
        Foundation actualFoundation = subject.tellMeTheRightFoundationForMySkinType(TypeOfSkin.Dark, SkinConsistency.DRY);
        Foundation expectedFoundation = Foundation.DarkDry;
        assertEquals(expectedFoundation, actualFoundation);

    }

    @Test
    void darkFoundationForDarkOilySkin() {
        Foundation actualFoundation = subject.tellMeTheRightFoundationForMySkinType(TypeOfSkin.Dark, SkinConsistency.OILY);
        Foundation expectedFoundation = Foundation.DarkOily;
        assertEquals(expectedFoundation, actualFoundation);

    }

    @Test
    void darkFoundationForDarkNormalSkin() {
        Foundation actualFoundation = subject.tellMeTheRightFoundationForMySkinType(TypeOfSkin.Dark, SkinConsistency.NORMAL);
        Foundation expectedFoundation = Foundation.DarkNormal;
        assertEquals(expectedFoundation, actualFoundation);

    }

    @Test
    void lightFoundationForLightOilySkin() {
        Foundation actualFoundation = subject.tellMeTheRightFoundationForMySkinType(TypeOfSkin.Light, SkinConsistency.OILY);
        Foundation expectedFoundation = Foundation.LightOily;
        assertEquals(expectedFoundation, actualFoundation);

    }

    @Test
    void lightFoundationForLightNormalSkin() {
        Foundation actualFoundation = subject.tellMeTheRightFoundationForMySkinType(TypeOfSkin.Light, SkinConsistency.NORMAL);
        Foundation expectedFoundation = Foundation.LightNormal;
        assertEquals(expectedFoundation, actualFoundation);
    }

    @Test
    void lightFoundationForLightDrySkin() {
        Foundation actualFoundation = subject.tellMeTheRightFoundationForMySkinType(TypeOfSkin.Light, SkinConsistency.DRY);
        Foundation expectedFoundation = Foundation.LightDry;
        assertEquals(expectedFoundation, actualFoundation);
    }

    @Test
    void mediumFoundationForMediumDrySkin() {
        Foundation actualFoundation = subject.tellMeTheRightFoundationForMySkinType(TypeOfSkin.Medium, SkinConsistency.DRY);
        Foundation expectedFoundation = Foundation.MediumDry;
        assertEquals(expectedFoundation, actualFoundation);
    }

    @Test
    void mediumFoundationForMediumOilySkin() {
        Foundation actualFoundation = subject.tellMeTheRightFoundationForMySkinType(TypeOfSkin.Medium, SkinConsistency.OILY);
        Foundation expectedFoundation = Foundation.MediumOily;
        assertEquals(expectedFoundation, actualFoundation);
    }

    @Test
    void mediumFoundationForMediumNormalSkin() {
        Foundation actualFoundation = subject.tellMeTheRightFoundationForMySkinType(TypeOfSkin.Medium, SkinConsistency.NORMAL);
        Foundation expectedFoundation = Foundation.MediumNormal;
        assertEquals(expectedFoundation, actualFoundation);
    }
    // @Test
    // void oilyFoundationForOilySkin(){
    //   Foundation actualyFoundation = subject.tellMeTheRightFoundationForMySkinType(SkinConsistency.OILY)
    // }
}

