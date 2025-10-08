package mcp.mcp_server.mysql.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;

import org.springframework.boot.context.properties.ConfigurationProperties;


@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "mysql")
public class MysqlProperties {
    private final String url;
    private final String username;
    private final String password;
}
