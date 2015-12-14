package models;

public class Partners {

    private static Partner dentist = new Partner(Title.DR, "Jason", "Bourne", PartnerType.DENTIST);
    private static Partner hygienist = new Partner(Title.DR, "Charlotte", "Webb", PartnerType.HYGIENIST);

    public static Partner getPartnerFromType(PartnerType type){

        if(type == PartnerType.DENTIST){
            return dentist;
        }else{
            return hygienist;
        }

    }

}
