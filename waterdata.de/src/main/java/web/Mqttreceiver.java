package web;

import org.eclipse.paho.client.mqttv3.*;
import org.json.JSONObject;

public class Mqttreceiver implements MqttCallback {

    MqttConnectOptions options = new MqttConnectOptions();
    MqttClient client;

    public Mqttreceiver() {
    }

  /*  public static void main(String[] args) {
        new Mqttreceiver().getMessage();
    }
*/
    public void getMessage() {
        try {
            client = new MqttClient("tcp://eu.thethings.network", "Sending");
            options.setUserName("sus2018_waterdata_mqtt");
            options.setPassword("ttn-account-v2.A1onZwjnWTPBUchbIi65cbdIfkYU4Msvao4wFuUWcRQ".toCharArray());
            client.connect(options);
            client.setCallback(this);
            client.subscribe("sus2018_waterdata_mqtt/devices/waterdata_cata1/up");
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connectionLost(Throwable cause) {
        System.out.println("error: connection lost");
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        JSONObject decodemess = new JSONObject(message.toString());
        System.out.println(decodemess);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // TODO Auto-generated method stub

    }

}
