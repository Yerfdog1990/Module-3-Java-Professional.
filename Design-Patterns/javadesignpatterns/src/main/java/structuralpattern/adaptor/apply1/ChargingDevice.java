package structuralpattern.adaptor.apply1;

public class ChargingDevice implements Charger{
    @Override
    public void charge(String roundPot, String squarePot, String origin) {
        if(origin.equalsIgnoreCase("France")){
            FranceCharger franceCharger = new Burundi();
            franceCharger.fromFrance(roundPot);
        }else if(origin.equalsIgnoreCase("UK")){
            UKCharger ukCharger = new Kenya();
            ukCharger.fromUK(squarePot);
        }else{
            System.out.println(origin + " is not supported by this device.");
        }
    }
}
