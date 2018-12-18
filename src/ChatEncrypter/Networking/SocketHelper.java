package ChatEncrypter.Networking;

import java.net.Socket;
import java.security.PublicKey;

public interface SocketHelper {

    public void setClientSocket(Socket socket);
    public PublicKey getReceiverPublicKey();
}
