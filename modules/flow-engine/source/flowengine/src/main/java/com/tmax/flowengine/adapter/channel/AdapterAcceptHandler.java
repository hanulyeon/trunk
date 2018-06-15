package com.tmax.flowengine.adapter.channel;

import java.nio.channels.SelectionKey;
import java.nio.channels.spi.AbstractSelectableChannel;

import com.tmax.proobject.logger.application.ChannelEventLogger;
import com.tmax.proobject.network.eventhandler.socket.SocketChannelAcceptHandler;
import com.tmax.proobject.network.manager.ChannelManager;

public class AdapterAcceptHandler extends SocketChannelAcceptHandler {
    @Override
    public void onAccept(AbstractSelectableChannel serverChannel, AbstractSelectableChannel clientChannel) {
        AdapterChannelEventHandler  handler = new AdapterChannelEventHandler();
        handler.setChannel(clientChannel);
        
        try {
            ChannelManager.register(clientChannel, handler, SelectionKey.OP_READ);
        } catch (Throwable e) {
            ChannelEventLogger.getLogger().severe("[AdapterAccepter] Failed to registering adapter channel.", e);
            handler.close();
        }
    }
}
