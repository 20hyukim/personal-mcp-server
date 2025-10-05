package mcp.mcp_server.wiki.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Component
@ConfigurationProperties(prefix = "wiki")
public class WikiProperties {
    private String baseUrl;
    private String email;
    private String apiToken;
    private String spaceKey;
}
