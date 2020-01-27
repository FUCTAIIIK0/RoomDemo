package ru.skillbranch.roomdemo.messagess;

import com.lampa.republish.RepublisherException;

import base.TextMessageObject;
import base.VoiceMessageObject;
import device.ResponseAlertObject;
import device.ResponseDeviceApk;
import device.ResponseDeviceFile;
import device.ResponseDeviceFilePart;
import device.ResponseEventsObject;
import device.ResponseLocationObject;
import device.ResponseLogFileObject;
import device.ResponseLogListObject;
import device.ResponseMediaFile;
import device.ResponsePageObject;
import device.ResponseSettingsObject;
import device.ResponseStatsBatteryObject;
import device.ResponseStatsSpeedDistanceObject;
import device.ResponseSystemInfoObject;
import device.ResponseTaskObject;
import device.ResponseTelemetryObject;
import lombok.extern.slf4j.Slf4j;
import ru.skillbranch.roomdemo.messagess.Interfaces.AbstractMessage;
import teminal.ResponseDataInfoObject;

/**
 * Сообщения, которые отправляет Agent Android Bodycam
 */
@Slf4j
public class DeviceMessages extends AbstractMessage {
    /**
     * Отправляет сообщение Alert в Core
     *
     * @param alertObject
     */
    public void sendAlert(ResponseAlertObject alertObject) throws RepublisherException {
        send(alertObject);
    }

    /**
     * Отправляет результат удаленной установки приложения в Core
     *
     * @param deviceApk
     */
    public void sendDeviceApkResponse(ResponseDeviceApk deviceApk) throws RepublisherException {
        send(deviceApk);
    }

    /**
     * Отправляет файл в Terminal
     *
     * @param deviceFile
     */
    public void sendDeviceFile(ResponseDeviceFile deviceFile) throws RepublisherException {
        send(deviceFile);
    }

    /**
     * Отправляет часть файла в Terminal
     *
     * @param deviceFilePart
     */
    public void sendDeviceFilePart(ResponseDeviceFilePart deviceFilePart) throws RepublisherException {
        send(deviceFilePart);
    }

    /**
     * Отправляет сообщение о событии устройства в Core
     *
     * @param eventsObject
     */
    public void sendEvents(ResponseEventsObject eventsObject) throws RepublisherException {
        send(eventsObject);
    }

    /**
     * Отправляет сообщение Location в Core
     *
     * @param locationObject
     */
    public void sendLocation(ResponseLocationObject locationObject) throws RepublisherException {
        send(locationObject);
    }

    /**
     * Отправляет сообщение с лог-файлом в Core/Terminal
     *
     * @param logFileObject
     */
    public void sendLogFile(ResponseLogFileObject logFileObject) throws RepublisherException {
        send(logFileObject);
    }

    /**
     * Отправляет сообщение со списком логов в Core/Terminal
     *
     * @param logListObject
     */
    public void sendLogList(ResponseLogListObject logListObject) throws RepublisherException {
        send(logListObject);
    }

    /**
     * @param mediaFile
     */
    public void sendMediaFile(ResponseMediaFile mediaFile) throws RepublisherException {
        send(mediaFile);
    }

    /**
     * @param pageObject
     */
    public void sendPage(ResponsePageObject pageObject) throws RepublisherException {
        send(pageObject);
    }

    /**
     * Отправляет сообщение Agent Settings в Core/Terminal
     *
     * @param settingsObject
     */
    public void sendSettings(ResponseSettingsObject settingsObject) throws RepublisherException {
        send(settingsObject);
    }

    /**
     * Отправляет сообщение со статистикой по батарее в Core
     *
     * @param statsBatteryObject
     */
    public void sendStatsBattery(ResponseStatsBatteryObject statsBatteryObject) throws RepublisherException {
        send(statsBatteryObject);
    }

    /**
     * Отправляет сообщение со статистикой по скорости/дистанции в Core
     *
     * @param statsSpeedDistanceObject
     */
    public void sendStatsSpeedDistance(ResponseStatsSpeedDistanceObject statsSpeedDistanceObject) throws RepublisherException {
        send(statsSpeedDistanceObject);
    }

    /**
     * Отправляет сообщение SYSINFO в Core/Terminal
     *
     * @param systemInfoObject
     */
    public void sendSystemInfo(ResponseSystemInfoObject systemInfoObject) throws RepublisherException {
        send(systemInfoObject);
    }

    /**
     * Отправляет сообщение с результатом выполнения поставленной задачи в Core
     *
     * @param taskObject
     */
    public void sendTaskResponse(ResponseTaskObject taskObject) throws RepublisherException {
        send(taskObject);
    }

    /**
     * Отправляет сообщение с телеметрией в Core
     *
     * @param responseTelemetryObject
     */
    public void sendTelemetry(ResponseTelemetryObject responseTelemetryObject) throws RepublisherException {
        send(responseTelemetryObject);
    }

    /**
     * Отправляет Текстовые сообщения в Core
     *
     * @param textMessageObject
     */
    public void sendTextMessage(TextMessageObject textMessageObject) throws RepublisherException {
        send(textMessageObject);
    }

    /**
     * Отправляет Голосовые сообщения (PTT) в Core
     *
     * @param voiceMessageObject
     */
    public void sendVoiceMessage(VoiceMessageObject voiceMessageObject) throws RepublisherException {
        send(voiceMessageObject);
    }

    /**
     * Отправляет сообщение DATAINFO в Terminal
     *
     * @param responseDataInfoObject
     */
    public void sendDataInfo(ResponseDataInfoObject responseDataInfoObject) throws RepublisherException {
        send(responseDataInfoObject);
    }

}
