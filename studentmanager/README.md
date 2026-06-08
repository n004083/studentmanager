# 学生信息管理系统

## 项目简介

这是一个基于Java Web技术开发的学生信息管理系统，采用Servlet+JSP+JavaBean的MVC架构设计，实现了学生信息的增删改查基本功能，并支持Excel文件批量导入功能。

## 功能特性

### 基础功能
- **学生列表查看**：分页展示所有学生信息
- **新增学生**：添加新的学生记录
- **修改学生**：更新已有学生信息
- **删除学生**：删除学生记录
- **查看详情**：查看单个学生的详细信息

### 增量功能
- **批量导入**：支持通过Excel文件批量导入学生信息（支持.xlsx和.xls格式）

## 技术栈

### 后端
- Java 8+
- Servlet 3.0+
- Apache POI 5.2.5（Excel处理）

### 前端
- HTML5
- CSS3
- JSP

### 数据库
- MySQL 8.0

### 服务器
- Apache Tomcat 9.0

## 项目结构

```
studentmanager/
├── src/main/
│   ├── java/
│   │   ├── control/          # 控制层（Servlet）
│   │   │   ├── ListStudentServlet.java
│   │   │   ├── InsertStudentServlet.java
│   │   │   ├── ShowStudentServlet.java
│   │   │   ├── UpStudentServlet.java
│   │   │   ├── DoStudentServlet.java
│   │   │   ├── DeleteStudentServlet.java
│   │   │   └── ImportStudentServlet.java
│   │   ├── model/           # 模型层
│   │   │   ├── SearchStudent.java
│   │   │   ├── InsertStudent.java
│   │   │   ├── SelectStudent.java
│   │   │   ├── UpdateStudent.java
│   │   │   ├── DeleteStudent.java
│   │   │   └── ImportStudent.java
│   │   ├── entity/          # 实体类
│   │   │   └── Student.java
│   │   └── dbutil/          # 数据库工具类
│   │       └── Dbconn.java
│   └── webapp/
│       ├── WEB-INF/
│       │   ├── lib/         # 依赖库
│       │   └── web.xml      # 配置文件
│       └── jsp/              # 视图层
│           ├── studentlist.jsp
│           ├── studentinsert.jsp
│           ├── studentupdate.jsp
│           ├── studentshow.jsp
│           └── studentimport.jsp
└── build/classes/            # 编译输出目录
```

## 环境配置

### 1. 数据库配置

在 `src/main/java/dbutil/Dbconn.java` 中修改数据库连接信息：

```java
private static final String URL = "jdbc:mysql://localhost:3306/students";
private static final String USER = "root";
private static final String PWD = "你的数据库密码";
```

### 2. 创建数据库

在MySQL中执行以下SQL语句：

```sql
CREATE DATABASE students CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE students;

CREATE TABLE student (
    sid INT PRIMARY KEY AUTO_INCREMENT,
    sname VARCHAR(50) NOT NULL,
    sage INT NOT NULL,
    ssex VARCHAR(10) NOT NULL,
    sclass VARCHAR(50) NOT NULL
);
```

### 3. IDE配置

本项目适用于Eclipse IDE for Java EE Developers：

1. File → Import → Existing Projects into Workspace
2. 选择项目目录
3. 配置Server（Tomcat 9.0）
4. 将项目添加到Server中运行

### 4. 依赖配置

将以下JAR文件添加到 `WEB-INF/lib/` 目录并配置到项目Build Path：

- `poi-5.2.5.jar`
- `poi-ooxml-5.2.5.jar`
- `poi-ooxml-lite-5.2.5.jar`
- `commons-collections4-4.4.jar`
- `commons-compress-1.21.jar`
- `commons-io-2.15.1.jar`
- `xmlbeans-5.1.1.jar`
- `log4j-api-2.22.1.jar`
- `log4j-core-2.22.1.jar`
- `mysql-connector-j-8.4.0.jar`

## 使用说明

### 访问地址
```
http://localhost:8080/studentmanager/
```

### 操作说明

1. **查看列表**：访问首页自动显示学生列表
2. **新增学生**：点击"新增学生"按钮，填写表单提交
3. **批量导入**：点击"批量导入"按钮，上传Excel文件
4. **修改学生**：在列表中点击"修改"按钮
5. **删除学生**：在列表中点击"查看/删除"，进入详情页删除

### Excel批量导入格式

| 姓名 | 年龄 | 性别 | 班级 |
|------|------|------|------|
| 张三 | 18 | 男 | 计算机2班 |

**注意**：
- 第一行为表头，不可省略
- 年龄必须为数字
- 文件格式支持.xlsx和.xls

## 系统架构

```
┌─────────────┐     ┌─────────────┐     ┌─────────────┐
│   View层    │ ←→  │ Controller层 │ ←→  │   Model层   │
│   (JSP)    │     │  (Servlet)  │     │ (JavaBean) │
└─────────────┘     └─────────────┘     └─────────────┘
                                                ↓
                                         ┌─────────────┐
                                         │  Dbutil层   │
                                         │ (Dbconn)   │
                                         └─────────────┘
                                                ↓
                                         ┌─────────────┐
                                         │   MySQL     │
                                         └─────────────┘
```

## 作者

[你的名字]

## 许可证

This project is for educational purposes.
