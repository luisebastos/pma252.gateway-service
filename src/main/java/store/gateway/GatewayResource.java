package store.gateway;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GatewayResource {

    @GetMapping("/health-check")
    public ResponseEntity<Map<String, String>> healthCheck() {
        String ip = "";
        try {
            ip = InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            ip = e.getMessage();
        }
        return ResponseEntity.ok()
            .body(Map.of(
                "osArch", System.getProperty("os.arch"),
                "osName", System.getProperty("os.name"),
                "osVersision", System.getProperty("os.version"),
                "ip", ip
            ));
    }

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok()
            .body("API for Store by In5p3R");
    }
    
}
