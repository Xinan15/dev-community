# Spring
- `Spring` 是一个 Java 开发框架，它提供了一种全面的编程和配置模型。
- `Spring` 的目标是简化企业级应用程序的开发，提高开发人员的生产力。
- `Spring` 的本质是 `Spring Container`，是一个容器框架，用于管理 Java 项目中的对象的生命周期和配置。
- 其中，被 Spring 管理的 Java 对象称为 `Bean`。
- `Spring` 的核心是 `IoC` 和 `AOP`。
  1. `控制反转 - Spring IoC`，它负责管理 Bean 的生命周期。
  2. `面向切面编程 - Spring AOP`，它负责管理 Bean 的配置。
- 这两个特性使得 Spring 框架更加灵活、可维护、可扩展。

## Spring IoC
- `IoC` 是 `Inversion of Control` 的缩写，即控制反转。
- `IoC` 是一种设计模式，它将对象的创建和对象之间的依赖关系的管理交给了容器。
- 主要是为了将对象之间的依赖关系从程序代码中解耦，使得程序更加灵活、可维护、可扩展。
- Spring IoC 容器负责管理 Bean 的生命周期，包括 Bean 的创建、初始化、使用和销毁。
- Spring IoC 容器有两种实现方式：`BeanFactory` 和 `ApplicationContext`。

## Dependency Injection
- `DI` 是 `Dependency Injection` 的缩写，即依赖注入。
- `DI` 是 `IoC` 的一种实现方式，它是一种设计模式，用于管理对象之间的依赖关系。

## Spring AOP
- `AOP` 是 `Aspect Oriented Programming` 的缩写，即面向切面编程。
