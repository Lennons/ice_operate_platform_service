#! /bin/bash
#chmod +x ./ok.sh
source ~/.bashrc
#获取输入的第一个参数
ARG=$1
#如果没输入参数，提示数据参数test或prod,test代表测试环境，prod代表正式环境
if [ $# != 1 ];then
    echo “input parameter:test or prod”
    exit 1;
fi
#创建logs文件夹
mkdir /home/logs
#根据参数更换正确的配置文件
\cp /home/ice_operate_platform_service/ice-provider/src/main/resources/application.$ARG.properties /home/ice_operate_platform_service/ice-provider/src/main/resources/application.properties
#maven编译
mvn clean package
#启动
java -jar /home/ice_operate_platform_service/ice-provider/target/ice-provider.jar
