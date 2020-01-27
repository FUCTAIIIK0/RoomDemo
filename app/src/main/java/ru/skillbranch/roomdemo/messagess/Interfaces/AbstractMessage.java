package ru.skillbranch.roomdemo.messagess.Interfaces;

import com.lampa.republish.RepublisherException;
import com.lampa.republish.core.Republish;
import com.lampa.republish.messages.Message;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractMessage {
    private Republish republish;
    private IHandler iHandler;

    public void send(Object object) throws RepublisherException {
        if (iHandler != null) {
            republish.publish(new Message(object), aBoolean -> {
                //log.info("is message delivered? " + aBoolean);

                if (!aBoolean) {
                    iHandler.handlePublishException(object);
                }
            });
        } else {
            republish.publish(new Message(object));
        }

    }

    public Republish getRepublish() {
        return republish;
    }

    public void setRepublish(Republish republish) {
        this.republish = republish;
    }

    public ru.skillbranch.roomdemo.messagess.Interfaces.IHandler getiHandler() {
        return iHandler;
    }

    public void setiHandler(ru.skillbranch.roomdemo.messagess.Interfaces.IHandler iHandler) {
        this.iHandler = iHandler;
    }
}
