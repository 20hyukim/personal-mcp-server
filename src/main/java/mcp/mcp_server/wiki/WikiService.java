package mcp.mcp_server.wiki;

import mcp.mcp_server.wiki.config.WikiProperties;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@Service
public class WikiService {

    private final RestClient restClient;
    private final WikiProperties wikiProperties;

    public WikiService(WikiProperties wikiProperties) {
        this.wikiProperties = wikiProperties;

        this.restClient = RestClient.builder()
                .baseUrl(wikiProperties.getBaseUrl())
                .defaultHeader("Authorization", buildAuthHeader(wikiProperties.getEmail(), wikiProperties.getApiToken()))
                .defaultHeader("Content-Type", "application/json")
                .build();
    }

    private String buildAuthHeader(String email, String apiToken) {
        String credentials = email + ":" + apiToken;
        return "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes(StandardCharsets.UTF_8));
    }

    @Tool(description = "Search wiki pages by keyword in title")
    public String searchPages(
            @ToolParam(description = "Search keyword") String keyword
    ) {
        String cql = "title~\"" + keyword + "\"";
        String uri = "/rest/api/content/search?cql=" + UriUtils.encode(cql, StandardCharsets.UTF_8);

        return restClient.get()
                .uri(uri)
                .retrieve()
                .body(String.class); // Claude에게 JSON 결과 그대로 전달
    }

    @Tool(description = "Create a new wiki page")
    public String createPage(
            @ToolParam(description = "Title of the page") String title,
            @ToolParam(description = "HTML content of the page") String content,
            @ToolParam(description = "Parent page ID") String parentId
    ) {
        Map<String, Object> payload = Map.of(
                "type", "page",
                "title", title,
                "ancestors", List.of(Map.of("id", parentId)),
                "space", Map.of("key", wikiProperties.getSpaceKey()),
                "body", Map.of("storage", Map.of(
                        "value", content,
                        "representation", "storage"
                ))
        );

        return restClient.post()
                .uri("/rest/api/content")
                .body(payload)
                .retrieve()
                .body(String.class);
    }

}
