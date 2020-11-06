package br.com.pillwatcher.dpb.entities;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class MqttPublish {

    @NotNull
    @Size(min = 1,max = 255)
    private String topic;

    @NotNull
    @Size(min = 1,max = 255)
    private String message;

    @NotNull
    private Boolean retained;

    @NotNull
    private Integer qos;

}