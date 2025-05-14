package structuralpattern.adaptor.apply1;

public class ChargeAdapter implements Charger {
  FranceCharger franceCharger;
  UKCharger ukCharger;

  public ChargeAdapter(String chargingPot) {
    if(chargingPot.equalsIgnoreCase("Square")){
        ukCharger = new Kenya();
    }else if(chargingPot.equalsIgnoreCase("Round")){
        franceCharger = new Burundi();
    }
  }

  @Override
  public void charge(String roundPot, String squarePot, String origin) {
    if(origin.equalsIgnoreCase("France")){
      FranceCharger franceCharger = new Burundi();
      franceCharger.fromFrance(roundPot);
    }else if(origin.equalsIgnoreCase("UK")){
      UKCharger ukCharger = new Kenya();
      ukCharger.fromUK(squarePot);
    }
  }
}
