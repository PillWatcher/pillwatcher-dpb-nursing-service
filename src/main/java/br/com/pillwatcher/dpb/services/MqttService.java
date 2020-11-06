package br.com.pillwatcher.dpb.services;

import br.com.pillwatcher.dpb.entities.MqttPublish;
import br.com.pillwatcher.dpb.exceptions.BaseException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public interface MqttService {

    MqttMessage createMqttMessage(MqttPublish publishModel);

    void setupMqtt(Object object, String topic, BaseException defaultException);

}