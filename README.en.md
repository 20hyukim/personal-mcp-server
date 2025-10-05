# MCP Server

English | [한국어](./README.md)

## What is MCP (Model Context Protocol)?

MCP is an open protocol developed by Anthropic that provides a standardized communication protocol for AI assistants to securely access local services and tools. This enables AI models like Claude to interact with various external resources such as databases, file systems, and APIs.

## Project Overview

This project is a Spring Boot-based MCP Server implementation that acts as an intermediary server allowing Claude Code to interact with the Confluence Wiki API. It provides functionality for Claude Code to create and search Wiki pages through the MCP protocol.

### Key Features
- Create Confluence Wiki pages
- Keyword-based Wiki page search
- Wiki manipulation from Claude Code via MCP protocol
- Confluence integration through REST API

### Tech Stack
- Java 21
- Spring Boot 3.5.6
- Spring AI MCP Server Starter
- Lombok

## Project Setup Guide

For detailed project setup and configuration instructions, please refer to the Wiki page below:
https://krafton.atlassian.net/wiki/spaces/webtechteam/pages/764909405/MCP+Claude+code+Intellij+Wiki+MCP