package web;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class Mqttreceiver implements MqttCallback {

    MqttClient client;

    public Mqttreceiver() {
    }

    public static void main(String[] args) {
        new Mqttreceiver().doDemo();
    }

    public void getMessage() {
        try {
            client = new MqttClient("tcp://eu.thethings.network", "Sending");
            client.connect();
            client.setCallback(this);
            client.subscribe("sus2018_waterdata_mqtt/devices/waterdata_cata1/up");
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void connectionLost(Throwable cause) {
        // TODO Auto-generated method stub

    }

    @Override
    public void messageArrived(String topic, MqttMessage message)
            throws Exception {
        System.out.println(message);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        // TODO Auto-generated method stub

    }

}
