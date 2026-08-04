## What is BladeX

* BladeX is a foundational framework based on core technologies such as Spring Boot 2, Spring Cloud Greenwich, and Mybatis, designed for rapidly building medium to large-scale systems
* Has been in stable production for nearly a year, having undergone technology architecture evolution from Camden→Greenwich, and deployment architecture evolution from FatJar→Docker→K8S+Jenkins
* Adopts a front-end and back-end separation mode, with two front-end frameworks: Sword (based on React, Ant Design) and Saber (based on Vue, ElementUI)
* The backend adopts the SpringCloud series, with high-level encapsulation of its basic components, and independently develops a backend core framework: BladeX-Tool
* BladeX-Tool has been pushed to a Maven private repository, allowing direct inclusion to reduce project modules and dependencies, enabling more focus on business development
* Integrates Sentinel to protect service stability from multiple dimensions including traffic control, circuit breaking and degradation, and system load protection
* Chooses Nacos as the registry center and configuration center, slimming down the project while strengthening inter-module collaboration
* Uses Traefik for reverse proxying, automatically applying new configuration files when backend changes are detected
* Integrates the Oauth2 protocol, perfectly supporting multi-terminal access and authentication/authorization
* Integrates the workflow Flowable, making complex workflow requirements no longer difficult to handle
* Creates a multi-tenant mode, enabling simple publishing and easy data isolation
* Project package structure is clear, adhering to the development mode specifications of microservices

## Project Structure

```
BladeX
├── blade-auth -- Authorization service provider
├── blade-common -- Common utility encapsulation package
├── blade-gateway -- Spring Cloud gateway
├── blade-ops -- Operations center
├    ├── blade-admin -- Spring-Cloud backend management
├    ├── blade-develop -- Code generation
├── blade-service -- Business modules
├    ├── blade-desk -- Workbench module 
├    ├── blade-log -- Log module 
├    ├── blade-system -- System module 
├    └── blade-user -- User module 
├── blade-service-api -- Business module API encapsulation
├    ├── blade-desk-api -- Workbench API 
├    ├── blade-dict-api -- Dictionary API 
├    ├── blade-system-api -- System API 
└──    └── blade-user-api -- User API 
```
