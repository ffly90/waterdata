package web;

import org.eclipse.paho.client.mqttv3.*;
import org.json.JSONObject;

import java.util.Base64;

public class Mqttreceiver implements MqttCallback {

    MqttConnectOptions options = new MqttConnectOptions();
    MqttClient client;

    public Mqttreceiver() {
    }

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
        String decodemess = new JSONObject(message.toString()).getString("payload_raw");
        byte[] decoded = Base64.getMimeDecoder().decode(decodemess);
        String output = new String(decoded);
        System.out.println(output);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // TODO Auto-generated method stub

    }

}
