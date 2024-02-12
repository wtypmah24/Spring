package pojo;

public class CertificateReceiver {
    public CertificateReceiver() {
        for (int i = 0; i < 30; i++) {
            System.out.println("Получение сертификата: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
