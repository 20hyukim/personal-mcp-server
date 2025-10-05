# MCP Server

[English](./README.en.md) | 한국어

## MCP(Model Context Protocol)란?

MCP는 Anthropic에서 개발한 오픈 프로토콜로, AI 어시스턴트가 로컬 서비스와 도구에 안전하게 접근할 수 있도록 하는 표준화된 통신 프로토콜입니다. 이를 통해 Claude와 같은 AI 모델이 데이터베이스, 파일 시스템, API 등 다양한 외부 리소스와 상호작용할 수 있습니다.

## 프로젝트 소개

이 프로젝트는 Spring Boot 기반의 MCP Server 구현체로, Claude Code가 Confluence Wiki API와 상호작용할 수 있도록 중간 서버 역할을 합니다. MCP 프로토콜을 통해 Claude Code가 Wiki 페이지를 생성하고 검색할 수 있는 기능을 제공합니다.

### 주요 기능
- Confluence Wiki 페이지 생성
- 키워드 기반 Wiki 페이지 검색
- Claude Code에서 MCP 프로토콜을 통한 Wiki 조작
- REST API를 통한 Confluence 연동

### 기술 스택
- Java 21
- Spring Boot 3.5.6
- Spring AI MCP Server Starter
- Lombok

## 프로젝트 생성 과정

프로젝트 생성 과정 및 상세 설정 방법은 아래 Wiki 페이지를 참조해주세요:
https://krafton.atlassian.net/wiki/spaces/webtechteam/pages/764909405/MCP+Claude+code+Intellij+Wiki+MCP