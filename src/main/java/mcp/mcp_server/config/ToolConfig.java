package mcp.mcp_server.config;

import mcp.mcp_server.mysql.MysqlService;
import mcp.mcp_server.wiki.WikiService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToolConfig {

    @Bean
    public ToolCallbackProvider wikiTools(WikiService wikiService) {
        return MethodToolCallbackProvider.builder().toolObjects(wikiService).build();
    }

    @Bean
    public ToolCallbackProvider mysqlTools(MysqlService mysqlService) {
        return MethodToolCallbackProvider.builder().toolObjects(mysqlService).build();
    }
}
