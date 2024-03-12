# Back
- Springboot 2.7.18
- Java 17
- Mysql

## Test
In *back\src\test\java\com\example\demo\initialDatabase*

Help you randomly generate the data(table) you need

Please run this test file first if you need

# Front
- Angular 17.2.0
- Redux (Manage Login Status)

# Deploy
Env: Jboss EAP-7.4.0

## Config
3 fils need to be placed in the 'EAP-7.4.0\standalone\deployments':
1. back.war
2. front.war
3. mysql-connector-j-8.2.0.jar

Launch standalone.bat in 'EAP-7.4.0\bin'
