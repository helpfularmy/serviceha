package army.helpful.app.it.config;

import org.mockserver.client.server.MockServerClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;



@Configuration
public class MockServerConfig {
    Logger logger = LoggerFactory.getLogger(MockServerConfig.class);
    @Bean
    public MockServerClient mockServerClient(@Value("${mockserver.url:http://localhost:1080}") String urlValue) {
        logger.info("Mock server URL: {}", urlValue);
        URL url  = parseUrl(urlValue);
        SecureMockServerClient mockServer = new SecureMockServerClient(url.getHost(), url.getPort() == -1 ? url.getDefaultPort() : url.getPort());
        return mockServer;
    }

    private static URL parseUrl(String urlValue) {
        try {
           return new URL(urlValue);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}
