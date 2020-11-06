package br.com.pillwatcher.dpb.config;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

import static java.util.Objects.isNull;

public class Mqtt {

    private static final String MQTT_PUBLISHER_ID = "spring-server";
    private static final String MQTT_SERVER_ADDRESS = "tcp://192.99.25.198:1883";

    private static IMqttClient instance;

    public static IMqttClient getInstance() {
        try {
            if (isNull(instance)) {
                instance = new MqttClient(MQTT_SERVER_ADDRESS, MQTT_PUBLISHER_ID);
            }

            MqttConnectOptions options = new MqttConnectOptions();

            options.setAutomaticReconnect(true);
            options.setCleanSession(true);
            options.setConnectionTimeout(10);

            if (!instance.isConnected()) {
                instance.connect(options);
            }

        } catch (MqttException e) {
            e.printStackTrace();
        }

        return instance;
    }

    private Mqtt(){}

}
