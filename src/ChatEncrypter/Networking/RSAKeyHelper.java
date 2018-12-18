package ChatEncrypter.Networking;

import java.net.Socket;
import java.security.PublicKey;

public interface RSAKeyHelper {
    
    public void getPublicKey(Socket receiverSocket);
    public void sendPublicKey(Socket receiverSocket,PublicKey publicKey);
    
}
