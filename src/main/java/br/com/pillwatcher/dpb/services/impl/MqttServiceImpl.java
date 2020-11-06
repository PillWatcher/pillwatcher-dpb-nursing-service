package br.com.pillwatcher.dpb.services.impl;

import br.com.pillwatcher.dpb.config.Mqtt;
import br.com.pillwatcher.dpb.entities.MqttPublish;
import br.com.pillwatcher.dpb.exceptions.BaseException;
import br.com.pillwatcher.dpb.services.MqttService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MqttServiceImpl implements MqttService {

    @Override
    public MqttMessage createMqttMessage(final MqttPublish publishModel) {

        log.info("MqttServiceImpl.publishMessage() - Start");
        log.debug("MqttServiceImpl.publishMessage() - Start - {}", publishModel);

        MqttMessage mqttMessage = new MqttMessage(publishModel.getMessage().getBytes());

        mqttMessage.setQos(publishModel.getQos());
        mqttMessage.setRetained(publishModel.getRetained());

        return mqttMessage;
    }

    @Override
    public void setupMqtt(final Object object, final String topic, final BaseException defaultException) {

        MqttPublish mqttPublish = MqttPublish.builder()
                .message(new Gson().toJson(object))
                .qos(0)
                .topic(topic)
                .retained(true)
                .build();

        MqttMessage mqttMessage = createMqttMessage(mqttPublish);

        try {
            Mqtt.getInstance().publish(mqttPublish.getTopic(), mqttMessage);
        } catch (MqttException e) {
            System.out.println(e);
            throw defaultException;
        }
    }
}