package org.redischool.fall2018project.usecases.foundationpicker;

import org.redischool.fall2018project.usecases.shoppingcart.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

@RestController
public final class FoundationPickerController {

    private final FoundationPickerService foundationPickerService = new FoundationPickerService();

    @RequestMapping("/foundation")
    public Foundation getFoundation(@RequestParam TypeOfSkin typeOfSkin , @RequestParam SkinConsistency skinConsistency) {

       return  foundationPickerService.tellMeTheRightFoundationForMySkinType(typeOfSkin , skinConsistency);
    }

}