package mcp.mcp_server.mysql;

import mcp.mcp_server.mysql.properties.MysqlProperties;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class MysqlService {

    private final MysqlProperties mysqlProperties;

    public MysqlService(MysqlProperties mysqlProperties) {
        this.mysqlProperties = mysqlProperties;
    }


    @Tool(description = "Execute a SQL query on a specific MySQL database")
    public String runQuery(
            @ToolParam(description = "Target database name") String database,
            @ToolParam(description = "SQL query to execute") String query
    ) {
        String jdbcUrl = mysqlProperties.getUrl() + "/" + database;

        try (
                Connection conn = DriverManager.getConnection(
                        jdbcUrl,
                        mysqlProperties.getUsername(),
                        mysqlProperties.getPassword()
                );
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)
        ) {
            ResultSetMetaData meta = rs.getMetaData();
            int columnCount = meta.getColumnCount();
            StringBuilder sb = new StringBuilder();

            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    sb.append(meta.getColumnLabel(i)).append(": ").append(rs.getString(i)).append("  ");
                }
                sb.append("\n");
            }

            return !sb.isEmpty()
                    ? sb.toString()
                    : "Query succeeded but returned no results.";

        } catch (SQLException e) {
            return "SQL Error: " + e.getMessage();
        }
    }
}
