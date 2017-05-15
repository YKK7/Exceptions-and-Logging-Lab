package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import static com.zipcodewilmington.tools.RandomNumberFactory.createInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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
     */
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        PhoneNumber[] result = new PhoneNumber[phoneNumberCount];
        for (int i = 0; i < phoneNumberCount; i++)
            result[i] = createRandomPhoneNumber();
        return result;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */
    private static PhoneNumber createRandomPhoneNumber() {
        return createPhoneNumberSafely(createInteger(100, 999), createInteger(100, 999), createInteger(1000, 9999));
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
            logger.warn(phoneNumberString + " is not a valid phone number");
            return null;
        }
    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {
        logger.info("Attempting to create a new PhoneNumber object with a value of " + phoneNumberString);
        return new PhoneNumber(phoneNumberString);
    }
}