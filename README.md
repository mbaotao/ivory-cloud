# 安装

## 开发环境准备

ivory-cloud作为一个java开源项目，开发过程中需要安装git、jdk、maven等。

fork开源云平台后端项目仓库到自己的github账号，然后clone到自己本地，例如：

```sh
YOUR_GITHUB_UN="<your GitHub username>"
git clone "git@github.com:${YOUR_GITHUB_UN}/ivory-cloud.git"
```

## 部署系统

### 准备k8s环境

安装开源云平台需要依赖1个master节点、2个node节点的k8s环境，并且需要搭建NFS服务器。

开源云平台的使用需要创建多个PV：

|   功能   | 数量 |
| :------: | :--: |
| 单机订阅 |  3   |
| 集群订阅 |  5   |

请注意需要创建的PV数量。

创建命名空间：

```
kubectl create namespace ivory
```

### 准备operator

需要获取[operator源码](https://github.com/IvorySQL/ivory-operator/releases/tag/Ivyo_REL_1_1)，在本地编译成二进制文件，将编译好的二进制文件ivory_operator放入`/home/cloud/ivory`目录下，`/home/cloud/ivory`允许自定义，然后执行以下命令：

```
nohup ./ivory-operator 2>&1 &
```

### 后端部署

修改数据库连接，编辑`cloudnative/src/main/resources`目录下的application-native.yaml：

```
datasource:
    druid:
      db-type: com.alibaba.druid.pool.DruidDataSource
      driver-class-name: org.postgresql.Driver
      url: jdbc:postgresql://127.0.0.1:5432/native
      username: postgres
      password: "highgo@123"
```

请确保服务器中已经创建了一个名为`native`的`database`，当后端服务启动之后，会自动向`native`中创建表并写入数据，同时，为了避免不必要的错误，`native`尽量为一个空的`database`。

修改服务器配置，后端服务的默认端口为8081，如需修改，可以编辑`cloudnative/src/main/resources`目录下的application-native.yaml：

```
server:
  port: 8081
```

进入项目根目录，使用maven将项目打成jar包：

```
cd ivory-cloud
mvn clean package --skip test
```

打包完成后，会在`cloudnative/target`下生成`cloudnative-1.0-SNAPSHOT.jar`，将jar包放入服务器的`/home/cloud/server`目录下，`/home/cloud/server`允许自定义。使用`java -jar`启动后台服务：

```
nohup java -jar cloudnative-1.0-SNAPSHOT.jar > log_tra 2>&1 &
```

