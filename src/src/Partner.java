public class Partner {

    Name name;
    PartnerType partnerType;

    //other fields?

    public Partner(Name name, PartnerType partnerType) {
        this.name = name;
        this.partnerType = partnerType;
    }
    public Partner(Title title, String firstName, String surname, PartnerType partnerType) {
        this.name = new Name(title, firstName, surname);
        this.partnerType = partnerType;
    }

    public Name getName() { return name; }
    public PartnerType getPartnerType() { return partnerType; }

}
