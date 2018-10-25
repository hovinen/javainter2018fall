package org.redischool.fall2018project.usecases.foundationpicker;

public class FoundationPickerService {
    Foundation tellMeTheRightFoundationForMySkinType(TypeOfSkin typeOfSkin, SkinConsistency skinConsistency) {

        if (TypeOfSkin.Light == typeOfSkin) {
            if (SkinConsistency.DRY == skinConsistency) {
                return Foundation.LightDry;
            } else if (SkinConsistency.OILY == skinConsistency) {
                return Foundation.LightOily;
            } else {
                return Foundation.LightNormal;
            }
        } else if (TypeOfSkin.Dark == typeOfSkin) {
            if (SkinConsistency.DRY == skinConsistency) {

            return Foundation.DarkDry;
        } else if (SkinConsistency.OILY == skinConsistency) {
            return Foundation.DarkOily;
        } else {
            return Foundation.DarkNormal;
        }

    } else

    {
        if (SkinConsistency.DRY == skinConsistency) {

        return Foundation.MediumDry;
    } else if(SkinConsistency.OILY ==skinConsistency)

    {
        return Foundation.MediumOily;
    } else

    {
        return Foundation.MediumNormal;
    }

}

    }
            }
