package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be entered in this format: a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = ".+";

    public static final int INDEX_OF_BLOCK = 0;
    public static final int INDEX_OF_STREET = 1;
    public static final int INDEX_OF_UNIT = 2;
    public static final int INDEX_OF_POSTALCODE = 3;
    
    public final String value;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        String[] addressDetails = trimmedAddress.split(", ");
        block = new Block(addressDetails[INDEX_OF_BLOCK]);
        street = new Street (addressDetails[INDEX_OF_STREET]);
        unit = new Unit (addressDetails[INDEX_OF_UNIT]);	
        postalCode = new PostalCode (addressDetails[INDEX_OF_POSTALCODE]);
        this.value = block.getBlock()+", "+street.getStreet()+", "+unit.getUnit()+", "+postalCode.getPostalCode();
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
    
}

/**
 * Represents the Block component of a Person's address in the address book.
 */
class Block{
	private String block;
	
	public Block(String block){
		this.block = block;
	}
	
	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}
}

/**
 * Represents the Street component of a Person's address in the address book.
 */
class Street{
	private String street;
	
	public Street(String street){
		this.street = street;
	}
	
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}
}

/**
 * Represents the Unit component of a Person's address in the address book.
 */
class Unit{
	private String unit;
	
	public Unit(String unit){
		this.unit = unit;
	}
	
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
}

/**
 * Represents the Postal Code component of a Person's address in the address book.
 */
class PostalCode{
	private String postalCode;
	
	public PostalCode(String postalCode){
		this.postalCode = postalCode;
	}
	
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
