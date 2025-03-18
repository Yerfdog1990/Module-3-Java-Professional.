package structural.pattern.adaptor.apply1;

public class Client {
   public static void main(String[] args){
       ChargingDevice chargingDevice = new ChargingDevice();
       chargingDevice.charge("round hole", "square holes", "UK");
       chargingDevice.charge("round hole", "square holes", "France");
   }
}
