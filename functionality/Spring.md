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

## 三层架构
- 三层架构是一种软件架构模式，将 Web 应用程序的开发过程（代码）分为三个独立的层次：
1. 表现层（View）：负责接收请求，返回响应。
2. 业务层（Service）：负责处理业务逻辑。
3. 持久层（Dao）：负责与数据库交互。

## Spring MVC
- `Spring MVC` 是 `Spring` 框架中，用于实现 `表现层` 的设计模式：
- `MVC`
  1. `Model`：负责处理业务逻辑。
  2. `View`：负责显示数据。
  3. `Controller`：负责处理请求，返回响应。
- 流程：
  1. 用户访问浏览器，浏览器会向服务器发送请求。
  2. `Controller` 最先接收到浏览器发送的请求，同时会调用业务层的 `Service`
  3. `Service` 层会处理业务逻辑，返回数据给 `Controller`
  4. `Controller` 会将从 `Service` 层返回的数据，打包成一个 `Model` 对象，传递给 `View` 层
  5. `View` 将 `Model` 对象中的数据，生成 HTML 页面，返回给浏览器
- `Spring MVC` 的核心是 `DispatcherServlet`，它负责接收请求，分发请求，调用 `Controller` 处理请求，返回响应。

![img.png](images/img.png)

---
- Controller 层：处理请求，返回响应。
- Service 层：处理业务逻辑。
- Dao 层：与数据库交互。
- Controller 层调用 Service 层，Service 层调用 Dao 层。


---

## Thymeleaf
- `Thymeleaf` 是一种模板引擎。
- 接受 `模版文件` 与 `Model` 对象中的数据，生成动态的 HTML 页面。
