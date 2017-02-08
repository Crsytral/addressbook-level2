package seedu.addressbook.data.person;

/**
 * An interface for Phone, Name, Email and Address class in the addressbook 
 * so that each class produces a printable string representation of the object.
 */
public interface Printable {
    public String getPrintableString();
}
