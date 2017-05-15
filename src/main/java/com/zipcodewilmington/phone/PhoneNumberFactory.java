package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.zipcodewilmington.tools.RandomNumberFactory.*;

/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = LoggerFactory.getLogger(PhoneNumberFactory.class);

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        return null;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    private static PhoneNumber createRandomPhoneNumber() {
        int areaCode = createInteger(0, 9) * 100 + createInteger(0, 9) * 10 + createInteger(0, 9);
        int centralOfficeCode = createInteger(0, 9) * 100 + createInteger(0, 9) * 10 + createInteger(0, 9);
        int phoneLineCode = createInteger(0, 9) * 1000 + createInteger(0, 9) * 100 + createInteger(0, 9) * 10 + createInteger(0, 9);
        return createPhoneNumberSafely(areaCode, centralOfficeCode, phoneLineCode);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        String phoneNumberString = "(" + areaCode + ")-" + centralOfficeCode + "-" + phoneLineCode;
        try {
            return createPhoneNumber(phoneNumberString);
        } catch (InvalidPhoneNumberFormatException e) {
            return null;
        }
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        return new PhoneNumber(phoneNumberString);
    }
}