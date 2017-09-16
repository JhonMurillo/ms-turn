package com.app.turn.websocket;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;

@Component
public class SocketHandler extends TextWebSocketHandler {

    public List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    private static final Logger LOG = LoggerFactory.getLogger(SocketHandler.class);

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message)
            throws InterruptedException, IOException {
        Map<String, String> value = new Gson().fromJson(message.getPayload(), Map.class);
        Long id = (Long) session.getAttributes().get("id");
        session.sendMessage(new TextMessage("Hello"));
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String id =  session.getUri().getQuery();
        System.out.println(id);
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws IOException {
        sessions.remove(session);
    }
    
     private static class ChatConnection {

        private final String connectionId;

        private final String token;


        private ChatConnection(String connectionId, String token) {
            this.connectionId = connectionId;
            this.token = token;
        }

//        @Override
//        protected void onOpen(WsOutbound outbound) {
//            sendConnectionInfo(outbound);
//            sendStatusInfoToOtherUsers(new StatusInfoMessage(userName, StatusInfoMessage.STATUS.CONNECTED));
//            connections.put(connectionId, this);
//        }
//
//        @Override
//        protected void onClose(int status) {
//            sendStatusInfoToOtherUsers(new StatusInfoMessage(userName, StatusInfoMessage.STATUS.DISCONNECTED));
//            connections.remove(connectionId);
//        }
//
//        @Override
//        protected void onBinaryMessage(ByteBuffer byteBuffer) throws IOException {
//            throw new UnsupportedOperationException("Binary messages not supported");
//        }
//
//        @Override
//        protected void onTextMessage(CharBuffer charBuffer) throws IOException {
//            final MessageInfoMessage message = jsonProcessor.fromJson(charBuffer.toString(), MessageInfoMessage.class);
//            final ChatConnection destinationConnection = getDestinationUserConnection(message.getMessageInfo().getTo());
//            if (destinationConnection != null) {
//                final CharBuffer jsonMessage = CharBuffer.wrap(jsonProcessor.toJson(message));
//                destinationConnection.getWsOutbound().writeTextMessage(jsonMessage);
//            } else {
//                log.warn("Se está intentando enviar un mensaje a un usuario no conectado");
//            }
//        }

        public String getUserName() {
            return token;
        }

//        private void sendConnectionInfo(WsOutbound outbound) {
//            final List<String> activeUsers = getActiveUsers();
//            final ConnectionInfoMessage connectionInfoMessage = new ConnectionInfoMessage(userName, activeUsers);
//            try {
//                outbound.writeTextMessage(CharBuffer.wrap(jsonProcessor.toJson(connectionInfoMessage)));
//            } catch (IOException e) {
//                log.error("No se pudo enviar el mensaje", e);
//            }
//        }
//
//        private List<String> getActiveUsers() {
//            final List<String> activeUsers = new ArrayList<String>();
//            for (ChatConnection connection : connections.values()) {
//                activeUsers.add(connection.getUserName());
//            }
//            return activeUsers;
//        }
//
//        private void sendStatusInfoToOtherUsers(StatusInfoMessage message) {
//            final Collection<ChatConnection> otherUsersConnections = getAllChatConnectionsExceptThis();
//            for (ChatConnection connection : otherUsersConnections) {
//                try {
//                    connection.getWsOutbound().writeTextMessage(CharBuffer.wrap(jsonProcessor.toJson(message)));
//                } catch (IOException e) {
//                    log.error("No se pudo enviar el mensaje", e);
//                }
//            }
//        }
//
//        private Collection<ChatConnection> getAllChatConnectionsExceptThis() {
//            final Collection<ChatConnection> allConnections = connections.values();
//            allConnections.remove(this);
//            return allConnections;
//        }
//
//        private ChatConnection getDestinationUserConnection(String destinationUser) {
//            for (ChatConnection connection : connections.values()) {
//                if (destinationUser.equals(connection.getUserName())) {
//                    return connection;
//                }
//            }
//            return null;
//        }

    }
}
