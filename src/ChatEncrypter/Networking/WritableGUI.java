package ChatEncrypter.Networking;

public interface WritableGUI {

    public void write(String s);

    public void clear();

    public void connectClient(String ip, int port);

    public void disconnectClient();

    public void showHostInfo(String hostIp, int hostPort);

    public void showClientInfo(String clientIp, int clientPort);
}
