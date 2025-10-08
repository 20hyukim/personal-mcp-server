# MCP Server

English | [한국어](./README.md)

## What is MCP (Model Context Protocol)?

MCP is an open protocol developed by Anthropic that provides a standardized communication protocol for AI assistants to securely access local services and tools. This enables AI models like Claude to interact with various external resources such as databases, file systems, and APIs.

## Project Overview

This project is a Spring Boot-based MCP Server implementation that acts as an intermediary server allowing Claude Code to interact with the Confluence Wiki API and MySQL database. It provides functionality for Claude Code to create/search Wiki pages and manipulate databases through the MCP protocol.

### Key Features
- **Wiki Features**
  - Create Confluence Wiki pages
  - Keyword-based Wiki page search
  - Wiki manipulation from Claude Code via MCP protocol
  - Confluence integration through REST API

- **MySQL Features**
  - Execute database queries
  - Browse tables and manage data
  - Execute SQL commands directly from Claude Code

### Tech Stack
- Java 21
- Spring Boot 3.5.6
- Spring AI MCP Server Starter
- MySQL Connector/J 8.0.33
- Lombok

## Available MCP Tools

### Wiki Tools
- `createPage`: Create a new Wiki page
- `searchPages`: Search Wiki pages by keyword

### MySQL Tools
- `runQuery`: Execute SQL queries on specified database

## Configuration

Add the following configuration to your `application.yml` or `application-secret.yml`:

```yaml
# Wiki configuration
wiki:
  base-url: https://your-confluence-domain.atlassian.net
  email: your-email@example.com
  api-token: your-api-token
  space-key: your-space-key

# MySQL configuration
mysql:
  url: jdbc:mysql://localhost:3306/
  username: your-username
  password: your-password
```

## Project Setup Guide

For detailed project setup and configuration instructions, please refer to the Wiki page below:
https://krafton.atlassian.net/wiki/spaces/webtechteam/pages/764909405/MCP+Claude+code+Intellij+Wiki+MCP