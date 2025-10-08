# MCP Server

[English](./README.en.md) | 한국어

## MCP(Model Context Protocol)란?

MCP는 Anthropic에서 개발한 오픈 프로토콜로, AI 어시스턴트가 로컬 서비스와 도구에 안전하게 접근할 수 있도록 하는 표준화된 통신 프로토콜입니다. 이를 통해 Claude와 같은 AI 모델이 데이터베이스, 파일 시스템, API 등 다양한 외부 리소스와 상호작용할 수 있습니다.

## 프로젝트 소개

이 프로젝트는 Spring Boot 기반의 MCP Server 구현체로, Claude Code가 Confluence Wiki API 및 MySQL 데이터베이스와 상호작용할 수 있도록 중간 서버 역할을 합니다. MCP 프로토콜을 통해 Claude Code가 Wiki 페이지를 생성/검색하고 데이터베이스를 조작할 수 있는 기능을 제공합니다.

### 주요 기능
- **Wiki 기능**
  - Confluence Wiki 페이지 생성
  - 키워드 기반 Wiki 페이지 검색
  - Claude Code에서 MCP 프로토콜을 통한 Wiki 조작
  - REST API를 통한 Confluence 연동

- **MySQL 기능**
  - 데이터베이스 쿼리 실행
  - 테이블 조회 및 데이터 관리
  - Claude Code에서 직접 SQL 명령 실행

### 기술 스택
- Java 21
- Spring Boot 3.5.6
- Spring AI MCP Server Starter
- MySQL Connector/J 8.0.33
- Lombok

## 사용 가능한 MCP Tools

### Wiki Tools
- `createPage`: 새로운 Wiki 페이지 생성
- `searchPages`: 키워드로 Wiki 페이지 검색

### MySQL Tools
- `runQuery`: 지정된 데이터베이스에서 SQL 쿼리 실행

## 설정 방법

`application.yml` 또는 `application-secret.yml`에 다음 설정을 추가하세요:

```yaml
# Wiki 설정
wiki:
  base-url: https://your-confluence-domain.atlassian.net
  email: your-email@example.com
  api-token: your-api-token
  space-key: your-space-key

# MySQL 설정
mysql:
  url: jdbc:mysql://localhost:3306/
  username: your-username
  password: your-password
```

## 프로젝트 생성 과정

프로젝트 생성 과정 및 상세 설정 방법은 아래 velog 페이지를 참조해주세요:
[코딩을 뿌리는 감자 velog](https://velog.io/@20hyukim/MCP-Claude-Code%EC%97%90%EC%84%9C-Intellij%EC%99%80-Wiki-MCP-%EC%84%9C%EB%B2%84-%EC%97%B0%EB%8F%99%ED%95%98%EA%B8%B0)
