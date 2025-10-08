package mcp.mcp_server.wiki.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;

import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "wiki")
public class WikiProperties {
    private final String baseUrl;
    private final String email;
    private final String apiToken;
    private final String spaceKey;
}
