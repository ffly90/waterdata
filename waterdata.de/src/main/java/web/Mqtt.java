package web;

import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;



public class Mqtt implements MqttCallback{
    MqttClient=new
    MqttClient("tcp://eu.thethings.network")
    MqttClient.
    public String connectionLost(Throwable throwable){
        return "error";
    }
    public String messageReceived(String s, MqttMessage mqttMessage) throws Exception {
        return new String(mqttMessage.getPayload());
    }
}