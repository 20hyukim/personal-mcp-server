package mcp.mcp_server.config;

import mcp.mcp_server.mysql.properties.MysqlProperties;
import mcp.mcp_server.wiki.properties.WikiProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({WikiProperties.class, MysqlProperties.class})
public class PropertiesConfig {
}
