package org.redischool.fall2018project.usecases.foundationpicker;

public class FoundationPickerService {
    Foundation tellMeTheRightFoundationForMySkinType(TypeOfSkin typeOfSkin) {

        if (TypeOfSkin.Light == typeOfSkin) {
            return Foundation.Light;
        } else if (TypeOfSkin.Dark == typeOfSkin) {
            return Foundation.Dark;
        } else  {
            return Foundation.Medium;
        }

    }
}
